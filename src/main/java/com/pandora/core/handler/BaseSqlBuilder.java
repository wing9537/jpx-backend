package com.pandora.core.handler;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseSqlBuilder<T> {
    
    private final Root<T> root;

    private final CriteriaBuilder builder;

    private final List<Predicate> stacks = new ArrayList<>();

    enum Wildcard {
        START, END, CONTAIN;
        public String wrap(String text) {
            return switch (this) {
                case START -> "%" + text;
                case END -> text + "%";
                case CONTAIN -> "%" + text + "%";
            };
        }
    };

    public void eq(String field, Object value) {
        stacks.add(builder.equal(root.get(field), value));
    }

    public void like(String field, String value) {
        like(field, value, Wildcard.CONTAIN);
    }
    
    public void like(String field, String value, Wildcard wildcard) {
        stacks.add(builder.like(root.get(field), wildcard.wrap(value)));
    }
    public Predicate build() {
        eq("deleted", "N"); // default exclude deleted records
        return builder.and(stacks.toArray(new Predicate[0]));
    }
}

package com.pandora.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.pandora.core.entity.BaseInfo;

@NoRepositoryBean
public interface BaseRepository<T extends BaseInfo> extends JpaRepository<T, Integer> {

    @Query("select e from #{#entityName} e where e.deleted = ?1")
    List<T> findByDeleted(String deleted);

    @Query("select count(e) from #{#entityName} e where e.deleted = ?1")
    long countByDeleted(String deleted);

    @Override
    @Modifying
    @Query("update #{#entityName} e set e.deleted = 'Y' where e.id = ?1")
    void deleteById(Integer id);

    @Override
    @Modifying
    @Query("update #{#entityName} e set e.deleted = 'Y'")
    void deleteAll();

    @Override
    default void delete(T entity) {
        deleteById(entity.getId());
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    default void deleteAllById(Iterable<? extends Integer> ids) {
        ids.forEach(this::deleteById);
    }

}

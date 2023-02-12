package com.pandora.jpx;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pandora.core.handler.BaseAesHandler;
import com.pandora.jpx.handler.MangaCrawler;
import com.pandora.jpx.handler.PasswordHandler;
import com.pandora.jpx.model.FileBucket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class JpxApplicationTests {

	@Autowired
	private PasswordHandler passwordHandler;

	@Autowired
	private BaseAesHandler baseAesHandler;

	@Autowired
	private MangaCrawler mangaCrawler;

	@Test
	public void testArgon2() {

		String password = "Hello World";

		Instant start = Instant.now(); // start timer

		String hash = passwordHandler.encode(password);
		log.debug(hash);

		// argon2 verify hash
		if (passwordHandler.matches("Hello World", hash)) {
			log.debug("match");
		}
		Instant end = Instant.now(); // end timer

		log.debug("Hashing took {} ms", ChronoUnit.MILLIS.between(start, end));
	}

	@Test
	public void testAesEncoder() throws Exception {
		String plainText = "Some text for encryption, lalalala";

		String encodeString = baseAesHandler.encrypt(plainText);
		log.debug("encodeString: {}", encodeString);

		String decodeString = baseAesHandler.decrypt(encodeString);
		log.debug("decodeString: {}", decodeString);
	}

	@Test
	public void testMangaCrawler() {
		List<FileBucket> files = mangaCrawler.process("manhuaren.py", "https://www.manhuaren.com/m1370692/");
		log.debug("results:\n{}", files.stream().map(f -> f.getSource()).collect(Collectors.joining("\n")));
	}

}

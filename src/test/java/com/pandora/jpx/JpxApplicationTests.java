package com.pandora.jpx;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pandora.core.handler.BaseAesHandler;
import com.pandora.jpx.handler.PasswordHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class JpxApplicationTests {

	@Autowired
	private PasswordHandler passwordHandler;

	@Autowired
	private BaseAesHandler baseAesHandler;

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

}

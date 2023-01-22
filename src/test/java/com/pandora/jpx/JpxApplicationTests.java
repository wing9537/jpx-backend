package com.pandora.jpx;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pandora.core.handler.BaseAesHandler;
import com.pandora.jpx.handler.PasswordHandler;

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
		System.out.println(hash);

		// argon2 verify hash
		if (passwordHandler.matches("Hello World", hash)) {
			System.out.println("match");
		}
		Instant end = Instant.now(); // end timer

		System.out.println(String.format("Hashing took %s ms", ChronoUnit.MILLIS.between(start, end)));
	}

	@Test
	public void testAesEncoder() throws Exception {
		String plainText = "Some text for encryption, lalalala";

		String encodeString = baseAesHandler.encrypt(plainText);
		System.out.println("encodeString: " + encodeString);

		String decodeString = baseAesHandler.decrypt(encodeString);
		System.out.println("decodeString: " + decodeString);

	}

}

package com.lawencon.elearning.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.lawencon.elearning.service.RandomTextService;

@Service
public class RandomTextServiceImpl implements RandomTextService {

	@Override
	public String getText() {
        final int leftLimit = 48; 
        final int rightLimit = 122; 
        final int targetStringLength = 5;
        final Random random = new Random();

        final String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generatedString.toUpperCase();
	}
}

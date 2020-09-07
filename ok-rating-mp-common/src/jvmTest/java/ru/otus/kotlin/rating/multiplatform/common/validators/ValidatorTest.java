package ru.otus.kotlin.rating.multiplatform.common.validators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void validatorTest() {
        ValidationResult result = new SomeValidator("rating").validate("5");
        assertTrue(result.isOk());
        assertEquals(0, result.getErrors().size());
    }
}
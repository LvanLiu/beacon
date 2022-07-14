package com.lvan.java.jsr.validation;

import com.lvan.java.jsr.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Qibin Liu
 * @since 2022-07-13 10:00
 */
@Slf4j
@SpringBootTest
class JsrValidationTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void updateParamsVerify_whenIdIsNull_thenValidatesIsLargeThenZero() {

        User user = new User();
        user.setAge(18);
        user.setName("demo");

        Set<ConstraintViolation<User>> validates = validator.validate(user);
        validates.forEach(validation -> {
            log.info("msg:{}", validation.getMessage());
        });

        assertTrue(validates.size() > 0);
    }
}
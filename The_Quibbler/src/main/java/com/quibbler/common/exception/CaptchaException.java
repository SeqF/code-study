package com.quibbler.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author paksu
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String explanation) {
        super(explanation);
    }
}

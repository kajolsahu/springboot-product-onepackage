package com.main.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NoDataFoundException extends RuntimeException {
	
	public NoDataFoundException() {

        super("No data found");
    }
	
}

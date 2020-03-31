package com.bhoga.cms.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bhoga.cms.exception.ApplicationError;
import com.bhoga.cms.exception.CustomerNotFoundException;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@Value("${api_doc_url}")
	private String details;

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest webRequest) {
		
		ApplicationError error = new ApplicationError();
		error.setCode(101);
		error.setMessage(ex.getMessage());
		error.setDetails(details);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}

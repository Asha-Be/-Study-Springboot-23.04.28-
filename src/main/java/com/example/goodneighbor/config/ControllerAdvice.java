package com.example.goodneighbor.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.goodneighbor.exception.NeighborException;
import com.example.goodneighbor.repository.ErrorResponse;

@RestControllerAdvice
public class ControllerAdvice {
	
	
	@ExceptionHandler(NeighborException.class)
	public ErrorResponse handleNeighborException(NeighborException exception) {
		
		var response = new ErrorResponse();
		response.setErrorCode(exception.getErrorCode());
		response.setErrorMessage(exception.getErrorMessage());
		
		return response;
	}

}

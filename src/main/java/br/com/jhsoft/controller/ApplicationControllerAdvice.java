package br.com.jhsoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.jhsoft.ApiErrors;
import br.com.jhsoft.exception.RegraNegocioException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
		String mensageErro = ex.getMessage();
		return new ApiErrors(mensageErro);
	}
}

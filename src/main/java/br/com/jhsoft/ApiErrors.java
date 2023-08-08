package br.com.jhsoft;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
	
	private List<String> errors;
	
	public ApiErrors(String mensagemErro) {
		this.errors = Arrays.asList(mensagemErro);
	}

	public List<String> getErros() {
		return errors;
	}
}

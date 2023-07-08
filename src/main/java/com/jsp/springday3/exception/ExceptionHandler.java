package com.jsp.springday3.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.springday3.util.ResponseStructure;
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> getException(IdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for user");
		structure.setData(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> getException(NameNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("name not found for user");
		structure.setData(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> listOfErrors = ex.getAllErrors();
		Map<String, String> map=new HashMap<String,String>();
		for (ObjectError objectError : listOfErrors) {
			String message= objectError.getDefaultMessage();
			String fieldname=((FieldError)objectError).getField();
			map.put(message, fieldname);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	

}

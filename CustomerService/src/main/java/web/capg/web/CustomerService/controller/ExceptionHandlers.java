package web.capg.web.CustomerService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import web.capg.web.CustomerService.Exception.*;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ExceptionHandlers {
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception){
	  return new ResponseEntity<Object>("Customer not found...",HttpStatus.NOT_FOUND);
	}
    
	
	@ExceptionHandler(value=DepartmentNotFoundException.class)
	public ResponseEntity<Object> exception(DepartmentNotFoundException exception){
	  return new ResponseEntity<Object>("Department not found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidCredentialException.class)
	public ResponseEntity<Object> exception(InvalidCredentialException exception){
	  return new ResponseEntity<Object>("Invalid Credentials...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IssueNotFoundException.class)
	public ResponseEntity<Object> exception(IssueNotFoundException exception){
	  return new ResponseEntity<Object>("No issue found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=OperatorNotFoundException.class)
	public ResponseEntity<Object> exception(OperatorNotFoundException exception){
	  return new ResponseEntity<Object>("Operator not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=SolutionNotFoundException.class)
	public ResponseEntity<Object> exception(SolutionNotFoundException exception){
	  return new ResponseEntity<Object>("Solution not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=CustomerAlreadyExistingException.class)
	public ResponseEntity<Object> exception(CustomerAlreadyExistingException exception){
	  return new ResponseEntity<Object>("Customer already exists!...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=OperatorAlreadyExistingException.class)
	public ResponseEntity<Object> exception(OperatorAlreadyExistingException exception){
	  return new ResponseEntity<Object>("Operator already exists!...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=ListEmptyException.class)
	public ResponseEntity<Object> exception(ListEmptyException exception){
	  return new ResponseEntity<Object>("List is Empty!...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=DepartmentAlreadyExistException.class)
	public ResponseEntity<Object> exception(DepartmentAlreadyExistException exception){
		  return new ResponseEntity<Object>("Department already exists!...",HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(value=SolutionAlreadyExistsException.class)
	public ResponseEntity<Object> exception(SolutionAlreadyExistsException exception){
		  return new ResponseEntity<Object>("Solution already exists for this issue!...",HttpStatus.NOT_FOUND);
		}
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,HttpHeaders headers,HttpStatus status,WebRequest request)
	{	Map<String,String> errors=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName,message);
		});
		//return super.handleMethodArgumentNotValid(e,headers,status, request);
	return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	
}
}

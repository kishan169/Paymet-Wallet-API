package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandlers {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> UserExceptionhandler(UserException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> LogInExceptionhandler(LoginException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BankException.class)
	public ResponseEntity<ErrorDetails> BankExceptionhandler(BankException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<ErrorDetails> BeneficiaryExceptionhandler(BeneficiaryException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorDetails> TransactionExceptionhandler(TransactionException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> extraExceptionhandler(MethodArgumentNotValidException ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), "ValidationError", ee.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionhandler(Exception ee, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}

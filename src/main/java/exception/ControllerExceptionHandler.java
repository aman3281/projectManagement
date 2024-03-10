package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	

	
	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<Object> handleIllegalArgumentExcepyion(IllegalArgumentException ex){
		ErrorResponse errorresponse = new ErrorResponse().status(HttpStatus.BAD_REQUEST)
		.message(ex.getLocalizedMessage());
		return new ResponseEntity<>(errorresponse,errorresponse.getStatus());
		
	}
 

	
	
	

}

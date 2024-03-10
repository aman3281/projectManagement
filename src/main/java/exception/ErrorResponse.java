package exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Validated
public class ErrorResponse {
	
	
	@JsonProperty("status")
	private HttpStatus status;
	
	
	@JsonProperty
	private String message;


	public HttpStatus getStatus() {
		return status;
	}

	

	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ErrorResponse status(HttpStatus statsu) {
		this.status=status;
		return this;
	}
	
	public ErrorResponse message(String message) {
		this.message=message;
		return this;
	}


	

}

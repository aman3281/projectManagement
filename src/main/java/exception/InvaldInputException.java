package exception;

import java.io.IOException;

public class InvaldInputException extends IOException{
	
	public InvaldInputException() {
		super();
	}

	public InvaldInputException(InvaldInputException ex,String msg) {
		super(msg);
	}
}

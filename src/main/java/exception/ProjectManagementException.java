package exception;

public class ProjectManagementException extends RuntimeException{
	
	public ProjectManagementException() {
		super();
	}
	
	public ProjectManagementException(IllegalArgumentException ex,String msg){
		super(msg);
	}
	
	public ProjectManagementException(InvaldInputException ex,String msg){
		super(msg);
	}
	
	public ProjectManagementException(String msg){
		super(msg);
	}

}

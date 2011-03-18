package jhgdc.common;

public class JHGDException extends Exception {

	public JHGDException(){
		super();
	}
	
	public JHGDException(String message) {
		super(message);
	}
	
	public JHGDException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public JHGDException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2779009794457307771L;

}

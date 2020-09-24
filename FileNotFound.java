package project;
import java.lang.Exception;
public class FileNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileNotFound(String errormessage) {
		super(errormessage);
	}
}

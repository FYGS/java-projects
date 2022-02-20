/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class NameTooLongException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameTooLongException(String msg) {
		super(msg);
	}
	
	public NameTooLongException() {
		this("Name too long !");
	}
}

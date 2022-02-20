/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class WrongDurationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongDurationException(String msg) {
		super(msg);
	}
	
	public WrongDurationException() {
		this("Wrong duration !");
	}
}

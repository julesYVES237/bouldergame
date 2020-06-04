package game.contract.src.main.java.contract;

import java.util.Observable;

import game.entity.src.main.java.entity.HelloWorld;

/**
 * The Interface IModel.
/**
 * @author mael
 *
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	HelloWorld getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}

package game.contract.src.main.java.view;

import java.awt.event.KeyEvent;

/**
 * @author mael
 * interface for the eventperformer
 */
public interface IEventPerformer {

    /**
     * @param keyEvent the key we used
     */
    void eventPerform(KeyEvent keyEvent);
}

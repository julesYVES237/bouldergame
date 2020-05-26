package game.model.element.cell;

import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.element.entity.actor.Rockford;
import game.model.map.MapInstance;

/**
 * Clase de la celda salida
 */
public class Exit extends Cell
{

	private boolean isOpen;
	private static Exit exit;

	/**
	 * Constructor de la salida.
	 * 
	 * @param pos
	 */
	private Exit()
	{
		super(new Position(0, 0));
		this.setElementType(ElementTypes.ExitClosed);
		this.isOpen = false;
	}

	/**
	 * Singleton salida.
	 * 
	 * @return
	 */
	public static Exit getInstance()
	{
		if (exit == null)
		{
			exit = new Exit();
		}
		return exit;
	}

	/**
	 * Resetea la salida con sus valores por defecto.
	 */
	public void close()
	{
		this.setElementType(ElementTypes.ExitClosed);
		this.isOpen = false;
	}

	/**
	 * Abre la salida.
	 */
	public void open()
	{
		Rockford player = Rockford.getInstance();
		if (player.getDiamonds() >= MapInstance.getInstance().getDiamondsneeded())
		{
			this.setElementType(ElementTypes.ExitOpen);
			this.isOpen = true;
		}
	}

	/**
	 * 
	 * @return si la salida esta abierta para el jugador
	 */
	public boolean isOpen()
	{
		return isOpen;
	}

}

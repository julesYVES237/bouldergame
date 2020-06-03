package game.model.map;

import game.model.element.Element;
import game.model.element.Position;

/**
 * Map parent class.
 */
public abstract class Map
{

	/**
	 * Initialize the map. 
	 */
	abstract public void start();

	/**
	 * Fill the map, initialize the matrix with earth, empty or null.
	 */
	abstract public void fill();

	/**
	 * 
	 * @return Map height
	 */
	public static int mapHeight()
	{
		return MapInstance.getInstance().getLevelReader().getHEIGHT();
	}

	/**
	 * 
	 * @return Map length
	 */
	public static int mapWidth()
	{
		return MapInstance.getInstance().getLevelReader().getWIDTH();
	}
	
	/**
	 * 
	 * @param pos
	 * @return if the position is on the map
	 */
	public static boolean isInMap(Position pos)
	{
		return mapWidth() >= pos.getX() && 0 <= pos.getX()
				&& mapHeight() >= pos.getY() && 0 <= pos.getY();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return if the coordinates is on the map
	 */
	public static boolean isInMap(Integer x, Integer y)
	{
		return mapWidth() >= x && 0 <= x && mapHeight() >= y && 0 <= y;
	}
	
	/**
	 * 
	 * @param element
	 * @return if the item's pos is on the map
	 */
	public static boolean elementPosIsInMap(Element element)
	{
		return mapWidth() >= element.getPosition().getX() && 0 <= element.getPosition().getX() && mapHeight() >= element.getPosition().getY() && 0 <= element.getPosition().getY();
	}
}

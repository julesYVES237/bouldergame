package game.model.map;

import game.model.element.Element;
import game.model.element.Position;
import game.model.element.cell.Cell;
import game.model.element.cell.Dirt;
import game.model.element.cell.Exit;
import game.model.element.cell.Wall;
import game.model.element.entity.actor.Actor;
import game.model.element.entity.actor.Rockford;
import game.model.element.entity.item.Diamond;
import game.model.element.entity.item.Empty;
import game.model.element.entity.item.Item;
import game.model.element.entity.item.Rock;

/**
 * Element matrix.
 */
/**
 * @author mael
 *
 */
public class MapElement extends Map
{
	private static MapElement mapelement;
	private static Element[][] matrix;

	/**
	 * MapElement constructor.
	 */
	private MapElement()
	{
		matrix = null;
	}

	/**
	 * Singleton  MapElement.
	 * 
	 * @return MapElement
	 */
	public static MapElement getInstance()
	{
		if (mapelement == null)
		{
			mapelement = new MapElement();
		}
		return mapelement;
	}

	/**
	 * Returns an element of the array.
	 * 
	 * @param pos
	 * @return item
	 */
	public static Element getElement(Position pos)
	{
		return matrix[pos.getX()][pos.getY()];
	}

	/**
	 * Returns an Element of the matrix, uses X, Y coordinates.
     *
	 * @param x
	 * @param y
	 * @return item
	 */
	public static Element getElement(Integer x, Integer y)
	{
		return matrix[x][y];
	}
	
	/**
	 * Sets an Element in the array.
	 * 
	 * @param element
	 * @return if it was set correctly
	 */
	public static boolean setElement(Element element)
	{
		if (elementPosIsInMap(element))
		{
			matrix[element.getPosition().getX()][element.getPosition().getY()] = element;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Sets a cell in the matrix.
	 * 
	 * @param cell
	 * @return if it was set correctly
	 */
	public static boolean setCell(Cell cell)
	{
		if (elementPosIsInMap(cell))
		{
			matrix[cell.getPosition().getX()][cell.getPosition().getY()] = cell;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Set an item in the array.
	 * 
	 * @param item
	 * @return if it was set correctly
	 */
	public static boolean setItem(Item item)
	{
		if (elementPosIsInMap(item))
		{
			matrix[item.getPosition().getX()][item.getPosition().getY()] = item;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Sets a cell in the matrix.
	 * 
	 * @param actor
	 * @return if it was set correctly
	 */
	public static boolean setActor(Actor actor)
	{
		if (elementPosIsInMap(actor))
		{
			matrix[actor.getPosition().getX()][actor.getPosition().getY()] = actor;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Remove an Element from the array.
	 * 
	 * @param pos
	 * @return if the item was deleted
	 */
	public static boolean removeElement(Position pos)
	{
		if (isInMap(pos))
		{
			matrix[pos.getX()][pos.getY()] = new Empty(pos);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns an item if it can't returns null, uses X, Y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return an item if it can't returns null
	 */
	public static Item getItem(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y].isItem())
			{
				return ((Item) matrix[x][y]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns a diamond if it can't returns null.
	 * 
	 * @param pos
	 * @return diamond
	 */
	public static Diamond getDiamond(Position pos)
	{
		if (isInMap(pos))
		{
			if (matrix[pos.getX()][pos.getY()].isDiamond())
			{
				return ((Diamond) matrix[pos.getX()][pos.getY()]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns a diamond if it can't returns null, uses X, Y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return a diamond if it can't returns null
	 */
	public static Diamond getDiamond(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y].isDiamond())
			{
				return ((Diamond) matrix[x][y]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns a rock if unable to return null, uses X, Y coordinates.
     *
	 * @param x
	 * @param y
	 * @return a rock if it can't returns null
	 */
	public static Rock getRock(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y].isRock())
			{
				return ((Rock) matrix[x][y]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * 
	 * @param pos
	 * @return earth if you can but returns null
	 */
	public static Dirt getDirt(Position pos)
	{
		if (isInMap(pos))
		{
			if (matrix[pos.getX()][pos.getY()].isDirt())
			{
				return ((Dirt) matrix[pos.getX()][pos.getY()]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns earth if it can but returns null.
	 * 
	 * @param x
	 * @param y
	 * @return earth if you can but returns null
	 */
	public static Dirt getDirt(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y].isDirt())
			{
				return ((Dirt) matrix[x][y]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns a wall if it can, otherwise it returns null.
	 * 
	 * @param x
	 * @param y
	 * @return a wall if you can but null
	 */
	public static Wall getWall(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y].isWall())
			{
				return ((Wall) matrix[x][y]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Rockford returns if he can, but returns null.
	 * 
	 * @param x
	 * @param y
	 * @return to Rockford
	 */
	public static Rockford getRockford(Integer x, Integer y)
	{
		if (isInMap(x, y))
		{
			if (matrix[x][y] != null)
			{
				if (matrix[x][y].isRockford())
				{
					return ((Rockford) matrix[x][y]);
				}
				else
				{
					return null;
				}
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns the output if it is, otherwise it returns null.
     *
     * @return the output if it is, but null
	 */
	public static Exit findExit()
	{
		Exit exit;
		for (int x = 0; x < mapWidth(); x++)
			for (int y = 0; y < mapHeight(); y++)
			{
				if (matrix[x][y].isExit())
				{
					exit = (Exit) matrix[x][y];
					return exit;
				}
			}
		return null;
	}

	@Override
	public void start()
	{
		matrix = new Element[mapWidth()][mapHeight()];
		fill();
	}

	@Override
	public void fill()
	{
		Position pos = new Position(0, 0);
		for (int x = 0; x < mapWidth(); x++)
			for (int y = 0; y < mapHeight(); y++)
			{
				pos.setXY(x, y);
				matrix[x][y] = new Element(pos);
			}
	}

}

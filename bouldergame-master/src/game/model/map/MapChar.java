package game.model.map;

import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.element.entity.actor.Rockford;

/**
 * This class is in charge of grabbing the elements and making a matrix of
 * characters with these.
 */
public class MapChar extends Map
{
	private static MapChar mapvisual;
	private static ElementTypes[][] map;

	/**
	 * MapVisual constructor.
	 */
	private MapChar()
	{
		map = null;
	}

	/**
	 * Singleton MapVisual.
	 * 
	 * @return
	 */
	public static MapChar getInstance()
	{
		if (mapvisual == null)
		{
			mapvisual = new MapChar();
		}
		return mapvisual;
	}

	/**
	 * Build the element map with its characters, the actors have more
     * priority than objects that have higher priority than cells.
	 */
	public static void drawMap()
	{
		for (int y = 0; y < mapHeight(); y++)
		{
			for (int x = 0; x < mapWidth(); x++)
			{
				putElementChar(y, x);
			}
		}
	}

	/**
	 * Print the map and some information. It is used for the console and
     * debugging.
	 */
	public static void imprimirMapa()
	{
		System.out.println("..............................................................");
		imprimiendoMapa();
		showInfo();
		System.out.println("..............................................................");

	}

	/**
	 * Returns a character from the matrix, using X, Y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static ElementTypes getChar(int x, int y)
	{
		return map[x][y];
	}

	@Override
	public void start()
	{
		MapChar.getInstance();
		map = new ElementTypes[mapWidth()][mapHeight()];
		fill();
	}

	@Override
	public void fill()
	{
		for (int x = 0; x < mapWidth(); x++)
			for (int y = 0; y < mapHeight(); y++)
			{
				map[x][y] = ElementTypes.Dirt;
			}
	}
	
	
	
	
	//////////////////
	
	
	
	
	/**
	 * Puts the character on the map.
	 * @param y
	 * @param x
	 */
	private static void putElementChar(int y, int x)
	{
		Position pos = new Position(x, y);
		if (MapElement.getElement(pos).isActor())
		{
			map[x][y] = MapElement.getElement(pos).getElementType();
		}
		else if (!MapElement.getElement(pos).isEmpty())
		{
			map[x][y] = MapElement.getElement(pos).getElementType();
		}
		else
		{
			map[x][y] = MapElement.getElement(pos).getElementType();
		}
	}
	
	/**
	 * Show shift information.
	 */
	private static void showInfo()
	{
		Rockford player = Rockford.getInstance();
		if (player != null)
		{
			showTurnInfo(player);
		}
		else
		{
			showEndInfo();
		}
	}

	/**
	 * Show the information of the last shift.
	 */
	private static void showEndInfo()
	{
		System.out.println("Rockford muerto");
	}

	/**
	 * Show shift information.
	 * @param player
	 */
	private static void showTurnInfo(Rockford player)
	{
		System.out.println("Rockford Pos: " + player.getPosition().getX() + "," + player.getPosition().getY());
		System.out.println("Rockford Diamonds: " + player.getDiamonds());
	}

	/**
	 * Print the map.
	 */
	private static void imprimiendoMapa()
	{
		for (int y = 0; y < mapHeight(); y++)
		{
			for (int x = 0; x < mapWidth(); x++)
			{
				System.out.print(map[x][y].getLetter());
				System.out.print(" ");
			}
			System.out.println();
		}
	}


}

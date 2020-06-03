package game.model.map;

import game.exception.LevelNotValidException;
import game.exception.RockfordNotInLevelException;
import game.model.element.Position;
import game.model.element.cell.*;
import game.model.element.entity.Entity;
import game.model.element.entity.ListOfEntities;
import game.model.element.entity.actor.*;
import game.model.element.entity.item.*;
import game.model.map.bdlevel.BDLevelReader;

/**
 * This class manages the element map and takes care of refreshing the
 * list of entities, to build and store level information. Contains
 * to a map of cells, items, and actors, along with a list of all the
 * living entities.
 */
/**
 * @author mael
 *
 */
public class MapInstance
{
	private static MapInstance mapinstance;
	private ListOfEntities listentity;
	private BDLevelReader levelReader;
	private Integer playerscore;
	private Integer selectedLevel;
	private Integer diamondsneeded;
	private Integer diamondvalue;
	private Integer diamondbonus;
	private Double timer;

	private static int[][] levelinfo = new int[][]
	{
			{ 1, 12, 10, 15, 110 },
			{ 2, 10, 20, 50, 110 },
			{ 3, 23, 15, 0, 100 },
			{ 4, 36, 5, 20, 100 },
			{ 5, 6, 30, 0, 100 },
			{ 6, 5, 50, 90, 120 },
			{ 7, 5, 50, 100, 100 },
			{ 8, 5, 50, 90, 120 },
			{ 9, 5, 50, 90, 120 }, };

	/**
	 * MapInstance constructor.
	 */
	private MapInstance()
	{
		listentity = null;
		levelReader = null;
		selectedLevel = null;
		timer = null;
		diamondvalue = null;
		diamondbonus = null;
		playerscore = 0;

	}

	/**
	 * MapInstance Singleton .
	 * 
	 * @return mapinstance
	 */
	public static MapInstance getInstance()
	{
		//If the instance was not created, it is created, and the instance is returned
		if (mapinstance == null)
		{
			mapinstance = new MapInstance();
		}
		return mapinstance;
	}

	
	
	//////////
	
	
	
	
	
	/**
	 *Initialize mapinstance, initialize all three element maps, load the
     *levelreader and initialize the entity list.
	 * 
	 * @param levelReader
	 */
	public static void start()
	{
		putLevelReader();
		initializeMapInstance();
	}

	/**
	 * Take care of reading the levelreader using the chosen level and take out
     * information on this.
	 */
	private void readLevel()
	{
		readingLevel();
		readLevelInfo();
	}
	
	/**
	 * Build and set the next level.
	 */
	public void levelNext()
	{
		setSelectedLevel(selectedLevel + 1);
		rebuildingSelectedLevel();
	}
	
	/**
	 * Restart the level.
	 */
	public void levelRestart()
	{
		rebuildingSelectedLevel();
	}
	
	/**
	 * Build and set the previous level.
	 */
	public void levelPrevious()
	{
		setSelectedLevel(selectedLevel - 1);
		rebuildingSelectedLevel();
	}
	
	/**
	 * Reset the mapinstance and build level number x.
     *
	 * @param selectedLevel
	 */
	public void buildSelectedLevel(Integer selectedLevel) throws LevelNotValidException
	{
		if (levelNotValid(selectedLevel))
		{
			throw new LevelNotValidException("Invalid level");
		}
		else
		{
			initializeMapInstance();
			mapinstance.selectedLevel = selectedLevel;
			readLevel();
			buildingMap();
			MapChar.drawMap();
		}
	}

	/**
	 * Decrease the timer on the map.v
	 * 
	 * @param timer
	 */
	private void decrementTimer()
	{
		if (timer > 0)
		{
			timer -= 0.1;
		}
	}

	/**
	 * Kills an element, removes it from its corresponding matrix.
     *
	 * @param pos
	 */
	public void kill(Position pos)
	{
		MapElement.getElement(pos.getX(), pos.getY()).die();
	}

	/**
	 * Kill an element, remove it from its corresponding matrix, use
     * X, Y coordinates.
	 * 
	 * @param x
	 * @param y
	 */
	public void kill(Integer x, Integer y)
	{
		if (elementCanDie(x, y))
		{
			MapElement.getElement(x, y).die();
		}
	}

	/**
	 * Determine if the level is empty. (If there is no Rockford).
     *
	 * @return boolean
	 */
	public boolean levelHasRockford()
	{
		if (ListOfEntities.getList().contains(Rockford.getInstance()))
			return true;
		else
			return false;
	}

	/**
	 * Refresh the map, decrease the timer, draw the map and change the
     * position of the entities.
	 */
	public void refresh()
	{
		decrementTimer();
		MapChar.drawMap();
		entitiesMove();
	}
	
	/**
	 * Generate the map using the tiles of the levelreader, creating the
     * elements and putting them in the matrices.
	 */
	private void buildMap() throws RockfordNotInLevelException
	{
		ListOfEntities.getList().clear();
		for (int y = 0; y < levelReader.getHEIGHT(); y++)
		{
			for (int x = 0; x < levelReader.getWIDTH(); x++)
			{
				putLevelTile(y, x);
			}
		}
		checkRockfordNotInLevel();
	}


	
	
	////////// GETTERS/SETTERS
	
	
	
	
	
	
	/**
	 * Returns the levelreader. Useful to access your size.
     *
	 * @return levelreader
	 */
	public BDLevelReader getLevelReader()
	{
		return levelReader;
	}
	
	/**
	 * Returns the list of entities.
     *
	 * @return listentity
	 */
	public ListOfEntities getEntitiesActive()
	{
		return listentity;
	}

	/**
	 * Returns the number of the current level.
	 * 
	 * @return selectedlevel
	 */
	public Integer getSelectedLevel()
	{
		return selectedLevel;
	}

	/**
	 * Sets the number of the current level.
	 * 
	 * @param selectedlevels
	 */
	public void setSelectedLevel(Integer selectedlevels)
	{
		selectedLevel = selectedlevels;
	}
	
	/**
	 * Returns the level timer.
	 * 
	 * @return timer
	 */
	public Double getTimer()
	{
		return timer;
	}

	/**
	 * Returns the value of diamonds from the current level.
     * 
	 * @return diamondvalue
	 */
	public Integer getDiamondvalue()
	{
		return diamondvalue;
	}

	/**
	 * Returns the bonus value of diamonds of the current level.
     *
	 * @return diamondbonus
	 */
	public Integer getDiamondbonus()
	{
		return diamondbonus;
	}

	/**
	 * Returns the player's total score.
	 * 
	 * @return playerscore
	 */
	public Integer getPlayerscore()
	{
		return playerscore;
	}

	/**
	 * Sets the player's total score.
	 * 
	 * @param playerscore
	 */
	public void setPlayerscore(Integer playerscore)
	{
		mapinstance.playerscore = playerscore;
	}

	/**
	 * Return the required amount of diamonds to open the door.
     *
	 * @return diamondsneeded
	 */
	public Integer getDiamondsneeded()
	{
		return diamondsneeded;
	}
	
	
	
	
	
	//////////////////////////////////// PRIVATE METHODS
	
	
	
	
	
	/**
	 * Lee el level reader.
	 */
	private void readingLevel()
	{
		try
		{
			levelReader.readLevels("levels.xml");
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		try
		{
			levelReader.setCurrentLevel(selectedLevel);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Read the level information.
	 */
	private void readLevelInfo()
	{
		diamondsneeded = levelinfo[selectedLevel - 1][1];
		diamondvalue = levelinfo[selectedLevel - 1][2];
		diamondbonus = levelinfo[selectedLevel - 1][3];
		timer = (double) levelinfo[selectedLevel - 1][4];
	}
	
	/**
	 * Redo the level.
	 */
	private void rebuildingSelectedLevel()
	{
		try
		{
			buildSelectedLevel(selectedLevel);
		}
		catch (LevelNotValidException e1)
		{
			try
			{
				buildSelectedLevel(1);
			}
			catch (LevelNotValidException e2)
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			e1.printStackTrace();
		}
	}
	
	/**
	 * Building the map.
	 */
	private void buildingMap()
	{
		try
		{
			buildMap();
		}
		catch (RockfordNotInLevelException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Reinitialize MapInstance.
	 */
	private static void initializeMapInstance()
	{
		MapInstance.getInstance();
		mapinstance.listentity = ListOfEntities.getInstance();
		MapElement.getInstance().start();
		MapChar.getInstance().start();
		ListOfEntities.start();
	}
	
	/**
	 * Puts the level reader
	 */
	private static void putLevelReader()
	{
		BDLevelReader bdlevel = new BDLevelReader();
		mapinstance.levelReader = bdlevel;
	}
	
	/**
	 * 
	 * @param selectedLevel
	 * @return if the level is valid
	 */
	private boolean levelNotValid(Integer selectedLevel)
	{
		return selectedLevel <= 0 || selectedLevel >= 10;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return if the element can die
	 */
	private boolean elementCanDie(Integer x, Integer y)
	{
		return MapElement.getElement(x, y) != null && !MapElement.getElement(x, y).isTitanium();
	}
	
	/**
	 * Change the position of the entities.
	 */
	private void entitiesMove()
	{
		for (int i = 0; i < ListOfEntities.getList().size(); ++i)
		{
			Entity ent = ListOfEntities.getList().get(i);
			ent.changePosition();
		}
	}
	
	/**
	 * Check if rockford is on the level.
	 * @throws RockfordNotInLevelException
	 */
	private void checkRockfordNotInLevel() throws RockfordNotInLevelException
	{
		if (!ListOfEntities.getList().contains(Rockford.getInstance()))
		{
			throw new RockfordNotInLevelException("Rockford no esta en el mapa");
		}
	}

	/**
	 * Convert the tiles of the levelreader to elements and put them in the
	 * element map.
	 * @param y
	 * @param x
	 */
	private void putLevelTile(int y, int x)
	{
		Position pos = new Position(x, y);
		switch (levelReader.getTile(x, y))
		{
			case EMPTY:
				MapElement.setCell(new Dirt(pos, false));
				break;
			case DIRT:
				MapElement.setCell(new Dirt(pos));
				break;
			case TITANIUM:
				MapElement.setCell( new Titanium(pos));
				break;
			case WALL:
				MapElement.setCell(new Wall(pos));
				break;
			// case MAGIC:
			// MapElement.setElement(new Wall(pos,5));
			// break;
			case ROCK:
				Rock rock = new Rock(pos);
				MapElement.setItem(rock);
				ListOfEntities.getList().add(rock);
				break;
			case FALLINGROCK:
				Rock fallingRock = new Rock(pos, StatusFallableEnum.FALLING);
				MapElement.setItem(fallingRock);
				ListOfEntities.getList().add(fallingRock);
				break;
			case DIAMOND:
				Diamond diamond = new Diamond(pos);
				MapElement.setItem(diamond);
				ListOfEntities.getList().add(diamond);
				break;
			case FALLINGDIAMOND:
				Diamond fallingDiamond = new Diamond(pos, StatusFallableEnum.FALLING);
				MapElement.setItem(fallingDiamond);
				ListOfEntities.getList().add(fallingDiamond);
				break;
			case AMOEBA:
				Amoeba amoeba = new Amoeba(pos);
				MapElement.setItem(amoeba);
				ListOfEntities.getList().add(amoeba);
				break;
			case FIREFLY:
				Firefly firefly = new Firefly(pos);
				MapElement.setActor(firefly);
				ListOfEntities.getList().add(firefly);
				break;
			case BUTTERFLY:
				Butterfly butterfly = new Butterfly(pos);
				MapElement.setActor(butterfly);
				ListOfEntities.getList().add(butterfly);
				break;
			case EXIT:
				Exit door = Exit.getInstance();
				door.close();
				door.setPosition(pos);
				MapElement.setCell(door);
				break;
			case PLAYER:
				Rockford player = Rockford.getInstance();
				player.setPosition(pos);
				MapElement.setActor(player);
				ListOfEntities.getList().add(player);
				break;
			default:
				break;
		}
	}
	
	
	
	
	////////
	
	
	
	
//	/**
//	 * Returns if the coordinates are valid.
//	 * 
//	 * @param x
//	 * @param y
//	 * @return boolean
//	 */
//	public boolean isInMapLimits(Integer x, Integer y)
//	{
//		return getLevelReader().getWIDTH() > x && getLevelReader().getHEIGHT() > y && 0 <= x && 0 <= y;
//	}
}

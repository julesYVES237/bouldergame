package game.model.element.entity;

import java.util.HashMap;

import game.model.element.Element;
import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.map.MapChar;
import game.model.map.MapElement;

/**
 * Elementos dinamicos que se pueden mover. Como Actor y Item. Tiene un hashmap
 * que contiene los elementos que la entidad puede pasar.
 */
public abstract class Entity extends Element
{
	private HashMap<Integer, ElementTypes> passable = new HashMap<>();

	/**
	 * Genera una entidad en una posicion.
	 * 
	 * @param pos
	 */
	public Entity(Position pos)
	{
		super(pos);
	}

	/**
	 * Devuelve los elementos que la entidad puede traspasar.
	 * 
	 * @return El hashmap de los elementos passables
	 */
	public HashMap<Integer, ElementTypes> getPassable()
	{
		return passable;
	}

	/**
	 * Setea los elementos que la entidad puede traspasar.
	 * 
	 * @param passable
	 */
	public void setPassable(HashMap<Integer, ElementTypes> passable)
	{
		this.passable = passable;
	}

	/**
	 * Cambia la posicion de la entidad antes de hacer makemove.
	 */
	abstract public void changePosition();

	/**
	 * Hace la movida de una entidad.
	 */
	abstract public void makeMove();

	/**
	 * Determina si esta entidad es un actor.
	 * 
	 * @return si esta entidad es un actor
	 */
	public boolean isActor()
	{
		if (this.getElementType().getKind().equals("Actor"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determina si esta entidad es Rockford.
	 * 
	 * @return si esta entidad es Rockford
	 */
	public boolean isRockford()
	{
		if (this.getElementType() == ElementTypes.Rockford)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determina si esta entidad es un Item.
	 * 
	 * @return si esta entidad es un Item
	 */
	public boolean isItem()
	{
		if (this.getElementType().getKind().equals("Item"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//////////////////// METODOS SIMPLES

	
	
	
	
	
	/**
	 * Pone la celda empty en passable.
	 */
	public void putEmptyPassable()
	{
		this.getPassable().put(ElementTypes.Empty.hashCode(), ElementTypes.Empty);
	}

	/**
	 * Verifica en el hashmap si la celda de abajo es passable para esta
	 * entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoDown()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().getX(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 * Verifica en el hashmap si la celda de arriba es passable para esta
	 * entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoUp()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().getX(), this.getPosition().checkUp()).hashCode());
	}

	/**
	 * Verifica en el hashmap si la celda de derecha es passable para esta
	 * entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoRight()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkRight(), this.getPosition().getY()).hashCode());
	}

	/**
	 * Verifica en el hashmap si la celda de izquierda es passable para esta
	 * entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoLeft()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkLeft(), this.getPosition().getY()).hashCode());
	}

	/**
	 * Verifica en el hashmap si la celda de abajo izquierda es passable para
	 * esta entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoDownLeft()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkLeft(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 * Verifica en el hashmap si la celda de abajo izquierda es passable para
	 * esta entidad.
	 * 
	 * @return boolean
	 */
	public boolean canGoDownRight()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkRight(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 * Verifica en el MapItem si el item abajo de esta entidad es redondo.
	 * 
	 * @return boolean
	 */
	public boolean itemBelowIsRounded()
	{
		if(MapElement.getItem(this.getPosition().getX(), this.getPosition().checkDown()) != null)
		{
			return MapElement.getItem(this.getPosition().getX(), this.getPosition().checkDown()).isRounded();
		}
		else
		{
			return false;
		}
	}

	/**
	 * Verifica en el MapItem si el item puede caer por los uno de los dos
	 * lados.
	 * 
	 * @return boolean
	 */
	public boolean itemCanSlide()
	{
		return this.canGoLeft() && this.canGoDownLeft() || this.canGoRight() && this.canGoDownRight();
	}

	/**
	 * Verifica en el MapItem si el item abajo de esta entidad es un muro magico
	 * activo.
	 * 
	 * @return boolean
	 */
	public boolean itemBelowIsMagic()
	{
		return MapElement.getWall(this.getPosition().getX(), this.getPosition().checkDown()).getMagicTimer() > 0;
	}

	/**
	 * Verifica en el MapItem si el item abajo de esta entidad es un muro.
	 * 
	 * @return boolean
	 */
	public boolean itemBelowIsWall()
	{
		return MapElement.getWall(this.getPosition().getX(), this.getPosition().checkDown()) != null;
	}
	
	/**
	 * Remueve la entidad del mapa y lista.
	 */
	public void removeEntity(Entity entity)
	{
		ListOfEntities.getList().remove(entity);
		MapElement.removeElement(entity.getPosition());
	}

}

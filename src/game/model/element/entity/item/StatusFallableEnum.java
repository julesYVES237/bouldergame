package game.model.element.entity.item;

/**
 *This indicates all the movement states of an item <p>
 * Falling: falling down <bz>
 * slidingright / left: sliding <bz>
 * idle: still.
 *
 */
/**
 * @author mael
 *
 */
public enum StatusFallableEnum
{
	FALLINGOFF,
	FALLING,
	SLIDINGRIGHT,
	SLIDINGLEFT,
	PUSHEDRIGHT,
	PUSHEDLEFT,
	CONVERT,
	IDLE,
	DEAD
}

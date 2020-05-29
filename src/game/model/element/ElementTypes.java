package game.model.element;

/**
 *This enum contains the identification characters of each element for the
 * representation in the console of all the elements of the game.
 * <p>
 * Rockford (d, b, u, n animations) <br>
 * R, d, b, u, n, <br>
 * Enemies (F: firefly, B: butterfly) <br>
 * F, B, <br>
 * Cells (E, e closed and open exit) <br>
 * D, T, W, w, E, e, <br>
 * Items (O: rocks, X: diamond, A: amoeba, _: empty) <br>
 * O, X, A, C, <br>
 */
public enum ElementTypes
{
	Rockford("Actor",'R'),
	RockfordLeft("Actor",'d'),
	RockfordRight("Actor",'b'),
	RockfordUp("Actor",'u'),
	RockfordDown("Actor",'n'),
	Firefly("Actor",'F'),
	Butterfly("Actor",'B'),
	Dirt("Cell",'D'),
	Titanium("Cell",'T'),
	Wall("Cell",'W'),
	WallMagic("Cell",'w'),
	ExitClosed("Cell",'E'),
	ExitOpen("Cell",'e'),
	Rock("Item",'O'),
	Diamond("Item",'X'),
	Amoeba("Item",'A'),
	Empty("Cell",'_');

	private ElementTypes(String kind, char letter)
	{
		this.kind = kind;
		this.letter = letter;
	}

	private char letter;
	private String kind;

	public char getLetter()
	{
		return letter;
	}
	
	public String getKind()
	{
		return kind;
	}
}

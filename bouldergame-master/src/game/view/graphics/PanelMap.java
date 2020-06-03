package game.view.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.controller.access.MapAccess;
import game.view.FrameMap;

/**
 * Il s'occupe de rehausser les images de la carte. et dessinez la carte.
 */
public class PanelMap extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1848316932643919682L;
	private Image empty;
	private Image dirt;
	private Image boulder;
	private Image diamond;
	private Image steel;
	private Image wall;
	private Image firefly;
	private Image butterfly;
	// private Image magic;
	private Image amoeba;
	private Image rockford;
	private Image rockfordleft;
	private Image rockfordright;
	private Image rockfordup;
	private Image rockforddown;
	private Image exit;

	/**
	 * Lisez les images, pour le gif anim� utilisez la bo�te � outils.
	 */
	public PanelMap()
	{
		try
		{
			empty = ImageIO.read(this.getClass().getResource("/res/Element/empty.gif"));
			dirt = ImageIO.read(this.getClass().getResource("/res/Element/dirt.png"));
			boulder = ImageIO.read(this.getClass().getResource("/res/Element/boulder.png"));
			steel = ImageIO.read(this.getClass().getResource("/res/Element/steel.png"));
			wall = ImageIO.read(this.getClass().getResource("/res/Element/wall.png"));

			// magic =
			// Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/magic.gif"));
			firefly = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/firefly.gif"));
			butterfly = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/butterfly.gif"));
			amoeba = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/amoeba.gif"));
			rockford = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/rockford.gif"));
			rockfordleft = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/rockfordleft.gif"));
			rockfordright = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/rockfordright.gif"));
			rockfordup = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/rockfordup.gif"));
			rockforddown = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/rockforddown.gif"));
			exit = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/exit.gif"));
			diamond = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/res/Element/diamond.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		for (int y = 0; y < MapAccess.getHeight() * FrameMap.getCellsizey(); y += FrameMap.getCellsizey())
		{
			for (int x = 0; x < MapAccess.getWidth() * FrameMap.getCellsizex(); x += FrameMap.getCellsizex())
			{

				char cellChar = MapAccess.getCellChar(x / FrameMap.getCellsizex(), y / FrameMap.getCellsizey());
				drawCell(cellChar, x, y, graphic);

			}
		}
	}

	/**
	 * Dessine une cellule
	 * 
	 * @param s
	 * @param x
	 * @param y
	 * @param graphic
	 */
	private void drawCell(char c, int x, int y, Graphics graphic)
	{
		switch (c)
		{
			case 'D':
				graphic.drawImage(dirt, x, y, null);
				break;
			case '_':
				graphic.drawImage(empty, x, y, null);
				break;
			case 'W':
				graphic.drawImage(wall, x, y, null);
				break;
			case 'w':
				graphic.drawImage(wall, x, y, null);
				break;
			case 'F':
				graphic.drawImage(firefly, x, y, null);
				break;
			case 'B':
				graphic.drawImage(butterfly, x, y, null);
				break;
			case 'A':
				graphic.drawImage(amoeba, x, y, null);
				break;
			case 'O':
				graphic.drawImage(boulder, x, y, null);
				break;
			case 'X':
				graphic.drawImage(diamond, x, y, null);
				break;
			case 'T':
				graphic.drawImage(steel, x, y, null);
				break;
			case 'R':
				graphic.drawImage(rockford, x, y, null);
				break;
			case 'd':
				graphic.drawImage(rockfordleft, x, y, null);
				break;
			case 'b':
				graphic.drawImage(rockfordright, x, y, null);
				break;
			case 'n':
				graphic.drawImage(rockfordup, x, y, null);
				break;
			case 'u':
				graphic.drawImage(rockforddown, x, y, null);
				break;
			case 'E':
				graphic.drawImage(steel, x, y, null);
				break;
			case 'e':
				graphic.drawImage(exit, x, y, null);
				break;
			default:
				break;
		}
	}

	/**
	 * Modifiez la taille des cellules pour plusieurs r�solutions.
	 */
	public void cambiarsize()
	{
		int CELLSIZEX = 20;
		int CELLSIZEY = 25;
		FrameMap.setPanelTopSize(22);
		switch (FrameMap.getInstance().getSize().height)
		{
			case 768:
				if (FrameMap.getInstance().getSize().width == 1024)
				{
					CELLSIZEX = 25;
				}
				else
				{
					CELLSIZEX = 34;
				}
				CELLSIZEY = 32;
				FrameMap.setPanelTopSize(29);
				break;
			case 1080:
				CELLSIZEX = 48;
				CELLSIZEY = 46;
				FrameMap.setPanelTopSize(19);
				break;
		}
		FrameMap.setCellsize(CELLSIZEX, CELLSIZEY);
		empty = empty.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		dirt = dirt.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		boulder = boulder.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		diamond = diamond.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		steel = steel.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		wall = wall.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		firefly = firefly.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		butterfly = butterfly.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		// magic = magic.getScaledInstance(CELLSIZEX, CELLSIZEY,
		// Image.SCALE_DEFAULT);
		amoeba = amoeba.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		rockford = rockford.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		rockfordleft = rockfordleft.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		rockfordright = rockfordright.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		rockfordup = rockfordup.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		rockforddown = rockforddown.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
		exit = exit.getScaledInstance(CELLSIZEX, CELLSIZEY, Image.SCALE_DEFAULT);
	}

}

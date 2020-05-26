package game.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.controller.access.GameAccess;
import game.controller.access.MapAccess;
import game.view.config.Config;
import game.view.sound.Sound;

/**
 * Panneau de menu de jeu.
 */
public class PanelMenu extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *Rend le menu du panneau.
	 */
	public static void makeMenu(Background panel, JButton[] button)
	{
		FrameMenu.getInstance().refreshPanel(panel);
		final double SPACEX = 0.3;

		button[0].setText("JE VEUX JOUER (Groupe 8 X1)");
		button[0].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sound.button();
				MapAccess.setSelectedLevel(Integer.parseInt((String) Config.getInstance().getInitialLevel()));
				FrameMenu.getInstance().setVisible(false);
				GameAccess.launch();
				FrameMap.getInstance().setSize(FrameMenu.getInstance().getSize());
				FrameMap.setFullscr(FrameMenu.getInstance().isFullscreen());
				FrameMap.fullScr();
			}
		});

		Constraint.setup(0, 0, 1, 1, 0.5, 5, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
		panel.add(button[0], Constraint.get());

		button[1].setText("STATISTIQUE");
		button[1].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sound.button();
				try
				{
					PanelTop.getInstance().showTopX(FrameMenu.getInstance());
				}
				catch (ClassNotFoundException | IOException | URISyntaxException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Constraint.setup(0, 1, 1, 1, 0.5, SPACEX, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		panel.add(button[1], Constraint.get());

		button[2].setText("REGLAGE DU JEU");
		button[2].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sound.button();
				PanelRules.getInstance().showRules(FrameMenu.getInstance());
				;
			}
		});

		Constraint.setup(0, 2, 1, 1, 0.5, SPACEX, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		panel.add(button[2], Constraint.get());

		button[3].setText("CONFIGURATION");
		button[3].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sound.button();
				PanelConfig.getInstance().showConfig(FrameMenu.getInstance());
			}
		});

		Constraint.setup(0, 3, 1, 1, 0.5, SPACEX, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		panel.add(button[3], Constraint.get());

		button[4].setText("QUITTER LE JEU");
		button[4].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sound.button();
				FrameMenu.getInstance().dispose();
				System.exit(0);
			}
		});

		Constraint.setup(0, 4, 1, 1, 0.5, SPACEX, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		panel.add(button[4], Constraint.get());
	}

}

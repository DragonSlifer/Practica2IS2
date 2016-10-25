/*
 * GEMenu
 * Menu bar
 */
package GEView;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jorge
 */
public class GEMenu extends JMenuBar {

    private JMenu file, tools, info, help;
    private JMenuItem exit, addPlayer, addTeam, movePlayer, teamInfo, playerInfo, movesInfo, helpView, credits, changeDemarcation;

    public GEMenu() {
        /**
         * Setting up the menus
         */
        file                = new JMenu("Archivo");
        tools               = new JMenu("Herramientas");
        info                = new JMenu("Información");
        help                = new JMenu("Ayuda");
        /**
         * Setting up the menu items
         */
        exit                = new JMenuItem("Salir");
        addPlayer           = new JMenuItem("Agregar Jugador");
        addTeam             = new JMenuItem("Agregar Equipo");
        movePlayer          = new JMenuItem("Traspasar Jugador");
        teamInfo            = new JMenuItem("Información de Equipo(s)");
        playerInfo          = new JMenuItem("Información de Jugador(es)");
        movesInfo           = new JMenuItem("Información de Traspaso(s)");
        helpView            = new JMenuItem("Ayuda");
        credits             = new JMenuItem("Creditos");
        changeDemarcation   = new JMenuItem("Cambiar demarcación");
        /**
         * Adding items to menus
         */
        file.add(exit);
        
        tools.add(addPlayer);
        tools.add(addTeam);
        tools.add(movePlayer);
        tools.add(changeDemarcation);
        
        info.add(teamInfo);
        info.add(playerInfo);
        info.add(movesInfo);
        
        help.add(helpView);
        help.add(credits);
        /**
         * Adding menus to menu bar
         */
        this.add(file);
        this.add(tools);
        this.add(info);
        this.add(help);
    }
    /**
     * This would add the action listeners and set the action
     * commands to the menu items.
     * Code reference:
     * Action Command              |Meaning
     *      M0                     |Exit
     *      M1                     |Open Add Player Panel
     *      M2                     |Open Add Team Panel
     *      M3                     |Open Move Player Panel
     *      M4                     |Show Team Information
     *      M5                     |Show Player Information
     *      M6                     |Show Moves Information
     *      M7                     |Show Help Panel
     *      M8                     |Show Credits Panel
     *      M9                     |Change Demarcation
     * @param al 
     **********************************************************/
    public void setActionListener(ActionListener al){
        exit.addActionListener(al);
        exit.setActionCommand("M0");                 ///< Commands will be identified by numbers and a letter
        
        addPlayer.addActionListener(al);
        addPlayer.setActionCommand("M1");
        addTeam.addActionListener(al);
        addTeam.setActionCommand("M2");
        movePlayer.addActionListener(al);
        movePlayer.setActionCommand("M3");
        changeDemarcation.setActionCommand("M9");
        changeDemarcation.addActionListener(al);
        
        teamInfo.addActionListener(al);
        teamInfo.setActionCommand("M4");
        playerInfo.addActionListener(al);
        playerInfo.setActionCommand("M5");
        movesInfo.addActionListener(al);
        movesInfo.setActionCommand("M6");
        
        helpView.addActionListener(al);
        helpView.setActionCommand("M7");
        credits.addActionListener(al);
        credits.setActionCommand("M8");
    }
}

/*
 *  GEViewMain
 *  Main Class for the view
 */
package GEView;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jorge
 */
public class GEViewMain extends JFrame {

    private CardLayout cardLayout;              ///< For making the panel switching
    private GEAddPlayerPanel addPlayerPanel;    ///< Panel for Adding Players
    private GEAddTeamPanel addTeamPanel;        ///< Panel for Adding Teams
    private GECreditsPanel creditsPanel;        ///< Panel that shows version number and credits
    private GEHelpPanel helpPanel;              ///< Panel that shows general help
    private GEMovePlayerPanel movePlayerPanel;  ///< Panel that's used to change one player to other team
    private GEShowMovesInfoPanel smip;          ///< Panel that shows moves information
    private GEShowPlayerInfoPanel spip;         ///< Panel that shows player information
    private GEShowTeamInfoPanel stip;           ///< Panel that shows team information
    private GEMenu menuBar;                     ///< MenuBar
    private JPanel MainPanel;                   ///< Main Panel(where other panels goes)
    private GEChangeDemarcationPanel cdp;       ///< Panel that aids the user to change players demarcation

    /**
     * Constructor
     */
    public GEViewMain() {
        /**
         * Setting up Main Panel
         */
        MainPanel = new JPanel();
        /**
         * Setting up the CardLayoyt
         */
        cardLayout = new CardLayout();
        MainPanel.setLayout(cardLayout);
        /**
         * Setting up the Panels
         */
        addPlayerPanel = new GEAddPlayerPanel();
        addTeamPanel = new GEAddTeamPanel();
        creditsPanel = new GECreditsPanel();
        helpPanel = new GEHelpPanel();
        movePlayerPanel = new GEMovePlayerPanel();
        smip = new GEShowMovesInfoPanel();
        spip = new GEShowPlayerInfoPanel();
        stip = new GEShowTeamInfoPanel();
        cdp = new GEChangeDemarcationPanel();
        /**
         * Adding Panels to CardLayout
         */
        MainPanel.add(addPlayerPanel, "PlayerPanel");
        MainPanel.add(addTeamPanel, "TeamPanel");
        MainPanel.add(creditsPanel, "CreditsPanel");
        MainPanel.add(helpPanel, "HelpPanel");
        MainPanel.add(movePlayerPanel, "MPP");
        MainPanel.add(smip, "SMIP");
        MainPanel.add(spip, "SPIP");
        MainPanel.add(stip, "STIP");
        MainPanel.add(cdp,"CDPanel");
        /**
         * Setting up the Menu Bar
         */
        menuBar = new GEMenu();
        this.setJMenuBar(menuBar);
        menuBar.add(Box.createRigidArea(new Dimension(100, 25)));
        this.add(MainPanel);
        cardLayout.show(MainPanel, "PlayerPanel");               ///< Este es el panel que se mostrará inicialmente
    }

    /**
     * Function to make visible the Main View and resize it
     *
     * @param b
     * @param i
     * @param i0
     */
    public void makeVisible(boolean b, int i, int i0) {
        this.setVisible(b);
        this.setSize(i, i0);
    }

    public void setActionListeners(ActionListener al) {
        menuBar.setActionListener(al);
        this.addPlayerPanel.setActionListeners(al);
        this.addTeamPanel.setActionListeners(al);
        this.movePlayerPanel.setActionListeners(al);
        this.cdp.addActionListener(al);
    }

    public void setWindowListeners(WindowListener wl) {
        this.addWindowListener(wl);
    }

    public void setCardLayout(String s) {
        cardLayout.show(MainPanel, s);
    }

    public Vector<String> returnPData() {
        return addPlayerPanel.returnData();
    }

    public Vector<String> returnTData() {
        return addTeamPanel.returnData();
    }

    public boolean getStatus(String m) {
        switch (m) {
            case "M3":
                if ((this.movePlayerPanel.withoutTeams()) || (this.movePlayerPanel.withoutPlayers())) {
                    return false;
                }
                break;
        }
        return true;
    }

    public void initializeMPP(Vector<String> t, Vector<String> p) {
        System.out.println("Teams vector:   " + t);
        System.out.println("Players vector: " + p);
        this.movePlayerPanel.addTeams(t);
        this.movePlayerPanel.addPlayers(p);
    }

    public Vector<String> returnMData() {
        return this.movePlayerPanel.returnData();
    }

    public void setInfoSMIP(Vector<String> movePlayerRecords) {
        this.smip.putInfo(movePlayerRecords);
    }

    public void spip(Vector<String> sendPlayers) {
        this.spip.putInfo(sendPlayers);
    }

    public void stip(Vector<String> sendTeams) {
        this.stip.putInfo(sendTeams);
    }
    
    public String mppCB (){
        return this.movePlayerPanel.getPlayer();
    }

    public void mpp(String team) {
        this.movePlayerPanel.actualTeam(team);
    }
    
    public String cdpgetPlayer(){
        return cdp.getPlayer_name();
    }
    
    public void cdpSearch(String aux){
        cdp.setAct(aux);
    }
    
    public String cpdgetDemarcation(){
        return cdp.getDemarcation();
    }
}

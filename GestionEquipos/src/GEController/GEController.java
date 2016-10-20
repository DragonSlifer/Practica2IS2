/*
 *  GEController
 */
package GEController;

import GEModel.GEModel;
import GEView.GEViewMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Jorge
 */
public class GEController {

    private static GEModel model;
    private static GEViewMain view;

    public GEController(GEModel model, GEViewMain view) {
        this.model = model;
        this.view = view;
        view.setWindowListeners(new GEWindowListener());
        view.setActionListeners(new GEActionListener());
    }

    private static class GEWindowListener implements WindowListener {

        public GEWindowListener() {
        }

        @Override
        public void windowOpened(WindowEvent we) {

        }

        @Override
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent we) {

        }

        @Override
        public void windowIconified(WindowEvent we) {

        }

        @Override
        public void windowDeiconified(WindowEvent we) {

        }

        @Override
        public void windowActivated(WindowEvent we) {

        }

        @Override
        public void windowDeactivated(WindowEvent we) {

        }
    }

    private static class GEActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            /**
             * Variable declaration
             */
            String command;
            /**
             * Command Proccessing
             */
            command = ae.getActionCommand();
            System.out.println("GEController: Command " + command);
            switch(command){
                case "M0":
                    System.out.println("GEController: Closing Application");
                    System.exit(0);
                    break;
                case "M1":
                    view.setCardLayout("PlayerPanel");
                    System.out.println("GEController: Switched to GEAddPlayerPanel");
                    break;
                case "M2":
                    view.setCardLayout("TeamPanel");
                    System.out.println("GEController: Switched to GEAddTeamPanel");                    
                    break;
                case "M3":
                    view.setCardLayout("MPP");
                    view.initializeMPP(model.getTeamsString(),model.getPlayersString());
                    
                    System.out.println("GEController: Switched to GEMovePlayerPanel");  
                    break;
                case "M4":
                    view.setCardLayout("STIP");
                    view.stip(model.sendTeams());
                    System.out.println("GEController: Switched to GEShowTeamInfoPanel");  
                    break;
                case "M5":
                    view.setCardLayout("SPIP");
                    view.spip(model.sendPlayers());
                    System.out.println("GEController: Switched to GEShowPlayerInfoPanel"); 
                    break;
                case "M6":
                    view.setCardLayout("SMIP");
                    view.setInfoSMIP(model.movePlayerRecords());
                    System.out.println("GEController: Switched to GEShowMovesInfoPanel");  
                    break;
                case "M7":
                    view.setCardLayout("HelpPanel");
                    System.out.println("GEController: Switched to GEHelpPanel");  
                    break;
                case "M8":
                    view.setCardLayout("CreditsPanel");
                    System.out.println("GEController: Switched to GECreditsPanel");  
                    break;
                case "ADDP":
                    System.out.println("GEController: Adding player");  
                    model.AddPlayer(view.returnPData());
                    System.out.println("GEController: Added player");  
                    break;
                case "ADDT":
                    System.out.println("GEController: Adding team");  
                    model.AddTeam(view.returnTData());
                    System.out.println("GEController: Added team");  
                    break;
                case "GEMPPT":
                    model.movePlayerRecord(view.returnMData());
                    System.out.println("GE Controller: Transfered Player");
                    break;
                default:
                    System.out.println(" not found");
                    break;
            }
        }
    }

}

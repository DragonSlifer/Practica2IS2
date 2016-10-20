/*
 *  GEModel
 *  
 */
package GEModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class GEModel {

    private Vector<GETeam> teams;
    private Vector<GEPlayer> players;
    private int currentidplayer;
    private int currentidteam;

    public GEModel() {
        players = ReadPlayers();
        teams = ReadTeams();
    }

    public Vector<String> getTeamsString() {
        Vector<String> team = new Vector<>();

        for (int i = 0; i < this.teams.size(); i++) {
            team.add(this.teams.elementAt(i).getName());
        }

        return team;
    }

    public Vector<String> getPlayersString() {
        Vector<String> player = new Vector<>();

        for (int i = 0; i < this.teams.size(); i++) {
            player.add(this.players.elementAt(i).getName());
        }

        return player;
    }

    private Vector<GEPlayer> ReadPlayers() {
        Vector<GEPlayer> play_aux = new Vector<>();
        String path = System.getProperty("user.dir");

        try {
            FileReader fread = new FileReader(path + "/bin/Players.txt");

            BufferedReader bread = new BufferedReader(fread);
            String linea;
            int i = 0;
            linea = bread.readLine();

            if (linea == null) {
                System.out.println("GEModel -- ReadPlayers -- Players.txt is Empty");
            }
            while (linea != null) {
                GEPlayer p_aux = new GEPlayer(-1);                  ///< Iniciamos a -1 porque vamos a sobreescribir
                switch (i) {
                    case 0:
                        currentidplayer = Integer.parseInt(linea);
                        p_aux.setId_player(currentidplayer);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player ID: " + currentidplayer);
                        i++;
                        break;
                    case 1:
                        currentidteam = Integer.parseInt(linea);
                        p_aux.setId_team(currentidteam);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Team ID: " + currentidplayer);
                        i++;
                        break;
                    case 2:
                        p_aux.setName(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Name: " + linea);
                        i++;
                        break;
                    case 3:
                        p_aux.setSurname(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Surname: " + linea);
                        i++;
                        break;
                    case 4:
                        p_aux.setNacionality(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Nacionality: " + linea);
                        i++;
                        break;
                    case 5:
                        p_aux.setActualTeam(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Actual Team: " + linea);
                        i++;
                        break;
                    case 6:
                        p_aux.setBornDate(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Born Date: " + linea);
                        i++;
                        break;
                    case 7:
                        p_aux.setNumber(Integer.parseInt(linea));
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Number: " + linea);
                        i++;
                        break;
                    case 8:
                        p_aux.setDemarcacion(linea);
                        i++;
                        break;
                    case 9:
                        p_aux.setImporte(Float.parseFloat(linea));
                        play_aux.add(p_aux);
                        i = 0;
                        break;
                }
                linea = bread.readLine();
            }

            //if (i != 0) {
                //currentidplayer = 0;
                //play_aux.removeAllElements();
            //}

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return play_aux;
    }

    private Vector<GETeam> ReadTeams() {
        Vector<GETeam> team_aux = new Vector<>();
        String path = System.getProperty("user.dir");

        try {
            FileReader fread = new FileReader(path + "/bin/Teams.txt");

            BufferedReader bread = new BufferedReader(fread);
            String linea;
            int i = 0;
            if ((linea = bread.readLine()) == null) {
                System.out.println("GEModel -- ReadTeams -- Teams.txt is Empty");
            }
            while (linea != null) {
                GETeam t_aux = new GETeam(-1);
                switch (i) {
                    case 0:
                        t_aux.setId_team(Integer.parseInt(linea));
                        System.out.println("GEModel -- ReadTeams -- Readed Team ID: " + Integer.parseInt(linea));
                        i++;
                        break;
                    case 1:
                        t_aux.setName(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Team Name: " + linea);
                        i++;
                        break;
                    case 2:
                        t_aux.setMoney(Float.parseFloat(linea));
                        System.out.println("GEModel -- ReadTeams -- Readed Team Money: " + linea);
                        i++;
                        break;
                    case 3:
                        t_aux.setMembers(Integer.parseInt(linea));
                        System.out.println("GEModel -- ReadTeams -- Readed Team Member Number: " + linea);
                        team_aux.add(t_aux);
                        i = 0;
                        break;
                }
                linea = bread.readLine();
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return team_aux;
    }

    public void AddPlayer(Vector<String> val) {
        GEPlayer aux = new GEPlayer(currentidplayer);
        currentidplayer++;
        aux.setName(val.elementAt(0));
        aux.setSurname(val.elementAt(1));
        aux.setNacionality(val.elementAt(2));
        aux.setBornDate(val.elementAt(3));
        aux.setNumber(Integer.parseInt(val.elementAt(4)));
        aux.setDemarcacion(val.elementAt(5));
        aux.setImporte(Float.parseFloat(val.elementAt(6)));
        players.add(aux);
        this.writePlayer(aux);
    }

    public void AddTeam(Vector<String> val) {
        GETeam aux = new GETeam(currentidteam);
        currentidteam++;
        aux.setName(val.elementAt(0));
        aux.setMoney(Integer.parseInt(val.elementAt(1)));
        aux.setMembers(Integer.parseInt(val.elementAt(2)));
        teams.add(aux);
        this.writeTeam(aux);
    }

    private void writePlayer(GEPlayer aux) {
        FileWriter fw;
        BufferedWriter bw = null;

        try {
            String path = System.getProperty("user.dir");
            fw = new FileWriter(path + "/bin/Players.txt", true);          ///< The true will append the new data

            bw = new BufferedWriter(fw);
            bw.append(Integer.toString(aux.getId_player()));                           ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getId_player());
            bw.newLine();
            bw.append(Integer.toString(aux.getId_team()));                             ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getId_team());
            bw.newLine();
            bw.append(aux.getName());                                ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getName());
            bw.newLine();
            bw.append(aux.getSurname());                             ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getSurname());
            bw.newLine();
            bw.append(aux.getNacionality());                         ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getNacionality());
            bw.newLine();
            bw.append(aux.getActualTeam());                          ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getActualTeam());
            bw.newLine();
            bw.append(aux.getBornDate());                            ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getBornDate());
            bw.newLine();
            bw.append(Integer.toString(aux.getNumber()));                              ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getNumber());
            bw.newLine();
            bw.append(aux.getDemarcacion());
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getDemarcacion());
            bw.newLine();
            bw.append(Float.toString(aux.getImporte()));
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getImporte());
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();

            } catch (IOException ex) {
                Logger.getLogger(GEModel.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeTeam(GETeam aux) {
        FileWriter fw;
        BufferedWriter bw = null;

        try {
            String path = System.getProperty("user.dir");
            fw = new FileWriter(path + "/bin/Teams.txt", true);          ///< The true will append the new data

            bw = new BufferedWriter(fw);
            bw.write(Integer.toString(aux.getId_team()));                           ///< Appends the string to the file
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getId_team());
            bw.newLine();
            bw.write(Integer.toString(aux.getId_team()));                             ///< Appends the string to the file
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getId_team());
            bw.newLine();
            bw.write(aux.getName());                                ///< Appends the string to the file
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getName());
            bw.newLine();
            bw.write(Float.toString(aux.getMoney()));                             ///< Appends the string to the file
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getMoney());
            bw.newLine();
            bw.write(Integer.toString(aux.getMembers()));                         ///< Appends the string to the file
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getMembers());
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();

            } catch (IOException ex) {
                Logger.getLogger(GEModel.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void movePlayerRecord(Vector<String> record) {
        try {
            FileWriter fw;
            BufferedWriter bw;

            String path = System.getProperty("user.dir");
            fw = new FileWriter(path + "/bin/Transfers.txt", true);          ///< The true will append the new data
            bw = new BufferedWriter(fw);

            bw.write("Jugador" + record.elementAt(1) + " traspasado de " + record.elementAt(0) + " a " + record.elementAt(2) + " con Importe :" + record.elementAt(3));

            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        GEPlayer p_aux = null;
        int x = 0;
        for (int i = 0; i < players.size(); i++){
            if (players.elementAt(i).getName() == record.elementAt(1)){
                p_aux = players.elementAt(i);
                x = i;
                players.remove(i);
            }
        }
        for(int i = 0; i < teams.size(); i++){
            if (teams.elementAt(i).getName() == record.elementAt(2)){
                p_aux.setId_team(teams.elementAt(i).getId_team());
                p_aux.setActualTeam(teams.elementAt(i).getName());
            }  
        }
        players.add(x, p_aux);
    }

    public Vector<String> movePlayerRecords() {
        Vector<String> retval = new Vector<>();
        try {
            String path = System.getProperty("user.dir");
            FileReader fread = new FileReader(path + "/bin/Transfers.txt");
            BufferedReader bread = new BufferedReader(fread);
            String linea;
            while ((linea = bread.readLine()) != null) {
                retval.add(linea);
            }

        } catch (IOException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retval;
    }
    
    public Vector<String> sendTeams(){
        Vector <String> t = new Vector<>();
        for (int i = 0; i < this.teams.size(); i++){
            t.add(this.teams.elementAt(i).toString());
        }
        return t;
    }
    
    public Vector<String> sendPlayers(){
        Vector <String> t = new Vector<>();
        for (int i = 0; i < this.players.size(); i++){
            t.add(this.players.elementAt(i).toString());
        }
        return t;
    }
}

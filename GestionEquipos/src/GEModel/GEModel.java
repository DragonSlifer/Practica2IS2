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
        players = new Vector<>();
        ReadPlayers();
        teams = new Vector<>();
        ReadTeams();
    }

    public Vector<String> getTeamsString() {
        Vector<String> team = new Vector<>();

        for (int i = 0; i < this.teams.size(); i++) {
            team.add(this.teams.elementAt(i).getName());
            System.out.println(team.elementAt(i));
        }

        return team;
    }

    public Vector<String> getPlayersString() {
        Vector<String> player = new Vector<>();

        for (int i = 0; i < this.players.size(); i++) {
            player.add(this.players.elementAt(i).getName());
            System.out.println(player.elementAt(i));
        }

        return player;
    }

    private void ReadPlayers() {
        Vector<String> play_aux = new Vector<>();
        String path = System.getProperty("user.dir");
        int curid = 0;
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
                switch (i) {
                    case 0:
                        //currentidplayer = Integer.parseInt(linea);
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player ID: " + Integer.parseInt(linea));
                        i++;
                        break;
                    case 1:
                        curid = Integer.parseInt(linea);
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Team ID: " + Integer.parseInt(linea));
                        i++;
                        break;
                    case 2:

                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Name: " + linea);
                        i++;
                        break;
                    case 3:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Surname: " + linea);
                        i++;
                        break;
                    case 4:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Nacionality: " + linea);
                        i++;
                        break;
                    case 6:
                        if (curid == -1) {
                            linea = "No hay equipo";
                        }
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Actual Team: " + linea);
                        i++;
                        break;
                    case 5:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Born Date: " + linea);
                        i++;
                        break;
                    case 7:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Number: " + linea);
                        i++;
                        break;
                    case 8:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Demarcacion: " + linea);
                        i++;
                        break;
                    case 9:
                        play_aux.add(linea);
                        System.out.println("GEModel -- ReadPlayers -- Readed Player Importe: " + linea);
                        this.AddPlayer(play_aux, 1); ///< Adding without write command
                        i = 0;
                        break;
                }
                linea = bread.readLine();
            }
            if(!players.isEmpty())
            currentidplayer = this.players.lastElement().getId_player();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReadTeams() {
        Vector<String> team_aux = new Vector<>();
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
                        team_aux.add(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Team ID: " + Integer.parseInt(linea));
                        i++;
                        break;
                    case 1:
                        team_aux.add(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Team Name: " + linea);
                        i++;
                        break;
                    case 2:
                        team_aux.add(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Team Money: " + linea);
                        i++;
                        break;
                    case 3:
                        team_aux.add(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Team Member Number: " + linea);
                        i++;
                        break;
                    case 4:
                        team_aux.add(linea);
                        System.out.println("GEModel -- ReadTeams -- Readed Anual General Budget: " + linea);
                        this.AddTeam(team_aux, 1);
                        i = 0;
                        break;
                }
                linea = bread.readLine();
                if (!teams.isEmpty()) {
                    currentidteam = this.teams.lastElement().getId_team();
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AddPlayer(Vector<String> val, int command) {                    ///< 0 --> write, 1 --> readOnly
        GEPlayer aux;
        int c;
        if (val.elementAt(0) != "-1") {
            c = Integer.parseInt(val.elementAt(0));
        } else {
            c = currentidplayer;
        }
        aux = new GEPlayer(c);
        currentidplayer++;
        aux.setName(val.elementAt(2));
        aux.setSurname(val.elementAt(3));
        aux.setNacionality(val.elementAt(4));
        aux.setActualTeam(val.elementAt(6));
        aux.setBornDate(val.elementAt(5));
        aux.setNumber(Integer.parseInt(val.elementAt(7)));
        aux.setDemarcacion(val.elementAt(8));
        aux.setImporte(Float.parseFloat(val.elementAt(9)));
        System.out.println(aux);
        players.add(aux);
        System.out.println("Players Vec add -- " + players);
        if (command != 1) {
            this.writePlayer(aux, true);
        }
    }

    public void AddTeam(Vector<String> val, int command) {
        GETeam aux;
        int c;
        if (val.elementAt(0) != "-1") {
            c = Integer.parseInt(val.elementAt(0));
        } else {
            c = currentidteam;
        }

        aux = new GETeam(Integer.parseInt(val.elementAt(0)));
        currentidteam++;

        aux.setName(val.elementAt(1));
        aux.setMoney(Float.parseFloat(val.elementAt(2)));
        aux.setMembers(Integer.parseInt(val.elementAt(3)));
        aux.setGastosGenerales(Float.parseFloat(val.elementAt(4)));
        teams.add(aux);
        if (command != 1) {
            this.writeTeam(aux, true);
        }
    }

    private void writePlayer(GEPlayer aux, boolean append) {
        FileWriter fw;
        BufferedWriter bw = null;

        try {
            String path = System.getProperty("user.dir");
            if (append) {
                fw = new FileWriter(path + "/bin/Players.txt", append);          ///< The true will append the new data
            } else {
                fw = new FileWriter(path + "/bin/Players.txt");          ///< The true will append the new data
            }
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
            bw.append(aux.getBornDate());                            ///< Appends the string to the file
            System.out.println("GEModel -- writePlayer -- Printed: " + aux.getBornDate());
            bw.newLine();
            bw.append(aux.getActualTeam());                          ///< Appends the string to the file
            if (aux.getActualTeam() != "") {
                System.out.println("GEModel -- writePlayer -- Printed: " + aux.getActualTeam());
            } else {
                System.out.println("GEModel -- writePlayer -- Printed: " + "Ningun Equipo");
            }
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

    private void writeTeam(GETeam aux, boolean append) {
        FileWriter fw;
        BufferedWriter bw = null;

        try {
            String path = System.getProperty("user.dir");
            if (append) {
                fw = new FileWriter(path + "/bin/Teams.txt", append);          ///< The true will append the new data
            } else {
                fw = new FileWriter(path + "/bin/Teams.txt");
            }
            bw = new BufferedWriter(fw);
            bw.write(Integer.toString(aux.getId_team()));                           ///< Appends the string to the file
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
            bw.write(Float.toString(aux.getGastosGenerales()));
            System.out.println("GEModel -- writeTeam -- Printed: " + aux.getGastosGenerales());
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

            bw.write("Jugador " + record.elementAt(1) + " traspasado de " + record.elementAt(0) + " a " + record.elementAt(2) + " con Importe: " + record.elementAt(3));

            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(GEModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        GEPlayer p_aux = null;
        int x = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.elementAt(i).getName() == record.elementAt(1)) {
                p_aux = players.elementAt(i);
                x = i;
                players.remove(i);
            }
        }
        for (int i = 0; i < teams.size(); i++) {
            if (teams.elementAt(i).getName() == record.elementAt(2)) {
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

    public Vector<String> sendTeams() {
        Vector<String> t = new Vector<>();
        for (int i = 0; i < this.teams.size(); i++) {
            t.add(this.teams.elementAt(i).toString());
        }
        return t;
    }

    public Vector<String> sendPlayers() {
        Vector<String> t = new Vector<>();
        for (int i = 0; i < this.players.size(); i++) {
            t.add(this.players.elementAt(i).toString());
        }
        return t;
    }

    public String getTeam(String player) {
        String retval = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.elementAt(i).getName() == player) {
                retval = players.elementAt(i).getActualTeam();
            }
        }
        return retval;
    }

    public void writePlayersAndTeams() {
        for (int i = 0; i < players.size(); i++) {
            if (i == 0) {
                this.writePlayer(players.elementAt(i), false);
            } else {
                this.writePlayer(players.elementAt(i), true);
            }
            System.out.println("WritePlayersAndTeams" + players.elementAt(i));
        }

        for (int i = 0; i < teams.size(); i++) {
            if (i == 0) {
                this.writeTeam(teams.elementAt(i), false);
            } else {
                this.writeTeam(teams.elementAt(i), true);
            }
        }
    }
}

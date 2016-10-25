/**
 *  
 */
package GEModel;

/**
 *
 * @author Jorge
 */
public class GEPlayer {
    private int id_player;
    private int id_team;                                    ///< It shows the current team
    private int number;                                     ///< Player number
    private String name, surname, nacionality, actualTeam,bornDate, demarcacion;
    private float importe;

    public GEPlayer(int lastIDPlayer) {
        this.id_player = lastIDPlayer+1;
        this.id_team = -1;                                  ///< This means that player has no team
    }
    @Override
    public String toString(){
        String result;
        result = "Nombre: " + name + "\n Apodo" + surname + "\n Nacionalidad: " + nacionality + "\n Equipo"
                + actualTeam + "\n Fecha de Nacimiento: " + bornDate + "\n Demarcación: " + demarcacion
                + "\n Numero:" + number + "\n Importe: " + importe;
        return result;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId_team() {
        return id_team;
    }
    
    public void setId_player(int id){
        this.id_player = id;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }
    
    public int getId_player() {
        return id_player;
    }

    public String getNameP() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(String actualTeam) {
        this.actualTeam = actualTeam;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
}

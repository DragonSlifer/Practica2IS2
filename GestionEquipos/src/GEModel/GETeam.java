/*
 *  Role Game Character Creator
 *  Programa para crear fichas de personaes de rol en varios
 *  sistemas: Mundo de Tinieblas, NSD20, Malefic Time: Plenilunio,
 *  ...
 *  Permite además, guardar la ficha, editarla y enviarla por
 *  correo electrónico al director de partida.
 */
package GEModel;

/**
 *
 * @author Jorge
 */
public class GETeam {

    private int id_team;
    private String name;
    private float money;
    private int members;
    private float gastosGenerales;

    public GETeam(int lastID) {
        this.id_team = lastID + 1;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public float getGastosGenerales() {
        return gastosGenerales;
    }

    public void setGastosGenerales(float gastosGenerales) {
        this.gastosGenerales = gastosGenerales;
    }

    @Override
    public String toString() {
        String result;
        result = "Nombre: " + name + " \n Caja: " + money + "\n Miembros: " + members
                + "\n Gastos Generales Anuales: " + gastosGenerales;
        System.out.println(result);
        return result;
    }
}

package beans;

import com.opencsv.bean.CsvBindByName;

public class Teams {

    @CsvBindByName
    private int team_id;

    @CsvBindByName
    private String team_name;

    @CsvBindByName
    private String cars;

    @CsvBindByName
    private int funds;

    @Override
    public String toString() {
        return "Teams{" +
                "team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", cars='" + cars + '\'' +
                ", funds=" + funds +
                '}';
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getCars() {
        return cars;
    }

    public void setCars(String cars) {
        this.cars = cars;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}

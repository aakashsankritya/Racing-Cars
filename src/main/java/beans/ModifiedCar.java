package beans;

import java.util.List;

public class ModifiedCar {
    String car_id;
    String team_name;
    int modified_speed;
    int fund_spent;
    List<Parts> parts_added;

    public ModifiedCar(String car_id, String team_name, int modified_speed, int fund_spent, List<Parts> parts_added) {
        this.car_id = car_id;
        this.team_name = team_name;
        this.modified_speed = modified_speed;
        this.fund_spent = fund_spent;
        this.parts_added = parts_added;
    }

    @Override
    public String toString() {
        return "ModifiedCar{" +
                "car_id='" + car_id + '\'' +
                ", team_name='" + team_name + '\'' +
                ", modified_speed=" + modified_speed +
                ", fund_spent=" + fund_spent +
                ", parts_added=" + parts_added +
                '}';
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getModified_speed() {
        return modified_speed;
    }

    public void setModified_speed(int modified_speed) {
        this.modified_speed = modified_speed;
    }

    public int getFund_spent() {
        return fund_spent;
    }

    public void setFund_spent(int fund_spent) {
        this.fund_spent = fund_spent;
    }

    public List<Parts> getParts_added() {
        return parts_added;
    }

    public void setParts_added(List<Parts> parts_added) {
        this.parts_added = parts_added;
    }
}

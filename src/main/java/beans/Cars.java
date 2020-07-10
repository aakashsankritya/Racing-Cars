package beans;

import com.opencsv.bean.CsvBindByName;

public class Cars {
    @CsvBindByName
    private String car_id;

    @CsvBindByName
    private String car_name;

    @CsvBindByName
    private int base_speed;

    @CsvBindByName
    private int top_speed;

    @CsvBindByName
    private String part_list_id;

    @Override
    public String toString() {
        return "Cars{" +
                "car_id='" + car_id + '\'' +
                ", car_name='" + car_name + '\'' +
                ", base_speed=" + base_speed +
                ", top_speed=" + top_speed +
                ", part_list_id='" + part_list_id + '\'' +
                '}';
    }


    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public int getBase_speed() {
        return base_speed;
    }

    public void setBase_speed(int base_speed) {
        this.base_speed = base_speed;
    }

    public int getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(int top_speed) {
        this.top_speed = top_speed;
    }

    public String getPart_list_id() {
        return part_list_id;
    }

    public void setPart_list_id(String part_list_id) {
        this.part_list_id = part_list_id;
    }
}

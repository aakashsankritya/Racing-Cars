package beans;

import com.opencsv.bean.CsvBindByName;

public class Parts {
    @CsvBindByName
    private String part_list_id;

    @CsvBindByName
    private String part_id;

    @CsvBindByName
    private int price;

    @CsvBindByName
    private int speed_boost;

    @Override
    public String toString() {
        return "Parts{" +
                "part_list_id='" + part_list_id + '\'' +
                ", part_id='" + part_id + '\'' +
                ", price=" + price +
                ", speed_boost=" + speed_boost +
                '}';
    }

    public String getPart_list_id() {
        return part_list_id;
    }

    public void setPart_list_id(String part_list_id) {
        this.part_list_id = part_list_id;
    }

    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed_boost() {
        return speed_boost;
    }

    public void setSpeed_boost(int speed_boost) {
        this.speed_boost = speed_boost;
    }
}

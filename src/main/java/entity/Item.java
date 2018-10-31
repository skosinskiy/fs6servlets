package entity;

public class Item {

    private int value;
    private String name;

    public Item() {
    }

    public Item(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//
//json:
//item = {
//        value : 213,
//        name : "admin"
//        }
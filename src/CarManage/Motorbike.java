package CarManage;

public class Motorbike implements ICar {
    private String id;
    private String brand;
    private int year;
    private int price;
    private String color;
    private int capacity;

    public Motorbike(String id, String brand, int year, int price, String color, int capacity) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.capacity = capacity;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBranch() {
        return brand;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void showInfo() {
        System.out.println("Motorbike information: ");
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
        System.out.println("Capacity: " + capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}

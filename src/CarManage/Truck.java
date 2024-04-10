package CarManage;

public class Truck implements ICar {
    private String id;
    private String brand;
    private int year;
    private int price;
    private String color;
    private int loadWeight;

    public Truck(String id, String brand, int year, int price, String color, int loadWeight) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.loadWeight = loadWeight;
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

    public int getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public void showInfo() {
        System.out.println("Truck information: ");
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
        System.out.println("Load weight: " + loadWeight);
    }
}

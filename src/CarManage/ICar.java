package CarManage;

public interface ICar {
    String getId();
    String getBranch();
    int getYear();
    int getPrice();
    String getColor();
    void setId(String id);
    void setBrand(String branch);
    void setYear(int year);
    void setPrice(int price);
    void setColor(String color);
    void showInfo();
}

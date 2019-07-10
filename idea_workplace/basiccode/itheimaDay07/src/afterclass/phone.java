package afterclass;

public class phone {
    String brand;
    int prize;
    int age;

    public phone() {
    }

    public phone(String brand, int prize, int age) {
        this.brand = brand;
        this.prize = prize;
        this.age = age;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

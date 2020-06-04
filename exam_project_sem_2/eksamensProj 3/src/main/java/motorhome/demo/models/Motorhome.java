package motorhome.demo.models;
// Made by Mohamad Elhady

public class Motorhome {
    private int motorhomeId;
    private double pricePerDay;
    private String numberPlate;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int bedding;

    public Motorhome(int motorhomeId, double pricePerDay, String numberPlate, String brand, String model, int year, String color, int bedding) {
        this.motorhomeId = motorhomeId;
        this.pricePerDay = pricePerDay;
        this.numberPlate = numberPlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.bedding = bedding;
    }

    public Motorhome() {
       }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBedding() {
        return bedding;
    }

    public void setBedding(int bedding) {
        this.bedding = bedding;
    }

    @Override
    public String toString() {
        return "Motorhome{" +
                "motorhomeId=" + motorhomeId +
                ", pricePerDay=" + pricePerDay +
                ", numberPlate='" + numberPlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", bedding=" + bedding +
                '}';
    }
}

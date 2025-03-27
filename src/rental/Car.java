package rental;

public class Car {
    private String carId;
    private String brand;
    private String name;
    private double basePricePerDay;
    private boolean isAvailable;
    public Car(String carId, String brand, String name, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.name = name;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }
    public String getCarId() {
        return carId;
    }
    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public double calculatePrice(int rentaldays) {
        return basePricePerDay * rentaldays;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void rent(){
        isAvailable = false;
    }
    public void returnCar(){
        isAvailable = true;
    }
}

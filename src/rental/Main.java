package rental;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1= new Car("001", "Maruti", "i20",700);
        Car car2= new Car("002", "Mahindra", "XUV 300",900);
        Car car3= new Car("003", "Range Rover", "Discovery",1100);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}

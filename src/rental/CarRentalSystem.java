package rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars ;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentcar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }else{
            System.out.println("Car is not available for rent");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;

        for( Rental rental : rentals){
            if( rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }

        if( rentalToRemove != null){
            rentals.remove(rentalToRemove);
            System.out.println("Car Returned Successfully");
        }else{
            System.out.println("Car was not rented");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("=====<------CAR RENTAL SYSTEM ------>=====");
            System.out.println("1. Rent a car ");
            System.out.println("2. Return a car ");
            System.out.println(("3. Exit"));

            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("---- RENTING A CAR----");
                System.out.print("Enter the name: ");
                sc.nextLine();
                String customerName = sc.nextLine();


                System.out.println("---- Available Cars ----");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " " + car.getBrand() + " " + car.getName());
                    }
                }

                System.out.print("Enter the car Id you want to rent: ");
                String carId = sc.next();

                System.out.print("Enter the number of days you want to rent: ");
                int rentaldays = sc.nextInt();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selected = null;

                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selected = car;
                        break;
                    }
                }

                if (selected != null) {
                    double totalPrice = selected.calculatePrice(rentaldays);
                    System.out.println("---- RENTAL INFORMATION ----");
                    System.out.println("Customer ID : " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selected.getCarId() + " " + selected.getBrand() + " " + selected.getName());
                    System.out.println("Rental Days : " + rentaldays);
                    System.out.println("Total Price : Rs. " + totalPrice);

                    System.out.print("Conform Rental( Y/N ) : ");
                    String confirm = sc.next();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentcar(selected, newCustomer, rentaldays);
                        System.out.println("--> Rented Successfully <--");
                    } else {
                        System.out.println("Rental canceled");
                    }
                } else {
                    System.out.println("Invalid car or car not available");
                }
            } else if (choice == 2) {
                System.out.println("---- RETURNING A CAR ----");
                System.out.print("Enter the car Id : ");
                String carId = sc.next();

                Car carToReturn = null;

                for (Car car : cars) {
                    if (car.getCarId().equals(carId)) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    returnCar(carToReturn);
                } else {
                    System.out.println("Invalid Car Id or Car not Rented");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Enter the a valid option");
            }
        }
    }
}

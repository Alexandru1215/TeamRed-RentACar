package rent_a_car2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        getListOfCars();
//        createAccount();
//        System.out.println("Enter car id: ");
//        int car = scanner.nextInt();
        CarManagement carManagement = new CarManagement();
//        System.out.println(carManagement.getById(car));
//        System.out.println("Enter client id: ");
//        int client = scanner.nextInt();
//        ClientManagement clientManagement = new ClientManagement();
//        System.out.println(clientManagement.getById(client));
//        getCarById();
//        insertRentPeriod();
        carManagement.delete(152);
    }
    static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static List<Car> getListOfCars() {
        List<Car> resultList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your preferences between automatic and manual: ");
        String answer = scanner.next();
        CarManagement carManagement = new CarManagement();

        List<Car> carsList = carManagement.getAll();
        resultList = carsList.stream().filter(car -> car.getGearbox().equalsIgnoreCase(answer)).collect(Collectors.toList());
        if (!resultList.isEmpty()) {
            System.out.println(resultList);
        } else {
            System.out.println("We don't have cars with this specification.");
        }
        return resultList;
    }

    public static void getCarById() {
        List<Car> listCars = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the car id: ");
        int reply = scanner.nextInt();
        CarManagement carManagement = new CarManagement();
        List<Car> carsCars = carManagement.getAll();

        listCars = carsCars.stream().filter(car -> car.getId() == reply).collect(Collectors.toList());
        if (!listCars.isEmpty()) {
            System.out.println(listCars);
        } else {
            System.out.println("This id is not valid.");
        }
    }

    public static void createAccount(Client... clients) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create account. \nEnter your name: ");
            String name = scanner.next();
            System.out.println("Enter your license id: ");
            long licenseId = scanner.nextLong();
            System.out.println("Enter your phone number: ");
            long phoneNo = scanner.nextLong();
            System.out.println("Enter your email: ");
            String email = scanner.next();

            Client client = new Client(name, licenseId, phoneNo, email);
            System.out.println(client);

            session.persist(client);
            for (Client cl : clients) {
                session.persist(cl);
            }
            transaction.commit();
        }
    }
    public static void insertRentPeriod(RentDetail... rentDetail) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter start data: ");
            String startData = scanner.next();
            System.out.println("Enter end data: " );
            String endData = scanner.next();
            System.out.println("Enter pick up location: ");
            String pickUpLoc = scanner.next();

            RentDetail rentDetail1 = new RentDetail(startData, endData, pickUpLoc);
            System.out.println(rentDetail1);

            session.persist(rentDetail1);
            for (RentDetail rd : rentDetail) {
                session.persist(rd);
            }
            transaction.commit();
        }
    }
}









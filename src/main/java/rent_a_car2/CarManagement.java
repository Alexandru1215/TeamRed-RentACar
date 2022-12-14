package rent_a_car2;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.Arrays;
import java.util.List;

import static rent_a_car2.Main.sessionFactory;

public class CarManagement implements CrudManagement<Car> {
    @Override
    public void insert(Car item) {
        System.out.println("Inserting car...");
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
        }
    }

    @Override
    public void update(Car item) {
        System.out.println("Updating car...");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Car> getAll() {
        System.out.println("Getting car list...");
        try (Session session = sessionFactory.openSession()) {
            JpaCriteriaQuery<Car> jpaCriteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Car.class);
            jpaCriteriaQuery.from(Car.class);
            TypedQuery<Car> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public Car getById(int id) {
        System.out.println("Getting car by id...");
        try (Session session = sessionFactory.openSession()) {
            return session.get(Car.class, id);
        }
    }

    @Override
    public void delete(int item) {
        System.out.println("Deleting car...");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
           Car car = getById(item);
           if (car == null){
               System.out.println("Car with id " + item + " doesn't exist.");
           } else {
               session.remove(car);
               System.out.println("The car was removed.");
           }
           session.getTransaction().commit();
        }
    }
}

package rent_a_car2;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;

import static rent_a_car2.Main.sessionFactory;

public class RentDetailManagement implements CrudManagement<RentDetail>{
    @Override
    public void insert(RentDetail item) {
        System.out.println("Inserting rent detail...");
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
        }
    }

    @Override
    public void update(RentDetail item) {
        System.out.println("Updating rent detail...");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<RentDetail> getAll() {
        System.out.println("Getting rent detail...");
        try (Session session = sessionFactory.openSession()) {
            JpaCriteriaQuery<RentDetail> jpaCriteriaQuery = session.getCriteriaBuilder()
                    .createQuery(RentDetail.class);
            jpaCriteriaQuery.from(RentDetail.class);
            TypedQuery<RentDetail> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }
    @Override
    public RentDetail getById(int id) {
        System.out.println("Getting rent detail by id...");
        try (Session session = sessionFactory.openSession()) {
            return session.get(RentDetail.class, id);
        }
    }

    @Override
    public void delete(int item) {
        System.out.println("Deleting rent detail...");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            RentDetail rentDetail = getById(item);
            if (rentDetail == null){
                System.out.println("Client with id " + item + " doesn't exist.");
            } else {
                session.remove(rentDetail);
                System.out.println("The rent detail was deleted!");
            }
            session.getTransaction().commit();
        }
    }
    }


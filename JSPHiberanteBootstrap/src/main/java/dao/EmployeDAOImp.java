package dao;

import model.Employe;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeDAOImp implements EmployeDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    private Session session;
    private Transaction transaction;

    @Override
    public Employe insertEmploye(Employe employe) {
        session = factory.openSession();
        transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(employe);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return employe;
    }

    @Override
    public Employe findEmploye(int id) {
        session = factory.openSession();
        Employe employe = null;
        try {
            employe = session.get(Employe.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employe;
    }

    @Override
    public List<Employe> findAllEmployes() {
        session = factory.openSession();
        List<Employe> employe = null;
        try {
            Query query = session.createQuery("from Employe");
            employe = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employe;
    }

    @Override
    public void removeEmploye(int id) {
        session = factory.openSession();
        transaction = session.getTransaction();
        transaction.begin();
        try {
            Employe employe = session.get(Employe.class, id);
            if (employe != null)
                session.remove(employe);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

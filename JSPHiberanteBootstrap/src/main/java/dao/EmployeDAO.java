package dao;

import model.Employe;

import java.util.List;

public interface EmployeDAO {
    public Employe insertEmploye(Employe employe);
    public Employe findEmploye(int id);
    public List<Employe> findAllEmployes();
    public void removeEmploye(int id);
}

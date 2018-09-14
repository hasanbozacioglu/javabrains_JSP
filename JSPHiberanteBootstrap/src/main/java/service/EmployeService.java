package service;

import model.Employe;

import java.util.List;

public interface EmployeService {

    public Employe insertEmploye(Employe employe);

    public Employe findEmploye(int id);

    public List<Employe> findAllEmployes();

    public void removeEmploye(int id);
}

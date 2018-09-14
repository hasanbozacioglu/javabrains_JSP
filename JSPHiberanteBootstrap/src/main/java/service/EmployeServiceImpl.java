package service;

import dao.EmployeDAOImp;
import model.Employe;

import java.util.List;

public class EmployeServiceImpl implements EmployeService {
    private EmployeDAOImp employeDAOImp = new EmployeDAOImp();

    @Override
    public Employe insertEmploye(Employe employe) {
        return employeDAOImp.insertEmploye(employe);
    }

    @Override
    public Employe findEmploye(int id) {
        return employeDAOImp.findEmploye(id);
    }

    @Override
    public List<Employe> findAllEmployes() {
        return employeDAOImp.findAllEmployes();
    }

    @Override
    public void removeEmploye(int id) {
        employeDAOImp.removeEmploye(id);
    }

    public EmployeDAOImp getEmployeDAOImp() {
        return employeDAOImp;
    }

    public void setEmployeDAOImp(EmployeDAOImp employeDAOImp) {
        this.employeDAOImp = employeDAOImp;
    }
}

package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Doctor;
import Dto.Patient;
import Dto.Staff;

public class My_Dao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void saveStaff(Staff staff) {
		transaction.begin();
		manager.persist(staff);
		transaction.commit();
	}

	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.persist(doctor);
		transaction.commit();

	}
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.persist(patient);
		transaction.commit();

	}

	public Staff fetchByMobile(long mobile) {
		List<Staff> list = manager.createQuery("select x from Staff x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Staff fetchByEmail(String email) {
		List<Staff> list = manager.createNativeQuery("select * from Staff where email=?1", Staff.class)
				.setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Doctor fetchDoctor(long mobile) {
		List<Doctor> list = manager.createQuery("select x from Doctor x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Doctor fetchDoctor(String email) {
		List<Doctor> list = manager.createNativeQuery("select * from Doctor where email=?1", Doctor.class)
				.setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public Patient fetchPatient(long mobile) {
		List<Patient> list = manager.createQuery("select x from Patient x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Staff fetchStaff(int id) {
		return manager.find(Staff.class, id);

	}

	public Doctor fetchDoctor(int id) {
		return manager.find(Doctor.class, id);

	}

	public Doctor find(int id) {
		// TODO Auto-generated method stub
		return manager.find(Doctor.class, id);
	}
	
	public Staff find1(int id) {
		// TODO Auto-generated method stub
		return manager.find(Staff.class, id);
	}
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(doctor);
		transaction.commit();
	}

	public void update(Staff staff) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(staff);
		transaction.commit();
	}
	public void update(Patient patient) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(patient);
		transaction.commit();
	}
	
	public List<Doctor> fetchAllDoctor()
	{
		return manager.createQuery("select x from Doctor x").getResultList();
	}

	public List<Staff> fetchAllStaff()
	{
		return manager.createQuery("select x from Staff x").getResultList();
	}
	
	public List<Patient> fetchAllPatient()
	{
		return manager.createQuery("select x from Patient x").getResultList();
	}
	
}

package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

//		Department department = new Department(1, "Books");
//		Seller seller = new Seller(21, "Grog", "grog@gmail.com", new Date(), 3000.0, department);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: department insert ===");
		Department newDept = new Department(null, "Songs");
		departmentDao.insert(newDept);
		System.out.println("new id = " + newDept.getId());

		System.out.println("\n=== TEST 4: department update ===");
		Department department2 = departmentDao.findById(1);
		department2.setName("Void");
		departmentDao.update(department2);
		System.out.println("updated!");

		System.out.println("\n=== TEST 5: department delete ===");
		System.out.println("Enter id for delete teste: ");
		int nid = 15;
		departmentDao.deleteById(nid);
		System.out.println("Deleted!");

	}

}

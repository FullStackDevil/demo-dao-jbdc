package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

//		Department department = new Department(1, "Books");
//
//		Seller seller = new Seller(21, "Grog", "grog@gmail.com", new Date(), 3000.0, department);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller o : list) {
			System.out.println(o);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller o : list) {
			System.out.println(o);
		}

		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newS = new Seller(null, "gros", "a@as.com", new Date(), 4000., department);
		sellerDao.insert(newS);
		System.out.println("new id = " + newS.getId());

		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Maine");
		sellerDao.update(seller);
		System.out.println("updated!");

	}

}

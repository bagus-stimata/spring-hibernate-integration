package org.uwiga.simple;

import java.util.Date;
import java.util.List;

import org.config.spring.hibernate.dao.CustomerGenericDao;
import org.config.spring.hibernate.model.Customer;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.CustomerGenericService;
import org.config.spring.hibernate.service.ProductGenericService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppGenericDao {
	public static void main(String [] args){
		ApplicationContext ctxForServiceLayer = 
				new ClassPathXmlApplicationContext("org/config/spring/ApplicationContextForServiceLayer.xml");
		ProductGenericService productGenericService = (ProductGenericService) ctxForServiceLayer.getBean("productGenericServiceImpl");
		
		CustomerGenericDao customerDao = (CustomerGenericDao) ctxForServiceLayer.getBean("customerGenericDaoImpl");
		CustomerGenericService customerGenericService = (CustomerGenericService) ctxForServiceLayer.getBean("customerGenericServiceImpl");

		System.out.println("========= PRODUCT GENERIC SERVICE=============");
		List<Product> list2 = productGenericService.getAll();
		for (Product item: list2){
			System.out.print(item.getIdProduct() + "\t");
			System.out.print(item.getDescription() + "\t");
			System.out.print(item.getPprice() + "\t");
			System.out.print(item.getSprice() + "\t");
			System.out.print(item.getStock() + "\t");
			
			System.out.println();
		}
		
		System.out.println("========= Using Generic Dao Tanpa Service=============");
		List<Customer> list = customerDao.getAll();
		for (Customer item: list){
			System.out.print(item.getIdCustomer() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAddress() + "\t");
			System.out.print(item.getCity() + "\t");
			System.out.print(item.getLastTransaction() + "\t");
			
			System.out.println();
		}
		
		System.out.println("========= Using Generic Service dan Generic Dao=============");
		list = customerGenericService.getAll();
		for (Customer item: list){
			System.out.print(item.getIdCustomer() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAddress() + "\t");
			System.out.print(item.getCity() + "\t");
			System.out.print(item.getLastTransaction() + "\t");
			
			System.out.println();
		}
		Customer custEdit = new Customer();
		custEdit.setIdCustomer("N002");
		custEdit.setName("Setiawan Jono");
		custEdit.setAddress("Jln Kauman");
		custEdit.setCity("Malang");
		custEdit.setLastTransaction(new Date());
		customerGenericService.saveOrUpdate(custEdit);
		
		System.out.println("========= Using Generic Service dan Generic Dao:>> Setelah Edit=============");
		list = customerGenericService.getAll();
		for (Customer item: list){
			System.out.print(item.getIdCustomer() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAddress() + "\t");
			System.out.print(item.getCity() + "\t");
			System.out.print(item.getLastTransaction() + "\t");
			
			System.out.println();
		}
		
		
		System.out.println("Hello World!!");
	}

}

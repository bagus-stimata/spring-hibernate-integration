package org.uwiga.simple;

import java.util.Date;
import java.util.List;

import org.config.spring.hibernate.dao.CustomerGenericDao;
import org.config.spring.hibernate.model.Customer;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.model.Salesman;
import org.config.spring.hibernate.service.CustomerGenericService;
import org.config.spring.hibernate.service.ProductGenericService;
import org.config.spring.hibernate.service.SalesmanGenericService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppGenericDaoGetAll {
	public static void main(String [] args){
		ApplicationContext ctxForServiceLayer = 
				new ClassPathXmlApplicationContext("org/config/spring/ApplicationContextForServiceLayer.xml");
		SalesmanGenericService salesmanGenericService = (SalesmanGenericService) ctxForServiceLayer.getBean("salesmanGenericServiceImpl");
		ProductGenericService productGenericService = (ProductGenericService) ctxForServiceLayer.getBean("productGenericServiceImpl");		
		CustomerGenericService customerGenericService = (CustomerGenericService) ctxForServiceLayer.getBean("customerGenericServiceImpl");

		System.out.println("========= CUSTOMER GENERIC SERVICE=============");
		List<Customer> list3 = customerGenericService.getAll();
		for (Customer item: list3){
			System.out.print(item.getIdCustomer() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAddress() + "\t");
			System.out.print(item.getCity() + "\t");
			System.out.print(item.getLastTransaction() + "\t");
			
			System.out.println();
		}
		
		
		System.out.println("========= SALESMAN GENERIC SERVICE=============");
		List<Salesman> list1 = salesmanGenericService.getAll();
		for (Salesman item: list1){
			System.out.print(item.getIdSalesman() + "\t");
			System.out.print(item.getFistName() + "\t");
			System.out.print(item.getLastName() + "\t");
			System.out.print(item.getAddress() + "\t");
			System.out.print(item.getCity() + "\t");
			System.out.print(item.getJoinDate() + "\t");
			
			System.out.println();
		}
		
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

		
		System.out.println("Hello World!!");
	}

}

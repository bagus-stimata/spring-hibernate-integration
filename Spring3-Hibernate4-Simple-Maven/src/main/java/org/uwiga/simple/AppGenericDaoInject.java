package org.uwiga.simple;

import java.util.Date;
import java.util.List;

import org.config.spring.hibernate.dao.CustomerGenericDao;
import org.config.spring.hibernate.model.Customer;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.CustomerGenericService;
import org.config.spring.hibernate.service.ProductGenericServiceInject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppGenericDaoInject {
	public static void main(String [] args){
		ApplicationContext ctxForServiceLayer = 
				new ClassPathXmlApplicationContext("org/config/spring/ApplicationContextForServiceLayer.xml");
		ProductGenericServiceInject productGenericServiceInject = (ProductGenericServiceInject) ctxForServiceLayer.getBean("productGenericServiceInjectImpl");
		
		
		System.out.println("========= Using Service Inject Langsung ke GenericDao TANPA GENERIC SERVICE=============");
		List<Product> list = productGenericServiceInject.getAllBos();
		System.out.println(list.get(0).getDescription());
		
		/*
		for (Product item: list){
			System.out.print(item.getIdProduct() + "\t");
			System.out.print(item.getDescription() + "\t");
			System.out.print(item.getPprice() + "\t");
			System.out.print(item.getPprice() + "\t");
			System.out.print(item.getSprice() + "\t");			
			System.out.println();
		}
		*/
		
		System.out.println("Hello World!!");
	}

}

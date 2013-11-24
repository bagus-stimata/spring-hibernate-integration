package org.uwiga.simple;

import java.util.List;

import org.config.ApplicationContextProviderForServiceLayer;
import org.config.spring.hibernate.dao.ProductDao;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.ProductManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	System.out.println("hehehe");
    	
    	//ApplicationContext for Service Layer
    	//ApplicationContext ctxForServiceLayer = ApplicationContextProviderForServiceLayer.getInstance().getApplicationContext();
    	ApplicationContext ctxForServiceLayer = new ClassPathXmlApplicationContext("org/config/spring/ApplicationContextForServiceLayer.xml");
    	//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	//ApplicationContext for Beans >> Sorry Masih belum bisa untuk ini
    	//ApplicationContext ctxForBeans = new ClassPathXmlApplicationContext("org/config/spring/ApplicationContextForBeans.xml");
    	//ApplicationContext ctxForBeans = new ClassPathXmlApplicationContext("org/config/spring/ApplicationContext.xml");
    	
    	ProductManager productManager = (ProductManager) ctxForServiceLayer.getBean("productManagerImpl");
    	
    	//Tanpa menggunakan service layer sebetulnya bisa: Tapi jangan lupa unutk menambahkan @Transactional pada Masing2 method
    	ProductDao productDao = (ProductDao) ctxForServiceLayer.getBean("productDaoImpl");
    	List<Product> list = productDao.getAll();
    	
    	//List<Product> list = productManager.getAll();
    	for (Product item: list){
    		System.out.print(item.getIdProduct() + "\t");
    		System.out.print(item.getDescription() + "\t");
    		System.out.print(item.getPprice() + "\t");
    		System.out.print(item.getSprice() + "\t");
    		System.out.print(item.getStock() + "\t");
    		System.out.println();
    	}

    	Product productEdit = new Product();
    	productEdit.setIdProduct("002");
    	productEdit.setDescription("Dibalikin mas bro");
    	productEdit.setPprice(7000.0);
    	productEdit.setSprice(8000.0);
    	productEdit.setStock(200);
    	productManager.saveOrUpdate(productEdit);

    	Product productHapus = new Product();
    	productHapus.setIdProduct("002");    	
    	//productManager.delete(productHapus);
    	
    	System.out.println("=============SETELAH HAPUS=============");
    	list = productManager.getAll();
    	for (Product item: list){
    		System.out.print(item.getIdProduct() + "\t");
    		System.out.print(item.getDescription() + "\t");
    		System.out.print(item.getPprice() + "\t");
    		System.out.print(item.getSprice() + "\t");
    		System.out.print(item.getStock() + "\t");
    		System.out.println();
    	}
        System.out.println( "Hello World!" );
        
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.config;

import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*Fungsi dari ApplicationContextProvider ini adalah untuk menyatukan path dari konfigurasi
 * Spring ApplicationContextProvider.xml sehingga jika ada perubahan path maka untuk JPA atau Hibernate DAO
 * pada teknik Classpath maka kita tidak perlu untuk mengganti pada masing-masing class yang menggunakan
 */
public class ApplicationContextProviderForServiceLayer {

    private ApplicationContext applicationContext;
    private ApplicationContext applicationContextHsql;

    private static ApplicationContextProviderForServiceLayer provider;

    private ApplicationContextProviderForServiceLayer() throws ExceptionInInitializerError {
        try {
            this.applicationContext = new ClassPathXmlApplicationContext("org" + File.separator + "config" 
                    + File.separator + "spring" + File.separator + "ApplicationContextForServiceLayer.xml");
        } catch (Throwable ex) {
            System.err.print("error " + ex);
        }
    }

    public synchronized static ApplicationContextProviderForServiceLayer getInstance() throws ExceptionInInitializerError {
        ApplicationContextProviderForServiceLayer tempProvider = null;
        if (provider == null) {
            provider = new ApplicationContextProviderForServiceLayer();
            tempProvider = provider;
        }else if(provider.getApplicationContext()==null){
            provider=new ApplicationContextProviderForServiceLayer();
            tempProvider=provider;
        }else{
            tempProvider=provider;
        }

        return tempProvider;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContextHsql() {
        return applicationContextHsql;
    }

    public void setApplicationContextHsql(ApplicationContext applicationContextHsql) {
        this.applicationContextHsql = applicationContextHsql;
    }
    
    
}

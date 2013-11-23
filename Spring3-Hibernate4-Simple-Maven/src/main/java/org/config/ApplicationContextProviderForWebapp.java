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
 * Rubah path dari application context ini untuk webapp yang tidak menggunkan DAO Service Manager
 */

public class ApplicationContextProviderForWebapp {

    private ApplicationContext applicationContext;
    private ApplicationContext applicationContextHsql;

    private static ApplicationContextProviderForWebapp provider;

    private ApplicationContextProviderForWebapp() throws ExceptionInInitializerError {
        try {
            this.applicationContext = new ClassPathXmlApplicationContext("org" + File.separator + "config" 
                    + File.separator + "spring" + File.separator + "ApplicationContext.xml");
        } catch (Throwable ex) {
            System.err.print("error " + ex);
        }
    }

    public synchronized static ApplicationContextProviderForWebapp getInstance() throws ExceptionInInitializerError {
        ApplicationContextProviderForWebapp tempProvider = null;
        if (provider == null) {
            provider = new ApplicationContextProviderForWebapp();
            tempProvider = provider;
        }else if(provider.getApplicationContext()==null){
            provider=new ApplicationContextProviderForWebapp();
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

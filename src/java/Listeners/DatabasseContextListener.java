/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import entities.Database;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Krm
 */
public class DatabasseContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Connect to DB one time and set it as attribute in Context

        Database.setConnection();
        sce.getServletContext().setAttribute("con", Database.con);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //close the Connection of DB
    }
}

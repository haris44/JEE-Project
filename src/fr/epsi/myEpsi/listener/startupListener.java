package fr.epsi.myEpsi.listener;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.jmx.Premier;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;
import fr.epsi.myEpsi.servlet.Messages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@WebListener
public class startupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
	 Logger logger =  LogManager.getLogger(startupListener.class.getName());
    public startupListener() {
    	MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    	ObjectName name = null;

    	try {
    	    name = new ObjectName("com.jmdoudoux.tests.jmx:type=PremierMBean");
    	    Premier mbean = new Premier();
    	    mbs.registerMBean(mbean, name);

    	} catch (MalformedObjectNameException e) {
    	    e.printStackTrace();
    	} catch (NullPointerException e) {
    	    e.printStackTrace();
    	} catch (InstanceAlreadyExistsException e) {
    	    e.printStackTrace();
    	} catch (MBeanRegistrationException e) {
    	    e.printStackTrace();
    	} catch (NotCompliantMBeanException e) {
    	    e.printStackTrace();
    	}

    	IUserService userService = new UserService();
    	Integer usersSize = userService.getListOfUsers().size();
    	logger.error("users:".concat(usersSize.toString()));
    	
    	IMessageService messageService = new MessageService();
    	Integer messagesSize = messageService.getListOfMessages().size();
	   	logger.error("messages:".concat(messagesSize.toString()));
    }


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

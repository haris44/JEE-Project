package utils;

import java.util.Optional;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JmxUtils {

	public ObjectName getObjectName(String name) throws 	NotCompliantMBeanException,
																	InstanceAlreadyExistsException,
																	MBeanRegistrationException{
		try {
			ObjectName objectName = new ObjectName(name);
		    return objectName;
		} catch (MalformedObjectNameException e) {
		    e.printStackTrace();
		} catch (NullPointerException e) {
		    e.printStackTrace();
		}
		return null;
	}
}

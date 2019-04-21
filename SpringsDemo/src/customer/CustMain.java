package customer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@SuppressWarnings("deprecation")
public class CustMain {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("customer/applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  
	      
	    CustomerInfo student=(CustomerInfo)factory.getBean("customerbean");  
	    student.displayInfo();  
	}

}

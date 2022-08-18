package com.seleniumexpresss.beanlifecycle.annotation;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO=context.getBean("studentDAO",StudentDAO.class);
		studentDAO.selectAllRows();
		Hello hello=context.getBean("hello",Hello.class);
		hello.sample();
		//context.registerShutdownHook();
		context.close();
	}

}

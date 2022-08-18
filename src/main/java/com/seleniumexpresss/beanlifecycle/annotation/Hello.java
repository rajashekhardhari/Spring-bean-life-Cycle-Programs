package com.seleniumexpresss.beanlifecycle.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean,DisposableBean{
	
	/*
	 * public void init() {
	 * 
	 * System.out.println("inside hello class init method "); }
	 * 
	 * public void destroy() {
	 * 
	 * System.out.println("inside hello class destroy method "); }
	 */

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("inside properties set method-->init");
	}
	
	public void sample() {
		System.out.println("my coding start from here and ends here");
	}

	@Override
	public void destroy() throws Exception {
  System.out.println("inside destroy method-->destroy");		
	}

}

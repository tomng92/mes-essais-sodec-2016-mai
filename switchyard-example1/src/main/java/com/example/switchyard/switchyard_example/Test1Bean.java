package com.example.switchyard.switchyard_example;

import org.switchyard.component.bean.Service;

@Service(Test1.class)
public class Test1Bean implements Test1 {
	@Override
	 public String sayHello(String name) {
	   
	  return "Hello " + name;
	 }
}

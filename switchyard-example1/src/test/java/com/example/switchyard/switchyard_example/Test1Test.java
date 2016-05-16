package com.example.switchyard.switchyard_example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
//import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class Test1Test {

//	private SwitchYardTestKit testKit;
//	private CDIMixIn cdiMixIn;
	
	@ServiceOperation("Test1")
	private Invoker service;

	@Test
	public void testSayHello() throws Exception {
		// initialize your test message
		String message = "Allo Monde !";
		String result = service.operation("sayHello").sendInOut(message).getContent(String.class);

		// validate the results
		Assert.assertTrue(("Hello " + message).equals(result));
	}
}

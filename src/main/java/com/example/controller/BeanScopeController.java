package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Person;
import com.example.scopes.Configuration;

@RestController
@RequestMapping("/beanscopes")
public class BeanScopeController {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	Configuration cfg;
	
	
	@GetMapping("/singleton")
	public void singletonScopeTest()
	{
		Person personSingletonA =(Person) applicationContext.getBean("personSingleton");
	    Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

	    personSingletonA.setName("Jaya");
	    System.out.println("person a name "+ personSingletonA.getName());
	    System.out.println("person b name "+ personSingletonB.getName());
	}
	
	/* o/p: person a name Jaya
person b name Jaya
*/
	
	@GetMapping("/prototype")
	public void prototypeScopeTest()
	{
		Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
	    Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");

	    personPrototypeA.setName("Jaya");
	    personPrototypeB.setName("Sudha");
	    
	    System.out.println("person a name "+ personPrototypeA.getName());
	    System.out.println("person b name "+ personPrototypeB.getName());
/* o/p: person a name Jaya
person b name Sudha
*/
	    
	}
	@GetMapping("/request/{name}")
	public void requestScopeTest(@PathVariable String name)
	{
		//System.out.println(cfg.requestScopedBean().getName());

		cfg.requestScopedBean().setName(name);
		System.out.println(cfg.requestScopedBean().getName());
		
		
	}
	
	/* o/p: null
	 * null
	 * */
	@GetMapping("/session/{name}")
	public void sessionScopeTest(@PathVariable String name)
	{
		//System.out.println(cfg.sessionScopedBean().getName());

		cfg.sessionScopedBean().setName(name);
		System.out.println(cfg.sessionScopedBean().getName());

	}
	
	/* o/p: null
	 * null
	 * */
	
	@GetMapping("/application")
	public void applicationScopeTest()
	{
		System.out.println(cfg.applicationScopedBean().getName());

		cfg.applicationScopedBean().setName("Jaya");
		System.out.println(cfg.applicationScopedBean().getName());

	}
	/* o/p: null
	 * null
	 * */
	
	@GetMapping("/websocket")
	public void websocketScopeTest()
	{
		
		//System.out.println(cfg.websoketScopedBean().getName());

		cfg.websoketScopedBean().setName("Jaya");
		System.out.println(cfg.websoketScopedBean().getName());

	}
	/* o/p: null
	 * null
	 * */
	
}

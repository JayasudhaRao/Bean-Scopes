package com.example.scopes;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.example.bean.Person;

@Component

public class Configuration {

	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean
	@Scope("singleton")
	public Person personSingleton() {
	    return new Person();
	}
	
	
@Bean
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype")
public Person personPrototype() {
    return new Person();
}

@Bean
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@RequestScope
public Person requestScopedBean() {
    return new Person();
}

@Bean
@SessionScope
public Person sessionScopedBean()
{
	return new Person();
}

@Bean
@ApplicationScope
public Person applicationScopedBean()
{
	return new Person();
	
}

@Bean
//@WebsockerBean not present
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public Person websoketScopedBean()
{
	return new Person();
	
}

}

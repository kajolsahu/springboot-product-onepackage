package com.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {
	

	final static Logger myLogger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.main.controller.ProductController.*(..))")
	public void controllerPackage() {}

	@Pointcut("execution(* com.main.service.ProductServiceImpl.*(..))")
	public void ServicePackage() {}
	
	@Pointcut("controllerPackage() || ServicePackage()")
	private void forAppFlow() {}

	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
			
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method:{} " , theMethod);
			
		Object[] args = theJoinPoint.getArgs();
			
			for (Object tempArg : args) 
			{
				myLogger.info("=====>> argument:{} " ,tempArg);
			}
			
		}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method:{} " , theMethod);
				
		// display data returned
		myLogger.info("=====>> result:{} " , theResult);
	
	}
			

}

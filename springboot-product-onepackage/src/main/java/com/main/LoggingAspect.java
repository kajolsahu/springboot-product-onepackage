package com.main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.main.ProductController.*(..))")
	public void controllerPackage() {}

	@Pointcut("execution(* com.main.ProductServiceImpl.*(..))")
	public void ServicePackage() {}
	
	@Pointcut("controllerPackage() || ServicePackage()")
	private void forAppFlow() {}

	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
			
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod);
			
		Object[] args = theJoinPoint.getArgs();
			
			for (Object tempArg : args) 
			{
				myLogger.info("=====>> argument: " + tempArg);
			}
			
		}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
				
		// display data returned
		myLogger.info("=====>> result: " + theResult);
	
	}
			

}

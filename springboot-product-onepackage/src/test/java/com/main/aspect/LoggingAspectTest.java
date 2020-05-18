package com.main.aspect;

import static org.junit.Assert.*;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LoggingAspectTest {
	
	@InjectMocks
	LoggingAspect loggingAspect;

	@Mock
	JoinPoint theJoinPoint;
	@Test
	public void testBefore() {
		Mockito.when(theJoinPoint.getSignature()).thenReturn(Mockito.any());
		loggingAspect.before(theJoinPoint);
	}

	@Test
	public void testAfterReturning() {
		Object theResult=null;
		Mockito.when(theJoinPoint.getSignature()).thenReturn(Mockito.any());
		loggingAspect.afterReturning(theJoinPoint, theResult);
	}

}

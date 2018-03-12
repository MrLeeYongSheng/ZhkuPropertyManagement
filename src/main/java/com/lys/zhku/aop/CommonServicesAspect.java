package com.lys.zhku.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.utils.StatusCode;

@Aspect
@Component
public class CommonServicesAspect {

	@Pointcut("execution(* com.lys.zhku.service..impl.*Impl.update*(..)) || execution(* com.lys.zhku.service..impl.*Impl.delete*(..))")
	public void pointcutUpdateDelete() {}

	@Pointcut("execution(* com.lys.zhku.service..impl.*Impl.insert*(..)) || execution(* com.lys.zhku.service..impl.*Impl.add*(..))")
	public void pointcutInsert() {}
	
	@Around("pointcutUpdateDelete()")
	public Integer afterUpdateDelete(ProceedingJoinPoint pjp) {
		Integer status = 0;
		try {
			status = (Integer) pjp.proceed();
		} catch(ErrorException e) {
			throw e;
		} catch (Throwable e) {
			System.out.println("捕捉异常:"+this.getClass() + "#updateDelete");
			e.printStackTrace();
			throw new ErrorException(StatusCode.ERROR, "操作失败");
		}
		if(status<1) {
			throw new ErrorException(StatusCode.NOT_FOUND, "数据不存在,操作失败");
		}
		return status;
	}
	
	@Around("pointcutInsert()")
	public Integer afterInsert(ProceedingJoinPoint pjp) {
		Integer status = 0;
		try {
			status = (Integer) pjp.proceed();
		} catch(ErrorException e) {
			throw e;
		} catch (Throwable e) {
			System.out.println("捕捉异常:"+this.getClass() + "#afterInsert");
			e.printStackTrace();
			throw new ErrorException(StatusCode.ERROR, "操作失败");
		}
		if(status<1) {
			throw new ErrorException(StatusCode.EXIST, "数据已经存在,插入失败");
		}
		return status;
	}
}

package com.example.pojo;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component // @Configuration 으로 사용 권장
@Aspect // aspectj 에서 제공, 횡단 관심사 클래스임을 표기함
public class LogAspect {

    @Pointcut("@annotation(LocalExcutionTime)")
    public void pointcut() {}

    //@Around("@annotation(LocalExcutionTime)") // Advice의 한 종류로 Aspect의 실패 여부와 상관없이 전,후로 실행되도록하는 Advice. 파라미터로 pointCut 전달 필요
    @Around("pointcut()")
    // pointCut은 Aspect가 적용될 joinpoint를 정의 함

    public Object LocalExcutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        log.info("proceed 호출 전 ");

        //Object proceed = proceedingJoinPoint.proceed();

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        log.info("proceed 호출 후 ");

        return null;
        //return proceed;
    }


    @Pointcut("@annotation(TestAOP)")
    public void TestAOP() {}

    @AfterThrowing("TestAOP()")
    public void afterThrowingTest(JoinPoint joinPoint)  {
        Signature signature = joinPoint.getSignature();
        log.info("throwing .. " + signature.getName());
    }

    @AfterReturning("TestAOP()")
    public void afterReturningTest(JoinPoint joinPoint)  {
        Signature signature = joinPoint.getSignature();
        log.info("returning .. " + signature.getName());
    }

}

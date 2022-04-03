package interceptors;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ProfileInterceptorClient {
    @Inject
    Logger logger;

    @PostConstruct
    public void logPostConstruct(InvocationContext invocationContext) {
        logger.debug("Constructing Bean " + invocationContext.getTarget());
        logger.debug("Thread " + Thread.currentThread().getId());
        try {
            invocationContext.proceed();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void logPreDestroy(InvocationContext invocationContext) {
        logger.debug("Destructing Bean " + invocationContext.getTarget());
        logger.debug("Thread " + Thread.currentThread().getId());
        try {
            invocationContext.proceed();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    @AroundInvoke
    public Object profile(InvocationContext invocationContext) throws Exception {
        logger.debug("Invoking Method " + invocationContext.getMethod());
        logger.debug("Thread " + Thread.currentThread().getId());
        return invocationContext.proceed();
    }
}

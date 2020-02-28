package info.novatec.micronaut.camunda.app;

import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@MicronautTest
class ProcessTest {

    @Inject
    RuntimeService runtimeService;


    @Inject
    LoggerDelegate loggerDelegate;

    @Test
    public void verifyBeanInvocationInServiceTask() throws InterruptedException {
        runtimeService.startProcessInstanceByKey("hungry");
        verify(loggerDelegate).execute(any(DelegateExecution.class));
    }


}

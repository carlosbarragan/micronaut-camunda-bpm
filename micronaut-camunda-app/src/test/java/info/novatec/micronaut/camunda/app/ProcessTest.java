package info.novatec.micronaut.camunda.app;

import io.micronaut.test.annotation.MicronautTest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@MicronautTest
class ProcessTest {

    @Inject
    RuntimeService runtimeService;

    LoggerDelegate loggerDelegate = mock(LoggerDelegate.class);

    @BeforeEach
    void init () {
        Mocks.register("loggerDelegate", loggerDelegate);
    }

    @Test
    public void verifyBeanInvocationInServiceTask() throws InterruptedException {
        runtimeService.startProcessInstanceByKey("hungry");
        verify(loggerDelegate).execute(any(DelegateExecution.class));
    }
}

package dev.gbesso;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class SimpleHandlerTest {

    private SimpleHandler simpleHandler;
    @Mock
    Context context;

    @Mock
    LambdaLogger lambdaLogger;

    @BeforeEach
    public void setup(){
        when(context.getLogger()).thenReturn(lambdaLogger);
        doAnswer(call ->{
            System.out.println((String) call.getArgument(0));
            return null;
        }).when(lambdaLogger).log(anyString());
        simpleHandler =new SimpleHandler();
    }

    @Test
    void shouldReturnUpperCaseInput() {
        when(context.getFunctionName()).thenReturn("handleRequest");
        Assertions.assertEquals("HELLO, LAMBDA! ", simpleHandler.handleRequest("hello, lambda! ", context));
    }
}
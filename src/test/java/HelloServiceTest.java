import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by elton on 2/6/17.
 */
public class HelloServiceTest {

    HelloService service;

    @Before
    public void setUp(){
        service = new HelloService();
    }

    @After
    public void tearDown(){
        service = null;
    }

    @Test
    public void sayHelloTest(){
        final String expected = "Hello, World!";

        assertEquals("sayHelloTest: ", this.service.sayHello(), expected);

    }

}

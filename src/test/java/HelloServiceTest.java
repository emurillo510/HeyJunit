import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.batch.test.MetaDataInstanceFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by elton on 2/6/17.
 */

@RunWith(SpringJUnit4ClassRunner.class) //Indicates that the class should use Spring's JUnit facilities
@ContextConfiguration(locations = {
  "/flatfilereader-batch-context.xml"
})
public class HelloServiceTest {

    HelloService service;

    @Autowired
    FlatFileItemReader reader;

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
        /*
        final String expected = "Hello, World!";

        assertEquals("sayHelloTest: ", this.service.sayHello(), expected);
        */

    }

    @Test
    public void batchTest() throws Exception {

        reader.setResource(new FileSystemResource("input/report.csv"));

        reader.open(MetaDataInstanceFactory.createJobExecution().getExecutionContext());

        final Report expected = new Report();
        expected.setId("0");
        expected.setQty("1");
        expected.setSales("Tech");
        expected.setStaffName("Elton");
        expected.setDate("2017");

        final Report actual = (Report) this.reader.read();

        assertEquals("batchTest: ", actual.getStaffName(), expected.getStaffName());
    }

}

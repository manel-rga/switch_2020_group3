package switchtwentytwenty.project.THREEinterfaceadapters;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.TWOusecaseservices.TestIService;
import switchtwentytwenty.project.TWOusecaseservices.TestService;


@RunWith(SpringRunner.class)
@SpringBootTest
class TestControllerTest {

    @Autowired
    private TestIService testService = Mockito.mock(TestService.class);

    @Test
    void testGetUser() {
    }
}
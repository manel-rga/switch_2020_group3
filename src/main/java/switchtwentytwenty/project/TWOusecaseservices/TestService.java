package switchtwentytwenty.project.TWOusecaseservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.THREEinterfaceadapters.TestRepository;

@Service
public class TestService {

    @Autowired
    TestRepository testRepo;

    public String getNameById(int id) {

        return testRepo.getNameByID(id);
    }
}

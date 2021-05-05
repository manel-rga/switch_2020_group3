package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.domain.valueobject.*;

class PersonRepositoryTest {

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final int VALIDPHONENUMBER = 916969696;
    final String VALIDCCNUMBER = "156066866ZY1";
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final String VALIDADDRESSNUMBER = "69";
    final String VALIDBIRTHDATE = "01/03/1990";
    Name tonyZeName;
    BirthDate tonyZeBirthDate;
    PersonID tonyZeEmail;
    VATNumber tonyZeVat;
    PhoneNumber tonyZePhone;
    Address tonyZeAddress;
    CCnumber tonyZeCC;
    FamilyID familyID;

    @BeforeEach
    void createValidPersonAttributtes() {
        tonyZeName = new Name(VALIDNAME);
        tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        tonyZeEmail = new PersonID(VALIDEMAIL);
        tonyZeVat = new VATNumber(VALIDVATNUMBER);
        tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        tonyZeCC = new CCnumber(VALIDCCNUMBER);
        familyID = new FamilyID(VALIDEMAIL);
    }





    /* UNIT TESTS */

    @Test
    void getByID() {
    }

    @Test
    void save() {
    }

    /*
    @Test
    void shouldThrowNineTimesPersonIDAlreadyPresentInRepositoryTenThreads() throws InterruptedException {
        PersonRepository personRepository = new PersonRepository();
        AtomicInteger counter = new AtomicInteger();
        int numberOfThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.submit(() -> {
                try {
                    personRepository.createAndAdd(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);
                } catch (EmailAlreadyRegisteredException e) {
                    counter.getAndIncrement();
                }
                latch.countDown();
            });
        }
        latch.await();
        assertEquals(9, counter.get());
    }
    */

}
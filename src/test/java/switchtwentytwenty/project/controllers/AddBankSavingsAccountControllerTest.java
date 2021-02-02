package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddBankSavingsAccountControllerTest {

    String cc = "110142608ZZ0";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    boolean admin = false;

    String cc2 = "137843828ZX3";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    String cc3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1900, 8, 26);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";
    boolean admin3 = true;

    FamilyMember familyMember1 = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local, city, admin);
    FamilyMember familyMember2 = new FamilyMember(cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2, city2, admin2);
    FamilyMember familyMember3 = new FamilyMember(cc3,name3,date3,numero3,email3,nif3,rua3,codPostal3,local3, city3, admin3);

    String testFamilyName = "Moura";
    int testFamilyID = 10;
    Family testFamily = new Family(testFamilyName, testFamilyID);
    Application app = new Application(testFamily);
    AddBankSavingsAccountController controller = new AddBankSavingsAccountController(app);

    @Test
    public void checkIfBankSavingsAccountAddedRegularInput() {
        String accountName = "Savings Account";
        Double balance = 1.23;
        Double interestRate = 3.00;

        testFamily.addFamilyMember(familyMember1);
        assertTrue(controller.addBankSavingsAccount(testFamilyID, cc, accountName, balance, interestRate));
    }

    @Test
    public void checkIfBankSavingsReturnsFalseIfNoMemberCCInFamily() {
        String accountName = "Savings Account";
        Double balance = 1.23;
        Double interestRate = 3.00;

        testFamily.addFamilyMember(familyMember2);
        assertFalse(controller.addBankSavingsAccount(testFamilyID, cc, accountName, balance, interestRate));
    }


    @Test
    public void checkIfBankSavingsAccountAddedNullInput() {
        String accountName = " ";
        Double balance = null;
        Double interestRate = null;

        testFamily.addFamilyMember(familyMember1);
        assertTrue(controller.addBankSavingsAccount(testFamilyID, cc, accountName, balance, interestRate));
    }

    @Test
    public void checkIfThrowsWhenNoSuchMemberID() {
        assertFalse(controller.addBankSavingsAccount(10, "110142608ZZ1", "Savings 3", 1.00,5.21));
    }

    @Test
    public void checkIfThrowsWhenNoSuchFamilyID() {
        testFamily.addFamilyMember(familyMember3);
        assertFalse(controller.addBankSavingsAccount(11, "110142608ZZ0", "Savings 3", 1.00,5.21));
    }

    @Test
    void addBankSavingsAccount() {
    }
}
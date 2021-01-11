package switch2020.project.services;

import org.junit.jupiter.api.Test;
import switch2020.project.controllers.CreateFamilyCashAccountController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    int id = 1111;
    String name = "Diogo";
    String date = "26/08/1990";
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = false;

    //Added 2nd FamilyMember to test
    int id2 = 2222;
    String name2 = "Tony";
    String date2 = "26/08/1954";
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    int id3 = 3333;
    String name3 = "TonyZe";
    String date3 = "26/08/1955";
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";
    Relation relation3 = new Relation(relacao3);
    boolean admin3 = true;

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, admin2);
    FamilyMember manuelAdmin = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, relation3, admin3);
    Family family = new Family();
    Family familyTwo = new Family();
    Family familyThree = new Family();
    ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    FamilyMemberRelationDTO diogoDTO = new FamilyMemberRelationDTO(diogo.getName(), diogo.getRelation());
    FamilyMemberRelationDTO jorgeDTO = new FamilyMemberRelationDTO(jorge.getName(), jorge.getRelation());
    FamilyMemberRelationDTO manuelAdminDTO = new FamilyMemberRelationDTO(manuelAdmin.getName(), manuelAdmin.getRelation());
    List<FamilyMemberRelationDTO> expected = new ArrayList<FamilyMemberRelationDTO>();

    @Test
    void GetFamilyByID() {
        int familyID1 = 1;
        int familyID2 = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 2;

        int expected = 2;

        int result = familyService.getFamily(familyID).getFamilyID();

        assertEquals(expected, result);
    }

    @Test
    void GivenFamilyIDNotFound() {
        int familyID1 = 1;
        int familyID2 = 2;
        int selfID = 1;
        int otherID = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 3; //Dont exist any family with that ID number

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(selfID,otherID,"prima",familyID));
    }

    @Test
    void CreateRelation() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertTrue(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void NotAdminTryingToCreateRelationReturningFalse() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertFalse(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void FamilyDontExist() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        int familyID2 = 2;

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID2));
    }

    @Test
    void CreateAnExistingRelationDesignation() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        int familyMemeberID3 = 3;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        FamilyMember familyMember3 = new FamilyMember(familyMemeberID3);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);
        family.addFamilyMember(familyMember3);

        int expected = 1;

        familyService.addFamily(family);

        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        int result = family.numberOfRelationDesignations();

        assertTrue(familyService.createRelation(familyMemberID1, familyMemeberID3, relationDesignation2, familyID));
        assertEquals(expected, result);
    }

    @Test
    void FamilyMemberWithARelationAssigned() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "Father";
        FamilyService familyService = new FamilyService();
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();
        int familyID = 1;
        Family family = new Family(familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);
        familyService.addFamily(family);
        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);
        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation2, familyID));
    }

    @Test
    void createFamilyCashAccountResultFalseAccountAlreadyExists() {
        FamilyService familyService = new FamilyService();
        int familyID = 1;
        Family aFamily = new Family(familyID);
        familyService.addFamily(aFamily);
        boolean expected = true;

        boolean result = familyService.createFamilyCashAccount(familyID);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountResultTrueAccountCreated() {
        FamilyService familyService = new FamilyService();
        int familyID = 1;
        Family aFamily = new Family(familyID);
        familyService.addFamily(aFamily);
        familyService.createFamilyCashAccount(familyID);
        boolean expected = false;

        boolean result = familyService.createFamilyCashAccount(familyID);

        assertEquals(expected, result);
    }

    @Test
    void NotAddFamilyMember_EmailPresent() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, ()-> familias.addFamilyMember(name2,date2,numero2,"abc@gmail.com",nif2,rua2,codPostal2,local2,city2,relation2,1));
    }

    @Test
    void AddFamilyMember_EmailNotPresent() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,relation2,1));
    }

    @Test
    void AddFamilyMember_FamilyExists() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,relation2,1));
    }

    @Test
    void NotAddFamilyMember_FamilyNotExists() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, ()-> familias.addFamilyMember(name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,relation2,2));

    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithAdministratorExpectingTrue() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService family = new FamilyService(ribeiro);
        diogo.makeAdmin();
        boolean expected = true;
        boolean result = family.verifyAdministratorPermission(ribeiro.getFamilyID(), diogo.getID());
        assertTrue(result);
    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithNoAdministratorExpectingFalse() {
        FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family ribeiro = new Family(1, diogo);
        FamilyService family = new FamilyService(ribeiro);
        boolean expected = false;
        boolean result = family.verifyAdministratorPermission(ribeiro.getFamilyID(), 12);
        assertFalse(result);
    }

    @Test
    void getDTOList_ExpectingToHaveEqualListsBecauseMemberIsAdminAndMethodWillReturnFilledList() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        expected.add(diogoDTO);
        expected.add(jorgeDTO);
        expected.add(manuelAdminDTO);
        FamilyService familyService = new FamilyService(family);
        //Act
        List<FamilyMemberRelationDTO> result = familyService.getDTOList(family.getFamilyID(), manuelAdmin.getID());
        //Assert
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getDTOList_TestWithNoAdministratorIDExpectingToBeNotEqualsBecauseTheFamilyMemberIsNotAdministratorAndTheReturnIsEmptyList() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        expected.add(diogoDTO);
        expected.add(jorgeDTO);
        expected.add(manuelAdminDTO);
        FamilyService familyService = new FamilyService(family);
        //Act
        List<FamilyMemberRelationDTO> result = familyService.getDTOList(family.getFamilyID(), jorge.getID());
        //Assert
        assertNotEquals(expected, result);
        assertNotSame(expected, result);
    }


}
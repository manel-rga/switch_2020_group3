package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddFamilyMemberControllerTest {


    String ccNumber = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    boolean admin = true;

    String ccNumber2 = "137843828ZX3";
    String name2 = "xxxx";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "abcd@gmail.com";
    int nif2 = 212122234;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "ccccc";
    String city2 = "Porto";
    String relacao2 = "filho";

    boolean admin2 = false;

    @Test
    /** Test if Family Member is added to Family **/
    void AddFamilyMember_FamilyExists() {
        FamilyMember Diogo = new FamilyMember(ccNumber, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        String familyName = "Ribeiro";
        int familyID = 1;
        Family Ribeiros = new Family(familyName, familyID);
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(ccNumber, ccNumber2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, 1);
        Ribeiros.addFamilyMember(Diogo);
        Application app = new Application(Ribeiros);
        AddFamilyMemberController FFMapp = new AddFamilyMemberController(app);
        assertTrue(FFMapp.addFamilyMember(familyMemberDTO));
    }


    @Test
    void NotAddFamilyMember_FamilyNotExists() {
        String familyName = "Ribeiro";
        int familyID = 1;
        Family Ribeiros = new Family(familyName, familyID);
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(ccNumber2, ccNumber, name, date, numero, email, nif, rua, codPostal, local, city, 2);
        Application app = new Application(Ribeiros);
        AddFamilyMemberController FFMapp = new AddFamilyMemberController(app);
        assertFalse(FFMapp.addFamilyMember(familyMemberDTO));
    }


}
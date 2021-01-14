package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.FamilyService;


public class GetFamilyMembersListController {
    private Application ffmApplication;

    public GetFamilyMembersListController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }


    /**
     * Method that obtains the FFMapp, that has the FamilyService as
     * its attribute. Then uses a method of the FamilyService
     * which is the getDTOList, that iterates through the
     * specific family (familyID) obtains the necessary info from its familyMembers
     * and converts it to a DTO, returning it back here to the Controller
     *
     * @param familyID representing the unique ID given to each family
     * @return DTOList with members name and the relation they have towards the Family Administrator
     */
    public boolean getFamilyMembersAndRelation(int familyID, String adminCCNumber) {
        boolean controllerSuccess;
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            familyService.getFamilyMembersRelationDTOList(familyID, adminCCNumber);
            controllerSuccess = true;
        } catch (IllegalArgumentException wrongFamilyID) {
            System.out.println(wrongFamilyID.getMessage());
            controllerSuccess = false;
        } return controllerSuccess;
    }

    }


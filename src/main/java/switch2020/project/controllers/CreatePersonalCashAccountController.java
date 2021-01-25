package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class CreatePersonalCashAccountController {
    private Application ffmApplication;


    public CreatePersonalCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean createPersonalCashAccount(int familyID, String ccNumber, String accountDesignation, double initialBalance) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(ccNumber);
            AccountService accountService = this.ffmApplication.getAccountService();
            return accountService.createPersonalCashAccount(targetMember, accountDesignation, initialBalance);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
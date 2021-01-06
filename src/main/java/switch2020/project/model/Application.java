package switch2020.project.model;

import switch2020.project.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //attributes
    //private ArrayList<Category> categories = new ArrayList();
    private CategoryService categoryService;
    private FamilyService familyService;

    //constructors
    public Application() {
        this.categoryService = new CategoryService();
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public Application(Family family) {
        this.familyService.addFamily(family);

    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyID       Integer representing the family's ID
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyID, int familyMemberID) {
        return this.familyService.addEmail(emailToAdd, familyID, familyMemberID);
    }
}

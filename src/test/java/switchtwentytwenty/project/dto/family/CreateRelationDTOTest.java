package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateRelationDTOTest {

    @Test
    void getMemberOneIDMustNotBeNull() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO("tonyze", "katia", "BFF");
        String result = createRelationDTO.getMemberOneID();
        assertNotNull(result);
    }

    @Test
    void getMemberTwoID() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO("tonyze", "katia", "BFF");
        String result = createRelationDTO.getMemberTwoID();
        assertNotNull(result);
    }

    @Test
    void getRelationDesignation() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO("tonyze", "katia", "BFF");
        String result = createRelationDTO.getRelationDesignation();
        assertNotNull(result);
    }
}
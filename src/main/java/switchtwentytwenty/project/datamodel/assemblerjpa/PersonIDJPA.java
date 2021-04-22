package switchtwentytwenty.project.datamodel.assemblerjpa;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@ToString
@NoArgsConstructor
@Embeddable
public class PersonIDJPA implements Serializable {

    private String personID;

    public PersonIDJPA(String personID) {
        this.personID = personID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonIDJPA that = (PersonIDJPA) o;
        return personID.equals(that.personID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID);
    }
}
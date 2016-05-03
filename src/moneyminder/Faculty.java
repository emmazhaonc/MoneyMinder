package gatech.Item.optimizer.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

/**
 * Created by 204069126 on 3/16/15.
 */
@Entity(name = "faculty")
public class Faculty extends User {


    @ManyToMany
    private Set<Item> competencies;

    @ManyToMany
    private List<Period> availability;

    public Set<Item> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<Item> competencies) {
        this.competencies = competencies;
    }

    public List<Period> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Period> availability) {
        this.availability = availability;
    }
}

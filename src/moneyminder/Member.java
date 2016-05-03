package gatech.Item.optimizer.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by 204069126 on 2/6/15.
 */

@Entity(name = "Member")
public class Member extends User {

    @OneToMany(fetch = FetchType.EAGER)
    private List<DesiredItem> desiredItems;

    private int seniority;
    private String MemberId;

    public Member() {
        setRole(Role.Member);
    }

    public Member(String username, String password, String firstName, String lastName, String id) {
        this();
        this.MemberId = id;
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public List<DesiredItem> getDesiredItems() {
        return desiredItems;
    }

    public void setDesiredItems(List<DesiredItem> desiredItems) {
        this.desiredItems = desiredItems;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }
}

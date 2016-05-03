package gatech.Item.optimizer.model;

import javax.persistence.Entity;

/**
 * Created by Joe Egan on 4/13/15.
 */
@Entity(name = "HeadofHousehold")
public class HeadofHousehold extends Faculty {
    public HeadofHousehold() {
        setRole(Role.HeadofHousehold);
    }

    public HeadofHousehold(String firstName, String lastName) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
    }

    public HeadofHousehold(String username, String password, String firstName, String lastName) {
        this(firstName, lastName);
        setUsername(username);
        setPassword(password);
    }
}
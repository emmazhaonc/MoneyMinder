package gatech.Item.optimizer.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 204069126 on 2/6/15.
 */
@Entity(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Lob
    private String description;
    private String number;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Item> prerequisites;


    public Item() {
    }

    public Item(String number, String name) {
        this.name = name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Item> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Set<Item> prerequisites) {
        this.prerequisites = prerequisites;
    }

}

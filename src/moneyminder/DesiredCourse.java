package gatech.Item.optimizer.model;

import javax.persistence.*;

/**
 * Created by 204069126 on 4/20/15.
 */
@Entity(name = "desired_Item")
public class DesiredItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Item Item;
    private int priority;
    private Long MemberId;

    public DesiredItem() {
    }

    public DesiredItem(Long MemberId, Item Item, int priority) {
        this.MemberId = MemberId;
        this.Item = Item;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return Item;
    }

    public void setItem(Item Item) {
        this.Item = Item;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long MemberId) {
        this.MemberId = MemberId;
    }
}

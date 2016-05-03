package gatech.Item.optimizer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 204069126 on 3/16/15.
 */
@Entity(name = "Item_offering")
public class ItemOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer crn;
    private int MemberCapacity;

    @OneToOne
    private Item Item;

    @OneToOne
    private Period Period;

    @OneToOne
    private Faculty HeadofHousehold;

    //@OneToMany
    @ManyToMany
    private Set<Faculty> teacherAssistants;

    @ManyToMany
    private List<Member> enrolledMembers;

    @OneToMany
    private List<Member> MembersOnWaitList;


    public ItemOffering() {
    }

    public ItemOffering(String crn, Item Item, Period Period) {
        this.crn = Integer.valueOf(crn);
        this.Item = Item;
        this.Period = Period;
        this.teacherAssistants = new HashSet<Faculty>();
        this.enrolledMembers = new ArrayList<Member>();
        this.MembersOnWaitList = new ArrayList<Member>();
        this.MemberCapacity = Integer.MAX_VALUE;
    }

    public void enrollMember(Member Member) {
        this.enrolledMembers.add(Member);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCrn() {
        return crn;
    }

    public void setCrn(Integer crn) {
        this.crn = crn;
    }

    public Item getItem() {
        return Item;
    }

    public void setItem(Item Item) {
        this.Item = Item;
    }

    public Period getPeriod() {
        return Period;
    }

    public void setPeriod(Period Period) {
        this.Period = Period;
    }

    public Faculty getHeadofHousehold() {
        return HeadofHousehold;
    }

    public void setHeadofHousehold(Faculty HeadofHousehold) {
        this.HeadofHousehold = HeadofHousehold;
    }

    public Set<Faculty> getTeacherAssistants() {
        return teacherAssistants;
    }

    public void setTeacherAssistants(Set<Faculty> teacherAssistants) {
        this.teacherAssistants = teacherAssistants;
    }

    public int getMemberCapacity() {
        return MemberCapacity;
    }

    public void setMemberCapacity(int MemberCapacity) {
        this.MemberCapacity = MemberCapacity;
    }

    public List<Member> getEnrolledMembers() {
        return enrolledMembers;
    }

    public void setEnrolledMembers(List<Member> enrolledMembers) {
        this.enrolledMembers = enrolledMembers;
    }

    public List<Member> getMembersOnWaitList() {
        return MembersOnWaitList;
    }

    public void setMembersOnWaitList(List<Member> MembersOnWaitList) {
        this.MembersOnWaitList = MembersOnWaitList;
    }

    public int getDemand() {
        return enrolledMembers.size() + MembersOnWaitList.size();
    }

}

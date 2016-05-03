package gatech.Item.optimizer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 204069126 on 4/9/15.
 */
@Entity(name = "Member_record")
public class MemberRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long ItemOfferingDBId;
    private Long MemberDBId;
    private String grade;

    // Extra - not really needed
    private String ItemShortName;
    private Integer crn;
    private String MemberId;


    public MemberRecord() {
    }

    public MemberRecord(Long ItemOfferingDBId, Long MemberDBId, String grade) {
        this.ItemOfferingDBId = ItemOfferingDBId;
        this.MemberDBId = MemberDBId;
        this.grade = grade;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemOfferingDBId() {
        return ItemOfferingDBId;
    }

    public void setItemOfferingDBId(Long ItemOfferingDBId) {
        this.ItemOfferingDBId = ItemOfferingDBId;
    }

    public Long getMemberDBId() {
        return MemberDBId;
    }

    public void setMemberDBId(Long MemberDBId) {
        this.MemberDBId = MemberDBId;
    }

    public String getItemShortName() {
        return ItemShortName;
    }

    public void setItemShortName(String ItemShortName) {
        this.ItemShortName = ItemShortName;
    }

    public Integer getCrn() {
        return crn;
    }

    public void setCrn(Integer crn) {
        this.crn = crn;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

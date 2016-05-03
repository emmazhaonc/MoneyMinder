package gatech.Item.optimizer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 204069126 on 2/6/15.
 */
@Entity(name = "Period")
public class Period {

    public enum PeriodTerm {
        FALL,
        SPRING,
        SUMMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private PeriodTerm term;
    private int year;

    public Period() {
    }

    public Period(String year, String term) {
        this.year = Integer.valueOf(year);
        this.term = PeriodTerm.valueOf(term);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeriodTerm getTerm() {
        return term;
    }

    public void setTerm(PeriodTerm term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

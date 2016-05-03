package gatech.Item.optimizer.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by 204069126 on 3/16/15.
 */
@Entity(name = "MoneyMinder_solution")
public class MoneyMinderSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date computedTime;
    private String triggeredReason;
    private boolean isOffline;

    @OneToMany
    private Set<ItemOffering> MoneyMinder;

    @OneToOne
    private Period Period;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getComputedTime() {
        return computedTime;
    }

    public void setComputedTime(Date computedTime) {
        this.computedTime = computedTime;
    }

    public String getTriggeredReason() {
        return triggeredReason;
    }

    public void setTriggeredReason(String triggeredReason) {
        this.triggeredReason = triggeredReason;
    }

    public boolean isOffline() {
        return isOffline;
    }

    public void setOffline(boolean isOffline) {
        this.isOffline = isOffline;
    }

    public Set<ItemOffering> getMoneyMinder() {
        return MoneyMinder;
    }

    public void setMoneyMinder(Set<ItemOffering> MoneyMinder) {
        this.MoneyMinder = MoneyMinder;
    }

    public Period getPeriod() {
        return Period;
    }

    public void setPeriod(Period Period) {
        this.Period = Period;
    }
}

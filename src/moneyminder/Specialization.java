/**
 *
 */
package gatech.Item.optimizer.model;

import java.util.Set;

/**
 * @author John Raffensperger
 */
public class Specialization {

    private Set<Item> requiredItems;
    private Set<Item> coreItems;
    private Set<Item> electiveItems;
    private int numberOfCoreItemsRequired;
    private int numberOfElectiveItemsRequired;

    /**
     * @return the requiredItems
     */
    public Set<Item> getRequiredItems() {
        return requiredItems;
    }

    /**
     * @return the coreItems
     */
    public Set<Item> getCoreItems() {
        return coreItems;
    }

    /**
     * @return the electiveItems
     */
    public Set<Item> getElectiveItems() {
        return electiveItems;
    }

    /**
     * @return the numberOfCoreItemsRequired
     */
    public int getNumberOfCoreItemsRequired() {
        return numberOfCoreItemsRequired;
    }

    /**
     * @return the numberOfElectiveItemsRequired
     */
    public int getNumberOfElectiveItemsRequired() {
        return numberOfElectiveItemsRequired;
    }

    /**
     * @param requiredItems the requiredItems to set
     */
    public void setRequiredItems(Set<Item> requiredItems) {
        this.requiredItems = requiredItems;
    }

    /**
     * @param coreItems the coreItems to set
     */
    public void setCoreItems(Set<Item> coreItems) {
        this.coreItems = coreItems;
    }

    /**
     * @param electiveItems the electiveItems to set
     */
    public void setElectiveItems(Set<Item> electiveItems) {
        this.electiveItems = electiveItems;
    }

    /**
     * @param numberOfCoreItemsRequired the numberOfCoreItemsRequired to set
     */
    public void setNumberOfCoreItemsRequired(int numberOfCoreItemsRequired) {
        this.numberOfCoreItemsRequired = numberOfCoreItemsRequired;
    }

    /**
     * @param numberOfElectiveItemsRequired the numberOfElectiveItemsRequired to set
     */
    public void setNumberOfElectiveItemsRequired(int numberOfElectiveItemsRequired) {
        this.numberOfElectiveItemsRequired = numberOfElectiveItemsRequired;
    }


}

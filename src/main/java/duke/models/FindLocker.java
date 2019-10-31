package duke.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import duke.models.locker.Address;
import duke.models.locker.Locker;
import duke.models.locker.SerialNumber;
import duke.models.locker.Zone;

public class FindLocker {
    private final SerialNumber serialNumber;
    private final Address address;
    private final Zone zone;

    /**
     * FindLocker stores all the information required to find the matching locker.
     * There is not a need for NULL values.
     *
     * @param serialNumber stores the serial numbers associated with each locker
     * @param address      stores the location of the locker
     * @param zone         stores the zone to which the locker belongs
     */

    @JsonCreator
    public FindLocker(@JsonProperty("serial") SerialNumber serialNumber,
                  @JsonProperty("address") Address address,
                  @JsonProperty("zone") Zone zone) {
        this.serialNumber = serialNumber;
        this.address = address;
        this.zone = zone;
    }

    @JsonGetter("serial")
    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    @JsonGetter("address")
    public Address getAddress() {
        return address;
    }

    @JsonGetter("zone")
    public Zone getZone() {
        return zone;
    }

    /**
     * This function is used to compare the locker info with a locker that was searched.
     * This is used in conjunction with Java in-streams.
     *
     * @param comparingLocker stores the locker to be compared to.
     * @return refers to check if the comparison was true.
     */

    public boolean compare(Locker comparingLocker) {

        if (comparingLocker.getSerialNumber().equals(this.getSerialNumber())) {
            return true;
        }
        else if (comparingLocker.getAddress().equals(this.getAddress())) {
            return true;
        }
        else if (comparingLocker.getAddress().equals(this.getZone())){
            return true;
        }
        else{
            return false;
        }
    }
}

package at.htl.Entity;

import org.hibernate.annotations.NamedQuery;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NamedQuery(
        name = "Device.findAll",
        query = "select d from device d"
)

@Entity(name = "device")
public class Device {

    @JsonbProperty("deviceName")
    private String deviceName;

    @Id
    @GeneratedValue
    private Long id;

    // region constructor

    public Device() {
    }

    public Device(String name) {
        this.deviceName = name;
    }

    //endregion

    // region properties

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String device_name) {
        this.deviceName = device_name;
    }

    public Long getId() {
        return id;
    }
    // endregion


    @Override
    public String toString() {
        return "Device{" +
                "name='" + deviceName + '\'' +
                ", id=" + id +
                '}';
    }
}

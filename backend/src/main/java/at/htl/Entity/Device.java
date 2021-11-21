package at.htl.Entity;


import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity(name = "device")
@NamedQueries({
        @NamedQuery(
                name = "Device.findAll",
                query = "select d from device d"
        ),
        @NamedQuery(
                name = "Device.findPerName",
                    query = "select d from device d where d.deviceName LIKE :NAME"
        ),
        @NamedQuery(
                name ="Device.countByInitial",
                query = "select substring(d.deviceName,1,1), count(d) from device d group by substring(d.deviceName,1,1) "
        )

})
public class Device {

    @JsonbProperty("deviceName")
    @Column(name ="NAME", unique = true)
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

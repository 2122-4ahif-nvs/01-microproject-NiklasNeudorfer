package at.htl.Entity;


import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity(name = "BM_DEVICE")
@NamedQueries({
        @NamedQuery(
                name = "Device.findAll",
                query = "select d from BM_DEVICE d"
        ),
        @NamedQuery(
                name = "Device.findPerName",
                query = "select d from BM_DEVICE d where d.deviceName LIKE :NAME"
        ),
        @NamedQuery(
                name = "Device.countByInitial",
                query = "select substring(p.deviceName,1, 1), count(p) from BM_DEVICE p " +
                        "group by substring(p.deviceName,1, 1)"
        ),
        @NamedQuery(
                name = "Device.removeByName",
                query = "DELETE from BM_DEVICE d where d.deviceName = :NAME"
        )

})
public class Device {

    @JsonbProperty("deviceName")
    @Column(name ="D_NAME", unique = true)
    private String deviceName;

    @Id
    @GeneratedValue
    @Column(name = "D_ID")
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

package at.htl.entity;


import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


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
        ),
        @NamedQuery(
                name = "Device.findById",
                query = "select d from BM_DEVICE d where d.id = :ID"
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

    @JoinColumn(name = "D_OWNER")
    //@NotBlank(message = "every device needs a name")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonbTransient
    private Owner owner;

    @Column(name = "D_PRICE")
    @JsonbProperty("price")
    private BigDecimal price;


    // region constructor

    public Device() {
    }

    public Device(String name) {
        this.deviceName = name;
    }

    public Device(String name, BigDecimal price) {
        this.deviceName = name;
        this.price = price;
    }

    public Device(String name, Owner owner, BigDecimal price) {
        this.owner = owner;
        this.deviceName = name;
        this.price = price;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

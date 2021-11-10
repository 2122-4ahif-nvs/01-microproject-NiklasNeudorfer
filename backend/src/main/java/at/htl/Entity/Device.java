package at.htl.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
    private String name;
    @Id
    @GeneratedValue
    private Long id;

    // region constructor

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    //endregion

    // region properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    // endregion


    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

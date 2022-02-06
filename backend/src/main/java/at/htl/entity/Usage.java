package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
public class Usage extends PanacheEntity {

    public String usage;

    @OneToOne
    public Device device;

    @OneToOne
    public Room room;

    @Enumerated
    public Position position;

}

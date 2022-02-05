package at.htl.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Owner.findAll",
                query = "select o from Owner o"
        ),
        @NamedQuery(
                name = "Owner.findByLastName",
                query = "select o from Owner o where o.lastName = :LN"
        ),
        @NamedQuery(
                name = "Owner.removeByLastName",
                query = "DELETE from Owner o where o.lastName = :LN"
        ),
        @NamedQuery(
                name = "Owner.findByFullName",
                query = "select o from Owner o where o.lastName = :LN and o.firstName = :FN"
        )
})

@Entity
@Table(name = "BM_OWNER")
public class Owner {

    @Id
    @GeneratedValue
    @Column(name = "O_ID")
    private Long id;

    @Column(name = "O_FIRSTNAME")
    //@NotBlank(message = "The Owner needs a Firstname")
    private String firstName;

    @Column(name = "O_LASTNAME")
    //@NotBlank(message = "The Owner needs a Lastname")
    private String lastName;

    // region constructor

    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // endregion


    // region properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    // endregion
}

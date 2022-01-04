package at.htl.Control;

import at.htl.Entity.Owner;
import at.htl.Entity.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class OwnerRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Owner save(Owner owner) {
        return em.merge(owner);
    }

    public List<Owner> findAll() {
        return em.createNamedQuery("Owner.findAll",Owner.class).getResultList();
    }

    public List<Owner> findByLastName(String ln){
        TypedQuery<Owner> query = em
                .createNamedQuery("Owner.findByLastName",Owner.class)
                .setParameter("LN",ln);
        return query.getResultList();
    }

    @Transactional
    public void removeByLastLane(String ln){
        Query query = em
                .createNamedQuery("Owner.removeByLastName")
                .setParameter("LN",ln);
        query.executeUpdate();
    }

    public Owner findOwnerByFullName(String fn, String ln) {
        TypedQuery<Owner> query = em
                .createNamedQuery("Owner.findByFullName",Owner.class)
                .setParameter("FN",fn)
                .setParameter("LN",ln);
        return query.getSingleResult();
    }
}

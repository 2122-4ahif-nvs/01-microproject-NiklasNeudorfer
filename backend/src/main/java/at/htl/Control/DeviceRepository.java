package at.htl.Control;

import at.htl.Entity.Device;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DeviceRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Device save(Device device) {
        return em.merge(device);
    }


    public List<Device> findAll() {
        return em.createNamedQuery("Device.findAll",Device.class).getResultList();
    }

    public Device findOneByName(String name){
        TypedQuery<Device> query = em
                .createNamedQuery("Device.findPerName",Device.class)
                .setParameter("NAME",name);
        return query.getSingleResult();
    }

    public Map<Character, Integer> countByInitials(){
        Map<Character, Integer> result = new HashMap<>();
        Query query = em
                .createNamedQuery("Device.findPerName");
        List<Object[]> initials = query.getResultList();

        for (Object[] initial : initials) {
            System.out.println(initial);
            result.put(
                    initial[0].toString().charAt(0),
                    Integer.parseInt(initial[1].toString())
            );
        }

        return result;
    }

}


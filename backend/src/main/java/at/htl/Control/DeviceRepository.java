package at.htl.Control;

import at.htl.Entity.Device;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeviceRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Device save(Device device) {
        return em.merge(device);
    }
}


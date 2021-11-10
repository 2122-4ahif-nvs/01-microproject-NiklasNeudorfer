package at.htl.Entity;

import at.htl.Control.DeviceRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.common.constraint.Assert;
import org.jboss.logmanager.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DeviceTest {
    @Inject
    EntityManager em;

    @Inject
    DeviceRepository deviceRepository;

    @Test
    void createDevice(){
        Device device = new Device("Chromecast 4K");
        Device device1 = deviceRepository.save(device);
        System.out.println(device1);
        //fail();
    }
}
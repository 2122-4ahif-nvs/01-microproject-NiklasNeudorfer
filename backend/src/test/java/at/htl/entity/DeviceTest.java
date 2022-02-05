package at.htl.entity;

import at.htl.control.DeviceRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
class DeviceTest {
    @Inject
    EntityManager em;

    @Inject
    DeviceRepository deviceRepository;

    @Test
    void createAndRemoveDevice(){
        Device device = new Device("HP Laserjet");
        Device device1 = deviceRepository.save(device);
        System.out.println(device1);
        assertThat(device.getDeviceName()).isEqualTo(device1.getDeviceName());
        //fail();
        deviceRepository.removeDevice(device.getDeviceName());
        assertThat(deviceRepository.findAll().size()).isEqualTo(1);
    }
}
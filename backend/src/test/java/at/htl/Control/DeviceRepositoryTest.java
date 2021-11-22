package at.htl.Control;

import at.htl.Entity.Device;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.Query;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DeviceRepositoryTest {

    @Inject
    DeviceRepository repo;

    @Test
    void findPersonByName_ok() {
        Device device = repo.findOneByName("Chromecast 4K");
        assertThat(device.getDeviceName()).isEqualTo("Chromecast 4K");
    }

    @Test
    void countPerInitial_ok() {
        Map<Character, Integer> result = repo.countByInitial();
        for (Map.Entry<Character, Integer> e : result.entrySet()) {
            out.printf("%s - %d\n", e.getKey(), e.getValue());
        }
        assertThat(result.size()).isEqualTo(1);
    }

}
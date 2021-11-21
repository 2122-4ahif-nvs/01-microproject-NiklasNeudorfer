package at.htl.Control;

import at.htl.Entity.Device;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DeviceRepositoryTest {

    @Inject
    DeviceRepository repo;

    @Test
    void findOneByName_ok(){
        Device device = repo.findOneByName("Chromecast 4k");
        //assertThat(device.getDeviceName().isEqalTo("Chromecast 4k"));
    }

    @Test
    void countPerInitial_ok(){
        Map<Character, Integer> result = repo.countByInitials();
        //result.forEach(out::println);

        //assertThat(result.size()).isEqualTo(17);

        for (Map.Entry<Character, Integer> e : result.entrySet()) {
            System.out.printf("%s %d \n", e.getKey(), e.getValue());
        }
    }

}
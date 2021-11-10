package at.htl.Control;

import at.htl.Entity.Device;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    DeviceRepository deviceRepository;

    void init(@Observes StartupEvent event) {
        Device d = new Device("Chromecast 4K");
        deviceRepository.save(d);
    }
}

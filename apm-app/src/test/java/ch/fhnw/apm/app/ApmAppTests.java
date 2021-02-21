package ch.fhnw.apm.app;

import ch.fhnw.apm.app.storage.Storage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApmAppTests {

    @Autowired
    private Storage storage;

    @Test
    void contextLoads() {
        assertThat(storage).isNotNull();
    }
}

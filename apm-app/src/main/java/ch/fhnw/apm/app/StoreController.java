package ch.fhnw.apm.app;

import ch.fhnw.apm.app.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class StoreController {

    private final Storage storage;

    Logger logger = LoggerFactory.getLogger(StoreController.class);

    public StoreController(Storage storage) {
        this.storage = storage;
    }

    @GetMapping("/store/{key}")
    public ResponseEntity<String> load(@PathVariable int key) {
        logger.info(String.format("GET %d", key));
        return ResponseEntity.of(Optional.ofNullable(storage.load(key)));
    }

    @PutMapping("/store/{key}")
    public ResponseEntity<Void> store(@PathVariable int key,
                                      @RequestBody(required = false) String value) {
        logger.info(String.format("PUT into %d value %s", key, value));
        storage.store(key, value);
        return ResponseEntity.noContent().build();
    }
}

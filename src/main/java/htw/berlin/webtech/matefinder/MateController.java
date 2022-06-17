package htw.berlin.webtech.matefinder;

import htw.berlin.webtech.matefinder.api.Mate;
import htw.berlin.webtech.matefinder.api.MateManipulationRequest;
import htw.berlin.webtech.matefinder.persistence.MateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MateController {

    private final MateService mateService;

    public MateController(MateService mateService) {
        this.mateService = mateService;
    }


    @GetMapping(path = "/api/mates")
    public ResponseEntity<List<Mate>> fetchMates() {
        return ResponseEntity.ok(mateService.findAll());
    }

    @GetMapping(path = "/api/mate/{id}")
    public ResponseEntity<Mate> fetchMatebyId(@PathVariable Long id) {
        var mate = mateService.findById(id);
        return mate != null? ResponseEntity.ok(mate) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/mate")
    public ResponseEntity<Void> createMate(@RequestBody MateManipulationRequest request) throws URISyntaxException {
        var mate = mateService.create(request);
        URI uri = new URI("/api/mate/" + mate.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/mate/{id}")
    public ResponseEntity<Mate> updateMate(@PathVariable Long id,@RequestBody MateManipulationRequest request) {
        var mate = mateService.update(id, request);
        return mate != null? ResponseEntity.ok(mate) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/mate/{id}")
    public ResponseEntity<Void> deleteMate(@PathVariable Long id) {
        boolean succesful = mateService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }
}
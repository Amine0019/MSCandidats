package tn.esprit.mscandidats.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mscandidats.Entities.Candidat;
import tn.esprit.mscandidats.Services.CandidatService;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatController {

    @Autowired
    DataSource dataSource;

    private String title = "Hello FROM MS Candidat";

    @RequestMapping("/hello")
    private String sayhello() {
        return title;
    }

    @GetMapping("/db-info")
    public String getDbInfo() throws Exception {
        return dataSource.getConnection().getMetaData().getDatabaseProductName();
    }

    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public ResponseEntity<List<Candidat>> getListCandid() {
        List<Candidat> candidats = candidatService.getAll();
        if (candidats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(candidats);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable("id") int id,
                                                   @RequestBody Candidat candidat) {
        return ResponseEntity.ok(candidatService.updateCandidat(id, candidat));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidat(@PathVariable("id") int id){
        return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
    }



}

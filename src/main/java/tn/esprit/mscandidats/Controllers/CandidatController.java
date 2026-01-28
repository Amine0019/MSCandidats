package tn.esprit.mscandidats.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

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


}

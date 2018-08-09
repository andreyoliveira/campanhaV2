package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Campanha;
import br.com.conceptmx.campanhaV2.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceCampanha")
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @RequestMapping(value = "/incluir",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Campanha> salvar(@RequestBody Campanha campanha){
        try {
            Campanha c =  this.campanhaRepository.save(campanha);

            HttpHeaders header = new HttpHeaders();
            header.add("campanha", "campanha");

            return ResponseEntity.status(201).headers(header).body(c);
        } catch(Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/alterar",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Campanha> alterar(@RequestBody Campanha campanha){
        try {
            Campanha c =  this.campanhaRepository.save(campanha);

            HttpHeaders header = new HttpHeaders();
            header.add("campanha", "campanha");

            return ResponseEntity.status(201).headers(header).body(c);
        } catch(Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/excluir/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity excluir(@PathVariable Long id){
        try {
            HttpHeaders header = new HttpHeaders();
            header.add("campanha", "campanha");

            this.campanhaRepository.deleteById(id);
            return ResponseEntity.status(204).headers(header).body(new Campanha());
        } catch(Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/getPorId/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Campanha> getCampanhaPorId(@PathVariable Long id){

        HttpHeaders header = new HttpHeaders();
        header.add("campanha", "campanha");

        Campanha c = this.campanhaRepository.getCampanhaPorId(id);

        return ResponseEntity.status(200).headers(header).body(c);
    }

    @RequestMapping(value = "/getTodasCampanhas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Campanha>> getTodasCampanhas(){

        HttpHeaders header = new HttpHeaders();
        header.add("campanha", "campanha");

        List<Campanha> campanhas = this.campanhaRepository.getTodasCampanhas();

        return ResponseEntity.status(200).headers(header).body(campanhas);
    }
}

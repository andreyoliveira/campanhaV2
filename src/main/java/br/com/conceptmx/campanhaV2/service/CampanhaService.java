package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Campanha;
import br.com.conceptmx.campanhaV2.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Campanha salvar(@RequestBody Campanha campanha){
        try {
            return this.campanhaRepository.save(campanha);
        } catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/excluir",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void excluir(@RequestBody Long id){
        try {
            this.campanhaRepository.deleteById(id);
        } catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/getPorId",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Campanha getCampanhaPorId(@RequestBody Long id){
        return this.campanhaRepository.getCampanhaPorId(id);
    }

    @RequestMapping(value = "/getTodasCampanhas",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Campanha> getTodasCampanhas(){
        return this.campanhaRepository.getTodasCampanhas();
    }
}

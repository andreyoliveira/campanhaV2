package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Time;
import br.com.conceptmx.campanhaV2.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceTime")
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @RequestMapping(value = "/incluir",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Time> salvar(@RequestBody Time time){
        try {
            HttpHeaders header = new HttpHeaders();
            header.add("time", "time");

            Time t =  this.timeRepository.save(time);

            return ResponseEntity.status(201).headers(header).body(t);
        } catch(Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/alterar",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Time> alterar(@RequestBody Time time){
        try {
            HttpHeaders header = new HttpHeaders();
            header.add("time", "time");

            Time t =  this.timeRepository.save(time);

            return ResponseEntity.status(201).headers(header).body(t);
        } catch(Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/excluir/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity excluir(@PathVariable Long id){
        try{
            HttpHeaders header = new HttpHeaders();
            header.add("time", "time");

            this.timeRepository.deleteById(id);
            return ResponseEntity.status(204).headers(header).body(new Time());
        } catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/getPorId/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Time> getTimePorId(@PathVariable Long id){

        HttpHeaders header = new HttpHeaders();
        header.add("time", "time");

        Time t = this.timeRepository.getTimePorId(id);

        return ResponseEntity.status(200).headers(header).body(t);
    }

    @RequestMapping(value = "/getTodosTimes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Time>> getTodosTimes(){

        HttpHeaders header = new HttpHeaders();
        header.add("time", "time");

        List<Time> times = this.timeRepository.getTodosTimes();

        return ResponseEntity.status(200).headers(header).body(times);
    }
}

package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Time;
import br.com.conceptmx.campanhaV2.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Time salvar(@RequestBody Time time){
        try {
            return this.timeRepository.save(time);
        } catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/excluir",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void excluir(@RequestBody Long id){
        try{
            this.timeRepository.deleteById(id);
        } catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/getPorId",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Time getTimePorId(@RequestBody Long id){
        return this.timeRepository.getTimePorId(id);
    }

    @RequestMapping(value = "/getTodosTimes",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Time> getTodosTimes(){
        return this.timeRepository.getTodosTimes();
    }
}

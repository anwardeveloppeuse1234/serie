package com.example.series.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.series.entities.Serie;
import com.example.series.service.SerieService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class SerieRESTController {
@Autowired
SerieService serieService;
@RequestMapping(method = RequestMethod.GET)
public List<Serie> getAllSeries() {
return serieService.getAllSeries();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Serie getSerieById(@PathVariable("id") Long id) {
return serieService.getSerie(id);
 }
@RequestMapping(method = RequestMethod.POST)
public Serie createSerie(@RequestBody Serie serie) {
return serieService.saveSerie(serie);
}
@RequestMapping(method = RequestMethod.PUT)
public Serie updateSerie(@RequestBody Serie serie) {
return serieService.updateSerie(serie);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteSerie(@PathVariable("id") Long id)
{
serieService.deleteSerieById(id);
}
@RequestMapping(value="/sersgen/{idGen}",method = RequestMethod.GET)
public List<Serie> getSeriesByGenId(@PathVariable("idGen") Long idGen) {
return serieService.findByGenreIdGen(idGen);
}
}

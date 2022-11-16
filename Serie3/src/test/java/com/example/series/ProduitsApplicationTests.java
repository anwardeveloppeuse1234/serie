package com.example.series;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.series.entities.Genre;
import com.example.series.entities.Serie;
import com.example.series.repos.SerieRepository;
import com.example.series.service.SerieService;
@SpringBootTest
class SeriesApplicationTests {
@Autowired
private SerieRepository serieRepository;

@Autowired
private SerieService serieService;

@Test
public void testCreateSerie() {
Serie ser = new Serie("The Wire",2200.500,new Date());
serieRepository.save(ser);
}
@Test
public void testFindSerie()
{
Serie s = serieRepository.findById(1L).get(); 
System.out.println(s);
}
@Test
public void testUpdateSerie()
{
Serie s = serieRepository.findById(1L).get();
s.setPrixSerie(1000.0);
serieRepository.save(s);
}
@Test
public void testDeleteSerie()
{
serieRepository.deleteById(1L);;
}
 
@Test
public void testListerTousSeries()
{
List<Serie> sers = serieRepository.findAll();
for (Serie s :sers)
{
System.out.println(s);
}
}
@Test
public void testFindByNomSerieContains()
{
Page<Serie> sers = serieService.getAllSeriesParPage(0,2);
System.out.println(sers.getSize());
System.out.println(sers.getTotalElements());
System.out.println(sers.getTotalPages());
sers.getContent().forEach(s -> {System.out.println(s.toString());
 });
/*ou bien
for (Serie s : sers.getContent()
{
System.out.println(s);
} */
}
@Test
public void testFindByNomSerie()
{
List<Serie> sers = serieRepository.findByNomSerie("Clavier");
for (Serie s: sers)
{
System.out.println(s);
}
}
@Test
public void findByNomSerieContains()
{
List<Serie> sers=serieRepository.findByNomSerieContains("P");
for (Serie s : sers)
{
System.out.println(s);
} }
@Test
public void testfindByNomPrix()
{
List<Serie> sers = serieRepository.findByNomPrix("iphone X", 1000.0);
for (Serie s : sers)
{ 
System.out.println(s);
}
}

@Test
public void testfindByGenre()
{
Genre gen = new Genre();
gen.setIdGen(1L);
List<Serie> sers = serieRepository.findByGenre(gen);
for (Serie s : sers)
{
System.out.println(s);
}
}
@Test
public void findByGenreIdGen()
{
List<Serie> sers = serieRepository.findByGenreIdGen(1L);
for (Serie s: sers)
{
System.out.println(s);
}
 }
@Test
public void testfindByOrderByNomSerieAsc()
{
List<Serie> sers = 
serieRepository.findByOrderByNomSerieAsc();
for (Serie s : sers)
{
System.out.println(s);
}
}
@Test
public void testTrierSeriesNomsPrix()
{
List<Serie> sers= serieRepository.trierSeriesNomsPrix();
for (Serie s : sers)
{
System.out.println(s);
}
}
}

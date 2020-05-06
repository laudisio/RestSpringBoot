package br.usjt.tempo.model.resources;


import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.tempo.model.repository.CidadeRepository;
import br.usjt.tempo.model.*;

@RestController
public class CidadeResource {
	
	@Autowired
	private CidadeRepository cidadeRepo;

	
	
	@GetMapping ("/lista")
	public List <Cidade> todosOsLivros (){
		return cidadeRepo.findAll();
	}
	
	
	@PostMapping ("/salvar")
	public ResponseEntity<Cidade> salvar ( @RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade l = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).body(l);
	}
	
	@GetMapping ("/cidade/latitude/{latitude}")
	public Cidade buscarLatitude (@PathVariable Long latitude) {
		return (Cidade) cidadeRepo.getFromLatitude(latitude);
	}
	
	@GetMapping ("/cidade/longitude/{longitude}")
	public Cidade buscarlongitude (@PathVariable Long longitude) {
		return (Cidade) cidadeRepo.getFromLongitude(longitude);
	}
	
	
	@GetMapping ("/{Letra}")
		public Cidade buscarLetra (@PathVariable Long letra) {
		return cidadeRepo.getOne(letra);
	}
	
	
}

	
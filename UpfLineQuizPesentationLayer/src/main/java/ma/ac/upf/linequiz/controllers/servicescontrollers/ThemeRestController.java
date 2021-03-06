package ma.ac.upf.linequiz.controllers.servicescontrollers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.upf.linequiz.dao.entities.ThemeEntity;
import ma.ac.upf.linequiz.services.businessservices.ThemeService;

/*JSONS SESPONCE*/
@RestController
@Transactional
@RequestMapping("themes") // API >>Important>> https://www.youtube.com/watch?v=2JPJ1OOVT3E
public class ThemeRestController {

	@Autowired
	private ThemeService service;
	
	// Retourne une liste d'objet sous foma JSON
	@GetMapping 
	public List<ThemeEntity> getAll() {
		return service.getAll().get();	
	}
	
	@GetMapping("/{id}")
	public ThemeEntity getById(@PathVariable String id) {
		return service.getById(Long.parseLong(id)).get();	
	}
	
	@PostMapping("/")
	public void save(@RequestBody ThemeEntity obj) {
		service.save(obj);
	}
	
	// Renvoie touts les attributs pour la mise à jour
	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody ThemeEntity obj) {
		service.save(obj);
	}
	
	/*
	// Renvoie que les attributs modifié 
	@PatchMapping("/{id}")
	public void liteUpdate(@PathVariable String id, @RequestBody Map obj) {
		//service.save(obj);
	}*/
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		//service.de(Long.parseLong(id));
	}
	
}

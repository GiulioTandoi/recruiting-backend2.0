package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.entities.Response;
import it.recruiting.sviluppo.repos.HomeRepository;
import it.recruiting.sviluppo.utility.EncodeImage;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class HomeController {

	@Autowired
	HomeRepository repo;

	EncodeImage encoder = new EncodeImage();

	@GetMapping(path = "home")
	public Response home() throws SQLException {

		ArrayList<Profilo> listaProfiliHome = new ArrayList<Profilo>();
		listaProfiliHome = repo.findAll();

		// Serve per sostituire la path all'immagine di profilo con il base64
		// dell'immagine che poi il frontend deve decodificare
		for (int p = 0; p < listaProfiliHome.size(); p++) {
			listaProfiliHome.get(p).setImage(encoder.encode(listaProfiliHome.get(p).getImage()));
		}
		Response response = new Response(listaProfiliHome.size(), listaProfiliHome);

		return response;

	}

	@GetMapping(path = "search")
	public Response search(@RequestParam("value") String value) throws SQLException {
		ArrayList<Profilo> profili = new ArrayList<Profilo>();
		System.out.println("====================================================================================");
		System.out.println("Valore Passato " + value);

		Response response = null;

		profili = repo.findByNomeOrCognomeOrQualificaIsContaining(value);

		System.out.println(profili);

		if (profili == null) {
			profili = repo.findAll();
			for (int p = 0; p < profili.size(); p++) {
				profili.get(p).setImage(encoder.encode(profili.get(p).getImage()));
				System.out.println(profili.get(p).getImage());
			}
			response = new Response(profili.size(), profili);
		} else {
			for (int p = 0; p < profili.size(); p++) {
				profili.get(p).setImage(encoder.encode(profili.get(p).getImage()));
				System.out.println(profili.get(p).getImage());
			}
			response = new Response(profili.size(), profili);
		}
		return response;
	}

}

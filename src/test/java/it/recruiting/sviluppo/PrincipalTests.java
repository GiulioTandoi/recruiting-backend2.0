package it.recruiting.sviluppo;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.entities.Selezionatore;
import it.recruiting.sviluppo.pojo.AggiuntaPreferitoPojo;
import it.recruiting.sviluppo.repos.HomeRepository;
import it.recruiting.sviluppo.services.ProfiloService;
import it.recruiting.sviluppo.services.SelezionatoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Principal.class})
public class PrincipalTests {
	
	@Autowired
	SelezionatoreService selezionatoreService;
	
	@Autowired
	ProfiloService profiloService;

	@Autowired
	HomeRepository homeRepo;
	
	Selezionatore selezionatore = new Selezionatore("Utente", "Prova", "utente@prova.it", "", "Passw0rd");
	
	String email = "tandoigiulio9@live.com";
	String password = "ciaociao";
	
	private int idSelezionatore = 1;
	private int idProfilo = 1;
	AggiuntaPreferitoPojo pPojo = new AggiuntaPreferitoPojo(idSelezionatore, idProfilo);
	@BeforeClass
	public static void initClass() {
		System.out.println("initClass()");
	}

	@AfterClass
	public static void endClass() {
		System.out.println("endClass()");
	}

	@Before
	public void initMethod() {
		System.out.println("initMethod()");
	}

	@After
	public void endMethod() {
		System.out.println("end Method");
	}

	@Test
	public void testLogin() {
		System.out.println(" ========================================= Test Login ========================================================");
		try {
			assertTrue(selezionatoreService.login(email, password) > 0);
		} catch (Exception e) {
			System.out.println("Utente non trovato");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRegistration() {
		System.out.println(" ========================================= Test Registration ========================================================");
		assertTrue(selezionatoreService.registration(selezionatore));
	}

	@Test
	public void testAddFavourite() {
		System.out.println(" ========================================= Test Add Favourite ========================================================");
		assertTrue(profiloService.insertInListaPreferiti(pPojo));
	}
	
	@Test
	public void testSearch () {
		System.out.println(" ========================================= Test Search ========================================================");
		assertTrue( homeRepo.findByNomeOrCognomeOrQualificaIsContaining("Sofia").get(0) instanceof Profilo );
	}
	
//	@Test
//	public void test2() {
//		System.out.println("Test 2");
//		assertTrue(false);
//	}
//
//	@Test
//	public void test3() throws Exception {
//		System.out.println("Test 3");
//		throw new Exception();
//	}
//
//	@Test(timeout = 100)
//	public void xyzTesting() throws InterruptedException {
//		System.out.println("Test xyzTesting");
//		// fallirà per timeout scaduto
//		Thread.sleep(200);
//		assertTrue(true);
//	}
//
//	@Test(expected = java.lang.Exception.class)
//	public void nuovoTest() throws Exception {
//		System.out.println("Test nuovoTest");
//		assertTrue(true);
//		throw new Exception();
//	}

}
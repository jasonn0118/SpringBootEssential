package com.example.ec;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.enumeration.Room;
import com.example.ec.service.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.example.ec.ExplorecaliApplication.TourFromFile.importTours;

/**
 * Main Class for the Spring Boot Application
 *
 * Created by Mary Ellen Bowman
 */
@SpringBootApplication
public class ExplorecaliApplication implements CommandLineRunner {
//
	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;

	@Autowired
	private PastorService pastorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PastorDepartmentService pastorDepartmentService;

	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}

	/**
	 * Method invoked after this class has been instantiated by Spring container
	 * Initializes the in-memory database with all the TourPackages and Tours.
	 *
	 * @param strings
	 * @throws Exception if problem occurs.
     */
	@Override
	public void run(String... strings) throws Exception {
		pastorService.createPastor(1L, LocalDate.of(2000,01,01),1);
//		pastorService.createPastor(2L,LocalDate.of(2000,01,02),2);
//		pastorService.createPastor(3L, LocalDate.of(2000,01,03),3);
//		pastorService.createPastor(4L,LocalDate.of(2000,02,04),4);

		departmentService.createDepartment(1L,LocalDate.of(2000,02,01),"Jason", Room.AHall);
//		departmentService.createDepartment(2L,LocalDate.of(2000,02,02),"Jay");
//		departmentService.createDepartment(3L,LocalDate.of(2000,02,03),"Lucy");
//		departmentService.createDepartment(4L,LocalDate.of(2000,02,04),"Keith");

		pastorDepartmentService.createPastorDepartment(1L,LocalDate.of(1990,01,01),LocalDate.of(1991,01,01),LocalDate.of(1991,12,31));


				//Create the default tour packages
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
		System.out.println("Number of tours packages =" + tourPackageService.total());

		//Persist the Tours to the database
		importTours().forEach(t-> tourService.createTour(
				t.title,
				t.description,
				t.blurb,
				Integer.parseInt(t.price),
				t.length,
				t.bullets,
				t.keywords,
				t.packageType,
				Difficulty.valueOf(t.difficulty),
				Region.findByLabel(t.region)));
		System.out.println("Number of tours =" + tourService.total());


	}

	/**
	 * Helper class to import the records in the ExploreCalifornia.json
	 */
	static class TourFromFile {
		//attributes as listed in the .json file
		private String packageType, title, description, blurb, price, length, bullets, keywords,  difficulty, region;

		/**
		 * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
		 *
		 * @return a List of TourFromFile objects.
		 * @throws java.io.IOException if ObjectMapper unable to open file.
         */
		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),new TypeReference<List<TourFromFile>>(){});
		}
	}

}

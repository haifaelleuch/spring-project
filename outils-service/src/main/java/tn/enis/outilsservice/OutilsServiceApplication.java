package tn.enis.outilsservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enis.outilsservice.dao.OutilRepository;
import tn.enis.outilsservice.entity.Outil;
import tn.enis.outilsservice.service.IOutilService;

import java.util.Date;

@AllArgsConstructor
@SpringBootApplication
public class OutilsServiceApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(OutilsServiceApplication.class, args);
	}

     OutilRepository outilRepository;
	IOutilService outilService;
	@Override
	public void run(String... args) throws Exception {
		Outil outil1=Outil.builder()
				.date(new Date())
				.source("hufuf")
				.build();
		outilRepository.save(outil1);

		 Outil out1= outilRepository.findById(1L).get();
		System.out.println(out1.getSource());
	}
}

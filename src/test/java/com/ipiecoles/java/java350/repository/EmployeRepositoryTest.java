package com.ipiecoles.java.java350.repository;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.repository.EmployeRepository;

@SpringBootTest

public class EmployeRepositoryTest {
	
	@Autowired
	EmployeRepository employeRepository;
	
	@BeforeEach
	@AfterAll
	public void setup() {
		employeRepository.deleteAll();
	}
	
	@Test
	public void testFindLastMatricule() {
	
	//Given
	Employe employe1 = employeRepository.save(new Employe("Jack", "Jacjie", "M12345", LocalDate.now(), 1500d, 1, 1.0));
	Employe employe2 = employeRepository.save(new Employe("Jack", "Jackie", "T02345", LocalDate.now(), 1500d, 1, 1.0));	
	
	//When
	String lastMatricule = employeRepository.findLastMatricule();
	
	//Then
	Assertions.assertThat(lastMatricule).isEqualTo("12345");
	}
}

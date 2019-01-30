package com.sergiu.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sergiu.Application;
import com.sergiu.entity.CandidateEntity;
import com.sergiu.entity.HallEntity;
import com.sergiu.entity.SupervisorEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ServerJPAIntegrationTest {

	@Autowired
	private SupervisorRepository supervisorRepository;

	@Autowired
	private HallRepository hallRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void givenSupervisorEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		SupervisorEntity entity = new SupervisorEntity();
		entity.setId(1);
		entity.setFirstName("firtsName");
		entity.setMiddleName("middleName");
		entity.setLastName("lastName");
		SupervisorEntity expected = supervisorRepository.save(entity);
		Optional<SupervisorEntity> foundEntity = supervisorRepository.findById(expected.getId());
		assertNotNull(foundEntity);
		assertEquals(expected, foundEntity.get());
		supervisorRepository.delete(foundEntity.get());
	}

	@Test
	public void givenHallEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		HallEntity entity = new HallEntity();
		entity.setId(2);
		entity.setName("C308");
		entity.setUtilizableSize(25);
		entity.setSize(50);
		HallEntity expected = hallRepository.save(entity);
		Optional<HallEntity> foundEntity = hallRepository.findById(expected.getId());
		assertNotNull(foundEntity);
		assertEquals(expected, foundEntity.get());
		hallRepository.delete(foundEntity.get());
	}

	@Test
	public void givenCandidateEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		CandidateEntity entity = new CandidateEntity();
		entity.setId(3);
		entity.setCnp("1940122374514");
		entity.setFirstName("Test First Name");
		entity.setLastName("Test Last Name");
		entity.setHighSchool("Liceul Teoretic Emil Racovita");
		entity.setCategory(categoryRepository.findById("MRA").get());
		CandidateEntity expected = candidateRepository.save(entity);
		Optional<CandidateEntity> foundEntity = candidateRepository.findById(expected.getId());
		assertNotNull(foundEntity);
		assertEquals(expected, foundEntity.get());
		candidateRepository.delete(foundEntity.get());
	}
}

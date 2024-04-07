package com.depollo.engineering;

import com.depollo.engineering.dto.ProjectRequest;
import com.depollo.engineering.dto.ProjectResponse;
import com.depollo.engineering.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EngineeringApplicationTests {

	@Autowired
	private ProjectService service;


	@Test
	void testCreateProject() {
		 ProjectRequest request = new ProjectRequest(null, "Project 1", 100.0f, "Project 1 description");
		 ProjectResponse response = service.create(request);

		 assertEquals(request.name(), response.getName());
		 assertEquals(request.value(), response.getValue());
		 assertEquals(request.description(), response.getDescription());

	}



	@Test
	void testUpdateProject() {
		ProjectRequest request = new ProjectRequest(null, "Project 1", 100.0f, "Project 1 description");
		ProjectResponse response = service.create(request);

		ProjectRequest updateRequest = new ProjectRequest(response.getId(), "Project 2", 200.0f, "Project 2 description");

		ProjectResponse updateResponse = service.update(updateRequest);
		assertEquals(updateRequest.name(), updateResponse.getName());
		assertEquals(updateRequest.value(), updateResponse.getValue());
		assertEquals(updateRequest.description(), updateResponse.getDescription());

	}

	@Test
	void testDeleteProject() {
		ProjectRequest request = new ProjectRequest(null, "Project 1", 100.0f, "Project 1 description");
		ProjectResponse response = service.create(request);
		service.delete(response.getId().toString());
	}

	@Test
	void testGetProject() {
		ProjectRequest request = new ProjectRequest(null, "Project 1", 100.0f, "Project 1 description");
		ProjectResponse response = service.create(request);
		ProjectResponse getResponse = service.get(response.getId().toString());
		assertEquals(response.getId(), getResponse.getId());
		assertEquals(response.getName(), getResponse.getName());
		assertEquals(response.getValue(), getResponse.getValue());
		assertEquals(response.getDescription(), getResponse.getDescription());
	}
}

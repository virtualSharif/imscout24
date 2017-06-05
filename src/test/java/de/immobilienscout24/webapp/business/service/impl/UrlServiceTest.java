package de.immobilienscout24.webapp.business.service.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.immobilienscout24.webapp.business.dto.StatusDTO;
import de.immobilienscout24.webapp.business.enums.ErrorCodes;
import de.immobilienscout24.webapp.business.service.UrlService;
import de.immobilienscout24.webapp.rest.exception.BadRequestException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlServiceTest {

	@Autowired
	private UrlService urlService;

	private final String unreachableUrl = "http://www.qwertytesturl.com";
	private final String blankUrl = "";

	@Test
	public void checkDependencyInjection() {
		assertThat(urlService, instanceOf(UrlService.class));
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsInvalidWhileAnalyse() {
		try {
			urlService.analyse(blankUrl);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.INPUT_URL_INVALID));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsInvalidWhileGetStatus() {
		try {
			urlService.analyse(blankUrl);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.INPUT_URL_INVALID));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsUnreachableWhileAnalyse() {
		try {
			urlService.analyse(unreachableUrl);
			fail();
		} catch (BadRequestException e) {
			System.out.println(e.getStatusDTO());
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsUnreachableWhileGetStatus() {
		try {
			urlService.getStatus(unreachableUrl);
			fail();
		} catch (BadRequestException e) {
			System.out.println(e.getStatusDTO());
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR));
		}
	}
}
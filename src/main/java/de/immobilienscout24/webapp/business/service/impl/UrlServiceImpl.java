package de.immobilienscout24.webapp.business.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.immobilienscout24.webapp.business.constants.Constants;
import de.immobilienscout24.webapp.business.dto.HeadingTagDTO;
import de.immobilienscout24.webapp.business.dto.UrlStatusDTO;
import de.immobilienscout24.webapp.business.dto.StatusDTO;
import de.immobilienscout24.webapp.business.dto.UrlAnalysisDTO;
import de.immobilienscout24.webapp.business.enums.ErrorCodes;
import de.immobilienscout24.webapp.business.enums.HeadingTag;
import de.immobilienscout24.webapp.business.service.UrlService;
import de.immobilienscout24.webapp.rest.exception.BadRequestException;

@Service
public class UrlServiceImpl implements UrlService {

	private static final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);

	@Override
	public UrlAnalysisDTO analyse(String url) {
		validateInput(url);
		try {
			return parse(url);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new BadRequestException(new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR));
		}
	}

	@Override
	public UrlStatusDTO getStatus(String url) {
		validateInput(url);
		try {
			Response response = Jsoup.connect(url).execute();
			return new UrlStatusDTO(url, new StatusDTO(response.statusCode(), response.statusMessage()));
		} catch (HttpStatusException e) {
			logger.error(e.getMessage());
			return new UrlStatusDTO(url, new StatusDTO(e.getStatusCode(), e.getMessage()));
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new BadRequestException(new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR));
		}
	}

	private UrlAnalysisDTO parse(String url) throws IOException {
		Document document = Jsoup.connect(url).get();
		String pageTitle = document.title();
		String htmlVersion = getHtmlVersion(document);
		Boolean loginForm = isLoginFormPresent(document);
		Elements headingTagElements = document.select(Constants.HEADING_TAGS);
		Elements linkElements = document.select("a[href]");
		Elements externalLinkElements = getExternalLinkElements(document);

		return createUrlAnalysisDTO(htmlVersion, pageTitle, loginForm, linkElements, externalLinkElements,
				headingTagElements);
	}

	private Elements getExternalLinkElements(Document document) {
		document.select("a[href^=" + document.baseUri() + "]").remove();
		return document.select("a[href^=http]");
	}

	private boolean isLoginFormPresent(Document document) {
		Elements inputTypePasswordElements = document.select("input[type=password]");
		if (inputTypePasswordElements != null
				&& inputTypePasswordElements.size() == Constants.COUNT_OF_INPUT_TYPE_PASSWORD) {
			return true;
		}
		return false;
	}

	private List<UrlStatusDTO> createLinkDTOs(Elements linkElements) {
		return linkElements.stream()
				.filter(element -> StringUtils.isNotBlank(element.attr("href")))
				.map(element -> new UrlStatusDTO(element.attr("href")))
				.collect(Collectors.toList());
	}

	private List<HeadingTagDTO> getHeadingTagDTOs(Elements headingTagElements) {
		return Stream.of(HeadingTag.values())
				.map(headingTag -> new HeadingTagDTO(headingTag, headingTagElements.select(headingTag.getHeadingTagName()).size()))
				.collect(Collectors.toList());
	}

	private String getHtmlVersion(Document document) {
		List<Node> nodes = document.childNodes();
		return nodes.stream()
				.filter(node -> node instanceof DocumentType)
				.map(this::generateHtmlVersion)
				.collect(Collectors.joining());
	}

	private String generateHtmlVersion(Node node) {
		DocumentType documentType = (DocumentType) node;
		String htmlVersion = documentType.attr("publicid");
		return "".equals(htmlVersion) ? Constants.HTML_5_VERSION : htmlVersion;
	}

	private void validateInput(String url) {
		UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
		if (!urlValidator.isValid(url)) {
			logger.error(ErrorCodes.INPUT_URL_INVALID.toString());
			throw new BadRequestException(new StatusDTO(ErrorCodes.INPUT_URL_INVALID));
		}
	}

	private UrlAnalysisDTO createUrlAnalysisDTO(String htmlVersion, String pageTitle, Boolean loginFormPresent,
			Elements linkElements, Elements externalLinkElements, Elements headingTags) {

		UrlAnalysisDTO urlAnalysisDTO = new UrlAnalysisDTO();
		List<UrlStatusDTO> externalLinkDTOs = createLinkDTOs(externalLinkElements);
		linkElements.removeAll(externalLinkElements);
		List<UrlStatusDTO> internalLinkDTOs = createLinkDTOs(linkElements);

		urlAnalysisDTO.setHtmlVersion(htmlVersion);
		urlAnalysisDTO.setPageTitle(pageTitle);
		urlAnalysisDTO.setLoginForm(loginFormPresent);
		urlAnalysisDTO.setHeadingTagDTOs(getHeadingTagDTOs(headingTags));
		urlAnalysisDTO.setInternalLinkDTOs(internalLinkDTOs);
		urlAnalysisDTO.setNoOfInternalLinks(internalLinkDTOs.size());
		urlAnalysisDTO.setExternalLinkDTOs(externalLinkDTOs);
		urlAnalysisDTO.setNoOfExternalLinks(externalLinkDTOs.size());
		return urlAnalysisDTO;
	}

}

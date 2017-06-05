package de.immobilienscout24.webapp.business.dto;

import java.util.List;

import lombok.Data;

@Data
public class UrlAnalysisDTO {

	private String pageTitle;
	private String htmlVersion;
	private Integer noOfInternalLinks;
	private Integer noOfExternalLinks;
	private Boolean loginForm;
	private List<HeadingTagDTO> headingTagDTOs;
	private List<UrlStatusDTO> externalLinkDTOs;
	private List<UrlStatusDTO> internalLinkDTOs;
}

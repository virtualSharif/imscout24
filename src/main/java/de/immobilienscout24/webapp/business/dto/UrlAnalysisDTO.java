package de.immobilienscout24.webapp.business.dto;

import java.util.List;


public class UrlAnalysisDTO {

    private String pageTitle;
    private String htmlVersion;
    private Integer noOfInternalLinks;
    private Integer noOfExternalLinks;
    private Boolean loginForm;
    private List<HeadingTagDTO> headingTagDTOs;
    private List<UrlStatusDTO> externalLinkDTOs;
    private List<UrlStatusDTO> internalLinkDTOs;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getHtmlVersion() {
        return htmlVersion;
    }

    public void setHtmlVersion(String htmlVersion) {
        this.htmlVersion = htmlVersion;
    }

    public Integer getNoOfInternalLinks() {
        return noOfInternalLinks;
    }

    public void setNoOfInternalLinks(Integer noOfInternalLinks) {
        this.noOfInternalLinks = noOfInternalLinks;
    }

    public Integer getNoOfExternalLinks() {
        return noOfExternalLinks;
    }

    public void setNoOfExternalLinks(Integer noOfExternalLinks) {
        this.noOfExternalLinks = noOfExternalLinks;
    }

    public Boolean getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(Boolean loginForm) {
        this.loginForm = loginForm;
    }

    public List<HeadingTagDTO> getHeadingTagDTOs() {
        return headingTagDTOs;
    }

    public void setHeadingTagDTOs(List<HeadingTagDTO> headingTagDTOs) {
        this.headingTagDTOs = headingTagDTOs;
    }

    public List<UrlStatusDTO> getExternalLinkDTOs() {
        return externalLinkDTOs;
    }

    public void setExternalLinkDTOs(List<UrlStatusDTO> externalLinkDTOs) {
        this.externalLinkDTOs = externalLinkDTOs;
    }

    public List<UrlStatusDTO> getInternalLinkDTOs() {
        return internalLinkDTOs;
    }

    public void setInternalLinkDTOs(List<UrlStatusDTO> internalLinkDTOs) {
        this.internalLinkDTOs = internalLinkDTOs;
    }
}

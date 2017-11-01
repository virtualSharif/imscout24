package de.immobilienscout24.webapp.business.dto;


public class UrlStatusDTO {

    private String url;
    private StatusDTO statusDTO;

    public UrlStatusDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

    public UrlStatusDTO(String url, StatusDTO statusDTO) {
        this.url = url;
        this.statusDTO = statusDTO;
    }
}

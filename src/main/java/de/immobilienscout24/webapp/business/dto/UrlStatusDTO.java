package de.immobilienscout24.webapp.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlStatusDTO {

	private String url;
	private StatusDTO statusDTO;

	public UrlStatusDTO(String url) {
		this.url = url;
	}
}

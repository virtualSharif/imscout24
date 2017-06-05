package de.immobilienscout24.webapp.rest.exception;

import de.immobilienscout24.webapp.business.dto.StatusDTO;
import lombok.Getter;
import lombok.Setter;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private StatusDTO statusDTO;

	public BadRequestException(StatusDTO statusDTO) {
		super();
		this.setStatusDTO(statusDTO);
	}

}

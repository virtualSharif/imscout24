package de.immobilienscout24.webapp.business.dto;

import de.immobilienscout24.webapp.business.enums.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDTO {

	private Integer code;
	private String message;

	public StatusDTO(ErrorCodes errorCodes) {
		this.code = errorCodes.getCode();
		this.message = errorCodes.getMessage();
	}
}

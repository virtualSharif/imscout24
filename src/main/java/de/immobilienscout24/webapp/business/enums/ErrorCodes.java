package de.immobilienscout24.webapp.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCodes {

	INPUT_URL_INVALID(1001, "Input url is invalid"), JSOUP_PARSING_ERROR(1002, "Jsoup parsing error");

	@Getter
	private int code;
	@Getter
	private String message;
}

package de.immobilienscout24.webapp.business.dto;

import de.immobilienscout24.webapp.business.enums.HeadingTag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeadingTagDTO {

	private HeadingTag headingTag;
	private Integer noOfOccurance;
}

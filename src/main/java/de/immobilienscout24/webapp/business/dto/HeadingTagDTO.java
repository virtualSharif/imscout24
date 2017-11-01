package de.immobilienscout24.webapp.business.dto;

import de.immobilienscout24.webapp.business.enums.HeadingTag;

public class HeadingTagDTO {

    private HeadingTag headingTag;
    private Integer noOfOccurance;

    public HeadingTag getHeadingTag() {
        return headingTag;
    }

    public Integer getNoOfOccurance() {
        return noOfOccurance;
    }

    public void setHeadingTag(HeadingTag headingTag) {
        this.headingTag = headingTag;
    }

    public void setNoOfOccurance(Integer noOfOccurance) {
        this.noOfOccurance = noOfOccurance;
    }

    public HeadingTagDTO(HeadingTag headingTag, Integer noOfOccurance) {
        this.headingTag = headingTag;
        this.noOfOccurance = noOfOccurance;
    }
}

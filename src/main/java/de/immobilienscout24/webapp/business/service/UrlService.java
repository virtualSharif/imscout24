package de.immobilienscout24.webapp.business.service;

import de.immobilienscout24.webapp.business.dto.UrlAnalysisDTO;
import de.immobilienscout24.webapp.business.dto.UrlStatusDTO;

public interface UrlService {

	UrlAnalysisDTO analyse(String url);

	UrlStatusDTO getStatus(String url);
}

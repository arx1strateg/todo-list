package com.bohush.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * Date 07/25/19.
 *
 * @author Raman_Bohush
 */
@Component
public class RequestLoggingFilter extends CommonsRequestLoggingFilter {
    public RequestLoggingFilter() {
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10000);
    }
}

package uk.gov.ida.notification.shared;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import static uk.gov.ida.notification.shared.IstioHeaders.ISTIO_HEADERS;

@Provider
public class IstioHeaderMapperFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        MultivaluedMap<String, String> incomingHeaders = requestContext.getHeaders();

        for (String istioHeader : ISTIO_HEADERS) {
            if (incomingHeaders.containsKey(istioHeader)) {
                responseContext.getHeaders().add(istioHeader, incomingHeaders.getFirst(istioHeader));
            }
        }
    }
}

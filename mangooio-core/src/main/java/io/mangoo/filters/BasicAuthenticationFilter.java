package io.mangoo.filters;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Base64;

import com.google.common.base.Charsets;

import io.mangoo.configuration.Config;
import io.mangoo.core.Application;
import io.mangoo.enums.Default;
import io.mangoo.enums.Key;
import io.mangoo.interfaces.MangooAuthenticator;
import io.mangoo.interfaces.MangooFilter;
import io.mangoo.routing.Response;
import io.mangoo.routing.bindings.Request;
import io.undertow.util.Headers;

/**
 * Filter for basic HTTP authentication
 * 
 * @author skubiak
 *
 */
public class BasicAuthenticationFilter implements MangooFilter {
    @Override
    public Response execute(Request request, Response response) {
        String username = null;
        String password = null;
        String authInfo = request.getHeader(Headers.AUTHORIZATION);
        if (StringUtils.isNotBlank(authInfo)) {
            authInfo = authInfo.replace("Basic", "");
            authInfo = authInfo.trim();
            authInfo = new String(Base64.decode(authInfo), Charsets.UTF_8);

            String [] credentials = authInfo.split(":");
            if (credentials != null && credentials.length == Default.BASICAUTH_CREDENTIALS_LENGTH.toInt()) {
                username = credentials[0];
                password = credentials[1];
            }
        }

        if (!Application.getInstance(MangooAuthenticator.class).validCredentials(username, password)) {
            return Response.withUnauthorized()
                    .andHeader(Headers.WWW_AUTHENTICATE, "Basic realm=" + Application.getInstance(Config.class).getString(Key.APPLICATION_NAME))
                    .andEmptyBody()
                    .end();
        }

        return response;
    }
}
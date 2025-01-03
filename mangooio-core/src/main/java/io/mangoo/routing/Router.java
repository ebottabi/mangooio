package io.mangoo.routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;

import io.mangoo.enums.RouteType;
import io.undertow.util.HttpString;

/**
 *
 * @author svenkubiak
 *
 */
public final class Router {
    private static List<Route> routes = new ArrayList<Route>();

    private Router() {
    }

    public static void addRoute(Route route) {
        Preconditions.checkNotNull(route, "route is required for addRoute");

        routes.add(route);
    }

    /**
     * Creates a request mapping using the given request method
     *
     * @param requestMethod The request method (e.g. Methods.GET)
     * @return A route object {@link io.mangoo.routing.Route}
     */
    public static Route mapRequest(HttpString requestMethod) {
        Preconditions.checkNotNull(requestMethod, "requestMethod is required for addRoute");

        return new Route(requestMethod);
    }

    /**
     * Creates a request mapping for a websocket
     * @return A route object {@link io.mangoo.routing.Route}
     */
    public static Route mapWebSocket() {
        return new Route(RouteType.WEBSOCKET);
    }

    /**
     * Creates a request mapping for a resource file, e.g. /robots.txt
     * @return A route object {@link io.mangoo.routing.Route}
     */
    public static Route mapResourceFile() {
        return new Route(RouteType.RESOURCE_FILE);
    }

    /**
     * Creates a request mapping for resource, e.g. /assets/javascripts
     * @return A route object {@link io.mangoo.routing.Route}
     */
    public static Route mapResourcePath() {
        return new Route(RouteType.RESOURCE_PATH);
    }

    public static List<Route> getRoutes() {
        return Collections.unmodifiableList(routes);
    }
}
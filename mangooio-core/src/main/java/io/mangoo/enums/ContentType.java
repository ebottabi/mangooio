package io.mangoo.enums;

/**
 * Content types for browser negotiation
 *
 * @author svenkubiak
 *
 */
public enum ContentType {
    APPLICATION_JSON("application/json"),
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    @Deprecated
    APPLICATION_OCTETE_STREAM("application/octet-stream"),
    APPLICATION_OCTET_STREAM("application/octet-stream");

    private final String value;

    ContentType (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
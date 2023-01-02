package tech.altier.JProxyClient.API.JProxyRequestBuilder;

public class BuildRequest {
    private final String method;
    private final String endPoint;
    private final String version;
    private final String body;

    private static final String SERVER_ADDRESS;

    static {
        SERVER_ADDRESS = "http://localhost:8080";   // TODO load this from application.properties
    }

    private BuildRequest(String method, String endPoint, String version, String body) {
        this.method = method;
        this.endPoint = endPoint;
        this.version = version;
        this.body = body;
    }

    public BuildRequest(String endPoint) {
        this("GET", SERVER_ADDRESS, "HTTP/1.1", buildRequestBody(endPoint));
    }

    public String build() {
        return String.format("%s %s %s\r\n\r\n%s", method, endPoint, version, body);
    }
}

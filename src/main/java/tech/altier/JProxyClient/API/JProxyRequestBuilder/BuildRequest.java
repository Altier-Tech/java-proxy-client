package tech.altier.JProxyClient.API.JProxyRequestBuilder;

public class BuildRequest {
    private final String method;
    private final String endPoint;
    private final String version;
    private final String body;

    BuildRequest(String method, String endPoint, String version, String body) {
        this.method = method;
        this.endPoint = endPoint;
        this.version = version;
        this.body = body;
    }

    BuildRequest(String endPoint, String body) {
        this("GET", endPoint, "HTTP/1.1", body);
    }

    BuildRequest(String endPoint) {
        String body = 
        this("GET", endPoint, "HTTP/1.1", body);
    }

    public String build() {
        return String.format("%s %s %s\r\n\r\n%s", method, endPoint, version, body);
    }
}

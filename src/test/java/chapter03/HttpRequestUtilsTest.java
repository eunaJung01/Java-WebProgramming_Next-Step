package chapter03;


import chapter03.util.HttpRequestUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpRequestUtilsTest {

    @Test
    public void parseQueryString() {
        String queryString = "userId=javajigi";
        Map<String, String> parameters = HttpRequestUtils.parseQueryString(queryString);
        assertThat(parameters.get("userId")).isEqualTo("javajigi");
        assertThat(parameters.get("password")).isEqualTo(null);

        queryString = "userId=javajigi&password=password2";
        parameters = HttpRequestUtils.parseQueryString(queryString);
        assertThat(parameters.get("userId")).isEqualTo("javajigi");
        assertThat(parameters.get("password")).isEqualTo("password2");
    }

    @Test
    public void parseQueryString_null() {
        Map<String, String> parameters = HttpRequestUtils.parseQueryString(null);
        assertThat(parameters.isEmpty()).isEqualTo(true);

        parameters = HttpRequestUtils.parseQueryString("");
        assertThat(parameters.isEmpty()).isEqualTo(true);

        parameters = HttpRequestUtils.parseQueryString(" ");
        assertThat(parameters.isEmpty()).isEqualTo(true);
    }

    @Test
    public void parseQueryString_invalid() {
        String queryString = "userId=javajigi&password";
        Map<String, String> parameters = HttpRequestUtils.parseQueryString(queryString);
        assertThat(parameters.get("userId")).isEqualTo("javajigi");
        assertThat(parameters.get("password")).isEqualTo(null);
    }

    @Test
    public void parseCookies() {
        String cookies = "logined=true; JSessionId=1234";
        Map<String, String> parameters = HttpRequestUtils.parseCookies(cookies);
        assertThat(parameters.get("logined")).isEqualTo("true");
        assertThat(parameters.get("JSessionId")).isEqualTo("1234");
        assertThat(parameters.get("session")).isEqualTo(null);
    }

    @Test
    public void getKeyValue() throws Exception {
        HttpRequestUtils.Pair pair = HttpRequestUtils.getKeyValue("userId=javajigi", "=");
        assertThat(pair).isEqualTo(new HttpRequestUtils.Pair("userId", "javajigi"));
    }

    @Test
    public void getKeyValue_invalid() throws Exception {
        HttpRequestUtils.Pair pair = HttpRequestUtils.getKeyValue("userId", "=");
        assertThat(pair).isEqualTo(null);
    }

    @Test
    public void parseHeader() throws Exception {
        String header = "Content-Length: 59";
        HttpRequestUtils.Pair pair = HttpRequestUtils.parseHeader(header);
        assertThat(pair).isEqualTo(new HttpRequestUtils.Pair("Content-Length", "59"));
    }

}

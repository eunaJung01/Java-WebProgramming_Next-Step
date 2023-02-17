package chapter03.webserver;

import chapter03.model.User;
import chapter03.util.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

public class RequestHandler extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(), connection.getPort());

        try (InputStream in = connection.getInputStream();
             OutputStream out = connection.getOutputStream()) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            logger.debug("request line : {}", line);

            if (line == null) return;
            String[] requestLine = line.split("' '|\\?");
            String httpMethod = requestLine[0];
            String url = requestLine[1];
            String params = "";
            if (requestLine.length >= 3) {
                params = requestLine[2];
            }

            // TODO: Request header 전체 출력
            /*
            while (!line.equals("")) {
                line = bufferedReader.readLine();
                logger.debug("header : {}", line);
            }
            //*/

            // TODO: 사용자의 요청에 대한 처리
            byte[] body = setBody(httpMethod, url, params);

            // TODO: 응답에 대한 처리
            DataOutputStream dos = new DataOutputStream(out);
            response200Header(dos, body.length);
            responseBody(dos, body);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private byte[] setBody(String httpMethod, String url, String params) throws IOException {
        if (httpMethod.equals("GET") && url.equals("/index.html")) {
            return Files.readAllBytes(new File("./webapp" + url).toPath());
        }
        if (httpMethod.equals("GET") && url.equals("/user/create")) {
            Map<String, String> queryParams = HttpRequestUtils.parseQueryString(params);
            User user = new User(queryParams.get("userId"), queryParams.get("password"), queryParams.get("name"), queryParams.get("email"));
            logger.debug("User : {}", user);
        }
        return "Hello World".getBytes();
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}

package chapter03;

import chapter03.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOUtilsTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(IOUtilsTest.class));

    @Test
    public void readData() throws Exception {
        String data = "abcd123";
        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);

        logger.log(Level.WARNING, "parse body : {}", IOUtils.readData(br, data.length()));
    }

}

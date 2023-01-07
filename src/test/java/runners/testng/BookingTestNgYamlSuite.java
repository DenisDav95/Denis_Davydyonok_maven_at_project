package runners.testng;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

public class BookingTestNgYamlSuite {

    public static void main(String[] args) throws IOException {
        final TestNG testNG = new TestNG(true);
        final Parser parse = new Parser("src/test/resources/settings/testng.yaml");
        final List<XmlSuite> suites = parse.parseToList();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}

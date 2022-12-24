package runners.cucumber;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "summary" },
        glue = { "steps" },
        features = {
                "src/test/resources/bookingregister.feature"
        },
        strict = true)

public class BookingCucumberSuite {
}

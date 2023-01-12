package framework.runners.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import framework.tests.junit4.RegisterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({RegisterTest.class})
public class BookingJunit4Suite {
}

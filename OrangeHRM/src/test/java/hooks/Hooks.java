package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {

        BaseClass.initialization();
    }

    @After
    public void tearDown() {

        BaseClass.quitBrowser();
    }
}
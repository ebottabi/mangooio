package mangoo.io.test;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.inject.Injector;
import com.icegreen.greenmail.util.GreenMail;

public class MangooFluent extends FluentTest {
    public WebDriver webDriver = new HtmlUnitDriver();

    @Before
    public final void mangooStartup() {
    	beforeMangooStartup();
    	MangooTestInstance.IO.getInjector();
    }

    public final Injector getInject() {
        return MangooTestInstance.IO.getInjector();
    }
    
    public final GreenMail getFakeSMTP() {
    	return MangooTestInstance.IO.getFakeSMTP();
    }
    
    public void beforeMangooStartup() {
	}
    
    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }
}
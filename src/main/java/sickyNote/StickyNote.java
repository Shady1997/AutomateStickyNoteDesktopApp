package sickyNote;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class StickyNote {

	public WindowsDriver<WebElement> StickyNoteSession = null;
	public DesiredCapabilities capabilities;

	@BeforeClass
	public void setup() {
		try {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.MicrosoftStickyNotes_8wekyb3d8bbwe!App");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("platformVersion", "1.0");

			StickyNoteSession = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capabilities);
			StickyNoteSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	@Test
	public void AddNewNote() throws InterruptedException {
		StickyNoteSession.findElementByAccessibilityId("RichEditBox").click();
		StickyNoteSession.wait(5000);
		StickyNoteSession.findElementByName("Title").click();
		StickyNoteSession.findElementByName("Note Editor").sendKeys("shady ahmed");
	}

	@AfterClass
	public void TearDown() {

		if (StickyNoteSession != null) {
			StickyNoteSession.quit();
		}
		StickyNoteSession = null;
	}

}

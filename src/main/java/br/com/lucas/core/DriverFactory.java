package br.com.lucas.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.lucas.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			
			switch (Propriedades.BROWSER) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
			default:
				break;
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			
			switch(Propriedades.BROWSER) {
			case FIREFOX: cap = DesiredCapabilities.firefox(); break;
			case CHROME: cap = DesiredCapabilities.chrome(); break;
			default:
				break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.0.184:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			
			switch(Propriedades.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
				case IE:  cap = DesiredCapabilities.internetExplorer();
								cap.setCapability("platformName", "Windows 10");
								cap.setCapability("browserVersion", "11.285");
								break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://lucas.emanuel@dcx.ufpb.br:dd8bfaee-d161-4906-8ef1-c2c849849a89@ondemand.saucelabs.com:80/le/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		
		
		driver.manage().window().maximize();
		return driver;
}
	
	public static void killDriver() {
		
		WebDriver driver = getDriver();
		
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
	
	
	
}

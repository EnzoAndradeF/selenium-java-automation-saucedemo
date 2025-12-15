package com.saucedemo.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver navegador;
    protected final String URL_BASE = "https://www.saucedemo.com/";

    public WebDriver inicializarNavegador() {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        navegador = new EdgeDriver(options);

        return navegador;
    }

    public void fecharNavegador(){
        if(navegador != null)
            navegador.quit();
    }
}

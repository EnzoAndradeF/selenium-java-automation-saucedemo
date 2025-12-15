package com.saucedemo.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class CartPage {

    private WebDriver navegador;

    @FindBy(id = "checkout")
    private WebElement acessarCheckout;

    public CartPage(WebDriver navegador){
        this.navegador = navegador;

        PageFactory.initElements(navegador, this);
    }

    @Step("Clicar no botão 'Checkout' para iniciar a compra")
    public void irParaCheckoutStep01(){
        acessarCheckout.click();
    }
}

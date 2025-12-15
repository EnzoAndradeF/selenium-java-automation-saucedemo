package com.saucedemo.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class CheckoutStepTwo {

    private WebDriver navegador;

    //Mapeando elementos
    
    @FindBy(id = "finish")
    private WebElement finalizarCompra;

    @FindBy(className = "complete-header")
    private WebElement mensagemFinal;

    @FindBy(id = "back-to-products")
    private WebElement backHome;

    public CheckoutStepTwo(WebDriver navegador) {
        this.navegador = navegador;

        PageFactory.initElements(navegador, this);
    }

    //Ação

    @Step("Clicar no botão 'Finish' e finalizar o pedido")
    public void realizarCompra(){
        finalizarCompra.click();
    }

    @Step("Validar mensagem de confirmação do pedido")
    public String getMensagemFinal(){
        return mensagemFinal.getText();
    }

    @Step("Clicar no botão 'BackHome' e voltar para a página inventory")
    public void clicarBackHome(){
        backHome.click();
    }

    
}

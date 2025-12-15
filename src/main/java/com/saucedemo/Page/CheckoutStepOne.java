package com.saucedemo.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class CheckoutStepOne {

    private WebDriver navegador;

    //Mapeando elementos
    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement caixaPostal;

    @FindBy(id = "continue")
    private WebElement AcessarCheckoutStepTwo;

    public CheckoutStepOne(WebDriver navegador) {
        this.navegador = navegador;

        PageFactory.initElements(navegador, this);
    }

    //Ação

    public void digitarNome(String nome){
        firstName.sendKeys(nome);
    }

    public void digitarSobrenome(String sobrenome){
        lastName.sendKeys(sobrenome);
    }

    public void digitarCaixaPostal(String cep){
        caixaPostal.sendKeys(cep);
    }

    public void irParaCheckoutStep02(){
        AcessarCheckoutStepTwo.click();
    }

    @Step("Preencher dados pessoais: {nome}, {sobrenome}, {cep}")
    public void digitarSuasInformacoes(String nome, String sobrenome, String cep){
        digitarNome(nome);
        digitarSobrenome(sobrenome);
        digitarCaixaPostal(cep);
        irParaCheckoutStep02();
    }
    
    

}

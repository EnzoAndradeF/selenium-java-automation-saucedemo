package com.saucedemo.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class LoginPage {

    private WebDriver navegador;

    //Mapeando elementos

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement botaoLogin;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement mensagemErro;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;

        PageFactory.initElements(navegador, this);
    }

    //Ação

    public void irParaUrl(String url){
        navegador.get(url);
    }

    public void digitarUsuario(String usuario){
        username.sendKeys(usuario);
    }

    public void digitarSenha(String senha){
        password.sendKeys(senha);
    }

    public void clicarBotaoLogin(){
        botaoLogin.click();
    }

    @Step("Realizar Login com usuário: {usuario} e senha: {senha}")
    public void realizarLogin(String usuario, String senha){
        digitarUsuario(usuario);
        digitarSenha(senha);
        clicarBotaoLogin();
    }

    @Step("Obter Mensagem de Erro")
    public String getMensagemDeErro(){
        return mensagemErro.getText();
    }


}

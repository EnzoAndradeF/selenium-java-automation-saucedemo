package com.saucedemo.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class InventoryPage {

    private WebDriver navegador;

    // Mapeando elementos

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addProduto;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement carrinho;

    @FindBy(className = "shopping_cart_badge")
    private WebElement contador;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuLateral;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    public InventoryPage(WebDriver navegador){
        this.navegador = navegador;

        PageFactory.initElements(navegador, this);
    }

    // Ação

    @Step("Adicionar produto 'Sauce Labs Backpack' no carrinho")
    public void adicionarProdutoNoCarrinho (){
        addProduto.click();
    }

    @Step("Navegar para o carrinho de compras")
    public void irParaCarrinho(){
        carrinho.click();
    }

    @Step("Validar quantidade de produto no carrinho")
    public String getContadorCarrinho() {
        return contador.getText();
    }

    @Step("Fazer o Logout do site")
    public void fazerLogout(WebDriverWait wait){
    menuLateral.click(); 
    wait.until(ExpectedConditions.elementToBeClickable(logout)); 
    logout.click();      
}

}

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.Page.CartPage;
import com.saucedemo.Page.CheckoutStepOne;
import com.saucedemo.Page.CheckoutStepTwo;
import com.saucedemo.Page.InventoryPage;
import com.saucedemo.Page.LoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("E-commerce SauceDemo")
@Feature("Fluxo de compra")
public class CompraDeProdutoTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOne checkoutStepOne;
    private CheckoutStepTwo checkoutStepTwo;

    @BeforeEach
    public void setup(){
        super.inicializarNavegador();
        loginPage = new LoginPage(navegador);
        loginPage.irParaUrl(URL_BASE);
    }

    @Test
    @Story("Compra com usuário válido")
    @DisplayName("CT001: Fluxo Completo de Compra (Usuário Válido)")
    public void testFluxoCompletoDeCompra(){
        loginPage.realizarLogin("standard_user", "secret_sauce");

        String urlInventory = navegador.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", urlInventory, "Falha no login");
    
        inventoryPage = new InventoryPage(navegador);
        inventoryPage.adicionarProdutoNoCarrinho();

        String contadorCarrinho = inventoryPage.getContadorCarrinho();
        assertEquals("1", contadorCarrinho, "Falha na adição");

        inventoryPage.irParaCarrinho();

        String urlCart = navegador.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/cart.html", urlCart, "Falha ao ser redirecionado ao carrinho");
    
        cartPage = new CartPage(navegador);
        cartPage.irParaCheckoutStep01();

        String urlAtual = navegador.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", urlAtual, "Falha ao avançar para compra");
    
        checkoutStepOne = new CheckoutStepOne(navegador);
        checkoutStepOne.digitarSuasInformacoes("Enzo", "Sobrenome", "60752320");

        String urlCheck01 = navegador.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", urlCheck01, "Falha ao confirmar seus dados");

        checkoutStepTwo = new CheckoutStepTwo(navegador);
        checkoutStepTwo.realizarCompra();

        String urlCheck02 = navegador.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-complete.html", urlCheck02, "Falha ao finalizar sua compra");

        String mensagemConfirmacao = checkoutStepTwo.getMensagemFinal();
        assertEquals("Thank you for your order!", mensagemConfirmacao, "Falha: Mensagem de conclusão da compra incorreta ou não encontrada.");
    
        checkoutStepTwo.clicarBackHome();
        inventoryPage.fazerLogout(new org.openqa.selenium.support.ui.WebDriverWait(navegador, java.time.Duration.ofSeconds(2)));
    }

    @Test
    @Story("Login inválido")
    @DisplayName("❌ CT002: Login Inválido - Deve Apresentar Mensagem de Erro")
    public void testLoginInvalido(){
        loginPage.realizarLogin("usuario_errado", "senha_errada");

        String mensagemAtual = loginPage.getMensagemDeErro();
        assertEquals("Epic sadface: Username and password do not match any user in this service", mensagemAtual, "Falha: A mensagem de erro esperada não foi exibida.");
    }

    @AfterEach
    public void tearDown(){
        super.fecharNavegador();
    }

}


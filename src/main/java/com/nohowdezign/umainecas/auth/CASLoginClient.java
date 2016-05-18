package com.nohowdezign.umainecas.auth;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.RefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author Noah Howard
 */
public class CASLoginClient {
    private String loginPortalUrl = "https://identity.maine.edu/cas/login";

    public String login(String username, String password) throws IOException {
        WebClient webClient = createWebClient(setupRefreshHandler());

        HtmlPage page1 = webClient.getPage(loginPortalUrl);
        HtmlForm form = page1.getFormByName("form");
        List<HtmlInput> button = form.getInputsByValue("LOGIN");
        HtmlTextInput usernameField = form.getInputByName("username");
        HtmlPasswordInput passwordField = form.getInputByName("password");

        usernameField.setValueAttribute(username);
        passwordField.setValueAttribute(password);

        HtmlPage page2 = button.get(0).click(); // Magic number 0, it SHOULD be the only "LOGIN" value but...
        return page2.getBody().asText();
    }

    public boolean isLoginSuccessful(String loginReturn) {
        if(loginReturn.contains("Log In Successful")) {
            return true;
        }
        return false;
    }

    private WebClient createWebClient(RefreshHandler rh) {
        WebClient webClient = new WebClient();
        webClient.setThrowExceptionOnScriptError(false);
        webClient.setRefreshHandler(rh);
        webClient.setThrowExceptionOnFailingStatusCode(false);
        return webClient;
    }

    private RefreshHandler setupRefreshHandler() {
        RefreshHandler rh = new RefreshHandler() {
            @Override
            public void handleRefresh(Page page, URL url, int seconds) throws IOException {

            }
        };
        return rh;
    }

}
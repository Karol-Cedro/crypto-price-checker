package com.cedro.cryptopricetracker;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/")
public class CryptoTrackerMainPageGui extends VerticalLayout {

    @Autowired
    CryptoController cryptoController;

    public CryptoTrackerMainPageGui(){
        VerticalLayout verticalLayout = new VerticalLayout();
        TextField textField = new TextField("Enter crypto short name: ");
        Button primaryButton = new Button("Check price");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_SUCCESS);
        Label label = new Label();
        primaryButton.addClickListener(buttonClickEvent -> {
            label.setText("Crypto price: "+ textField.getValue() +" = "+cryptoController.getCryptoPrice("BTC").getPrice());
        });
        add(textField,primaryButton,label);

    }
}

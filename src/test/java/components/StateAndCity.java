package components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCity {
    public static void setState(){
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
    }
    public static void setCity(){
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
    }

}

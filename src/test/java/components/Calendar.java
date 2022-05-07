package components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public static void setDate() {
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day.react-datepicker__day--013").click();
    }

}
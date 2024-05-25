package wingifyHandsOn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

    @FindBy(id = "amount")
    WebElement amountHeader;

    @FindBy(xpath = "//table[@id='transactionsTable']//tr/td[5]")
    List<WebElement> amountColumn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAmountHeader() {
        amountHeader.click();
    }

    public List<Double> getAmountValues() {
        return amountColumn.stream()
            .map(e -> e.getText().replace("$", "").replace(",", ""))
            .map(Double::parseDouble)
            .collect(Collectors.toList());
    }

    public boolean isAmountSorted() {
        List<Double> amounts = getAmountValues();
        List<Double> sortedAmounts = new ArrayList<>(amounts);
        Collections.sort(sortedAmounts);
        return amounts.equals(sortedAmounts);
    }
}


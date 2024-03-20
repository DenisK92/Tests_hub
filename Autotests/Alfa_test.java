import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {

	@BeforeAll 
	static void BeforeAll() {
	Configuration.baseUrl = ("https://alfabank.ru/");
	Configuration.browserSize = "1920x1080";
}
	@Test
	void testAlfaBank() {
		open(baseUrl);
		$(byText("Вклады")).click();
		$("a["href="/make-money/deposits/alfa/?platformId=alfasite"]").click();
		$([data-test-id="resident-notResident"]).click();
		$([data-test-id="resident-resident"]).click();
		$([name="fullName"]).click().setValue("Иванов Иван Иванович");
		$([name="passportBirthDateField"]).click().setValue("05.12.1987").setValue("9889560989"); //Ввод даты рождения и номера телефона
		$([data-test-id="email-input-placeholder"]).click().setValue("develop-test@gmail.com");
		$([class="button__text_1mgd7 button__stretchText_1mgd7"]).$(byText("Продолжить")).click();
		$([class="confirmation__phone_1aoq4 typography__primary_4kq0c typography__primary-medium_9new2"]).shouldHave(text("Код отправлен на "),text("+7 (988) 956-09-89"));
	}
}

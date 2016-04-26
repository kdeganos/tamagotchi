import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void tamaIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#tamaName").with("mr.spock");
    submit("#ogForm");
    assertThat(pageSource()).contains("mr.spock");
  }

  // @Test
  // public void tamaIsStoredInSessionTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#tamaName").with("mr.spock");
  //   submit("#ogForm");
  //   assertThat(pageSource()).contains("saved tamas");
  // }
}

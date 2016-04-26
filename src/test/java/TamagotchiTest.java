
import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void Tamagotchi_instantiates_true(){
    Tamagotchi testTama = new Tamagotchi("mr.spock");
    assertEquals("mr.spock", testTama.getName());
    assertEquals(10, testTama.getFoodLevel());
    assertEquals(10, testTama.getSleepLevel());
    assertEquals(10, testTama.getActivityLevel());
  }

  @Test
  public void Tamagotchi_timePassesAllDecreaseByOne_9(){
    Tamagotchi testTama = new Tamagotchi("mr.spock");

    testTama.timePasses(1);
    assertEquals(9, testTama.getFoodLevel());
    assertEquals(9, testTama.getSleepLevel());
    assertEquals(9, testTama.getActivityLevel());
  }

  @Test
  public void Tamagotchi_timePassesTamaDies_false(){
    Tamagotchi testTama = new Tamagotchi("mr.spock");

    testTama.timePasses(10);
    assertEquals(true, testTama.isDead());
  }

  @Test
  public void Tamagotchi_checkStatus_String(){
    Tamagotchi testTama = new Tamagotchi("mr.spock");
    assertEquals("mr.spock's  food level: 10 sleep level: 10 activity level: 10", testTama.checkStatus());
  }
}

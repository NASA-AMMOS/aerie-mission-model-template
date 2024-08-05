package missionmodel;

import gov.nasa.jpl.aerie.merlin.framework.Registrar;
import gov.nasa.jpl.aerie.merlin.framework.junit.MerlinExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MerlinExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExampleTest {

  private final Mission mission;

  public ExampleTest(Registrar registrar) {
    this.mission = new Mission(registrar, Configuration.defaultConfiguration());
  }

  @Test
  public void exampleAssertion() {
    // spawn(new MyActivity());
    // delay(10, duration(10, MINUTES));
    // assertEquals(currentValue(mission.myResource.get()), 5);
  }
}

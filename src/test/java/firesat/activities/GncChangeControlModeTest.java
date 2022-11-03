package gradle.test;

import firesat.activities.gnc.GncChangeControlMode;
import firesat.generated.activities.gnc.GncChangeControlModeMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GncChangeControlModeTest {
  private final GncChangeControlModeMapper mapper;

  public GncChangeControlModeTest() {
    this.mapper = new GncChangeControlModeMapper();
  }

  @Test
  public void testDefaultSerializationDoesNotThrow() {
    this.mapper.getInputType().getArguments(new GncChangeControlMode());
  }
}

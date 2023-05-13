package firesat.activities.gnc;

import firesat.Mission;
import firesat.models.mms.ShadowType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.*;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

@ActivityType("InShadow")
public class InShadow {
  @Parameter
  public String scId = "";

  @Parameter
  public String startTime = "";

  @Parameter
  public Duration duration = Duration.HOUR;

  @Parameter
  public ShadowType shadowType = ShadowType.PENUMBRA;

  @EffectModel
  @ActivityType.ControllableDuration(parameterName = "duration")
  public void run(final Mission mission) {
    mission.shadowType.set(this.shadowType);
    delay(duration);
  }
}

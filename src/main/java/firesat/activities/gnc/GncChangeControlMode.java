package firesat.activities.gnc;

import firesat.Mission;
import firesat.models.gnc.GncControlMode;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.EffectModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;

@ActivityType("GncChangeControlMode")
public final class GncChangeControlMode {
  @Parameter
  public GncControlMode gncControlMode = GncControlMode.THRUSTERS;

  @EffectModel
  public void run(final Mission mission) {
    mission.gncControlMode.set(this.gncControlMode);
  }
}

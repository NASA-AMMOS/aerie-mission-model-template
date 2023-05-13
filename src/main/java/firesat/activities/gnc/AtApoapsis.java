package firesat.activities.gnc;

import firesat.Mission;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.EffectModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;

@ActivityType("AtApoapsis")
public final class AtApoapsis {
  //@Parameter
  // no parameters yet

  @EffectModel
  public void run(final Mission mission) {
    mission.atApoapsis.set(true);
  }
}

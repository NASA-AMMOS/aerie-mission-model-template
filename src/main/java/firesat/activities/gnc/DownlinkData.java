package firesat.activities.gnc;

import firesat.Mission;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.FixedDuration;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.EffectModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

@ActivityType("DownlinkData")
public class DownlinkData {
  @Parameter
  public String sc_id = "";

  @Parameter
  public String tlm_type = "";

  @Parameter
  public Duration activity_duration = Duration.ZERO;

  @Parameter
  public long durationInSeconds;

  @EffectModel
  public void run(final Mission mission){
    mission.dsnDownlinkCounter.add(1);
  }
}

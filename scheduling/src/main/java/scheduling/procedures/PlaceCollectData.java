package scheduling;

import gov.nasa.ammos.aerie.procedural.scheduling.plan.EditablePlan;
import gov.nasa.ammos.aerie.procedural.scheduling.Rule;
import gov.nasa.ammos.aerie.procedural.scheduling.annotations.SchedulingProcedure;
import gov.nasa.ammos.aerie.procedural.timeline.payloads.activities.DirectiveStart;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import java.util.Map;

@SchedulingProcedure
public record PlaceCollectData(int start) implements Rule {
  @Override
  public void run(EditablePlan plan) {
    final var firstTime = Duration.hours(start);

    plan.create(
        "CollectData",
        new DirectiveStart.Absolute(firstTime),
        Map.of()
        );

    plan.commit();
  }
}

package scheduling.procedures;

import gov.nasa.ammos.aerie.procedural.scheduling.Goal;
import gov.nasa.ammos.aerie.procedural.scheduling.plan.EditablePlan;
import gov.nasa.ammos.aerie.procedural.scheduling.annotations.SchedulingProcedure;
import gov.nasa.ammos.aerie.procedural.timeline.payloads.activities.DirectiveStart;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import missionmodel.Utils;

import java.util.Map;

@SchedulingProcedure
public record SampleProcedure(int quantity) implements Goal {
  @Override
  public void run(EditablePlan plan) {
    final var firstTime = Duration.hours(0);
    final var step = Duration.hours(6);

    var currentTime = firstTime;
    for (var i = 0; i < quantity; i++) {
      plan.create(
        Utils.getCollectDataActivityName(),
        new DirectiveStart.Absolute(currentTime),
        Map.of()
      );
      currentTime = currentTime.plus(step);
    }
    plan.commit();
//    var results = plan.simulate(new SimulateOptions());
//    var size = results.instances().collect().size();
  }
}

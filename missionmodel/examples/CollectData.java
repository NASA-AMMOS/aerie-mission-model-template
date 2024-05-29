package missionmodel;

import gov.nasa.jpl.aerie.contrib.metadata.Unit;
import gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.DiscreteEffects;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Validation;


import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

/* Example Activity Type Definition
   If this activity is moved over to main/java/missionmodel along with the DataModel class and the example model
   declaration in the Mission class is uncommented, the model should compile.
 */
@ActivityType("CollectData")
public class CollectData {

    @Parameter
    @Unit("Mbps")
    public double rate = 10.0; // Mbps

    @Parameter
    public Duration duration = Duration.duration(1, Duration.HOURS);

    @Validation("Collection rate is beyond buffer limit of 100.0 Mbps")
    @Validation.Subject("rate")
    public boolean validateCollectionRate() {
      return rate <= 100.0;
    }

    @ActivityType.EffectModel
    public void run(Mission model) {

        /*
         Collect data at fixed rate over duration of activity
        */
        DiscreteEffects.increase(model.dataModel.RecordingRate, this.rate);
        delay(duration);
        DiscreteEffects.decrease(model.dataModel.RecordingRate, this.rate);

    }
}

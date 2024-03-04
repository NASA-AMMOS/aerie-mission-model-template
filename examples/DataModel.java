package missionmodel;

import gov.nasa.jpl.aerie.contrib.serialization.mappers.DoubleValueMapper;
import gov.nasa.jpl.aerie.contrib.streamline.core.MutableResource;
import gov.nasa.jpl.aerie.contrib.streamline.modeling.Registrar;
import gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.Discrete;
import gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.DiscreteEffects;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import static gov.nasa.jpl.aerie.contrib.metadata.UnitRegistrar.withUnit;
import static gov.nasa.jpl.aerie.contrib.streamline.core.MutableResource.resource;
import static gov.nasa.jpl.aerie.contrib.streamline.core.Resources.currentValue;
import static gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.Discrete.discrete;
import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

/* Example Mission Model delegate class
   This class includes two resource declarations and a method that can be spawned via a daemon task
   If this activity is moved over to main/java/missionmodel and the example model declaration in the Mission class
   is uncommented, the model should compile.
 */
public class DataModel {

    public MutableResource<Discrete<Double>> RecordingRate; // Megabits/s

    public MutableResource<Discrete<Double>> SSR_Volume_Sampled; // Gigabits

    public DataModel(Registrar registrar, Configuration config) {
      RecordingRate = resource(discrete(0.0));
      registrar.discrete("RecordingRate", RecordingRate, withUnit("Mbps", new DoubleValueMapper()));
    }

    public void integrateDataRate() {
      Duration INTEGRATION_SAMPLE_INTERVAL = Duration.duration(60, Duration.SECONDS);
      while(true) {
        delay(INTEGRATION_SAMPLE_INTERVAL);
        Double currentRecordingRate = currentValue(RecordingRate);
        DiscreteEffects.increase(SSR_Volume_Sampled, currentRecordingRate *
          INTEGRATION_SAMPLE_INTERVAL.ratioOver(Duration.SECONDS) / 1000.0); // Mbit -> Gbit
      }
    }

}

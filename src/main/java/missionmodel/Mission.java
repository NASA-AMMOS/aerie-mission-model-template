package missionmodel;

// import gov.nasa.jpl.aerie.contrib.serialization.mappers.DoubleValueMapper;
// import gov.nasa.jpl.aerie.contrib.streamline.core.MutableResource;
import gov.nasa.jpl.aerie.contrib.streamline.modeling.Registrar;
// import gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.Discrete;

// import static gov.nasa.jpl.aerie.contrib.streamline.core.MutableResource.resource;
// import static gov.nasa.jpl.aerie.contrib.streamline.modeling.discrete.Discrete.discrete;

/**
 * Top-level Mission Model Class
 *
 * Declare, define, and register resources within this class or its delegates
 * Spawn daemon tasks using spawn(objectName::nameOfMethod) within the class constructor
 */
public final class Mission {

  // Special registrar class that handles simulation errors via auto-generated resources
  public final Registrar errorRegistrar;

  // Example resource declaration
  // public MutableResource<Discrete<Double>> ExampleResource;

  public Mission(final gov.nasa.jpl.aerie.merlin.framework.Registrar registrar, final Configuration config) {
    this.errorRegistrar = new Registrar(registrar, Registrar.ErrorBehavior.Log);

    // Example resource definition and registration
    // ExampleResource = resource(discrete(0.0));
    // errorRegistrar.discrete("ExampleResource", ExampleResource, new DoubleValueMapper());

  }
}

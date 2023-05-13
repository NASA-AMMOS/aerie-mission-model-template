package firesat;

import firesat.External_Utilities.shadow_file_parser;
import firesat.models.gnc.GncControlMode;
import firesat.models.mms.ShadowType;
import gov.nasa.jpl.aerie.contrib.models.Clock;
import gov.nasa.jpl.aerie.contrib.models.Register;
import gov.nasa.jpl.aerie.contrib.models.counters.Counter;
import gov.nasa.jpl.aerie.contrib.serialization.mappers.BooleanValueMapper;
import gov.nasa.jpl.aerie.contrib.serialization.mappers.EnumValueMapper;
import gov.nasa.jpl.aerie.contrib.serialization.mappers.IntegerValueMapper;
import gov.nasa.jpl.aerie.merlin.framework.Registrar;
import gov.nasa.jpl.aerie.contrib.models.Accumulator;

import java.time.Instant;
import java.util.List;

public final class Mission {

  //examples of the Register resource, which represents a discrete quantity that can be set
  public final Register<ShadowType> shadowType = Register.forImmutable(ShadowType.NO_SHADOW);
  public final Register<GncControlMode> gncControlMode = Register.forImmutable(GncControlMode.THRUSTERS);
  public final Register<Boolean> atApoapsis = Register.forImmutable(false);
  
  //examples of the Counter resource, which you can add to
  public final Counter<Integer> dsnDownlinkCounter = Counter.ofInteger(0);
  public final Accumulator stateOfCharge = new Accumulator(100.0, -1.0);
  public final Clock utcClock = new Clock(Instant.parse("2023-08-18T00:00:00.00Z"));
  
  public Mission(final Registrar registrar, final Configuration config) {
    registrar.discrete("/shadowType", this.shadowType, new EnumValueMapper<>(ShadowType.class));
    registrar.discrete("/gncControlMode", this.gncControlMode, new EnumValueMapper<>(GncControlMode.class));
    registrar.discrete("/atApoapsis", this.atApoapsis, new BooleanValueMapper());
    registrar.discrete("/dsnPassCounter",this.dsnDownlinkCounter, new IntegerValueMapper());
    registrar.real("/stateOfCharge", this.stateOfCharge);
  }
}


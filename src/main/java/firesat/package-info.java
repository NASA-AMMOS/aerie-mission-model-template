@MissionModel(model = Mission.class)
@WithMappers(BasicValueMappers.class)
@WithConfiguration(Configuration.class)
@WithActivityType(GncChangeControlMode.class)
@WithActivityType(DownlinkData.class)
@WithActivityType(AtApoapsis.class)
@WithActivityType(InShadow.class)

package firesat;

import firesat.activities.gnc.AtApoapsis;
import firesat.activities.gnc.DownlinkData;
import firesat.activities.gnc.GncChangeControlMode;
import firesat.activities.gnc.InShadow;
import firesat.models.mms.ShadowType;
import gov.nasa.jpl.aerie.contrib.serialization.rulesets.BasicValueMappers;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithConfiguration;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithMappers;

package org.energy_home.jemma.ah.zigbee.appliances;

import java.util.Dictionary;

import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IEndPointTypes;
import org.energy_home.jemma.ah.hac.lib.Appliance;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.eh.ZclMeterIdentificationServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclBasicServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclIdentifyClient;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclIdentifyServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.metering.ZclSimpleMeteringServer;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclAppliance;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevelcoExternalMeterAppliance extends ZclAppliance {

	private ZclEndPoint endPoint = null;
	
	private static final Logger LOG = LoggerFactory.getLogger(DevelcoExternalMeterAppliance.class);
	
	public DevelcoExternalMeterAppliance(String pid, Dictionary config)
			throws ApplianceException {
		super(pid, config);

		endPoint = this.zclAddEndPoint(IEndPointTypes.ZIGBEE_METERING_DEVICE);

		// Server Clusters
		endPoint.addServiceCluster(new ZclBasicServer());
		endPoint.addServiceCluster(new ZclIdentifyServer());
		endPoint.addServiceCluster(new ZclSimpleMeteringServer());

	}
	
	protected void attached() {
		LOG.debug("DevelcoExternalMeterAppliance attached");
	}

	protected void detached() {
		LOG.debug("DevelcoExternalMeterAppliance detached");
	}

}

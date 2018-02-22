package Ex4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.*;

public class Ex4_4_MonitorVehicleTracker {
	@GuardedBy("this")
	private final Map<String, Ex4_5_MutablePoint> locations;
	
	public Ex4_4_MonitorVehicleTracker (
			Map<String, Ex4_5_MutablePoint> locations) {
		this.locations = deepCopy(locations);
	}
	
	public synchronized Map<String, Ex4_5_MutablePoint> getLocations(){
		return deepCopy(locations);
	}
	
	public synchronized Ex4_5_MutablePoint getLocations(String id){
		Ex4_5_MutablePoint loc = locations.get(id);
		return loc == null ? null : new Ex4_5_MutablePoint(loc);
	}
	
	public synchronized void setLocation(String id, int x, int y) {
		Ex4_5_MutablePoint loc = locations.get(id);
		if(loc == null)
			throw new IllegalArgumentException("No such ID: " + id);
		loc.x = x;
		loc.y = y;
	}

	private Map<String, Ex4_5_MutablePoint> deepCopy(Map<String, Ex4_5_MutablePoint> m) {
		Map<String, Ex4_5_MutablePoint> result = new HashMap<String, Ex4_5_MutablePoint>();
		for(String id : m.keySet())
			result.put(id, new Ex4_5_MutablePoint(m.get(id)));
		return Collections.unmodifiableMap(result);
	}
			
}

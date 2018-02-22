package Ex4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_12_PublishingVehicleTracker {
	private final Map<String, Ex4_11_SafePoint> locations;
	private final Map<String, Ex4_11_SafePoint> unmodifiableMap;
	
	public Ex4_12_PublishingVehicleTracker (Map<String, Ex4_11_SafePoint> locations) {
		this.locations = new ConcurrentHashMap<String, Ex4_11_SafePoint>(locations);
		this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
	}
	
	public Map<String, Ex4_11_SafePoint> getLocations() {
		return unmodifiableMap;
	}
	
	public Ex4_11_SafePoint getLocation(String id) {
		return locations.get(id);
	}
	
	public void setLocation(String id, int x, int y){
		if(!locations.containsKey(id))
			throw new IllegalArgumentException("Invalid vehicle name : " + id);
		locations.get(id).set(x, y);
	}
}

package Ex4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_7_DelegatingCehicleTracker {
	private final ConcurrentMap<String, Ex4_6_Point> locations;
	private final Map<String, Ex4_6_Point> unmodifiableMap;
	
	public Ex4_7_DelegatingCehicleTracker(Map<String, Ex4_6_Point> points){
		locations = new ConcurrentHashMap<String, Ex4_6_Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	
	public Map<String, Ex4_6_Point> getLocations() {
		return unmodifiableMap;
	}
	
	public Ex4_6_Point getLocaion(String id) {
		return locations.get(id);
	}
	
	public void setLocations(String id, int x, int y) {
		if(locations.replace(id, new Ex4_6_Point(x, y)) == null) {
			throw new IllegalArgumentException("Invalid vehicle name: " + id);
		}
	}
}

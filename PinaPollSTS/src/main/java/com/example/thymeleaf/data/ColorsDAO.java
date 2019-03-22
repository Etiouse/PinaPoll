package com.example.thymeleaf.data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.thymeleaf.model.Color;

@Component
public class ColorsDAO {
	
	private static Map<Integer, Color> colors = new HashMap<>();
	
	static {
		
		colors.put(1, new Color(255, 0, 0, 255));
		colors.put(2, new Color(0, 255, 0, 255));
		colors.put(3, new Color(0, 0, 255, 255));
	}

	public List<Color> getAllColors() {
		return colors.values().stream().collect(Collectors.toList());
	}
	
	public void save(Color color) {
		colors.put(nextKey(), color);
	}
	
	private static Integer nextKey() {
		final Comparator<Integer> comp = (k1, k2) -> Integer.compare( k1, k2);
	    
		return colors.keySet().stream().max(comp).get() + 1;
	}
}

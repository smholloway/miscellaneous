package com.sethholloway;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Skyline {
	private List<Building> skyline;
	
	public Skyline() {
		skyline = new ArrayList<Building>();
	}

	public Skyline(List<Building> buildings) {
		skyline = buildings;
		//skyline = new ArrayList<Building>();
		//skyline.addAll(buildings);
	}
	
	public boolean addBuilding(Building b) {
		return skyline.add(b);
	}

	public boolean addBuildings(List<Building> b) {
		return skyline.addAll(b);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (skyline == null) {
			result = prime * result + 0;
		} else {
			// hash off the middle building in the skyline
			result = prime * result + skyline.get(skyline.size()/2).hashCode();
		}
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof Skyline)) {
			return false;
		}
		
		Skyline other = (Skyline) obj;
		if (skyline == null) {
			if (other.skyline != null) {
				return false;
			}
		} else if (!skyline.equals(other.skyline)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Building b : skyline) {
			result.append(b.toString());
		}
		return result.toString();
	}
	
	/* 
	 * create a sorted array of all unique x1 and x2
	 */
	private List<Integer> getAllX() {
		List<Integer> points = new ArrayList<Integer>();
		for (Building b : skyline) {
			points.add(b.getX1());
			points.add(b.getX2());
		}
		Collections.sort(points);
		points = (List<Integer>) Utilities.removeDuplicateWithOrder(points);
		return points;
	}

	/*
	 *  sort the list of buildings by x1 (then x2 if necessary)
	 */
	public List<Building> sort(List<Building> buildings) {
		Collections.sort(buildings, new Comparator<Building>() {
			public int compare( Building b1, Building b2 ) {
				if (b1.getX1() == b2.getX1()) {
					return b1.getX2() - b2.getX2();
				}
		    	return b1.getX1() - b2.getX2();
		    }
		});
		return buildings;
	}
	
	/*
	 * return the buildings at a particular x location
	 */
	public List<Building> inRange(List<Building> buildings, int x) {
		List<Building> buildingsInRange = new ArrayList<Building>();
		for (Building b : buildings) {
			if (b.getX1() >= x && b.getX2() <= x) {
				buildingsInRange.add(b);
			}
		}
		return buildingsInRange;
	}
	
	/*
	 * return the height of the tallest building at a particular x
	 */
	public int tallestAtPoint(int x) {
		int tallest = 0;
		for (Building b : skyline) {
			if (b.getX1() <= x && b.getX2() >= x) {
				if (b.getHeight() > tallest) {
					tallest = b.getHeight();
				}
			}
		}
		return tallest;
	}
	
	/*
	 * print the skyline by determining the tallest building at each X
	 */	
	private void printSkylines(List<Building> buildings) {
		List<Building> s = calculateSkyline(buildings);
		s.toString();
	}

	private List<Building> calculateSkyline(List<Building> buildings) {
		buildings = sort(buildings);
		List<Integer> points = getAllX();
		List<Building> skyline = getSkyline(points);
		return skyline;
	}

	private List<Building> getSkyline(List<Integer> points) {
		List<Building> s = new ArrayList<Building>();
		int previousX = 0, currentX = 0, midX = 0, currentHeight = 0;
		for (int point : points) {
			currentX = point;
			if (currentX != previousX) {
				midX     = (currentX + previousX) >> 1; // divide is too readable!
				currentHeight = tallestAtPoint(midX);
				s.add(new Building(previousX, currentX, currentHeight));
				previousX = currentX;
			}
		}
		return s;
	}
		
}

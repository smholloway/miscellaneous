package com.sethholloway;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Building {	
	private int x1;
	private int x2;
	private int height;
	
	/*
	 * @param x1 - building's starting x position
	 * @param x2 - building's ending x position
	 * @param height - building's height
	 */
	public Building(int x1, int x2, int height) {
		this.x1     = x1;
		this.x2     = x2;
		this.height = height;
	}

	public Building() {
		this.x1     = 0;
		this.x2     = 0;
		this.height = 0;
	}
	
	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return ("(" + this.x1 + ", " + this.x2 + ", " + this.height + ")");
	}
	
	/*
	 *  sort the list of buildings by x1 (then x2 if necessary)
	 */
	public static List<Building> sort(List<Building> buildings) {
		Collections.sort(buildings, new Comparator<Building>() {
			public int compare( Building b1, Building b2 ) {
				if (b1.x1 == b2.x1) {
					return b1.x2 - b2.x2;
				}
		    	return b1.x1 - b2.x2;
		    }
		});
		return buildings;
	}
	
	/*
	 * return the buildings at a particular x location
	 */
	public static List<Building> inRange(List<Building> buildings, int x) {
		List<Building> buildingsInRange = new ArrayList<Building>();
		for (Building b : buildings) {
			if (b.x1 >= x && b.x2 <= x) {
				buildingsInRange.add(b);
			}
		}
		return buildingsInRange;
	}
	
	/*
	 * return the height of the tallest building at a particular x
	 */
	public static int tallestAtPoint(List<Building> buildings, int x) {
		int tallest = 0;
		for (Building b : buildings) {
			if (b.x1 <= x && b.x2 >= x) {
				if (b.height > tallest) {
					tallest = b.height;
				}
			}
		}
		return tallest;
	}
	
	/*
	 * utility method to remove duplicates from an array list
	 */
	public static List<?> removeDuplicateWithOrder(List<?> list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Object e : list) {
			if (set.add(e)) {
				newList.add(e);
			}
		}
		return newList;
	}
	
	/*
	 * print the skyline by determining the tallest building at each X
	 */	
	private static void printSkylines(List<Building> buildings) {
		List<Building> skyline = calculateSkyline(buildings);
		printBuildings(skyline);
	}

	private static void printBuildings(List<Building> buildings) {
		for (Building b : buildings) {
			System.out.println(b.toString());
		}
	}

	private static List<Building> calculateSkyline(List<Building> buildings) {
		buildings = sort(buildings);
		List<Integer> points = getAllX(buildings);
		List<Building> skyline = getSkyline(buildings, points);
		return skyline;
	}

	private static List<Building> getSkyline(List<Building> buildings,
			List<Integer> points) {
		List<Building> skyline = new ArrayList<Building>();
		int previousX = 0, currentX = 0, midX = 0, currentHeight = 0;
		for (int point : points) {
			currentX = point;
			if (currentX != previousX) {
				midX     = (currentX + previousX) >> 1; // divide is too readable!
				currentHeight = tallestAtPoint(buildings, midX);
				skyline.add(new Building(previousX, currentX, currentHeight));
				previousX = currentX;
			}
		}
		return skyline;
	}

	/* 
	 * create a sorted array of all unique x1 and x2
	 */
	private static List<Integer> getAllX(List<Building> buildings) {
		
		List<Integer> points = new ArrayList<Integer>();
		for (Building b : buildings) {
			points.add(b.x1);
			points.add(b.x2);
		}
		Collections.sort(points);
		points = (List<Integer>) removeDuplicateWithOrder(points);
		return points;
	}
	
	private static List<Building> init() {
		List<Building> buildings = new ArrayList<Building>();
		buildings.add(new Building(0,  10, 1));
		buildings.add(new Building(5,  10, 2));
		buildings.add(new Building(10, 20, 3));
		buildings.add(new Building(10, 15, 5));
		buildings.add(new Building(15, 20, 2));
		buildings.add(new Building(30, 35, 1));
		buildings.add(new Building(35, 40, 5 ));
		return buildings;
	}

	/**
	 * @param args - arguments
	 */
	public static void main(String[] args) {
		List<Building> buildings = init();
		printSkylines(buildings);
		/*
		 5            =====                    =====
		 4            =====                    ===== 
         3            ==========		       =====
		 2       ===============               =====
		 1  ====================          ==========
		    0123456789012345678901234567890123456789
		 */
		/*
		(0,  5,  1)
		(5,  10, 2)
		(10, 15, 5)
		(15, 20, 3)
		(20, 30, 0)
		(30, 35, 1)
		(35, 40, 5)
		 */
	}
}
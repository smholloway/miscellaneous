package com.sethholloway;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SkylineTest {
	Skyline skyline;
	
	public void init() {
		skyline.addBuilding(new Building(0,  10, 1));
		skyline.addBuilding(new Building(5,  10, 2));
		skyline.addBuilding(new Building(10, 20, 3));
		skyline.addBuilding(new Building(10, 15, 5));
		skyline.addBuilding(new Building(15, 20, 2));
		skyline.addBuilding(new Building(30, 35, 1));
		skyline.addBuilding(new Building(35, 40, 5 ));
	}
	
	@Before
	public void setUp() throws Exception {
		skyline = new Skyline();
	}
	
	@Test
	public void testSort() {
		List<Building> buildings = new ArrayList<Building>();
		buildings.add(new Building(0, 4, 1));
		buildings.add(new Building(2, 6, 2));
		buildings.add(new Building(4, 6, 3));
		assertEquals("Tallest", buildings, skyline.sort(buildings));
	}

	@Test
	public void testTallestAtPoint() {
		skyline.addBuilding(new Building(0, 4, 1));
		skyline.addBuilding(new Building(2, 6, 2));
		skyline.addBuilding(new Building(4, 6, 3));
		assertEquals("Tallest", 1, skyline.tallestAtPoint(1));
		assertEquals("Tallest", 2, skyline.tallestAtPoint(3));
		assertEquals("Tallest", 3, skyline.tallestAtPoint(5));
	}
	
	@Test
	public void testAddBuilding() {
		skyline.addBuilding(new Building(0,  10, 1));
		skyline.addBuilding(new Building(5,  10, 2));
		skyline.addBuilding(new Building(10, 20, 3));
		skyline.addBuilding(new Building(10, 15, 5));
		skyline.addBuilding(new Building(15, 20, 2));
		skyline.addBuilding(new Building(30, 35, 1));
		skyline.addBuilding(new Building(35, 40, 5 ));
	}
	
	@Test
	public void testPrint() {
		assertEquals("printBlank", "", skyline.toString());
		init();
		assertEquals("printBlank", "(0, 10, 1)(5, 10, 2)(10, 20, 3)(10, 15, 5)(15, 20, 2)(30, 35, 1)(35, 40, 5)", skyline.toString());
		
		/*
		 5            =====                    =====
		 4            =====                    ===== 
         3            ==========		       =====
		 2       ===============               =====
		 1  ====================          ==========
		    0123456789012345678901234567890123456789
		 */
		/*
		(0,  5,  1) //(x1, x2, height)
		(5,  10, 2)
		(10, 15, 5)
		(15, 20, 3)
		(20, 30, 0)
		(30, 35, 1)
		(35, 40, 5)
		 */
	}

}

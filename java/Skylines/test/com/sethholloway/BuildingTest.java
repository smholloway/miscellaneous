package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuildingTest {
	Building building;
	
	@Before
	public void setup() {
		building = new Building();
	}

	@Test
	public void testDefaultConstructor() {
		assertEquals("X1",     0, building.getX1());
		assertEquals("X2",     0, building.getX2());
		assertEquals("Height", 0, building.getHeight());
	}
	
	@Test
	public void testBuildingIntIntInt() {
		Building b = new Building(0, 1, 1);
		assertEquals("X1",     0, b.getX1());
		assertEquals("X2",     1, b.getX2());
		assertEquals("Height", 1, b.getHeight());
	}

	@Test
	public void testBuilding() {
		Building b = new Building();
		assertEquals("X1",     0, b.getX1());
		assertEquals("X2",     0, b.getX2());
		assertEquals("Height", 0, b.getHeight());
	}

	@Test
	public void testGetX1() {
		Building b = new Building(0, 1, 1);
		assertEquals("X1", 0, b.getX1());
	}

	@Test
	public void testGetX2() {
		Building b = new Building(0, 1, 1);
		assertEquals("X2", 1, b.getX2());
	}

	@Test
	public void testGetHeight() {
		Building b = new Building(0, 1, 1);
		assertEquals("Height", 1, b.getHeight());
	}
	
	@Test
	public void testPrint() {
		assertEquals("toString", "(0, 0, 0)", building.toString());
	}
}

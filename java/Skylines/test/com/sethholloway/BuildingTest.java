package com.sethholloway;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BuildingTest {

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
	public void testSort() {
		List<Building> buildings = new ArrayList<Building>();
		buildings.add(new Building(0, 4, 1));
		buildings.add(new Building(2, 6, 2));
		buildings.add(new Building(4, 6, 3));
		assertEquals("Tallest", buildings, Building.sort(buildings));
	}

	@Test
	public void testTallestAtPoint() {
		List<Building> buildings = new ArrayList<Building>();
		buildings.add(new Building(0, 4, 1));
		buildings.add(new Building(2, 6, 2));
		buildings.add(new Building(4, 6, 3));
		assertEquals("Tallest", 1, Building.tallestAtPoint(buildings, 1));
		assertEquals("Tallest", 2, Building.tallestAtPoint(buildings, 3));
		assertEquals("Tallest", 3, Building.tallestAtPoint(buildings, 5));
	}

	@Test
	public void testRemoveDuplicateWithOrder() {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> noDuplicatesManual = new ArrayList<Integer>();
		list.add(0);
		list.add(0);  noDuplicatesManual.add(0);
		list.add(1);  noDuplicatesManual.add(1);
		list.add(2);  noDuplicatesManual.add(2);
		List<Integer> noDuplicates = (List<Integer>)Building.removeDuplicateWithOrder(list);
		assertEquals("Duplicates", noDuplicatesManual, noDuplicates);
	}
}

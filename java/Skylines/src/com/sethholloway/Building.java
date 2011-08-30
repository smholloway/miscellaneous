package com.sethholloway;

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
	
	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return ("(" + this.x1 + ", " + this.x2 + ", " + this.height + ")");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof Building)) {
			return false;
		}
		
		Building other = (Building) obj;
		
		if (height != other.height)
			return false;
		if (x1 != other.x1) {
			return false;
		} else if (x2 != other.x2) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + height;
		result = prime * result + x1;
		result = prime * result + x2;
		
		return result;
	}
}
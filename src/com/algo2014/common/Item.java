package com.algo2014.common;

public class Item implements Comparable<Item> {

	public final Integer i;
	public Item(int i){
		this.i  = i;
	}
	@Override
	public int compareTo(Item arg0) {
		return i.compareTo(arg0.i);
	}

	public int getValue(){
		return i;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [i=" + i + "]";
	}
	
}

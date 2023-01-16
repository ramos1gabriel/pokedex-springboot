package com.pokedex.springboot.api.model;

import java.util.ArrayList;

public class Pokemon {
	private int count;
	private String next;
    private Object previous;
    private ArrayList<Result> results;
    
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public Object getPrevious() {
		return previous;
	}
	public void setPrevious(Object previous) {
		this.previous = previous;
	}
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
}

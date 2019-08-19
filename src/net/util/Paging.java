package net.util;

public class Paging {
	private int current_min_page;
	private int current_max_page;
	private int max_page;

	public int getCurrent_min_page() {
		return current_min_page;
	}

	public void setCurrent_min_page(int current_min_page) {
		this.current_min_page = current_min_page;
	}

	public int getCurrent_max_page() {
		return current_max_page;
	}

	public void setCurrent_max_page(int current_max_page) {
		this.current_max_page = current_max_page;
	}

	public int getMax_page() {
		return max_page;
	}

	public void setMax_page(int max_page) {
		this.max_page = max_page;
	}

}

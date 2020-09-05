package ProgressBar;

abstract public class ProgressBar implements ProgressBarInterface {
	
	private long total = 10;	
	private int width = 10;
	
	public ProgressBar() {}
	
	public ProgressBar(int width) {
		this.setWidth(width);
	}
	
	public ProgressBar(int width, long total) {
		this.setWidth(width);
		this.setTotal(total);
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public long getTotal() {
		return this.total;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public long getWidth() {
		return this.width;
	}
	
	abstract public void show(long progress);
}

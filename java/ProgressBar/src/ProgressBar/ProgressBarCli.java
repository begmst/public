package ProgressBar;

public class ProgressBarCli extends ProgressBar {
	
	public ProgressBarCli(int width) {
		super(width);
	}

	public ProgressBarCli(int width, long total) {
		super(width, total);
	}

	public void show(long progress) {
	    long perc = Math.round(progress * 100) / this.getTotal();
	    int bar = Math.round((this.getWidth() * perc) / 100);
	    String line = "=".repeat(bar);
	    String space = " ".repeat((int) (this.getWidth() - bar));
	    String output = "\r".concat(String.format("[%s>%s]%s%%", line, space, perc));
	    if (progress < this.getTotal()) {
		    System.out.print(output);
	    } else {
		    System.out.println(output);	    	
	    }
	}
}

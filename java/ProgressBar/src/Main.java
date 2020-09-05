import Downloader.Downloader;
import ProgressBar.ProgressBarCli;
import ProgressBar.ProgressBarInterface;

public class Main {
	public static void main(String[] args) {
		String url = args[0];
		System.out.println("URL: ".concat(url));
		
//		Main.testProgressBar();
		
		ProgressBarInterface progressBar = new ProgressBarCli(100);
		Downloader d = new Downloader(url, progressBar);
		d.start();
		try {
			d.join();
		} catch (InterruptedException e) {
		}
	}
	
	protected static void testProgressBar()
	{
		int width = 10;
		int total = 10;
		ProgressBarCli pb = new ProgressBarCli(width, total);
		try {
			for (int i = 0; i <= total; i++) {
				pb.show(i);
				Thread.sleep(200);
			}
		} catch (InterruptedException  e) {
		}
	}
}

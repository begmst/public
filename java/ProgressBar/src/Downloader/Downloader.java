package Downloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import ProgressBar.ProgressBarInterface;

public class Downloader extends Thread {
	
	private String url;
	private ProgressBarInterface progressBar;
	
	public Downloader(String url, ProgressBarInterface progressBar) {
		this.url = url;
		this.progressBar = progressBar;		
	}
	public void run() {
		URL url = null;
		String filename = null;
		try {
			url = new URL(this.url);
			String filepath = url.getPath();
			String[] parts = filepath.split("/");
			filename = parts[parts.length - 1];
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection httpConnection = null;
		try {
			httpConnection = (HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			httpConnection.setRequestMethod("HEAD");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long removeFileSize = httpConnection.getContentLengthLong();
		System.out.println(String.format("File size: %d bytes.", removeFileSize));
		this.progressBar.setTotal(removeFileSize);
		
		try {
			BufferedInputStream in = new BufferedInputStream(url.openStream());
			
			FileOutputStream fileOutputStream = new FileOutputStream(filename); 
		    byte dataBuffer[] = new byte[1024 * 10];
		    int bytesRead, totalBytesRead = 0;
		    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
		        fileOutputStream.write(dataBuffer, 0, bytesRead);
		        totalBytesRead += bytesRead;
		        this.progressBar.show(totalBytesRead);
		    }			
		    in.close();
		    fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

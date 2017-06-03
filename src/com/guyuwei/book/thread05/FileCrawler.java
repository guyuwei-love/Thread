package com.guyuwei.book.thread05;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileCrawler implements Runnable{
	
	private final BlockingQueue<File> fileQueue;
	
	private final FileFilter fileFilter;
	
	private final File root;
	
	public FileCrawler(BlockingQueue<File> fileQueue,FileFilter fileFilter,File root){
		this.fileQueue = fileQueue;
		this.fileFilter = fileFilter;
		this.root = root;
	}
	
	@Override
	public void run() {
		try {
			crawl(root);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void crawl(File root) throws InterruptedException{
		File [] entries = root.listFiles();
		if(null != entries){
			for (File entry : entries) {
				if(entry.isDirectory()){
					crawl(entry);
				}else{
					fileQueue.put(entry);
				}
				
			}
		}
	}

	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\acer\\Desktop");
		File[] roots = new File[]{file};
		Main.startIndexing(roots);
	}
}

class Indexer implements Runnable{

	private final BlockingQueue<File> queue;
	
	public Indexer(BlockingQueue<File> queue_){
		queue = queue_;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				File take = queue.take();
				System.out.println(take.getName());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}

class Main{
	
	public static final int BOUND = 100;
	public static final int N_CONSUMERS = 100;
	
	public static void startIndexing(File[] roots){
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
		FileFilter fileFilter = new FileFilter(){
			public boolean accept(File file){
				return true;
			};
		};
		
		for (File file : roots) {
			new Thread(new FileCrawler(queue,fileFilter,file)).start();
		}
		
		for (int i= 0;i<N_CONSUMERS;i++) {
			new Thread(new Indexer(queue)).start();
		}
	}
	
	
}

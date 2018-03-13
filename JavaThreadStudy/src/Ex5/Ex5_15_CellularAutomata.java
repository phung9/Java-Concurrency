package Ex5;

import java.util.concurrent.*;
import java.util.concurrent.CyclicBarrier;

public class Ex5_15_CellularAutomata {
	private final Board mainBoard;
	private final CyclicBarrier barrier;
	private final Worker[] workers;
	
	public Ex5_15_CellularAutomata(Board board) {
		this.mainBoard = board;
		int count = Runtime.getRuntime().availableProcessors();
		this.barrier = new CyclicBarrier(count, new Runnable() {
			public void run() {
				mainBoard.commitNewValues();
			}
		});
		this.workers = new Worker[count];
		for(int i = 0 ; i< count ; i ++)
			workers[i] = new Worker(mainBoard.getSubBoard(count, i));		
	}
	//catch¹® BrokenBarrierException ÀÔ·Â ¾ÈµÊ.
	private class Worker implements Runnable {
		private final Board board;
		
		public Worker(Board board) { this.board = board; }
		public void run() {
			while (!board.hasConverged()) {
				for(int x= 0 ; x < board.getMaxX(); x++)
					for(int y = 0 ; y < board.getMaxY(); y++)
						board.setNewValue(x, y, computeValue(x,y));
				try {
					barrier.wait();
				} catch (InterruptedException ex) {
					return;
				}
			}
		}
		private int computeValue(int x, int y) {
			// Compute the new value that goes in (x,y)
			return 0;
		}
	}
	
	public void start() {
		for(int i = 0 ; i < workers.length ; i++)
			new Thread(workers[i]).start();
		mainBoard.waitForConvergence();
	}

	
	
	interface Board {
		int getMaxX();
		int getMaxY();
		int getValue(int x, int y);
		int setNewValue(int x, int y, int value);
		void commitNewValues();
		boolean hasConverged();
		void waitForConvergence();
		Board getSubBoard(int newPartitions, int index);
	}
	
}

package Ex4;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ex4_9_VisualComponent {
	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>();
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();
	
	public void addKeyListener(KeyListener listener) {
		keyListeners.add(listener);
	}
	
	public void addMouseListener(MouseListener listener) {
		mouseListeners.add(listener);
	}
	
	public void removeKeyListener(KeyListener listener) {
		keyListeners.remove(listener);
	}
	
	public void removeMouseListener(MouseListener listener) {
		mouseListeners.remove(listener);
	}
}

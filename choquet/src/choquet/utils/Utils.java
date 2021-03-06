package choquet.utils;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class Utils {
	public static void centrerFenetre(Display display, Shell shell){
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + ((bounds.width - rect.width) / 2);
		int y = bounds.y + ((bounds.height - rect.height) / 2);
		shell.setLocation(x, y);
	}

	public static int getMaxHeight(Display display){
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		return bounds.height;
	}
}

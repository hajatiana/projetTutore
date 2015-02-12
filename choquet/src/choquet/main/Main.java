package choquet.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import choquet.utils.Utils;
import choquet.view.MainView;

public class Main {
	public static void main(String[] args) {
		int shellWidth=998, shellHeight=700;
		Display display = new Display();
		Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		shell.setText("Classification par la méthode d'intégrale de Choquet");
		shell.setSize(shellWidth, shellHeight);
		shell.setLayout(new GridLayout(1, false));
		shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new MainView(shell);
		Utils.centrerFenetre(display, shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		System.exit(-1);
	}
}


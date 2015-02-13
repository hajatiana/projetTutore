package choquet.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import choquet.utils.Utils;
import choquet.view.MainView;

public class Main {
	public static void main(String[] args) {
		Display display = new Display();
		int shellWidth=998, shellHeight=Utils.getMaxHeight(display);
		Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.RESIZE);
		shell.setText("Classification par la méthode d'intégrale de Choquet");
		shell.setSize(shellWidth, shellHeight);
		shell.setLayout(new GridLayout(1, false));
		shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		MainView mainView = new MainView(scrolledComposite);
		Utils.centrerFenetre(display, shell);
		
		scrolledComposite.setContent(mainView);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setMinSize(mainView.computeSize(SWT.DEFAULT, SWT.DEFAULT));
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


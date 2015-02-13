package choquet.view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import choquet.model.Node;
import choquet.utils.Utils;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddDataView{
	
	private Shell shell;	
	private Button btnOk;

	public AddDataView(Shell parentShell, List<Node> listNode) {
	    shell = new Shell(parentShell, SWT.TITLE | SWT.CLOSE );
	    shell.setSize(400, 400);
	    Utils.centrerFenetre(Display.getCurrent(), shell);
	    shell.setLayout(new GridLayout(1, false));
	    
	    Composite composite = new Composite(shell, SWT.NONE);
	    composite.setLayout(new GridLayout(1, false));
	    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	    
	    Composite composite_1 = new Composite(composite, SWT.NONE);
	    composite_1.setLayout(new GridLayout(4, true));
	    composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
	    
	    Composite composite_2 = new Composite(composite, SWT.NONE);
	    composite_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
	    composite_2.setLayout(new GridLayout(1, false));
	    
	    btnOk = new Button(composite_2, SWT.NONE);
	    
	    GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
	    gd_btnNewButton.heightHint = 27;
	    gd_btnNewButton.widthHint = 99;
	    btnOk.setLayoutData(gd_btnNewButton);
	    btnOk.setText("OK");
	    
	    for (Node node : listNode) {
	    	Label lblNewLabel = new Label(composite_1, SWT.NONE);
		    lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		    lblNewLabel.setText(node.getName()+" = ");		    
		    Text text = new Text(composite_1, SWT.BORDER);
		    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}	    
	    	    	    
	    parentShell.setEnabled(false);	
	    bind();
	}
	
	public void bind(){
		shell.addDisposeListener(new DisposeListener() {			
			public void widgetDisposed(DisposeEvent arg0) {
				shell.getParent().setEnabled(true);
			}
		});
		
		btnOk.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		shell.dispose();
	    	}
	    });
	}
	
	public void open(){
		shell.open();
	}
}

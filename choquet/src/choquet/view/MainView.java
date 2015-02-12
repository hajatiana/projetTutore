package choquet.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import choquet.controleur.NodeController;
import choquet.controleur.TreilliController;
import choquet.model.Node;
import choquet.model.Step;
import choquet.model.Treilli;

public class MainView extends Composite{
	private TreilliController treilliController;
	private NodeController nodeController;
	private Treilli treilli;
	private int nodeIntervalle=50;
	private int nodeSpace;
	private final int PADDING_TOP = 30;

	private Table table;
	private Text txtNumberOfCriteria;
	private Button btnCalculate;
	private Composite compositeGraph;
	private ScrolledComposite scrolledComposite;
	private Text txtBrowse;
	private Button btnParcourir;

	public MainView(Shell shell){
		super(shell, SWT.NONE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setBackgroundMode(SWT.INHERIT_FORCE);
		setLayout(new GridLayout(1,true));
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		createPartControl();
		bind();
	}

	public void addItemToTable(){
		for (Step step : treilli.getSteps()) {
			for (Node node : step) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, nodeController.getNodeName(node));
				item.setText(1, String.valueOf(node.getWeight()));
			}
		}
	}

	public void bind(){
		txtNumberOfCriteria.addListener(SWT.Verify, new Listener() {
			public void handleEvent(Event e) {
				String string = e.text;
				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++) {
					if (!(('0' <= chars[i]) && (chars[i] <= '9'))) {
						e.doit = false;
						return;
					}
				}
			}
		});

		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtNumberOfCriteria.getText().isEmpty()){
					MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
					messageBox.setMessage("Number of criteria cannot be null");
					messageBox.setText("Error Message");
					messageBox.open();
					return;
				}

				reset();
				scrolledComposite.redraw();

				treilliController = new TreilliController();
				nodeController = new NodeController();
				treilli = treilliController.createTreilli(Integer.parseInt(txtNumberOfCriteria.getText()));
				nodeSpace=treilli.getSize()*20;

				addItemToTable();
				createGraphControl(compositeGraph);

				scrolledComposite.setContent(compositeGraph);
				scrolledComposite.setExpandHorizontal(true);
				scrolledComposite.setExpandVertical(true);
				scrolledComposite.setMinSize((treilli.getMaxStepSize()*nodeIntervalle)+100, treilli.getSize()*nodeSpace);
			}
		});

		btnParcourir.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				FileDialog leDialogue = new FileDialog(getShell(), SWT.OPEN);
				leDialogue.setText("Choix du répertoire");
				try{
					txtBrowse.setText(leDialogue.open());
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					return;
				}
			}
		}
				);
	}

	public void createGraphControl(final Composite composite) {
		composite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawRectangle(0, 0, composite.getBounds().width-1, composite.getBounds().height-1);
				gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
				FontMetrics fm = gc.getFontMetrics();
				int charWidth = fm.getAverageCharWidth();
				int width;
				for (Step step : treilli.getSteps()) {
					int i=0;
					int origine = (composite.getBounds().width-(nodeIntervalle*step.size()))/2;
					for (Node node : step) {
						node.setX(origine+(nodeIntervalle*i));
						node.setY(PADDING_TOP+(nodeSpace*(step.getNumber()-1)));
						width = node.getName().length()*charWidth;
						gc.drawText(node.getName(), node.getX()-(width/2), node.getY());

						i++;
						for (Node parent : node.getParents()) {
							gc.drawLine(node.getX(), node.getY(), parent.getX(), parent.getY()+15);
						}
					}
				}
			}
		});
	}

	private void createPartControl(){

		Composite panelComposite = new Composite(this, SWT.NONE);
		panelComposite.setLayout(new GridLayout(3, false));
		panelComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNumberOfCriteria = new Label(panelComposite, SWT.NONE);
		lblNumberOfCriteria.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNumberOfCriteria.setText("Number of criteria decision");

		txtNumberOfCriteria = new Text(panelComposite, SWT.BORDER);
		GridData gd_txtNumberOfCriteria = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtNumberOfCriteria.widthHint = 107;
		txtNumberOfCriteria.setLayoutData(gd_txtNumberOfCriteria);
		new Label(panelComposite, SWT.NONE);

		Label lblPathOfData = new Label(panelComposite, SWT.NONE);
		lblPathOfData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPathOfData.setText("Path of data file");

		txtBrowse = new Text(panelComposite, SWT.BORDER);
		txtBrowse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnParcourir = new Button(panelComposite, SWT.NONE);
		btnParcourir.setText("...");
		new Label(panelComposite, SWT.NONE);
		new Label(panelComposite, SWT.NONE);

		btnCalculate = new Button(panelComposite, SWT.NONE);

		btnCalculate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnCalculate.setText("Calculate");

		Label lblSeperator = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_lblSeperator = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblSeperator.verticalIndent = 10;
		lblSeperator.setLayoutData(gd_lblSeperator);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		CLabel lblResult = new CLabel(composite, SWT.NONE);
		lblResult.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblResult.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblResult.setText("Result of identification");

		CLabel lblLattice = new CLabel(composite, SWT.NONE);
		lblLattice.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblLattice.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblLattice.setText("Lattice Graph");

		Composite compositeResult = new Composite(composite, SWT.NONE);
		compositeResult.setLayout(new GridLayout(1, false));
		GridData gdResult = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdResult.widthHint = 205;
		gdResult.heightHint = 400;
		compositeResult.setLayoutData(gdResult);

		table = new Table(compositeResult, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Node Name");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(73);
		tblclmnNewColumn_1.setText("Weight");

		Composite compositeLattice = new Composite(composite, SWT.NONE);
		GridData gdLattice = new GridData(SWT.FILL, SWT.FILL, true, true);
		compositeLattice.setLayoutData(gdLattice);
		compositeLattice.setLayout(new GridLayout(1,false));
		compositeLattice.setSize(compositeLattice.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		scrolledComposite = new ScrolledComposite(compositeLattice, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeGraph = new Composite(scrolledComposite, SWT.NONE);
		compositeGraph.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));

		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	public void reset(){
		table.removeAll();
	}
}

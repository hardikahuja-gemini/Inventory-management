package sporty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
//import com.advance.MyNotePad.MyListener;

public class TableModel extends Frame {

	Vector selectedCells= new Vector<int[]>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
					Vector v = null;
						Vector str = null;
						TableModel frame = new TableModel(str,v);
					
				
		
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public TableModel(Vector str,Vector v) throws ClassNotFoundException {
		setTitle("Tabular display.");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		frame.setBackground(UIManager.getColor(Color.BLUE));
		
		

		DefaultTableModel model=new DefaultTableModel() ;
		
		model.setDataVector(str,v);
		final JTable jt=new JTable(model);
		
		jt.setColumnSelectionAllowed(true);
		jt.setCellSelectionEnabled(true);
		jt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jt.setBounds(30,40,200,300);
		JMenuBar  menubar=new JMenuBar();
		JMenu  menu1=new JMenu("File");
		JMenuItem  menuitem1=new JMenuItem("Print");
		menubar.add(menu1);
		menu1.add(menuitem1);
		//frame.getContentPane().add(menu1);
		frame.setJMenuBar(menubar);
		ActionListener listener1 = null;
		menuitem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat("Ahuja Enterprises");
		        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
				try {
					jt.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			 
		});

		//MyListener listener1=new MyListener();
		try{
			JScrollPane sp=new JScrollPane(jt);
			frame.getContentPane().add(sp, BorderLayout.CENTER);

			frame.setSize(602,412);
			//			f.setLayout(null);
			MouseListener tableMouseListener=new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					System.out.println(e.MOUSE_CLICKED);
					if(e.MOUSE_CLICKED !=-1)
					{
						int row=jt.rowAtPoint(e.getPoint());
//						int col=jt.columnAtPoint(e.getPoint());  to get column value

						ViewModifyData screen = new ViewModifyData(jt.getValueAt(row,7).toString());  // adjust according to itemCode position
						screen.setVisible(true);
					}	
					
				}	
			};
			jt.addMouseListener(tableMouseListener);
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	}

package sporty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.UIManager;

import com.sporty.dao.DatabaseConnection;

public class ViewModifyData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String item = "";
	Connection con = null;
	private PreparedStatement ps = null;
	public static void main(String[] args) {

		ViewModifyData frame = new ViewModifyData();
		frame.setVisible(true);

	}

	public ViewModifyData(String itemCode){
		try {
			item = itemCode;

			setTitle("Searching and updation");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 578, 360);
			contentPane = new JPanel();
			setBackground(UIManager.getColor(Color.BLUE));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			textField = new JTextField();
			textField.setBounds(166, 8, 97, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			JLabel lblItemType = new JLabel("Model Name");
			lblItemType.setBounds(10, 49, 77, 14);
			contentPane.add(lblItemType);

			JLabel lblItemName = new JLabel("Item Name");
			lblItemName.setBounds(10, 11, 77, 14);
			contentPane.add(lblItemName);

			JLabel lblItemCode = new JLabel("Company Name");
			lblItemCode.setBounds(10, 94, 89, 14);
			contentPane.add(lblItemCode);

			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(166, 46, 97, 20);
			contentPane.add(textField_1);

			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(166, 91, 97, 20);
			contentPane.add(textField_2);

			JButton btnClose = new JButton("Delete");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String	query = "delete from  sport  where itemCode='"+item+"' ";
					int option = JOptionPane.showConfirmDialog(null, "Are you confirm", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

					if(option == JOptionPane.OK_OPTION)
					{

						try {
							ps = con.prepareStatement(query);
							int i = ps.executeUpdate();
							if(i!= -1){
								JOptionPane.showMessageDialog(ViewModifyData.this,"DELETED!");

								System.out.println("deleted");
							}
							else
								JOptionPane.showMessageDialog(ViewModifyData.this,"Not deleted!");

						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}
			});
			btnClose.setBounds(371, 240, 89, 23);
			contentPane.add(btnClose);

			JLabel lblEnterTheMrp = new JLabel("Enter the mrp");
			lblEnterTheMrp.setBounds(10, 172, 77, 14);
			contentPane.add(lblEnterTheMrp);

			textField_3 = new JTextField();
			textField_3.setBounds(166, 133, 97, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			JButton btnUpdate = new JButton("Update");
			btnUpdate.setBounds(371, 45, 89, 23);
			contentPane.add(btnUpdate);

			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String	query = "update sport set itemName='"+textField.getText()+"', Type ='"+textField_7.getText()+"', stock ='"+textField_6.getText()+"', Colour ='"+textField_5.getText()+"',mrp ='"+textField_4.getText()+"', modelName ='"+textField_1.getText()+"',companyName ='"+textField_2.getText()+"'where itemCode='"+item+"' ";
					int option = JOptionPane.showConfirmDialog(null, "Are you confirm", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

					if(option == JOptionPane.OK_OPTION)
					{
						try {
							ps = con.prepareStatement(query);
							int i = ps.executeUpdate();
							if(i!= -1){
								JOptionPane.showMessageDialog(ViewModifyData.this,"Updated!!");

								System.out.println("updated");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						// do something
					}
				}
			});

			JLabel lblEnterTheDiscount = new JLabel("Enter the Colour");
			lblEnterTheDiscount.setBounds(10, 210, 146, 14);
			contentPane.add(lblEnterTheDiscount);

			textField_4 = new JTextField();
			textField_4.setBounds(166, 169, 97, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			JLabel lblEnterTheStock = new JLabel("Enter the stock");
			lblEnterTheStock.setBounds(10, 249, 110, 14);
			contentPane.add(lblEnterTheStock);

			textField_5 = new JTextField();
			textField_5.setBounds(166, 207, 97, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);

			JLabel lblEnterTheNeeded = new JLabel("Enter the Type");
			lblEnterTheNeeded.setBounds(10, 283, 146, 14);
			contentPane.add(lblEnterTheNeeded);

			textField_6 = new JTextField();
			textField_6.setBounds(166, 246, 96, 20);
			contentPane.add(textField_6);
			textField_6.setColumns(10);

			JLabel lblNewLabel = new JLabel("Item code");
			lblNewLabel.setBounds(10, 136, 124, 14);
			contentPane.add(lblNewLabel);

			textField_7 = new JTextField();
			textField_7.setBounds(166, 280, 97, 20);
			contentPane.add(textField_7);
			textField_7.setColumns(10);
			con = DatabaseConnection.getConnection();

			String query = "select * from sport where itemCode='"+item+"' ";
			if(!textField.getText().isEmpty())
				query +="where  itemName ='"+textField.getText()+" ";
			if(!textField_1.getText().isEmpty())
				query +="and modelName ='"+textField_1.getText()+" ";
			if(!textField_2.getText().isEmpty())
				query +="and companyName ='"+textField_2.getText()+" ";
			if(!textField_3.getText().isEmpty())
				query +="where  itemcode ='"+textField_3.getText()+" ";
			if(!textField_4.getText().isEmpty())
				query +="and mrp ='"+textField_4.getText()+" ";
			if(!textField_5.getText().isEmpty())
				query +="and Colour ='"+textField_5.getText()+" ";
			if(!textField_6.getText().isEmpty())
				query +="where  stock ='"+textField_6.getText()+" ";
			if(!textField_7.getText().isEmpty())
				query +="and Type ='"+textField_7.getText()+" ";

			ps = con.prepareStatement(query);
			ResultSet i=ps.executeQuery();
			Vector<String> row = new Vector<>();
			while(i.next()){
				//row.addElement(i.getString("itemid"));
				row.addElement(i.getString("itemName"));
				row.addElement(i.getString("modelName"));
				row.addElement(i.getString("companyName"));
				row.addElement(i.getString("mrp"));
				row.addElement(i.getString("Colour"));
				row.addElement(i.getString("stock"));
				row.addElement(i.getString("Type"));
				row.addElement(i.getString("itemCode"));

			}
			textField.setText(row.elementAt(0));
			textField_1.setText(row.elementAt(1));
			textField_2.setText(row.elementAt(2));
			textField_3.setText(row.elementAt(7));
			textField_4.setText(row.elementAt(3));
			textField_5.setText(row.elementAt(4));
			textField_6.setText(row.elementAt(5));
			textField_7.setText(row.elementAt(6));
			System.out.println("here");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		} 
	}

	public ViewModifyData() {
		setTitle("Searching and updation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 421);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(166, 25, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblItemType = new JLabel("Model Name");
		lblItemType.setBounds(10, 74, 77, 14);
		contentPane.add(lblItemType);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(10, 28, 77, 14);
		contentPane.add(lblItemName);

		JLabel lblItemCode = new JLabel("Company Name");
		lblItemCode.setBounds(10, 116, 89, 14);
		contentPane.add(lblItemCode);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 71, 97, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(166, 113, 97, 20);
		contentPane.add(textField_2);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					con =DatabaseConnection.getConnection();
					PreparedStatement ps = null;
					String query = "select * from sport where 1=1 ";
					if(!textField.getText().isEmpty())
						query +="and itemName ='"+textField.getText()+"' ";
					if(!textField_1.getText().isEmpty())
						query +="and modelName ='"+textField_1.getText()+"' ";
					if(!textField_2.getText().isEmpty())
						query +="and companyName ='"+textField_2.getText()+"' ";
					if(!textField_3.getText().isEmpty())
						query +=" and itemcode ='"+textField_3.getText()+"' ";
					if(!textField_4.getText().isEmpty())
						query +="and mrp ='"+textField_4.getText()+"' ";
					if(!textField_5.getText().isEmpty())
						query +="and Colour ='"+textField_5.getText()+"' ";
					if(!textField_6.getText().isEmpty())
						query +="where stock ='"+textField_6.getText()+"' ";
					if(!textField_7.getText().isEmpty())
						query +="and Type ='"+textField_7.getText()+"' ";
					System.out.println(query);

					ps = con.prepareStatement(query);

					Vector<Vector> rowData=new Vector<Vector>();
					ResultSet i=ps.executeQuery();
					while(i.next()){
						Vector<String> row = new Vector<String>();
						//row.addElement(i.getString("itemid"));
						row.addElement(i.getString("itemName"));
						row.addElement(i.getString("modelName"));
						row.addElement(i.getString("companyName"));
						row.addElement(i.getString("mrp"));
						row.addElement(i.getString("Colour"));
						row.addElement(i.getString("stock"));
						row.addElement(i.getString("Type"));
						row.addElement(i.getString("itemcode"));
						rowData.add(row);

						//					System.out.println(i.getString("itemName"));
						//						System.out.println(i.getString("modelName"));
						//						System.out.println(i.getString("companyName"));
					}


					ps=con.prepareStatement("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'sport' ORDER BY ORDINAL_POSITION");
					ResultSet res=ps.executeQuery();
					Vector<String> columnname=new Vector<String>();
					while(res.next())
					{
						columnname.addElement(res.getString("COLUMN_NAME"));

					}
					//	 System.out.println(row);
					System.out.println(columnname);
					TableModel r=new TableModel(rowData,columnname);
					r.setVisible(true);
					//dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();


				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSearch.setBounds(371, 45, 89, 23);
		contentPane.add(btnSearch);

		JButton btnClose = new JButton("Clear");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnClose.setBounds(371, 240, 89, 23);
		contentPane.add(btnClose);

		JLabel lblEnterTheMrp = new JLabel("Enter the mrp");
		lblEnterTheMrp.setBounds(10, 195, 77, 14);
		contentPane.add(lblEnterTheMrp);

		textField_3 = new JTextField();
		textField_3.setBounds(166, 155, 97, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblEnterTheDiscount = new JLabel("Enter the colour");
		lblEnterTheDiscount.setBounds(10, 220, 146, 14);
		contentPane.add(lblEnterTheDiscount);

		textField_4 = new JTextField();
		textField_4.setBounds(166, 186, 97, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblEnterTheStock = new JLabel("Enter the stock");
		lblEnterTheStock.setBounds(10, 263, 110, 14);
		contentPane.add(lblEnterTheStock);

		textField_5 = new JTextField();
		textField_5.setBounds(166, 217, 97, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblEnterTheNeeded = new JLabel("Enter the Type");
		lblEnterTheNeeded.setBounds(10, 305, 146, 14);
		contentPane.add(lblEnterTheNeeded);

		textField_6 = new JTextField();
		textField_6.setBounds(167, 260, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel = new JLabel("Item code");
		lblNewLabel.setBounds(10, 158, 124, 14);
		contentPane.add(lblNewLabel);

		textField_7 = new JTextField();
		textField_7.setBounds(166, 302, 97, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}
}

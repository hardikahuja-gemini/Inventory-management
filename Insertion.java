package sporty;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

import com.sporty.dao.DatabaseConnection;

public class Insertion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextArea textField_2;
	private JTextField textField;



	public static void main(String[] args) throws ClassNotFoundException, Exception {

		Insertion frame = new Insertion();
		frame.setVisible(true);
	}



	public Insertion() throws ClassNotFoundException, SQLException {
		setTitle("Insertion area...");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 407);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setForeground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter the item code");
		lblNewLabel.setBounds(10, 143, 126, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(239, 137, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEnterTheType = new JLabel("Enter The  type of item");
		lblEnterTheType.setBounds(10, 11, 126, 14);
		contentPane.add(lblEnterTheType);

		JLabel lblEnterTheModel = new JLabel("Enter the model number");
		lblEnterTheModel.setBounds(10, 59, 141, 14);
		contentPane.add(lblEnterTheModel);

		textField_1 = new JTextField();
		textField_1.setBounds(239, 56, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEnterTheCompany = new JLabel("  Enter the company name");
		lblEnterTheCompany.setBounds(0, 111, 151, 14);
		contentPane.add(lblEnterTheCompany);

		JLabel lblEnterTheMrp = new JLabel("Enter the M.R.P");
		lblEnterTheMrp.setBounds(10, 247, 116, 14);
		contentPane.add(lblEnterTheMrp);

		textField_3 = new JTextField();
		textField_3.setBounds(239, 244, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblEnterTheDiscounted = new JLabel("Enter the color");
		lblEnterTheDiscounted.setBounds(10, 290, 162, 14);
		contentPane.add(lblEnterTheDiscounted);

		textField_4 = new JTextField();
		textField_4.setBounds(239, 287, 180, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblEnterTheNoof = new JLabel("Enter the no.of stock");
		lblEnterTheNoof.setBounds(10, 168, 124, 14);
		contentPane.add(lblEnterTheNoof);

		textField_5 = new JTextField();
		textField_5.setBounds(239, 165, 180, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNeededStock = new JLabel("Type of model");
		lblNeededStock.setBounds(10, 209, 102, 14);
		contentPane.add(lblNeededStock);

		textField_6 = new JTextField();
		textField_6.setBounds(239, 206, 180, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_2 = new JTextArea();
		textField_2.setBounds(239, 106, 180, 20);
		contentPane.add(textField_2);


		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(239, 8, 180, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Fan");
		comboBox.addItem("Switches");
		comboBox.addItem("Lights");
		comboBox.addItem("Pump");
		comboBox.addItem("Heaters");
		comboBox.addItem("Exhaust");
		comboBox.addItem("Table Fan");
		comboBox.addItem("Farrata");
		comboBox.addItem("Spare parts");
		comboBox.addItem("Mixer Grinders");
		comboBox.addItem("Ceiling Fan");
		comboBox.addItem("others");

		JButton btnNewButton = new JButton("Save record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String item=comboBox.getSelectedItem().toString();

					String modelnm=textField_1.getText();
					if(textField_1.getText().isEmpty())
					{
						modelnm="0";
					}
					String compnm=textField_2.getText();
					if(textField_2.getText().isEmpty())
					{
						compnm="0";
					}

					String mrp=textField_3.getText();
					if(textField_3.getText().isEmpty())
					{
						mrp="0";
					}

					float Mrp=Float.parseFloat(mrp);
					String color=textField_4.getText();
					if(textField_4.getText().isEmpty())
					{
						color="0";
					}

					//float Dmrp= Float.parseFloat(dmrp);
					String stk=textField_5.getText();
					if(textField_5.getText().isEmpty())
					{
						stk="0";
					}

					int Stk=Integer.parseInt(stk);
         			String nstk=textField_6.getText();
					if(textField_5.getText().isEmpty())
					{
						nstk="0";
					}

					//int Nstk=Integer.parseInt(nstk);

					String itc=textField.getText();
				/*	if(itc==null)
					{
						itc="0";
					}*/
					final Connection con=DatabaseConnection.getConnection();
					PreparedStatement ps=con.prepareStatement("insert into sport(itemName,modelName,companyName,mrp,Colour,stock,Type,itemCode) values(?,?,?,?,?,?,?,?)");
					ps.setString(1, item);
					ps.setString(2, modelnm);
					ps.setString(3, compnm);
					ps.setFloat(4, Mrp);
					ps.setString(5, color);
					ps.setInt(6, Stk);
					ps.setString(7, nstk);
					ps.setString(8, itc);


					int pp=ps.executeUpdate();
					if(pp!=0)
					{					JOptionPane.showMessageDialog(Insertion.this,"Insertion done!");
					    dispose();
						int option = JOptionPane.showConfirmDialog(null, "Do you want to add more..", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
						if(option==JOptionPane.OK_OPTION)
						{
							Insertion frame = new Insertion();
							frame.setVisible(true);
						}
					System.out.print("insertion done");

					}
					else
					{
								JOptionPane.showMessageDialog(Insertion.this,"Insertion not done!");
								dispose();

					}






					System.out.print("success");
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(292, 318, 116, 39);
		contentPane.add(btnNewButton);

		JButton btnAddNewItem = new JButton("Add new item");
		btnAddNewItem.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		btnAddNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
				textField_4.setText(" ");
				textField_5.setText(" ");
				textField_6.setText(" ");
				textField.setText(" ");
*/
			}
		});
		btnAddNewItem.setBounds(131, 319, 116, 39);
		contentPane.add(btnAddNewItem);


	}
}

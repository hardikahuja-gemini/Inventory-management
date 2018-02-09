package sporty;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import com.sporty.dao.DatabaseConnection;

public class newPass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	Connection con = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		newPass frame = new newPass();
		frame.setVisible(true);
	}


	public newPass() {
		setTitle("Ahuja Enterprise..");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 351);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setToolTipText("");
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHimr = new JLabel("Hi ! .Mr.Shyam Ahuja");
		lblHimr.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblHimr.setBounds(85, 24, 264, 14);
		contentPane.add(lblHimr);

		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterPassword.setBounds(61, 77, 125, 14);
		contentPane.add(lblEnterPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(61, 152, 125, 14);
		contentPane.add(lblConfirmPassword);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the legal password to proceed..");
		lblPleaseEnterThe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblPleaseEnterThe.setBounds(10, 266, 315, 14);
		contentPane.add(lblPleaseEnterThe);
		passwordField = new JPasswordField();
		//passwordField.setEchoChar('*');
		passwordField.setToolTipText("Password must contain at least 8 characters");
		passwordField.setBounds(229, 77, 135, 23);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		//passwordField_1.setEchoChar('*');
		passwordField_1.setToolTipText("Password must contain at least 8 characters");
		passwordField_1.setBounds(229, 150, 135, 23);
		contentPane.add(passwordField_1);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				final char[] pass_1=passwordField.getPassword();
				final char[] pass_2=passwordField_1.getPassword();


				try {
					if (!Arrays.equals(pass_1, pass_2)) {
						JOptionPane.showMessageDialog(newPass.this,"Passwords do not match!");
						passwordField.setText("");
						passwordField_1.setText("");
						return;
					}else {
						con =DatabaseConnection.getConnection();

						PreparedStatement ps = null;
						String query = "select * from user where 1=1 ";
						ps = con.prepareStatement(query);
						ResultSet i  = ps.executeQuery();
						if(i.next() == true) {
							String query2 = "select * from user where password=? ";
							ps = con.prepareStatement(query2);
							ps.setString(1, passwordField.getText());
							i = ps.executeQuery();
							if(i.next() == true) {
								Sportss s = new Sportss();
								s.setVisible(true);
								dispose();
							}
							/*else {
								int option = JOptionPane.showConfirmDialog(null, "Password does not exists, Do you want to sign up", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

								if(option == JOptionPane.OK_OPTION)
								{
									User u = new User();
									u.setVisible(true);
									dispose();
								}
								passwordField.setText("");
								passwordField_1.setText("");
								return;
							}*/
						}else {
							int option = JOptionPane.showConfirmDialog(null, "Password does not exists, Do you want to sign up", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

							if(option == JOptionPane.OK_OPTION)
							{
								User user = new User();
								user.setVisible(true);
								passwordField.setText("");
								passwordField_1.setText("");
								dispose();
							}
						}
					} 
				}catch (SQLException e) {
					e.printStackTrace();
				}

				//			char[] pass_3={'k','r','i','s','h','n','a'};

				//				if (Arrays.equals(pass_1, pass_3)) 
				//				{
				//					
				//					Sportss oo=null;
				//					oo=new Sportss();
				//					oo.setVisible(true);
				//					//pack();
				//					dispose();
				//							
				//				} 
				//				else 
				//				
				//				{
				//					JOptionPane.showMessageDialog(Password.this,"You entered a wrong password.");	
				//				}
				//				

			}
		});
		btnOk.setBounds(40, 232, 190, 23);
		contentPane.add(btnOk);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
/*
				ResetPassword mumy=null;
				mumy=new ResetPassword();
				mumy.setVisible(true);*/
			}
		});
		btnChangePassword.setBounds(285, 232, 190, 23);
		contentPane.add(btnChangePassword);


	}
}

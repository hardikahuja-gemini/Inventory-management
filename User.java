package sporty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sporty.dao.DatabaseConnection;
import java.awt.Color;
import java.awt.SystemColor;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		User frame = new User();
		frame.setVisible(true);
	}

	public User() {
		setTitle("User Info...");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 270);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheUsername = new JLabel("Enter your username");
		lblEnterTheUsername.setBounds(59, 46, 147, 14);
		contentPane.add(lblEnterTheUsername);

		JLabel lblEmterThePassword = new JLabel("Emter the password");
		lblEmterThePassword.setBounds(59, 71, 147, 14);
		contentPane.add(lblEmterThePassword);

		JLabel lblEnterTheMobile = new JLabel("Enter the mobile number");
		lblEnterTheMobile.setBounds(59, 96, 147, 14);
		contentPane.add(lblEnterTheMobile);

		JLabel lblEnterTheEmail = new JLabel("Enter the Email");
		lblEnterTheEmail.setBounds(59, 121, 147, 14);
		contentPane.add(lblEnterTheEmail);

		textField = new JTextField();
		textField.setBounds(238, 43, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(238, 93, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 118, 86, 20);
		contentPane.add(textField_3);
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String userName = textField.getText();
				final String password = passwordField.getText();
				final long mobileNo = Long.parseLong(textField_2.getText()
						.trim());
				final String email = textField_3.getText();
				final Connection con = DatabaseConnection.getConnection();
				try {
					PreparedStatement ps = con
							.prepareStatement("insert into user(user_name,password,mobileno,email) values(?,?,?,?)");
					ps.setString(1, userName);
					ps.setString(2, password);
					ps.setLong(3, mobileNo);
					ps.setString(4, email);

					int i = ps.executeUpdate();
					if (i != 0) {
						int option = JOptionPane
								.showConfirmDialog(
										null,
										"Password exists now , Do you want to sign in",
										"Confirm",
										JOptionPane.YES_NO_CANCEL_OPTION);

						if (option == JOptionPane.OK_OPTION) {
							newPass pass = new newPass();
							pass.setVisible(true);
							dispose();
						}

					} else {
						System.out.print("insertion  not done");

					}
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		});
		btnCreateAccount.setBounds(59, 198, 130, 23);
		contentPane.add(btnCreateAccount);

		passwordField = new JPasswordField();
		passwordField.setBounds(238, 68, 85, 17);
		contentPane.add(passwordField);

		JButton button = new JButton("clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setText(" ");
				textField.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
			}
		});
		button.setBounds(238, 198, 89, 23);
		contentPane.add(button);
	}
}

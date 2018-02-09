package sporty;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.UIManager;

import com.sporty.dao.DatabaseConnection;

import java.awt.Font;
import java.io.File;

public class Sportss extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		Sportss frame = new Sportss();
		frame.setVisible(true);
	}

	public Sportss() {
		setTitle("Ahuja Enterprise...Shop Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.cyan);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton();
		btnNewButton.setText("Adding Items..");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insertion spo = null;
				try {
					spo = new Insertion();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				spo.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 116, 145, 33);
		contentPane.add(btnNewButton);
		JLabel lblStudentRegistration = new JLabel("      Adding items");
		lblStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentRegistration.setBounds(49, 308, 186, 14);
		contentPane.add(lblStudentRegistration);
		
		
		JButton btnSearchAndUpdate = new JButton(new ImageIcon(DatabaseConnection.path2));
		btnSearchAndUpdate.setText("Searching items...");
		btnSearchAndUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewModifyData spoo = null;
				
				spoo = new ViewModifyData();
				spoo.setVisible(true);
			}
		});
		btnSearchAndUpdate.setBounds(192, 116, 145, 33);
		contentPane.add(btnSearchAndUpdate);
		JLabel lblTeacherRegistration = new JLabel("           Searching items");
		lblTeacherRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTeacherRegistration.setBounds(330, 308, 195, 14);
		contentPane.add(lblTeacherRegistration);
		
		JLabel lblSpogoRetails = new JLabel("Ahuja Enterprizes..\r\n");
		lblSpogoRetails.setFont(new Font("Sitka Small", Font.ITALIC, 21));
		lblSpogoRetails.setBounds(61, 36, 226, 48);
		contentPane.add(lblSpogoRetails);
		
		JLabel lblBuildingTrustsSine = new JLabel("BUILDING TRUSTS SINC\r\nE A VERY LONG TIME..");
		lblBuildingTrustsSine.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblBuildingTrustsSine.setBounds(10, 172, 372, 14);
		contentPane.add(lblBuildingTrustsSine);
	}
}

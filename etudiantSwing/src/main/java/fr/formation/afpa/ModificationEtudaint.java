package fr.formation.afpa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModificationEtudaint extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	

	/**
	 * Create the application.
	 */
	public ModificationEtudaint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pPhotoMo = new JPanel();
		pPhotoMo.setBounds(0, 0, 650, 494);
		pPhotoMo.setLayout(null);
		frame.getContentPane().add(pPhotoMo);
		
		JLabel photoMo = new JLabel("Photo : ");
		photoMo.setBounds(12, 8, 45, 16);
		pPhotoMo.add(photoMo);
		
		textField = new JTextField(10);
		textField.setBounds(12, 33, 116, 22);
		pPhotoMo.add(textField);
		
		JLabel nomMo = new JLabel("Nom: ");
		nomMo.setBounds(12, 97, 35, 16);
		pPhotoMo.add(nomMo);
		
		textField_1 = new JTextField(10);
		textField_1.setBounds(12, 123, 116, 22);
		pPhotoMo.add(textField_1);
		
		JLabel dateNaissanceMo = new JLabel("Date de naissance : ");
		dateNaissanceMo.setBounds(11, 266, 117, 16);
		pPhotoMo.add(dateNaissanceMo);
		
		textField_2 = new JTextField(10);
		textField_2.setBounds(12, 290, 116, 22);
		pPhotoMo.add(textField_2);
		
		JLabel prenomMo = new JLabel("Prenom : ");
		prenomMo.setBounds(12, 170, 57, 16);
		pPhotoMo.add(prenomMo);
		
		textField_3 = new JTextField(10);
		textField_3.setBounds(12, 199, 116, 22);
		pPhotoMo.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(248, 8, 243, 213);
		pPhotoMo.add(lblNewLabel);
	}

}

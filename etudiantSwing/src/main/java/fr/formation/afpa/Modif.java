package fr.formation.afpa;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Modif {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Modif(){
	JFrame fMo = new JFrame();
	fMo.setSize(521, 446);
	fMo.setTitle("Modifier étudiant");
	fMo.getContentPane().setLayout(null);
	
	JPanel pPhotoMo = new JPanel();
	pPhotoMo.setBounds(0, 0, 503, 399);
	pPhotoMo.setLayout(null);
	fMo.getContentPane().add(pPhotoMo);
	
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
	JLabel affPhotoMo = new JLabel();
	affPhotoMo.setSize(200, 100);
	fMo.setVisible(true);
	
	}
}

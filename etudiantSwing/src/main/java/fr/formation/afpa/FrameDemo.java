package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import javax.swing.BoxLayout;

import fr.formation.afpa.model.Etudiant;

/**
 * Hello world!
 *
 */
public class FrameDemo extends JFrame implements WindowListener {
	public static void main(String[] args) {
		FrameDemo fd = new FrameDemo();

	}

	public FrameDemo() {
		super("Frame Demo");
		// Initialisation des components
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setTitle("Liste des étudiants");

		JFrame fAj = new JFrame();
		fAj.setSize(500, 400);
		fAj.setTitle("Ajouter un étudiant");
		
		JFrame fMo = new JFrame();
		fAj.setSize(500, 400);
		fAj.setTitle("Afficher étudiant");
		

		JPanel pBouton = new JPanel();
		JPanel pAcc = new JPanel();
		JPanel pPhoto = new JPanel();
		JPanel pNom = new JPanel();
		JPanel pPrenom = new JPanel();
		JPanel pDateNaissance = new JPanel();

		JMenuBar menu = new JMenuBar();

		JMenu etudiant = new JMenu("Etudiant");
		

		JMenuItem ajoutEtudiant = new JMenuItem("Ajouter étudiant");
		JMenuItem listEtudiant = new JMenuItem("Liste étudiant");
		

		JLabel photo = new JLabel("Photo : ");
		JLabel nom = new JLabel("Nom: ");
		JLabel prenom = new JLabel("Prenom : ");
		JLabel dateNaissance = new JLabel("Date de naissance : ");

		JTextField photoT = new JTextField(10);
		photoT.setSize(20, 20);
		JTextField nomT = new JTextField(10);
		nomT.setSize(20, 20);
		JTextField prenomT = new JTextField(10);
		prenomT.setSize(20, 20);
		JTextField dateNaissanceT = new JTextField(10);
		dateNaissanceT.setSize(10, 20);

		
		JButton enregistrer = new JButton("Enregistrer");
		JButton annuler = new JButton("Annuler");
		JButton modifier = new JButton("Modifier");
		JButton parcourir = new JButton("Parcourir");
		JFileChooser parcourPhoto = new JFileChooser();

		enregistrer.setSize(20, 20);
		annuler.setSize(20, 20);
		modifier.setSize(20, 20);
		parcourir.setSize(20, 20);

		//Initialisation de la liste des étudiants
		String[] donnees = { "Nom", "Prenom", "Date de naissance", "ID" };

		Object[][] arrEtu = { { "Petit", "Nicolas", new Integer(1997), new Integer(1)},
				{ "Paddle", "Kid", new Integer(1999),new Integer (2)},
				{ "Zep", "Titeuf", new Integer(2001), new Integer (3) }, };

		JTable tab = new JTable(arrEtu, donnees);
		tab.setVisible(false);

		// Agencement page d'accueil avec liste

		menu.add(etudiant);
		etudiant.add(ajoutEtudiant);
		etudiant.add(listEtudiant);

		BoxLayout boxlayoutAcc = new BoxLayout(pAcc, BoxLayout.Y_AXIS);
		pAcc.setLayout(boxlayoutAcc);
		f.add(menu, BorderLayout.NORTH);
		pAcc.add(tab);


		pAcc.add(tab.getTableHeader());
		pAcc.add(tab);
		f.add(pAcc);

		pBouton.add(enregistrer);
		pBouton.add(annuler);
		pBouton.add(modifier);

		pPhoto.add(photo);
		pPhoto.add(photoT);
		pPhoto.add(parcourir);
		pNom.add(nom);
		pNom.add(nomT);
		pPrenom.add(prenom);
		pPrenom.add(prenomT);
		pDateNaissance.add(dateNaissance);
		pDateNaissance.add(dateNaissanceT);

		// Initialistion de la fenêtre accueillant le formulaire d'ajout d'étudiant
		ajoutEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fAj.setVisible(true);
				JPanel boxAj = new JPanel();
				BoxLayout boxlayoutAj = new BoxLayout(boxAj, BoxLayout.Y_AXIS);

				boxAj.setLayout(boxlayoutAj);

				boxAj.add(pPhoto);
				boxAj.add(pPrenom);
				boxAj.add(pNom);
				boxAj.add(pDateNaissance);

				fAj.add(boxAj);
				fAj.add(pBouton, BorderLayout.SOUTH);
				enregistrer.setVisible(true);
				modifier.setVisible(false);
				annuler.setVisible(true);

			}
		});
		
		parcourir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parcourPhoto.showOpenDialog(getParent());
				
			}
		});

		enregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(dateNaissanceT.getText());
				Etudiant e1 = new Etudiant(nomT.getText(), prenomT.getText(), n);

			}

		});

		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				photoT.setText(null);
				prenomT.setText(null);
				nomT.setText(null);
				dateNaissanceT.setText(null);

				fAj.dispose();

			}
		});
		
		listEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tab.setVisible(true);
				
			}
		});

		addWindowListener(this);

		f.setVisible(true);

		fAj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	

	public void windowActivated(WindowEvent event) {
		System.out.println("The window has been activated");
	}

	public void windowClosed(WindowEvent event) {
		System.out.println("The window has been closed");
	}

	public void windowClosing(WindowEvent event) {
		System.out.println("About to close the window");
	}

	public void windowDeactivated(WindowEvent event) {
		System.out.println("The window has been deactivated");
	}

	public void windowDeiconified(WindowEvent event) {
		System.out.println("The window has been restored");
	}

	public void windowIconified(WindowEvent event) {
		System.out.println("The window has been minimized");
	}

	public void windowOpened(WindowEvent event) {
		System.out.println("The window has been opened");
	}
}

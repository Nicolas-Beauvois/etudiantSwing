package fr.formation.afpa.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;


import fr.formation.afpa.model.Etudiant;

public class EtudiantDaoFile implements IEtudiantDao{

	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Etudiant e) {
		try {
			OutputStream os = new FileOutputStream("etudiant\\liste.txt");
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeUTF("Nouvel etudiant");
			oos.writeObject(new Date());
			

			oos.writeObject(e);
			

			oos.close();

		} catch (FileNotFoundException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		} catch (IOException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		}

		
	}

	public Etudiant update(Etudiant e) {
InputStream in;
		
		try {
			in = new FileInputStream("etudiant\\liste.txt");
			
			ObjectInputStream din = new ObjectInputStream(in);
			
			String cat = din.readUTF();
			Date date = (Date) din.readObject();
			
			System.out.println(date);
			System.out.println(cat);
	
			for (int i = 0; i< 3; i++) {
				e = (Etudiant) din.readObject();
			System.out.println(e);
			}
			din.close();
			
		} catch (FileNotFoundException err2) {
			
			err2.printStackTrace();
		} catch (IOException err2) {
			// TODO Auto-generated catch block
			err2.printStackTrace();
		} catch (ClassNotFoundException err2) {
			// TODO Auto-generated catch block
			err2.printStackTrace();
		}
		return null;
	}

	

}

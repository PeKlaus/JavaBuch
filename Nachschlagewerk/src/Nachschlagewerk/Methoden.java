package Nachschlagewerk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Methoden {
/*	
 * -----------------------------------------------------------------------------------------------------------------------------
 *                      >>> Übernehmen <<<
 *                      
 *     (    private DefaultListModel<String> MessreiheModel;    )                
 *     (    MessreiheModel = new DefaultListModel<String>();    ) <<<  Erstellen des List-Models
	   (    listMessreihe.setModel(MessreiheModel);             )       
 *                      
 *                      
 * 
	private void Uebernehmen() {
		if (!tfMesswert.getText().equals("")) {                  // Prüft auf eine Eingabe
			MessreiheModel.addElement(tfMesswert.getText());     //eingegebenen Messwert der JList hinzufügen
			tfMesswert.requestFocus();
            tfMesswert.selectAll();
		} else {
			JOptionPane.showMessageDialog(null , "Bitte geben Sie einen Messwert ein!");
			tfMesswert.requestFocus();
            tfMesswert.selectAll();
            }
      }
---------------------------------------------------------------------------------------------------------------------------------      
                         >>> Speichern <<<
      
      private void speichern() {
			
			File datei = new File(dateiname);    // File-Objekt erstellen
			                                                                        // erzeugt einen BufferedWriter (dem Konstruktor wird ein
			try	(BufferedWriter out = new BufferedWriter(new FileWriter(datei))) {  // neuer FileWriter mit Ziel das File >datei< übergeben.
				for (int i = 0; i < MessreiheModel.getSize(); i++) {                // Mit einer For-Schleife werden zeilenweise mit der write-Methode
					out.write(MessreiheModel.get(i).toString());                    // Zeile für Zeile in den BufferenWriter geschrieben.
					out.newLine(); // schreibt immer in eine neue Zeile
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
--------------------------------------------------------------------------------------------------------------------------------------		
	
		                 >>> Speichern mit File-Chooser <<<
		
		private void speichernmitfilechooser () {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter(                  // Stellt den File-Chooser auf .mwd ein
				"Messwertdateien *.mwd", "mwd"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showSaveDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION) {                   
			    String selFile = fc.getSelectedFile().getAbsolutePath();    // prüft auf .mwd 
			    int index = selFile.indexOf('.');
			    if (index >= 0) {
				dateiname = selFile.substring(0, index).concat(".mwd");
			    } else {
				dateiname = selFile.concat(".mwd");
			    }
			    
			    try {
				BufferedWriter out = new BufferedWriter(new FileWriter(
					dateiname));
				for (int i = 0; i < MessreiheModel.getSize(); i++) {
				    out.write(MessreiheModel.get(i).toString());
				    out.newLine();
				}
				out.close();
			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
					"Fehler beim Speichern!");
			    }
			}
		    }
 ---------------------------------------------------------------------------------------------------------------------------------   
   
                          >>> Öffnen mit File-Chooser <<<
                        
      private void dateioeffnen() {
			
			MessreiheModel.clear();
			tfMesswert.requestFocus();
            tfMesswert.selectAll();;
			File datei = new File(dateiname);
			
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter(
					"Messwertdateien *.mwd", "mwd"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				String selFile = fc.getSelectedFile().getAbsolutePath();
				int index = selFile.indexOf('.');
				if (index >= 0) {
					dateiname = selFile.substring(0, index).concat(".mwd");
				    } else {
					dateiname = selFile.concat(".mwd");
				    }
				try
				(BufferedReader in = new BufferedReader(new FileReader(dateiname))) {
					while ((selFile = in.readLine()) != null) {
						MessreiheModel.addElement(selFile);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
------------------------------------------------------------------------------------------------------------------------------------      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
*/	

	
	
	
	
	
	
	
	
	
	
	
}



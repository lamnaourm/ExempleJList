import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	DefaultListModel<String> model = new DefaultListModel<>();
	private JLabel lbl_taille;
	private JLabel lbl_indice;
	private JLabel lbl_value;
	private JTextField txt_indice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Exemple JList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex()>-1) {
					lbl_indice.setText(String.valueOf(list.getSelectedIndex()));
					lbl_value.setText(String.valueOf(list.getSelectedValue()));
				}else {
					JOptionPane.showMessageDialog(null, "Aucun element selectionnee");
					lbl_indice.setText("");
					lbl_value.setText("");
				}
			}
		});
		list.setModel(model);
		model.addElement("Lundi");
		model.addElement("Mardi");
		model.addElement("Mercredi");
		model.addElement("Jeudi");
		model.addElement("Vendredi");
		model.addElement("Samedi");
		model.addElement("Dimanche");
		list.setBounds(10, 119, 201, 217);
		contentPane.add(list);
		
		JLabel lblNouvelElement = new JLabel("Nouvel Element :");
		lblNouvelElement.setBounds(10, 11, 201, 14);
		contentPane.add(lblNouvelElement);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 201, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Controle de texte vide
				if(textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Texte vide");
					textField.requestFocus();
					return;
				}
				// Controle les doublons
				for(int i=0;i<model.size();i++)
					if(textField.getText().equals(model.get(i))) {
						JOptionPane.showMessageDialog(null, "Element Existe deja");
						textField.requestFocus();
						return;
					}
				
				model.addElement(textField.getText());
				lbl_taille.setText(String.valueOf(model.size()));
			}
		});
		btnNewButton.setBounds(10, 67, 201, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Les proprietes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(221, 142, 287, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDesElements = new JLabel("Nombre des elements :");
		lblNombreDesElements.setBounds(10, 42, 142, 14);
		panel.add(lblNombreDesElements);
		
		lbl_taille = new JLabel("0");
		lbl_taille.setBounds(187, 42, 46, 14);
		panel.add(lbl_taille);
		
		JLabel lblIndiceElementSelectionnee = new JLabel("Indice element selectionnee:");
		lblIndiceElementSelectionnee.setBounds(10, 86, 168, 14);
		panel.add(lblIndiceElementSelectionnee);
		
		lbl_indice = new JLabel("0");
		lbl_indice.setBounds(187, 86, 46, 14);
		panel.add(lbl_indice);
		
		JLabel lblValeurElementSelectionnee = new JLabel("Valeur element selectionnee:");
		lblValeurElementSelectionnee.setBounds(10, 132, 168, 14);
		panel.add(lblValeurElementSelectionnee);
		
		lbl_value = new JLabel("0");
		lbl_value.setBounds(187, 132, 46, 14);
		panel.add(lbl_value);
		
		txt_indice = new JTextField();
		txt_indice.setColumns(10);
		txt_indice.setBounds(264, 36, 201, 20);
		contentPane.add(txt_indice);
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(txt_indice.getText());
				
				if(a<model.size())
					list.setSelectedIndex(a);
			}
		});
		btnNewButton_1.setBounds(264, 67, 201, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Remove");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txt_indice.getText());
				
				model.remove(a);
				lbl_taille.setText(String.valueOf(model.size()));
			}
		});
		btnNewButton_1_1.setBounds(264, 95, 201, 23);
		contentPane.add(btnNewButton_1_1);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.CryptoPrimitive;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Color;

public class MainGUI {

	JFrame frame;
	private HadeerProjectSecurity hadeerAlgorithms = new HadeerProjectSecurity();
	private String key = "my secret key 16";
	String res="Nothing",encryptionHash,decreptionHash;
	JFileChooser fc;
	File selectedFile;
	JLabel resultLabel;
	JTextPane txtpnResult ;
	File inputFile,outputFile,hashOutput;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Enter Path of the file to be encrypted or decrypted:");
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setToolTipText("C:\\Files\\input.txt");
		
		JButton btnBrows = new JButton("Browse");
		btnBrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					fc = new JFileChooser("./");
					int returnVal = fc.showDialog(btnBrows, "Attach");
					selectedFile = fc.getSelectedFile();
					editorPane.setText(selectedFile.getPath());
				
			}
		});
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnResult.setBackground(Color.GRAY);
				if(editorPane.getText().toString().isEmpty())
					{
						txtpnResult.setBackground(Color.RED);
						resultLabel.setText("Choose a valid input file!!");
					}
				else {
					txtpnResult.setBackground(Color.GREEN);
					inputFile = new File(editorPane.getText().toString());
					outputFile = new File("output.enc");
					try {
						hadeerAlgorithms.encDecryption(1, key, inputFile, outputFile);
						encryptionHash=hadeerAlgorithms.hashingSHA256(inputFile);
						resultLabel.setText("Encryption succeeded!! \n saved in "+outputFile.getAbsolutePath());
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						txtpnResult.setBackground(Color.RED);
						resultLabel.setText("Error happened!!");
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnResult.setBackground(Color.GRAY);
				if(editorPane.getText().toString().isEmpty())
				{
					txtpnResult.setBackground(Color.RED);
					resultLabel.setText("Choose a valid input file!!");
				}
			else {
				txtpnResult.setBackground(Color.GREEN);
				inputFile = new File(editorPane.getText().toString());
				outputFile = new File("decrypted.txt");
				try {
					hadeerAlgorithms.encDecryption(2, key, inputFile, outputFile);
					//hashOutput= new File("hashoutput.txt");
					decreptionHash=hadeerAlgorithms.hashingSHA256(outputFile);
					if(encryptionHash.equals(decreptionHash))
						resultLabel.setText("Decryption succeeded! and Hashing is succeeded!");
					else {
						resultLabel.setText("Decryption succeeded! and Hashing is false!");
					}
						
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					txtpnResult.setBackground(Color.RED);
					resultLabel.setText("Error happened!!");
					e1.printStackTrace();
				}
			}
			
		}
	});
		
		txtpnResult = new JTextPane();
		txtpnResult.setBackground(Color.LIGHT_GRAY);
		txtpnResult.setText("Result:");
		
		resultLabel = new JLabel("...");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnBrows)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEncrypt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDecrypt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resultLabel)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBrows)
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEncrypt)
						.addComponent(btnDecrypt))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(resultLabel))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		

		
	}
}

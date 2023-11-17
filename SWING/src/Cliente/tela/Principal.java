package Cliente.tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputName;
	private JTextField inputAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputName = new JTextField();
		inputName.setBounds(169, 118, 86, 20);
		contentPane.add(inputName);
		inputName.setColumns(10);

        inputAge = new JTextField();
		inputAge.setBounds(169, 210, 86, 20);
		contentPane.add(inputAge);
		inputAge.setColumns(10);
		
		JLabel resposta = new JLabel("");
		resposta.setBounds(144, 183, 148, 113);
		contentPane.add(resposta);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = inputName.getText();
				JOptionPane.showMessageDialog(null,"Seja bem vindo " + nome);
				
			}
		});
		btnNewButton.setBounds(166, 149, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Digite seu nome");
		lblNewLabel.setBounds(144, 84, 158, 23);
		contentPane.add(lblNewLabel);
		
		
	}
}

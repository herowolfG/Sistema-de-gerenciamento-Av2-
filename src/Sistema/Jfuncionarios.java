package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;

public class Jfuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JTextField tfIdade;
	private JTextField tfEndereco;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jfuncionarios frame = new Jfuncionarios();
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
	public Jfuncionarios() {
		setTitle("Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(37, 77, 184, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(37, 136, 184, 26);
		contentPane.add(tfNome);
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		tfSalario.setBounds(37, 196, 184, 26);
		contentPane.add(tfSalario);
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		tfIdade.setBounds(37, 256, 184, 26);
		contentPane.add(tfIdade);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(37, 312, 184, 26);
		contentPane.add(tfEndereco);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 53, 99, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(37, 114, 99, 26);
		contentPane.add(lblNome);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalario.setBounds(37, 171, 99, 26);
		contentPane.add(lblSalario);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdade.setBounds(37, 233, 99, 26);
		contentPane.add(lblIdade);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereo.setBounds(37, 290, 99, 26);
		contentPane.add(lblEndereo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 54, 452, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"CPF", "Nome", "Idade", "Salario", "Cargo", "Endere\u00E7o"
			}
		));
		scrollPane.setViewportView(table);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Funcionario");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 240));
		rdbtnNewRadioButton.setBounds(37, 345, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBackground(new Color(255, 255, 240));
		rdbtnGerente.setBounds(148, 345, 73, 23);
		contentPane.add(rdbtnGerente);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(17, 53, 214, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(21, 322, 99, 36);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 224));
		panel_1.setBounds(238, 370, 452, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(48, 11, 99, 36);
		panel_1.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(169, 11, 99, 36);
		panel_1.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(286, 11, 99, 36);
		panel_1.add(btnListar);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(85, 21, 99, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lista De Funcionarios");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(361, 21, 196, 22);
		contentPane.add(lblNewLabel_2);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

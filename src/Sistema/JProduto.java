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

public class JProduto extends JFrame {

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
					JProduto frame = new JProduto();
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
	public JProduto() {
		setTitle("Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(27, 54, 184, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(27, 113, 184, 26);
		contentPane.add(tfNome);
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		tfSalario.setBounds(27, 173, 184, 26);
		contentPane.add(tfSalario);
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		tfIdade.setBounds(27, 233, 184, 26);
		contentPane.add(tfIdade);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(27, 289, 184, 26);
		contentPane.add(tfEndereco);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 30, 99, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(27, 91, 99, 26);
		contentPane.add(lblNome);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalario.setBounds(27, 148, 99, 26);
		contentPane.add(lblSalario);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdade.setBounds(27, 210, 99, 26);
		contentPane.add(lblIdade);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereo.setBounds(27, 267, 99, 26);
		contentPane.add(lblEndereo);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(27, 326, 99, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 53, 337, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"CPF", "Nome", "Salario", "Idade", "Endere\u00E7o"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(231, 326, 99, 36);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(352, 326, 99, 36);
		contentPane.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(469, 326, 99, 36);
		contentPane.add(btnListar);
	}
}

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
import java.awt.Color;

public class JProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JTextField tfIdade;
	private JTextField tfEndereco;
	private JTable table;
	private JTextField textField_1;

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
		setBounds(100, 100, 764, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 53, 507, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "Setor", "Valor", "Valor Original", "Fornecedor"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(10, 54, 218, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(24, 0, 99, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfCpf = new JTextField();
		tfCpf.setBounds(24, 24, 184, 26);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 61, 99, 26);
		panel.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfNome = new JTextField();
		tfNome.setBounds(24, 83, 184, 26);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblSalario = new JLabel("Setor");
		lblSalario.setBounds(24, 118, 99, 26);
		panel.add(lblSalario);
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfSalario = new JTextField();
		tfSalario.setBounds(24, 143, 184, 26);
		panel.add(tfSalario);
		tfSalario.setColumns(10);
		
		JLabel lblIdade = new JLabel("Valor");
		lblIdade.setBounds(24, 180, 99, 26);
		panel.add(lblIdade);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfIdade = new JTextField();
		tfIdade.setBounds(24, 203, 184, 26);
		panel.add(tfIdade);
		tfIdade.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Valor Original");
		lblEndereo.setBounds(24, 237, 99, 26);
		panel.add(lblEndereo);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(24, 259, 184, 26);
		panel.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblFornecedor_1 = new JLabel("Fornecedor");
		lblFornecedor_1.setBounds(24, 296, 99, 26);
		panel.add(lblFornecedor_1);
		lblFornecedor_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 318, 184, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(56, 384, 99, 36);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 224));
		panel_1.setBounds(231, 438, 507, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(87, 11, 99, 36);
		panel_1.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(208, 11, 99, 36);
		panel_1.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(325, 11, 99, 36);
		panel_1.add(btnListar);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(74, 17, 100, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lista Dos Produtos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(399, 26, 166, 20);
		contentPane.add(lblNewLabel_2);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

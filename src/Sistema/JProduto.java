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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfSetor;
	private JTextField tfValor;
	private JTextField tfValorO;
	private JTable table;
	private JTextField tfFornecedor;
	private ProdutoDAO prod = new ProdutoDAO();
	

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
		setBounds(100, 100, 755, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 47, 507, 380);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();
				
				if (linha != -1) {
		            tfCodigo.setText(table.getValueAt(linha, 0).toString()); 
		            tfNome.setText(table.getValueAt(linha, 1).toString());  
		            tfSetor.setText(table.getValueAt(linha, 2).toString()); 
		            tfValor.setText(table.getValueAt(linha, 3).toString());
		            tfValorO.setText(table.getValueAt(linha, 4).toString()); 
		            tfFornecedor.setText(table.getValueAt(linha, 5).toString());
		        }
			}
		});
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
		panel.setBounds(10, 48, 206, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 11, 99, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(10, 35, 184, 26);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 72, 99, 26);
		panel.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 94, 184, 26);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblSalario = new JLabel("Setor");
		lblSalario.setBounds(10, 129, 99, 26);
		panel.add(lblSalario);
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfSetor = new JTextField();
		tfSetor.setBounds(10, 154, 184, 26);
		panel.add(tfSetor);
		tfSetor.setColumns(10);
		
		JLabel lblIdade = new JLabel("Valor");
		lblIdade.setBounds(10, 191, 99, 26);
		panel.add(lblIdade);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfValor = new JTextField();
		tfValor.setBounds(10, 214, 184, 26);
		panel.add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Valor Original");
		lblEndereo.setBounds(10, 248, 99, 26);
		panel.add(lblEndereo);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfValorO = new JTextField();
		tfValorO.setBounds(10, 270, 184, 26);
		panel.add(tfValorO);
		tfValorO.setColumns(10);
		
		JLabel lblFornecedor_1 = new JLabel("Fornecedor");
		lblFornecedor_1.setBounds(10, 307, 99, 26);
		panel.add(lblFornecedor_1);
		lblFornecedor_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(10, 329, 184, 26);
		panel.add(tfFornecedor);
		tfFornecedor.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod.prod.setCodigo(Integer.parseInt(tfCodigo.getText()));
				prod.prod.setNome(tfNome.getText());
				prod.prod.setSetor(tfSetor.getText());
				prod.prod.setValor(Float.parseFloat(tfValor.getText()));
				prod.prod.setValorO(Float.parseFloat(tfValorO.getText()));
				prod.prod.setFornecedor(tfFornecedor.getText());
				
				prod.registro(prod.prod.getCodigo(),prod.prod.getNome(),prod.prod.getSetor(),prod.prod.getValor(),prod.prod.getValorO(),prod.prod.getFornecedor());
				prod.lista(table);
				
			}
		});
		btnNewButton.setBounds(50, 386, 99, 36);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 224));
		panel_1.setBounds(219, 426, 507, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod.prod.setCodigo(Integer.parseInt(tfCodigo.getText()));
				prod.prod.setNome(tfNome.getText());
				prod.prod.setSetor(tfSetor.getText());
				prod.prod.setValor(Float.parseFloat(tfValor.getText()));
				prod.prod.setValorO(Float.parseFloat(tfValorO.getText()));
				prod.prod.setFornecedor(tfFornecedor.getText());
				
				prod.Atualizar(prod.prod.getCodigo(),prod.prod.getNome(),prod.prod.getSetor(),prod.prod.getValor(),prod.prod.getValorO(),prod.prod.getFornecedor());
				prod.lista(table);
			}
		});
		btnAtualizar.setBounds(40, 11, 99, 36);
		panel_1.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod.excluir(tfCodigo.getText());
				prod.lista(table);
			}
		});
		btnDeletar.setBounds(149, 11, 99, 36);
		panel_1.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(258, 11, 99, 36);
		panel_1.add(btnListar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod.Buscar(tfCodigo.getText());
				
				tfNome.setText(prod.prod.getNome());
				tfSetor.setText(prod.prod.getSetor());
				tfValor.setText(String.valueOf(prod.prod.getValor()));
				tfValorO.setText(String.valueOf(prod.prod.getValorO()));
				tfFornecedor.setText(prod.prod.getFornecedor());
			}
		});
		btnBuscar.setBounds(367, 11, 99, 36);
		panel_1.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 11, 100, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lista Dos Produtos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(387, 20, 166, 20);
		contentPane.add(lblNewLabel_2);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod.lista(table);
				
			}
		});
		prod.lista(table);
	}
}

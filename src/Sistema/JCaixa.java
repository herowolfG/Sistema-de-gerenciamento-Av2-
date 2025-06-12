package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfCodigo;
	private JTextField tfValor;
	private JTextField tfQuantia;
	private JTextField tfNum;
	private JTextField tfTotal;
	private JTextField tfRecebido;
	private JTextField tfTroco;
	private CaixaDAO caixa = new CaixaDAO();
	private int num = 1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JCaixa() {
		setTitle("Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 400, 513);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					int linha = table.getSelectedRow();
				
					if (linha != -1) {
						tfNum.setText(table.getValueAt(linha, 0).toString()); 
						
		        }	
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num", "Codigo", "Valor", "Quantia"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(420, 11, 237, 324);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 115, 28);
		panel.add(lblNewLabel);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(10, 37, 217, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(10, 107, 115, 28);
		panel.add(lblValor);
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		tfValor.setBounds(10, 133, 217, 20);
		panel.add(tfValor);
		
		JLabel lblQuantia = new JLabel("Quantia");
		lblQuantia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantia.setBounds(10, 163, 115, 28);
		panel.add(lblQuantia);
		
		tfQuantia = new JTextField();
		tfQuantia.setColumns(10);
		tfQuantia.setBounds(10, 189, 217, 20);
		panel.add(tfQuantia);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				caixa.caixa.setCodigo(Integer.parseInt(tfCodigo.getText()));
				caixa.caixa.setQuantia(Integer.parseInt(tfQuantia.getText()));
				caixa.caixa.setValor(Float.parseFloat(tfValor.getText()));
				
				caixa.Adicionar(table, num);
				tfTotal.setText(String.valueOf(caixa.caixa.getTotal()));
				num++;
				tfCodigo.setText("");
				tfValor.setText("");
				tfQuantia.setText("");
				
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionar.setBounds(10, 220, 115, 37);
		panel.add(btnAdicionar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caixa.Buscar(tfCodigo.getText());
				tfValor.setText(String.valueOf(caixa.caixa.getValor()));
			}
		});
		btnPesquisar.setBounds(10, 68, 115, 28);
		panel.add(btnPesquisar);
		
		JLabel lblNum = new JLabel("Num");
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNum.setBounds(10, 268, 42, 20);
		panel.add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setEditable(false);
		tfNum.setColumns(10);
		tfNum.setBounds(10, 286, 69, 20);
		panel.add(tfNum);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caixa.Deletar(table, tfNum.getText());
				tfTotal.setText(String.valueOf(caixa.caixa.getTotal()));
			}
		});
		btnNewButton_2.setBounds(89, 285, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(420, 346, 237, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		tfTotal.setHorizontalAlignment(SwingConstants.CENTER);
		tfTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfTotal.setBounds(10, 15, 122, 34);
		panel_1.add(tfTotal);
		tfTotal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(142, 14, 79, 34);
		panel_1.add(lblNewLabel_1);
		
		tfRecebido = new JTextField();
		tfRecebido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfRecebido.setBounds(10, 82, 122, 34);
		panel_1.add(tfRecebido);
		tfRecebido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Recebido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 60, 122, 24);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Calcular");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float resu = caixa.Troco(Float.parseFloat(tfTotal.getText()), Float.parseFloat(tfRecebido.getText()));
				tfTroco.setText(String.valueOf(resu));
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(138, 89, 89, 23);
		panel_1.add(btnNewButton_3);
		
		tfTroco = new JTextField();
		tfTroco.setEditable(false);
		tfTroco.setBounds(10, 143, 122, 24);
		panel_1.add(tfTroco);
		tfTroco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Troco");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 118, 68, 24);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("Finalizar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				caixa.registro(table);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(471, 535, 126, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRegistro ini = new JRegistro();
				ini.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistro.setBounds(140, 535, 126, 40);
		contentPane.add(btnRegistro);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = new Inicio();
				ini.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 548, 89, 23);
		contentPane.add(btnNewButton);
	}
}

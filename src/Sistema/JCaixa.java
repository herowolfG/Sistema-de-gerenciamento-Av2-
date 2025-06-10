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

public class JCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtSd;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCaixa frame = new JCaixa();
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
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
		
		textField = new JTextField();
		textField.setBounds(10, 37, 217, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(10, 107, 115, 28);
		panel.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 133, 217, 20);
		panel.add(textField_1);
		
		JLabel lblQuantia = new JLabel("Quantia");
		lblQuantia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantia.setBounds(10, 163, 115, 28);
		panel.add(lblQuantia);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 189, 217, 20);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 220, 115, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.setBounds(10, 68, 115, 28);
		panel.add(btnNewButton_1);
		
		JLabel lblNum = new JLabel("Num");
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNum.setBounds(10, 268, 42, 20);
		panel.add(lblNum);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 286, 69, 20);
		panel.add(textField_3);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.setBounds(89, 285, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(420, 346, 237, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtSd = new JTextField();
		txtSd.setEditable(false);
		txtSd.setHorizontalAlignment(SwingConstants.CENTER);
		txtSd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSd.setBounds(10, 15, 122, 34);
		panel_1.add(txtSd);
		txtSd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(142, 14, 79, 34);
		panel_1.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(10, 82, 122, 34);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Recebido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 60, 122, 24);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Calcular");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(138, 89, 89, 23);
		panel_1.add(btnNewButton_3);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(10, 143, 122, 24);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Troco");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 118, 68, 24);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("Finalizar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(471, 535, 126, 40);
		contentPane.add(btnNewButton_4);
	}
}

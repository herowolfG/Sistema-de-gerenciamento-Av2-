package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class JRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfTotal;
	private CaixaDAO caixa = new CaixaDAO();
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 344, 413);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Valor", "Quantia"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCaixa ini = new JCaixa();
				ini.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(20, 435, 89, 38);
		contentPane.add(btnNewButton);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		tfTotal.setBounds(192, 435, 162, 38);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		caixa.lista(table);
		tfTotal.setText(String.valueOf(caixa.caixa.getTotal()));
	}
}

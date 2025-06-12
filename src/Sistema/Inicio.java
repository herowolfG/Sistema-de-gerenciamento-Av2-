package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Produtos");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JProduto prod = new JProduto();
				prod.setVisible(true);
				setVisible(false);
			}
		});
		btnEntrar.setBounds(115, 88, 226, 43);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnEntrar);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jfuncionarios func = new Jfuncionarios();
				func.setVisible(true);
				setVisible(false);
			}
		});
		btnFuncionarios.setBounds(115, 183, 226, 43);
		btnFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnFuncionarios);
		
		JButton btnEntrar_1_1 = new JButton("Caixa");
		btnEntrar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCaixa caixa = new JCaixa();
				caixa.setVisible(true);
				setVisible(false);
			}
		});
		btnEntrar_1_1.setBounds(115, 278, 226, 43);
		btnEntrar_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnEntrar_1_1);
	}
}

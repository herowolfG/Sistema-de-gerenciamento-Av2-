package Sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.BD;



public class FuncionarioDAO {

	public Funcionario func;
	
	public FuncionarioDAO() {
		func = new Funcionario();
		
	}
	
	
	public void Buscar(String cpf) {
		
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "informe o id");
		}
		else {
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "select *from funcionario where CPF=?";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				if (rs.getString("CPF").equals(cpf)) {
					func.setCpf(Integer.parseInt(rs.getString("CPF")));
					func.setNome(rs.getString("Nome"));
					func.setSalario(Float.parseFloat(rs.getString("Salario")));
					func.setIdade(Integer.parseInt(rs.getString("Idade")));
					func.setEndereco(rs.getString("Endereco"));
					func.setCargo(rs.getString("Cargo"));
				}		
				if(rs.getString("CPF").equals(null)) {
					JOptionPane.showMessageDialog(null, "n deu");
				}
			
			}
			
			rs.close();
			com.close();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
	}
	
	
	public void excluir(String cpf) {
		
		if(cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "informe o id");
		}
		else {
			
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "delete from funcionario where CPF=?";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			stmt.setString(1, cpf);
			
			stmt.execute();
			
			stmt.close();
			com.close();
			
			JOptionPane.showMessageDialog(null, "dados excluidos");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		}
		
		
		
	}	
	
	
public void lista(JTable p1) {
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "select *from funcionario";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			ResultSet rs = stmt.executeQuery();
			
			DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
			modelo.setNumRows(0);
			
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getString("CPF"), rs.getString("Nome"), rs.getString("Idade"),rs.getString("Salario"),rs.getString("Cargo"),rs.getString("Endereco")});
				
			}
			rs.close();
			com.close();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}	
	
	
public void registro(int cpf,String nome, float salario, int idade, String endereco, String cargo) {
	
		if ( cpf == 0 || nome.equals("") || salario == 0 || idade == 0 || endereco.equals("") || cargo.equals("") ) {
			JOptionPane.showMessageDialog(null, "Não a informação");
		}
		else {
			
		
		try {
			Connection com = BD.Faz_conexao();
			String sql = "insert into funcionario(CPF, Nome, Salario, Idade, Endereco, Cargo) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = com.prepareStatement(sql);
			
			
			stmt.setInt(1, cpf);
			stmt.setString(2, nome);
			stmt.setFloat(3, salario);
			stmt.setInt(4, idade);
			stmt.setString(5, endereco);
			stmt.setString(6, cargo);
			
			stmt.execute();
			
			stmt.close();
			com.close();
			
			JOptionPane.showMessageDialog(null, "Registro concluido com sucesso");
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	}
	
	
}

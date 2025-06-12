package Sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdutoDAO {

	public Produto prod;
	
	public ProdutoDAO() {
		prod = new Produto();
	}
	
	
	
public void Atualizar(int codigo, String nome, String setor, Float valor, Float valorO, String fornecedor) {
		
		if(codigo == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum Codigo incontrado");
		}
		else {
			
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "update produtos set Nome=?, Setor=?, Valor=?, Valor_Original=?, Fornecedor=? where Codigo=?";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			stmt.setString(1, nome);
			stmt.setString(2, setor);
			stmt.setFloat(3, valor);
			stmt.setFloat(4, valorO);
			stmt.setString(5, fornecedor);
			stmt.setInt(6, codigo);
			
			
			stmt.execute();
			stmt.close();
			com.close();
			
			JOptionPane.showMessageDialog(null, "dados atualizados");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	}
	
	
	public void Buscar(String codigo) {
		
		if (codigo.equals("")) {
			JOptionPane.showMessageDialog(null, "informe o Codigo");
		}
		else {
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "select *from produtos where Codigo=?";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			stmt.setString(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
                prod.setCodigo(Integer.parseInt(rs.getString("Codigo")));
                prod.setNome(rs.getString("Nome"));
                prod.setSetor(rs.getString("Setor"));
                prod.setValor(Float.parseFloat(rs.getString("Valor")));
                prod.setValorO(Float.parseFloat(rs.getString("Valor_Original")));
                prod.setFornecedor(rs.getString("Fornecedor"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado encontrado com esse CPF.");
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
	
	
	
public void excluir(String codigo) {
		
		if(codigo.equals("")) {
			JOptionPane.showMessageDialog(null, "informe o Codigo");
		}
		else {
			
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "delete from produtos where Codigo=?";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			stmt.setString(1, codigo);
			
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
			
			String slq = "select *from produtos";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			ResultSet rs = stmt.executeQuery();
			
			DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
			modelo.setNumRows(0);
			
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getString("Codigo"), rs.getString("Nome"), rs.getString("Setor"),rs.getString("Valor"),rs.getString("Valor_Original"),rs.getString("Fornecedor")});
				
			}
			rs.close();
			com.close();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	
	
	
	public void registro(int codigo, String nome, String setor, Float valor, Float valorO, String fornecedor) {
		
		if ( codigo == 0 || nome.equals("") || setor.equals("") || valor == 0 || valorO == 0 || fornecedor.equals("") ) {
			JOptionPane.showMessageDialog(null, "Não a informação");
		}
		else {
			
		
		try {
			Connection com = BD.Faz_conexao();
			
			 String SQL = "SELECT * FROM produtos WHERE Codigo = ?";
	            PreparedStatement verificaStmt = com.prepareStatement(SQL);
	            verificaStmt.setInt(1, codigo);
	            ResultSet rs = verificaStmt.executeQuery();

	            if (rs.next()) {
	                JOptionPane.showMessageDialog(null, "Codigo já cadastrado.");
	            }else {
		            	SQL = "insert into produtos(Codigo, Nome, Setor, Valor, Valor_Original, Fornecedor) values (?, ?, ?, ?, ?, ?)";
		            	PreparedStatement stmt = com.prepareStatement(SQL);
			
			
		            	stmt.setInt(1, codigo);
		            	stmt.setString(2, nome);
		            	stmt.setString(3, setor);
		            	stmt.setFloat(4, valor);
		            	stmt.setFloat(5, valorO);
		            	stmt.setString(6, fornecedor);
			
		            	stmt.execute();
			
		            	stmt.close();
		            	com.close();
			
		            	JOptionPane.showMessageDialog(null, "Registro concluido com sucesso");
		            	}
	            	}
			
			
			
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	}
	
}
package Sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CaixaDAO {

	public Caixa caixa;
	
	public CaixaDAO(){
		caixa = new Caixa();
	}
	
	
public void lista(JTable p1) {
		
		try {
			Connection com = BD.Faz_conexao();
			
			String slq = "select *from caixa";
			
			PreparedStatement stmt = com.prepareStatement(slq);
			
			ResultSet rs = stmt.executeQuery();
			
			DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
			modelo.setNumRows(0);
			
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getString("Codigo"), rs.getString("Valor"), rs.getString("Quantia")});
				
				caixa.setTotal((rs.getFloat("Valor")*rs.getInt("Quantia"))+caixa.getTotal());
				
			}
			rs.close();
			com.close();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	
	public void registro(JTable p1) {
		
		DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
		int codigo;
		float valor;
		int quant;
		String st;
		
		for(int i =0;i<modelo.getRowCount();i++) {
			try {
				Connection com = BD.Faz_conexao();
				
				 String SQL = "insert into caixa(Codigo, Valor, Quantia) values (?, ?, ?)";
			        PreparedStatement stmt = com.prepareStatement(SQL);
				
			        st = modelo.getValueAt(i, 1).toString();
			        codigo = Integer.parseInt(st);
			        st = modelo.getValueAt(i, 2).toString();
			        valor = Float.parseFloat(st);
			        st = modelo.getValueAt(i, 3).toString();
			        quant = Integer.parseInt(st);
			        
			        
				
			       stmt.setInt(1, codigo);
			       stmt.setFloat(2, valor);
			       stmt.setInt(3, quant);

			       stmt.execute();
			       stmt.close();
			       com.close();
				
			      
			            	
		            	}	
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro concluido com sucesso");
		
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
                caixa.setValor(Float.parseFloat(rs.getString("Valor")));
        
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
	
	
public void Deletar(JTable p1,String num) {
	
	DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
	String st;
	int quant;
	float valor;
	
	
	for(int i =0;i<modelo.getRowCount();i++) {
		if (modelo.getValueAt(i, 0).toString().equals(num)) {
			
			st = modelo.getValueAt(i, 2).toString();
			valor = Float.parseFloat(st);
			st = modelo.getValueAt(i, 3).toString();
			quant =  Integer.parseInt(st);
			
			caixa.setTotal(caixa.getTotal()-(quant*valor));
			modelo.removeRow(i);
			
		}
	}

	
}
	
	
public float Troco(float total, float rec) {
	float resu;
	resu = total - rec;;
	return resu;
}
	
public void Adicionar(JTable p1, int num) {
			if (caixa.getQuantia() == 0 || caixa.getValor() == 0) {
				JOptionPane.showMessageDialog(null, "Falta informação");
			}else {
			
				DefaultTableModel modelo = (DefaultTableModel) p1.getModel();
				modelo.addRow(new Object[] {num, caixa.getCodigo(),caixa.getValor(),caixa.getQuantia()});
				
				caixa.setTotal((caixa.getQuantia()*caixa.getValor())+caixa.getTotal());
				
			}
	}	
	
	
	
	
}

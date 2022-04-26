package gamesWithJavaCode.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gamesWithJavaRepositorio.util.JdbcCon;

public class Jogo {

	public int idjogo;
	public String nomeJogo;
	public String linkJogo;

	List<String> jogos;

	public int getIdjogo() {
		return idjogo;
	}

	public void setIdjogo(int idjogo) {
		this.idjogo = idjogo;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public List<String> getJogos() {
		return jogos;
	}

	public void setJogos(List<String> jogos) {
		this.jogos = jogos;
	}
	
	public String getLinkJogo() {
		return linkJogo;
	}

	public void setLinkJogo(String linkJogo) {
		this.linkJogo = linkJogo;
	}

	public List<Jogo> listarJogos() throws SQLException {
		List<Jogo> j = new ArrayList<Jogo>();
		String sql = "SELECT * FROM jogos";
		JdbcCon con = new JdbcCon();
		Connection c = con.conectar();
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Jogo jogo = new Jogo();
				jogo.setIdjogo(rs.getInt("idjogo"));
				jogo.setNomeJogo(rs.getString("nomeJogo"));
				j.add(jogo);
			}
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return j;
	}

	public void inserirJogo(Jogo jogo) throws SQLException {
		JdbcCon con = new JdbcCon();
		Connection c = con.conectar();
		String sql = "INSERT INTO jogos (nomeJogo) values ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, jogo.getNomeJogo());
			stmt.execute();
			c.close();
		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	public void updateJogo(Jogo jogo)throws SQLException {
		JdbcCon con = new JdbcCon();
		Connection c = con.conectar();
		String sql = "UPDATE jogos set nomeJogo = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, jogo.getNomeJogo());
			stmt.executeUpdate();
			c.close();
		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	public void deleteJogo(Jogo jogo)throws SQLException {
		JdbcCon con = new JdbcCon();
		Connection c = con.conectar();
		String sql = "DELETE FROM jogos where idjogo = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, jogo.getIdjogo());
			stmt.execute();
			c.close();
		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

}

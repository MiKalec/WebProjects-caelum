package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement statement = this.connection.prepareStatement("select * from contatos");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultSet.getLong("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			resultSet.close();
			statement.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato, String nome, String email, String endereco, Calendar dataNascimento) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, email);
			statement.setString(3, endereco);
			statement.setDate(4, new Date(dataNascimento.getTimeInMillis()));
			statement.setLong(5, contato.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement statement = this.connection.prepareStatement("delete from contatos where id=?");
			statement.setLong(1, contato.getId());
			statement.execute();
			statement.close();
			System.out.println("Contato removido");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Contato pesquisar(Long id) {
		//String sql = "select * from contatos where id=?";

		try {
			PreparedStatement statement = connection.prepareStatement("select * from contatos where id=?");
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.first()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
			
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				return contato;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

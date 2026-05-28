package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectionFactory;
import model.Livro;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

	// CREATE
	public void cadastrar(Livro livro) {

		String sql = "INSERT INTO livros " + "(titulo, autor, categoria, ano) " + "VALUES (?, ?, ?, ?)";

		try (

				Connection conn = ConnectionFactory.conectar();

				PreparedStatement stmt = conn.prepareStatement(sql);

		) {
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getCategoria());
			stmt.setInt(4, livro.getAno());

			stmt.executeUpdate();

			System.out.println("Livro cadastrado!");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	// READ
	public List<Livro> listar() {
		List<Livro> livros = new ArrayList<>();

		String sql = "SELECT * FROM livros";

		try (Connection conn = ConnectionFactory.conectar();

				PreparedStatement stmt = conn.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

		) {
			while (rs.next()) {
				Livro livro = new Livro();

				livro.setId(rs.getInt("id"));

				livro.setTitulo(rs.getString("titulo"));

				livro.setAutor(rs.getString("autor"));

				livro.setCategoria(rs.getString("categoria"));

				livro.setAno(rs.getInt("ano"));

				livros.add(livro);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return livros;
	}

	// UPDATE
	public void atualizar(Livro livro) {
		String sql = "UPDATE livros SET " + "titulo=?, autor=?, categoria=?, ano=? " + "WHERE id=?";

		try (Connection conn = ConnectionFactory.conectar();

				PreparedStatement stmt = conn.prepareStatement(sql);

		) {
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getCategoria());
			stmt.setInt(4, livro.getAno());
			stmt.setInt(5, livro.getId());

			stmt.executeUpdate();
			System.out.println("Livro atualizado!");

		} catch (Exception e) {
			System.out.println("Erro!" + e.getMessage());
		}
	}

	// DELETE
	public void apagar(int id) {

		String sql = "DELETE FROM livros WHERE id =?";

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stmt = conn.prepareStatement(sql);

		) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Livro deletado!");

		} catch (Exception e) {
			System.out.println("Erro! " + e.getMessage());
		}
	}
}

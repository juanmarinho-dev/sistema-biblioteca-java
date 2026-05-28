package model;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private String categoria;
	private int ano;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Livro() {

	}

	public Livro(String titulo, String autor, String categoria, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
	}

}

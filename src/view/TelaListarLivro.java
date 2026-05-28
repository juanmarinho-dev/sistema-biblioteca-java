package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.LivroDAO;
import model.Livro;

public class TelaListarLivro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tabela;

	public TelaListarLivro() {

		setTitle("Lista de Livros");

		setBounds(100, 100, 800, 500);

		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(30, 30, 720, 380);

		contentPane.add(scrollPane);

		tabela = new JTable();

		tabela.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Título", "Autor", "Categoria", "Ano" }));

		scrollPane.setViewportView(tabela);

		carregarTabela();
	}

	public void carregarTabela() {

		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

		modelo.setRowCount(0);

		LivroDAO dao = new LivroDAO();

		List<Livro> livros = dao.listar();

		for (Livro livro : livros) {

			modelo.addRow(new Object[] { livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getCategoria(),
					livro.getAno() });
		}
	}
}
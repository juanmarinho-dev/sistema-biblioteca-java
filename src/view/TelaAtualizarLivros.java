package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LivroDAO;
import model.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarLivros extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtCategoria;
	private JTextField txtAno;

	public TelaAtualizarLivros() {

		setTitle("Atualizar Livro");

		setBounds(100, 100, 500, 450);

		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		// LABEL E CAMPO (ID)

		JLabel lblId = new JLabel("ID:");

		lblId.setBounds(40, 50, 80, 25);

		contentPane.add(lblId);

		txtId = new JTextField();

		txtId.setBounds(140, 50, 250, 30);

		contentPane.add(txtId);

		// LABEL E CAMPO (Título)

		JLabel lblTitulo = new JLabel("Título:");

		lblTitulo.setBounds(40, 100, 80, 25);

		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();

		txtTitulo.setBounds(140, 100, 250, 30);

		contentPane.add(txtTitulo);

		// LABEL E CAMPO (Autor)

		JLabel lblAutor = new JLabel("Autor:");

		lblAutor.setBounds(40, 150, 80, 25);

		contentPane.add(lblAutor);

		txtAutor = new JTextField();

		txtAutor.setBounds(140, 150, 250, 30);

		contentPane.add(txtAutor);

		// LABEL E CAMPO (Categoria)

		JLabel lblCategoria = new JLabel("Categoria:");

		lblCategoria.setBounds(40, 200, 80, 25);

		contentPane.add(lblCategoria);

		txtCategoria = new JTextField();

		txtCategoria.setBounds(140, 200, 250, 30);

		contentPane.add(txtCategoria);

		// LABEL E CAMPO (Ano)

		JLabel lblAno = new JLabel("Ano:");

		lblAno.setBounds(40, 250, 80, 25);

		contentPane.add(lblAno);

		txtAno = new JTextField();

		txtAno.setBounds(140, 250, 250, 30);

		contentPane.add(txtAno);

		// LABEL E CAMPO (Botão)

		JButton btnAtualizar = new JButton("Atualizar");

		btnAtualizar.setBounds(170, 330, 140, 40);

		contentPane.add(btnAtualizar);

		// EVENTO
		btnAtualizar.addActionListener(e -> {

			try {

				Livro livro = new Livro();

				livro.setId(Integer.parseInt(txtId.getText()));

				livro.setTitulo(txtTitulo.getText());

				livro.setAutor(txtAutor.getText());

				livro.setCategoria(txtCategoria.getText());

				livro.setAno(Integer.parseInt(txtAno.getText()));

				LivroDAO dao = new LivroDAO();

				dao.atualizar(livro);

				JOptionPane.showMessageDialog(null, "Livro atualizado!");

			} catch (Exception erro) {

				JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
			}
		});
	}
}
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

public class TelaCadastrarLivros extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtCategoria;
	private JTextField txtAno;

	public TelaCadastrarLivros() {

		setTitle("Cadastrar Livro");

		setBounds(100, 100, 500, 400);

		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(40, 50, 80, 25);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(140, 50, 250, 30);
		contentPane.add(txtTitulo);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(40, 100, 80, 25);
		contentPane.add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(140, 100, 250, 30);
		contentPane.add(txtAutor);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(40, 150, 80, 25);
		contentPane.add(lblCategoria);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(140, 150, 250, 30);
		contentPane.add(txtCategoria);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(40, 200, 80, 25);
		contentPane.add(lblAno);

		txtAno = new JTextField();
		txtAno.setBounds(140, 200, 250, 30);
		contentPane.add(txtAno);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(170, 280, 140, 40);

		contentPane.add(btnCadastrar);

		// EVENTO
		btnCadastrar.addActionListener(e -> {

			try {

				Livro livro = new Livro(txtTitulo.getText(), txtAutor.getText(), txtCategoria.getText(),
						Integer.parseInt(txtAno.getText()));

				LivroDAO dao = new LivroDAO();

				dao.cadastrar(livro);

				JOptionPane.showMessageDialog(null, "Livro cadastrado!");

			} catch (Exception erro) {

				JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
			}
		});
	}
}

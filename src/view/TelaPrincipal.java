
package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public TelaPrincipal() {

		setTitle("Sistema Biblioteca");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 700, 500);

		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();

		contentPane.setLayout(null);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("SISTEMA BIBLIOTECA");

		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));

		lblTitulo.setBounds(197, 39, 282, 40);

		contentPane.add(lblTitulo);

		JButton btnCadastrar = new JButton("Cadastrar Livro");

		btnCadastrar.setBounds(220, 120, 220, 40);

		contentPane.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar Livro");

		btnAtualizar.setBounds(220, 190, 220, 40);

		contentPane.add(btnAtualizar);

		JButton btnListar = new JButton("Listar Livros");

		btnListar.setBounds(220, 260, 220, 40);

		contentPane.add(btnListar);

		JButton btnDeletar = new JButton("Deletar Livro");

		btnDeletar.setBounds(220, 330, 220, 40);

		contentPane.add(btnDeletar);

		// EVENTOS

		btnCadastrar.addActionListener(e -> {

			TelaCadastrarLivros tela = new TelaCadastrarLivros();

			tela.setVisible(true);
		});

		btnAtualizar.addActionListener(e -> {

			TelaAtualizarLivros tela = new TelaAtualizarLivros();

			tela.setVisible(true);
		});

		btnListar.addActionListener(e -> {

			TelaListarLivro tela = new TelaListarLivro();

			tela.setVisible(true);
		});

		btnDeletar.addActionListener(e -> {

			TelaDeletarLivro tela = new TelaDeletarLivro();

			tela.setVisible(true);
		});
	}
}

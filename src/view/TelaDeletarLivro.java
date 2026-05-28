package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LivroDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaDeletarLivro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtId;

	public TelaDeletarLivro() {

		setTitle("Deletar Livro");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 400, 250);

		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		// LABEL E CAMPO (ID)

		JLabel lblId = new JLabel("ID do Livro:");

		lblId.setBounds(40, 50, 100, 25);

		contentPane.add(lblId);

		txtId = new JTextField();

		txtId.setBounds(150, 50, 150, 30);

		contentPane.add(txtId);

		// BOTÃO DELETAR

		JButton btnDeletar = new JButton("Deletar");

		btnDeletar.setBounds(120, 120, 140, 40);

		contentPane.add(btnDeletar);

		// EVENTO

		btnDeletar.addActionListener(e -> {

			try {

				int id = Integer.parseInt(txtId.getText());

				LivroDAO dao = new LivroDAO();

				dao.apagar(id);

				JOptionPane.showMessageDialog(null, "Livro deletado!");

				txtId.setText("");

			} catch (Exception erro) {

				JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
			}
		});
	}
}
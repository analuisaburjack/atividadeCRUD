package dw.jpa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/professores")
public class LivroController extends HttpServlet {
	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg;
			String op = valor(req, "operacao", "");
			String editora = valor(req, "editora", "");
			String titulo = valor(req, "titulo", "");
			if (op.equals("incluir")) {
				LivroModel.inclui(editora, titulo);
				msg = "Inclusão realizada com sucesso.";
			} else if (op.equals("alterar")) {
				LivroModel.alterar(editora, titulo);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				LivroModel.excluir(editora);
				msg = "Exclusão realizada com sucesso.";
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
			}
			req.setAttribute("msg", msg);
			req.setAttribute("livros", LivroModel.listar());
			
			req.getRequestDispatcher("/jpa/livro-view.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}

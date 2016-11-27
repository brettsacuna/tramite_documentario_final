package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UnidadDao;
import entity.Unidad;

/**
 * Servlet implementation class ServletUnidad
 */
@WebServlet("/ServletUnidad")
public class ServletUnidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUnidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		// PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("list")) {

			try {

				UnidadDao oUDao = new UnidadDao();
				List<Unidad> listado = oUDao.Listar();

				String json = new Gson().toJson(listado);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				System.out.println(e);
			}

		}
		if (opcion.equals("filt")) {

			String criterio = request.getParameter("filtro");

			try {

				UnidadDao oUDao = new UnidadDao();
				Unidad u = new Unidad();
				u.setUnidad(criterio);
				List<Unidad> listado = oUDao.Filtrar(u);

				String json = new Gson().toJson(listado);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

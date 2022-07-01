package co.com.ecommerce.test;

import co.com.ecommerce.daos.MarcaDao;
import co.com.ecommerce.entities.Marca;

public class TestMarca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcaDao marcaControlador = new MarcaDao();
		
		/*Marca marca = new Marca(1, "GUCCI");
		Marca marcaActualizada = new Marca(1, "ADIDAS");
		
		marcaControlador.agregarNuevaCategoria(marca);
		
		marcaControlador.actualizar(marcaActualizada);*/
		Marca marcaBuscada = marcaControlador.buscarMarca(1);
		
		System.out.println(marcaBuscada.toString());
	}

}

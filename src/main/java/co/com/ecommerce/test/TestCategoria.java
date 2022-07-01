package co.com.ecommerce.test;

import co.com.ecommerce.daos.CategoriaDao;
import co.com.ecommerce.entities.Categoria;

public class TestCategoria {

	public static void main(String[] args) {
		CategoriaDao controlador = new CategoriaDao();
		
		
		/*Categoria categoria = new Categoria(9,"ACCESORIOS");
		Categoria actualizada = new Categoria(9,"ELECTRODOMESTICOS");
		
		controlador.agregarNuevaCategoria(categoria);
		
		controlador.actualizar(actualizada);*/
		
		Categoria categoriaBuscada = controlador.buscarCategoria(9);
		System.out.println(categoriaBuscada.toString());

	}

}

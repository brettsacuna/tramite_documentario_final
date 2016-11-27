package interfaces;

import java.util.List;

public interface Intermetodos<T> {

	public abstract T Grabar(T o) throws Exception;

	public abstract void Eliminar(T o) throws Exception;

	public abstract void Modificar(T o) throws Exception;

	public abstract List<T> Listar() throws Exception;

	public abstract List<T> Filtrar(T o) throws Exception;

	public abstract T Buscar(T o) throws Exception;

}

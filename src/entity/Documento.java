package entity;

public class Documento {

	private String documento_id;
	private String asunto;
	private String documento_fecha;
	private int tipo_documento_id;
	private String fecha_registro;
	private String documento_numero;
	private int unidad_id_origen;
	private int seccion_id_destino;
	private int accion_id;
	private int clasificacion_id;
	private String url_archivo;
	private String observacion;
	private int anulado;
	private int estado;

	public Documento(String documento_id, String asunto, String documento_fecha, int tipo_documento_id,
			String fecha_registro, String documento_numero, int unidad_id_origen, int clasificacion_id,
			int seccion_id_destino, int accion_id, String url_archivo, String observacion, int anulado, int estado) {
		super();
		this.documento_id = documento_id;
		this.asunto = asunto;
		this.documento_fecha = documento_fecha;
		this.tipo_documento_id = tipo_documento_id;
		this.fecha_registro = fecha_registro;
		this.documento_numero = documento_numero;
		this.unidad_id_origen = unidad_id_origen;
		this.seccion_id_destino = seccion_id_destino;
		this.accion_id = accion_id;
		this.clasificacion_id = clasificacion_id;
		this.url_archivo = url_archivo;
		this.observacion = observacion;
		this.anulado = anulado;
		this.estado = estado;
	}

	public Documento() {

	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String documento_id) {
		this.documento_id = documento_id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDocumento_fecha() {
		return documento_fecha;
	}

	public void setDocumento_fecha(String documento_fecha) {
		this.documento_fecha = documento_fecha;
	}

	public int getTipo_documento_id() {
		return tipo_documento_id;
	}

	public void setTipo_documento_id(int tipo_documento_id) {
		this.tipo_documento_id = tipo_documento_id;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getDocumento_numero() {
		return documento_numero;
	}

	public void setDocumento_numero(String documento_numero) {
		this.documento_numero = documento_numero;
	}

	public int getUnidad_id_origen() {
		return unidad_id_origen;
	}

	public void setUnidad_id_origen(int unidad_id_origen) {
		this.unidad_id_origen = unidad_id_origen;
	}

	public int getSeccion_id_destino() {
		return seccion_id_destino;
	}

	public void setSeccion_id_destino(int seccion_id_destino) {
		this.seccion_id_destino = seccion_id_destino;
	}

	public int getAccion_id() {
		return accion_id;
	}

	public void setAccion_id(int accion_id) {
		this.accion_id = accion_id;
	}

	public String getUrl_archivo() {
		return url_archivo;
	}

	public void setUrl_archivo(String url_archivo) {
		this.url_archivo = url_archivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getAnulado() {
		return anulado;
	}

	public void setAnulado(int anulado) {
		this.anulado = anulado;
	}

	public int getClasificacion_id() {
		return clasificacion_id;
	}

	public void setClasificacion_id(int clasificacion_id) {
		this.clasificacion_id = clasificacion_id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}

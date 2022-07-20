package com.gft.Livraria.DTO.Livro;

public class ConsultaLivroDTO {
	private Long Id;
	
    private String titulo;
	
	private String autor;
	
	private Integer paginas;

	private double preco;

	public ConsultaLivroDTO() {
	}

	public ConsultaLivroDTO(Long id, String titulo, String autor, Integer paginas, double preco) {
		Id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.preco = preco;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}

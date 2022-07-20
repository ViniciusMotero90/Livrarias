package com.gft.Livraria.DTO.Livro;

public class RegistroLivroDTO {
    private String titulo;
	
	private String autor;
	
	private Integer paginas;

	private double preco;

	public RegistroLivroDTO() {
	}

	public RegistroLivroDTO(String titulo, String autor, Integer paginas, double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.preco = preco;
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
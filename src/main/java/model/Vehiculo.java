package model;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Vehiculo {

	@Getter
	@Setter
	@NonNull
	private String matricula;
	@NonNull
	private String tipo;
	@NonNull
	private String marca;
	private String modelo;
	private Integer anyo;
	private String motor;
	private String combustible;
	private Double consumo;
	private Integer cilindros;
	private String modoCarga;
	private String transmision;
	private String estructura;
	private Integer ejes;
	private String ballestas;
	private String traccion;
	private Double longitud;
	private Double altura;
	private Integer capacidadCarga;
	private HashMap<String, String> detalles;

	@Builder
	public Vehiculo(String matricula, String tipo, String marca, String modelo, Integer anyo, String motor, String combustible,
			Double consumo, Integer cilindros, String modoCarga, String transmision, String estructura, Integer ejes,
			String ballestas, String traccion, Double longitud, Double altura, Integer capacidadCarga, HashMap<String, String> detalles) {

		this.matricula = matricula;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.motor = motor;
		this.combustible = combustible;
		this.consumo = consumo;
		this.cilindros = cilindros;
		this.modoCarga = modoCarga;
		this.transmision = transmision;
		this.estructura = estructura;
		this.ejes = ejes;
		this.ballestas = ballestas;
		this.traccion = traccion;
		this.longitud = longitud;
		this.altura = altura;
		this.capacidadCarga = capacidadCarga;
		this.detalles = detalles;
	}
}

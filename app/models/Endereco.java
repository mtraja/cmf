package models;

import javax.persistence.*;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="enderecos")
public class Endereco extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco_id_seq") 
	public Long id;
	
	@Required	
	public String rua;
	public int numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String uf;
	public String cep;
	
	private Endereco(String rua, int numero, String cep) {
		this.rua=rua;
		this.numero=numero;
		this.cep=cep;
	}
	
	public static Finder<Long,Endereco> buscar = new Finder<Long,Endereco>(Long.class, Endereco.class ); 
	
	public static Endereco criar(String rua, int numero, String cep) {
        
		Endereco endereco = new Endereco(rua, numero, cep);
        endereco.save();
        return endereco;
	}
	
}

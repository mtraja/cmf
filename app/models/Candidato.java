package models;

import java.util.Date;
import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.data.format.*;
import play.db.ebean.*;

@Entity
@Table(name="candidatos")
@SequenceGenerator(name="candidato_id_seq", initialValue=10000, allocationSize=1)
public class Candidato extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="candidato_id_seq")
	public Long id;
	
	@Required
	public String nome;
	@Email
	public String email;

	public String identidade;
	public String cpf;
	public int sexo;
	@OneToOne
	public Endereco endereco;
	@OneToOne
	public Inscricao inscricao;
	
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date dataNac;
	
	private Candidato(String nome, String identidade, String cpf, String email) {
		this.nome=nome;
		this.identidade=identidade;
		this.cpf=cpf;
		this.email=email;
	}
	
	public static Finder<Long,Candidato> buscar = new Finder<Long,Candidato>(Long.class, Candidato.class ); 
	
	public static Candidato criar(String nome, String identidade, String cpf, String email) {
        
        Candidato candidato = new Candidato(nome, identidade, cpf, email);
        candidato.save();
        return candidato;
    }
	    
	
}

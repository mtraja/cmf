package models;

import javax.persistence.*;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="incricoes")
public class Disciplina extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="disciplina_id_seq")
	public Long id;
	
	@Required
	public String nome;
	private Disciplina(String nome) {
		this.nome=nome;
	}
	
	public static Finder<Long,Disciplina> buscar = new Finder<Long,Disciplina>(Long.class, Disciplina.class ); 
	
	public static Disciplina criar(String nome) {
        
		Disciplina disciplina = new Disciplina(nome);
        disciplina.save();
        return disciplina;
    }


}

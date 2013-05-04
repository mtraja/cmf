package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="incricoes")
public class Inscricao extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inscricao_id_seq")
	public Long id;
	
	@Required
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date dataAbertura;
	
	public Disciplina disciplina;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date dataAtivacao;
	private Inscricao(Date dt) {
		this.dataAbertura=dt;
	}
	
	public static Finder<Long,Inscricao> buscar = new Finder<Long,Inscricao>(Long.class, Inscricao.class ); 
	
	public static Inscricao criar(Date dt) {
        
		Inscricao inscricao = new Inscricao(dt);
        inscricao.save();
        return inscricao;
    }

}

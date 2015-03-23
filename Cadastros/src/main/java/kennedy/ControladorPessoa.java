package kennedy;

import java.util.ArrayList;
import java.util.List;

public class ControladorPessoa {

	public static List<Pessoa> Pessoas = new ArrayList<Pessoa>();
	
	public void salvar(Pessoa pessoa){
		Pessoas.add(pessoa);
		
	}
	
	public List<Pessoa> getPessoa(){
		return Pessoas;
	}
	
	public void excluir( int pos ){
		Pessoas.remove(pos);
			
		}
		
		
	
	
	
}

package gsan.gui.relatorio.arrecadacao;



import gsan.arrecadacao.ArrecadacaoForma;





/**
 * [UC0826] Gerar Relat�rio An�lise da Arreca��o
 * 
 * @see gsan.gui.relatorio.arrecadacao.GerarRelatorioAnaliseArrecadacaoActionForm
 * @see gsan.gui.relatorio.arrecadacao.GerarRelatorioAnaliseArrecadacaoAction
 * @see gsan.relatorio.arrecadacao.RelatorioAnaliseArrecadacao
 * 
 * @author Victor Cisneiros
 * @date 23/07/2008
 */
public class ExibirGerarRelatorioAnaliseArrecadacaoAction extends GcomAction {
	
	@Override
	public ActionForward execute(
			ActionMapping mapping, 
			ActionForm actionForm,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ActionForward retorno = mapping.findForward("exibirGerarRelatorioAnaliseArrecadacaoAction");
		Fachada fachada = Fachada.getInstancia();
		
		// ------------------------------
		// -- Por Arrecadador
		// ------------------------------
		FiltroArrecadador filtroArrecadador = new FiltroArrecadador();
		filtroArrecadador.adicionarCaminhoParaCarregamentoEntidade("cliente");
		Collection collectionArrecadador = fachada.pesquisar(filtroArrecadador, Arrecadador.class.getName());
		request.setAttribute("collectionArrecadador", collectionArrecadador);
		
		// ------------------------------
		// -- Por Formar de Arrecada��o
		// ------------------------------
		FiltroArrecadacaoForma filtroArrecadacaoForma = new FiltroArrecadacaoForma();
		Collection collectionArrecadacaoForma = fachada.pesquisar(filtroArrecadacaoForma, ArrecadacaoForma.class.getName());
		request.setAttribute("collectionArrecadacaoForma", collectionArrecadacaoForma);
		
		return retorno;
	}

}
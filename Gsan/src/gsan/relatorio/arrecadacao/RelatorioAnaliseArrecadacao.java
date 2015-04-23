package gsan.relatorio.arrecadacao;



import gsan.arrecadacao.bean.PesquisarAnaliseArrecadacaoHelper;

public class RelatorioAnaliseArrecadacao extends TarefaRelatorio {
	
	private static final long serialVersionUID = 1L;

	public RelatorioAnaliseArrecadacao(Usuario usuario) {
		super(usuario, ConstantesRelatorios.RELATORIO_ANALISE_ARRECADACAO);
	}

	@Override
	public Object executar() throws TarefaException {
		Fachada fachada = Fachada.getInstancia();
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		SistemaParametro sistemaParametro = Fachada.getInstancia().pesquisarParametrosDoSistema();
		parametros.put("imagem", sistemaParametro.getImagemRelatorio());
		parametros.put("tipoRelatorio", "RF0826");
		
		Integer mesAno = (Integer) getParametro("mesAno");
		Boolean porEstado = (Boolean) getParametro("porEstado");
		Boolean porArrecadador = (Boolean) getParametro("porArrecadador");
		Boolean porFormaArrecadacao = (Boolean) getParametro("porFormaArrecadacao");
		Integer idArrecadador = (Integer) getParametro("idArrecadador");
		Integer idFormaArrecadacao = (Integer) getParametro("idFormaArrecadacao");
		Integer tipoRelatorio = (Integer) getParametro("tipoRelatorio");
		
		parametros.put("mesAno", mesAno.toString().substring(4) + "/" + mesAno.toString().substring(0, 4));
		parametros.put("porEstado", porEstado);
		parametros.put("porArrecadador", porArrecadador);
		parametros.put("porFormaArrecadacao", porFormaArrecadacao);
		
		PesquisarAnaliseArrecadacaoHelper filtro = new PesquisarAnaliseArrecadacaoHelper();
		filtro.setMesAno(mesAno);
		filtro.setPorEstado(porEstado);
		filtro.setPorArrecadador(porArrecadador);
		filtro.setPorFormaArrecadacao(porFormaArrecadacao);
		filtro.setIdArrecadador(idArrecadador);
		filtro.setIdFormaArrecadacao(idFormaArrecadacao);
		
		Collection<RelatorioAnaliseArrecadacaoBean> pesquisa = fachada.pesquisarAnaliseArrecadacao(filtro);
		if (pesquisa.isEmpty()) {
			throw new ActionServletException("atencao.dados.inexistente.parametros.informados");
		}
		
		List<RelatorioAnaliseArrecadacaoBean> beans = new ArrayList<RelatorioAnaliseArrecadacaoBean>();
		beans.addAll(pesquisa);
		
		byte[] retorno = this.gerarRelatorio(ConstantesRelatorios.RELATORIO_ANALISE_ARRECADACAO,
				parametros, new RelatorioDataSource(beans), tipoRelatorio);
		
		return retorno;
	}
	
	@Override
	public int calcularTotalRegistrosRelatorio() {
		return 0;
	}

	@Override
	public void agendarTarefaBatch() {
		AgendadorTarefas.agendarTarefa("RelatorioAnaliseArrecadacao", this);
	}

}
/*
* Copyright (C) 2007-2007 the GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
*
* This file is part of GSAN, an integrated service management system for Sanitation
*
* GSAN is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License.
*
* GSAN is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
*/

/*
* GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
* Copyright (C) <2007> 
* Adriano Britto Siqueira
* Alexandre Santos Cabral
* Ana Carolina Alves Breda
* Ana Maria Andrade Cavalcante
* Aryed Lins de Ara�jo
* Bruno Leonardo Rodrigues Barros
* Carlos Elmano Rodrigues Ferreira
* Cl�udio de Andrade Lira
* Denys Guimar�es Guenes Tavares
* Eduardo Breckenfeld da Rosa Borges
* Fab�ola Gomes de Ara�jo
* Fl�vio Leonardo Cavalcanti Cordeiro
* Francisco do Nascimento J�nior
* Homero Sampaio Cavalcanti
* Ivan S�rgio da Silva J�nior
* Jos� Edmar de Siqueira
* Jos� Thiago Ten�rio Lopes
* K�ssia Regina Silvestre de Albuquerque
* Leonardo Luiz Vieira da Silva
* M�rcio Roberto Batista da Silva
* Maria de F�tima Sampaio Leite
* Micaela Maria Coelho de Ara�jo
* Nelson Mendon�a de Carvalho
* Newton Morais e Silva
* Pedro Alexandre Santos da Silva Filho
* Rafael Corr�a Lima e Silva
* Rafael Francisco Pinto
* Rafael Koury Monteiro
* Rafael Palermo de Ara�jo
* Raphael Veras Rossiter
* Roberto Sobreira Barbalho
* Rodrigo Avellar Silveira
* Rosana Carvalho Barbosa
* S�vio Luiz de Andrade Cavalcante
* Tai Mu Shih
* Thiago Augusto Souza do Nascimento
* Tiago Moreno Rodrigues
* Vivianne Barbosa Sousa
*
* Este programa � software livre; voc� pode redistribu�-lo e/ou
* modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
* publicada pela Free Software Foundation; vers�o 2 da
* Licen�a.
* Este programa � distribu�do na expectativa de ser �til, mas SEM
* QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
* COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
* PARTICULAR. Consulte a Licen�a P�blica Geral GNU para obter mais
* detalhes.
* Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
* junto com este programa; se n�o, escreva para Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
* 02111-1307, USA.
*/  
package gsan.relatorio.seguranca;


import gsan.cadastro.sistemaparametro.SistemaParametro;
import gsan.fachada.Fachada;
import gsan.relatorio.ConstantesRelatorios;
import gsan.relatorio.RelatorioDataSource;
import gsan.relatorio.RelatorioVazioException;
import gsan.seguranca.acesso.FiltroOperacao;
import gsan.seguranca.acesso.Funcionalidade;
import gsan.seguranca.acesso.Operacao;
import gsan.seguranca.acesso.OperacaoTipo;
import gsan.seguranca.acesso.usuario.Usuario;
import gsan.tarefa.TarefaException;
import gsan.tarefa.TarefaRelatorio;
import gsan.util.agendadortarefas.AgendadorTarefas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: GCOM
 * </p>
 * <p>
 * Description: Sistema de Gest�o Comercial
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: COMPESA - Companhia Pernambucana de Saneamento
 * </p>
 * 
 * @author Arthur Carvalho
 * @version 1.0
 */

public class RelatorioManterOperacao extends TarefaRelatorio {
	private static final long serialVersionUID = 1L;
	public RelatorioManterOperacao(Usuario usuario) {
		super(usuario, ConstantesRelatorios.RELATORIO_OPERACAO_MANTER);
	}
	
	@Deprecated
	public RelatorioManterOperacao() {
		super(null, "");
	}

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param situacao pagamento
	 *            Description of the Parameter
	 * @param SituacaoPagamentoParametros
	 *            Description of the Parameter
	 * @return Descri��o do retorno
	 * @exception RelatorioVazioException
	 *                Descri��o da exce��o
	 */

	public Object executar() throws TarefaException {

		// ------------------------------------
		//		Integer idFuncionalidadeIniciada = this.getIdFuncionalidadeIniciada();
		// ------------------------------------

		FiltroOperacao filtroOperacao = (FiltroOperacao) getParametro("filtroOperacao");
		
		Operacao operacaoParametros = (Operacao) getParametro("operacaoParametros");
		OperacaoTipo operacaoTipoParametros = (OperacaoTipo) getParametro("operacaoTipoParametros");
		Funcionalidade funcionalidadeParametros = (Funcionalidade) getParametro("funcionalidadeParametros");
		
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");
		
		
		filtroOperacao.adicionarCaminhoParaCarregamentoEntidade("operacaoTipo");
		filtroOperacao.adicionarCaminhoParaCarregamentoEntidade("funcionalidade");
		filtroOperacao.adicionarCaminhoParaCarregamentoEntidade("argumentoPesquisa");
		
		// valor de retorno
		byte[] retorno = null;

		// cole��o de beans do relat�rio
		List relatorioBeans = new ArrayList();

		RelatorioManterOperacaoBean relatorioBean = null;

		Fachada fachada = Fachada.getInstancia();

		Collection colecaoOperacao = fachada.pesquisar(filtroOperacao,
				Operacao.class.getName());

		// se a cole��o de par�metros da analise n�o for vazia
		if (colecaoOperacao != null && !colecaoOperacao.isEmpty()) {

			// coloca a cole��o de par�metros da analise no iterator
			Iterator operacaoIterator = colecaoOperacao.iterator();

			// la�o para criar a cole��o de par�metros da analise
			while (operacaoIterator.hasNext()) {

				Operacao operacao = (Operacao) operacaoIterator.next();
				
				String argumentoPesquisa = "";
				
				if (operacao.getTabelaColuna() != null) {
					
					argumentoPesquisa = operacao.getTabelaColuna().getColuna();
				}
				
				String operacaoTipo = "";
				
				if(operacao.getOperacaoTipo() != null ) {
					
					operacaoTipo = operacao.getOperacaoTipo().getDescricao();
				} 
				
				String funcionalidade ="";
				
				if (operacao.getFuncionalidade() != null ) {
					
					funcionalidade = operacao.getFuncionalidade().getDescricao();
				}
				
				relatorioBean = new RelatorioManterOperacaoBean(
						// CODIGO
						operacao.getId().toString(), 
						
						// Descri��o
						operacao.getDescricao(), 
						
						//Argumento de Pesquisa
						argumentoPesquisa,
						
						//Tipo de Operacao
						operacaoTipo,
						
						//Funcionalidade
						funcionalidade);
						
						
						
				// adiciona o bean a cole��o
				relatorioBeans.add(relatorioBean);
			}
		}

		// Par�metros do relat�rio
		Map parametros = new HashMap();

		// adiciona os par�metros do relat�rio
		// adiciona o laudo da an�lise
		SistemaParametro sistemaParametro = fachada
				.pesquisarParametrosDoSistema();

		parametros.put("imagem", sistemaParametro.getImagemRelatorio());

		parametros.put("id",
				operacaoParametros.getId() == null ? "" : ""
						+ operacaoParametros.getId());
		
		
		if (operacaoParametros.getDescricao() != null){
			parametros.put("descricao", operacaoParametros.getDescricao());
		} else {
			parametros.put("descricao", "");
		}
		
		if (operacaoParametros.getArgumentoPesquisa() != null) {
			parametros.put("argumentoPesquisa", operacaoParametros.getArgumentoPesquisa());
		} else {
			parametros.put("argumentoPesquisa", "");	
		}
		
		if (operacaoTipoParametros.getId() != null) {
			parametros.put("operacaoTipo", operacaoTipoParametros.getDescricao());
		} else {
			parametros.put("operacaoTipo", "");	
		}

		if (funcionalidadeParametros.getId() != null) {
			parametros.put("funcionalidade", funcionalidadeParametros.getDescricao());
		} else {
			parametros.put("funcionalidade", "");	
		}
		
		
		// cria uma inst�ncia do dataSource do relat�rio

		RelatorioDataSource ds = new RelatorioDataSource(relatorioBeans);

		retorno = this.gerarRelatorio(
				ConstantesRelatorios.RELATORIO_OPERACAO_MANTER, parametros,
				ds, tipoFormatoRelatorio);
		
		// ------------------------------------
		// Grava o relat�rio no sistema
//		try {
//			persistirRelatorioConcluido(retorno, Relatorio.MANTER_LOCALIDADE,
//					idFuncionalidadeIniciada);
//		} catch (ControladorException e) {
//			e.printStackTrace();
//			throw new TarefaException("Erro ao gravar relat�rio no sistema", e);
//		}
		// ------------------------------------

		// retorna o relat�rio gerado
		return retorno;
	}

	@Override
	public int calcularTotalRegistrosRelatorio() {
		int retorno = 0;

//		retorno = Fachada.getInstancia().totalRegistrosPesquisa(
//				(FiltroLocalidade) getParametro("filtroLocalidade"),
//				Localidade.class.getName());

		return retorno;
	}

	public void agendarTarefaBatch() {
		AgendadorTarefas.agendarTarefa("RelatorioManterOperacao", this);
	}

}
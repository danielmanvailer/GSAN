/*
* Copyright (C) 2007-2007 the GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
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
* Foundation, Inc., 59 Temple Place � Suite 330, Boston, MA 02111-1307, USA
*/

/*
* GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
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
package gsan.relatorio.atendimentopublico.ordemservico;

import gsan.batch.Relatorio;
import gsan.cadastro.sistemaparametro.SistemaParametro;
import gsan.fachada.Fachada;
import gsan.relatorio.ConstantesRelatorios;
import gsan.relatorio.RelatorioDataSource;
import gsan.seguranca.acesso.usuario.Usuario;
import gsan.tarefa.TarefaException;
import gsan.tarefa.TarefaRelatorio;
import gsan.util.ControladorException;
import gsan.util.agendadortarefas.AgendadorTarefas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [UC1120] Gerar Relat�rio de religa��o de clientes inadimplentes
 * 
 * @author Hugo Leonardo
 *
 * @date 25/01/2011
 */
public class RelatorioReligacaoClientesInadiplentes extends TarefaRelatorio {
	
	private static final long serialVersionUID = 1L;
	
	public RelatorioReligacaoClientesInadiplentes(Usuario usuario) {
		super(usuario, ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES);
	}

	@Deprecated
	public RelatorioReligacaoClientesInadiplentes() {
		super(null, "");
	}

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 */
	public Object executar() throws TarefaException {

		// valor de retorno
		byte[] retorno = null;

		// ------------------------------------
		Integer idFuncionalidadeIniciada = this.getIdFuncionalidadeIniciada();
		// ------------------------------------

		FiltrarRelatorioReligacaoClientesInadiplentesHelper relatorioHelper = 
			(FiltrarRelatorioReligacaoClientesInadiplentesHelper) getParametro("filtrarRelatorioReligacaoClientesInadiplentesHelper");
		
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");
		
		String gerenciaRegional = (String) getParametro("gerenciaRegional");
		String unidadeNegocio = (String) getParametro("unidadeNegocio");
		String localidade = (String) getParametro("localidade");
		String setorComercial = (String) getParametro("setorComercial");
		String cliente = (String) getParametro("cliente");
		String nomeUsuario = (String) getParametro("nomeUsuario");
		String periodoEncerramento = (String) getParametro("periodoEncerramento");
		String periodoRecorrencia = (String) getParametro("periodoRecorrencia");
		
		// cole��o de beans do relat�rio
		List relatorioBeans = new ArrayList();

		Fachada fachada = Fachada.getInstancia();

		RelatorioReligacaoClientesInadiplentesBean relatorioBean = null;

		Collection<RelatorioReligacaoClientesInadiplentesHelper> colecao = fachada.pesquisarRelatorioReligacaoClientesInadiplentes(relatorioHelper);

		// se a cole��o de par�metros da analise n�o for vazia
		if (colecao != null && !colecao.isEmpty()) {

			// la�o para criar a cole��o de par�metros da analise
			for (RelatorioReligacaoClientesInadiplentesHelper helper : colecao) {
			
				if(relatorioHelper.getEscolhaRelatorio() == 1){
					
					relatorioBean = new RelatorioReligacaoClientesInadiplentesBean(
							helper.getMatricula(),
							helper.getEndereco(),
							helper.getPerfil(),
							helper.getNumeroOS(),
							helper.getUsuarioAberturaOS(),
							helper.getNomeUsuarioAberturaOS(),
							helper.getDataEncerramento(),
							helper.getUsuarioEncerramentoOS(),
							helper.getNomeUsuarioEncerramentoOS(),
							helper.getValorDebito()
					);
				}
				else if(relatorioHelper.getEscolhaRelatorio() == 2){
					
					relatorioBean = new RelatorioReligacaoClientesInadiplentesBean(
							
							helper.getNomeCliente(),
							helper.getCpf(),
							helper.getTipoRelacao(),
							helper.getMatricula(),
							helper.getEndereco(),
							helper.getPerfil(),
							helper.getNumeroOS(),
							helper.getUsuarioAberturaOS(),
							helper.getNomeUsuarioAberturaOS(),
							helper.getDataEncerramento(),
							helper.getUsuarioEncerramentoOS(),
							helper.getNomeUsuarioEncerramentoOS(),
							helper.getValorDebito()
					);
				}
				else if(relatorioHelper.getEscolhaRelatorio() == 3 || 
						relatorioHelper.getEscolhaRelatorio() == 4 || 
						relatorioHelper.getEscolhaRelatorio() == 5 ){
					
					relatorioBean = new RelatorioReligacaoClientesInadiplentesBean(
							
							helper.getNomeCliente(),
							helper.getCpf(),
							helper.getTipoRelacao(),
							helper.getMatricula(),
							helper.getEndereco(),
							helper.getPerfil(),
							helper.getNumeroOS(),
							helper.getUsuarioAberturaOS(),
							helper.getNomeUsuarioAberturaOS(),
							helper.getDataEncerramento(),
							helper.getUsuarioEncerramentoOS(),
							helper.getNomeUsuarioEncerramentoOS(),
							helper.getValorDebito()
					);
				}
				
				relatorioBeans.add(relatorioBean);
			}
			
			if(relatorioHelper.getEscolhaRelatorio() == 2){
				
				Collections.sort((List) relatorioBeans,
					new Comparator() {
						public int compare(Object a, Object b) {
							String codigo1 = ((RelatorioReligacaoClientesInadiplentesBean) a)
									.getNomeCliente();
							String codigo2 = ((RelatorioReligacaoClientesInadiplentesBean) b)
								.getNomeCliente();
							if (codigo1 == null || codigo1.equals("")) {
								return -1;
							} else {
								return codigo1.compareTo(codigo2);
							}
						}
					});
			}
			
			if(relatorioHelper.getEscolhaRelatorio() == 3){
				
				Collections.sort((List) relatorioBeans,
					new Comparator() {
						public int compare(Object a, Object b) {
							String codigo1 = ((RelatorioReligacaoClientesInadiplentesBean) a)
									.getNomeUsuarioAberturaOS();
							String codigo2 = ((RelatorioReligacaoClientesInadiplentesBean) b)
								.getNomeUsuarioAberturaOS();
							if (codigo1 == null || codigo1.equals("")) {
								return -1;
							} else {
								return codigo2.compareTo(codigo1);
							}
						}
					});
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 4 || 
					relatorioHelper.getEscolhaRelatorio() == 5 ){
				
				Collections.sort((List) relatorioBeans,
					new Comparator() {
						public int compare(Object a, Object b) {
							String codigo1 = ((RelatorioReligacaoClientesInadiplentesBean) a)
									.getNomeUsuarioEncerramentoOS();
							String codigo2 = ((RelatorioReligacaoClientesInadiplentesBean) b)
								.getNomeUsuarioEncerramentoOS();
							if (codigo1 == null || codigo1.equals("")) {
								return -1;
							} else {
								return codigo2.compareTo(codigo1);
							}
						}
					});
			}
		}
		
		else{
			
			relatorioBean = new RelatorioReligacaoClientesInadiplentesBean();
			relatorioBeans.add(relatorioBean);
		}
		
		// __________________________________________________________________

		// Par�metros do relat�rio
		Map parametros = new HashMap();
		
		// adiciona os par�metros do relat�rio
		SistemaParametro sistemaParametro = fachada.pesquisarParametrosDoSistema();
		
		parametros.put("imagem", sistemaParametro.getImagemRelatorio());	
		
		parametros.put("gerenciaRegional", gerenciaRegional);
		parametros.put("unidadeNegocio", unidadeNegocio);
		parametros.put("localidade", localidade);
		parametros.put("setorComercial", setorComercial);
		parametros.put("cliente", cliente);
		parametros.put("nomeUsuario", nomeUsuario);
		parametros.put("periodoEncerramento", periodoEncerramento);
		parametros.put("periodoRecorrencia", periodoRecorrencia);
		
		// cria uma inst�ncia do dataSource do relat�rio
		RelatorioDataSource ds = new RelatorioDataSource(relatorioBeans);
		
		if(colecao != null && colecao.size() > 0){
			
			if(relatorioHelper.getEscolhaRelatorio() == 1){
				
				retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES,
						parametros, ds, tipoFormatoRelatorio);
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 2){
				
				retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES_2,
						parametros, ds, tipoFormatoRelatorio);
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 3){
				
				retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES_3,
						parametros, ds, tipoFormatoRelatorio);
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 4){
				
				retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES_4,
						parametros, ds, tipoFormatoRelatorio);
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 5){
				
				retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES_5,
						parametros, ds, tipoFormatoRelatorio);
			}
		}
		else{
			
			this.nomeRelatorio = ConstantesRelatorios.RELATORIO_VAZIO;
			
			retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_VAZIO,
					parametros, ds, tipoFormatoRelatorio);
		}
		
		
		
		// ------------------------------------
		// Grava o relat�rio no sistema
		try {
			persistirRelatorioConcluido(retorno, Relatorio.RELATORIO_RELIGACAO_CLIENTES_INADIPLENTES,
					idFuncionalidadeIniciada);
		} catch (ControladorException e) {
			e.printStackTrace();
			throw new TarefaException("Erro ao gravar relat�rio no sistema", e);
		}
		// ------------------------------------

		// retorna o relat�rio gerado
		return retorno;
	}

	@Override
	public int calcularTotalRegistrosRelatorio() {
		
		int retorno = 101;
		
		/*
		FiltrarRelatorioReligacaoClientesInadiplentesHelper relatorioHelper = 
			(FiltrarRelatorioReligacaoClientesInadiplentesHelper) getParametro("filtrarRelatorioReligacaoClientesInadiplentesHelper");
		
		retorno = Fachada.getInstancia().countRelatorioReligacaoClientesInadiplentes(relatorioHelper);
		
		if (retorno == 0) {
			// Caso a pesquisa n�o retorne nenhum resultado comunica ao
			// usu�rio;
			throw new RelatorioVazioException("atencao.relatorio.vazio");
		}
		else{
			
			if(relatorioHelper.getEscolhaRelatorio() == 1 && retorno > 100){
				retorno = 101;
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 2 && retorno > 100){
				retorno = 101;
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 3 && retorno > 25){
				retorno = 101;	
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 4 && retorno > 25){
				retorno = 101;
			}
			else if(relatorioHelper.getEscolhaRelatorio() == 5 && retorno > 100){
				retorno = 101;
			}
		}
		*/
		
		return retorno;		
	}

	public void agendarTarefaBatch() {
		AgendadorTarefas.agendarTarefa("RelatorioReligacaoClientesInadiplentes", this);
	}

}
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
package gcom.relatorio.faturamento;

import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.faturamento.FaturamentoAtividadeCronograma;
import gcom.faturamento.FaturamentoGrupo;
import gcom.relatorio.ConstantesRelatorios;
import gcom.relatorio.RelatorioDataSource;
import gcom.relatorio.RelatorioVazioException;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaException;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.agendadortarefas.AgendadorTarefas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * classe respons�vel por criar o relat�rio de bairro manter de �gua
 * 
 * @author S�vio Luiz
 * @created 11 de Julho de 2005
 */
public class RelatorioPosicaoFaturamento extends TarefaRelatorio {
	private static final long serialVersionUID = 1L;

	public RelatorioPosicaoFaturamento(Usuario usuario) {
		super(usuario, ConstantesRelatorios.RELATORIO_POSICAO_FATURAMENTO);
	}

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param bairros
	 *            Description of the Parameter
	 * @param bairroParametros
	 *            Description of the Parameter
	 * @return Descri��o do retorno
	 * @exception RelatorioVazioException
	 *                Descri��o da exce��o
	 */
	public Object executar() throws TarefaException {

		Map<FaturamentoGrupo, Collection<FaturamentoAtividadeCronograma>> map = (Map<FaturamentoGrupo, Collection<FaturamentoAtividadeCronograma>>) getParametro("map");
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");

		// valor de retorno
		byte[] retorno = null;

		// cole��o de beans do relat�rio
		List relatorioBeans = new ArrayList();

		Fachada fachada = Fachada.getInstancia();

		if (map != null && !map.isEmpty()) {

			Collection<FaturamentoGrupo> colecaoFaturamentoGrupo = map.keySet();

			for (FaturamentoGrupo grupo : colecaoFaturamentoGrupo) {

				Collection<FaturamentoAtividadeCronograma> colecaoFaturamentoAtividadeCronograma = map
						.get(grupo);

				for (FaturamentoAtividadeCronograma faturamentoAtividadeCronograma : colecaoFaturamentoAtividadeCronograma) {

					// Faz as valida��es dos campos necess�riose e formata a
					// String
					// para a forma como ir� aparecer no relat�rio

					// Grupo de Faturamento / M�s/Ano
					String grupoFaturamento = "";
					String mesAno = "";

					if (faturamentoAtividadeCronograma
							.getFaturamentoGrupoCronogramaMensal() != null
							&& faturamentoAtividadeCronograma
									.getFaturamentoGrupoCronogramaMensal()
									.getFaturamentoGrupo() != null) {
						grupoFaturamento = faturamentoAtividadeCronograma
								.getFaturamentoGrupoCronogramaMensal()
								.getFaturamentoGrupo().getDescricao();
						mesAno = Util
								.formatarAnoMesParaMesAno(faturamentoAtividadeCronograma
										.getFaturamentoGrupoCronogramaMensal()
										.getFaturamentoGrupo()
										.getAnoMesReferencia());
					}

					// Atividade / Predecessora / Obrigatoriedade
					String atividade = "";
					String predecessora = "";
					String obrigatoria = "";

					if (faturamentoAtividadeCronograma
							.getFaturamentoAtividade() != null) {

						atividade = faturamentoAtividadeCronograma
								.getFaturamentoAtividade().getDescricao();

						if (faturamentoAtividadeCronograma
								.getFaturamentoAtividade()
								.getIndicadorObrigatoriedadeAtividade().equals(
										ConstantesSistema.SIM)) {
							obrigatoria = "SIM";
						} else {
							obrigatoria = "N�O";
						}

						if (faturamentoAtividadeCronograma
								.getFaturamentoAtividade()
								.getFaturamentoAtividadePrecedente() != null) {
							predecessora = faturamentoAtividadeCronograma
									.getFaturamentoAtividade()
									.getFaturamentoAtividadePrecedente()
									.getDescricao();
						}

					}

					// Data Previs�o / Usu�rio Previs�o
					String dataPrevisao = "";
					String usuarioPrevisao = "";

					if (faturamentoAtividadeCronograma.getDataPrevista() != null) {
						dataPrevisao = Util
								.formatarData(faturamentoAtividadeCronograma
										.getDataPrevista());

						if (faturamentoAtividadeCronograma
								.getFaturamentoGrupoCronogramaMensal() != null
								&& faturamentoAtividadeCronograma
										.getFaturamentoGrupoCronogramaMensal()
										.getUsuario() != null) {
							usuarioPrevisao = faturamentoAtividadeCronograma
									.getFaturamentoGrupoCronogramaMensal()
									.getUsuario().getNomeUsuario();
						}
					}

					// Data Comando / Usu�rio Comando
					String dataComando = "";
					String usuarioComando = "";

					if (faturamentoAtividadeCronograma.getComando() != null) {
						dataComando = Util
								.formatarDataComHora(faturamentoAtividadeCronograma
										.getComando());

						if (faturamentoAtividadeCronograma.getUsuario() != null) {
							usuarioComando = faturamentoAtividadeCronograma
									.getUsuario().getNomeUsuario();
						}

					}

					// Data Realiza��o
					String dataRealizacao = "";

					if (faturamentoAtividadeCronograma.getDataRealizacao() != null) {
						dataRealizacao = Util
								.formatarDataComHora(faturamentoAtividadeCronograma
										.getDataRealizacao());
					}

					RelatorioPosicaoFaturamentoBean relatorioBean = new RelatorioPosicaoFaturamentoBean(

					// Grupo de Faturamento
							grupoFaturamento,

							// M�s/Ano
							mesAno,

							// Atividade
							atividade,

							// Predecessora
							predecessora,

							// Obrigat�ria
							obrigatoria,

							// Data Previs�o
							dataPrevisao,

							// Usu�rio Previs�o
							usuarioPrevisao,

							// Data Comando
							dataComando,

							// Usu�rio Comando
							usuarioComando,

							// Data Realiza��o
							dataRealizacao);

					// adiciona o bean a cole��o
					relatorioBeans.add(relatorioBean);
				}
			}
		}

		// Par�metros do relat�rio
		Map parametros = new HashMap();

		// adiciona os par�metros do relat�rio
		// adiciona o laudo da an�lise
		SistemaParametro sistemaParametro = fachada
				.pesquisarParametrosDoSistema();

		parametros.put("imagem", sistemaParametro.getImagemRelatorio());

		// cria uma inst�ncia do dataSource do relat�rio
		RelatorioDataSource ds = new RelatorioDataSource(relatorioBeans);

		retorno = gerarRelatorio(
				ConstantesRelatorios.RELATORIO_POSICAO_FATURAMENTO, parametros,
				ds, tipoFormatoRelatorio);

		// retorna o relat�rio gerado
		return retorno;
	}

	@Override
	public int calcularTotalRegistrosRelatorio() {
		int retorno = 0;

		return retorno;
	}

	public void agendarTarefaBatch() {
		AgendadorTarefas.agendarTarefa("RelatorioPosicaoFaturamento", this);
	}
}
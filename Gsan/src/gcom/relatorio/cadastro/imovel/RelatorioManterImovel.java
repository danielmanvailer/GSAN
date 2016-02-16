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
package gcom.relatorio.cadastro.imovel;

import gcom.batch.Relatorio;
import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.cliente.ClienteImovel;
import gcom.cadastro.cliente.ClienteRelacaoTipo;
import gcom.cadastro.cliente.FiltroClienteImovel;
import gcom.cadastro.geografico.Bairro;
import gcom.cadastro.geografico.Municipio;
import gcom.cadastro.imovel.FiltroImovelSubCategoria;
import gcom.cadastro.imovel.Imovel;
import gcom.cadastro.imovel.ImovelSubcategoria;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.micromedicao.consumo.ConsumoHistorico;
import gcom.micromedicao.consumo.FiltroConsumoHistorico;
import gcom.micromedicao.hidrometro.HidrometroInstalacaoHistorico;
import gcom.relatorio.ConstantesRelatorios;
import gcom.relatorio.RelatorioDataSource;
import gcom.relatorio.RelatorioVazioException;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaException;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.ControladorException;
import gcom.util.Util;
import gcom.util.agendadortarefas.AgendadorTarefas;
import gcom.util.filtro.ParametroNulo;
import gcom.util.filtro.ParametroSimples;
import gcom.util.filtro.ParametroSimplesIn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * classe respons�vel por criar o relat�rio de im�vel manter
 * 
 * @author Rafael Corr�a
 * @created 11 de Julho de 2005
 */
public class RelatorioManterImovel extends TarefaRelatorio {
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor da classe RelatorioAnaliseFisicoQuimicaAgua
	 */
	public RelatorioManterImovel(Usuario usuario) {
		super(usuario, ConstantesRelatorios.RELATORIO_IMOVEL_MANTER);
	}
	
	@Deprecated
	public RelatorioManterImovel() {
		super(null, "");
	}
	
	
	/**
	 * <<Descri��o do m�todo>>
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

		// ------------------------------------
		Integer idFuncionalidadeIniciada = this.getIdFuncionalidadeIniciada();
		// ------------------------------------
		
		

		FiltroClienteImovel filtroClienteImovelPesquisa = (FiltroClienteImovel) getParametro("filtroClienteImovel");
		Imovel imovelParametros = (Imovel) getParametro("imovelParametros");
		Cliente cliente = (Cliente) getParametro("cliente");
		Municipio municipio = (Municipio) getParametro("municipio");
		Bairro bairro = (Bairro) getParametro("bairro");
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");
		String numeroImovelInicial = (String) getParametro("numeroImovelInicial");
		String numeroImovelFinal = (String) getParametro("numeroImovelFinal");
		Collection imoveisLista = (Collection) getParametro("imoveisLista");		

		// valor de retorno
		byte[] retorno = null;

		// cole��o de beans do relat�rio
		List relatorioBeans = new ArrayList();

		Fachada fachada = Fachada.getInstancia();

		RelatorioManterImovelBean relatorioBean = null;

		filtroClienteImovelPesquisa.setConsultaSemLimites(true);
		
		Collection imovelFiltro = new ArrayList();
		
		Iterator it = imoveisLista.iterator();
		
		//inserir na cole��o os im�veis do filtro
		while(it.hasNext()){
			ClienteImovel clienteImovel = (ClienteImovel) it.next();
			
			if(clienteImovel != null){
				
				imovelFiltro.add(clienteImovel.getImovel().getId());
			}
		}			
				
		//adicionando os im�veis do filtro para o relat�rio
		filtroClienteImovelPesquisa.adicionarParametro(new ParametroSimplesIn(
			FiltroClienteImovel.IMOVEL_ID, imovelFiltro));	

		Collection imoveis = fachada
				.pesquisarClienteImovelRelatorio(filtroClienteImovelPesquisa);

		// se a cole��o de par�metros da analise n�o for vazia
		if (imoveis != null && !imoveis.isEmpty()) {
			// coloca a cole��o de par�metros da analise no iterator
			Iterator imovelIterator = imoveis.iterator();

			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

			while (imovelIterator.hasNext()) {

				Imovel imovelNovo = (Imovel) imovelIterator.next();

				ClienteImovel clienteImovel = null;
				ClienteImovel clienteUsuario = null;
				ClienteImovel clienteResponsavel = null;
				ImovelSubcategoria imovelSubcategoria = null;
				String imovelSubcategoriaImprimir = "";
				String mediaConsumo = "";
				short quantidadeEconomias = 0;

				if (imovelNovo.getId() != null
						&& !imovelNovo.getId().equals("")) {
					FiltroClienteImovel filtroClienteImovel = new FiltroClienteImovel();

					filtroClienteImovel
							.adicionarParametro(new ParametroSimples(
									FiltroClienteImovel.IMOVEL_ID, imovelNovo
											.getId()));
					filtroClienteImovel
							.adicionarParametro(new ParametroNulo(FiltroClienteImovel.DATA_FIM_RELACAO));
					filtroClienteImovel
							.adicionarCaminhoParaCarregamentoEntidade("cliente");
					filtroClienteImovel
							.adicionarCaminhoParaCarregamentoEntidade("clienteRelacaoTipo");

					Collection clientesImoveis = fachada.pesquisar(
							filtroClienteImovel, ClienteImovel.class.getName());

					if (clientesImoveis != null && !clientesImoveis.isEmpty()) {
						// O Cliente Imovel foi encontrado
						Iterator clienteImovelIterator = clientesImoveis
								.iterator();

						while (clienteImovelIterator.hasNext()) {
							clienteImovel = (ClienteImovel) clienteImovelIterator
									.next();

							// Trazer o cliente usu�rio do im�vel
							if (clienteImovel.getClienteRelacaoTipo().getId()
									.toString().equals(
											ClienteRelacaoTipo.USUARIO
													.toString())) {
								clienteUsuario = clienteImovel;
							}

							// Trazer o cliente respons�vel do im�vel
							if (clienteImovel.getClienteRelacaoTipo().getId()
									.toString().equals(
											ClienteRelacaoTipo.RESPONSAVEL
													.toString())) {
								clienteResponsavel = clienteImovel;
							}
						}

					}

					FiltroImovelSubCategoria filtroImovelSubCategoria = new FiltroImovelSubCategoria();

					filtroImovelSubCategoria
							.adicionarParametro(new ParametroSimples(
									FiltroImovelSubCategoria.IMOVEL_ID,
									imovelNovo.getId()));

					filtroImovelSubCategoria
							.adicionarCaminhoParaCarregamentoEntidade("comp_id.subcategoria");

					Collection imoveisSubCategorias = fachada.pesquisar(
							filtroImovelSubCategoria, ImovelSubcategoria.class
									.getName());

					if (imoveisSubCategorias != null
							&& !imoveisSubCategorias.isEmpty()) {
						// O Cliente Imovel foi encontrado
						Iterator imovelSubCategoriaIterator = imoveisSubCategorias
								.iterator();

						while (imovelSubCategoriaIterator.hasNext()) {

							// Concatenar as categorias com suas respectivas
							// quantidades de economias
							imovelSubcategoria = (ImovelSubcategoria) imovelSubCategoriaIterator
									.next();
							quantidadeEconomias = imovelSubcategoria
									.getQuantidadeEconomias();

							if (imovelSubcategoriaImprimir != null
									&& !imovelSubcategoriaImprimir.equals("")) {

								imovelSubcategoriaImprimir = imovelSubcategoriaImprimir
										+ (imovelSubcategoria.getComp_id()
												.getSubcategoria()
												.getDescricao() == null ? ""
												: "; "
														+ imovelSubcategoria
																.getComp_id()
																.getSubcategoria()
																.getDescricao()
														+ "/" + ""
														+ quantidadeEconomias);
							} else {
								imovelSubcategoriaImprimir = imovelSubcategoriaImprimir
										+ (imovelSubcategoria.getComp_id()
												.getSubcategoria()
												.getDescricao() == null ? ""
												: imovelSubcategoria
														.getComp_id()
														.getSubcategoria()
														.getDescricao()
														+ "/"
														+ ""
														+ quantidadeEconomias);
							}
						}
					}

					FiltroConsumoHistorico filtroConsumoHistorico = new FiltroConsumoHistorico();
					filtroConsumoHistorico
							.adicionarParametro(new ParametroSimples(
									FiltroConsumoHistorico.IMOVEL_ID,
									imovelNovo.getId()));

					SistemaParametro sistemaParametro = fachada
							.pesquisarParametrosDoSistema();

					if (sistemaParametro != null) {

						filtroConsumoHistorico
								.adicionarParametro(new ParametroSimples(
										FiltroConsumoHistorico.ANO_MES_FATURAMENTO,
										Util.subtrairData(sistemaParametro
												.getAnoMesFaturamento())));

					}

					Collection consumosHistorico = fachada.pesquisar(
							filtroConsumoHistorico, ConsumoHistorico.class
									.getName());

					if (consumosHistorico != null
							&& !consumosHistorico.isEmpty()) {
						Iterator consumoHistoricoIterator = consumosHistorico
								.iterator();

						ConsumoHistorico consumoHistorico = (ConsumoHistorico) consumoHistoricoIterator
								.next();

						mediaConsumo = "" + consumoHistorico.getConsumoMedio();
					}

				}
				String indicadorJardim = "";
				if ( imovelNovo.getIndicadorJardim() != null && !imovelNovo.getIndicadorJardim().equals("") ) {
					if ( imovelNovo.getIndicadorJardim().equals(
							Imovel.INDICADOR_JARDIM_SIM)) {
						indicadorJardim = "SIM";
					} else {
						indicadorJardim = "N�O";
					}
					
				}
				// In�cio da Constru��o do objeto RelatorioManterImovelBean
				// para ser colocado no relat�rio
				relatorioBean = new RelatorioManterImovelBean(

						// C�digo da Ger�ncia Regional
						imovelNovo.getLocalidade() == null ? "" : ""
								+ imovelNovo.getLocalidade()
										.getGerenciaRegional().getId(),

						// Descri��o da Ger�ncia Regional
						imovelNovo.getLocalidade() == null ? "" : imovelNovo
								.getLocalidade().getGerenciaRegional()
								.getNomeAbreviado(),

						// C�digo da Unidade de Neg�cio
						imovelNovo.getLocalidade() == null ? ""
								: imovelNovo.getLocalidade()
										.getUnidadeNegocio() == null ? "" : ""
										+ imovelNovo.getLocalidade()
												.getUnidadeNegocio().getId(),

						// Descri��o da Unidade de Neg�cio
						imovelNovo.getLocalidade() == null ? ""
								: imovelNovo.getLocalidade()
										.getUnidadeNegocio() == null ? ""
										: imovelNovo.getLocalidade()
												.getUnidadeNegocio().getNome(),

						// C�digo da Localidade
						imovelNovo.getLocalidade() == null ? "" : ""
								+ imovelNovo.getLocalidade().getId(),

						// Descri��o da Localidade
						imovelNovo.getLocalidade() == null ? "" : imovelNovo
								.getLocalidade().getDescricao(),

						// C�digo do Setor Comercial
						imovelNovo.getSetorComercial() == null ? "" : ""
								+ imovelNovo.getSetorComercial().getCodigo(),

						// Descri��o do Setor Comercial
						imovelNovo.getSetorComercial() == null ? ""
								: imovelNovo.getSetorComercial().getDescricao(),

						// Inscri��o do Im�vel composto do c�digo da
						// localidade, c�digo do setor comercial, n�mero da
						// quadra, lote e sublote
						imovelNovo.getInscricaoFormatada(),

						// Matr�cula do Im�vel
						imovelNovo.getId().toString(),

						// C�digo do Cliente Usu�rio
						clienteUsuario == null ? "" : ""
								+ clienteUsuario.getCliente().getId(),

						// Nome do Cliente Usu�rio
						clienteUsuario == null ? "" : clienteUsuario
								.getCliente().getNome(),

						// C�digo do Cliente Respons�vel
						clienteResponsavel == null ? "" : ""
								+ clienteResponsavel.getCliente().getId(),

						// Nome do Cliente Respons�vel
						clienteResponsavel == null ? "" : clienteResponsavel
								.getCliente().getNome(),

						// Endere�o
						imovelNovo.getEnderecoFormatado(),

						// Indicador Im�vel Condom�nio
						imovelNovo.getIndicadorImovelCondominio() == null ? ""
								: imovelNovo.getIndicadorImovelCondominio()
										.equals(Imovel.IMOVEL_CONDOMINIO) ? "SIM"
										: "N�O",

						// Matr�cula Im�vel Condom�nio
						imovelNovo.getImovelCondominio() == null ? ""
								: imovelNovo.getImovelCondominio().getId() == null ? ""
										: ""
												+ imovelNovo
														.getImovelCondominio()
														.getId(),

						// Matr�cula Im�vel Principal
						imovelNovo.getImovelPrincipal() == null ? "" : ""
								+ imovelNovo.getImovelPrincipal().getId(),

						// Perfil Im�vel
						imovelNovo.getImovelPerfil() == null ? "" : imovelNovo
								.getImovelPerfil().getDescricao(),

						// Subcategorias / Quantidade de Economias
						imovelSubcategoriaImprimir,

						// Situa��o da Liga��o de �gua
						imovelNovo.getLigacaoAguaSituacao() == null ? ""
								: imovelNovo.getLigacaoAguaSituacao()
										.getDescricao(),

						// Situa��o da Liga��o de Esgoto
						imovelNovo.getLigacaoEsgotoSituacao() == null ? ""
								: imovelNovo.getLigacaoEsgotoSituacao()
										.getDescricao(),

						// Tipo Pavimento Cal�ada
						imovelNovo.getPavimentoCalcada() == null ? ""
								: imovelNovo.getPavimentoCalcada()
										.getDescricao(),

						// Tipo Pavimento Rua
						imovelNovo.getPavimentoRua() == null ? "" : imovelNovo
								.getPavimentoRua().getDescricao(),

						// Tipo de Despejo
						imovelNovo.getDespejo() == null ? "" : imovelNovo
								.getDespejo().getDescricao(),

						// Volume do Reservat�rio Superior
						imovelNovo.getVolumeReservatorioSuperior() == null ? imovelNovo
								.getReservatorioVolumeFaixaSuperior() == null ? ""
								: imovelNovo
										.getReservatorioVolumeFaixaSuperior()
										.getFaixaCompleta()
								: Util.formatarMoedaReal(imovelNovo
										.getVolumeReservatorioSuperior()),

						// Volume do Reservat�rio Inferior
						imovelNovo.getVolumeReservatorioInferior() == null ? imovelNovo
								.getReservatorioVolumeFaixaInferior() == null ? ""
								: imovelNovo
										.getReservatorioVolumeFaixaInferior()
										.getFaixaCompleta()
								: Util.formatarMoedaReal(imovelNovo
										.getVolumeReservatorioInferior()),

						// Volume da Piscina
						imovelNovo.getVolumePiscina() == null ? imovelNovo
								.getPiscinaVolumeFaixa() == null ? ""
								: imovelNovo.getPiscinaVolumeFaixa()
										.getFaixaCompleta() : Util
								.formatarMoedaReal(imovelNovo
										.getVolumePiscina()),

						// M�dia de Consumo do Im�vel
						mediaConsumo,

						// �rea Constru�da
						imovelNovo.getAreaConstruida() == null ? imovelNovo
								.getAreaConstruidaFaixa() == null ? ""
								: imovelNovo.getAreaConstruidaFaixa()
										.getFaixaCompleta() : Util
								.formatarMoedaReal(imovelNovo
										.getAreaConstruida()),

						// N�mero de Moradores
						imovelNovo.getNumeroMorador() == null ? "" : ""
								+ imovelNovo.getNumeroMorador(),

						// Pontos de Utiliza��o
						imovelNovo.getNumeroPontosUtilizacao() == null ? ""
								: "" + imovelNovo.getNumeroPontosUtilizacao(),

						// Tipo do Po�o
						imovelNovo.getPocoTipo() == null ? "" : imovelNovo
								.getPocoTipo().getDescricao(),

						// Jardim
						indicadorJardim,

						// Data da Liga��o de �gua
						imovelNovo.getLigacaoAgua() == null ? "" : imovelNovo
								.getLigacaoAgua().getDataLigacao() == null ? ""
								: dataFormatada.format(imovelNovo
										.getLigacaoAgua().getDataLigacao()),

						// Di�metro da Liga��o de �gua
						imovelNovo.getLigacaoAgua() == null ? "" : imovelNovo
								.getLigacaoAgua().getLigacaoAguaDiametro()
								.getDescricao(),

						// Material da Liga��o de �gua
						imovelNovo.getLigacaoAgua() == null ? "" : imovelNovo
								.getLigacaoAgua().getLigacaoAguaMaterial()
								.getDescricao(),

						// Consumo M�nimo Fixado de �gua
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getNumeroConsumoMinimoAgua() == null ? ""
										: ""
												+ imovelNovo
														.getLigacaoAgua()
														.getNumeroConsumoMinimoAgua(),

						// Data da Liga��o de Esgoto
						imovelNovo.getLigacaoEsgoto() == null ? ""
								: imovelNovo.getLigacaoEsgoto()
										.getDataLigacao() == null ? ""
										: dataFormatada.format(imovelNovo
												.getLigacaoEsgoto()
												.getDataLigacao()),

						// Di�metro da Liga��o de Esgoto
						imovelNovo.getLigacaoEsgoto() == null ? "" : imovelNovo
								.getLigacaoEsgoto().getLigacaoEsgotoDiametro()
								.getDescricao(),

						// Material da Liga��o de Esgoto
						imovelNovo.getLigacaoEsgoto() == null ? "" : imovelNovo
								.getLigacaoEsgoto().getLigacaoEsgotoMaterial()
								.getDescricao(),

						// Percentual da Coleta de �gua
						imovelNovo.getLigacaoEsgoto() == null ? "" : Util
								.formatarMoedaReal(imovelNovo
										.getLigacaoEsgoto()
										.getPercentualAguaConsumidaColetada()),

						// Percentual de Esgoto
						imovelNovo.getLigacaoEsgoto() == null ? "" : Util
								.formatarMoedaReal(imovelNovo
										.getLigacaoEsgoto().getPercentual()),

						// Consumo M�nimo Fixado de Esgoto
						imovelNovo.getLigacaoEsgoto() == null ? ""
								: imovelNovo.getLigacaoEsgoto()
										.getConsumoMinimo() == null ? "" : ""
										+ imovelNovo.getLigacaoEsgoto()
												.getConsumoMinimo(),

						// In�cio dos Dados do Hidr�metro Instalado na
						// Liga��o de �gua
						// N�mero
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro().getNumero(),

						// Ano de Fabrica��o
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: ""
														+ imovelNovo
																.getLigacaoAgua()
																.getHidrometroInstalacaoHistorico()
																.getHidrometro()
																.getAnoFabricacao(),

						// Capacidade
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: imovelNovo
														.getLigacaoAgua()
														.getHidrometroInstalacaoHistorico()
														.getHidrometro()
														.getHidrometroCapacidade()
														.getDescricao(),

						// Marca
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: imovelNovo
														.getLigacaoAgua()
														.getHidrometroInstalacaoHistorico()
														.getHidrometro()
														.getHidrometroMarca()
														.getDescricao(),

						// Di�metro
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: imovelNovo
														.getLigacaoAgua()
														.getHidrometroInstalacaoHistorico()
														.getHidrometro()
														.getHidrometroDiametro()
														.getDescricao(),

						// Tipo
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: imovelNovo
														.getLigacaoAgua()
														.getHidrometroInstalacaoHistorico()
														.getHidrometro()
														.getHidrometroTipo()
														.getDescricao(),

						// Data de Instala��o
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: dataFormatada
												.format(imovelNovo
														.getLigacaoAgua()
														.getHidrometroInstalacaoHistorico()
														.getDataInstalacao()),

						// Local de Instala��o
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometroLocalInstalacao()
												.getDescricao(),

						// Tipo de Prote��o
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getHidrometroProtecao()
												.getDescricao(),

						// Indicador da Exist�ncia de Cavalete
						imovelNovo.getLigacaoAgua() == null ? ""
								: imovelNovo.getLigacaoAgua()
										.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getLigacaoAgua()
												.getHidrometroInstalacaoHistorico()
												.getIndicadorExistenciaCavalete()
												.equals(
														HidrometroInstalacaoHistorico.INDICADOR_CAVALETE_SIM) ? "SIM"
												: "N�O",
						// Fim dos Dados do Hidr�metro Instalado na Liga��o
						// de �gua

						// In�cio dos Dados do Hidr�metro Instalado na Sa�da
						// do Po�o
						// N�mero
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometro().getNumero(),

						// Ano de Fabrica��o
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: ""
										+ imovelNovo
												.getHidrometroInstalacaoHistorico() == null ? ""
										: imovelNovo
												.getHidrometroInstalacaoHistorico()
												.getHidrometro() == null ? ""
												: ""
														+ imovelNovo
																.getHidrometroInstalacaoHistorico()
																.getHidrometro()
																.getAnoFabricacao(),

						// Capacidade
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometro() == null ? ""
										: imovelNovo
												.getHidrometroInstalacaoHistorico()
												.getHidrometro()
												.getHidrometroCapacidade()
												.getDescricao(),

						// Marca
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometro() == null ? ""
										: imovelNovo
												.getHidrometroInstalacaoHistorico()
												.getHidrometro()
												.getHidrometroMarca()
												.getDescricao(),

						// Di�metro
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometro() == null ? ""
										: imovelNovo
												.getHidrometroInstalacaoHistorico()
												.getHidrometro()
												.getHidrometroDiametro()
												.getDescricao(),

						// Tipo
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometro() == null ? ""
										: imovelNovo
												.getHidrometroInstalacaoHistorico()
												.getHidrometro()
												.getHidrometroTipo()
												.getDescricao(),

						// Data de Instala��o
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: dataFormatada.format(imovelNovo
										.getHidrometroInstalacaoHistorico()
										.getDataInstalacao()),

						// Local de Instala��o
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometroLocalInstalacao()
										.getDescricao(),

						// Tipo de Prote��o
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo.getHidrometroInstalacaoHistorico()
										.getHidrometroProtecao().getDescricao(),

						// Indicador da Exist�ncia de Cavalete
						imovelNovo.getHidrometroInstalacaoHistorico() == null ? ""
								: imovelNovo
										.getHidrometroInstalacaoHistorico()
										.getIndicadorExistenciaCavalete()
										.equals(
												HidrometroInstalacaoHistorico.INDICADOR_CAVALETE_SIM) ? "SIM"
										: "N�O",
				
						// Rota
						imovelNovo.getQuadra().getRota().getCodigo().toString(),
						
						// Sequencial Rota
						imovelNovo.getNumeroSequencialRota() == null? "": imovelNovo.getNumeroSequencialRota().toString(),
						
						// Logradouro	
							imovelNovo.getLogradouroCep() == null ? ""
							: imovelNovo.getLogradouroCep().getLogradouro() == null ? ""
								:imovelNovo.getLogradouroCep().getLogradouro().getId().toString(),
						null
						
				);
				// Fim dos Dados do Hidr�metro Instalado na Sa�da do
				// Po�o

				// Fim da Constru��o do objeto RelatorioManterImovelBean
				// para ser colocado no relat�rio

				// adiciona o bean a cole��o
				relatorioBeans.add(relatorioBean);
			}
		}

		// Par�metros do relat�rio
		Map parametros = new HashMap();
		
		SistemaParametro sistemaParametro = fachada.pesquisarParametrosDoSistema();
		
		parametros.put("imagem", sistemaParametro.getImagemRelatorio());

		parametros.put("matricula", imovelParametros.getId() == null ? "" : ""
				+ imovelParametros.getId());
		parametros.put("idLocalidade",
				imovelParametros.getLocalidade().getId() == null ? "" : ""
						+ imovelParametros.getLocalidade().getId());
		parametros.put("nomeLocalidade", imovelParametros.getLocalidade()
				.getDescricao());
		parametros.put("idSetorComercial", imovelParametros.getSetorComercial() == null || imovelParametros.getSetorComercial()
				.getId() == null ? "" : ""
				+ imovelParametros.getSetorComercial().getCodigo());
		parametros.put("nomeSetorComercial", imovelParametros
				.getSetorComercial() == null ? "" : imovelParametros
						.getSetorComercial().getDescricao());
		parametros.put("numeroQuadra", imovelParametros.getQuadra()
				.getNumeroQuadra() == 0 ? "" : ""
				+ imovelParametros.getQuadra().getNumeroQuadra());
		parametros.put("lote", imovelParametros.getLote() == 0 ? "" : ""
				+ imovelParametros.getLote());
		parametros.put("subLote", imovelParametros.getSubLote() == 0 ? "" : ""
				+ imovelParametros.getSubLote());
		parametros.put("idCliente", cliente.getId() == null ? "" : cliente
				.getId().toString());
		parametros.put("nomeCliente", cliente.getNome());
		parametros.put("cep",
				imovelParametros.getLogradouroCep().getCep() == null ? ""
						: imovelParametros.getLogradouroCep().getCep()
								.getCodigo() == null ? "" : ""
								+ imovelParametros.getLogradouroCep().getCep()
										.getCodigo());
		parametros.put("idMunicipio", municipio.getId() == null ? "" : ""
				+ municipio.getId());
		parametros.put("nomeMunicipio", municipio.getNome());
		parametros.put("idBairro", bairro.getId() == null ? "" : ""
				+ bairro.getCodigo());
		parametros.put("nomeBairro", bairro.getNome());
		parametros.put("nomeLogradouro", imovelParametros.getLogradouroCep()
				.getLogradouro() == null ? "" : imovelParametros
				.getLogradouroCep().getLogradouro().getNome());

		RelatorioDataSource ds = new RelatorioDataSource((List) relatorioBeans);

		// exporta o relat�rio em pdf e retorna o array de bytes
		retorno = this.gerarRelatorio(
				ConstantesRelatorios.RELATORIO_IMOVEL_MANTER, parametros, ds,
				tipoFormatoRelatorio);

		// ------------------------------------
		// Grava o relat�rio no sistema
		try {
			persistirRelatorioConcluido(retorno, Relatorio.MANTER_IMOVEL,
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

		int retorno = Fachada.getInstancia().pesquisarQuantidadeClienteImovel(
				(FiltroClienteImovel) getParametro("filtroClienteImovel"));

		return retorno;
	}

	public void agendarTarefaBatch() {
		AgendadorTarefas.agendarTarefa("RelatorioManterImovel", this);
	}
}

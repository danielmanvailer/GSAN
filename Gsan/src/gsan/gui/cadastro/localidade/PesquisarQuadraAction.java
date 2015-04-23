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
package gsan.gui.cadastro.localidade;

import gsan.cadastro.localidade.FiltroQuadra;
import gsan.cadastro.localidade.Quadra;
import gsan.fachada.Fachada;
import gsan.gui.ActionServletException;
import gsan.gui.GcomAction;
import gsan.util.ConstantesSistema;
import gsan.util.filtro.ParametroSimples;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * Action que define o processamento da p�gina de pesquisa de Quadra
 * 
 * @author Fl�vio
 */

public class PesquisarQuadraAction extends GcomAction {
	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param actionMapping
	 *            Descri��o do par�metro
	 * @param actionForm
	 *            Descri��o do par�metro
	 * @param httpServletRequest
	 *            Descri��o do par�metro
	 * @param httpServletResponse
	 *            Descri��o do par�metro
	 * @return Descri��o do retorno
	 */
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		ActionForward retorno = actionMapping.findForward("listaQuadra");

		HttpSession sessao = httpServletRequest.getSession(false);

		DynaValidatorForm pesquisarActionForm = (DynaValidatorForm) actionForm;

		Fachada fachada = Fachada.getInstancia();

		String numeroQuadra = (String) pesquisarActionForm.get("numeroQuadra");
		String idRota = (String) pesquisarActionForm.get("idRota");
		//String nomeBairro = (String) pesquisarActionForm.get("nomeBairro");
		//String tipoPesquisa = (String) pesquisarActionForm.get("tipoPesquisa");
		String idSetorComercial = (String) sessao
				.getAttribute("idSetorComercial");
		String codigoSetorComercial = (String) sessao
				.getAttribute("codigoSetorComercial");
		

		boolean peloMenosUmParametroInformado = false;

		FiltroQuadra filtroQuadra = new FiltroQuadra();

		// Objetos que ser�o retornados pelo Hibernate
		filtroQuadra.adicionarCaminhoParaCarregamentoEntidade("bairro");
		filtroQuadra.adicionarCaminhoParaCarregamentoEntidade("setorComercial");
		filtroQuadra.adicionarCaminhoParaCarregamentoEntidade("setorComercial.localidade");


		if (numeroQuadra != null && !numeroQuadra.trim().equalsIgnoreCase("")) {
			filtroQuadra.adicionarParametro(new ParametroSimples(
					FiltroQuadra.NUMERO_QUADRA, new Integer(numeroQuadra)));
			peloMenosUmParametroInformado = true;
		}
		

		if (idSetorComercial != null
				&& !idSetorComercial.trim().equalsIgnoreCase("")) {
			filtroQuadra.adicionarParametro(new ParametroSimples(
					FiltroQuadra.ID_SETORCOMERCIAL, new Integer(
							idSetorComercial)));
			peloMenosUmParametroInformado = true;
		}
		if (codigoSetorComercial != null
				&& !codigoSetorComercial.trim().equalsIgnoreCase("")) {
			filtroQuadra.adicionarParametro(new ParametroSimples(
					FiltroQuadra.CODIGO_SETORCOMERCIAL, new Integer(
							codigoSetorComercial)));
			peloMenosUmParametroInformado = true;
		}
		
		if (idRota != null && !idRota.equalsIgnoreCase("")) {
			peloMenosUmParametroInformado = true;
			filtroQuadra.adicionarParametro(new ParametroSimples(
					FiltroQuadra.ROTA_ID, new Integer(idRota)));
		}

		if (sessao.getAttribute("indicadorUsoTodos") == null) {
			filtroQuadra.adicionarParametro(new ParametroSimples(
					FiltroQuadra.INDICADORUSO,
					ConstantesSistema.INDICADOR_USO_ATIVO));
		}

		if (!peloMenosUmParametroInformado) {
			throw new ActionServletException(
					"atencao.filtro.nenhum_parametro_informado");
		}

		Collection quadras = fachada.pesquisar(filtroQuadra, Quadra.class
				.getName());

		if (quadras != null && !quadras.isEmpty()) {
			// Aciona o controle de pagina��o para que sejam pesquisados apenas
			// os registros que aparecem na p�gina
			Map resultado = controlarPaginacao(httpServletRequest, retorno,
					filtroQuadra, Quadra.class.getName());
			quadras = (Collection) resultado.get("colecaoRetorno");
			retorno = (ActionForward) resultado.get("destinoActionForward");

			sessao.setAttribute("quadras", quadras);
		} else {
			throw new ActionServletException(
					"atencao.pesquisa.nenhumresultado", null, "quadra");
		}

		// Passa parametros para distinguir o tipo de retorno
		sessao
				.setAttribute("tipoPesquisa", sessao
						.getAttribute("tipoPesquisa"));

		return retorno;
	}

}
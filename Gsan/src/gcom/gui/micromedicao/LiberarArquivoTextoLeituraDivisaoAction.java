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
package gcom.gui.micromedicao;

import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.micromedicao.ArquivoTextoRoteiroEmpresaDivisao;
import gcom.micromedicao.SituacaoTransmissaoLeitura;
import gcom.util.Util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * UC1027 - Exibir Consultar Arquivo Texto Leitura Divis�o.
 *  
 * @author Hugo Leonardo
 * @created 08/06/2010
 *  
 * 
 */
public class LiberarArquivoTextoLeituraDivisaoAction extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		// Seta o retorno
		ActionForward retorno = actionMapping.findForward("telaSucesso");

		// Obt�m a inst�ncia da fachada
		Fachada fachada = Fachada.getInstancia();
		
		Integer situacaoNova = null;	
		String descricaoSituacaoNova = "";

		HttpSession sessao = this.getSessao(httpServletRequest);     
	
		ConsultarArquivoTextoLeituraDivisaoPopupActionForm consultarArquivoTextoLeituraDivisaoPopupActionForm = 
			(ConsultarArquivoTextoLeituraDivisaoPopupActionForm) actionForm;

		// Saber se vai liberar ou nao liberar
		String liberar = (String) httpServletRequest.getParameter("liberar");
		if (consultarArquivoTextoLeituraDivisaoPopupActionForm.getIdsRegistros() != null) {
			Vector<Integer> v = new Vector<Integer>();
			for (int i = 0; i < consultarArquivoTextoLeituraDivisaoPopupActionForm
					.getIdsRegistros().length; i++) {
				v.add(new Integer(consultarArquivoTextoLeituraDivisaoPopupActionForm
						.getIdsRegistros()[i]));

			}
			
			if(liberar == null){
				liberar = (String) sessao.getAttribute("liberar");
			}
			
			if ( liberar.equals( SituacaoTransmissaoLeitura.LIBERADO+ "" ) ){
				situacaoNova = SituacaoTransmissaoLeitura.LIBERADO;
				descricaoSituacaoNova = "LIBERADO";				
			} else if ( liberar.equals( SituacaoTransmissaoLeitura.EM_CAMPO+ "" ) ){
				situacaoNova = SituacaoTransmissaoLeitura.EM_CAMPO;
				descricaoSituacaoNova = "EM CAMPO";
			} else if ( liberar.equals( SituacaoTransmissaoLeitura.DISPONIVEL+"" ) ){
				situacaoNova = SituacaoTransmissaoLeitura.DISPONIVEL;
				descricaoSituacaoNova = "DISPON�VEL";				
			} else if ( liberar.equals( SituacaoTransmissaoLeitura.FINALIZADO_USUARIO+ "" ) ){
				situacaoNova = SituacaoTransmissaoLeitura.FINALIZADO_USUARIO;
				descricaoSituacaoNova = "FINALIZADO PELO USU�RIO";				
			}
			
			Collection colecaoArquivoTextoRoteiroEmpresaDivisao = (Collection) sessao.getAttribute("colecaoArquivoTextoRoteiroEmpresaDivisao");
			
			fachada.atualizarListaArquivoTextoDivisao(v, situacaoNova,colecaoArquivoTextoRoteiroEmpresaDivisao);
		}
		
		montarPaginaSucesso(httpServletRequest,
				"Arquivo Texto para Leitura Divis�o Alterado para " + descricaoSituacaoNova.toLowerCase() + " com sucesso.",
				"Realizar outra Manuten��o de Arquivo Texto para Leitura Divis�o",
				"exibirConsultarArquivoTextoLeituraDivisaoPopupAction.do");

		consultarArquivoTextoLeituraDivisaoPopupActionForm.setIdsRegistros(null);

		return retorno;
	}

}

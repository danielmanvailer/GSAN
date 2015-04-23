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
 * Yara Taciane de Souza
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

package gsan.micromedicao;

import gsan.cadastro.imovel.Imovel;
import gsan.micromedicao.leitura.LeituraAnormalidade;
import gsan.seguranca.acesso.usuario.Usuario;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class ReleituraMobile implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer indicadorReleitura;
	
	private Integer anoMesReferencia;
	
	private Integer indicadorMensagemRecebida;
	
	private Date ultimaAlteracao;
	
	private Usuario usuario;
	
	private Imovel imovel;
	
	private Integer leituraAtualAgua;	
	private Integer leituraAnteriorAgua;
	private Integer leituraAtualPoco;	
	private Integer leituraAnteriorPoco;	
	
	private LeituraAnormalidade leituraAnormalidadeAnteriorAgua;	
	private LeituraAnormalidade leituraAnormalidadeAtualAgua;
	private LeituraAnormalidade leituraAnormalidadeAnteriorPoco;	
	private LeituraAnormalidade leituraAnormalidadeAtualPoco;
	

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Integer getIndicadorMensagemRecebida() {
		return indicadorMensagemRecebida;
	}

	public void setIndicadorMensagemRecebida(Integer indicadorMensagemRecebida) {
		this.indicadorMensagemRecebida = indicadorMensagemRecebida;
	}

	public Integer getIndicadorReleitura() {
		return indicadorReleitura;
	}

	public void setIndicadorReleitura(Integer indicadorReleitura) {
		this.indicadorReleitura = indicadorReleitura;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LeituraAnormalidade getLeituraAnormalidadeAnteriorAgua() {
		return leituraAnormalidadeAnteriorAgua;
	}

	public void setLeituraAnormalidadeAnteriorAgua(
			LeituraAnormalidade leituraAnormalidadeAnteriorAgua) {
		this.leituraAnormalidadeAnteriorAgua = leituraAnormalidadeAnteriorAgua;
	}

	public LeituraAnormalidade getLeituraAnormalidadeAnteriorPoco() {
		return leituraAnormalidadeAnteriorPoco;
	}

	public void setLeituraAnormalidadeAnteriorPoco(
			LeituraAnormalidade leituraAnormalidadeAnteriorPoco) {
		this.leituraAnormalidadeAnteriorPoco = leituraAnormalidadeAnteriorPoco;
	}

	public LeituraAnormalidade getLeituraAnormalidadeAtualAgua() {
		return leituraAnormalidadeAtualAgua;
	}

	public void setLeituraAnormalidadeAtualAgua(
			LeituraAnormalidade leituraAnormalidadeAtualAgua) {
		this.leituraAnormalidadeAtualAgua = leituraAnormalidadeAtualAgua;
	}

	public LeituraAnormalidade getLeituraAnormalidadeAtualPoco() {
		return leituraAnormalidadeAtualPoco;
	}

	public void setLeituraAnormalidadeAtualPoco(
			LeituraAnormalidade leituraAnormalidadeAtualPoco) {
		this.leituraAnormalidadeAtualPoco = leituraAnormalidadeAtualPoco;
	}

	public Integer getLeituraAnteriorAgua() {
		return leituraAnteriorAgua;
	}

	public void setLeituraAnteriorAgua(Integer leituraAnteriorAgua) {
		this.leituraAnteriorAgua = leituraAnteriorAgua;
	}

	public Integer getLeituraAnteriorPoco() {
		return leituraAnteriorPoco;
	}

	public void setLeituraAnteriorPoco(Integer leituraAnteriorPoco) {
		this.leituraAnteriorPoco = leituraAnteriorPoco;
	}

	public Integer getLeituraAtualAgua() {
		return leituraAtualAgua;
	}

	public void setLeituraAtualAgua(Integer leituraAtualAgua) {
		this.leituraAtualAgua = leituraAtualAgua;
	}

	public Integer getLeituraAtualPoco() {
		return leituraAtualPoco;
	}

	public void setLeituraAtualPoco(Integer leituraAtualPoco) {
		this.leituraAtualPoco = leituraAtualPoco;
	}	
}
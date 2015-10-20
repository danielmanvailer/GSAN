/** Copyright (C) 2007-2007 the GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento** This file is part of GSAN, an integrated service management system for Sanitation** GSAN is free software; you can redistribute it and/or modify* it under the terms of the GNU General Public License as published by* the Free Software Foundation; either version 2 of the License.** GSAN is distributed in the hope that it will be useful,* but WITHOUT ANY WARRANTY; without even the implied warranty of* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the* GNU General Public License for more details.** You should have received a copy of the GNU General Public License* along with this program; if not, write to the Free Software* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA*//** GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento* Copyright (C) <2007> * Adriano Britto Siqueira* Alexandre Santos Cabral* Ana Carolina Alves Breda* Ana Maria Andrade Cavalcante* Aryed Lins de Ara�jo* Bruno Leonardo Rodrigues Barros* Carlos Elmano Rodrigues Ferreira* Cl�udio de Andrade Lira* Denys Guimar�es Guenes Tavares* Eduardo Breckenfeld da Rosa Borges* Fab�ola Gomes de Ara�jo* Fl�vio Leonardo Cavalcanti Cordeiro* Francisco do Nascimento J�nior* Homero Sampaio Cavalcanti* Ivan S�rgio da Silva J�nior* Jos� Edmar de Siqueira* Jos� Thiago Ten�rio Lopes* K�ssia Regina Silvestre de Albuquerque* Leonardo Luiz Vieira da Silva* M�rcio Roberto Batista da Silva* Maria de F�tima Sampaio Leite* Micaela Maria Coelho de Ara�jo* Nelson Mendon�a de Carvalho* Newton Morais e Silva* Pedro Alexandre Santos da Silva Filho* Rafael Corr�a Lima e Silva* Rafael Francisco Pinto* Rafael Koury Monteiro* Rafael Palermo de Ara�jo* Raphael Veras Rossiter* Roberto Sobreira Barbalho* Rodrigo Avellar Silveira* Rosana Carvalho Barbosa* S�vio Luiz de Andrade Cavalcante* Tai Mu Shih* Thiago Augusto Souza do Nascimento* Tiago Moreno Rodrigues* Vivianne Barbosa Sousa** Este programa � software livre; voc� pode redistribu�-lo e/ou* modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme* publicada pela Free Software Foundation; vers�o 2 da* Licen�a.* Este programa � distribu�do na expectativa de ser �til, mas SEM* QUALQUER GARANTIA; sem mesmo a garantia impl�cita de* COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM* PARTICULAR. Consulte a Licen�a P�blica Geral GNU para obter mais* detalhes.* Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU* junto com este programa; se n�o, escreva para Free Software* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA* 02111-1307, USA.*/  package gcom.faturamento.debito;import gcom.cobranca.FiltroResolucaoDiretoria;import gcom.financeiro.FinanciamentoTipo;import gcom.financeiro.lancamento.LancamentoItemContabil;import gcom.interceptor.ControleAlteracao;import gcom.interceptor.ObjetoTransacao;import gcom.util.filtro.Filtro;import gcom.util.filtro.ParametroSimples;import java.math.BigDecimal;import java.util.Date;import org.apache.commons.lang.builder.ToStringBuilder;/** @author Hibernate CodeGenerator */@ControleAlteracao()public class DebitoTipo extends ObjetoTransacao {	private static final long serialVersionUID = 1L;	//Constantes tipo de d�bito >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     public final static Integer TAXA_COBRANCA = new Integer(17);    public final static Integer ENTRADA_PARCELAMENTO = new Integer(33);    public final static Integer DESPESA_POSTAL = new Integer(97);    public final static Integer ATUALIZACAO_MONETARIA = new Integer(94);    public final static Integer JUROS_MORA = new Integer(91);    public final static Integer MULTA_IMPONTUALIDADE = new Integer(80);    public final static Integer PARCELAMENTO_CONTAS = new Integer(40);    public final static Integer PARCELAMENTO_GUIAS_PAGAMENTO = new Integer(41);    public final static Integer PARCELAMENTO_ACRESCIMOS_IMPONTUALIDADE = new Integer(43);    public final static Integer PARCELAMENTO_DEBITO_A_COBRAR_CURTO_PRAZO = new Integer(45);    public final static Integer PARCELAMENTO_DEBITO_A_COBRAR_LONGO_PRAZO = new Integer(47);    public final static Integer REPARCELAMENTOS_CURTO_PRAZO = new Integer(42);    public final static Integer REPARCELAMENTOS_LONGO_PRAZO = new Integer(50);    public final static Integer JUROS_SOBRE_PARCELAMENTO = new Integer(44);    public final static Integer OUTROS = new Integer(99);    public final static Integer ACRESCIMOS_POR_IMPONTUALIDADE = new Integer(100);    public final static Integer TAXA_2_VIA_CONTA = new Integer(101);    public final static Integer CODIGO_CONSTANTE_DEBITO_AJUSTE_VALOR_PAGAMENTO_MAIOR = new Integer(55);    public final static Integer SANCOES_REGULAMENTARES = new Integer(12);    public final static Integer MULTA_POR_INFRACAO = new Integer(46);    public final static Integer CONSUMO_NAO_CONTABILIZADO = new Integer(48);    public final static Integer INSTAL_SUBST_HIDROMETRO = new Integer(49);        public final static Integer SERVICOS_ESPECIAIS = new Integer(15);        public final static Integer DOACAO_AO_PRO_CRIANCA = new Integer(104);        public final static Integer PARCELAMENTO_CONTAS_DIVIDA_ATIVA = new Integer(240);        public final static Integer PARCELAMENTO_GUIAS_PAGAMENTO_DIVIDA_ATIVA = new Integer(241);    public final static Integer PARCELAMENTO_ACRESCIMOS_IMPONTUALIDADE_DIVIDA_ATIVA = new Integer(143);    public final static Integer REPARCELAMENTOS_CURTO_PRAZO_DIVIDA_ATIVA = new Integer(242);    public final static Integer REPARCELAMENTOS_LONGO_PRAZO_DIVIDA_ATIVA = new Integer(250);    public final static Integer JUROS_SOBRE_PARCELAMENTO_DIVIDA_ATIVA = new Integer(144);        public final static Integer PAGAMENTO_PARCIAL_CONTA = new Integer(409);        public final static Integer DOACAO_AO_HOSPITAL_INFANTIL_VARELA_SANTIAGO = new Integer(202);        public final static Integer GUIA_DE_PAGAMENTO_NAO_ENCONTRADA = new Integer(8888);        public final static int DOACAO = 1;        public final static Integer MOVIMENTO_CARTAO_CREDITO = new Integer(2408);        public final static Integer CONSTANTE_TAXA_2_VIA_CONTA = new Integer(22);        public final static Integer TARIFA_CORTADO = new Integer(2500);        public final static Integer JUROS_SOBRE_CONTR_PARCELAMENTO = new Integer(115);        public final static Integer DOCUMENTO_NAO_ACEITO = new Integer(116);        public final static Integer EXTORNO_CREDITO_CONTRATO_DEMANDA = new Integer(117);        public final static Integer MULTA_INFRACAO = new Integer(205);        public final static Integer CONSUMO_FRAUDADO = new Integer(206);    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>			/** identifier field */	private Integer id;	/** persistent field */	private LancamentoItemContabil lancamentoItemContabil;	/** nullable persistent field */	private String descricao;	/** nullable persistent field */	private String descricaoAbreviada;	/** nullable persistent field */	private Short indicadorUso;	/** nullable persistent field */	private Date ultimaAlteracao;	/** nullable persistent field */	private BigDecimal valorLimite;	/** nullable persistent field */	private Short indicadorGeracaoAutomatica;	/** nullable persistent field */	private Short indicadorGeracaoConta;	private BigDecimal valorSugerido;		private BigDecimal valorLimiteInferior;		private Integer codigoConstante;	/** persistent field */	private FinanciamentoTipo financiamentoTipo;		/** nullable persistent field */	private Short indicadorDebitoCartaoCredito;			private Short indicadorJurosParCliente;		private Short indicadorDividaAtiva;		public String[] retornaCamposChavePrimaria(){		String[] retorno = new String[1];		retorno[0] = "id";		return retorno;	}	public Filtro retornaFiltro(){		FiltroDebitoTipo filtroDebitoTipo = new FiltroDebitoTipo();		filtroDebitoTipo.adicionarCaminhoParaCarregamentoEntidade("lancamentoItemContabil");		filtroDebitoTipo.adicionarCaminhoParaCarregamentoEntidade("financiamentoTipo");		filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroResolucaoDiretoria.CODIGO,				this.getId()));		return filtroDebitoTipo;	}		/** full constructor */	public DebitoTipo(LancamentoItemContabil lancamentoItemContabil,			String descricao, String descricaoAbreviada, Short indicadorUso,			Date ultimaAlteracao, BigDecimal valorLimite,			Short indicadorGeracaoAutomatica,			FinanciamentoTipo financiamentoTipo) {		this.lancamentoItemContabil = lancamentoItemContabil;		this.descricao = descricao;		this.descricaoAbreviada = descricaoAbreviada;		this.indicadorUso = indicadorUso;		this.ultimaAlteracao = ultimaAlteracao;		this.valorLimite = valorLimite;		this.indicadorGeracaoAutomatica = indicadorGeracaoAutomatica;		this.financiamentoTipo = financiamentoTipo;	}	/** default constructor */	public DebitoTipo() {	}	/** minimal constructor */	public DebitoTipo(LancamentoItemContabil lancamentoItemContabil,			FinanciamentoTipo financiamentoTipo) {		this.lancamentoItemContabil = lancamentoItemContabil;		this.financiamentoTipo = financiamentoTipo;	}			/**	 * [UC0745] - Gerar Arquivo Texto para Faturamento	 * 	 * Construtor de DebitoTipo 	 * 	 * @param id	 * @param descricao	 */	public DebitoTipo(Integer id, String descricao) {		this.id = id;		this.descricao = descricao;	}	public Integer getId() {		return this.id;	}	public void setId(Integer id) {		this.id = id;	}	public LancamentoItemContabil getLancamentoItemContabil() {		return this.lancamentoItemContabil;	}	public void setLancamentoItemContabil(			LancamentoItemContabil lancamentoItemContabil) {		this.lancamentoItemContabil = lancamentoItemContabil;	}	public String getDescricao() {		return this.descricao;	}	public void setDescricao(String descricao) {		this.descricao = descricao;	}	public String getDescricaoAbreviada() {		return this.descricaoAbreviada;	}	public void setDescricaoAbreviada(String descricaoAbreviada) {		this.descricaoAbreviada = descricaoAbreviada;	}	public Short getIndicadorUso() {		return this.indicadorUso;	}	public void setIndicadorUso(Short indicadorUso) {		this.indicadorUso = indicadorUso;	}	public Date getUltimaAlteracao() {		return this.ultimaAlteracao;	}	public void setUltimaAlteracao(Date ultimaAlteracao) {		this.ultimaAlteracao = ultimaAlteracao;	}	public BigDecimal getValorLimite() {		return this.valorLimite;	}	public void setValorLimite(BigDecimal valorLimite) {		this.valorLimite = valorLimite;	}	public Short getIndicadorGeracaoAutomatica() {		return this.indicadorGeracaoAutomatica;	}	public void setIndicadorGeracaoAutomatica(Short indicadorGeracaoAutomatica) {		this.indicadorGeracaoAutomatica = indicadorGeracaoAutomatica;	}	public FinanciamentoTipo getFinanciamentoTipo() {		return this.financiamentoTipo;	}	public void setFinanciamentoTipo(FinanciamentoTipo financiamentoTipo) {		this.financiamentoTipo = financiamentoTipo;	}	public String toString() {		return new ToStringBuilder(this).append("id", getId()).toString();	}	/**	 * @return Retorna o campo indicadorGeracaoConta.	 */	public Short getIndicadorGeracaoConta() {		return indicadorGeracaoConta;	}	/**	 * @param indicadorGeracaoConta O indicadorGeracaoConta a ser setado.	 */	public void setIndicadorGeracaoConta(Short indicadorGeracaoConta) {		this.indicadorGeracaoConta = indicadorGeracaoConta;	}    /**     * Description of the Method     *      * @param other     *            Description of the Parameter     * @return Description of the Return Value     */	@Override    public boolean equals(Object other) {    	boolean retorno = false;				if (other instanceof DebitoTipo) {						DebitoTipo castOther = (DebitoTipo) other;						retorno = this.getId().compareTo(castOther.getId())==0;		}				return retorno;    }        @Override    public void initializeLazy() {    	this.retornaCamposChavePrimaria();    	getDescricao();    }        @Override    public String getDescricaoParaRegistroTransacao() {    	return getDescricao();    }	/**	 * @return Retorna o campo valorSugerido.	 */	public BigDecimal getValorSugerido() {		return valorSugerido;	}	/**	 * @param valorSugerido O valorSugerido a ser setado.	 */	public void setValorSugerido(BigDecimal valorSugerido) {		this.valorSugerido = valorSugerido;	}	public BigDecimal getValorLimiteInferior() {		return valorLimiteInferior;	}	public void setValorLimiteInferior(BigDecimal valorLimiteInferior) {		this.valorLimiteInferior = valorLimiteInferior;	}	public Integer getCodigoConstante() {		return codigoConstante;	}	public void setCodigoConstante(Integer codigoConstante) {		this.codigoConstante = codigoConstante;	}	public Short getIndicadorDebitoCartaoCredito() {		return indicadorDebitoCartaoCredito;	}	public void setIndicadorDebitoCartaoCredito(Short indicadorDebitoCartaoCredito) {		this.indicadorDebitoCartaoCredito = indicadorDebitoCartaoCredito;	}		public Short getIndicadorJurosParCliente() {		return indicadorJurosParCliente;	}	public void setIndicadorJurosParCliente(Short indicadorJurosParCliente) {		this.indicadorJurosParCliente = indicadorJurosParCliente;	}		public Short getIndicadorDividaAtiva() {		return indicadorDividaAtiva;	}	public void setIndicadorDividaAtiva(Short indicadorDividaAtiva) {		this.indicadorDividaAtiva = indicadorDividaAtiva;	}	@Override	public int hashCode() {		return this.getId();	}}
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<%@page import="gsan.arrecadacao.pagamento.Pagamento"%>
<%@page import="gsan.arrecadacao.pagamento.PagamentoHistorico"%>
<%@page import="gsan.cadastro.cliente.ClienteImovel"%>
<%@page import="gsan.util.Util" isELIgnored="false"%>
<%@ page import="gsan.util.ConstantesSistema" isELIgnored="false"%>

<html:html>
	<head>
		<title>Caema | Servi&ccedil;os</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<script language="JavaScript" src="<bean:message key="caminho.portal.js"/>jquery-1.4.2.min.js"></script>
		<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
		<link rel="stylesheet" href="<bean:message key="caminho.portalcaema.css"/>style.css" type="text/css">
		<link rel="stylesheet" href="<bean:message key="caminho.portalcaema.css"/>internal.css" type="text/css">
	<style type="text/css">
				
			.lista li {
				list-style: url("/gsan/imagens/portal/caema/general/marcador.gif");
				margin: 0 0 0 15px;
				padding: 0px;
			}
			
			em {
    			color: #008FD6;
    			font-style: normal;
   				font-weight: 700;
    			padding-right: 5px;
			}
			font {
   				color: #008FD6;
    			float: none;
   				margin: 0;
    			padding-bottom: 10px;
    			text-indent: 0;
				font-style:italic;
    			float: right;
    		}
    		.paragrafo {
    			line-height: 30px;
    		}    		
    		p{
    		text-align: justify;
    		}
			#atualizacao{
    			line-height:2.3em;
    			padding:0 15px; 
    			position:relative;    			
    			float:left; 
    			font-size:11px;
    			height:33px;
    			width: 315px;  	
    		}
    		
    		<logic:present name="arquivoNaoEncontrado" scope="request">
			<script type="text/javascript">
				$(document).ready(function(){
					showMessage('O arquivo n�o foi encontrado.');
				});
			</script>
		</logic:present>
    					
		</style>
	</head>
<body onload="setarFoco('${requestScope.nomeCampo}');">
		<div id="container">
	    	<%@ include file="/jsp/portal/caema/cabecalho.jsp"%>
	        
	        <!-- Content - Start -->
		        <div id="content">
				<%@ include file="/jsp/portal/caema/cabecalhoImovel.jsp"%>
		        	<div id="consultarPagamentoImovel" class="serv-int" style="width:880px;">	
	    	    			
							<p>&nbsp;</p>
							<h3>
								Consultar Pagamentos<span>&nbsp;</span>
							</h3>
							<br />
							<br />
							<p>&nbsp;</p>
							
							<table summary="Consultar Pagamentos" style="margin-top: 0px">
								<%int cont = 0;%>
								<tr>
									<td colspan="4">
									<table summary="Consultar Pagamentos">
										<thead>
					                    	<tr>
					                        	<th width="25%">M&ecirc;s&#47;Ano</th>
					                            <th width="25%">Valor</th>
					                            <th width="25%">Data Pagamento</th>
					                            <th width="25%">Arrecadador</th>
					                        </tr>
					                    </thead>

										<logic:notEmpty name="colecaoPagamentosImovelConta" scope="request">
												
											<tbody>
												<logic:iterate name="colecaoPagamentosImovelConta" type="Pagamento" 
													id="pagamento">
													 <%cont = cont + 1;
													if (cont % 2 == 0) {%>
													<tr class="tr-2" id="tr-2-2">
													<%} else {%>
													<tr class="tr-1" id="tr-1-2">
													<%}%>
														<td width="25%" style="border-right: 1px solid #C8C8C8;">
												           <bean:write name="pagamento" property="formatarAnoMesPagamentoParaMesAno" />
														</td>
														<td width="25%">
															<bean:write name="pagamento" property="valorPagamento"
																formatKey="money.format" />
														</td>
														<td width="25%">
												           <bean:write name="pagamento" property="dataPagamento" 
												           		 formatKey="date.format"/>
														</td>
														<td width="25%">
															<bean:write name="pagamento" property="avisoBancario.arrecadador.cliente.nome" />
														</td>
													</tr>
												</logic:iterate>
											</tbody>										
										</logic:notEmpty>
										
										<logic:notEmpty name="colecaoPagamentosHistoricoImovelConta" scope="request">
											<tbody>
												<logic:iterate name="colecaoPagamentosHistoricoImovelConta" type="PagamentoHistorico" 
													id="pagamentoHistorico">
													 <%cont = cont + 1;
													if (cont % 2 == 0) {%>
													<tr class="tr-2" id="tr-2-2">
													<%} else {%>
													<tr class="tr-1" id="tr-1-2">
													<%}%>
														<td width="25%" style="border-right: 1px solid #C8C8C8;">
												           <bean:write name="pagamentoHistorico" property="formatarAnoMesReferenciaPagamento" />
														</td>
														<td width="25%">
															<bean:write name="pagamentoHistorico" property="valorPagamento"
																formatKey="money.format" />
														</td>
														<td width="25%">
												           <bean:write name="pagamentoHistorico" property="dataPagamento" 
												           		 formatKey="date.format"/>
														</td>
														<td width="25%">
															<bean:write name="pagamentoHistorico" property="avisoBancario.arrecadador.cliente.nome" />
														</td>
													</tr>
												</logic:iterate>
											</tbody>										
										</logic:notEmpty>
									</table>
									</td>
								</tr>
							</table>
							
							
							             
		       	</div><!-- negociadebitos - End -->
	       </div><!-- Content - End -->
	    	 <%@ include file="/jsp/portal/caema/rodape.jsp"%>
	  	</div><!-- Container - End -->       
	</body>
</html:html>
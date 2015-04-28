<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/gsanLib.tld" prefix="gsan" %>

<%@ page import="gsan.util.Util" %>
<%@ page import="gsan.util.ConstantesSistema"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<%@ include file="/jsp/util/titulo.jsp"%>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet"
	href="<bean:message key="caminho.css"/>EstilosCompesa.css"
	type="text/css">
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
		<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script><html:javascript staticJavascript="false"  formName="FiltrarPerfilParcelamentoActionForm" />
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>validacao/ManutencaoRegistro.js"></script>
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>Calendario.js"></script>
<script language="JavaScript">


	function verificarChecado(valor){
		form = document.forms[0];
		if(valor == "1"){
		 	form.indicadorAtualizar.checked = true;
		 }else{
		 	form.indicadorAtualizar.checked = false;
		}
	
		
	}
	
	
	function limpar(){
		form = document.forms[0];
		
		form.idNegativador.value = "-1";
		form.codigoRegistro.value = "";
		form.descricaoRegistroTipo.value = "";		
	}
	
	

</script>
</head>
<body leftmargin="0" topmargin="0"
onload="setarFoco('${requestScope.nomeCampo}');verificarChecado('${sessionScope.indicadorAtualizar}');">
<html:form action="/filtrarNegativadorRegistroTipoAction"
	name="FiltrarNegativadorRegistroTipoActionForm"
	type="gsan.gui.cobranca.spcserasa.FiltrarNegativadorRegistroTipoActionForm"
	method="post"
	onsubmit="return validateFiltrarNegativadorRegistroTipoActionForm(this);">


<%@ include file="/jsp/util/cabecalho.jsp"%>
<%@ include file="/jsp/util/menu.jsp" %>


<table width="770" border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td width="120" valign="top" class="leftcoltext">
			<div align="center">
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<%@ include file="/jsp/util/informacoes_usuario.jsp"%>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<%@ include file="/jsp/util/mensagens.jsp"%>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
				<p align="left">&nbsp;</p>
			</div>
		</td>
		<td valign="top" class="centercoltext">
            <table>
              <tr><td></td></tr>
              
            </table>
         
        
          <!--In�cio Tabela Reference a P�gina��o da Tela de Processo-->
            <table>
              <tr>
                <td></td>
              </tr>
            </table>
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img border="0" src="imagens/parahead_left.gif"/></td>
                <td class="parabg">Filtrar Tipo do Registro do Negativador </td>
                <td width="11" valign="top"><img border="0" src="imagens/parahead_right.gif"/></td>
              </tr>
            </table>
            <!--Fim Tabela Reference a P�gina��o da Tela de Processo-->
<p>&nbsp;</p>
            <table width="100%" border="0" >
              <tr> 
                <td colspan="2">Para filtrar o(s) tipo(s) do registro do negativador, informe 
                  os dados abaixo:</td>
                <td width="79"><input type="checkbox" name="indicadorAtualizar" value="1" />  
                <strong>Atualizar</strong></td>
              </tr>
              <tr>              </tr>
			  <tr>
                <td width="132"><strong>Negativador:<font color="#FF0000">*</strong></td>
                <td width="396">
                 <logic:present name="colecaoNegativador">  
                   	   <html:select property="idNegativador" tabindex="7">
						<html:option value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;</html:option>
							<logic:present name="colecaoNegativador">
								<html:options collection="colecaoNegativador" labelProperty="cliente.nome" property="id"/>
							</logic:present>
						</html:select>
                		</logic:present>  </td>
              </tr>
			  <tr>
                <td width="132"><strong>C�digo doTipo do Registro:</strong></td>
                <td width="396"><html:text property="codigoRegistro" size="3" maxlength="1"/></td>
              </tr>
              <tr>
                <td><strong>Descri&ccedil;&atilde;o do Tipo do Registro: </strong></td>
                <td colspan="2"><strong>
                  <html:text property="descricaoRegistroTipo" size="65" maxlength="60"/>
                </strong></td>
              </tr>
               
             
              <tr> 
               <tr> 
                
             
                <td><div align="left"><strong><font color="#FF0000">
                   <input name="button" type="button" class="bottonRightCol" value="Limpar" onclick="javascript:limpar();">
                </font></strong></div></td>
                <td colspan="2"><div align="right">
                  <input type="submit" name="Submit" class="bottonRightCol" onClick="javascript:window.location.href='../../Cobran�a/negativador_registro_tipo_manter.html'" value="Filtrar">
                </div></td>
              </tr>
            </table>
       
       
       
              
			<p>&nbsp;</p>
			</td>

		</tr>
	</table>
<%@ include file="/jsp/util/rodape.jsp"%>
</html:form>
</body>
</html:html>

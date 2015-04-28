<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/gsanLib.tld" prefix="gsan" %>

<%@page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>

<%@ include file="/jsp/util/titulo.jsp"%>
<link rel="stylesheet"
	href="<bean:message key="caminho.css"/>EstilosCompesa.css"
	type="text/css">
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script><html:javascript staticJavascript="false"  formName="RegistrarMovimentoArredadadoresAction" />	
<script language="JavaScript">
<!--

var bCancel = false; 

function validateAtualizarAvisoBancarioAction(form) 
{
   if (bCancel) {
      return true; 
   }else 
   {
      return validateCaracterEspecial(form) && validateLong(form);
   }
}
 
function caracteresespeciais () { 
   this.aa = new Array("idArrecadador", "Arrecadador possui caracteres especiais.", new Function ("varName", " return this[varName];"));
   this.ab = new Array("idTipoMovimento", "Tipo Movimento possui caracteres especiais.", new Function ("varName", " return this[varName];"));
}

function IntegerValidations () {
   this.aa = new Array("idArrecadador", "Arrecadador deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
}
function recuperarDadosPopup(codigoRegistro, descricaoRegistro, tipoConsulta) {

    var form = document.forms[0];

    if (tipoConsulta == 'arrecadador') {
      form.idArrecadador.value = codigoRegistro;
      form.nomeArrecadador.value = descricaoRegistro;
      form.nomeArrecadador.style.color = "#000000";

    }
  }

function validarForm(){
   var form = document.forms[0];
   var mensagem = '';
   if(form.idArrecadador.value != '' && form.idTipoMovimento.value != '' && form.uploadPicture.value != '')
   {
	  if (validateAtualizarAvisoBancarioAction(form)){
  	 	if(confirm('Confirma registrar movimento dos arrecadadores?')){
    	   document.forms[0].submit();
	   	}
	  }
   }else{
      if(form.idArrecadador.value == ''){
	       mensagem = mensagem + 'Informe Arrecadador.';
	  }
	  if(form.idTipoMovimento.value == ''){
	     mensagem = mensagem + '\n Informe Tipo do Movimento.';
	  }
	  if(form.uploadPicture.value == ''){
	     mensagem = mensagem + '\n Informe Nome do Arquivo.';
	  }
	  alert(mensagem);
   }
}
function limparPesquisaArrecadador(form) {
    form.idArrecadador.value = "";
    form.nomeArrecadador.value = "";
    form.idTipoMovimento.value = "";
    form.uploadPicture.value = "";
}

-->
</script>

</head>
<body leftmargin="5" topmargin="5"
	onload="javascript:setarFoco('${requestScope.nomeCampo}');">
<form action="/gsan/registrarMovimentoArredadadoresAction.do"
	method="post" enctype="multipart/form-data"><%@ include
	file="/jsp/util/cabecalho.jsp"%> <%@ include file="/jsp/util/menu.jsp"%>

<table width="770" border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td width="115" valign="top" class="leftcoltext">
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
			<tr>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="11"><img border="0"
					src="<bean:message key="caminho.imagens"/>parahead_left.gif" /></td>
				<td class="parabg">Registrar Movimento dos Arrecadadores</td>
				<td width="11" valign="top"><img border="0"
					src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
			</tr>
		</table>

		<p>&nbsp;</p>
		<table width="100%" border="0">
			<tr>
				<td colspan="2">Para registrar movimento de arrecadador, informe os
				dados abaixo:</td>
			</tr>
			<tr>
				<td><strong>Arrecadador:<font color="#FF0000">*</font></strong></td>
				<td><input type="text" maxlength="3" name="idArrecadador" size="4"
					onkeypress="validaEnterComMensagem(event, 'exibirRegistrarMovimentoArredadadoresAction.do?objetoConsulta=1', 'idArrecadador','Arrecadador');"
					value="${requestScope.parametroidArrecadador}"> <a
					href="javascript:abrirPopup('exibirPesquisarArrecadadorAction.do');">
				<img width="23" height="21" border="0"
					src="<bean:message key="caminho.imagens"/>pesquisa.gif"
					title="Pesquisar Arrecadador" /></a> <logic:present
					name="idArrecadadorNaoEncontrado">
					<logic:equal name="idArrecadadorNaoEncontrado" value="exception">
						<input type="text" name="nomeArrecadador" size="40" maxlength="30"
							readonly="true" value="${requestScope.parametroNomeArrecadador}"
							style="background-color:#EFEFEF; border:0; color: #ff0000">
					</logic:equal>
					<logic:notEqual name="idArrecadadorNaoEncontrado" value="exception">
						<input type="text" name="nomeArrecadador" size="40" maxlength="30"
							readonly="true" value="${requestScope.parametroNomeArrecadador}"
							style="background-color:#EFEFEF; border:0; color: #000000">
					</logic:notEqual>
				</logic:present> <logic:notPresent name="idArrecadadorNaoEncontrado">
					<input type="text" name="nomeArrecadador" size="40" maxlength="30"
						readonly="true" value=""
						style="background-color:#EFEFEF; border:0; color: #ff0000">

				</logic:notPresent> <a
					href="javascript:limparPesquisaArrecadador(document.forms[0]);"> <img
					src="<bean:message key="caminho.imagens"/>limparcampo.gif"
					border="0" title="Apagar" /></a></td>

			</tr>

			<tr>
				<td><strong>Tipo Movimento:<font color="#FF0000">*</font></strong></td>
				<td><select name="idTipoMovimento">
					<option value="">&nbsp;</option>
					<c:forEach items="${sessionScope.tiposMovimentos}"
						var="tipoMovimento">
						<option value="${tipoMovimento}">${tipoMovimento}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><strong>Nome Arquivo:<font color="#FF0000">*</font></strong></td>
				<td><input type="file" style="textbox" name="uploadPicture"
					size="50" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left"><font color="#FF0000">*</font> Campo
				Obrigat&oacute;rio</td>
			</tr>
		</table>

		<table width="100%">
			<tr>
				<td align="left"><input name="Button" type="button" class="bottonRightCol"
						value="Desfazer" align="left"
						onclick="window.location.href='<html:rewrite page="/exibirRegistrarMovimentoArredadadoresAction.do?menu=sim"/>'">
						&nbsp;<input type="button"
						name="ButtonCancelar" class="bottonRightCol" value="Cancelar"
						onClick="javascript:window.location.href='/gsan/telaPrincipal.do'"></td>
				<td align="right">
				  <gsan:controleAcessoBotao name="Button" value="Registrar" onclick="javascript:validarForm();" url="registrarMovimentoArredadadoresAction.do"/>
				  <%-- <input type="button" name="Button" class="bottonRightCol" value="Registrar" onclick="validarForm();" /> --%>
				</td>
			</tr>
		</table>
	</tr>


</table>
<%@ include file="/jsp/util/rodape.jsp"%></form>
</body>
</html:html>

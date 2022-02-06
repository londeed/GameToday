<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>var sId = readCookie('sessionId')
$("<textarea class=\"form-control\" type=\"text\" id=\"textareaMod\" aria-label=\"Disabled input example\" style=\"resize: none\" disabled readonly >").appendTo($("#prova"));
$("#textareaMod").text(sId)
</script>
<div id="prova">
</div>
   <!--<textarea class="form-control" type="text" id="#textareaMod" aria-label="Disabled input example" style="resize: none" disabled="disabled" readonly="readonly"></textarea>-->

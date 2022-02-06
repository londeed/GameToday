<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String test = (String) request.getSession().getAttribute("commentoTesto");%>
<textarea class="form-control" type="text" id="#textareaMod" aria-label="Disabled input example" style="resize: none" ><%=test%></textarea>
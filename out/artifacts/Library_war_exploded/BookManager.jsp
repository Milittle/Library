<%--
  Created by IntelliJ IDEA.
  User: 米泽双
  Date: 2015/12/13
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
  <title>图书管理系统</title>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">图书管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
            <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">图书管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="BookManager.action">
                  <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="BookAdd.jsp">添加图书</a></td>
                      <td width="72%">查询：
                        <select name="SearchRow" id="SearchRow">
                          <option value="Book_Isbn">ISBN</option>
                          <option value="Book_Name">图书名</option>
                          <option value="Book_Type">图书类型</option>
                          <option value="Book_Author">图书作者</option>
                        </select>
                        <input name="SearchKey" type="text" class="text1" id="SearchKey">
                        <input type="submit" name="button" id="button" value="点击查询"></td>
                    </tr>
                  </table>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>ISBN</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图书名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图书类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图书价格</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图书数量</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图书作者</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="l">
                    <tr align="center">
                      <td height="25" align="center">${Book_Isbn}</td>
                      <td>${Book_Name}</td>
                      <td>${Book_Type}</td>
                      <td align="center">${Book_Price}</td>
                      <td align="center">${Book_Balance}</td>
                      <td align="center">${Book_Author}</td>
                      <td align="center"><a href="BookUpdate.action?Book_ID=${Book_ID}">修改</a> <a href="BookDel.action?Book_ID=${Book_ID}" onClick="return confirm('确定要删除该图书么？')">删除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
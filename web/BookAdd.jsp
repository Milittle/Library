<%--
  Created by IntelliJ IDEA.
  User: 米泽双
  Date: 2015/12/13
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <title>图书管理系统</title>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


  function mycheck(){
    if(isNull(form1.Book_Isbn.value)){
      alert("请输入ISBN！");
      return false;
    }
    else
    {
      var t1=document.getElementById("Book_Isbn").value;
      var r=new RegExp("^([0-9])*\d*$");
      if(!r.test(t1)){
        alert('isbn输入不正确！');
        return false;
      }
    }
    if(isNull(form1.Book_Name.value)){
      alert("请输入图书名！");
      return false;
    }
    if(isNull(form1.Book_Type.value)){
      alert("请输入图书类型！");
      return false;
    }
    if(isNull(form1.Book_Balance.value)){
      alert('请输入图书数量！');
    }
    else
    {
      var t1=document.getElementById("Book_Balance").value;
      var r=new RegExp("^[0-9]\d*$");
      if(!r.test(t1)){
        alert('图书数量输入不正确！');
        return false;
      }
    }
    if(isNull(form1.Book_Price.value)){
      alert("请输入价格！");
      return false;
    }
    else
    {
      var t1=document.getElementById("Book_Price").value;
      var r=new RegExp("^[0-9]+([.0-9]{1,5})?$");
      if(!r.test(t1)){
        alert('价格格式输入不正确！');
        return false;
      }
    }
  }

  function isNull(str){
    if ( str == "" ) return true;
  }
</script>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加图书</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="BookAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>ISBN：</td>
                    <td><input name="Book_Isbn" type="text" class="text2" id="Book_Isbn"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>图书名：</td>
                    <td><input name="Book_Name" type="text" class="text2" id="Book_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>图书类型：</td>
                    <td><input name="Book_Type" type="text" class="text2" id="Book_Type"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>图书价格：</td>
                    <td><input name="Book_Price" type="text" class="text2" id="Book_Price"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>图书数量：</td>
                    <td><input name="Book_Balance" type="text" class="text2" id="Book_Balance"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>图书作者：</td>
                    <td><input name="Book_Author" type="text" class="text2" id="Book_Author"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加图书">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
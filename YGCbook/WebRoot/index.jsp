<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="cn.key.entity.BookInfo"%>
<%@page import="cn.key.entity.BookType"%>
<%@page import="cn.key.dao.BookTypeDAO"%>
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 150%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
// -->
</style>
<title>云工厂网上书店 - 西北地区首家专业网上书店</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="javascript">
	function aa() {
		window.location.href = BookInfomation.htm;
	}
</script>
</head>
		
	<jsp:include page="fgLeft.jsp"></jsp:include>
	
    <td width="3" bgcolor="#8F8F8F"><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></td>
    <%
    	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos");
		int i = 0;
		BookInfo book = null;
	%>
	
	<input type ="button"  value="新会员注册" onclick="window.location.href='userRegister.jsp'"></button>
	<input type ="button"  value="新会员搜索" onclick="window.location.href='Search.jsp'"></button>
	
    <td> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr valign="top"> 
          <td width="446"> 
            <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td> <img src="<%=request.getContextPath()%>/images/daodu37.gif" width="337" height="48" alt="广告区"></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><img src="<%=request.getContextPath()%>/images/ff.gif" width="417" height="189" alt="广告区"></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td> 
                  <h2><font color="#008B38" face="楷体_GB2312"><u>科学家传记、经典科普书…全部５折</u></font></h2>
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td background="<%=request.getContextPath()%>/images/daodu33.gif" height="32" width="14%">&nbsp;</td>
                <td background="<%=request.getContextPath()%>/images/daodu33.gif" height="32" width="86%"><img src="images/dd-m13.gif" width="90" height="32" alt="专题推荐"></td>
              </tr>
              <tr> 
                <td colspan="2"> 
                  <hr size="1">
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr valign="top"> 
                <td width="222"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td bgcolor="#CCCCCC" width="1"><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></td>
                <td width="223"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td> 
                  <hr size="1">
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr valign="top"> 
                <td width="222"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td bgcolor="#CCCCCC" width="1"><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></td>
                <td width="223"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                 </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="60" valign="top"> 
                  <div align="center"><img src="<%=request.getContextPath()%>/images/dd-008.gif" width="426" height="51" alt="广告区"></div>
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td background="<%=request.getContextPath()%>/images/daodu33.gif" height="32" width="14%">&nbsp;</td>
                <td background="<%=request.getContextPath()%>/images/daodu33.gif" height="32" width="86%"><img src="<%=request.getContextPath()%>/images/dd-m12.gif" width="90" height="32" alt="行家推荐"></td>
              </tr>
              <tr> 
                <td colspan="2"> 
                  <hr size="1">
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr valign="top"> 
                <td width="222"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td bgcolor="#CCCCCC" width="1"><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></td>
                <td width="223"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td> 
                  <hr size="1">
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr valign="top"> 
                <td width="222"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td bgcolor="#CCCCCC" width="1"><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></td>
                <td width="223"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <% book = bookInfos.get(i++); %>
                    <tr> 
                      <td class="wr4"> 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="72" height="91" border="1" align="left" vspace="5" hspace="5" alt="<%=book.getContext() %>"></a><b><font color="#C77B03">□ 
                       <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>（<%=book.getAuthor()%>著）</font></b><br>
                          定价：<%=book.getPrice() %>元<br>
                          云工厂价：<%=book.getYgcprice() %>元<br>
                          　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13"></a>　<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>">购买</a>
                        <p>　　简介：<%=book.getContext() %></p>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            
          </td>
          <td width="1" bgcolor="#005c69"> 
            <p><img src="<%=request.getContextPath()%>/images/point.gif" width="1" height="1"></p>
          </td>
          <td width="150"> 
            <table width="100%" border="0" cellspacing="0" cellpadding="3">
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td>
                        <div align="center"><img src="<%=request.getContextPath()%>/images/dd-m18.gif" width="115" height="57"></div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div align="center"><img src="<%=request.getContextPath()%>/images/dd-m20.gif" width="116" height="58" alt="淘书秀"></div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div align="center"><a href="shalong.htm"><img src="<%=request.getContextPath()%>/images/daodu21.gif" width="116" height="58" alt="文化沙龙" border="0"></a></div>
                      </td>
                    </tr>
                  </table>
                  
                </td>
              </tr>
              <tr> 
                <td bgcolor="#3AA6BF"> 
                  <div align="center"><img src="<%=request.getContextPath()%>/images/dd-m14.gif" width="83" height="22" alt="最新推荐"></div>
                </td>
              </tr>
              <tr> 
                <td class="wr4" bgcolor="#F5F2E3"> 
         <p>
         <%for(int j = 0; j < 8; j++) {
         	book = bookInfos.get(j);
         %>
        	<a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><font color="#0190AA" size="-7">■</font><%=book.getBookName() %></a><br>	 
        <%}%>
                  <p align="center">更多……</p>
                </td>
              </tr>
              <tr> 
                <td bgcolor="#3AA6BF"> 
                  <div align="center"><img src="<%=request.getContextPath()%>/images/dd-m16.gif" width="81" height="22" alt="云工厂排行"></div>
                </td>
              </tr>
              <tr> 
                <td bgcolor="#F5F2E3" class="wr4"> 
                <ol>
                  <% for(int g = 0; g < 8; g++) {
                  	book = bookInfos.get(g);%>
                    <li>
                    <a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName()%></a><br>
                    </li>
                    <%} %>
                 </ol>
                  <p align="center">更多……</p>
                </td>
              </tr>
              <tr> 
                <td bgcolor="#3AA6BF"> 
                  <div align="center"><img src="<%=request.getContextPath()%>/images/dd-m19.gif" width="143" height="23" alt="寻书公告"></div>
                </td>
              </tr>
              <tr> 
                <td bgcolor="#F5F2E3" class="wr4"> 
                  <p>　　以下图书已有，请需要的朋友下订单购买：<br>
                  </p>
                  <p>
                  <%for(int j = 0; j < 6; j++) {
		         	book = bookInfos.get(j);
		         %>
		        	<img src="<%=request.getContextPath()%>/images/<%=book.getSmallImg() %>" width="3" height="3"><%=book.getBookName()  %><br>	 
		        <%}%>　
                  <p> 　　您有什么想买而买不到的书，请在这里登记，我们将努力为您寻找。请提供尽可能多的信息。</p>
                  <form name="frmlack" method="post" action="<%=request.getContextPath()%>/SearchBookServlet" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="wr1">
                      <tr> 
                      	<td width="38%"> 
                      		<div align="right">
	                      		书名<input type=text name="bookName" size=10 class="textbox"><br>
	                      		作者<input type=text name="author" size=10 class="textbox"><br>
	                      		出版社<input type=text name="pbName" size=10 class="textbox"><br>
	                      		email<input type=text name="email" size=10 class="textbox"><br>
	                      		其他<textarea name="context" cols="10" class="textbox"></textarea><br>
	                      		<input type="submit" name="Submit" value="发出">
                      		</div>
                      	</td>
                      </tr>
                    </table>
                  </form>
                </td>
              </tr>
              <tr> 
                <td bgcolor="#F5F2E3">&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td> 
            <div align="right"><img src="<%=request.getContextPath()%>/images/daodu36.gif" width="593" height="58" alt="广告区"></div>
          </td>
        </tr>
      </table>  
      <p align="center" class="wr1"> 关于书店 | 意见箱 | 联系我们</p>
    </td>
  </tr>
</table>
<table width="770" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="22" background="<%=request.getContextPath()%>/images/dd-m09.gif">&nbsp;</td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td>&nbsp;</td>
    <td class="wr1" width="10">&nbsp;</td>
    <td class="wr1">&nbsp;</td>
  </tr>
  <tr> 
    <td><a href="http://www.qybook.com"><img src="<%=request.getContextPath()%>/images/dd-009.gif" width="36" height="40" alt="logo" border="0"></a></td>
    <td class="wr4" width="10">&nbsp;</td>
    <td class="wr4"> 版权所有：<a href="http://www.qingyun.com" target="_blank">西安云工厂科技文化图书有限责任公司</a><br>
      地址：西安市玉祥门华豪丽都　服务电话：13772086698</td>
  </tr>
</table>
</body>
</html>

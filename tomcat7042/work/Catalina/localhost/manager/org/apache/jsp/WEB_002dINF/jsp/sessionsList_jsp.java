/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2018-01-09 16:01:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Collection;
import java.util.Iterator;
import org.apache.catalina.manager.JspHelper;
import org.apache.catalina.Session;
import org.apache.catalina.ha.session.DeltaSession;
import org.apache.catalina.util.ContextName;
import org.apache.catalina.manager.DummyProxySession;

public final class sessionsList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html\r\n");
      out.write("     PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("     \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\r\n");
 String path = (String) request.getAttribute("path");
   String version = (String) request.getAttribute("version");
   ContextName cn = new ContextName(path, version);
   String submitUrl = JspHelper.escapeXml(response.encodeURL(
           ((HttpServletRequest) pageContext.getRequest()).getRequestURI() +
           "?path=" + path + "&version=" + version));
   Collection activeSessions = (Collection) request.getAttribute("activeSessions");

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=iso-8859-1\"/>\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\"/><!-- HTTP 1.0 -->\r\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache,must-revalidate\"/><!-- HTTP 1.1 -->\r\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\"/><!-- 0 is an invalid value and should be treated as 'now' -->\r\n");
      out.write("    <meta http-equiv=\"content-language\" content=\"en\"/>\r\n");
      out.write("    <meta name=\"author\" content=\"Cedrik LIME\"/>\r\n");
      out.write("    <meta name=\"copyright\" content=\"copyright 2005-2013 the Apache Software Foundation\"/>\r\n");
      out.write("    <meta name=\"robots\" content=\"noindex,nofollow,noarchive\"/>\r\n");
      out.write("    <title>Sessions Administration for ");
      out.print( JspHelper.escapeXml(cn.getDisplayName()) );
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Sessions Administration for ");
      out.print( JspHelper.escapeXml(cn.getDisplayName()) );
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("<p>Tips:</p>\r\n");
      out.write("<ul>\r\n");
      out.write("    <li>Click on a column to sort.</li>\r\n");
      out.write("    <li>To view a session details and/or remove a session attributes, click on its id.</li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("<div class=\"error\">");
      out.print( JspHelper.escapeXml(request.getAttribute("error")) );
      out.write("</div>\r\n");
      out.write("<div class=\"message\">");
      out.print( JspHelper.escapeXml(request.getAttribute("message")) );
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print( submitUrl );
      out.write("\" method=\"post\" id=\"sessionsForm\">\r\n");
      out.write("    <fieldset><legend>Active HttpSessions informations</legend>\r\n");
      out.write("        <input type=\"hidden\" name=\"action\" id=\"sessionsFormAction\" value=\"injectSessions\"/>\r\n");
      out.write("        <input type=\"hidden\" name=\"sort\" id=\"sessionsFormSort\" value=\"");
      out.print( JspHelper.escapeXml(request.getAttribute("sort")) );
      out.write("\"/>\r\n");
      out.write("        ");
 String order = (String) request.getAttribute("order");
           if (order == null || "".equals(order)) {
               order = "ASC";
           }
        
      out.write("\r\n");
      out.write("        <input type=\"hidden\" name=\"order\" id=\"sessionsFormSortOrder\" value=\"");
      out.print( JspHelper.escapeXml(order) );
      out.write("\"/>\r\n");
      out.write("        <input type=\"submit\" name=\"refresh\" id=\"refreshButton\" value=\"Refresh Sessions list\" onclick=\"document.getElementById('sessionsFormAction').value='refreshSessions'; return true;\"/>\r\n");
      out.write("        ");
      out.print( JspHelper.formatNumber(activeSessions.size()) );
      out.write(" active Sessions<br/>\r\n");
      out.write("        <table border=\"1\" cellpadding=\"2\" cellspacing=\"2\" width=\"100%\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='id'; document.getElementById('refreshButton').click(); return true;\">Session Id</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='id'; document.getElementById('refreshButton').click(); return true;\">Type</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='locale'; document.getElementById('refreshButton').click(); return true;\">Guessed Locale</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='user'; document.getElementById('refreshButton').click(); return true;\">Guessed User name</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='CreationTime'; document.getElementById('refreshButton').click(); return true;\">Creation Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='LastAccessedTime'; document.getElementById('refreshButton').click(); return true;\">Last Accessed Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='UsedTime'; document.getElementById('refreshButton').click(); return true;\">Used Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='InactiveTime'; document.getElementById('refreshButton').click(); return true;\">Inactive Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='TTL'; document.getElementById('refreshButton').click(); return true;\"><span title=\"Time To Live\">TTL</span></a></th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            ");
 if (activeSessions.size() > 10) { 
      out.write("\r\n");
      out.write("            <tfoot>");
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='id'; document.getElementById('refreshButton').click(); return true;\">Session Id</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='id'; document.getElementById('refreshButton').click(); return true;\">Type</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='locale'; document.getElementById('refreshButton').click(); return true;\">Guessed Locale</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='user'; document.getElementById('refreshButton').click(); return true;\">Guessed User name</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='CreationTime'; document.getElementById('refreshButton').click(); return true;\">Creation Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='LastAccessedTime'; document.getElementById('refreshButton').click(); return true;\">Last Accessed Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='UsedTime'; document.getElementById('refreshButton').click(); return true;\">Used Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='InactiveTime'; document.getElementById('refreshButton').click(); return true;\">Inactive Time</a></th>\r\n");
      out.write("                    <th><a onclick=\"document.getElementById('sessionsFormSort').value='TTL'; document.getElementById('refreshButton').click(); return true;\"><span title=\"Time To Live\">TTL</span></a></th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </tfoot>\r\n");
      out.write("            ");
 } // end if 
      out.write("\r\n");
      out.write("            <tbody>\r\n");
 Iterator iter = activeSessions.iterator();
   while (iter.hasNext()) {
       Session currentSession = (Session) iter.next();
       String currentSessionId = JspHelper.escapeXml(currentSession.getId());
       String type;
       if (currentSession instanceof DeltaSession) {
           if (((DeltaSession) currentSession).isPrimarySession()) {
               type = "Primary";
           } else {
               type = "Backup";
           }
       } else if (currentSession instanceof DummyProxySession) {
           type = "Proxy";
       } else {
           type = "Primary";
       }

      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input type=\"checkbox\" name=\"sessionIds\" value=\"");
      out.print( currentSessionId );
      out.write("\" />\r\n");
      out.write("                      ");

                        if ("Proxy".equals(type)) {
                            out.print(currentSessionId);
                        } else {
                      
      out.write("\r\n");
      out.write("                      <a href=\"");
      out.print( submitUrl );
      out.write("&amp;action=sessionDetail&amp;sessionId=");
      out.print( currentSessionId );
      out.write("&amp;sessionType=");
      out.print( type );
      out.write('"');
      out.write('>');
      out.print( currentSessionId );
      out.write("</a>\r\n");
      out.write("                      ");

                        }
                      
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( type );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.guessDisplayLocaleFromSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.guessDisplayUserFromSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.getDisplayCreationTimeForSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.getDisplayLastAccessedTimeForSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.getDisplayUsedTimeForSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.getDisplayInactiveTimeForSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                    <td style=\"text-align: center;\">");
      out.print( JspHelper.getDisplayTTLForSession(currentSession) );
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
 } // end while 
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <p style=\"text-align: center;\">\r\n");
      out.write("            <input type=\"submit\" name=\"invalidate\" value=\"Invalidate selected Sessions\" onclick=\"document.getElementById('sessionsFormAction').value='invalidateSessions'; return true;\"/>\r\n");
      out.write("        </p>\r\n");
      out.write("    </fieldset>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form method=\"get\" action=\"");
      out.print(request.getContextPath());
      out.write("/html\">\r\n");
      out.write("  <p style=\"text-align: center;\">\r\n");
      out.write("    <input type=\"submit\" value=\"Return to main page\" />\r\n");
      out.write("  </p>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
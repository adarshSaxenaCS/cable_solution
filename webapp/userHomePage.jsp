<!DOCTYPE html>
<%@page import="com.thinking.machine.entity.AdminCompt"%>
<%@page import="com.thinking.machine.entity.OperatorCompt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thinking.machine.dao.cableDaoImple"%>

<% 
String gg=(String)session.getAttribute("uname");
if(gg==null)
{
response.sendRedirect("index.html");	
}	
%>


<html lang="en">




<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Ca-Solution </title>
    <link rel="stylesheet" href="style01.css">
     <script src='jquery.js'></script>
    
   
    

</head>

<body>
<div class="backg">
    <div class="container">
        <ul class="container">
            <a href="#" class="txt">Ca-Solution</a>
            <li>
                <a href="logout.jsp" class="profile">LOGOUT</a>
                <a href="#" class="profile">PROFILE</a>
                <a href="userComptPage.jsp" class="profile">NEW COMPLAINT</a>

            </li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="center">
        <table>
      <caption><b>USER COMPLAINT TABLE</b></caption>
            
            
            <thead>
            
              <tr>
                <th scope="col">UserName</th>
              
                <th scope="col">Complaint</th>
                <th scope="col">Status</th>
                
                <th scope="col">Seen</th>
                <th scope="col">Data</th>
                
                
              </tr>
            </thead>
            <tbody>
            
            
            <%
            String uname=(String)session.getAttribute("uname");
            
            ArrayList<AdminCompt> ar=new ArrayList<>();
            cableDaoImple cd=new cableDaoImple();
            ar=cd.getAdminComptData(uname);
            String name="";
            String compt="";
            
            
            
            Boolean flag=false;
            
            int i=11;
            for(AdminCompt oc:ar)
            {
            	name=oc.getUname();
            	compt=oc.getCompt();
            	
            	flag=cd.getOperatorLoginData(name, compt);
            	
            	String Operator_status=oc.getOperator_status();
            	
            	
            	Boolean f1=Operator_status.equalsIgnoreCase("Solved");
            	Boolean f2=Operator_status.equalsIgnoreCase("Unsolved");
            	
            	
            			
            
            	
            	
            %>
            
            <%if(i==11){ %>
              <tr id="aa<%=i%>" style="background: #bec4be;">
                <td data-label="uname"><%=oc.getUname() %></td>
                <td data-label="complaint"><%=oc.getCompt() %></td>
                <% if(f1) %><td data-label="status" style="color: green;" >Solved</td><% ;%>
                <% if(f2) %><td data-label="status" style="color: red;" >Unsolved</td><% ;%>
                <% if(flag==true || f1) %>  <td data-label="seen" style="color: green;">Seen</td><%;%>
                <% if(flag==false && f2) %>  <td data-label="seen" style="color: red;">Unseen </td><%;%>
                <td data-label="date"><%=oc.getOperator()%></td>
              </tr>
              
              <%
            i=12;
            continue;
            } %>
              
              
              <tr id="aa<%=i%>">
                <td data-label="uname"><%=oc.getUname() %></td>
                <td data-label="complaint"><%=oc.getCompt() %></td>
                <% if(f1) %><td data-label="status" style="color: green;" >Solved</td><% ;%>
                <% if(f2) %><td data-label="status" style="color: red;" >Unsolved</td><% ;%>
                <% if(flag==true || f1) %>  <td data-label="seen" style="color: green;">Seen</td><%;%>
                <% if(flag==false && f2) %>  <td data-label="seen" style="color: red;">Unseen </td><%;%>
                <td data-label="date"><%=oc.getOperator()%></td>
              </tr>
              
              
              
              
              
              <%
              i++;
            }
              %>
              
              
              </tbody>
          </table>
    </div>
    </div>


</body>

</html>
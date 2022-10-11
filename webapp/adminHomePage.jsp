<!DOCTYPE html>
<%@page import="com.thinking.machine.entity.Login"%>
<%@page import="com.thinking.machine.entity.AdminCompt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thinking.machine.dao.cableDaoImple"%>
<%@page import="com.mysql.cj.MysqlConnection"%>
<%@page import="com.thinking.machine.MyConnection"%>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Ca-Solution </title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="style01.css">
    <script src='jquery.js'></script>



<script>





$(()=>{

	$("tr").on('click',function(){
		
		var uname=$(this).find("td:eq(0)").text();
		var compt=$(this).find("td:eq(1)").text();
		var ward_no=$(this).find("td:eq(2)").text();
		var operator=$(this).find("td:eq(3)").text();
		var operator_status=$(this).find("td:eq(4)").text();
		
		
		
		if(!(confirm("are you sure ?")))return false;
		
		if(operator_status=="Solved")
		{
			$(this).find("td:eq(5)").text("Unsolved");
			
		}	
		

		$.ajax({
			   method: "GET",
			  url: "AdminComptServlet",
			  data: { uname: uname, compt: compt,operator_status: operator_status }
			});
		 
		alert(uname+","+compt+","+ward_no+","+operator+","+operator_status);
		
		
	});
	

	
	
	
});






</script>




</head>

<body>
<div class="backg">


    <div class="container">
        <ul class="container">
            <a href="#" class="txt">Ca-Solution</a>
            <li>
                <a href="logout.jsp" class="profile">LOGOUT</a>
                <a href="#" class="profile">PROFILE</a>
                <a href="#" class="profile">STATUS</a>

            </li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="center">
        <table>
            <caption>Statement Summary</caption>
            <thead>
              <tr>
                <th scope="col">UserId</th>
                <th scope="col">complaint</th>
                <th scope="col">Area No.</th>
                <th scope="col">Operator</th>
                <th scope="col">oper. status</th>
              </tr>
            </thead>
            <tbody>

<%

ArrayList<AdminCompt> ar=new ArrayList<AdminCompt>();
cableDaoImple cd=new cableDaoImple();
ar=cd.getAdminComptData();
int i=1;
for(AdminCompt ac:ar)
{

%>

<%if(i==1){%>
<tr style="background: #bec4be;" >

                <td data-label="Account" ><%=ac.getUname() %></td>
                <td data-label="Due Date"><%=ac.getCompt()%></td>
                <td data-label="Amount"><%=ac.getWard_no()%></td>
                <td data-label="Period"><%=ac.getOperator()%></td>
                <td data-label="Period"><%=ac.getOperator_status()%></td>            
 </tr>
 
<%
i=2;
 continue;
}%>

<tr >

                <td data-label="Account" ><%=ac.getUname() %></td>
                <td data-label="Due Date"><%=ac.getCompt()%></td>
                <td data-label="Amount"><%=ac.getWard_no()%></td>
                <td data-label="Period"><%=ac.getOperator()%></td>
                <td data-label="Period"><%=ac.getOperator_status()%></td>            
 </tr>




<% 
}
%>
             


            </tbody>
          </table>
    </div>
    </div>



</body>

</html>
<!DOCTYPE html>
<%@page import="com.thinking.machine.entity.OperatorCompt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thinking.machine.dao.cableDaoImple"%>
<html lang="en">



<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Ca-Solution </title>
    <link rel="stylesheet" href="style01.css">
     <script src='jquery.js'></script>
    
    <script>
    
    $(()=>{
    	
    	$(":button").click(function(){
    		
    		
    		var id=$(this).attr("name");
    		
    		
    		var status=$("#bb"+id+" :selected").text();
    		
    		
    		 var uname=$("#aa"+id).find("td:eq(0)").text();
     		var compt=$("#aa"+id).find("td:eq(1)").text();
     		var phone_no=$("#aa"+id).find("td:eq(2)").text();	
    		
    		if(!confirm("Have you solved ?"))return false;
    		if(status=="Unsolved")
    			{
    			alert("You haven't solved !!!!");
    			return;
    			}
    		
    		
    		$.ajax({
 			   method: "GET",
 			  url: "OperatorServlet",
 			  data: { uname: uname,compt: compt,phone_no: phone_no,status: status}
 			});
 			
    		
    		
    		
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
                <a href="#" class="profile">COMPLAINT </a>

            </li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="center">
        <table>
            <caption><b>OPERATOR TABLE<b></caption>
            <thead>
              <tr>
                <th scope="col">Complainer Name</th>
                <th scope="col">Complaint</th>
                <th scope="col">Mobile no.</th>
                <th scope="col">Status</th>
                <th scope="col">Submit Btn</th>
                
              </tr>
            </thead>
            <tbody>
            
            
            <%
            
            ArrayList<OperatorCompt> ar=new ArrayList<>();
            cableDaoImple cd=new cableDaoImple();
            ar=cd.getOperatorComptData();
            int i=11;
            for(OperatorCompt oc:ar)
            {
            
            %>
            
            
            
            
            
              <tr id="aa<%=i%>">
                <td data-label="user_name"><%=oc.getUname()%></td>
                <td data-label="complaint"><%=oc.getCompt()%></td>
                <td data-label="mobile_no"><%=oc.getPhone_no()%></td>
                <td data-label="status">
			 <select id="bb<%=i%>" >
			        <option value="unsolved">Unsolved</option>
    				<option value="solved">Solved</option>
    				
			</select></td>
			<td data-label="btn"><button  name="<%=i%>"> Submit</button></td>
                
			
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
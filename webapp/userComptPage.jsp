<!DOCTYPE html>
<html lang="en">
<% 
String gg=(String)session.getAttribute("uname");
if(gg==null)
{
response.sendRedirect("index.html");	
}	
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="contact.css">
    <title>Raise Complaint</title>
    <script src='jquery.js'></script>
    <script >
    
    
    $(()=>{
    	
    	$("#reset1").click(function(){
    	
    	$("#query ").prop('selectedIndex',0);
    	$('#message').html("");
    		
    	});
    	
         $("#submit1").click(function(){
    		 
    		var n=$("select").find(':selected').val();
    		
    		if(n<=0)
    	    {
    		alert("select query !");
    		return false;
    	    }
    	
    		var compt=$("#query").find(':selected').text();
        	
    		if (!confirm("are you sure this complaint "+compt+" ?"))return ;
    		
        <%
        String name=(String)session.getAttribute("uname");
        %>
    	
        var name=$("#userName").val();
    	
    	
    	
        
    	   $.ajax({
			   method: "GET",
			  url: "UserServlet",
			  data: { compt: compt,uname: name }
			});
		
    	
    	
    	
    	  alert("Your Query has been submitted");
    	
         
    	
    	
  
    		
    		
    		
    		

    		
    	});
    	
     	
    	
    });
    
    
    </script>
    
    
    
</head>

<body>
    <div class="bg-img">
        <div class="container">
            <div class="topnav">
                <a href="userHomePage.jsp">Home</a>
                <a href="#about">About</a>
                <a href="logout.jsp">Logout</a>
            </div>
        </div>

        <div class="Container">
            <div class="headBox">
                <div class="head1">
                    <h2>Raise Complaint</h2>
                </div>
                <form action="">
                    <div class="inputBox">
                        <div class="query"><label>Query Type : </label><select name="select" id="query">
                                <option value="0" aria-readonly="true">Select your Query</option>
                                <option value="1">problem with channels</option>
                                <option value="2">plug problem</option>
                                <option value="3">cable break</option>
                                <option value="4">no signal</option>
                                <option value="5">poor signal</option>
                                <option value="6">other</option>
                            </select></div>
                        <div class="inp msg"><label for="message"> Message : </label>
                            <input type="text" id="message" name="message" placeholder="Message here">
                            <div>
                                <input class="bbtn" type="reset" value="Reset" id="reset1">
                                <input class="btn" type="submit" value="Submit" id="submit1">
                                <input type="hidden" id="userName" value="<%=name %>">
                                
                                
                            </div>
                        </div>
                    </div>
                </form>
            </div>
</body>

</html>
<% 
String gg=request.getParameter("utype");
if(gg==null)
{
response.sendRedirect("index.html");	
}	
%>


<html>
    <head>
        <title>home</title>
        <link rel="stylesheet" href="logstyle.css"> 			
        <script src='jquery.js'></script>
      <script>
      
      $(()=>{
    	  
    	$("#btn1").click(function(){
    		
    		var uname=$("#uname").val();
    		var upass=$("#upass").val();
    		var utype=$("#utype").val();
    		//alert(uname.length==0);
    		// alert(upass.length==0);
    		
    		
    		if(uname.length==0 && upass.length==0)
    		{
    			alert("Feel details userName and password");
    			return false;
    		}
    		
    		if(uname.length==0 )
    		{
    			alert("Feel detail userName ");
    			return false;
    		}
    		
    		
    		if(upass.length==0)
    		{
    			alert("Feel detail password");
    			return false;
    		}
    		
    		if(utype=="null")
    		{	
    			alert("choise your type like admin , lineMan , user");
    			
    			return false;
    		}
    			
    		
 			
    	
    		
    		
    	
    	});  
    	  
    	  
    	  
      });
      
      
      </script>
      
      
    </head>
    <body>
         <div class="banner">
            <div class="navbar">
                <img src="logo.png" class="logo">
                <ul>
                    <li><a href="index.html">home</a></li>
                    <!--<li><a href="#">Service</a></li>-->
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact us</a></li>

                </ul>
            </div>

            <div class="content">
                <h1>W<span>elcome</span></h1><br><br>
                
<%

String name=request.getParameter("utype");



%>
                <div class="form">
                    <h2> <%=name %> Login here</h2>
                    
                    <form action="loginServlet"  method="post" >
                    
                    <input type="hidden"  name="utype" id="utype" value="<%=name %>">
                    
                    <input type="text" name="uname" id="uname" placeholder="Enter user name here">
                    <input type="password" name="upass" id="upass" placeholder="Enter password here"><span id="span2"></span>
                    <button class="btnn" type="submit" id="btn1">Login </button>
                
                </form>
                    
                </div>
                
        </div>
        </div>
        
    </body>
</html>
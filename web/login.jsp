<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Test</title>
    <link rel='stylesheet' href='styleme.css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="javascript1.js" type="text/javascript"></script>
</head>
<body>
<%
    String n="";
    int count=0;
    if(request.getCookies()!=null){
        List<Cookie> cockies = Arrays.asList(request.getCookies());
        for(Cookie c : cockies) {
            if(count==0) {System.out.println("Cookie is:"+c.getValue());count++;}
            if(c.getName().equals("Name")) {
                n = (String) c.getValue();

                break;
            }
            else{
                n="";
            }
        }
    }
    else{
        n="";
    }
%>
<h1>Please Enter the log-in Information Below</h1>
<form action='viewpage1' method='POST'>
    <br /><br />
    user name: <input id="username" type='text' name='username' value=<%=n%> ><br /><br />
    password: <input type='password' name='password' /><br /><br />
    <input type='submit' name='submit' value='log-in' /><br /><br />

    <input id="box1" type="checkbox" name="rememberme"  > Remember me<br /><br />
</form><br /><br />

</body>
</html>

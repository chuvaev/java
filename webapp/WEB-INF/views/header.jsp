
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title>
    <style>
        body {
            /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#a4b357+0,a4b357+34,a4b357+34,a4b357+43,a4b357+43,75890c+100 */
            background: rgb(164,179,87); /* Old browsers */
            background: radial-gradient(ellipse at center, rgba(164,179,87,1) 0%,rgba(164,179,87,1) 34%,rgba(164,179,87,1) 34%,rgba(164,179,87,1) 43%,rgba(164,179,87,1) 43%,rgba(117,137,12,1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#a4b357', endColorstr='#75890c',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
            background-attachment: fixed;
        }
        a {
            color: beige;
            border: none;
            text-decoration: unset;
            font-size: 24px;
            cursor: pointer;
            font-weight: bold;
        }
        button{
            font-size: 1.1em;
            background: #47af50;
            border:none;
            color:white;
            padding:10px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        body a:hover{
            color: #ffc913;

        }

        input [type="text"], input [type="date"], input [type="number"], input [type="password"]{
            border: 1px solid black;
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            background: #ffffff !important;
            outline: none;
            height:34px;
            width: 350px;
            color:black;
            font-size: 1.6em;
        }
    </style>
</head>
<body>
<jsp:include page="main-menu.jsp" />
<table width="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td width="100%"></td>
    </tr>
</table>
</body>
</html>

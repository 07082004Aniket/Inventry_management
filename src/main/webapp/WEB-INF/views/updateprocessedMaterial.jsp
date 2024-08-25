<%@ page import="com.aniket.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Full Width Layout with Sidebar</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: grid;
            grid-template-rows: auto 1fr auto; /* Header, Main Content, Footer */
            grid-template-columns: 200px 1fr; /* Sidebar, Main Content */
            min-height: 100vh; /* Ensure the body covers the full height of the viewport */
        }

        header {
            grid-column: 1 / span 2; /* Span across both columns */
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }

        nav {
            grid-row: 2; /* Place navigation in the second row */
            grid-column: 1; /* First column for sidebar */
            background-color: #444;
            color: white;
            padding: 10px;
            height: calc(100vh - 100px); /* Subtract header and footer height */
            overflow-y: auto; /* Allow scrolling if content exceeds height */
        }

        nav ul {
            list-style-type: none;
            padding: 0;
        }

        nav ul li {
            margin-bottom: 10px;
        }

        nav ul li a {
            display: block;
            padding: 10px;
            text-decoration: none;
            color: white;
            transition: background-color 0.3s;
        }

        nav ul li a:hover {
            background-color: #555;
        }

        .content {
            grid-row: 2; /* Place content in the second row */
            grid-column: 2; /* Second column for main content */
            padding: 20px;
            overflow-y: auto; /* Allow scrolling if content exceeds height */
        }

        article {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
        }
        
        form {
        background-color: #fff;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    form h3 {
        font-size: 20px;
        margin-bottom: 10px;
    }

    form p {
        margin-bottom: 5px;
    }

    form input[type="text"],
    form input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }

    form input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    form input[type="submit"]:hover {
        background-color: #45a049;
    }

        footer {
            grid-column: 1 / span 2; /* Span across both columns */
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }

        @media (max-width: 768px) {
            body {
                display: flex;
                flex-direction: column;
            }

            nav {
                height: auto;
                overflow-y: visible;
            }
        }
    </style>
</head>

<body>
    <header>
        <h1>Inventory Manager</h1>
    </header>
   <nav>
        <ul>
        <div>
        <li><a href="viewRaw" >viewRawMaterial</a></li>
        </div>
        <div>
        <li><a href="viewProcessed">viewProcessedMaterial</a></li>
        </div>
        <div>
        <li><a href="viewIssueRaw">issueRawMaterialLog</a></li>
        </div>
        <div>
        <li><a href="viewIssuepro">issueProcessedMaterialLog</a></li>
        </div>
         <div>
        <li><a href="unavailableRaw">unavailableRawMaterial</a></li>
        </div>
         <div>
        <li><a href="unavailableProcessed">unavailableProcessedMaterial</a></li>
        </div>
        <div>
        <li><a href="changepass">changePassword</a></li><p></li>
        </div>
        </ul>
    </nav>


    <div class="content">
        <article>
		         <%ProcessedMaterial pro= (ProcessedMaterial) request.getAttribute("processedMaterialList"); %>

<fieldset>
		<legend>Add Processed Material </legend>
		<form action="updateProcesseddb" method="post">
		<h3>Add Raw  here</h3>
		<p>Enter the id</p>
		<input type="text" name="id"  value=<%=pro.getId() %>>
		<p>Enter the Name</p>
		<input type="text" name="name" value=<%=pro.getName() %>>
		<p>Enter the quantity</p>
		<input type="text" name="quantity" value=<%=pro.getQuantity() %>>
		<p>Enter the unit</p>
		<input type="text" name="unit" value=<%=pro.getUnit() %> >
		<p>Enter the costPerUnit</p>
		<input type="text" name="costPerUnit" value=<%=pro.getCostPerUnit() %>>
		<p></p>
		<input type="submit" value="Add raw"> 
		</form>
		</fieldset>
        </article>
    </div>

    <footer>
        <p>The Templet/Project Design By Aniket Patil</p>
    </footer>
</body>

</html>
    


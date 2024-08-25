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
            <h2>WelCome to th Thalner Bank</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis libero sit amet urna porta, vel
                dignissim elit sollicitudin. Donec volutpat, mauris quis ultrices mattis, mi nisl laoreet nulla, nec
                accumsan sem nisl a lectus.</p>
            <p>Quisque elementum, quam sed sollicitudin malesuada, nisi eros egestas lacus, id semper metus arcu sit
                amet libero. Nulla at ultrices risus, quis egestas magna. Fusce feugiat urna sed quam feugiat, vel
                vestibulum metus lacinia.</p>
        </article>
    </div>

    <footer>
        <p>The Templet/Project Design By Aniket Patil</p>
    </footer>
</body>

</html>
    

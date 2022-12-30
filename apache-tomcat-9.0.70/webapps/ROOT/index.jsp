<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="">
    <style>
        .input {
            height: 180px;
            width: 230px;
            margin: 0;
            padding: 10px;
            border: 1px #CCC solid;
        }

        .button {
            padding: 5px;
            margin: 5px ;
            background: bisque;
        }
    </style>
</head>

<body>
<h2>Product Discount Calculator</h2>
<form method="post" action="/calculate-discount">
    <div class="input" style="background: #CCCCCC ">
        <label>Product Description</label><br/>
        <input type="text" name="Product_Description" placeholder="Product Description"/><br/>
        <label>List Price</label><br/>
        <input type="text" name="List_Price" placeholder="List Price"/><br/>
        <label>Discount Percent</label><br/>
        <input type="text" name="Discount_Percent" placeholder="Discount Percent"/><br/>
        <button class="button" type="submit" id="submit" value="Calculate Discount">Calculate Discount</button>
    </div>


</form>
</body>
</html>
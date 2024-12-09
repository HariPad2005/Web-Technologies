<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bag Details from XML</title>
    <style>
        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        /* Table styles */
        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        tr:nth-child(even) td {
            background-color: #f2f2f2;
        }

        tr:hover td {
            background-color: #e0e0e0;
        }

        /* Error message styling */
        .error {
            color: red;
            text-align: center;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <h1>Bag Details</h1>

    <?php
    // Specify the XML file path
    $xmlFile = 'ex6b_output.xml'; // Replace with your actual XML file path

    // Load the XML file
    if (file_exists($xmlFile)) {
        $xml = simplexml_load_file($xmlFile);
    } else {
        die("Error: XML file not found.");
    }

    // Check if there are any bags in the XML
    if ($xml->Bag) {
        echo "<table>
                <tr>
                    <th>ID</th>
                    <th>Brand</th>
                    <th>Type</th>
                    <th>Price</th>
                </tr>";

        // Loop through each 'Bag' element in the XML
        foreach ($xml->Bag as $bag) {
            echo "<tr>
                    <td>" . $bag->ID . "</td>
                    <td>" . $bag->Brand . "</td>
                    <td>" . $bag->Type . "</td>
                    <td>$" . $bag->Price . "</td>
                  </tr>";
        }
        echo "</table>";
    } else {
        echo "<p class='error'>No bag details found in the XML file.</p>";
    }
    ?>

</body>
</html>

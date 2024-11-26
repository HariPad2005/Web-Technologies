<?php
// Database connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "BagsDB"; // Changed database name to BagsDB

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// SQL query to fetch bag details
$sql = "SELECT id, brand, type, price FROM BagDetails";
$result = $conn->query($sql);

// Create a new XML document
$xml = new SimpleXMLElement('<BagDetails/>');

// Fetch the data and add it to the XML
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        // Add each bag as an XML element
        $bag = $xml->addChild('Bag');
        $bag->addChild('ID', $row['id']);
        $bag->addChild('Brand', $row['brand']);
        $bag->addChild('Type', $row['type']);
        $bag->addChild('Price', $row['price']);
    }
} else {
    echo "0 results found";
}

// Set the correct header to output XML
header('Content-Type: text/xml');

// Output the XML
echo $xml->asXML();

// Close the connection
$conn->close();
?>

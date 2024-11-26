<?php
// Database connection variables
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "BagsDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// If form is submitted to add a new bag
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['brand'])) {
    $brand = $_POST['brand'];
    $type = $_POST['type'];
    $price = $_POST['price'];

    $sql = "INSERT INTO BagDetails (brand, type, price) VALUES ('$brand', '$type', '$price')";

    if ($conn->query($sql) === TRUE) {
        echo "<p>New record created successfully.</p>";
    } else {
        echo "<p>Error: " . $sql . "<br>" . $conn->error . "</p>";
    }
}

// If form is submitted to update bag details
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['update_id'])) {
    $id = $_POST['update_id'];
    $brand = $_POST['update_brand'];
    $type = $_POST['update_type'];
    $price = $_POST['update_price'];

    $sql = "UPDATE BagDetails SET brand='$brand', type='$type', price='$price' WHERE id='$id'";

    if ($conn->query($sql) === TRUE) {
        echo "<p>Record updated successfully.</p>";
    } else {
        echo "<p>Error updating record: " . $conn->error . "</p>";
    }
}

// If form is submitted to delete a bag
if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['delete_id'])) {
    $id = $_GET['delete_id'];

    $sql = "DELETE FROM BagDetails WHERE id='$id'";

    if ($conn->query($sql) === TRUE) {
        echo "<p>Record deleted successfully.</p>";
    } else {
        echo "<p>Error deleting record: " . $conn->error . "</p>";
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bag Details CRUD Operations</title>
</head>
<body>
    <h1>World of Bags - CRUD Operations</h1>

    <!-- Form to insert new bag -->
    <h2>Add New Bag</h2>
    <form action="bags.php" method="POST">
        <label for="brand">Bag Brand:</label>
        <input type="text" id="brand" name="brand" required><br><br>

        <label for="type">Bag Type:</label>
        <input type="text" id="type" name="type" required><br><br>

        <label for="price">Price (USD):</label>
        <input type="number" step="0.01" id="price" name="price" required><br><br>

        <input type="submit" value="Add Bag">
    </form>

    <hr>

    <!-- Form to update bag details -->
    <h2>Update Bag Details</h2>
    <form action="bags.php" method="POST">
        <label for="update_id">Bag ID to Update:</label>
        <input type="number" id="update_id" name="update_id" required><br><br>

        <label for="update_brand">New Brand:</label>
        <input type="text" id="update_brand" name="update_brand" required><br><br>

        <label for="update_type">New Type:</label>
        <input type="text" id="update_type" name="update_type" required><br><br>

        <label for="update_price">New Price (USD):</label>
        <input type="number" step="0.01" id="update_price" name="update_price" required><br><br>

        <input type="submit" value="Update Bag">
    </form>

    <hr>

    <!-- Form to delete a bag record -->
    <h2>Delete Bag</h2>
    <form action="bags.php" method="GET">
        <label for="delete_id">Bag ID to Delete:</label>
        <input type="number" id="delete_id" name="delete_id" required><br><br>
        <input type="submit" value="Delete Bag">
    </form>

    <hr>

    <!-- Section to display all bag details -->
    <h2>Bag List</h2>
    <?php
    // Fetch all bag details from the database to display
    $sql = "SELECT id, brand, type, price FROM BagDetails";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        echo "<table border='1'>
                <tr>
                    <th>ID</th>
                    <th>Brand</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>";
        while($row = $result->fetch_assoc()) {
            echo "<tr>
                    <td>" . $row["id"]. "</td>
                    <td>" . $row["brand"]. "</td>
                    <td>" . $row["type"]. "</td>
                    <td>" . $row["price"]. "</td>
                    <td>
                        <a href='bags.php?delete_id=" . $row["id"] . "'>Delete</a> |
                        <a href='bags.php?update_id=" . $row["id"] . "'>Update</a>
                    </td>
                </tr>";
        }
        echo "</table>";
    } else {
        echo "<p>No results found</p>";
    }

    // Close the connection
    $conn->close();
    ?>

</body>
</html>

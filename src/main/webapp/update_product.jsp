<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Update Product</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<%--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
  <style>
    body {
      color: #566787;
      background: #f5f5f5;
      font-family: 'Varela Round', sans-serif;
      font-size: 13px;
    }

    .table-responsive {
      margin: 30px 0;
    }

    .table-wrapper {
      min-width: 1000px;
      background: #fff;
      padding: 20px 25px;
      border-radius: 3px;
      box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
    }

    .table-title {
      padding-bottom: 15px;
      background: #435d7d;
      color: #fff;
      padding: 16px 30px;
      margin: -20px -25px 10px;
      border-radius: 3px 3px 0 0;
    }

    .table-title h2 {
      margin: 5px 0 0;
      font-size: 24px;
    }

    .table-title .btn-group {
      float: right;
    }

    .table-title .btn {
      color: #fff;
      float: right;
      font-size: 13px;
      border: none;
      min-width: 50px;
      border-radius: 2px;
      border: none;
      outline: none !important;
      margin-left: 10px;
    }

    .table-title .btn i {
      float: left;
      font-size: 21px;
      margin-right: 5px;
    }

    .table-title .btn span {
      float: left;
      margin-top: 2px;
    }

    table.table tr th, table.table tr td {
      border-color: #e9e9e9;
      padding: 12px 15px;
      vertical-align: middle;
    }

    table.table tr th:first-child {
      width: 60px;
    }

    table.table tr th:last-child {
      width: 100px;
    }

    table.table-striped tbody tr:nth-of-type(odd) {
      background-color: #fcfcfc;
    }

    table.table-striped.table-hover tbody tr:hover {
      background: #f5f5f5;
    }

    table.table th i {
      font-size: 13px;
      margin: 0 5px;
      cursor: pointer;
    }

    table.table td:last-child i {
      opacity: 0.9;
      font-size: 22px;
      margin: 0 5px;
    }

    table.table td a {
      font-weight: bold;
      color: #566787;
      display: inline-block;
      text-decoration: none;
      outline: none !important;
    }

    table.table td a:hover {
      color: #2196F3;
    }

    table.table td a.edit {
      color: #FFC107;
    }

    table.table td a.delete {
      color: #F44336;
    }

    table.table td i {
      font-size: 19px;
    }

    table.table .avatar {
      border-radius: 50%;
      vertical-align: middle;
      margin-right: 10px;
    }

    .pagination {
      float: right;
      margin: 0 0 5px;
    }

    .pagination li a {
      border: none;
      font-size: 13px;
      min-width: 30px;
      min-height: 30px;
      color: #999;
      margin: 0 2px;
      line-height: 30px;
      border-radius: 2px !important;
      text-align: center;
      padding: 0 6px;
    }

    .pagination li a:hover {
      color: #666;
    }

    .pagination li.active a, .pagination li.active a.page-link {
      background: #03A9F4;
    }

    .pagination li.active a:hover {
      background: #0397d6;
    }

    .pagination li.disabled i {
      color: #ccc;
    }

    .pagination li i {
      font-size: 16px;
      padding-top: 6px
    }

    .hint-text {
      float: left;
      margin-top: 10px;
      font-size: 13px;
    }

    /* Custom checkbox */
    .custom-checkbox {
      position: relative;
    }

    .custom-checkbox input[type="checkbox"] {
      opacity: 0;
      position: absolute;
      margin: 5px 0 0 3px;
      z-index: 9;
    }

    .custom-checkbox label:before {
      width: 18px;
      height: 18px;
    }

    .custom-checkbox label:before {
      content: '';
      margin-right: 10px;
      display: inline-block;
      vertical-align: text-top;
      background: white;
      border: 1px solid #bbb;
      border-radius: 2px;
      box-sizing: border-box;
      z-index: 2;
    }

    .custom-checkbox input[type="checkbox"]:checked + label:after {
      content: '';
      position: absolute;
      left: 6px;
      top: 3px;
      width: 6px;
      height: 11px;
      border: solid #000;
      border-width: 0 3px 3px 0;
      transform: inherit;
      z-index: 3;
      transform: rotateZ(45deg);
    }

    .custom-checkbox input[type="checkbox"]:checked + label:before {
      border-color: #03A9F4;
      background: #03A9F4;
    }

    .custom-checkbox input[type="checkbox"]:checked + label:after {
      border-color: #fff;
    }

    .custom-checkbox input[type="checkbox"]:disabled + label:before {
      color: #b8b8b8;
      cursor: auto;
      box-shadow: none;
      background: #ddd;
    }

    /* Modal styles */
    .modal .modal-dialog {
      max-width: 400px;
    }

    .modal .modal-header, .modal .modal-body, .modal .modal-footer {
      padding: 20px 30px;
    }

    .modal .modal-content {
      border-radius: 3px;
    }

    .modal .modal-footer {
      background: #ecf0f1;
      border-radius: 0 0 3px 3px;
    }

    .modal .modal-title {
      display: inline-block;
    }

    .modal .form-control {
      border-radius: 2px;
      box-shadow: none;
      border-color: #dddddd;
    }

    .modal textarea.form-control {
      resize: vertical;
    }

    .modal .btn {
      border-radius: 2px;
      min-width: 100px;
    }

    .modal form label {
      font-weight: normal;
    }
  </style>
<%--  <script>--%>
<%--    $(document).ready(function () {--%>
<%--      // Activate tooltip--%>
<%--      $('[data-toggle="tooltip"]').tooltip();--%>

<%--      // Select/Deselect checkboxes--%>
<%--      var checkbox = $('table tbody input[type="checkbox"]');--%>
<%--      $("#selectAll").click(function () {--%>
<%--        if (this.checked) {--%>
<%--          checkbox.each(function () {--%>
<%--            this.checked = true;--%>
<%--          });--%>
<%--        } else {--%>
<%--          checkbox.each(function () {--%>
<%--            this.checked = false;--%>
<%--          });--%>
<%--        }--%>
<%--      });--%>
<%--      checkbox.click(function () {--%>
<%--        if (!this.checked) {--%>
<%--          $("#selectAll").prop("checked", false);--%>
<%--        }--%>
<%--      });--%>
<%--    });--%>
<%--  </script>--%>
</head>
<body>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="products?action=update_product&&id_product=${product.getId_product()}" method="post">
        <div class="modal-header">
          <h4 class="modal-title">Edit Product</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" name="name" value="${product.getName()}" required>
          </div>
          <div class="form-group">
            <label>Price</label>
            <input type="text" class="form-control" name="price" value="<fmt:formatNumber value="${product.getPrice()}" pattern="###0"/>" required>
          </div>
          <div class="form-group">
            <label>Sale Price</label>
            <input type="text" class="form-control" name="sale_price" value="<fmt:formatNumber value="${product.getSale_price()}" pattern="###0"/>" required>
          </div>
          <div class="form-group">
            <label>Quantity</label>
            <input type="text" class="form-control" name="quantity" value="${product.getQuantity()}" required>
          </div>
          <div class="form-group">
            <label>Image</label>
            <input type="text" class="form-control" name="image" value="${product.getImage()}" required>
          </div>
          <div class="form-group">
            <label>Category</label>
            <select name="category" id="category_update">
              <c:forEach items="${categories}" var="category">
                <c:choose>
                  <c:when test="${product.getCategory().getId_category() == category.getId_category()}">
                    <option name="id_category" value="${category.getId_category()}"
                            selected>${category.getName()}</option>
                  </c:when>
                  <c:otherwise>
                    <option value="${category.getId_category()}">${category.getName()}</option>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <label>Brand</label>
            <select name="brand" id="brand_update">
              <c:forEach items="${brands}" var="brand">
                <c:choose>
                  <c:when test="${product.getBrand().getId_brand() == brand.getId_brand()}">
                    <option name="id_category" value="${brand.getId_brand()}"
                            selected>${brand.getName()}</option>
                  </c:when>
                  <c:otherwise>
                    <option value="${brand.getId_brand()}">${brand.getName()}</option>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <label>Description</label>
              <textarea class="form-control" name="description" required>${product.getDescription()}</textarea>
          </div>
        </div>
        <div class="modal-footer">
          <a class="btn btn-default" data-dismiss="modal" href="products?action=home_product">Cancel</a>
<%--          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">--%>
          <input type="submit" class="btn btn-info" value="Save">
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
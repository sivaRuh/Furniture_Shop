<%-- 
    Document   : productmgthome
    Created on : Jun 3, 2018, 9:11:16 PM
    Author     : Dinesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <%@include file="/stylelinks.jspf" %> 
    
  <script type="text/javascript">
    $(function() {
       $( "#datepicker" ).datepicker();
    });
  </script>
  
  <script>
     function setSubCategory() {
                $.post("${pageContext.request.contextPath}/LoadSubCategoriesToCategoryServlet",
                        {category: $('#cat option:selected').val()},
                function (data) {
                    if (data !== '') {
//                        var array = data.split(',', 2);
//                        $("#district").val(array[0]);
//                        $("#province").val(array[1]);
                           
                        var i;

                        for(i=0;i<data.length;i++){
                            $('#subcat').append('<option value="' + data[i].subcatid + '">' + data[i].subcatdes + '</option>');
                        }
                    }
                });
            }
  </script>
  
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!--navbar-->
  <%@include file="/navbar.jsp" %>
  <div class="content-wrapper">
    <div class="container-fluid">
        
        
    <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Product Management</li>
      </ol>
    <!--  End of Breadcrumbs -->
    
    <div class="card mb-3">
        <div class="card-header">Search Parameters </div>
        <div class="card-body">
            <form name="productmgtsearchform" action="SearchProductMgtServlet">               
                   <table>
                        <tr>
                            <td>Product ID :</td>
                            <td><input type="text" width="10" name="productid" id="productid"/></td>
                            <td width="100"></td>
                            <td>Product Name :</td>
                            <td><input type="text" width="10" name="productname" id="productname"/></td>
                        </tr>                        
                        <tr>
                            <td>Category :</td>
                            <td>
                                <select name="cat" id="cat" style="width:175px" onchange="setSubCategory()">
                                    <option selected="true"> -- SELECT -- </option>
                                    <c:forEach var="category" items="categorylist">
                                        <option value="${category.categoryid}"> ${category.categorydes} </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td width="100"></td>
                            <td>Sub Category :</td>
                            <td>
                                <select name="subcat" id="subcat" style="width: 175px">
                                    <option selected="true"> -- SELECT -- </option>
                                    
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5"><br>Listed Date</td>                            
                        </tr>
                        <tr>
                            <td>From Date :</td>
                            <td><input type="text" width="10" name="fromdate" id="datepicker" onfocus="(this.type='date')" onblur="if(!this.value)this.type='text'"/></td>
                            <td width="100"></td>
                            <td>To Date :</td>
                            <td><input type="text" width="10" name="todate" id="datepicker" onfocus="(this.type='date')" onblur="if(!this.value)this.type='text'"/></td>
                        </tr>
                    </table> 
                    <hr>
                    <input type="button" class="col-1 btn btn-primary" name="searsh" value="Search">
                    <input type="button" class="col-1 btn btn-primary" name="reset" value="Reset">
                    <input type="button" class="col-md-1 btn btn-primary" name="back" value="Back">
                    <span class="col-md-6"></span><span class="col-md-6"></span>
                    <input type="button" class="col-md-2 btn btn-primary" name="add" value="Add New Product">
            </form>
            
            <br>
            
    <div class="card mb-3">

        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover" id="dataTable" width="100%" cellspacing="0">
              <thead class="thead-dark">
                <tr>
                  <th class=" border border-warning" style="white-space: nowrap">Product ID</th>
                  <th class=" border border-warning" style="white-space: nowrap">Product Name</th>
                  <th class=" border border-warning" style="white-space: nowrap">Category</th>
                  <th class=" border border-warning" style="white-space: nowrap">Sub Category</th>
                  <th class=" border border-warning" style="white-space: nowrap">Listed Date</th>
                  <th class=" border border-warning" style="white-space: nowrap">Price</th>
                  <th class=" border border-warning" style="white-space: nowrap">Quantity</th>
                  <th class=" border border-warning" style="white-space: nowrap">Status</th>
                  <th class=" border border-warning"></th>
                </tr>
              </thead>

              <tbody class="text-sm">
                  
                <c:forEach var="product" items="${productlist}">
                    <tr>
                      <td>${product.productId}</td>
                      <td>${product.productName}</td>
                      <td>${product.category}</td>
                      <td>${product.subCategory}</td>
                      <td>${product.listeddate}</td>
                      <td>${product.price}</td>
                      <td>${product.quantity}</td>
                      <td>${product.status}</td>
                      <td  style="white-space: nowrap">
                          <a href="ViewProductServlet?productId=${product.productId}"><i class="fa fa-wpforms" style="font-size: 20px;" title="View"></i></a>
                          <a href="UpdateProductServlet?productId=${product.productId}"><i class="fa fa-pencil-square-o" style="font-size: 20px;" title="Update"></i></a>
                          <a href="DeleteProductServlet?productId=${product.productId}"><i class="fa fa-close" style="font-size: 20px;" title="Delete"></i></a>
                      </td>
                    </tr>  
                </c:forEach>

              </tbody>
            </table>
          </div>
        </div>
    </div>
        </div>
    </div>
            
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <!--footer-->
    <%@include file="/footer.jsp" %>
    
  </div>
</body>

</html>

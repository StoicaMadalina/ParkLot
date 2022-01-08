<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Add Photo">
  <jsp:useBean id="car" scope="request" type="com.park.parkinglot.common.CarDetails"/>

  <h1>Add Photo</h1>

  <form action="${pageContext.request.contextPath}/AddPhoto" method="POST" enctype="multipart/form-data"
        novalidate class="needs-validation">
    <div class="row">
      <div class="col-md-6 mb-3">License plate: ${car.licensePlate}</div>
    </div>
    <div class="row">
      <div>
        <div>
          <label for="file">Photo</label>
          <input type="file" name="file" required>
          <div class="invalid-feedback">Photo is required</div>
        </div>
      </div>
    </div>
    <input type="hidden" name="car_id" value="${car.id}">
    <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
  </form>

</t:pageTemplate>
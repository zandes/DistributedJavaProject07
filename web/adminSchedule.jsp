<%--
  Created by IntelliJ IDEA.
  User: Zach
  Date: 11/19/2018
  Time: 12:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Schedule</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>
    <link href="site.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <ul class="nav navbar-nav">
        <li class="nav-item">
            <a href="index.jsp" class="nav-link">Home</a>
        </li>
        <li class="nav-item">
            <a href="eventSchedule" class="nav-link">Schedule</a>
        </li>
    </ul>
</nav>

${deleteNum}
<div class="container" style="padding-top: 70px;">
    <c:forEach items="${events}" var="event" varStatus="status">

        <div class="row">
            <div class="col"></div>
            <div class="col-md-auto">
                    ${event.eventName}
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-md-auto">
                    ${event.eventDesc}
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-md-auto">
                    ${event.eventTime}
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-md-auto">
                <input type="button" class="btn btn-default" id=${status.count} value="Edit">
            </div>
            <div class="col-md-auto">
                <form action="schedule" method="post">
                    <button type="submit" class="btn btn-warn" value=${status.count} name="delete">Delete</button>
                </form>
            </div>
            <div class="col"></div>
        </div>
        <br>

    </c:forEach>
    <div class="row">
        <div class="col"></div>
        <div class="col-md-auto">

        </div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col"></div>
        <div class="col-md-8">
            <form action="schedule" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Event Name" name="name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Event Description" name="desc">
                </div>
                <div class="form-group">
                    <input type="time" class="form-control" placeholder="Event Time" name="time">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>
</body>
</html>

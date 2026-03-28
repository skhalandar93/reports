<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reports Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h3 class="mb-4 text-primary">Reports Application</h3>

    <div class="card shadow-sm p-4 mb-4">
        <form:form action="search" modelAttribute="search" method="POST">
            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Plan Name:</label>
                    <form:select path="planName" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}" />
                    </form:select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Plan Status:</label>
                    <form:select path="planStatus" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}" />
                    </form:select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Gender:</label>
                    <form:select path="gender" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label" for="startDate">Start Date:</label>
                    <form:input path="startDate" type="date" cssClass="form-control" id="startDate"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label" for="endDate">End Date:</label>
                    <form:input path="endDate" type="date" cssClass="form-control" id="endDate"/>
                </div>
                <div class="col-md-4 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary me-2">Search</button>
                    <a href="reset" class="btn btn-secondary">Reset</a>
                </div>
            </div>
        </form:form>
    </div>

    <div class="card shadow-sm p-3">
        <form:form action="plans" modelAttribute="plans" method="POST">
            <table class="table table-bordered table-striped table-hover text-center">
                <thead class="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Holder Name</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Plan Name</th>
                    <th scope="col">Plan Status</th>
                    <th scope="col">Start Date</th>
                    <th scope="col">End Date</th>
                    <th scope="col">Amount</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty plans}">
                    <tr>
                        <td colspan="8" class="text-center text-danger">No record found</td>
                    </tr>
                </c:if>

                <c:forEach var="plan" items="${plans}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${plan.citizenName}</td>
                        <td>${plan.gender}</td>
                        <td>${plan.planName}</td>
                        <td>${plan.planStatus}</td>
                        <td>${plan.planStartDate}</td>
                        <td>${plan.planEndDate}</td>
                        <td>${plan.benfitAmt}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form:form>
    </div>

    <div class="mt-3">
        <strong>Export :</strong> 
        <a href="E-Mail" class="btn btn-outline-primary btn-sm ms-2">E-Mail</a>
        <a href="PDF" class="btn btn-outline-danger btn-sm ms-2">PDF</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

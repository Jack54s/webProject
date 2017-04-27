<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/27
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.redweb.jstl.bean.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    List<Person> personList = new ArrayList<Person>();

    int i = 1;

    Person person = new Person();
    person.setId(i++);
    person.setName("张三");
    person.setAge(20);
    person.setSex("男");
    person.setAddress("北京市海淀区上地软件园");
    person.setBirthday("2008-08-08");
    person.setMobile("13820080808");
    person.setTelephone("69653234");
    person.setCity("北京");

    personList.add(person);

    Person person2 = new Person();
    person2.setId(i++);
    person2.setName("李四");
    person2.setAge(20);
    person2.setSex("男");
    person2.setAddress("北京市东皇城根锡拉胡同");
    person2.setBirthday("2008-01-01");
    person2.setMobile("13820080808");
    person2.setTelephone("20054879");
    person2.setCity("北京");

    personList.add(person2);

    Person person3 = new Person();
    person3.setId(i++);
    person3.setName("王五");
    person3.setAge(20);
    person3.setSex("男");
    person3.setAddress("北京市东皇城根锡拉胡同");
    person3.setBirthday("2008-01-01");
    person3.setMobile("13820080808");
    person3.setTelephone("20054879");
    person3.setCity("北京");

    personList.add(person3);

    Person person4 = new Person();
    person4.setId(i++);
    person4.setName("王二麻子");
    person4.setAge(20);
    person4.setSex("男");
    person4.setAddress("北京市东皇城根锡拉胡同");
    person4.setBirthday("2008-01-01");
    person4.setMobile("13820080808");
    person4.setTelephone("20054879");
    person4.setCity("北京");

    personList.add(person4);

    request.setAttribute("personList", personList);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr class="title">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>城市</td>
        <td>地址</td>
        <td>生日</td>
        <td>手机</td>
        <td>电话</td>
    </tr>

    <c:forEach items="${ personList }" var="person">

        <tr>
            <td>${ person.id }</td>
            <td>${ person.name }</td>
            <td>${ person.age }</td>
            <td>${ person.sex }</td>
            <td>${ person.city }</td>
            <td>${ person.address }</td>
            <td>${ person.birthday }</td>
            <td>${ person.mobile }</td>
            <td>${ person.telephone }</td>
        </tr>

    </c:forEach>

</table>

<br/>
<br/>
<br/>

<table>
    <tr class="title">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>城市</td>
        <td>地址</td>
        <td>生日</td>
        <td>手机</td>
        <td>电话</td>
    </tr>

    <c:forEach items="${ personList }" var="person" varStatus="varStatus">

        <tr bgcolor="${ varStatus.index % 2 == 1 ? '#EFEFEF' : '#FFFFFF' }">
            <td>${ varStatus.current.id }</td>
            <td>${ varStatus.current.name }</td>
            <td>${ varStatus.current.age }</td>
            <td>${ varStatus.current.sex }</td>
            <td>${ varStatus.current.city }</td>
            <td>${ varStatus.current.address }</td>
            <td>${ varStatus.current.birthday }</td>
            <td>${ varStatus.current.mobile }</td>
            <td>${ varStatus.current.telephone }</td>
        </tr>

    </c:forEach>

</table>
<br>
<table>
    <tr>
        <td class="header">Header Name</td>
        <td class="header">Header Value</td>
    </tr>
    <c:forEach var="item" items="${header}" varStatus="varStatus">
        <tr>
            <td bgcolor="${varStatus.index % 2 == 0 ? '#eee' : '#fff'}">${item.key}</td>
            <td bgcolor="${varStatus.index % 2 == 0 ? '#eee' : '#fff'}">${item.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

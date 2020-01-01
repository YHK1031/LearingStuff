# ORM(Object-relaptional mapping)
<ul>
<li>ORM does the mapping of an object to a data in database.
<li>It helps to manipulate database more intuitively than using query.
<li>It is based on object and Relational-Database.
</ul>

# JPA(Java Persistence API)
<ul>
<li>JAVA ORM stadard.
<li>JPA works between JAVA application and JDBC.
<li>It is a concept that can be used by framework and so on...
<li>Hibernate, EclipseLink, DataNucleus are frameworks that supports JPA.
</ul>

### Adavantages of using JPA
<ol>
<li>Development more focused on object-oriented rather than SQL.
  <ul>
  <li>Difference in paradigm cause problems
  <li>Inheritance requires dissection of an object saving data.
  <li>Need to join tables when loading data.(Since data of object is scattered in multiple tables)
  <li>Modeling can be focused on object rather than table.
  <li>Data obtained by using JPA is more reliable than using DAO developed by some other developer.
  
  </ul>
<li>Improvement of productivity. Simpler form of CRUD and easy update.
<li>Easier maintenance. Change in field does not require change in SQL. Just adding field solves problem.
</ol>

# Connection Pool

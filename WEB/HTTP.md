# HTTP
## HTTP is Hyper Text Transfer Protocol. It is a protocol in transfering data in web.<br><br>
HTTP request message consist of three parts.<br>
<ul>
  <li>First, Start line containing http method, address, and http version.</li>
  <li>Second, a block of headers containing attributes of the request.</li>
  <li>Third, an optional body containing data.</li>
</ul>
<br>
HTTP response message also consist of three parts.<br>
<ul>
  <li>First, Start line containing version, status code, and status message.</li>
  <li>Second, a block of headers containing attributes of the response.</li>
  <li>Third, an optional body containing data. This data helps rendering the screen.</li>
</ul>

## What is <Strong>HTTP method</Strong>?
HTTP method is sent along with address in request.<br>
The common http methods are <Strong>GET, POST, PUT, PATCH, DELETE</Strong>.<br>
(PUT replace original version of the resource, PATCH is modify the resource)<br>
Considering address as resource and method as verb is <Strong>REST</Strong>.

## Difference between GET and POST method
Difference between GET and POST method in sending request is,<br>
<ul>
  <li>Data is contained in the body in POST method.</li>
  <li>Data is added at the end of the address in GET method.</li>
</ul>

## HTTP state code

### 1XX
Shows the information.<br>

### 2XX
Represents success.<br>

### 3XX
Represents redirection.<br>

### 4XX
Represents client error.<br>

### 5XX
Represents server error.<br>

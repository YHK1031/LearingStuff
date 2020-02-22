# Cookie
Cookie is stored in client's browser. It is a text data file included in http header.("string" datatype)<br>
It maintains even after browser is closed. Erased after certain life cycle.<br>
It is less secure than session since it is stored in client's computer.

## Transfering cookie
<ol>
  <li>Client request for cookie since there are none at first</li>
  <li>Server finds out there are no cookie in Request Header. Then response with cookie contains connection state.</li>
  <li>The browser of the client receive the cookie</li>
  <li>Cookie would be added in the header of HTTP from the second request.</li>
</ol>

## Characteristics
<ul>
  <li>Client can add up to 300 cookies</li>
  <li>20 cookies can be added on each domain. After 20, least used one would be erased</li>
  <li>Each cookie can save up to 4KB</li>
</ul>
<br><br>

# Session
It is a cookie saved in server side. Usually contains important data.<br>
It maintains until browser is closed. Erased after closing browser<br>
It is more secure than cookie since it is saved in server instead of local.

## Session communication
<ol>
  <li>Issue the session ID when client access the server</li>
  <li>Server saves the cookie using the session ID in previous step</li>
  <li>Client sends session ID when access the server later on</li>
  <li>Server distinguish the client by the session ID of the cookie in Request header</li>
</ol>

For the security reason, comparing ip of the admin as well as the session ID would be recommended.
<br><br><br>

# Cache
Unlike cookie and session, it contains resource files like images, videos, CSS, JS, and so on instead of user data.<br>
It helps rendering speed since it doesn't need to re-access the server for resources.
<ul>
  <li>Cache hit : Data exists in the cache when CPU access for it</li>
  <li>Cache miss : Data does not exist in the cache when CPU access for it</li>
</ul>

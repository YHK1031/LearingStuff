# ModelAttribute Annotation
<Strong>@ModelAttribute</Strong> is used to bind a model parameter or inject data.
### When used in method
~~~JAVA
@ModelAttribute("firstNameGet")
public String gettingFirstName(String firstName){
      return firstName;
}
~~~
It injects data so that it can be used in JSP.

### When used in parameter
~~~java
public String processForm(@ModelAttribute("student") Student theStudent) {
      return "student-confirmation";
}
~~~
It binds the object handed over from http request to the model. Now attributes of the model can be used in JSP.<br> (<Strong>${student.firstName}</Strong>)

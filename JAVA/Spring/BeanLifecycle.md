# Process of bean generation
```
1. Construct an instance of class
2. Inject dependencies
3. Set properties etc(@Value)
```
Errors such as an null pointer exception can be cause due to the bean creation process shown above.</br>
<Strong>@PostConstruct</Strong> can be helpful for dodging the potential error. </br>
<Strong>@PreDestroy</Strong> executes before the object(bean) is destroyed while <Strong>@PostConstruct</Strong> executes after number three above(Set properties etc(@Value)).
</br>
```
In contrast to the other scopes, Spring does not manage the complete lifecycle of aprototype bean
```
</br>
So that <Strong>@PreDestroy</Strong> is not called in <Strong>prototype</Strong> scope!

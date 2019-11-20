# IoC(Inversion of Control)
Literally, the control is inversed.</br>
Spring container contructs and manages the object.(eg. life cycle) </br>
Developer would not use <String>new</Strong> to create object. Instead, the container do it for developer!

# DI(Dependency Injection)
IoC can be achieved by DI. DI can be seen as one of the methods for Ioc. </br>
Annotation or xml is used as a method to inject dependency.</br>
Container controls the flow by scanning through codes making dependencies between beans!

```
IoC is tightly coupled with the concept of Interface from my point of view.
Objects that share same interface can be modified causing much less change in other codes.
It is usefulness for maintenance of codes.
```

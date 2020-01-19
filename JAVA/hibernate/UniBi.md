# Uni-directional
Linked in one way so that any operations like delete can be done in one direction. <br>
<Strong>@OneToOne</Strong> annotation is applied to only one entity. <br>
And <Strong>@JoinColumn</Strong> is applied on a property. It finds <Strong>FK(foreign key)</Strong> from the table which can be found by the return type of the method.
```Java
public class First{
  @OneToOne
  @JoinColumn(name="columnName")
  private Second second
}
```

# Bi-directional
Linked in two way. In cascade operation, deleting one row cause deleting a linked row(or rows) on other table <br>
<Strong>@OneToOne</Strong> annotation is applied to another entity. <br>
And <Strong>mappedBy</Strong> is used inside of the mapping annotation with property name of the other column.<br>
```Java
public class Second{
  @OneToOne(mappedBy="second")
  private First first
}
```
### Notes
It is important to setting the relationship one to another when using Bi-directional relationship.<br>
Column with <Strong>mappedBy</Strong> will automatically associate with other column but the one with <Strong>@JoinColumn</Strong> will not.<br>
Therefore, association is needed for property with <Strong>@JoinColumn</Strong>.

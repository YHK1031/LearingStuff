# Uni-directional
Linked in one way so that any operations like delete can be done in one direction. <br>
<Strong>@OneToOne</Strong> annotation is applied to only one entity. <br>
And <Strong>@JoinColumn</Strong> is applied on a property. It finds <Strong>FK(foreign key)</Strong> from the table which can be found by the return type of the method.

# Bi-directional
Linked in two way. In cascade operation, deleting one row cause deleting a linked row(or rows) on other table <br>
<Strong>@OneToOne</Strong> annotation is applied to two or more entities. <br>
And <Strong>mappedBy</Strong> is used inside of the mapping annotation. (eg)@OneToOne(mappedBy=propertyName) <br>
It tells hibernate to find property of given property name from the table which can be found by the return type of the method.
Then, information from <Strong>@JoinColumn</Strong> is used.

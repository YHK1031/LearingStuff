# How to "deep copy"
It seems like there are three options
1. Object.assign()
2. Spread method
3. JSON.parse and JSON.stringify
4. _.cloneDeep(value) from lodash

First and second one does only shallow copy. 
Third one is possible but there is a function in object.
Fourth one actually DEEP COPY!!

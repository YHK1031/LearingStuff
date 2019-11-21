# 3 ways of configuring Spring container

```
1. Full XML Config
2. XML Component Scan
3. Java Configuration Class
```

1. Use <Strong>ClassPathXmlApplicationContext</Strong> to add XML file. On XML file, beans and dependencies are defined.
2. Also use <Strong>ClassPathXmlApplicationContext</Strong> to add XML file.</br>
However, instead of defining beans and dependencies inside XML file, only entry(context:component-scan) to enable component scanning is added inside of XML file.</br>
Beans and dependencies defined automatically just by adding @Component or @Autowired since the container do the scanning.

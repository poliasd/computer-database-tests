# Play sample application — Computer database Tests

### Required Software to execute the tests
* Java: Version Java 1.8
* Gradle
* Browsers: Firefox or Chrome

### Running the tests

In order to run the tests with default setting (bowser: chrome) and all the set of tests execute:

```
 gradle test
```

To run the tests with specific browser (chrome or firefox) with a specific tag execute:

```
 gradle test -DBROWSER={browser} -Dcucumber.options="{--tags @Regression}"
```

The report will be generated at build/reports/tests/index.html

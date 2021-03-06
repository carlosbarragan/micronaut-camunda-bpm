# FAQ

## Development
### Why did you not implement the extension with Kotlin?
If implemented with Kotlin we'd need to bundle the Kotlin runtime libraries which would increase the size. Therefore we stay with Java. However, this does not prevent you from implementing your application with Kotlin and still use this extension.

### Why are you not using Lombok?
We're not depending on the Lombok to simplify the setup of the development environment - otherwise this would require a plugin for the IDE.

### What about warnings regarding illegal reflective access operations?
When starting the application you will see:
```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.ibatis.reflection.Reflector (file:/home/tos/.m2/repository/org/mybatis/mybatis/3.4.4/mybatis-3.4.4.jar) to method java.lang.Object.finalize()
WARNING: Please consider reporting this to the maintainers of org.apache.ibatis.reflection.Reflector
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```
This warning is shown when using JDK 9 and later. It will need to be fixed by MyBatis.


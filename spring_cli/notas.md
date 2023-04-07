spring init --dependencies=web,data-jpa,thymeleaf --build maven --extract --name myproject --groupId=com.example --artifactId=myproject


pero si no quiero que me extraiga, es 
spring init --dependencies=web,data-jpa,thymeleaf --build maven --groupId=com.example --artifactId=myproject --name=myproject


---


Para agregar más dependencias a la plantilla de proyecto Spring Boot que estás generando con el comando spring init, simplemente agrégalas separadas por comas después de la opción --dependencies.

Por ejemplo, si quisieras agregar las dependencias web, data-jpa y thymeleaf, ejecutarías el siguiente comando:

kotlin

    spring init --dependencies=web,data-jpa,thymeleaf myproject

Para especificar la versión de Java que quieres utilizar, puedes utilizar la opción --java-version. Por ejemplo, si quieres utilizar Java 11, puedes agregar la opción --java-version=11 a tu comando:

css

    spring init --dependencies=web,data-jpa,thymeleaf --java-version=11 myproject

Ten en cuenta que Spring Boot 2.x.x requiere al menos Java 8, pero puede ser compatible con versiones posteriores de Java. Si no especificas una versión de Java, se utilizará la versión predeterminada del sistema.


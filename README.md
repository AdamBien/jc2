# jc2
JCache Configurator for Java EE 7

## Installation

```xml
<dependency>
  <groupId>com.airhacks</groupId>
  <artifactId>jc2</artifactId>
  <version>0.0.2</version>
</dependency>
```

## Usage

```java
package com.airhacks.jc2.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @Inject
    String greeting;
    
	@GET
    public String hello() {
        return greeting;
    }

}
```

The key `com.airhacks.jc2.boundary.HelloResource.greeting` is resolved in the cache named: `configuration`

## Customization

An initial set of value can be preloaded and merged by exposing a `Map<String,String>` like e.g.:

```java
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Produces;

public class InitialConfiguration {

    @Produces
    public Map<String, String> get() {
        Map<String, String> cache = new HashMap<>();
        cache.put("com.airhacks.jc2.boundary.HelloResource.greeting", "hey duke");
        return cache;
    }
}
```

## Administration

[headlands](https://github.com/AdamBien/headlands) exposes JCache API as a REST service and also uses Hazelcast as an SPI. Deploy headlands and use the cache with the name `configuration` to maintain the contents.

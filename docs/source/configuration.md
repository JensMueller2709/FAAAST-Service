# Configuration
This section gives a short introduction how the configuration file works.

The basic structure of a configuration is the following
```json
{
	"core" : {
		"requestHandlerThreadPoolSize" : [integer]
	},
	"endpoints" : [
		// endpoint configurations, multiple allowed
	],
	"persistence" : {
		// persistence configuration
	},
	"messageBus" : {
		// message bus configuration
	},
	"assetConnections": [
		// asset connection configurations, multiple allowed
	]
}
```
As FA³ST is designed to be easily extendable, the configuration supports to change the used implementation for any of those interfaces without the need to change or recompile the code.
To tell the Service which implementation of an interface to use, each dynamically configurable configuration block contains the `@class` node specifying the fully qualified name of the implementation class. Each block then contains additionals nodes as defined by the configuration class associated with the implementation class.
For example, the `HttpEndpoint` defines the property `port` in its configuration class ([HttpEndpointConfig.java#L23](https://github.com/FraunhoferIOSB/FAAAST-Service/blob/main/endpoint/http/src/main/java/de/fraunhofer/iosb/ilt/faaast/service/endpoint/http/HttpEndpointConfig.java#L23)).
Therefore, the configuration block for a `HttpEndpoint` on port 8080 would look like this:
```json
{
	"@class" : "de.fraunhofer.iosb.ilt.faaast.service.endpoint.http.HttpEndpoint",
	"port" : 8080
}
```

A simple example configuration could look like this:

```json
{
	"core" : {
		"requestHandlerThreadPoolSize" : 2
	},
	"endpoints" : [ {
		"@class" : "de.fraunhofer.iosb.ilt.faaast.service.endpoint.http.HttpEndpoint",
		"port" : 8080
	} ],
	"persistence" : {
		"@class" : "de.fraunhofer.iosb.ilt.faaast.service.persistence.memory.PersistenceInMemory"
	},
	"messageBus" : {
		"@class" : "de.fraunhofer.iosb.ilt.faaast.service.messagebus.internal.MessageBusInternal"
	}
}
```
Each implementation should provide documentation about supported configuration parameters.
When using FA³ST Service from your code instead of running it in standalone mode, you can also create the configuration file manually like this:

```java
ServiceConfig serviceConfig = new ServiceConfig.Builder()
	.core(new CoreConfig.Builder()
			.requestHandlerThreadPoolSize(2)
			.build())
	.persistence(new PersistenceInMemoryConfig())
	.endpoint(new HttpEndpointConfig())
	.messageBus(new MessageBusInternalConfig())
	.build());
```

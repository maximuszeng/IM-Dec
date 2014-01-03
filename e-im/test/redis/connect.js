var redis = require("redis"), client = redis.createClient(6379, '127.0.0.1');

client.on("error", function(err) {
	console.log("Error " + err);
});

// Set a value
//client.set("string key", "Hello World", redis.print);

// Get the value back
client.get("string key", function(err, reply) {
	console.log(reply.toString());
});

// Clean quit (waits for client to finish)
client.quit();
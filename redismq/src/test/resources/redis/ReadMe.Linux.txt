Installation
Download, extract and compile Redis with:

$ wget http://download.redis.io/releases/redis-2.8.2.tar.gz
$ tar xzf redis-2.8.2.tar.gz
$ cd redis-2.8.2
$ make

The binaries that are now compiled are available in the src directory. Run Redis with:

$ src/redis-server

You can interact with Redis using the built-in client:

$ src/redis-cli
redis> set foo bar
OK
redis> get foo
"bar"

Where's Redis Cluster?
Redis Cluster, the distributed version of Redis, is making a lot of progresses and you can find a 
full implementation in the unstable branch at Github. It will be released as a release candidate 
at the end of 2013. You can watch a video about what Redis Cluster can currently do.
http://vimeo.com/63672368

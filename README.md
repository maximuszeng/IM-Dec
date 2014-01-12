## E-IM

# E-IM standards for Enterprise Instant Message, it's include Online Customer Service(SaaS), based following technology
* node.js
* socket.io
* redis
* bootstrap


## Development Environment:
1. Eclipse 4.2+
2. Eclipse plugin :
   * EGit  
   * Nodeclipse
   * m2e
   * Google Chrome Developer Tools
3. MySQL 5.6+
4. Node.js
5. Redis
6. redis-commander

## Local Environment Install Step:
* Step 1, <code>MYSQL</code>
1. Create database schema named <code>eim</code>, and <code>root</code> 's password is <code>password</code>
2. Execute following script : 
   * <code>/persist/sql/mysql/base.sql</code>
   * <code>/persist/sql/mysql/tag.sql</code>
   
* Step 2, <code>Maven</code>
1. Execute command <code>mvn clean compile package install</code> in <code>parent</code> project, to install lib in local maven repository.

* Step 3, <code>Redis</code>
1. In windows os, redis's executable <code>exe</code> files in <code>/redismq/src/test/resources/redis</code>, 
choose <code>win32</code> or <code>win64</code> subfolder depend on your os
2. Enter the folder, start redis with this command : <code>redis-server.exe redis.conf</code>
3. Execute following <code>junit test case</code> to fill mysql data in order:
   * <code>com.eim.service.base.impl.UserServiceTest</code>
   * <code>com.eim.service.base.impl.ApplicationServiceTest</code>
4. Execute following <code>junit test case</code> to fill redis data in order:
   * <code>com.eim.service.redis.base.OperatorTest</code>
   * <code>com.eim.service.redis.base.SequenceOperatorTest</code>

* Step 4, <code>imagemagick</code>
1. Install <code>imagemagick</code> in your os. http://www.imagemagick.org

* Step 5, <code>Node</code>
1. Execute <code>npm install bower -g</code> to install <code>bower</code>
1. Execute <code>npm install</code> in <code>e-im</code> directory to collect <code>node_modules</code>
2. Execute <code>bower install</code> in <code>e-im</code> directory to collect <code>public/libs</code>
3. Execute <code>node app.js</code> in <code>e-im</code> directory to start app

* Step 6, Access <code>http://localhost:3000</code>


## Installing
Build (binary file will be placed in **target** directory):
```bash
mvn clean compile assembly:single
```

Run (will ask you for working mode):
```bash
mvn exec:java
```

## Usage
Both server and client are in **chatsocket-x.y-SNAPSHOT-jar-with-dependencies.jar** (to get this jar file you need to build this project).
1. Server app: `java -jar chatsocket.jar --mode=server`
2. Client app: `java -jar chatsocket.jar --mode=client`

App settings will be saved in **app.json** file
```json
{
  "modified" : 1615911198333,
  "settings" : [ {
    "key" : "server",
    "data" : {
      "ip" : "127.0.0.1",
      "port" : 11111
    }
  }, {
    "key" : "client",
    "data" : {
      "serverIp" : "127.0.0.1",
      "serverPort" : 11111,
      "loggedUserName" : "huyduong"
    }
  } ]
}
``` 

### Server
The server needs to listen to an IP and a port number, other clients will connect to this address.
Fill up these boxes and click on **Start** button to start the server.

![](https://1.bp.blogspot.com/-kB7oA2W7bcc/WzcodYjgBtI/AAAAAAAAVOs/JBM-hmbCSoE9aWaZYSl77k0C0Ggm-kkZgCLcBGAs/s1600/server.PNG)

All users data will be saved in **user.json** file.
```json
[ {
  "id" : "d70b0d72083a4feaa2c3acd9f73125f5",
  "username" : "huyduong",
  "passwordHash" : "b0f8035c8ff795d5434c8b50d282d3c4a59b5f1d",
  "profile" : {
    "displayName" : "huyduong",
    "status" : null
  }
}, {
  "id" : "9ba71e3e42ec43f7a443ecccb577ffef",
  "username" : "huyduong1",
  "passwordHash" : "87b488287328def1a49e4081e3c54c56fff6381b",
  "profile" : {
    "displayName" : "huyduong1",
    "status" : "dang ngu"
  }
} ]
```
### Client
1. Connect to the server.

2. Then login with your account

3. Or register a new one.

4. Other users will be shown in your friend list.

5. To update your userProfile, double-click to the avatar.

6. Double-click to any online friend to chat

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## Author
Developed by team dev at15c kma
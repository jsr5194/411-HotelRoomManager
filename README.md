# 411-HotelRoomManager

Requirements
---------------------------
Mandatory Requirements for Full Credit:<br>
1. The system must be networked with a reasonable user interface for users. This user interface doesn't need to be fancy or complex – it can even be a <br>completely command-line system. But if you are expecting user input, you must lay this out in a way that makes it very clear what a user should input and how to do it.<br>
2. The system must be of some practical use to some user group, which needs to be specified clearly.<br>
3. The system must be multi-user and implement concurrent threads as an important part of the functionality of the system.<br>
4. The system must have important critical sections which require thread safety, and must not deadlock even when subjected to large numbers of concurrent transactions.<br>
5. The base language must be Java, use Java network sockets, and must be able to be compiled and run from the Java command line.<br>
6. There must be a Java-based system for data persistence – in other words a text-file, database, or some othermechanism (e.g., XML) where user and possibly other data can be stored and retrieved for later use.<br>
7. You may use external libraries IF and ONLY IF you reference where you got them, with the proviso that the code you write must satisfy the above requirements. In other words, you may not use external library code to satisfy the basic system requirements given in 1-6 above. For example, it is fine to use a JDBC driver to deal with a database, but you must write the database calls yourself. For another example, it is fine to use a graphics engine to render complex graphics if you need them, but any code you submit to use this graphics engine must be your own.<br>

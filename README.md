# 411-HotelRoomManager

How to Start: Server
--------------------------
Run the program with one command line arg to represent port. <br>
Remember to select a port number outside the reserved range<br>

Common Usage:<br>
java ReservationServer [PORT]<br>
<br><br>
Example:<br>
java ReservationServer 12345<br>



How to Start: Client
--------------------------
Run the program with two command line args to represent server ip and port. 
Remember to select the port number that the server is listening on<br>

Common Usage:<br>
java ReservationClient [SERVER_IP] [PORT]<br>
<br><br>
Example:<br>
java ReservationClient 127.0.0.1 12345<br>


How to Operate: Client
--------------------------
There are a few commands that can be run at this time to retrieve or
update information in the hotel. They are explained below. To run any command,
simply type the specified command and any necessary arguments into the client.
NOTE: All commands will start with a slash (/)<br>

Command: 		/displayrooms<br>
Description: 	This command will print out all of the rooms in the hotel
				along with their current availibility<br>

Command: 		/buildguest [FIRST_NAME] [LAST_NAME] [PHONE] [EMAIL]<br>
Description: 	This command will create a new guest object on the hotel<br>

Command: 		/toggleroomstate [ROOM_NUMBER] [AVAILIBILITY_BOOL] [RESERVER_EMAIL] [CHECK_IN_DATE] [CHECK_OUT_DATE]<br>
Description: 	This command will update the availibility status of a specified
				room. It requires two paramaters. The first is the room number
				that will be changed. The second is a boolean (spelled in 
				agreement with java spec) which will set the availibility of the 
				room. <br>
				true	==	availible<br>
				false	==	occupied<br>


Requirements
---------------------------
Mandatory Requirements for Full Credit:<br>

1. The system must be networked with a reasonable user interface for users. This user interface doesn't need to be fancy or complex – it can even be a <br>completely command-line system. But if you are expecting user input, you must lay this out in a way that makes it very clear what a user should input and how to do it.

2. The system must be of some practical use to some user group, which needs to be specified clearly.<br>

3. The system must be multi-user and implement concurrent threads as an important part of the functionality of the system.<br>

4. The system must have important critical sections which require thread safety, and must not deadlock even when subjected to large numbers of concurrent transactions.<br>

5. The base language must be Java, use Java network sockets, and must be able to be compiled and run from the Java command line.<br>

6. There must be a Java-based system for data persistence – in other words a text-file, database, or some othermechanism (e.g., XML) where user and possibly other data can be stored and retrieved for later use.<br>

7. You may use external libraries IF and ONLY IF you reference where you got them, with the proviso that the code you write must satisfy the above requirements. In other words, you may not use external library code to satisfy the basic system requirements given in 1-6 above. For example, it is fine to use a JDBC driver to deal with a database, but you must write the database calls yourself. For another example, it is fine to use a graphics engine to render complex graphics if you need them, but any code you submit to use this graphics engine must be your own.<br>

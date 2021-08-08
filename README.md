
Hello Everyone. I created an application that is old time communication phone which had keys by using java FXML and JAXB. 

Server : 

This is server we write number and create a phone.

Features:
- Can be seen the phones which are created.
- Can be seen the phones are active or inactive
- Phones can be activate or inactive  by server  : if phone can be reached then it has green circle, else it has black circle.
- if phone is busy (for example phone is calling someone) : it has red circle

![server.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/server.png) 

Phone :

This is a phone which is created as being has number  "1".
NOTE :  Phone number is added to phone frame's title;
Can be divided as two parts  like screen (red  line and has menu) and keys buttons).

Features: 
- Have to press "Ʌ" to move up or press "V" to move down.
- If wanted to write any character which is on buttons to textfield then have to press same button as character's index value times. Within every press time is reseted to 1.5 second.
 <br/>(Actually index is started by 0  but I dont know how to name it so I wrote that. I am sorry if it makes you confusing)
 
![phone.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/phone.png) 


*Let's Learn What Can We Do In This Project: 
-) When we run the project , two phones are created as "1" and "2".
-) "1" phone's screen  is MainMenuScreen.
-) When we go through  "Contact" from MainMenuScreen then we can see screen as "2" phone's screen which is ContactScreen.

![1.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/3.png)



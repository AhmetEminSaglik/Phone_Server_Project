
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


- Let's Learn What Can We Do In This Project: 
- When we run the project , two phones are created as "1" and "2".
- "1" phone's screen  is MainMenuScreen.
- When we go through  "Contact" from MainMenuScreen then we can see screen as "2" phone's screen which is ContactScreen.

![1.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/1.png)


-When we go through to "Registered Number" in "2" phone it is empty. We did not add any number. Then Let's go "Add Number"  in "1" phone
![2.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/2.png)

- We see "Name", "Surname" and "Phone No". I wrote some informations to here. 
- By the way Phone No texfield just can be wrote numbers,
- When we press the button which is under "Select" writing then it is saved.
- 
![3.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/3.png)

- Now "1" phone has 1 contact in ContactScreen, "2" phone has not any contact in ContactScreen.
![4.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/4.png)

- When we go through registered contact ( which seen as "AHMET EMIN SAGLIK") then we can see there are 2 options like following image.
- We can press  (green)"---" or button which is under "Select" writing. Both of them call the contact.

![5.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/5.png)

- Top Label : If contact is registered then it is seen how contact's name was registered. Otherwise is seen phone number.
- Bottom Label : describes the action.
- And we hear a  voice from the phone which is dialed.
![6.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/6.png)



- If Dialed phone press the "(green)---" then communication starts. 
- Middle Label : Total communication time is wrote.
![7.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/7.png)


- If One of the phones which have in call,  press "(red)---" then call is over.


![8.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/8.png)


-Now it is time to look call history. So We go through "Call" option which is in MainMenuScreen.

![9.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/9.png)


- There are some different symbol and their explanations in the following lines :
-   ">>"  : I called 
-   "<<"  : I am dialed
-   "✓"  : Connection was succesfull;
-   "X"  : Connection was failed; (Well this is not shown right now but we may see in future images.)
-    And call time is seen there.
![10.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/10.png)


- Now it is time to see other option in RegisteredContactScreen options.
- We go through the "Text" option in "1" phone.
![11.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/11.png)


- "To Whome" part is filled automatic because try to do something  with contact which is added as this name. And we can not change it.
- I wrote a message that is "HELLO AHMET. HOW ARE YOU?".
- Now we press to  button which is under "Send" writing. 
- And we hear a message voice from phone which received a message.
![12.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/12.png)


- Now we look "Sent Messages" option from the "1" phone which we sent message.
- Now we look "Received Messages" option from the "2" phone which we received message.
![13.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/13.png)


-We see message for both phone. "2" phone has a additional word which is "Unread" that means that  phone which received message did not see the message.

![14.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/14.png)


- Message is same in the both phone.
![15.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/15.png)

- Now se wonder as being "2" phone and want to send a message to "1"phone and learn who is it.
- Now we go through "Send Message" And filled "To Whome" part. And wrote the message text. And sent it.

![16.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/16.png)

- "1" phone received message. We will look "Received Messages" for this phone.
- "2" phone sent message. We will look "Sent Message" for this phone.
![17.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/17.png)


- As before example we saw it goes same way.
![18.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/18.png)


- And messages are same.
![19.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/19.png)

-When we go back "Unread" additional word is gone. Because we read the message.
![20.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/20.png)

-Let's have a look in xml file (I used JAXB to create xml documentation as call and message history)
![21.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/21.png)


-Let's create "3" phone  with using server.
![22.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/22.png)


-Ok. It is created. We can see it.
![23.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/23.png)


-Now it is time to call a number which is not registered. We can go through  "Call New Number" in CallScreen which can be reached by going through "Call" in MainMenuScreen.
![24.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/23.png)

-
![25.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/25.png)











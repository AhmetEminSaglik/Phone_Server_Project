<b>This application includes simple calling and messaging features of old mobile phones. And was used FXML and JAXB to create this project.</b>
<br/><br/><br/>

Hello everyone. I created an application that is old time communication phone which had keys by using java FXML and JAXB. 

<h2><b> Server :</b></h2>
This is server we write number to create phone.

<h3><b> Features :</b></h3>

- Can be seen the phones which are created.
- Can be seen the phones are active or inactive.
- Phones can be activate or inactive  by server  : if phone can be reached then it has green circle(activate), else it has black circle(inactive).
- if phone is busy (for example phone is calling someone) : it has red circle.

<br/>![server.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/server.png) 
<br/><br/>

<hr/>

<h2><b> Phone :</b></h2>
This is a phone which is created as being has number  "1".
<br/>
<b>NOTE :</b>  Phone number is added to phone frame's title.<br/>
Phone can be divided as two parts  like screen (red  line and has menu) and keys buttons).

<h3><b> Features :</b></h3>

- Have to press "Ʌ" to move up or press "V" to move down.
- If wanted to write any character which is on buttons to textfield then have to press same button as character's index value times. Within every press time is reseted to 1.5 second.
<br/>(Actually index is started by 0  but I dont know how to name it so I wrote that. I am sorry if it makes you confusing)

<br/>![phone.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/phone.png) 
<br/><br/>
<hr/>

<h3> <b>Let's Learn What Can We Do In This Project : </b></h3>
- When we run the project , two phones are created as "1" and "2".
- "1" phone's screen  is MainMenuScreen.
- When we go through  "Contact" from MainMenuScreen then we can see screen as "2" phone's screen which is ContactScreen.

<br/>![1.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/1.png)
<br/><br/>
<hr/>


- When we go through to "Registered Number" in "2" phone it is empty. We did not add any number. Then Let's go "Add Number"  in "1" phone

<br/>![2.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/2.png)
<br/><br/>
<hr/>


- We see "Name", "Surname" and "Phone No". I wrote some informations to here. 
- By the way Phone No texfield just can be wrote numbers,
- When we press the button which is under "Select" writing then it is saved.

<br/>![3.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/3.png)
<br/><br/>
<hr/>


- Now "1" phone has 1 contact in ContactScreen, "2" phone has not any contact in ContactScreen.
 
<br/>![4.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/4.png)
<br/><br/>
<hr/>


- When we go through registered contact ( which seen as "AHMET EMIN SAGLIK") then we can see there are 2 options like following image.
- We can press  (green)"---" or button which is under "Select" writing. Both of them call the contact.

<br/>![5.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/5.png)
<br/><br/>
<hr/>

- Top Label : If contact is registered then it is seen how contact's name was registered. Otherwise is seen phone number.
- Bottom Label : describes the action.
- And we hear a  voice from the phone which is dialed.

<br/>![6.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/6.png)
<br/><br/>
<hr/>

- If Dialed phone press the "(green)---" then communication starts. 
- Middle Label : Total communication time is wrote.

<br/>![7.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/7.png)
<br/><br/>
<hr/>

- If One of the phones which have in call,  press "(red)---" then call is over.

<br/>![8.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/8.png)
<br/><br/>
<hr/>


-Now it is time to look call history. So We go through "Call" option which is in MainMenuScreen.

<br/>![9.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/9.png)
<br/><br/>
<hr/>

- There are some different symbol and their explanations in the following lines :
-   ">>"  : I called 
-   "<<"  : I was dialed
-   "✓"  : Connection was succesfull;
-   "X"  : Connection was failed; (Well this is not shown right now but we may see in future images.)
-    And call time is seen there.

<br/>![10.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/10.png)
<br/><br/>
<hr/>


- Now it is time to see other option in RegisteredContactScreen options.
- We go through the "Text" option in "1" phone.

<br/>![11.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/11.png)
<br/><br/>
<hr/>


- "To Whome" part is filled automatic because try to do something  with contact which is added as this name. And we can not change it.
- I wrote a message that is "HELLO AHMET. HOW ARE YOU?".
- Now we press to  button which is under "Send" writing. 
- And we hear a message voice from phone which received a message.

<br/>![12.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/12.png)
<br/><br/>
<hr/>


- Now we look "Sent Messages" option from the "1" phone which we sent message.
- Now we look "Received Messages" option from the "2" phone which we received message.

<br/>![13.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/13.png)
<br/><br/>
<hr/>


-We see message for both phone. "2" phone has a additional word which is "Unread" that means that  phone which received message did not see the message.

<br/>![14.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/14.png)
<br/><br/>
<hr/>


- Message is same in the both phone.

<br/>![15.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/15.png)
<br/><br/>
<hr/>


- Now se wonder as being "2" phone and want to send a message to "1"phone and learn who is it.
- Now we go through "Send Message" And filled "To Whome" part. And wrote the message text. And sent it.

<br/>![16.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/16.png)
<br/><br/>
<hr/>

- "1" phone received message. We will look "Received Messages" for this phone.
- "2" phone sent message. We will look "Sent Message" for this phone.

<br/>![17.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/17.png)
<br/><br/>
<hr/>


- As before example we saw it goes same way.

<br/>![18.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/18.png)
<br/><br/>
<hr/>


- And messages are same.

<br/>![19.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/19.png)
<br/><br/>
<hr/>


- When we go back "Unread" additional word is gone. Because we read the message.

<br/>![20.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/20.png)
<br/><br/>
<hr/>


- Let's have a look in xml file (I used JAXB to create xml documentation as call and message history)

<br/>![21.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/21.png)
<br/><br/>
<hr/>


-Let's create "3" phone  with using server.

<br/>![22.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/22.png)
<br/><br/>
<hr/>


- Ok. It is created. We can see it.

<br/>![23.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/23.png)
<br/><br/>
<hr/>


- Now it is time to call a number which is not registered. We can go through  "Call New Number" in CallScreen which can be reached by going through "Call" in MainMenuScreen.

<br/>![24.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/23.png)
<br/><br/>
<hr/>


- Now we write here ("2" phone where is written as "Enter Phone Number" with gray color) phone number that we want to call. 

<br/>![25.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/25.png)
<br/><br/>
<hr/>


- Now  "1" and "2" phones is busy  with call. And we have a available phone which is "3".

<br/>![26.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/26.png)
<br/><br/>
<hr/>


- We  with using "3" phone  tried to call "2" phone  but it is failed because "2" is busy.

<br/>![27.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/27.png)
<br/><br/>
<hr/>


- We closed the "2" phone  and it can not reachable right now.

<br/>![28.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/28.png)
<br/><br/>
<hr/>

- But we as being owning of "3" phone we want to call so much "2" phone. I dont know why we are so eagerly try to call "2" phone. Maybe it is our gir/boy friend. But It is failed again. We got a feedback something like it can not reachable now. And we are sad because we could not have  any call with "2" phone. 

<br/>![29.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/29.png)
<br/><br/>
<hr/>


- Still as being owning of "3" phone we think that "Do I remember number of my lover wrong? And we call another random  number  because we got furious to  ourselves.  But there is not any number like this random we called.

<br/>![30.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/30.png)
<br/><br/>
<hr/>


- Now we created  a new phone which is "4".
- "1" and "2", "3", "4" have call between them. At the same time there can be  a lot call.

<br/>![31.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/31.png)
<br/><br/>
<hr/>


- Now it is time to see what did we do? There is a  xml documentation again. new calls is added to before ones. Every new call or message procees is written top and old ones  slide to bottom.

<br/>![32.png](https://github.com/AhmetEminSaglik/PhoneProject_2/blob/master/Images%20from%20Application/32.png)
<br/><br/>
<hr/>

Thank you for your time. I hope you enjoyed and understood what I did by reading notes or seeing images.




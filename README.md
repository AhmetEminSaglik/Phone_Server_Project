
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











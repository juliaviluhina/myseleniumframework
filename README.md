Sources are developed and published by [Automician](http://automician.com/) team

#About
This source code is an experimental simply project, showing how to build a selenium based wrapper for efficient testing of dynamic Ajax web applications. 

It simply provides an alternative implementation of Selenium’s implicit & explicit waits and PageFactory, known for their limitations:

 * selenium implicit waits can’t wait for visibility of elements, what is needed very often
 * selenium explicit waits are completely non-informative: when they fail, you usually can’t understand from the error message what happened
 * selenium PageFactory can be hardly debugged because of its “magic” implementation, is bulky in usage, and can’t create dynamic elements proxy outside of PageObject.

Of course, you don’t need to create such wrapper from scratch because it is already created for you: [selenide](http://selenide.org). 

This project is just simplified implementation to show you the core Selenide ideas, so you can:

 * understand how selenide works
 * use these ideas in your own selenium based project if for any reason you can’t use selenide
 * learn “software development in test” by examples ;)
 
This test framework was built using mainly OOP techniques. The only “non-OOP” part - is driver management - which is completely “procedural”:) So far the reason for this is - simplicity. Though soon the “OOP implementation” of driver management will be also added. If you are interested now in OOP implementation look into [nselene sources](https://github.com/yashaka/NSelene) or [custom “oop” driver for selenide](https://gist.github.com/yashaka/dc7607239518bd37298ef5eb5b08da9b) 


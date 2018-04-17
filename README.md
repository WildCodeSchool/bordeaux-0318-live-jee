# live_jee_20180410

Uses https://xkcd.com/json.html to display today's comic.

##Test with Glassfish/Payara

### JSP
Today's XKCD:
* http://localhost:8080/live-20180410/
* http://localhost:8080/live-20180410/today
* http://localhost:8080/live-20180410/xkcd

Display a range of XKCD cartoons:
* http://localhost:8080/live-20180410/xkcd/range?start=610&end=614


### JSF
* http://localhost:8080/http://localhost:8080/live-20180410/comic.jsf

#### Notes
Use Java 1.8 because Glassfish 5 doesn't start with Java9 !

Above JDK 1.8 151, you have to use Glassfish 5.0.1, and if it's unavailable for you, you shall use Payara instead
In a general manner, prefer [Payara](http://payara.fish) as it's updated more often.

On OSX, you'll *REALLY* need to have JAVA_HOME defined. Worst case scenario, you can set it in the environment variables in the Glasshfish Run/Debug configuration.

I don't know why but the war created by IntelliJ is bogus, so you can delete it from the Glassfish Run/Debug configuraiton and add a Maven goal instead (command line: `clean package`)

README.txt - MySmartUSC

Improved capabilities from Sprint 1:
1. Can now add/delete individual keywords from each filter list as opposed to having to retype entire lists each time.
2. Added start/stop listening capability so that you can toggle whether or not you would like the app to parse emails and send notifs.
3. Added case insensitivity to keyword parsing so that an email with the subject SOCCER will trigger a notif even if the keyword is soccer.
4. Improved layouts for an overall cleaner user experience.

Improved capabilities from Sprint 2:
1. Email notifications are now only sent for emails incoming after the user clicks the "Start Listening" button. Prior to this update, notifications were being sent for older emails sent up to midnight of the same day. 
2. Added error checking on all filter list form inputs. The app will reject phrases (anything that contains a space) and inform the user of bad input.
3. Fixed a problem where several of the button throughout the app were sticky and not responding on the first click.
4. Began initial step of total redesign of app layouts by changing the login screen and several small changes in the other layouts. 

Improved capabilities from Sprint 3:
1. Totaly redesign of app is complete and now offers more intuitive and aesthetic designs/ayouts. Every single layout has been completely redesigned with new color schemes and component poisitioning. 
2. Can now set notification type (intensity level) for each email filter list. For example, HIGH notification type will show additional information about the email in the notification and also show up on the lock screen.
3. All four settings pages have both a clear button and home button for easier user interface.
4. Fixed a bug where leaving a filter blank could lead to some unintended behavior.

MySmartUSC is a mobile android application that allows you to login to any gmail account and receive notifications for received emails you deem important. Users can enter keywords seperated into 4 categories for which our app will check if any incoming email contains and send an appropriate notification. The four categories are: 1) Email address of sender 2) Subject line keywords 3) Content (email body) keywords and 4) Flag keywords for which our app will mark the email as starred so that you can revisit it at a later time. 

Steps to run our application

1. Import complete project to Android Studio (version 3.0 or newer required)
2. Run app (Run > Run... > app > Select Device)
3. Connect physical device or create new virtual device
4. Make sure that device runs API Level 28 or later
5. Login using custom Gmail credentials
  5a. Make sure to turn on 2-step verification for your Gmail account
    i. Go to https://myaccount.google.com/security to turn on 2-step verification
    ii. Go to https://myaccount.google.com/apppasswords to genererate custom app password
    iii. Once in /apppasswords, click add device > other, set name to mysmartusc
    iv. Click generate, and copy 16-character password to safe location
    v. Login in using email address and custom (generated) password

Notes:

Notifications:
-Notifications should appear within 5 minutes, but can take up to 10 minutes, since the time the origianl email was sent.
-Notifications will only be given for emails that have been sent after the application has started.


Important keywords and emails:
-To view each keyword and email field, go to where the keywords and emails are changed (press the settings button, then change __ button).
-Emails sent prior to keyword changes will not trigger a notification
-Keywords will not be recognized as substrings (for example, entering the keyword "just" will not recognize an email containing the word justice)


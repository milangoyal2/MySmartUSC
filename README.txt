README.txt - MySmartUSC

Improved capabilities from Sprint 1:
1. Can now add/delete individual keywords from each filter list as opposed to having to retype entire lists each time.
2. Added start/stop listening capability so that you can toggle whether or not you would like the app to parse emails and send notifs.
3. Added case insensitivity to keyword parsing so that an email with the subject SOCCER will trigger a notif even if the keyword is soccer.
4. Improved layouts for an overall cleaner user experience.

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


Important keywords and Emails:
-To view each keyword and email field, go to where the keywords and emails are changed (press the settings button, then change __ button).
-Emails sent prior to keyword changes will not trigger a notification
-Keywords will not be recognized as substrings (for example, entering the keyword "just" will not recognize an email containing the word justice)


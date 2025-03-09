package socialMediaPlatform;

import java.util.ArrayList;
import java.util.List;

interface SocialMediaPost {
 void attach(NotificationSubscriber subscriber);
 void detach(NotificationSubscriber subscriber);
 void notifySubscribers();
}

interface NotificationSubscriber {
 void update(String postContent);
}

class InstagramPost implements SocialMediaPost {
 private List<NotificationSubscriber> subscribers = new ArrayList<>();
 private String postContent;

 public void createPost(String content) {
     this.postContent = content;
     notifySubscribers();
 }

 @Override
 public void attach(NotificationSubscriber subscriber) {
     subscribers.add(subscriber);
 }

 @Override
 public void detach(NotificationSubscriber subscriber) {
     subscribers.remove(subscriber);
 }

 @Override
 public void notifySubscribers() {
     for(NotificationSubscriber subscriber : subscribers) {
         subscriber.update(postContent);
     }
 }
}

class MobileAppNotification implements NotificationSubscriber {
 private String username;

 public MobileAppNotification(String username) {
     this.username = username;
 }

 @Override
 public void update(String postContent) {
     System.out.println("📱 Push Notification to " + username + ": New post - " + postContent);
 }
}

class EmailNotification implements NotificationSubscriber {
 private String email;

 public EmailNotification(String email) {
     this.email = email;
 }

 @Override
 public void update(String postContent) {
     System.out.println("📧 Email sent to " + email + ": New post - " + postContent);
 }
}

class WebsiteNotification implements NotificationSubscriber {
 private String userId;

 public WebsiteNotification(String userId) {
     this.userId = userId;
 }

 @Override
 public void update(String postContent) {
     System.out.println("🌐 Website notification for user " + userId + ": New post - " + postContent);
 }
}

public class SocialMediaDemo {
 public static void main(String[] args) {
     InstagramPost post = new InstagramPost();

     MobileAppNotification mobileApp = new MobileAppNotification("john_doe");
     EmailNotification email = new EmailNotification("john@example.com");
     WebsiteNotification website = new WebsiteNotification("john123");

     post.attach(mobileApp);
     post.attach(email);
     post.attach(website);

     System.out.println("Creating new post...");
     post.createPost("Check out my new vacation photos! #summer #beach");

     System.out.println("\nTurning off email notifications...");
     post.detach(email);

     System.out.println("\nCreating another post...");
     post.createPost("Having a great time! 🌊 #vacation");
 }
}
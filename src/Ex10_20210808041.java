import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Ex10_20210808041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

public class User {
    private int id;
    private String username;
    private String email;
    private Set<User> followers;
    private Set<User> following;
    private Set<Post> likedPosts;
    private Map<User, Queue<Message>> messages;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.id = hashCode();
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.likedPosts = new HashSet<>();
        this.messages = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void message(User recipient, String content) {
        if (!messages.containsKey(recipient)) {
            messages.put(recipient, new LinkedList<>());
            recipient.messages.put(this, new LinkedList<>());
        }

        Message message = new Message(this, content);
        messages.get(recipient).offer(message);
        recipient.read(this);
    }

    public void read(User user) {
        if (messages.containsKey(user)) {
            Queue<Message> messageQueue = messages.get(user);
            System.out.println("Messages from " + user.getUsername() + ":");
            for (Message message : messageQueue) {
                System.out.println(message.getContent());
            }
        } else {
            System.out.println("No messages from " + user.getUsername());
        }
    }

    public void follow(User user) {
        if (following.contains(user)) {
            following.remove(user);
            user.followers.remove(this);
        } else {
            following.add(user);
            user.followers.add(this);
        }
    }
    public void like(Post post) {
        if (likedPosts.contains(post)) {
            likedPosts.remove(post);
            post.likedBy(this,false);
        } else {
            likedPosts.add(post);
            post.likedBy(this, true);
        }
    }

    public Post post(String content) {
        return new Post(this,content);
    }

    public Comment comment(Post post, String content) {
        return new Comment(this post,content);
    }

    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj==null || getClass()!=obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return id == other.id;
    }

    public int hashCode() {
        return Objects.hash(email);
    }
}

public class Message {
    private boolean seen;
    private Date dateSent;
    private String content;
    private User sender;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
        this.dateSent = new Date();
        this.seen = false;
    }

    public String getContent() {
		return content;
	}

	public String read(User reader) {
        if (!sender.equals(reader)) {
            seen = true;
        }
        return "Sent at: " + dateSent + "\n" + content;
    }

    public boolean hasRead() {
        return seen;
    }
}

public class Post {
    private Date datePosted;
    private String content;
    private Set<User> likes;
    private Map<User, List<Comment>> comments;

    public Post(User user, String content) {
        this.content = content;
        this.datePosted = new Date();
        this.likes = new HashSet<>();
        this.comments = new HashMap<>();
      
    }

    public boolean likedBy(User user, boolean like) {
        if (like){
            return likes.add(user);
        } else {
            return likes.remove(user);
        }
    }

    public boolean commentBy(User user,Comment comment) {
        if (!comments.containsKey(user)) {
            comments.put(user, new ArrayList<>());
        }
        return comments.get(user).add(comment);
    }

    public String getContent(){
        return "Posted at: " +datePosted + "\n" + content;
    }

    public Comment getComment(User user, int index) {
        if (comments.containsKey(user)) {
            List<Comment> userComment = comments.get(user);
            if (index >= 0 && index < userComment.size()) {
                return userComment.get(index);
            }
        }
        return null;
    }

    public int getCommentCount() {
        int count = 0;
        for (List<Comment> userComment : comments.values()) {
            count += userComment.size();
        }
        return count;
    }

    public int getCommentCountByUser(User user) {
        if (comments.containsKey(user)) {
            return comments.get(user).size();
        }
        return 0;
    }
}

public class Comment extends Post {
    public Comment(User user, Post post, String content) {
        super(user, content);
        post.commentBy(user, this);
    }
}

public class SocialNetwork {
    private static Map<User, List<Post>> postsByUsers = new HashMap<>();

    public static User register(String username, String email) {
        User user = new User(username, email);
        if (!postsByUsers.containsKey(user)) {
            postsByUsers.put(user, new ArrayList<>());
            return user;
        }
        return null;
    }

    public static Post post(User user, String content) {
        if (postsByUsers.containsKey(user)) {
            return new Post(user, content);
        }
        return null;
    }

    public static User getUser(String email) {
        int hashedEmail = Objects.hash(email);
        for (User user : postsByUsers.keySet()) {
            if (user.hashCode() == hashedEmail) {
                return user;
            }
        }
        return null;
    }

    public static Set<Post> getFeed(User user) {
        Set<Post> feed = new HashSet<>();
        for (User followingUser : user.getFollowing()) {
            List<Post> posts = postsByUsers.get(followingUser);
            if (posts != null) {
                feed.addAll(posts);
            }
        }
        return feed;
    }

    public static Map<User, String> search(String keyword) {
        Map<User, String>result = new HashMap<>();
        for (User user: postsByUsers.keySet()) {
            if (user.getUsername().contains(keyword)) {
                result.put(user, user.getUsername());
            }
        }
        return result;
    }

    public static <K, V> Map<V, Set<K>> reverseMap(Map<K, V> map) {
        Map<V, Set<K>> reversedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (!reversedMap.containsKey(value)) {
                reversedMap.put(value, new HashSet<>());
            }
            reversedMap.get(value).add(key);
        }
        return reversedMap;
    }
}

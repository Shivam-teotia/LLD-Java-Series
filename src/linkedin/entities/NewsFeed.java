package linkedin.entities;

import java.util.List;

public class NewsFeed {
    private final List<Post> posts;

    public NewsFeed(List<Post> posts){
        this.posts = posts;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public List<Post> getPosts(){
        return this.posts;
    }
}

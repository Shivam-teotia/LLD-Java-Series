package linkedin.strategy;

import linkedin.entities.Post;

import java.util.List;

public interface SortingStrategy {
    List<Post> sort(List<Post> posts);
}

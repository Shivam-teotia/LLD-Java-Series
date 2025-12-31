package linkedin.service;

import linkedin.entities.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchService {
    private final Collection<Member> members;

    public SearchService(Collection<Member> members) {
        this.members = members;
    }

    public List<Member> searchByName(String name){
        List<Member> result = new ArrayList<>();
        members.stream().filter(member -> member.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(result::add);
        return result;
    }
}

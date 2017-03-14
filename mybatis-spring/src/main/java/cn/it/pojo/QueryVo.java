package cn.it.pojo;

import java.util.List;

/**
 * Created by Eric on 3/12/17.
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

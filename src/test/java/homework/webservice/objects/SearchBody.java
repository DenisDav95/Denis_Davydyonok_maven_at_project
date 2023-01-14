package homework.webservice.objects;

import java.util.Objects;

public class SearchBody {

    String user;
    boolean strict;

    public SearchBody(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchBody that = (SearchBody) o;
        return strict == that.strict && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, strict);
    }

    @Override
    public String toString() {
        return "SearchBody{" +
                "user='" + user + '\'' +
                ", strict=" + strict +
                '}';
    }
}

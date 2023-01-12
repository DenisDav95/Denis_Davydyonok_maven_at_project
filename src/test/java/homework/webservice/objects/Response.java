package homework.webservice.objects;

import java.io.Reader;
import java.util.List;
import java.util.Objects;

public class Response {

    int code;
    List<User> data;

    public Response(int code, List<User> data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return code == response.code && data.equals(response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}

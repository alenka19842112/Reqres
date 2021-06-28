package reqres_objects;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class SupportSingleUser {
    @Expose
    String url;
    @Expose
    String text;
}

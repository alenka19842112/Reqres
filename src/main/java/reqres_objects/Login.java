package reqres_objects;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Login {
    @Expose
    String email;
    @Expose
    String error;
    @Expose
    String password;
    @Expose
    String token;
}

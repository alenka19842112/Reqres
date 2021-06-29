package reqres_objects;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class SingleUser {
    @Expose
    DataSingleUser data;
    @Expose
    SupportSingleUser support;
}

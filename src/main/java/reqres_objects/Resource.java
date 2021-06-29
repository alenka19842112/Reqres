package reqres_objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Resource {
    @Expose
    int page;
    @Expose
    @SerializedName("per_page")
    int perPage;
    @Expose
    int total;
    @Expose
    @SerializedName("total_pages")
    int totalPages;
    @Expose
    List<DataResource> data;
    @Expose
    SupportSingleUser support;
}

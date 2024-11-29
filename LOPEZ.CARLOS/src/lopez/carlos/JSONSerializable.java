
package lopez.carlos;


import com.google.gson.Gson;

public interface JSONSerializable {

    
    String toJSON();

    
    static <T> T fromJSON(String json, Class<T> clazz) {
        
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}

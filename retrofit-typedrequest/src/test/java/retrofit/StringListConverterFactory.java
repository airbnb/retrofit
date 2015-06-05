package retrofit;

import com.google.common.reflect.TypeToken;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class StringListConverterFactory implements Converter.Factory {
  @Override public Converter<?> get(Type type) {
    Type listType = new TypeToken<List<String>>() {}.getType();
    if (!type.equals(listType)) {
      throw new IllegalArgumentException("Type was not " + listType +
          ". It was " + type.toString());
    }
    return new StringListConverter();
  }

  class StringListConverter implements Converter<List<String>> {
    @Override public List<String> fromBody(ResponseBody body) throws IOException {
      return null;
    }

    @Override public RequestBody toBody(List<String> value) {
      return null;
    }
  }
}

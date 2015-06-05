package retrofit;

import com.google.common.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CallableRequestBuilderTest {
  @Test public void testTypes() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://example.com")
        .converterFactory(new StringListConverterFactory())
        .build();

    Type responseType = new TypeToken<List<String>>(getClass()) { }.getType();
    CallableRequest request = new CallableRequest.Builder(retrofit)
        .path("/")
        .responseType(responseType)
        .method(Method.GET)
        .build();

    Type returnType = request.returnType();
    assertThat(returnType).isInstanceOf(ParameterizedType.class);
    ParameterizedType parameterizedType = (ParameterizedType) returnType;
    assertThat(parameterizedType.getRawType()).isEqualTo(Call.class);
    assertThat(parameterizedType.getActualTypeArguments()[0]).isEqualTo(responseType);
  }
}
package retrofit;

import com.squareup.okhttp.Request;

class TypedRawRequestFactory implements RequestFactory {
  private final BaseUrl baseUrl;
  private final TypedRequest request;
  private final Converter.Factory converterFactory;

  TypedRawRequestFactory(BaseUrl baseUrl, TypedRequest request,
      Converter.Factory converterFactory) {
    this.baseUrl = baseUrl;
    this.request = request;
    this.converterFactory = converterFactory;
  }

  @Override public Request create(Object... args) {
    TypedRequestRawRequestBuilder requestBuilder =
        new TypedRequestRawRequestBuilder(baseUrl.url(), request, converterFactory);
    return requestBuilder.build();
  }
}

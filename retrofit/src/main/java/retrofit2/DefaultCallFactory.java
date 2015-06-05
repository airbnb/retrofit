package retrofit2;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.ResponseBody;

class DefaultCallFactory<R> implements CallFactory<R> {
  private final ServiceMethod<R, ?> serviceMethod;

  DefaultCallFactory(ServiceMethod<R, ?> serviceMethod) {
    this.serviceMethod = serviceMethod;
  }

  @Override public okhttp3.Call create(Object... args) throws IOException {
    Request request = serviceMethod.toRequest(args);
    return serviceMethod.callFactory.newCall(request);
  }

  @Override public R toResponse(ResponseBody body) throws IOException {
    return serviceMethod.toResponse(body);
  }
}

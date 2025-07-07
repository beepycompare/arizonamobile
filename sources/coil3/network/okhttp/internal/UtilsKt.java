package coil3.network.okhttp.internal;

import coil3.network.NetworkClientKt;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkRequest;
import coil3.network.NetworkRequestBody;
import coil3.network.NetworkResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"toRequest", "Lokhttp3/Request;", "Lcoil3/network/NetworkRequest;", "(Lcoil3/network/NetworkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readByteString", "Lokio/ByteString;", "Lcoil3/network/NetworkRequestBody;", "(Lcoil3/network/NetworkRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toNetworkResponse", "Lcoil3/network/NetworkResponse;", "Lokhttp3/Response;", "toHeaders", "Lokhttp3/Headers;", "Lcoil3/network/NetworkHeaders;", "toNetworkHeaders", "coil-network-okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toRequest(NetworkRequest networkRequest, Continuation<? super Request> continuation) {
        UtilsKt$toRequest$1 utilsKt$toRequest$1;
        int i;
        Request.Builder builder;
        String str;
        Request.Builder builder2;
        Request.Builder builder3;
        NetworkRequest networkRequest2;
        String str2;
        ByteString byteString;
        if (continuation instanceof UtilsKt$toRequest$1) {
            utilsKt$toRequest$1 = (UtilsKt$toRequest$1) continuation;
            if ((utilsKt$toRequest$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$toRequest$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$toRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$toRequest$1.label;
                RequestBody requestBody = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    builder = new Request.Builder();
                    builder.url(networkRequest.getUrl());
                    String method = networkRequest.getMethod();
                    NetworkRequestBody body = networkRequest.getBody();
                    if (body == null) {
                        str = method;
                        builder2 = builder;
                        String str3 = str;
                        networkRequest2 = networkRequest;
                        str2 = str3;
                        builder3 = builder;
                        builder3.method(str2, requestBody);
                        builder2.headers(toHeaders(networkRequest2.getHeaders()));
                        return builder2.build();
                    }
                    utilsKt$toRequest$1.L$0 = networkRequest;
                    utilsKt$toRequest$1.L$1 = builder;
                    utilsKt$toRequest$1.L$2 = builder;
                    utilsKt$toRequest$1.L$3 = method;
                    utilsKt$toRequest$1.label = 1;
                    Object readByteString = readByteString(body, utilsKt$toRequest$1);
                    if (readByteString == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    builder3 = builder;
                    obj = readByteString;
                    networkRequest2 = networkRequest;
                    str2 = method;
                    builder2 = builder3;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    str2 = (String) utilsKt$toRequest$1.L$3;
                    builder3 = (Request.Builder) utilsKt$toRequest$1.L$2;
                    builder2 = (Request.Builder) utilsKt$toRequest$1.L$1;
                    networkRequest2 = (NetworkRequest) utilsKt$toRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                byteString = (ByteString) obj;
                if (byteString == null) {
                    requestBody = RequestBody.Companion.create$default(RequestBody.Companion, byteString, (MediaType) null, 1, (Object) null);
                    builder3.method(str2, requestBody);
                    builder2.headers(toHeaders(networkRequest2.getHeaders()));
                    return builder2.build();
                }
                NetworkRequest networkRequest3 = networkRequest2;
                str = str2;
                networkRequest = networkRequest3;
                builder = builder3;
                String str32 = str;
                networkRequest2 = networkRequest;
                str2 = str32;
                builder3 = builder;
                builder3.method(str2, requestBody);
                builder2.headers(toHeaders(networkRequest2.getHeaders()));
                return builder2.build();
            }
        }
        utilsKt$toRequest$1 = new UtilsKt$toRequest$1(continuation);
        Object obj2 = utilsKt$toRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$toRequest$1.label;
        RequestBody requestBody2 = null;
        if (i != 0) {
        }
        byteString = (ByteString) obj2;
        if (byteString == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readByteString(NetworkRequestBody networkRequestBody, Continuation<? super ByteString> continuation) {
        UtilsKt$readByteString$1 utilsKt$readByteString$1;
        int i;
        Buffer buffer;
        if (continuation instanceof UtilsKt$readByteString$1) {
            utilsKt$readByteString$1 = (UtilsKt$readByteString$1) continuation;
            if ((utilsKt$readByteString$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$readByteString$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$readByteString$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$readByteString$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    BufferedSink buffer2 = new Buffer();
                    utilsKt$readByteString$1.L$0 = buffer2;
                    utilsKt$readByteString$1.label = 1;
                    if (networkRequestBody.writeTo(buffer2, utilsKt$readByteString$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    buffer = buffer2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    buffer = (Buffer) utilsKt$readByteString$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return buffer.readByteString();
            }
        }
        utilsKt$readByteString$1 = new UtilsKt$readByteString$1(continuation);
        Object obj2 = utilsKt$readByteString$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$readByteString$1.label;
        if (i != 0) {
        }
        return buffer.readByteString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkResponse toNetworkResponse(Response response) {
        BufferedSource source;
        int code = response.code();
        long sentRequestAtMillis = response.sentRequestAtMillis();
        long receivedResponseAtMillis = response.receivedResponseAtMillis();
        NetworkHeaders networkHeaders = toNetworkHeaders(response.headers());
        ResponseBody body = response.body();
        return new NetworkResponse(code, sentRequestAtMillis, receivedResponseAtMillis, networkHeaders, (body == null || (source = body.source()) == null) ? null : NetworkClientKt.NetworkResponseBody(source), response);
    }

    private static final Headers toHeaders(NetworkHeaders networkHeaders) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : networkHeaders.asMap().entrySet()) {
            String key = entry.getKey();
            for (String str : entry.getValue()) {
                builder.addUnsafeNonAscii(key, str);
            }
        }
        return builder.build();
    }

    private static final NetworkHeaders toNetworkHeaders(Headers headers) {
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        Iterator<Pair<? extends String, ? extends String>> it = headers.iterator();
        while (it.hasNext()) {
            Pair<? extends String, ? extends String> next = it.next();
            builder.add(next.component1(), next.component2());
        }
        return builder.build();
    }
}

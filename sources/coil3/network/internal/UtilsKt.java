package coil3.network.internal;

import coil3.disk.DiskCache;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\tH\u0080@¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0080\u0002\u001a\f\u0010\u0015\u001a\u00020\t*\u00020\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u0005*\u00060\u0018j\u0002`\u0019H\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"append", "Lcoil3/network/NetworkHeaders$Builder;", "line", "", "abortQuietly", "", "Lcoil3/disk/DiskCache$Editor;", "readBuffer", "Lokio/Buffer;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CACHE_CONTROL", "CONTENT_TYPE", "HTTP_METHOD_GET", "MIME_TYPE_TEXT_PLAIN", "HTTP_RESPONSE_OK", "", "HTTP_RESPONSE_NOT_MODIFIED", "plus", "Lcoil3/network/NetworkHeaders;", "other", "requireBody", "Lcoil3/network/NetworkResponse;", "closeQuietly", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "coil-network-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String HTTP_METHOD_GET = "GET";
    public static final int HTTP_RESPONSE_NOT_MODIFIED = 304;
    public static final int HTTP_RESPONSE_OK = 200;
    public static final String MIME_TYPE_TEXT_PLAIN = "text/plain";

    public static final NetworkHeaders.Builder append(NetworkHeaders.Builder builder, String str) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String obj = StringsKt.trim((CharSequence) substring).toString();
        String substring2 = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        builder.add(obj, substring2);
        return builder;
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBuffer(NetworkResponseBody networkResponseBody, Continuation<? super Buffer> continuation) {
        UtilsKt$readBuffer$1 utilsKt$readBuffer$1;
        int i;
        AutoCloseable autoCloseable;
        Throwable th;
        Buffer buffer;
        if (continuation instanceof UtilsKt$readBuffer$1) {
            utilsKt$readBuffer$1 = (UtilsKt$readBuffer$1) continuation;
            if ((utilsKt$readBuffer$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$readBuffer$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$readBuffer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$readBuffer$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NetworkResponseBody networkResponseBody2 = networkResponseBody;
                    try {
                        Buffer buffer2 = new Buffer();
                        utilsKt$readBuffer$1.L$0 = networkResponseBody2;
                        utilsKt$readBuffer$1.L$1 = buffer2;
                        utilsKt$readBuffer$1.label = 1;
                        if (networkResponseBody2.writeTo(buffer2, utilsKt$readBuffer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        autoCloseable = networkResponseBody2;
                        buffer = buffer2;
                    } catch (Throwable th2) {
                        autoCloseable = networkResponseBody2;
                        th = th2;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    buffer = (Buffer) utilsKt$readBuffer$1.L$1;
                    autoCloseable = (AutoCloseable) utilsKt$readBuffer$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            AutoCloseableKt.closeFinally(autoCloseable, th);
                            throw th4;
                        }
                    }
                }
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return buffer;
            }
        }
        utilsKt$readBuffer$1 = new UtilsKt$readBuffer$1(continuation);
        Object obj2 = utilsKt$readBuffer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$readBuffer$1.label;
        if (i != 0) {
        }
        AutoCloseableKt.closeFinally(autoCloseable, null);
        return buffer;
    }

    public static final NetworkHeaders plus(NetworkHeaders networkHeaders, NetworkHeaders networkHeaders2) {
        NetworkHeaders.Builder newBuilder = networkHeaders.newBuilder();
        for (Map.Entry<String, List<String>> entry : networkHeaders2.asMap().entrySet()) {
            newBuilder.set(entry.getKey(), entry.getValue());
        }
        return newBuilder.build();
    }

    public static final NetworkResponseBody requireBody(NetworkResponse networkResponse) {
        NetworkResponseBody body = networkResponse.getBody();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("body == null".toString());
    }

    public static final void closeQuietly(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }
}

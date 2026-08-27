package com.arizona.launcher.updater.http;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* compiled from: UpdateMetadataHttpClient.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u00020\t*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpClient;", "Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;", "callFactory", "Lokhttp3/Call$Factory;", "maxBodyBytes", "", "<init>", "(Lokhttp3/Call$Factory;J)V", "get", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeResponse", "response", "Lokhttp3/Response;", "readBounded", TtmlNode.TAG_BODY, "Lokhttp3/ResponseBody;", "toResult", "Ljava/io/IOException;", "responseStarted", "", "isTimeout", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateMetadataHttpClient implements UpdateMetadataRequest {
    @Deprecated
    public static final String ACCEPT_ENCODING_IDENTITY = "identity";
    @Deprecated
    public static final String CACHE_CONTROL_NO_CACHE = "no-cache";
    @Deprecated
    public static final long DEFAULT_MAX_BODY_BYTES = 4194304;
    @Deprecated
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    @Deprecated
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    @Deprecated
    public static final int MAX_INITIAL_BUFFER_BYTES = 65536;
    @Deprecated
    public static final int READ_BUFFER_BYTES = 8192;
    private final Call.Factory callFactory;
    private final long maxBodyBytes;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UpdateMetadataHttpClient(Call.Factory callFactory, long j) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        this.callFactory = callFactory;
        this.maxBodyBytes = j;
        if (j < 0) {
            throw new IllegalArgumentException("maxBodyBytes must not be negative".toString());
        }
    }

    public /* synthetic */ UpdateMetadataHttpClient(Call.Factory factory, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(factory, (i & 2) != 0 ? 4194304L : j);
    }

    @Override // com.arizona.launcher.updater.http.UpdateMetadataRequest
    public Object get(String str, Continuation<? super UpdateMetadataHttpResult> continuation) {
        try {
            return execute(new Request.Builder().url(str).get().header("Cache-Control", "no-cache").header("Accept-Encoding", "identity").build(), continuation);
        } catch (IllegalArgumentException e) {
            return new UpdateMetadataHttpResult.InvalidRequest(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateMetadataHttpResult consumeResponse(Response response) {
        if (!response.isSuccessful()) {
            return new UpdateMetadataHttpResult.HttpError(response.code());
        }
        return readBounded(response.body());
    }

    private final UpdateMetadataHttpResult readBounded(ResponseBody responseBody) {
        Charset charset;
        long contentLength = responseBody.contentLength();
        long j = this.maxBodyBytes;
        if (contentLength > j) {
            return new UpdateMetadataHttpResult.BodyTooLarge(this.maxBodyBytes, Long.valueOf(contentLength));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) RangesKt.coerceIn(contentLength, 0L, Math.min(j, (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)));
        byte[] bArr = new byte[8192];
        InputStream byteStream = responseBody.byteStream();
        try {
            InputStream inputStream = byteStream;
            long j2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteStream, null);
                    MediaType contentType = responseBody.contentType();
                    if (contentType == null || (charset = contentType.charset(Charsets.UTF_8)) == null) {
                        charset = Charsets.UTF_8;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    return new UpdateMetadataHttpResult.Success(new String(byteArray, charset));
                } else if (read != 0) {
                    long j3 = read;
                    if (j3 > this.maxBodyBytes - j2) {
                        UpdateMetadataHttpResult.BodyTooLarge bodyTooLarge = new UpdateMetadataHttpResult.BodyTooLarge(this.maxBodyBytes, null);
                        CloseableKt.closeFinally(byteStream, null);
                        return bodyTooLarge;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    j2 += j3;
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateMetadataHttpResult toResult(IOException iOException, boolean z) {
        if (isTimeout(iOException)) {
            return new UpdateMetadataHttpResult.Timeout(iOException);
        }
        return new UpdateMetadataHttpResult.NetworkError(iOException, z);
    }

    private final boolean isTimeout(IOException iOException) {
        String message;
        return (iOException instanceof SocketTimeoutException) || ((iOException instanceof InterruptedIOException) && (message = iOException.getMessage()) != null && StringsKt.contains((CharSequence) message, (CharSequence) "timeout", true));
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpClient$Companion;", "", "<init>", "()V", "DEFAULT_MAX_BODY_BYTES", "", "MAX_INITIAL_BUFFER_BYTES", "", "READ_BUFFER_BYTES", "HEADER_CACHE_CONTROL", "", "CACHE_CONTROL_NO_CACHE", "HEADER_ACCEPT_ENCODING", "ACCEPT_ENCODING_IDENTITY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object execute(Request request, Continuation<? super UpdateMetadataHttpResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Call newCall = this.callFactory.newCall(request);
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.arizona.launcher.updater.http.UpdateMetadataHttpClient$execute$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.cancel();
            }
        });
        newCall.enqueue(new Callback() { // from class: com.arizona.launcher.updater.http.UpdateMetadataHttpClient$execute$2$2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException error) {
                UpdateMetadataHttpResult result;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                if (cancellableContinuationImpl2.isActive()) {
                    Result.Companion companion = Result.Companion;
                    result = this.toResult(error, false);
                    cancellableContinuationImpl2.resumeWith(Result.m9919constructorimpl(result));
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                UpdateMetadataHttpResult result;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    Response response2 = response;
                    result = this.consumeResponse(response2);
                    CloseableKt.closeFinally(response2, null);
                } catch (IOException e) {
                    result = this.toResult(e, true);
                }
                if (cancellableContinuationImpl2.isActive()) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m9919constructorimpl(result));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

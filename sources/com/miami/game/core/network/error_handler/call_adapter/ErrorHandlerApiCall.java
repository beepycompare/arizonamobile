package com.miami.game.core.network.error_handler.call_adapter;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.miami.game.core.error.model.AppError;
import com.miami.game.core.error.model.AppException;
import com.miami.game.core.error.model.NetworkErrorType;
import com.miami.game.core.network.error_handler.parser.ResponseApiErrorParser;
import com.miami.game.core.network.extensions.OkHttpRequestStringExtensionsKt;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;
/* compiled from: ErrorHandlerApiCall.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\u001c\u0010\u0015\u001a\u0015\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u0002¢\u0006\u0002\b\u0017H\u0096\u0001J-\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u0000 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u000f0\u000fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010\u001c\u001a\n \u0016*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\n \u0016*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/miami/game/core/network/error_handler/call_adapter/ErrorHandlerApiCall;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Call;", "sourceCall", "responseApiErrorParser", "Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;", "<init>", "(Lretrofit2/Call;Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;)V", "enqueue", "", "callback", "Lretrofit2/Callback;", "appErrorFromErrorResponse", "Lcom/miami/game/core/error/model/AppError;", "response", "Lretrofit2/Response;", "appExceptionFromCallException", "Lcom/miami/game/core/error/model/AppException;", "throwable", "", FacebookDialog.COMPLETION_GESTURE_CANCEL, "clone", "kotlin.jvm.PlatformType", "Lkotlin/jvm/internal/EnhancedNullability;", "execute", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorHandlerApiCall<T> implements Call<T> {
    private final ResponseApiErrorParser responseApiErrorParser;
    private final Call<T> sourceCall;

    @Override // retrofit2.Call
    public void cancel() {
        this.sourceCall.cancel();
    }

    @Override // retrofit2.Call
    public Call<T> clone() {
        Call<T> mo8324clone = this.sourceCall.mo8324clone();
        Intrinsics.checkNotNullExpressionValue(mo8324clone, "clone(...)");
        return mo8324clone;
    }

    @Override // retrofit2.Call
    public Response<T> execute() {
        return this.sourceCall.execute();
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        return this.sourceCall.isCanceled();
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        return this.sourceCall.isExecuted();
    }

    @Override // retrofit2.Call
    public Request request() {
        return this.sourceCall.request();
    }

    @Override // retrofit2.Call
    public Timeout timeout() {
        return this.sourceCall.timeout();
    }

    public ErrorHandlerApiCall(Call<T> sourceCall, ResponseApiErrorParser responseApiErrorParser) {
        Intrinsics.checkNotNullParameter(sourceCall, "sourceCall");
        Intrinsics.checkNotNullParameter(responseApiErrorParser, "responseApiErrorParser");
        this.sourceCall = sourceCall;
        this.responseApiErrorParser = responseApiErrorParser;
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.sourceCall.enqueue(new Callback<T>() { // from class: com.miami.game.core.network.error_handler.call_adapter.ErrorHandlerApiCall$enqueue$1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                AppError appErrorFromErrorResponse;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    appErrorFromErrorResponse = this.appErrorFromErrorResponse(response);
                    Request request = call.request();
                    Intrinsics.checkNotNullExpressionValue(request, "request(...)");
                    AppException appException = new AppException(appErrorFromErrorResponse, StringsKt.trimMargin$default("HTTP request returned an error code.\n                        |Request: " + OkHttpRequestStringExtensionsKt.toSafeString(request) + "\n                        |Response: " + response, null, 1, null));
                    Timber.Forest.e(new ApiCallException(appException));
                    callback.onFailure(call, appException);
                    return;
                }
                callback.onResponse(call, response);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable t) {
                AppException appExceptionFromCallException;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                appExceptionFromCallException = this.appExceptionFromCallException(t);
                Request request = call.request();
                Intrinsics.checkNotNullExpressionValue(request, "request(...)");
                AppException appException = new AppException(appExceptionFromCallException.getAppError(), StringsKt.trimMargin$default("HTTP request failed.\n                    |Request: " + OkHttpRequestStringExtensionsKt.toSafeString(request), null, 1, null), appExceptionFromCallException);
                Timber.Forest.e(new ApiCallException(appException));
                callback.onFailure(call, appException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppError appErrorFromErrorResponse(Response<T> response) {
        int code = response.code();
        if (code == 401) {
            return AppError.AuthError.INSTANCE;
        }
        AppError parseApiErrorFromErrorResponse = this.responseApiErrorParser.parseApiErrorFromErrorResponse(response);
        return parseApiErrorFromErrorResponse == null ? new AppError.HttpError(code) : parseApiErrorFromErrorResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppException appExceptionFromCallException(Throwable th) {
        if (th instanceof AppException) {
            return (AppException) th;
        }
        if ((th instanceof JsonSyntaxException) || (th instanceof MalformedJsonException) || (th instanceof EOFException)) {
            return new AppException(new AppError.ResponseParsingError(null, 1, null), th);
        }
        if (th instanceof SSLException) {
            return new AppException(new AppError.NetworkError(NetworkErrorType.SSL), th);
        }
        if ((th instanceof ConnectException) || (th instanceof IOException)) {
            return new AppException(new AppError.NetworkError(NetworkErrorType.CONNECTION), th);
        }
        return new AppException(new AppError.NetworkError(NetworkErrorType.UNKNOWN), th);
    }
}

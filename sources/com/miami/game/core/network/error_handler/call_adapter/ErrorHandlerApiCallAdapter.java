package com.miami.game.core.network.error_handler.call_adapter;

import androidx.core.app.NotificationCompat;
import com.miami.game.core.network.error_handler.parser.ResponseApiErrorParser;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
/* compiled from: ErrorHandlerApiCallAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/miami/game/core/network/error_handler/call_adapter/ErrorHandlerApiCallAdapter;", "R", "Lretrofit2/CallAdapter;", "Lretrofit2/Call;", "responseType", "Ljava/lang/reflect/Type;", "responseApiErrorParser", "Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;", "<init>", "(Ljava/lang/reflect/Type;Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;)V", "adapt", NotificationCompat.CATEGORY_CALL, "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorHandlerApiCallAdapter<R> implements CallAdapter<R, Call<R>> {
    private final ResponseApiErrorParser responseApiErrorParser;
    private final Type responseType;

    public ErrorHandlerApiCallAdapter(Type responseType, ResponseApiErrorParser responseApiErrorParser) {
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(responseApiErrorParser, "responseApiErrorParser");
        this.responseType = responseType;
        this.responseApiErrorParser = responseApiErrorParser;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    @Override // retrofit2.CallAdapter
    public Call<R> adapt(Call<R> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return new ErrorHandlerApiCall(call, this.responseApiErrorParser);
    }
}

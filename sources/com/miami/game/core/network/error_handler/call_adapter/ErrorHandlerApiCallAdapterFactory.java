package com.miami.game.core.network.error_handler.call_adapter;

import com.miami.game.core.network.error_handler.parser.ResponseApiErrorParser;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
/* compiled from: ErrorHandlerApiCallAdapterFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/network/error_handler/call_adapter/ErrorHandlerApiCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "responseApiErrorParser", "Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;", "<init>", "(Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;)V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorHandlerApiCallAdapterFactory extends CallAdapter.Factory {
    private final ResponseApiErrorParser responseApiErrorParser;

    public ErrorHandlerApiCallAdapterFactory(ResponseApiErrorParser responseApiErrorParser) {
        Intrinsics.checkNotNullParameter(responseApiErrorParser, "responseApiErrorParser");
        this.responseApiErrorParser = responseApiErrorParser;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (Intrinsics.areEqual(Call.class, CallAdapter.Factory.getRawType(returnType))) {
            if (!(returnType instanceof ParameterizedType)) {
                throw new IllegalStateException(Unit.INSTANCE.toString());
            }
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            Intrinsics.checkNotNull(parameterUpperBound);
            return new ErrorHandlerApiCallAdapter(parameterUpperBound, this.responseApiErrorParser);
        }
        return null;
    }
}

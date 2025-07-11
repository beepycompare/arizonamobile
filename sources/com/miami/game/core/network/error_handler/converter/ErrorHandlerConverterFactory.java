package com.miami.game.core.network.error_handler.converter;

import com.miami.game.core.error.model.AppError;
import com.miami.game.core.error.model.AppException;
import com.miami.game.core.network.error_handler.parser.ResponseApiErrorParser;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* compiled from: ErrorHandlerConverterFactory.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011JI\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/network/error_handler/converter/ErrorHandlerConverterFactory;", "Lretrofit2/Converter$Factory;", "responseApiErrorParser", "Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;", "delegate", "<init>", "(Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;Lretrofit2/Converter$Factory;)V", "responseBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "requestBodyConverter", "Lokhttp3/RequestBody;", "parameterAnnotations", "methodAnnotations", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Companion", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorHandlerConverterFactory extends Converter.Factory {
    public static final Companion Companion = new Companion(null);
    private static final long PEEK_BYTES = 10240;
    private final Converter.Factory delegate;
    private final ResponseApiErrorParser responseApiErrorParser;

    public ErrorHandlerConverterFactory(ResponseApiErrorParser responseApiErrorParser, Converter.Factory delegate) {
        Intrinsics.checkNotNullParameter(responseApiErrorParser, "responseApiErrorParser");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.responseApiErrorParser = responseApiErrorParser;
        this.delegate = delegate;
    }

    /* compiled from: ErrorHandlerConverterFactory.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/network/error_handler/converter/ErrorHandlerConverterFactory$Companion;", "", "<init>", "()V", "PEEK_BYTES", "", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        final Converter<ResponseBody, ?> responseBodyConverter = this.delegate.responseBodyConverter(type, annotations, retrofit);
        if (responseBodyConverter != null) {
            return new Converter() { // from class: com.miami.game.core.network.error_handler.converter.ErrorHandlerConverterFactory$$ExternalSyntheticLambda0
                @Override // retrofit2.Converter
                public final Object convert(Object obj) {
                    Object responseBodyConverter$lambda$0;
                    responseBodyConverter$lambda$0 = ErrorHandlerConverterFactory.responseBodyConverter$lambda$0(ErrorHandlerConverterFactory.this, responseBodyConverter, (ResponseBody) obj);
                    return responseBodyConverter$lambda$0;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object responseBodyConverter$lambda$0(ErrorHandlerConverterFactory errorHandlerConverterFactory, Converter converter, ResponseBody responseBody) {
        ResponseApiErrorParser responseApiErrorParser = errorHandlerConverterFactory.responseApiErrorParser;
        Intrinsics.checkNotNull(responseBody);
        AppError parseApiErrorFromResponseBody = responseApiErrorParser.parseApiErrorFromResponseBody(ResponseBodyPeekExtensionKt.peek(responseBody, PEEK_BYTES));
        if (parseApiErrorFromResponseBody != null) {
            throw new AppException(parseApiErrorFromResponseBody, "error parsed from successful response");
        }
        return converter.convert(responseBody);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(methodAnnotations, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return this.delegate.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}

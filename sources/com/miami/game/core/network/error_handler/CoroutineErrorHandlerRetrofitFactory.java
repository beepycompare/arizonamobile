package com.miami.game.core.network.error_handler;

import com.google.gson.Gson;
import com.miami.game.core.network.error_handler.call_adapter.ErrorHandlerApiCallAdapterFactory;
import com.miami.game.core.network.error_handler.converter.ErrorHandlerConverterFactory;
import com.miami.game.core.network.error_handler.parser.JsonApiErrorParser;
import com.miami.game.core.network.error_handler.parser.ResponseApiErrorParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: CoroutineErrorHandlerRetrofitFactory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/miami/game/core/network/error_handler/CoroutineErrorHandlerRetrofitFactory;", "", "httpClientProvider", "Lkotlin/Function0;", "Lokhttp3/OkHttpClient;", "baseUrlProvider", "Lokhttp3/HttpUrl;", "gsonProvider", "Lcom/google/gson/Gson;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "createRetrofit", "Lretrofit2/Retrofit;", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineErrorHandlerRetrofitFactory {
    private final Function0<HttpUrl> baseUrlProvider;
    private final Function0<Gson> gsonProvider;
    private final Function0<OkHttpClient> httpClientProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineErrorHandlerRetrofitFactory(Function0<? extends OkHttpClient> httpClientProvider, Function0<HttpUrl> baseUrlProvider, Function0<Gson> gsonProvider) {
        Intrinsics.checkNotNullParameter(httpClientProvider, "httpClientProvider");
        Intrinsics.checkNotNullParameter(baseUrlProvider, "baseUrlProvider");
        Intrinsics.checkNotNullParameter(gsonProvider, "gsonProvider");
        this.httpClientProvider = httpClientProvider;
        this.baseUrlProvider = baseUrlProvider;
        this.gsonProvider = gsonProvider;
    }

    public final Retrofit createRetrofit() {
        ResponseApiErrorParser responseApiErrorParser = new ResponseApiErrorParser(new JsonApiErrorParser());
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(this.baseUrlProvider.invoke());
        GsonConverterFactory create = GsonConverterFactory.create(this.gsonProvider.invoke());
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        Retrofit build = baseUrl.addConverterFactory(new ErrorHandlerConverterFactory(responseApiErrorParser, create)).addCallAdapterFactory(new ErrorHandlerApiCallAdapterFactory(responseApiErrorParser)).client(this.httpClientProvider.invoke()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}

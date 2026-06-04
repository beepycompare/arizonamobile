package com.miami.game.core.api.network.retrofit;

import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Url;
/* compiled from: NetworkApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\b\u0001\u0010\u0005\u001a\u00020\u0006:\u0002\b\u0007H§@b\u0002\b\t¢\u0006\u0002\u0010\bJ(\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\f\b\u0001\u0010\f\u001a\u00020\u0006:\u0002\b\u0007H§@b\u0002\b\t¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\f\b\u0001\u0010\f\u001a\u00020\u0006:\u0002\b\u0007H§@b\u0002\b\t¢\u0006\u0002\u0010\b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/api/network/retrofit/NetworkApi;", "", "getServers", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "serversUrl", "", "Lretrofit2/http/Url;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "getNews", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "url", "getHwVersion", "Lcom/miami/game/core/api/model/response/HwVersion;", "api-network"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NetworkApi {
    @GET
    Object getHwVersion(@Url String str, Continuation<? super HwVersion> continuation);

    @GET
    Object getNews(@Url String str, Continuation<? super List<NewsApiModelItem>> continuation);

    @GET
    Object getServers(@Url String str, Continuation<? super List<ServersApiModelItem>> continuation);
}

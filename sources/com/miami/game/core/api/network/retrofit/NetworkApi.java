package com.miami.game.core.api.network.retrofit;

import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Url;
/* compiled from: NetworkApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/api/network/retrofit/NetworkApi;", "", "getGameFilesInfo", "Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServers", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "serversUrl", "getNews", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "getHwVersion", "Lcom/miami/game/core/api/model/response/HwVersion;", "api-network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface NetworkApi {
    @GET
    Object getGameFilesInfo(@Url String str, Continuation<? super GameInfoResponseApiModel> continuation);

    @GET
    Object getHwVersion(@Url String str, Continuation<? super HwVersion> continuation);

    @GET
    Object getNews(@Url String str, Continuation<? super List<NewsApiModelItem>> continuation);

    @GET
    Object getServers(@Url String str, Continuation<? super List<ServersApiModelItem>> continuation);
}

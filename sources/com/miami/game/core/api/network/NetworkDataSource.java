package com.miami.game.core.api.network;

import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: NetworkDataSource.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0005¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/api/network/NetworkDataSource;", "", "getServersMobile", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServersDesktop", "getServersVc", "getNews", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "getHwVersion", "Lcom/miami/game/core/api/model/response/HwVersion;", "api-network"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NetworkDataSource {
    Object getHwVersion(Continuation<? super HwVersion> continuation);

    Object getNews(Continuation<? super List<NewsApiModelItem>> continuation);

    Object getServersDesktop(Continuation<? super List<ServersApiModelItem>> continuation);

    Object getServersMobile(Continuation<? super List<ServersApiModelItem>> continuation);

    Object getServersVc(Continuation<? super List<ServersApiModelItem>> continuation);
}

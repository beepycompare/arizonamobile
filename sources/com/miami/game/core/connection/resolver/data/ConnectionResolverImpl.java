package com.miami.game.core.connection.resolver.data;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: ConnectionResolverImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/connection/resolver/data/ConnectionResolverImpl;", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "availabilityService", "Lcom/miami/game/core/connection/resolver/data/AvailabilityService;", "serversList", "Lcom/miami/game/core/connection/resolver/data/ServersList;", "<init>", "(Lcom/miami/game/core/connection/resolver/data/AvailabilityService;Lcom/miami/game/core/connection/resolver/data/ServersList;)V", "getDownloadFilesChannel", "Lkotlin/Pair;", "", "", "channel", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerDesktopList", "getServerMobileList", "getGameFilesInfoServer", "getNewsServer", "findAvailableServer", "servers", "", "connection-resolver_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionResolverImpl implements ConnectionResolver {
    private final AvailabilityService availabilityService;
    private final ServersList serversList;

    @Inject
    public ConnectionResolverImpl(AvailabilityService availabilityService, ServersList serversList) {
        Intrinsics.checkNotNullParameter(availabilityService, "availabilityService");
        Intrinsics.checkNotNullParameter(serversList, "serversList");
        this.availabilityService = availabilityService;
        this.serversList = serversList;
    }

    @Override // com.miami.game.core.connection.resolver.api.ConnectionResolver
    public Object getDownloadFilesChannel(int i, Continuation<? super Pair<String, Integer>> continuation) {
        List<String> dataServers = this.serversList.dataServers();
        if (i == -1) {
            return findAvailableServer(dataServers);
        }
        return i >= dataServers.size() ? TuplesKt.to(CollectionsKt.first((List<? extends Object>) dataServers), Boxing.boxInt(0)) : TuplesKt.to(dataServers.get(i), Boxing.boxInt(i));
    }

    @Override // com.miami.game.core.connection.resolver.api.ConnectionResolver
    public Object getServerDesktopList(int i, Continuation<? super Pair<String, Integer>> continuation) {
        List<String> gameServersDesktop = this.serversList.gameServersDesktop();
        if (i == -1) {
            return findAvailableServer(gameServersDesktop);
        }
        return i >= gameServersDesktop.size() ? TuplesKt.to(CollectionsKt.first((List<? extends Object>) gameServersDesktop), Boxing.boxInt(0)) : TuplesKt.to(gameServersDesktop.get(i), Boxing.boxInt(i));
    }

    @Override // com.miami.game.core.connection.resolver.api.ConnectionResolver
    public Object getServerMobileList(int i, Continuation<? super Pair<String, Integer>> continuation) {
        List<String> gameServersMobile = this.serversList.gameServersMobile();
        if (i == -1) {
            return findAvailableServer(gameServersMobile);
        }
        return i >= gameServersMobile.size() ? TuplesKt.to(CollectionsKt.first((List<? extends Object>) gameServersMobile), Boxing.boxInt(0)) : TuplesKt.to(gameServersMobile.get(i), Boxing.boxInt(i));
    }

    @Override // com.miami.game.core.connection.resolver.api.ConnectionResolver
    public Object getGameFilesInfoServer(int i, Continuation<? super Pair<String, Integer>> continuation) {
        List<String> gameInfoFilesServers = this.serversList.gameInfoFilesServers();
        if (i == -1) {
            return findAvailableServer(gameInfoFilesServers);
        }
        return i >= gameInfoFilesServers.size() ? TuplesKt.to(CollectionsKt.first((List<? extends Object>) gameInfoFilesServers), Boxing.boxInt(0)) : TuplesKt.to(gameInfoFilesServers.get(i), Boxing.boxInt(i));
    }

    @Override // com.miami.game.core.connection.resolver.api.ConnectionResolver
    public Object getNewsServer(int i, Continuation<? super Pair<String, Integer>> continuation) {
        List<String> newsServers = this.serversList.newsServers();
        if (i == -1) {
            return findAvailableServer(newsServers);
        }
        return i >= newsServers.size() ? TuplesKt.to(CollectionsKt.first((List<? extends Object>) newsServers), Boxing.boxInt(0)) : TuplesKt.to(newsServers.get(i), Boxing.boxInt(i));
    }

    private final Pair<String, Integer> findAvailableServer(List<String> list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (this.availabilityService.checkAvailability(str)) {
                return TuplesKt.to(str, Integer.valueOf(i));
            }
            i = i2;
        }
        Timber.Forest.d("Available server not found among: " + list, new Object[0]);
        throw new IllegalStateException("Available server not found among: " + list);
    }
}

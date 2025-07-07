package com.miami.game.core.connection.resolver.di;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.connection.resolver.data.ConnectionResolverImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
/* compiled from: ConnectionResolverModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/connection/resolver/di/ConnectionResolverModule;", "", "BindConnectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "connectionResolverImpl", "Lcom/miami/game/core/connection/resolver/data/ConnectionResolverImpl;", "connection-resolver_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public interface ConnectionResolverModule {
    @Binds
    ConnectionResolver BindConnectionResolver(ConnectionResolverImpl connectionResolverImpl);
}

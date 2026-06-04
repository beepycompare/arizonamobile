package com.miami.game.core.connection.resolver.di;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.connection.resolver.data.ConnectionResolverImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
/* compiled from: ConnectionResolverModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'b\u0002\b\u0006Ê\u0001\u0002\b\bÊ\u0001\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000b¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/connection/resolver/di/ConnectionResolverModule;", "", "BindConnectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "connectionResolverImpl", "Lcom/miami/game/core/connection/resolver/data/ConnectionResolverImpl;", "Ldagger/Binds;", "connection-resolver", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public interface ConnectionResolverModule {
    @Binds
    ConnectionResolver BindConnectionResolver(ConnectionResolverImpl connectionResolverImpl);
}

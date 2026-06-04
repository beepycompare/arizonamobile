package com.miami.game.core.local.repository.di;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocalRepositoryModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0006b\u0002\b\u0007b\u0002\b\bJ,\u0010\t\u001a\u00020\n2\f\b\u0001\u0010\u000b\u001a\u00020\f:\u0002\b\r2\f\b\u0001\u0010\u000e\u001a\u00020\u0005:\u0002\b\bH\u0007b\u0002\b\u0007b\u0002\b\u0006Ê\u0001\u0002\b\u0010Ê\u0001\u0010\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\t0\u0013¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/local/repository/di/LocalRepositoryModule;", "", "<init>", "()V", "provideGson", "Lcom/google/gson/Gson;", "Ljavax/inject/Singleton;", "Ldagger/Provides;", "Lcom/miami/game/core/local/repository/di/LocalRepositoryClient;", "provideLocalRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "context", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "gson", "local-repository", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class LocalRepositoryModule {
    public static final LocalRepositoryModule INSTANCE = new LocalRepositoryModule();

    private LocalRepositoryModule() {
    }

    @Provides
    @Singleton
    public final Gson provideGson() {
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    @Provides
    @Singleton
    public final LocalRepository provideLocalRepository(@ApplicationContext Context context, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new LocalRepository(context, gson);
    }
}

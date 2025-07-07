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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u001c\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/miami/game/core/local/repository/di/LocalRepositoryModule;", "", "<init>", "()V", "provideGson", "Lcom/google/gson/Gson;", "provideLocalRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "context", "Landroid/content/Context;", "gson", "local-repository_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
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

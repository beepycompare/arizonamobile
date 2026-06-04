package com.arizona.launcher.di;

import android.content.Context;
import android.content.res.Resources;
import com.arizona.game.BuildConfig;
import com.miami.game.core.build.config.BuildConfigRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CoreAppModule.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\f\b\u0001\u0010\b\u001a\u00020\t:\u0002\b\nH\u0007b\u0002\b\u000bJ\f\u0010\f\u001a\u00020\rH\u0007b\u0002\b\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u000fÊ\u0001\u0010\b\u0010\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\t0\u0012Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/di/CoreAppModule;", "", "<init>", "()V", "DATABASE_APP_NAME", "", "providesResources", "Landroid/content/res/Resources;", "context", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "Ldagger/Provides;", "provideBuildConfigRepository", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "app", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class CoreAppModule {
    public static final int $stable = 0;
    private static final String DATABASE_APP_NAME = "ArizonaDatabase";
    public static final CoreAppModule INSTANCE = new CoreAppModule();

    private CoreAppModule() {
    }

    @Provides
    public final Resources providesResources(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return resources;
    }

    @Provides
    public final BuildConfigRepository provideBuildConfigRepository() {
        return new BuildConfigRepository("release", BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE, false, true, false, BuildConfig.APPLICATION_ID);
    }
}

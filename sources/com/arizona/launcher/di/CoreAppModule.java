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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/di/CoreAppModule;", "", "<init>", "()V", "DATABASE_APP_NAME", "", "providesResources", "Landroid/content/res/Resources;", "context", "Landroid/content/Context;", "provideBuildConfigRepository", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        return new BuildConfigRepository("release_web", BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE, false, true, BuildConfig.APPLICATION_ID);
    }
}

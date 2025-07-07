package com.arizona.launcher.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PreferencesModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/di/PreferencesModule;", "", "<init>", "()V", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "applicationContext", "Landroid/content/Context;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class PreferencesModule {
    public static final int $stable = 0;

    @Provides
    public final SharedPreferences provideSharedPreferences(@ApplicationContext Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        return defaultSharedPreferences;
    }
}

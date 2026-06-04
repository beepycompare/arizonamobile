package com.arizona.launcher.data.repository;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PreferencesRepository.kt */
@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\rÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/data/repository/PreferencesRepository;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "Ljavax/inject/Inject;", "isFirstRun", "", "setNotFirstRun", "", "Companion", "app", "Ljavax/inject/Singleton;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PreferencesRepository {
    private static final String FIRSTRUN = "FIRSTRUN";
    private final SharedPreferences preferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public PreferencesRepository(SharedPreferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.preferences = preferences;
    }

    public final boolean isFirstRun() {
        return this.preferences.getBoolean(FIRSTRUN, true);
    }

    public final void setNotFirstRun() {
        this.preferences.edit().putBoolean(FIRSTRUN, false).apply();
    }

    /* compiled from: PreferencesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/data/repository/PreferencesRepository$Companion;", "", "<init>", "()V", PreferencesRepository.FIRSTRUN, "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

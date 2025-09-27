package com.arizona.launcher.data.repository.settings;

import android.content.SharedPreferences;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SettingsRepository.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/data/repository/settings/SettingsRepository;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "getNickname", "", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsRepository {
    public static final int $stable = 0;

    @Inject
    public SettingsRepository(SharedPreferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
    }

    public final String getNickname() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String substring = StringsKt.replace$default(uuid, Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).substring(0, 12);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return "Player_" + substring;
    }
}

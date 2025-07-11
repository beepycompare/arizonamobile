package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectableValueSetting.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/model/settings/SelectableValueSetting;", "Lcom/arizona/launcher/model/settings/IntSetting;", "settingVisibleName", "", "settingKey", "defaultValue", "", "variants", "", "icon", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;ILandroid/content/SharedPreferences;)V", "getVariants", "()Ljava/util/Map;", "getIcon", "()I", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectableValueSetting extends IntSetting {
    public static final int $stable = 8;
    private final int icon;
    private final Map<Integer, String> variants;

    public final Map<Integer, String> getVariants() {
        return this.variants;
    }

    public final int getIcon() {
        return this.icon;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableValueSetting(String settingVisibleName, String settingKey, int i, Map<Integer, String> variants, int i2, SharedPreferences sharedPreferences) {
        super(settingVisibleName, settingKey, i, sharedPreferences, null, 16, null);
        Intrinsics.checkNotNullParameter(settingVisibleName, "settingVisibleName");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.variants = variants;
        this.icon = i2;
    }
}

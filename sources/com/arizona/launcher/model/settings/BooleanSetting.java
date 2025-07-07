package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BooleanSetting.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/model/settings/BooleanSetting;", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "settingVisibleName", "", "settingKey", "defaultValue", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroid/content/SharedPreferences;)V", "value", "currentValue", "getCurrentValue", "()Z", "setCurrentValue", "(Z)V", "readValueFromPreferences", "writeValueToPreferences", "", "newValue", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BooleanSetting extends AbstractSetting {
    public static final int $stable = 8;
    private boolean currentValue;
    private final boolean defaultValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BooleanSetting(String settingVisibleName, String settingKey, boolean z, SharedPreferences sharedPreferences) {
        super(settingVisibleName, settingKey, sharedPreferences, null);
        Intrinsics.checkNotNullParameter(settingVisibleName, "settingVisibleName");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.defaultValue = z;
        this.currentValue = readValueFromPreferences();
    }

    public final void setCurrentValue(boolean z) {
        this.currentValue = z;
        writeValueToPreferences(z);
    }

    public final boolean getCurrentValue() {
        return readValueFromPreferences();
    }

    private final boolean readValueFromPreferences() {
        return getSharedPreferences().getBoolean(getSettingKey(), this.defaultValue);
    }

    private final void writeValueToPreferences(boolean z) {
        getSharedPreferences().edit().putBoolean(getSettingKey(), z).apply();
    }
}

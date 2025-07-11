package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AbstractSetting.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/model/settings/AbstractSetting;", "", "settingVisibleName", "", "settingKey", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences;)V", "getSettingVisibleName", "()Ljava/lang/String;", "getSettingKey", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "Lcom/arizona/launcher/model/settings/BooleanSetting;", "Lcom/arizona/launcher/model/settings/FloatSetting;", "Lcom/arizona/launcher/model/settings/IntSetting;", "Lcom/arizona/launcher/model/settings/StringSetting;", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractSetting {
    public static final int $stable = 8;
    private final String settingKey;
    private final String settingVisibleName;
    private final SharedPreferences sharedPreferences;

    public /* synthetic */ AbstractSetting(String str, String str2, SharedPreferences sharedPreferences, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, sharedPreferences);
    }

    private AbstractSetting(String str, String str2, SharedPreferences sharedPreferences) {
        this.settingVisibleName = str;
        this.settingKey = str2;
        this.sharedPreferences = sharedPreferences;
    }

    public final String getSettingVisibleName() {
        return this.settingVisibleName;
    }

    public final String getSettingKey() {
        return this.settingKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }
}

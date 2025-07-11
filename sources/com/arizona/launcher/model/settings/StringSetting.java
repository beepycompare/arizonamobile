package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import com.arizona.launcher.model.settings.validation.StringSettingValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StringSetting.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/model/settings/StringSetting;", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "settingVisibleName", "", "settingKey", "defaultValue", "sharedPreferences", "Landroid/content/SharedPreferences;", "icon", "", "validator", "Lcom/arizona/launcher/model/settings/validation/StringSettingValidator;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences;ILcom/arizona/launcher/model/settings/validation/StringSettingValidator;)V", "getIcon", "()I", "isValid", "", "()Z", "setValid", "(Z)V", "value", "currentValue", "getCurrentValue", "()Ljava/lang/String;", "setCurrentValue", "(Ljava/lang/String;)V", "readValueFromPreferences", "writeValueToPreferences", "", "newValue", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringSetting extends AbstractSetting {
    public static final int $stable = 8;
    private String currentValue;
    private final String defaultValue;
    private final int icon;
    private boolean isValid;
    private final StringSettingValidator validator;

    public /* synthetic */ StringSetting(String str, String str2, String str3, SharedPreferences sharedPreferences, int i, StringSettingValidator stringSettingValidator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, sharedPreferences, i, (i2 & 32) != 0 ? null : stringSettingValidator);
    }

    public final int getIcon() {
        return this.icon;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringSetting(String settingVisibleName, String settingKey, String defaultValue, SharedPreferences sharedPreferences, int i, StringSettingValidator stringSettingValidator) {
        super(settingVisibleName, settingKey, sharedPreferences, null);
        Intrinsics.checkNotNullParameter(settingVisibleName, "settingVisibleName");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.defaultValue = defaultValue;
        this.icon = i;
        this.validator = stringSettingValidator;
        this.isValid = true;
        this.currentValue = readValueFromPreferences();
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setValid(boolean z) {
        this.isValid = z;
    }

    public final void setCurrentValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringSettingValidator stringSettingValidator = this.validator;
        if (stringSettingValidator == null || stringSettingValidator.isValueValid(value)) {
            this.currentValue = value;
            writeValueToPreferences(value);
            this.isValid = true;
            return;
        }
        this.isValid = false;
    }

    public final String getCurrentValue() {
        return readValueFromPreferences();
    }

    private final String readValueFromPreferences() {
        String string = getSharedPreferences().getString(getSettingKey(), this.defaultValue);
        return string == null ? "" : string;
    }

    private final void writeValueToPreferences(String str) {
        getSharedPreferences().edit().putString(getSettingKey(), str).apply();
    }
}

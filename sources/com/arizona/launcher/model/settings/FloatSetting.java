package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import com.arizona.launcher.model.settings.validation.FloatSettingValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FloatSetting.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/model/settings/FloatSetting;", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "settingVisibleName", "", "settingKey", "defaultValue", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "validator", "Lcom/arizona/launcher/model/settings/validation/FloatSettingValidator;", "<init>", "(Ljava/lang/String;Ljava/lang/String;FLandroid/content/SharedPreferences;Lcom/arizona/launcher/model/settings/validation/FloatSettingValidator;)V", "isValid", "", "()Z", "setValid", "(Z)V", "value", "currentValue", "getCurrentValue", "()F", "setCurrentValue", "(F)V", "readValueFromPreferences", "writeValueToPreferences", "", "newValue", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public class FloatSetting extends AbstractSetting {
    public static final int $stable = 8;
    private float currentValue;
    private final float defaultValue;
    private boolean isValid;
    private final FloatSettingValidator validator;

    public /* synthetic */ FloatSetting(String str, String str2, float f, SharedPreferences sharedPreferences, FloatSettingValidator floatSettingValidator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f, sharedPreferences, (i & 16) != 0 ? null : floatSettingValidator);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatSetting(String settingVisibleName, String settingKey, float f, SharedPreferences sharedPreferences, FloatSettingValidator floatSettingValidator) {
        super(settingVisibleName, settingKey, sharedPreferences, null);
        Intrinsics.checkNotNullParameter(settingVisibleName, "settingVisibleName");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.defaultValue = f;
        this.validator = floatSettingValidator;
        this.isValid = true;
        this.currentValue = readValueFromPreferences();
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setValid(boolean z) {
        this.isValid = z;
    }

    public final void setCurrentValue(float f) {
        FloatSettingValidator floatSettingValidator = this.validator;
        if (floatSettingValidator == null || floatSettingValidator.isValueValid(Float.valueOf(f))) {
            this.currentValue = f;
            writeValueToPreferences(f);
            this.isValid = true;
            return;
        }
        this.isValid = false;
    }

    public final float getCurrentValue() {
        return readValueFromPreferences();
    }

    private final float readValueFromPreferences() {
        return getSharedPreferences().getFloat(getSettingKey(), this.defaultValue);
    }

    private final void writeValueToPreferences(float f) {
        getSharedPreferences().edit().putFloat(getSettingKey(), f).apply();
    }
}

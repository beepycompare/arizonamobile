package com.arizona.launcher.model.settings;

import android.content.SharedPreferences;
import com.arizona.launcher.model.settings.validation.IntSettingValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IntSetting.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/model/settings/IntSetting;", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "settingVisibleName", "", "settingKey", "defaultValue", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "validator", "Lcom/arizona/launcher/model/settings/validation/IntSettingValidator;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/SharedPreferences;Lcom/arizona/launcher/model/settings/validation/IntSettingValidator;)V", "isValid", "", "()Z", "setValid", "(Z)V", "value", "currentValue", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "readValueFromPreferences", "writeValueToPreferences", "", "newValue", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class IntSetting extends AbstractSetting {
    public static final int $stable = 8;
    private int currentValue;
    private final int defaultValue;
    private boolean isValid;
    private final IntSettingValidator validator;

    public /* synthetic */ IntSetting(String str, String str2, int i, SharedPreferences sharedPreferences, IntSettingValidator intSettingValidator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, sharedPreferences, (i2 & 16) != 0 ? null : intSettingValidator);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntSetting(String settingVisibleName, String settingKey, int i, SharedPreferences sharedPreferences, IntSettingValidator intSettingValidator) {
        super(settingVisibleName, settingKey, sharedPreferences, null);
        Intrinsics.checkNotNullParameter(settingVisibleName, "settingVisibleName");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.defaultValue = i;
        this.validator = intSettingValidator;
        this.isValid = true;
        this.currentValue = readValueFromPreferences();
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setValid(boolean z) {
        this.isValid = z;
    }

    public final void setCurrentValue(int i) {
        IntSettingValidator intSettingValidator = this.validator;
        if (intSettingValidator == null || intSettingValidator.isValueValid(Integer.valueOf(i))) {
            this.currentValue = i;
            writeValueToPreferences(i);
            this.isValid = true;
            return;
        }
        this.isValid = false;
    }

    public final int getCurrentValue() {
        return readValueFromPreferences();
    }

    private final int readValueFromPreferences() {
        return getSharedPreferences().getInt(getSettingKey(), this.defaultValue);
    }

    private final void writeValueToPreferences(int i) {
        getSharedPreferences().edit().putInt(getSettingKey(), i).apply();
    }
}

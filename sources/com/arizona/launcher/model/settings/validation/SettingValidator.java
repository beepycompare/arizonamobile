package com.arizona.launcher.model.settings.validation;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingValidator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/model/settings/validation/SettingValidator;", ExifInterface.GPS_DIRECTION_TRUE, "", "validator", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "isValueValid", "value", "(Ljava/lang/Object;)Z", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SettingValidator<T> {
    public static final int $stable = 0;
    private final Function1<T, Boolean> validator;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingValidator(Function1<? super T, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        this.validator = validator;
    }

    public final boolean isValueValid(T t) {
        return this.validator.invoke(t).booleanValue();
    }
}

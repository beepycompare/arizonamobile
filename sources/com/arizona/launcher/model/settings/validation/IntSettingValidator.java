package com.arizona.launcher.model.settings.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IntSettingValidator.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/model/settings/validation/IntSettingValidator;", "Lcom/arizona/launcher/model/settings/validation/SettingValidator;", "", "validator", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntSettingValidator extends SettingValidator<Integer> {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntSettingValidator(Function1<? super Integer, Boolean> validator) {
        super(validator);
        Intrinsics.checkNotNullParameter(validator, "validator");
    }
}

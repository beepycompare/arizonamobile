package com.arizona.launcher.model.settings.validation;

import com.arizona.launcher.model.settings.validation.StringSettingValidator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: StringSettingValidator.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/model/settings/validation/StringSettingValidator;", "Lcom/arizona/launcher/model/settings/validation/SettingValidator;", "", "validator", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringSettingValidator extends SettingValidator<String> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: StringSettingValidator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/model/settings/validation/StringSettingValidator$Companion;", "", "<init>", "()V", "createByRegexp", "Lcom/arizona/launcher/model/settings/validation/StringSettingValidator;", "regex", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StringSettingValidator createByRegexp(final String regex) {
            Intrinsics.checkNotNullParameter(regex, "regex");
            return new StringSettingValidator(new Function1() { // from class: com.arizona.launcher.model.settings.validation.StringSettingValidator$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean createByRegexp$lambda$0;
                    createByRegexp$lambda$0 = StringSettingValidator.Companion.createByRegexp$lambda$0(regex, (String) obj);
                    return Boolean.valueOf(createByRegexp$lambda$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean createByRegexp$lambda$0(String str, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Regex(str).matches(it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringSettingValidator(Function1<? super String, Boolean> validator) {
        super(validator);
        Intrinsics.checkNotNullParameter(validator, "validator");
    }
}

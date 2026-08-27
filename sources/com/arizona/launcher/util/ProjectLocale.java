package com.arizona.launcher.util;

import android.content.Context;
import android.content.res.Configuration;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProjectLocale.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\u00020\u0005H\u0007b\u0002\b\bJ\f\u0010\t\u001a\u00020\nH\u0007b\u0002\b\bJ\u0014\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007b\u0002\b\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/util/ProjectLocale;", "", "<init>", "()V", "LOCALE_RU", "Ljava/util/Locale;", "LOCALE_PT_BR", "resolve", "Lkotlin/jvm/JvmStatic;", "applyDefault", "", "wrap", "Landroid/content/Context;", "context", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProjectLocale {
    public static final int $stable = 0;
    public static final ProjectLocale INSTANCE = new ProjectLocale();
    private static final Locale LOCALE_PT_BR;
    private static final Locale LOCALE_RU;

    private ProjectLocale() {
    }

    static {
        Locale forLanguageTag = Locale.forLanguageTag("ru-RU");
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(...)");
        LOCALE_RU = forLanguageTag;
        Locale forLanguageTag2 = Locale.forLanguageTag("pt-BR");
        Intrinsics.checkNotNullExpressionValue(forLanguageTag2, "forLanguageTag(...)");
        LOCALE_PT_BR = forLanguageTag2;
    }

    @JvmStatic
    public static final Locale resolve() {
        if (FlavorUtilKt.isBrazil()) {
            return LOCALE_PT_BR;
        }
        return LOCALE_RU;
    }

    @JvmStatic
    public static final void applyDefault() {
        Locale.setDefault(resolve());
    }

    @JvmStatic
    public static final Context wrap(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Locale resolve = resolve();
        Locale.setDefault(resolve);
        Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
        if (locale != null && Intrinsics.areEqual(locale.getLanguage(), resolve.getLanguage()) && Intrinsics.areEqual(locale.getCountry(), resolve.getCountry())) {
            return context;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(resolve);
        configuration.setLayoutDirection(resolve);
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "createConfigurationContext(...)");
        return createConfigurationContext;
    }
}

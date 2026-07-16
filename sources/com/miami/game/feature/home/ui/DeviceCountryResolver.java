package com.miami.game.feature.home.ui;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.core.os.ConfigurationCompat;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: DeviceCountryResolver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/miami/game/feature/home/ui/DeviceCountryResolver;", "", "<init>", "()V", "isoCountryRegex", "Lkotlin/text/Regex;", "detectCountryIso", "", "context", "Landroid/content/Context;", "home", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceCountryResolver {
    public static final int $stable = 0;
    public static final DeviceCountryResolver INSTANCE = new DeviceCountryResolver();
    private static final Regex isoCountryRegex = new Regex("[A-Z]{2}");

    private DeviceCountryResolver() {
    }

    public final String detectCountryIso(Context context) {
        Object m9898constructorimpl;
        Object m9898constructorimpl2;
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext.getSystemService("phone");
        Object obj = null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        try {
            Result.Companion companion = Result.Companion;
            DeviceCountryResolver deviceCountryResolver = this;
            m9898constructorimpl = Result.m9898constructorimpl(telephonyManager != null ? telephonyManager.getNetworkCountryIso() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9904isFailureimpl(m9898constructorimpl)) {
            m9898constructorimpl = null;
        }
        String str = (String) m9898constructorimpl;
        try {
            Result.Companion companion3 = Result.Companion;
            DeviceCountryResolver deviceCountryResolver2 = this;
            m9898constructorimpl2 = Result.m9898constructorimpl(telephonyManager != null ? telephonyManager.getSimCountryIso() : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m9898constructorimpl2 = Result.m9898constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m9904isFailureimpl(m9898constructorimpl2)) {
            m9898constructorimpl2 = null;
        }
        String str2 = (String) m9898constructorimpl2;
        Locale locale = ConfigurationCompat.getLocales(applicationContext.getResources().getConfiguration()).get(0);
        Iterator it = SequencesKt.mapNotNull(SequencesKt.sequenceOf((Object[]) new String[]{str, str2, locale != null ? locale.getCountry() : null}), new Function1() { // from class: com.miami.game.feature.home.ui.DeviceCountryResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeviceCountryResolver.detectCountryIso$lambda$2((String) obj2);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (isoCountryRegex.matches((String) next)) {
                obj = next;
                break;
            }
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String detectCountryIso$lambda$2(String str) {
        String obj;
        if (str == null || (obj = StringsKt.trim((CharSequence) str).toString()) == null) {
            return null;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = obj.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}

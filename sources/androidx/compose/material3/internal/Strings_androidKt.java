package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.ConfigurationCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* compiled from: Strings.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"getString", "", TypedValues.Custom.S_STRING, "Landroidx/compose/material3/internal/Strings;", "getString-2EP1pXo", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-qBjtwXw", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Strings_androidKt {
    /* renamed from: getString-2EP1pXo  reason: not valid java name */
    public static final String m2779getString2EP1pXo(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -907677715, "C(getString)P(0:c#material3.internal.Strings)31@1161L7,32@1202L7:Strings.android.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-907677715, i2, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        String string = ((Context) consume).getResources().getString(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    /* renamed from: getString-qBjtwXw  reason: not valid java name */
    public static final String m2780getStringqBjtwXw(int i, Object[] objArr, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1427268608, "C(getString)P(1:c#material3.internal.Strings)39@1395L17,41@1488L7:Strings.android.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1427268608, i2, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:38)");
        }
        String m2779getString2EP1pXo = m2779getString2EP1pXo(i, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Locale locale = ConfigurationCompat.getLocales((Configuration) consume).get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, m2779getString2EP1pXo, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return format;
    }
}

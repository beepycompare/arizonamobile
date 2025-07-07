package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformTypefaces.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ<\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PlatformTypefacesApi28 implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo6288optionalOnDeviceFontFamilyByName78DK7lM(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, Context context) {
        android.graphics.Typeface mo6287createNamedRetOiIg;
        if (Intrinsics.areEqual(str, FontFamily.Companion.getSansSerif().getName())) {
            mo6287createNamedRetOiIg = mo6287createNamedRetOiIg(FontFamily.Companion.getSansSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, FontFamily.Companion.getSerif().getName())) {
            mo6287createNamedRetOiIg = mo6287createNamedRetOiIg(FontFamily.Companion.getSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, FontFamily.Companion.getMonospace().getName())) {
            mo6287createNamedRetOiIg = mo6287createNamedRetOiIg(FontFamily.Companion.getMonospace(), fontWeight, i);
        } else {
            mo6287createNamedRetOiIg = Intrinsics.areEqual(str, FontFamily.Companion.getCursive().getName()) ? mo6287createNamedRetOiIg(FontFamily.Companion.getCursive(), fontWeight, i) : m6294loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(mo6287createNamedRetOiIg, settings, context);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo6286createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m6292createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo6287createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        return m6292createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg  reason: not valid java name */
    private final android.graphics.Typeface m6294loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface m6292createAndroidTypefaceApi28RetOiIg = m6292createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual(m6292createAndroidTypefaceApi28RetOiIg, TypefaceHelperMethodsApi28.INSTANCE.create(android.graphics.Typeface.DEFAULT, fontWeight.getWeight(), FontStyle.m6259equalsimpl0(i, FontStyle.Companion.m6265getItalic_LCdwA()))) || Intrinsics.areEqual(m6292createAndroidTypefaceApi28RetOiIg, m6292createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) {
            return null;
        }
        return m6292createAndroidTypefaceApi28RetOiIg;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default  reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m6293createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m6292createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg  reason: not valid java name */
    private final android.graphics.Typeface m6292createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        android.graphics.Typeface create;
        String str2;
        if (FontStyle.m6259equalsimpl0(i, FontStyle.Companion.m6266getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && ((str2 = str) == null || str2.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        if (str == null) {
            create = android.graphics.Typeface.DEFAULT;
        } else {
            create = android.graphics.Typeface.create(str, 0);
        }
        return android.graphics.Typeface.create(create, fontWeight.getWeight(), FontStyle.m6259equalsimpl0(i, FontStyle.Companion.m6265getItalic_LCdwA()));
    }
}

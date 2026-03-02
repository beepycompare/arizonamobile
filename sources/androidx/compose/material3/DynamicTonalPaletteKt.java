package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import androidx.compose.material3.internal.colorUtil.Cam;
import androidx.compose.material3.internal.colorUtil.CamUtils;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
/* compiled from: DynamicTonalPalette.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0012"}, d2 = {"dynamicTonalPalette", "Landroidx/compose/material3/TonalPalette;", "context", "Landroid/content/Context;", "dynamicLightColorScheme", "Landroidx/compose/material3/ColorScheme;", "dynamicDarkColorScheme", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "", "setLuminance-DxMtmZc", "(JF)J", "dynamicLightColorScheme31", "tonalPalette", "dynamicLightColorScheme34", "dynamicDarkColorScheme31", "dynamicDarkColorScheme34", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DynamicTonalPaletteKt {
    public static final TonalPalette dynamicTonalPalette(Context context) {
        return new TonalPalette(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170461), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170462), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 98.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 96.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170463), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 94.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 92.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170464), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 87.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170465), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170466), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170467), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170468), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170470), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 24.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 22.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170471), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 17.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 12.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170472), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 6.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170469), 4.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170473), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170474), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170475), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 98.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 96.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170476), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 94.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 92.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170477), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 87.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170478), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170479), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170480), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170481), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170483), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 24.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 22.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170484), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 17.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 12.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170485), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 6.0f), m2051setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170482), 4.0f), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170486), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170487), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170488), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170489), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170490), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170491), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170492), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170493), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170494), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170495), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170496), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170497), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170498), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170499), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170500), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170501), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170502), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170503), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170504), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170505), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170506), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170507), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170508), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170509), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170510), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170511), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170512), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170513), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170514), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170515), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170516), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170517), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170518), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170519), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170520), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170521), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170522), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170523), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170524), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170525), null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicLightColorScheme34(context);
        }
        return dynamicLightColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicDarkColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicDarkColorScheme34(context);
        }
        return dynamicDarkColorScheme31(dynamicTonalPalette(context));
    }

    /* renamed from: setLuminance-DxMtmZc  reason: not valid java name */
    public static final long m2051setLuminanceDxMtmZc(long j, float f) {
        double d = f;
        if ((d < 1.0E-4d) | (d > 99.9999d)) {
            return ColorKt.Color(CamUtils.INSTANCE.argbFromLstar(d));
        }
        Cam fromInt = Cam.Companion.fromInt(ColorKt.m4826toArgb8_81llA(j));
        return ColorKt.Color(Cam.Companion.getInt(fromInt.getHue(), fromInt.getChroma(), f));
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long m2837getPrimary400d7_KjU = tonalPalette.m2837getPrimary400d7_KjU();
        long m2834getPrimary1000d7_KjU = tonalPalette.m2834getPrimary1000d7_KjU();
        long m2842getPrimary900d7_KjU = tonalPalette.m2842getPrimary900d7_KjU();
        long m2833getPrimary100d7_KjU = tonalPalette.m2833getPrimary100d7_KjU();
        long m2841getPrimary800d7_KjU = tonalPalette.m2841getPrimary800d7_KjU();
        long m2850getSecondary400d7_KjU = tonalPalette.m2850getSecondary400d7_KjU();
        long m2847getSecondary1000d7_KjU = tonalPalette.m2847getSecondary1000d7_KjU();
        long m2855getSecondary900d7_KjU = tonalPalette.m2855getSecondary900d7_KjU();
        long m2846getSecondary100d7_KjU = tonalPalette.m2846getSecondary100d7_KjU();
        long m2863getTertiary400d7_KjU = tonalPalette.m2863getTertiary400d7_KjU();
        long m2860getTertiary1000d7_KjU = tonalPalette.m2860getTertiary1000d7_KjU();
        long m2868getTertiary900d7_KjU = tonalPalette.m2868getTertiary900d7_KjU();
        long m2859getTertiary100d7_KjU = tonalPalette.m2859getTertiary100d7_KjU();
        long m2830getNeutralVariant980d7_KjU = tonalPalette.m2830getNeutralVariant980d7_KjU();
        long m2809getNeutralVariant100d7_KjU = tonalPalette.m2809getNeutralVariant100d7_KjU();
        long m2830getNeutralVariant980d7_KjU2 = tonalPalette.m2830getNeutralVariant980d7_KjU();
        long m2809getNeutralVariant100d7_KjU2 = tonalPalette.m2809getNeutralVariant100d7_KjU();
        long m2825getNeutralVariant900d7_KjU = tonalPalette.m2825getNeutralVariant900d7_KjU();
        long m2816getNeutralVariant300d7_KjU = tonalPalette.m2816getNeutralVariant300d7_KjU();
        long m2813getNeutralVariant200d7_KjU = tonalPalette.m2813getNeutralVariant200d7_KjU();
        long m2828getNeutralVariant950d7_KjU = tonalPalette.m2828getNeutralVariant950d7_KjU();
        long m2819getNeutralVariant500d7_KjU = tonalPalette.m2819getNeutralVariant500d7_KjU();
        long m2823getNeutralVariant800d7_KjU = tonalPalette.m2823getNeutralVariant800d7_KjU();
        long m2808getNeutralVariant00d7_KjU = tonalPalette.m2808getNeutralVariant00d7_KjU();
        long m2830getNeutralVariant980d7_KjU3 = tonalPalette.m2830getNeutralVariant980d7_KjU();
        long m2824getNeutralVariant870d7_KjU = tonalPalette.m2824getNeutralVariant870d7_KjU();
        return ColorSchemeKt.m1914lightColorScheme_VG5OTI$default(m2837getPrimary400d7_KjU, m2834getPrimary1000d7_KjU, m2842getPrimary900d7_KjU, m2833getPrimary100d7_KjU, m2841getPrimary800d7_KjU, m2850getSecondary400d7_KjU, m2847getSecondary1000d7_KjU, m2855getSecondary900d7_KjU, m2846getSecondary100d7_KjU, m2863getTertiary400d7_KjU, m2860getTertiary1000d7_KjU, m2868getTertiary900d7_KjU, m2859getTertiary100d7_KjU, m2830getNeutralVariant980d7_KjU, m2809getNeutralVariant100d7_KjU, m2830getNeutralVariant980d7_KjU2, m2809getNeutralVariant100d7_KjU2, m2825getNeutralVariant900d7_KjU, m2816getNeutralVariant300d7_KjU, tonalPalette.m2837getPrimary400d7_KjU(), m2813getNeutralVariant200d7_KjU, m2828getNeutralVariant950d7_KjU, 0L, 0L, 0L, 0L, m2819getNeutralVariant500d7_KjU, m2823getNeutralVariant800d7_KjU, m2808getNeutralVariant00d7_KjU, m2830getNeutralVariant980d7_KjU3, tonalPalette.m2827getNeutralVariant940d7_KjU(), tonalPalette.m2826getNeutralVariant920d7_KjU(), tonalPalette.m2825getNeutralVariant900d7_KjU(), tonalPalette.m2829getNeutralVariant960d7_KjU(), tonalPalette.m2810getNeutralVariant1000d7_KjU(), m2824getNeutralVariant870d7_KjU, tonalPalette.m2842getPrimary900d7_KjU(), tonalPalette.m2841getPrimary800d7_KjU(), tonalPalette.m2833getPrimary100d7_KjU(), tonalPalette.m2836getPrimary300d7_KjU(), tonalPalette.m2855getSecondary900d7_KjU(), tonalPalette.m2854getSecondary800d7_KjU(), tonalPalette.m2846getSecondary100d7_KjU(), tonalPalette.m2849getSecondary300d7_KjU(), tonalPalette.m2868getTertiary900d7_KjU(), tonalPalette.m2867getTertiary800d7_KjU(), tonalPalette.m2859getTertiary100d7_KjU(), tonalPalette.m2862getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        long m1845getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170528);
        long m1845getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170529);
        long m1845getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170526);
        long m1845getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170527);
        long m1845getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170571);
        long m1845getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170532);
        long m1845getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170533);
        long m1845getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170530);
        long m1845getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170531);
        long m1845getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170536);
        long m1845getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170537);
        long m1845getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170534);
        long m1845getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170535);
        long m1845getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170538);
        long m1845getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170539);
        long m1845getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170540);
        long m1845getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170541);
        long m1845getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170549);
        long m1845getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170550);
        long m1845getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170583);
        long m1845getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170584);
        long m1845getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170551);
        long m1845getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170624);
        long m1845getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170547);
        long m1845getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170548);
        return ColorSchemeKt.m1914lightColorScheme_VG5OTI$default(m1845getColorWaAFU9c, m1845getColorWaAFU9c2, m1845getColorWaAFU9c3, m1845getColorWaAFU9c4, m1845getColorWaAFU9c5, m1845getColorWaAFU9c6, m1845getColorWaAFU9c7, m1845getColorWaAFU9c8, m1845getColorWaAFU9c9, m1845getColorWaAFU9c10, m1845getColorWaAFU9c11, m1845getColorWaAFU9c12, m1845getColorWaAFU9c13, m1845getColorWaAFU9c14, m1845getColorWaAFU9c15, m1845getColorWaAFU9c16, m1845getColorWaAFU9c17, m1845getColorWaAFU9c18, m1845getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170528), m1845getColorWaAFU9c20, m1845getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1845getColorWaAFU9c22, m1845getColorWaAFU9c23, 0L, m1845getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170544), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170545), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170546), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170542), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170543), m1845getColorWaAFU9c25, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170612), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170613), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170614), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170615), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170616), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170617), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170618), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170619), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170620), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170621), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170622), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170623), 331350016, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long m2841getPrimary800d7_KjU = tonalPalette.m2841getPrimary800d7_KjU();
        long m2835getPrimary200d7_KjU = tonalPalette.m2835getPrimary200d7_KjU();
        long m2836getPrimary300d7_KjU = tonalPalette.m2836getPrimary300d7_KjU();
        long m2842getPrimary900d7_KjU = tonalPalette.m2842getPrimary900d7_KjU();
        long m2837getPrimary400d7_KjU = tonalPalette.m2837getPrimary400d7_KjU();
        long m2854getSecondary800d7_KjU = tonalPalette.m2854getSecondary800d7_KjU();
        long m2848getSecondary200d7_KjU = tonalPalette.m2848getSecondary200d7_KjU();
        long m2849getSecondary300d7_KjU = tonalPalette.m2849getSecondary300d7_KjU();
        long m2855getSecondary900d7_KjU = tonalPalette.m2855getSecondary900d7_KjU();
        long m2867getTertiary800d7_KjU = tonalPalette.m2867getTertiary800d7_KjU();
        long m2861getTertiary200d7_KjU = tonalPalette.m2861getTertiary200d7_KjU();
        long m2862getTertiary300d7_KjU = tonalPalette.m2862getTertiary300d7_KjU();
        long m2868getTertiary900d7_KjU = tonalPalette.m2868getTertiary900d7_KjU();
        long m2820getNeutralVariant60d7_KjU = tonalPalette.m2820getNeutralVariant60d7_KjU();
        long m2825getNeutralVariant900d7_KjU = tonalPalette.m2825getNeutralVariant900d7_KjU();
        long m2820getNeutralVariant60d7_KjU2 = tonalPalette.m2820getNeutralVariant60d7_KjU();
        long m2825getNeutralVariant900d7_KjU2 = tonalPalette.m2825getNeutralVariant900d7_KjU();
        long m2816getNeutralVariant300d7_KjU = tonalPalette.m2816getNeutralVariant300d7_KjU();
        long m2823getNeutralVariant800d7_KjU = tonalPalette.m2823getNeutralVariant800d7_KjU();
        long m2825getNeutralVariant900d7_KjU3 = tonalPalette.m2825getNeutralVariant900d7_KjU();
        long m2813getNeutralVariant200d7_KjU = tonalPalette.m2813getNeutralVariant200d7_KjU();
        long m2821getNeutralVariant600d7_KjU = tonalPalette.m2821getNeutralVariant600d7_KjU();
        long m2816getNeutralVariant300d7_KjU2 = tonalPalette.m2816getNeutralVariant300d7_KjU();
        long m2808getNeutralVariant00d7_KjU = tonalPalette.m2808getNeutralVariant00d7_KjU();
        long m2815getNeutralVariant240d7_KjU = tonalPalette.m2815getNeutralVariant240d7_KjU();
        long m2820getNeutralVariant60d7_KjU3 = tonalPalette.m2820getNeutralVariant60d7_KjU();
        return ColorSchemeKt.m1908darkColorScheme_VG5OTI$default(m2841getPrimary800d7_KjU, m2835getPrimary200d7_KjU, m2836getPrimary300d7_KjU, m2842getPrimary900d7_KjU, m2837getPrimary400d7_KjU, m2854getSecondary800d7_KjU, m2848getSecondary200d7_KjU, m2849getSecondary300d7_KjU, m2855getSecondary900d7_KjU, m2867getTertiary800d7_KjU, m2861getTertiary200d7_KjU, m2862getTertiary300d7_KjU, m2868getTertiary900d7_KjU, m2820getNeutralVariant60d7_KjU, m2825getNeutralVariant900d7_KjU, m2820getNeutralVariant60d7_KjU2, m2825getNeutralVariant900d7_KjU2, m2816getNeutralVariant300d7_KjU, m2823getNeutralVariant800d7_KjU, tonalPalette.m2841getPrimary800d7_KjU(), m2825getNeutralVariant900d7_KjU3, m2813getNeutralVariant200d7_KjU, 0L, 0L, 0L, 0L, m2821getNeutralVariant600d7_KjU, m2816getNeutralVariant300d7_KjU2, m2808getNeutralVariant00d7_KjU, m2815getNeutralVariant240d7_KjU, tonalPalette.m2811getNeutralVariant120d7_KjU(), tonalPalette.m2812getNeutralVariant170d7_KjU(), tonalPalette.m2814getNeutralVariant220d7_KjU(), tonalPalette.m2809getNeutralVariant100d7_KjU(), tonalPalette.m2817getNeutralVariant40d7_KjU(), m2820getNeutralVariant60d7_KjU3, tonalPalette.m2842getPrimary900d7_KjU(), tonalPalette.m2841getPrimary800d7_KjU(), tonalPalette.m2833getPrimary100d7_KjU(), tonalPalette.m2836getPrimary300d7_KjU(), tonalPalette.m2855getSecondary900d7_KjU(), tonalPalette.m2854getSecondary800d7_KjU(), tonalPalette.m2846getSecondary100d7_KjU(), tonalPalette.m2849getSecondary300d7_KjU(), tonalPalette.m2868getTertiary900d7_KjU(), tonalPalette.m2867getTertiary800d7_KjU(), tonalPalette.m2859getTertiary100d7_KjU(), tonalPalette.m2862getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        long m1845getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170571);
        long m1845getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170572);
        long m1845getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170569);
        long m1845getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170570);
        long m1845getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170528);
        long m1845getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170575);
        long m1845getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170576);
        long m1845getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170573);
        long m1845getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170574);
        long m1845getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170579);
        long m1845getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170580);
        long m1845getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170577);
        long m1845getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170578);
        long m1845getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170581);
        long m1845getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170582);
        long m1845getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170583);
        long m1845getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170584);
        long m1845getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170592);
        long m1845getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170593);
        long m1845getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170540);
        long m1845getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170541);
        long m1845getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170594);
        long m1845getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170625);
        long m1845getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170590);
        long m1845getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170591);
        return ColorSchemeKt.m1908darkColorScheme_VG5OTI$default(m1845getColorWaAFU9c, m1845getColorWaAFU9c2, m1845getColorWaAFU9c3, m1845getColorWaAFU9c4, m1845getColorWaAFU9c5, m1845getColorWaAFU9c6, m1845getColorWaAFU9c7, m1845getColorWaAFU9c8, m1845getColorWaAFU9c9, m1845getColorWaAFU9c10, m1845getColorWaAFU9c11, m1845getColorWaAFU9c12, m1845getColorWaAFU9c13, m1845getColorWaAFU9c14, m1845getColorWaAFU9c15, m1845getColorWaAFU9c16, m1845getColorWaAFU9c17, m1845getColorWaAFU9c18, m1845getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170571), m1845getColorWaAFU9c20, m1845getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1845getColorWaAFU9c22, m1845getColorWaAFU9c23, 0L, m1845getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170587), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170588), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170589), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170585), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170586), m1845getColorWaAFU9c25, ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170612), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170613), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170614), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170615), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170616), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170617), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170618), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170619), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170620), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170621), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170622), ColorResourceHelper.INSTANCE.m1845getColorWaAFU9c(context, 17170623), 331350016, 0, null);
    }
}

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
        return new TonalPalette(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170461), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170462), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 98.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 96.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170463), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 94.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 92.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170464), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 87.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170465), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170466), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170467), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170468), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170470), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 24.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 22.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170471), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 17.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 12.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170472), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 6.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170469), 4.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170473), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170474), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170475), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 98.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 96.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170476), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 94.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 92.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170477), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 87.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170478), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170479), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170480), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170481), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170483), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 24.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 22.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170484), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 17.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 12.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170485), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 6.0f), m2334setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170482), 4.0f), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170486), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170487), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170488), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170489), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170490), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170491), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170492), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170493), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170494), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170495), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170496), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170497), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170498), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170499), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170500), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170501), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170502), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170503), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170504), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170505), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170506), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170507), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170508), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170509), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170510), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170511), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170512), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170513), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170514), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170515), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170516), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170517), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170518), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170519), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170520), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170521), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170522), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170523), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170524), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170525), null);
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
    public static final long m2334setLuminanceDxMtmZc(long j, float f) {
        double d = f;
        if ((d < 1.0E-4d) | (d > 99.9999d)) {
            return ColorKt.Color(CamUtils.INSTANCE.argbFromLstar(d));
        }
        Cam fromInt = Cam.Companion.fromInt(ColorKt.m5334toArgb8_81llA(j));
        return ColorKt.Color(Cam.Companion.getInt(fromInt.getHue(), fromInt.getChroma(), f));
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long m3312getPrimary400d7_KjU = tonalPalette.m3312getPrimary400d7_KjU();
        long m3309getPrimary1000d7_KjU = tonalPalette.m3309getPrimary1000d7_KjU();
        long m3317getPrimary900d7_KjU = tonalPalette.m3317getPrimary900d7_KjU();
        long m3308getPrimary100d7_KjU = tonalPalette.m3308getPrimary100d7_KjU();
        long m3316getPrimary800d7_KjU = tonalPalette.m3316getPrimary800d7_KjU();
        long m3325getSecondary400d7_KjU = tonalPalette.m3325getSecondary400d7_KjU();
        long m3322getSecondary1000d7_KjU = tonalPalette.m3322getSecondary1000d7_KjU();
        long m3330getSecondary900d7_KjU = tonalPalette.m3330getSecondary900d7_KjU();
        long m3321getSecondary100d7_KjU = tonalPalette.m3321getSecondary100d7_KjU();
        long m3338getTertiary400d7_KjU = tonalPalette.m3338getTertiary400d7_KjU();
        long m3335getTertiary1000d7_KjU = tonalPalette.m3335getTertiary1000d7_KjU();
        long m3343getTertiary900d7_KjU = tonalPalette.m3343getTertiary900d7_KjU();
        long m3334getTertiary100d7_KjU = tonalPalette.m3334getTertiary100d7_KjU();
        long m3305getNeutralVariant980d7_KjU = tonalPalette.m3305getNeutralVariant980d7_KjU();
        long m3284getNeutralVariant100d7_KjU = tonalPalette.m3284getNeutralVariant100d7_KjU();
        long m3305getNeutralVariant980d7_KjU2 = tonalPalette.m3305getNeutralVariant980d7_KjU();
        long m3284getNeutralVariant100d7_KjU2 = tonalPalette.m3284getNeutralVariant100d7_KjU();
        long m3300getNeutralVariant900d7_KjU = tonalPalette.m3300getNeutralVariant900d7_KjU();
        long m3291getNeutralVariant300d7_KjU = tonalPalette.m3291getNeutralVariant300d7_KjU();
        long m3288getNeutralVariant200d7_KjU = tonalPalette.m3288getNeutralVariant200d7_KjU();
        long m3303getNeutralVariant950d7_KjU = tonalPalette.m3303getNeutralVariant950d7_KjU();
        long m3294getNeutralVariant500d7_KjU = tonalPalette.m3294getNeutralVariant500d7_KjU();
        long m3298getNeutralVariant800d7_KjU = tonalPalette.m3298getNeutralVariant800d7_KjU();
        long m3283getNeutralVariant00d7_KjU = tonalPalette.m3283getNeutralVariant00d7_KjU();
        long m3305getNeutralVariant980d7_KjU3 = tonalPalette.m3305getNeutralVariant980d7_KjU();
        long m3299getNeutralVariant870d7_KjU = tonalPalette.m3299getNeutralVariant870d7_KjU();
        return ColorSchemeKt.m2142lightColorScheme_VG5OTI$default(m3312getPrimary400d7_KjU, m3309getPrimary1000d7_KjU, m3317getPrimary900d7_KjU, m3308getPrimary100d7_KjU, m3316getPrimary800d7_KjU, m3325getSecondary400d7_KjU, m3322getSecondary1000d7_KjU, m3330getSecondary900d7_KjU, m3321getSecondary100d7_KjU, m3338getTertiary400d7_KjU, m3335getTertiary1000d7_KjU, m3343getTertiary900d7_KjU, m3334getTertiary100d7_KjU, m3305getNeutralVariant980d7_KjU, m3284getNeutralVariant100d7_KjU, m3305getNeutralVariant980d7_KjU2, m3284getNeutralVariant100d7_KjU2, m3300getNeutralVariant900d7_KjU, m3291getNeutralVariant300d7_KjU, tonalPalette.m3312getPrimary400d7_KjU(), m3288getNeutralVariant200d7_KjU, m3303getNeutralVariant950d7_KjU, 0L, 0L, 0L, 0L, m3294getNeutralVariant500d7_KjU, m3298getNeutralVariant800d7_KjU, m3283getNeutralVariant00d7_KjU, m3305getNeutralVariant980d7_KjU3, tonalPalette.m3302getNeutralVariant940d7_KjU(), tonalPalette.m3301getNeutralVariant920d7_KjU(), tonalPalette.m3300getNeutralVariant900d7_KjU(), tonalPalette.m3304getNeutralVariant960d7_KjU(), tonalPalette.m3285getNeutralVariant1000d7_KjU(), m3299getNeutralVariant870d7_KjU, tonalPalette.m3317getPrimary900d7_KjU(), tonalPalette.m3316getPrimary800d7_KjU(), tonalPalette.m3308getPrimary100d7_KjU(), tonalPalette.m3311getPrimary300d7_KjU(), tonalPalette.m3330getSecondary900d7_KjU(), tonalPalette.m3329getSecondary800d7_KjU(), tonalPalette.m3321getSecondary100d7_KjU(), tonalPalette.m3324getSecondary300d7_KjU(), tonalPalette.m3343getTertiary900d7_KjU(), tonalPalette.m3342getTertiary800d7_KjU(), tonalPalette.m3334getTertiary100d7_KjU(), tonalPalette.m3337getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        long m2071getColorWaAFU9c = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170528);
        long m2071getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170529);
        long m2071getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170526);
        long m2071getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170527);
        long m2071getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170571);
        long m2071getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170532);
        long m2071getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170533);
        long m2071getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170530);
        long m2071getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170531);
        long m2071getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170536);
        long m2071getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170537);
        long m2071getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170534);
        long m2071getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170535);
        long m2071getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170538);
        long m2071getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170539);
        long m2071getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170540);
        long m2071getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170541);
        long m2071getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170549);
        long m2071getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170550);
        long m2071getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170583);
        long m2071getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170584);
        long m2071getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170551);
        long m2071getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170624);
        long m2071getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170547);
        long m2071getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170548);
        return ColorSchemeKt.m2142lightColorScheme_VG5OTI$default(m2071getColorWaAFU9c, m2071getColorWaAFU9c2, m2071getColorWaAFU9c3, m2071getColorWaAFU9c4, m2071getColorWaAFU9c5, m2071getColorWaAFU9c6, m2071getColorWaAFU9c7, m2071getColorWaAFU9c8, m2071getColorWaAFU9c9, m2071getColorWaAFU9c10, m2071getColorWaAFU9c11, m2071getColorWaAFU9c12, m2071getColorWaAFU9c13, m2071getColorWaAFU9c14, m2071getColorWaAFU9c15, m2071getColorWaAFU9c16, m2071getColorWaAFU9c17, m2071getColorWaAFU9c18, m2071getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170528), m2071getColorWaAFU9c20, m2071getColorWaAFU9c21, 0L, 0L, 0L, 0L, m2071getColorWaAFU9c22, m2071getColorWaAFU9c23, 0L, m2071getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170544), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170545), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170546), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170542), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170543), m2071getColorWaAFU9c25, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170612), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170613), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170614), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170615), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170616), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170617), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170618), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170619), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170620), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170621), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170622), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170623), 331350016, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long m3316getPrimary800d7_KjU = tonalPalette.m3316getPrimary800d7_KjU();
        long m3310getPrimary200d7_KjU = tonalPalette.m3310getPrimary200d7_KjU();
        long m3311getPrimary300d7_KjU = tonalPalette.m3311getPrimary300d7_KjU();
        long m3317getPrimary900d7_KjU = tonalPalette.m3317getPrimary900d7_KjU();
        long m3312getPrimary400d7_KjU = tonalPalette.m3312getPrimary400d7_KjU();
        long m3329getSecondary800d7_KjU = tonalPalette.m3329getSecondary800d7_KjU();
        long m3323getSecondary200d7_KjU = tonalPalette.m3323getSecondary200d7_KjU();
        long m3324getSecondary300d7_KjU = tonalPalette.m3324getSecondary300d7_KjU();
        long m3330getSecondary900d7_KjU = tonalPalette.m3330getSecondary900d7_KjU();
        long m3342getTertiary800d7_KjU = tonalPalette.m3342getTertiary800d7_KjU();
        long m3336getTertiary200d7_KjU = tonalPalette.m3336getTertiary200d7_KjU();
        long m3337getTertiary300d7_KjU = tonalPalette.m3337getTertiary300d7_KjU();
        long m3343getTertiary900d7_KjU = tonalPalette.m3343getTertiary900d7_KjU();
        long m3295getNeutralVariant60d7_KjU = tonalPalette.m3295getNeutralVariant60d7_KjU();
        long m3300getNeutralVariant900d7_KjU = tonalPalette.m3300getNeutralVariant900d7_KjU();
        long m3295getNeutralVariant60d7_KjU2 = tonalPalette.m3295getNeutralVariant60d7_KjU();
        long m3300getNeutralVariant900d7_KjU2 = tonalPalette.m3300getNeutralVariant900d7_KjU();
        long m3291getNeutralVariant300d7_KjU = tonalPalette.m3291getNeutralVariant300d7_KjU();
        long m3298getNeutralVariant800d7_KjU = tonalPalette.m3298getNeutralVariant800d7_KjU();
        long m3300getNeutralVariant900d7_KjU3 = tonalPalette.m3300getNeutralVariant900d7_KjU();
        long m3288getNeutralVariant200d7_KjU = tonalPalette.m3288getNeutralVariant200d7_KjU();
        long m3296getNeutralVariant600d7_KjU = tonalPalette.m3296getNeutralVariant600d7_KjU();
        long m3291getNeutralVariant300d7_KjU2 = tonalPalette.m3291getNeutralVariant300d7_KjU();
        long m3283getNeutralVariant00d7_KjU = tonalPalette.m3283getNeutralVariant00d7_KjU();
        long m3290getNeutralVariant240d7_KjU = tonalPalette.m3290getNeutralVariant240d7_KjU();
        long m3295getNeutralVariant60d7_KjU3 = tonalPalette.m3295getNeutralVariant60d7_KjU();
        return ColorSchemeKt.m2136darkColorScheme_VG5OTI$default(m3316getPrimary800d7_KjU, m3310getPrimary200d7_KjU, m3311getPrimary300d7_KjU, m3317getPrimary900d7_KjU, m3312getPrimary400d7_KjU, m3329getSecondary800d7_KjU, m3323getSecondary200d7_KjU, m3324getSecondary300d7_KjU, m3330getSecondary900d7_KjU, m3342getTertiary800d7_KjU, m3336getTertiary200d7_KjU, m3337getTertiary300d7_KjU, m3343getTertiary900d7_KjU, m3295getNeutralVariant60d7_KjU, m3300getNeutralVariant900d7_KjU, m3295getNeutralVariant60d7_KjU2, m3300getNeutralVariant900d7_KjU2, m3291getNeutralVariant300d7_KjU, m3298getNeutralVariant800d7_KjU, tonalPalette.m3316getPrimary800d7_KjU(), m3300getNeutralVariant900d7_KjU3, m3288getNeutralVariant200d7_KjU, 0L, 0L, 0L, 0L, m3296getNeutralVariant600d7_KjU, m3291getNeutralVariant300d7_KjU2, m3283getNeutralVariant00d7_KjU, m3290getNeutralVariant240d7_KjU, tonalPalette.m3286getNeutralVariant120d7_KjU(), tonalPalette.m3287getNeutralVariant170d7_KjU(), tonalPalette.m3289getNeutralVariant220d7_KjU(), tonalPalette.m3284getNeutralVariant100d7_KjU(), tonalPalette.m3292getNeutralVariant40d7_KjU(), m3295getNeutralVariant60d7_KjU3, tonalPalette.m3317getPrimary900d7_KjU(), tonalPalette.m3316getPrimary800d7_KjU(), tonalPalette.m3308getPrimary100d7_KjU(), tonalPalette.m3311getPrimary300d7_KjU(), tonalPalette.m3330getSecondary900d7_KjU(), tonalPalette.m3329getSecondary800d7_KjU(), tonalPalette.m3321getSecondary100d7_KjU(), tonalPalette.m3324getSecondary300d7_KjU(), tonalPalette.m3343getTertiary900d7_KjU(), tonalPalette.m3342getTertiary800d7_KjU(), tonalPalette.m3334getTertiary100d7_KjU(), tonalPalette.m3337getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        long m2071getColorWaAFU9c = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170571);
        long m2071getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170572);
        long m2071getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170569);
        long m2071getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170570);
        long m2071getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170528);
        long m2071getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170575);
        long m2071getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170576);
        long m2071getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170573);
        long m2071getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170574);
        long m2071getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170579);
        long m2071getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170580);
        long m2071getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170577);
        long m2071getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170578);
        long m2071getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170581);
        long m2071getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170582);
        long m2071getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170583);
        long m2071getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170584);
        long m2071getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170592);
        long m2071getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170593);
        long m2071getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170540);
        long m2071getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170541);
        long m2071getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170594);
        long m2071getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170625);
        long m2071getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170590);
        long m2071getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170591);
        return ColorSchemeKt.m2136darkColorScheme_VG5OTI$default(m2071getColorWaAFU9c, m2071getColorWaAFU9c2, m2071getColorWaAFU9c3, m2071getColorWaAFU9c4, m2071getColorWaAFU9c5, m2071getColorWaAFU9c6, m2071getColorWaAFU9c7, m2071getColorWaAFU9c8, m2071getColorWaAFU9c9, m2071getColorWaAFU9c10, m2071getColorWaAFU9c11, m2071getColorWaAFU9c12, m2071getColorWaAFU9c13, m2071getColorWaAFU9c14, m2071getColorWaAFU9c15, m2071getColorWaAFU9c16, m2071getColorWaAFU9c17, m2071getColorWaAFU9c18, m2071getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170571), m2071getColorWaAFU9c20, m2071getColorWaAFU9c21, 0L, 0L, 0L, 0L, m2071getColorWaAFU9c22, m2071getColorWaAFU9c23, 0L, m2071getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170587), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170588), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170589), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170585), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170586), m2071getColorWaAFU9c25, ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170612), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170613), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170614), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170615), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170616), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170617), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170618), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170619), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170620), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170621), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170622), ColorResourceHelper.INSTANCE.m2071getColorWaAFU9c(context, 17170623), 331350016, 0, null);
    }
}

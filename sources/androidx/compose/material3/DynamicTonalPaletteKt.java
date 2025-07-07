package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.core.math.MathUtils;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import kotlin.Metadata;
import kotlin.math.MathKt;
/* compiled from: DynamicTonalPalette.android.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"delinearized", "", "rgbComponent", "", "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DynamicTonalPaletteKt {
    private static final float labInvf(float f) {
        float f2 = f * f * f;
        return f2 > 0.008856452f ? f2 : ((((float) AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID) * f) - 16) / 903.2963f;
    }

    public static final TonalPalette dynamicTonalPalette(Context context) {
        return new TonalPalette(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170461), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170462), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 98.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 96.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170463), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 94.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 92.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170464), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 87.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170465), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170466), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170467), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170468), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170470), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 24.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 22.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170471), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 17.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 12.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170472), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 6.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170469), 4.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170473), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170474), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170475), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 98.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 96.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170476), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 94.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 92.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170477), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 87.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170478), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170479), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170480), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170481), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170483), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 24.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 22.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170484), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 17.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 12.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170485), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 6.0f), m1882setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170482), 4.0f), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170486), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170487), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170488), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170489), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170490), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170491), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170492), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170493), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170494), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170495), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170496), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170497), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170498), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170499), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170500), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170501), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170502), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170503), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170504), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170505), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170506), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170507), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170508), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170509), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170510), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170511), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170512), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170513), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170514), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170515), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170516), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170517), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170518), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170519), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170520), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170521), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170522), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170523), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170524), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170525), null);
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
    public static final long m1882setLuminanceDxMtmZc(long j, float f) {
        double d = f;
        if ((d < 1.0E-4d) | (d > 99.9999d)) {
            int delinearized = delinearized(100 * labInvf((f + 16) / ((float) AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID)));
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, null);
        }
        long m4075convertvNxB06k = Color.m4075convertvNxB06k(j, ColorSpaces.INSTANCE.getCieLab());
        return Color.m4075convertvNxB06k(ColorKt.Color$default(f, Color.m4083getGreenimpl(m4075convertvNxB06k), Color.m4081getBlueimpl(m4075convertvNxB06k), 0.0f, ColorSpaces.INSTANCE.getCieLab(), 8, null), ColorSpaces.INSTANCE.getSrgb());
    }

    private static final int delinearized(float f) {
        double d = f / 100;
        return MathUtils.clamp(MathKt.roundToInt((d <= 0.0031308d ? d * 12.92d : (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, 255);
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long m2610getPrimary400d7_KjU = tonalPalette.m2610getPrimary400d7_KjU();
        long m2607getPrimary1000d7_KjU = tonalPalette.m2607getPrimary1000d7_KjU();
        long m2615getPrimary900d7_KjU = tonalPalette.m2615getPrimary900d7_KjU();
        long m2606getPrimary100d7_KjU = tonalPalette.m2606getPrimary100d7_KjU();
        long m2614getPrimary800d7_KjU = tonalPalette.m2614getPrimary800d7_KjU();
        long m2623getSecondary400d7_KjU = tonalPalette.m2623getSecondary400d7_KjU();
        long m2620getSecondary1000d7_KjU = tonalPalette.m2620getSecondary1000d7_KjU();
        long m2628getSecondary900d7_KjU = tonalPalette.m2628getSecondary900d7_KjU();
        long m2619getSecondary100d7_KjU = tonalPalette.m2619getSecondary100d7_KjU();
        long m2636getTertiary400d7_KjU = tonalPalette.m2636getTertiary400d7_KjU();
        long m2633getTertiary1000d7_KjU = tonalPalette.m2633getTertiary1000d7_KjU();
        long m2641getTertiary900d7_KjU = tonalPalette.m2641getTertiary900d7_KjU();
        long m2632getTertiary100d7_KjU = tonalPalette.m2632getTertiary100d7_KjU();
        long m2603getNeutralVariant980d7_KjU = tonalPalette.m2603getNeutralVariant980d7_KjU();
        long m2582getNeutralVariant100d7_KjU = tonalPalette.m2582getNeutralVariant100d7_KjU();
        long m2603getNeutralVariant980d7_KjU2 = tonalPalette.m2603getNeutralVariant980d7_KjU();
        long m2582getNeutralVariant100d7_KjU2 = tonalPalette.m2582getNeutralVariant100d7_KjU();
        long m2598getNeutralVariant900d7_KjU = tonalPalette.m2598getNeutralVariant900d7_KjU();
        long m2589getNeutralVariant300d7_KjU = tonalPalette.m2589getNeutralVariant300d7_KjU();
        long m2586getNeutralVariant200d7_KjU = tonalPalette.m2586getNeutralVariant200d7_KjU();
        long m2601getNeutralVariant950d7_KjU = tonalPalette.m2601getNeutralVariant950d7_KjU();
        long m2592getNeutralVariant500d7_KjU = tonalPalette.m2592getNeutralVariant500d7_KjU();
        long m2596getNeutralVariant800d7_KjU = tonalPalette.m2596getNeutralVariant800d7_KjU();
        long m2581getNeutralVariant00d7_KjU = tonalPalette.m2581getNeutralVariant00d7_KjU();
        long m2603getNeutralVariant980d7_KjU3 = tonalPalette.m2603getNeutralVariant980d7_KjU();
        long m2597getNeutralVariant870d7_KjU = tonalPalette.m2597getNeutralVariant870d7_KjU();
        return ColorSchemeKt.m1739lightColorSchemeCXl9yA$default(m2610getPrimary400d7_KjU, m2607getPrimary1000d7_KjU, m2615getPrimary900d7_KjU, m2606getPrimary100d7_KjU, m2614getPrimary800d7_KjU, m2623getSecondary400d7_KjU, m2620getSecondary1000d7_KjU, m2628getSecondary900d7_KjU, m2619getSecondary100d7_KjU, m2636getTertiary400d7_KjU, m2633getTertiary1000d7_KjU, m2641getTertiary900d7_KjU, m2632getTertiary100d7_KjU, m2603getNeutralVariant980d7_KjU, m2582getNeutralVariant100d7_KjU, m2603getNeutralVariant980d7_KjU2, m2582getNeutralVariant100d7_KjU2, m2598getNeutralVariant900d7_KjU, m2589getNeutralVariant300d7_KjU, tonalPalette.m2610getPrimary400d7_KjU(), m2586getNeutralVariant200d7_KjU, m2601getNeutralVariant950d7_KjU, 0L, 0L, 0L, 0L, m2592getNeutralVariant500d7_KjU, m2596getNeutralVariant800d7_KjU, m2581getNeutralVariant00d7_KjU, m2603getNeutralVariant980d7_KjU3, tonalPalette.m2600getNeutralVariant940d7_KjU(), tonalPalette.m2599getNeutralVariant920d7_KjU(), tonalPalette.m2598getNeutralVariant900d7_KjU(), tonalPalette.m2602getNeutralVariant960d7_KjU(), tonalPalette.m2583getNeutralVariant1000d7_KjU(), m2597getNeutralVariant870d7_KjU, 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        long m1690getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170528);
        long m1690getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170529);
        long m1690getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170526);
        long m1690getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170527);
        long m1690getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170571);
        long m1690getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170532);
        long m1690getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170533);
        long m1690getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170530);
        long m1690getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170531);
        long m1690getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170536);
        long m1690getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170537);
        long m1690getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170534);
        long m1690getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170535);
        long m1690getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170538);
        long m1690getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170539);
        long m1690getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170540);
        long m1690getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170541);
        long m1690getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170549);
        long m1690getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170550);
        long m1690getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170583);
        long m1690getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170584);
        long m1690getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170551);
        long m1690getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170624);
        long m1690getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170547);
        long m1690getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170548);
        return ColorSchemeKt.m1739lightColorSchemeCXl9yA$default(m1690getColorWaAFU9c, m1690getColorWaAFU9c2, m1690getColorWaAFU9c3, m1690getColorWaAFU9c4, m1690getColorWaAFU9c5, m1690getColorWaAFU9c6, m1690getColorWaAFU9c7, m1690getColorWaAFU9c8, m1690getColorWaAFU9c9, m1690getColorWaAFU9c10, m1690getColorWaAFU9c11, m1690getColorWaAFU9c12, m1690getColorWaAFU9c13, m1690getColorWaAFU9c14, m1690getColorWaAFU9c15, m1690getColorWaAFU9c16, m1690getColorWaAFU9c17, m1690getColorWaAFU9c18, m1690getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170528), m1690getColorWaAFU9c20, m1690getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1690getColorWaAFU9c22, m1690getColorWaAFU9c23, 0L, m1690getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170544), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170545), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170546), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170542), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170543), m1690getColorWaAFU9c25, 331350016, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long m2614getPrimary800d7_KjU = tonalPalette.m2614getPrimary800d7_KjU();
        long m2608getPrimary200d7_KjU = tonalPalette.m2608getPrimary200d7_KjU();
        long m2609getPrimary300d7_KjU = tonalPalette.m2609getPrimary300d7_KjU();
        long m2615getPrimary900d7_KjU = tonalPalette.m2615getPrimary900d7_KjU();
        long m2610getPrimary400d7_KjU = tonalPalette.m2610getPrimary400d7_KjU();
        long m2627getSecondary800d7_KjU = tonalPalette.m2627getSecondary800d7_KjU();
        long m2621getSecondary200d7_KjU = tonalPalette.m2621getSecondary200d7_KjU();
        long m2622getSecondary300d7_KjU = tonalPalette.m2622getSecondary300d7_KjU();
        long m2628getSecondary900d7_KjU = tonalPalette.m2628getSecondary900d7_KjU();
        long m2640getTertiary800d7_KjU = tonalPalette.m2640getTertiary800d7_KjU();
        long m2634getTertiary200d7_KjU = tonalPalette.m2634getTertiary200d7_KjU();
        long m2635getTertiary300d7_KjU = tonalPalette.m2635getTertiary300d7_KjU();
        long m2641getTertiary900d7_KjU = tonalPalette.m2641getTertiary900d7_KjU();
        long m2593getNeutralVariant60d7_KjU = tonalPalette.m2593getNeutralVariant60d7_KjU();
        long m2598getNeutralVariant900d7_KjU = tonalPalette.m2598getNeutralVariant900d7_KjU();
        long m2593getNeutralVariant60d7_KjU2 = tonalPalette.m2593getNeutralVariant60d7_KjU();
        long m2598getNeutralVariant900d7_KjU2 = tonalPalette.m2598getNeutralVariant900d7_KjU();
        long m2589getNeutralVariant300d7_KjU = tonalPalette.m2589getNeutralVariant300d7_KjU();
        long m2596getNeutralVariant800d7_KjU = tonalPalette.m2596getNeutralVariant800d7_KjU();
        long m2598getNeutralVariant900d7_KjU3 = tonalPalette.m2598getNeutralVariant900d7_KjU();
        long m2586getNeutralVariant200d7_KjU = tonalPalette.m2586getNeutralVariant200d7_KjU();
        long m2594getNeutralVariant600d7_KjU = tonalPalette.m2594getNeutralVariant600d7_KjU();
        long m2589getNeutralVariant300d7_KjU2 = tonalPalette.m2589getNeutralVariant300d7_KjU();
        long m2581getNeutralVariant00d7_KjU = tonalPalette.m2581getNeutralVariant00d7_KjU();
        long m2588getNeutralVariant240d7_KjU = tonalPalette.m2588getNeutralVariant240d7_KjU();
        long m2593getNeutralVariant60d7_KjU3 = tonalPalette.m2593getNeutralVariant60d7_KjU();
        return ColorSchemeKt.m1735darkColorSchemeCXl9yA$default(m2614getPrimary800d7_KjU, m2608getPrimary200d7_KjU, m2609getPrimary300d7_KjU, m2615getPrimary900d7_KjU, m2610getPrimary400d7_KjU, m2627getSecondary800d7_KjU, m2621getSecondary200d7_KjU, m2622getSecondary300d7_KjU, m2628getSecondary900d7_KjU, m2640getTertiary800d7_KjU, m2634getTertiary200d7_KjU, m2635getTertiary300d7_KjU, m2641getTertiary900d7_KjU, m2593getNeutralVariant60d7_KjU, m2598getNeutralVariant900d7_KjU, m2593getNeutralVariant60d7_KjU2, m2598getNeutralVariant900d7_KjU2, m2589getNeutralVariant300d7_KjU, m2596getNeutralVariant800d7_KjU, tonalPalette.m2614getPrimary800d7_KjU(), m2598getNeutralVariant900d7_KjU3, m2586getNeutralVariant200d7_KjU, 0L, 0L, 0L, 0L, m2594getNeutralVariant600d7_KjU, m2589getNeutralVariant300d7_KjU2, m2581getNeutralVariant00d7_KjU, m2588getNeutralVariant240d7_KjU, tonalPalette.m2584getNeutralVariant120d7_KjU(), tonalPalette.m2585getNeutralVariant170d7_KjU(), tonalPalette.m2587getNeutralVariant220d7_KjU(), tonalPalette.m2582getNeutralVariant100d7_KjU(), tonalPalette.m2590getNeutralVariant40d7_KjU(), m2593getNeutralVariant60d7_KjU3, 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        long m1690getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170571);
        long m1690getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170572);
        long m1690getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170569);
        long m1690getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170570);
        long m1690getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170528);
        long m1690getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170575);
        long m1690getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170576);
        long m1690getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170573);
        long m1690getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170574);
        long m1690getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170579);
        long m1690getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170580);
        long m1690getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170577);
        long m1690getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170578);
        long m1690getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170581);
        long m1690getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170582);
        long m1690getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170583);
        long m1690getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170584);
        long m1690getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170592);
        long m1690getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170593);
        long m1690getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170540);
        long m1690getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170541);
        long m1690getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170594);
        long m1690getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170625);
        long m1690getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170590);
        long m1690getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170591);
        return ColorSchemeKt.m1735darkColorSchemeCXl9yA$default(m1690getColorWaAFU9c, m1690getColorWaAFU9c2, m1690getColorWaAFU9c3, m1690getColorWaAFU9c4, m1690getColorWaAFU9c5, m1690getColorWaAFU9c6, m1690getColorWaAFU9c7, m1690getColorWaAFU9c8, m1690getColorWaAFU9c9, m1690getColorWaAFU9c10, m1690getColorWaAFU9c11, m1690getColorWaAFU9c12, m1690getColorWaAFU9c13, m1690getColorWaAFU9c14, m1690getColorWaAFU9c15, m1690getColorWaAFU9c16, m1690getColorWaAFU9c17, m1690getColorWaAFU9c18, m1690getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170571), m1690getColorWaAFU9c20, m1690getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1690getColorWaAFU9c22, m1690getColorWaAFU9c23, 0L, m1690getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170587), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170588), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170589), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170585), ColorResourceHelper.INSTANCE.m1690getColorWaAFU9c(context, 17170586), m1690getColorWaAFU9c25, 331350016, 0, null);
    }
}

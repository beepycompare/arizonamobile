package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a´\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aø\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\b\u0010<\u001a\u00020\u0004H\u0000\u001a´\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u00102\u001aø\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b?\u0010;\u001a&\u0010@\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020BH\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u001e\u0010\u000f\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0019\u0010G\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0001¢\u0006\u0002\u0010H\u001a\u001e\u0010I\u001a\u00020\u000b*\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "value", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "contentColorFor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", L2.g, "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "darkColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "expressiveLightColorScheme", "lightColorScheme", "lightColorScheme-G1PFc-w", "lightColorScheme-C-Xl9yA", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ColorScheme invoke() {
            return ColorSchemeKt.m2046lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalTonalElevationEnabled$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return true;
        }
    });

    /* compiled from: ColorScheme.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m2046lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3222getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3222getPrimary0d7_KjU() : j;
        long m3206getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3206getOnPrimary0d7_KjU() : j2;
        long m3223getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3223getPrimaryContainer0d7_KjU() : j3;
        long m3207getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3207getOnPrimaryContainer0d7_KjU() : j4;
        long m3201getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3201getInversePrimary0d7_KjU() : j5;
        long m3227getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3227getSecondary0d7_KjU() : j6;
        long m3210getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3210getOnSecondary0d7_KjU() : j7;
        long m3228getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3228getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3222getPrimary0d7_KjU;
        long m3211getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3211getOnSecondaryContainer0d7_KjU() : j9;
        long m3241getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3241getTertiary0d7_KjU() : j10;
        long m3216getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3216getOnTertiary0d7_KjU() : j11;
        long m3242getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3242getTertiaryContainer0d7_KjU() : j12;
        long m3217getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3217getOnTertiaryContainer0d7_KjU() : j13;
        long m3197getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3197getBackground0d7_KjU() : j14;
        long m3203getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3203getOnBackground0d7_KjU() : j15;
        long m3231getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3231getSurface0d7_KjU() : j16;
        long m3214getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3214getOnSurface0d7_KjU() : j17;
        long m3240getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3240getSurfaceVariant0d7_KjU() : j18;
        long m3215getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3215getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3202getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3202getInverseSurface0d7_KjU() : j21;
        long m3200getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3200getInverseOnSurface0d7_KjU() : j22;
        long m3198getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3198getError0d7_KjU() : j23;
        long m3204getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3204getOnError0d7_KjU() : j24;
        long m3199getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3199getErrorContainer0d7_KjU() : j25;
        long m3205getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3205getOnErrorContainer0d7_KjU() : j26;
        long m3220getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3220getOutline0d7_KjU() : j27;
        long m3221getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3221getOutlineVariant0d7_KjU() : j28;
        long m3226getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3226getScrim0d7_KjU() : j29;
        long m3232getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3232getSurfaceBright0d7_KjU() : j30;
        long m3233getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3233getSurfaceContainer0d7_KjU() : j31;
        long m3234getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3234getSurfaceContainerHigh0d7_KjU() : j32;
        long m3235getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3235getSurfaceContainerHighest0d7_KjU() : j33;
        long m3236getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3236getSurfaceContainerLow0d7_KjU() : j34;
        long m3237getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3237getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m3238getSurfaceDim0d7_KjU();
        }
        return m2045lightColorSchemeCXl9yA(j37, m3206getOnPrimary0d7_KjU, m3223getPrimaryContainer0d7_KjU, m3207getOnPrimaryContainer0d7_KjU, m3201getInversePrimary0d7_KjU, m3227getSecondary0d7_KjU, m3210getOnSecondary0d7_KjU, m3228getSecondaryContainer0d7_KjU, m3211getOnSecondaryContainer0d7_KjU, m3241getTertiary0d7_KjU, m3216getOnTertiary0d7_KjU, m3242getTertiaryContainer0d7_KjU, m3217getOnTertiaryContainer0d7_KjU, m3197getBackground0d7_KjU, m3203getOnBackground0d7_KjU, m3231getSurface0d7_KjU, m3214getOnSurface0d7_KjU, m3240getSurfaceVariant0d7_KjU, m3215getOnSurfaceVariant0d7_KjU, j38, m3202getInverseSurface0d7_KjU, m3200getInverseOnSurface0d7_KjU, m3198getError0d7_KjU, m3204getOnError0d7_KjU, m3199getErrorContainer0d7_KjU, m3205getOnErrorContainer0d7_KjU, m3220getOutline0d7_KjU, m3221getOutlineVariant0d7_KjU, m3226getScrim0d7_KjU, m3232getSurfaceBright0d7_KjU, m3233getSurfaceContainer0d7_KjU, m3234getSurfaceContainerHigh0d7_KjU, m3235getSurfaceContainerHighest0d7_KjU, m3236getSurfaceContainerLow0d7_KjU, m3237getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* renamed from: lightColorScheme-C-Xl9yA */
    public static final ColorScheme m2045lightColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m2048lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3222getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3222getPrimary0d7_KjU() : j;
        long m3206getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3206getOnPrimary0d7_KjU() : j2;
        long m3223getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3223getPrimaryContainer0d7_KjU() : j3;
        long m3207getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3207getOnPrimaryContainer0d7_KjU() : j4;
        long m3201getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3201getInversePrimary0d7_KjU() : j5;
        long m3227getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3227getSecondary0d7_KjU() : j6;
        long m3210getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3210getOnSecondary0d7_KjU() : j7;
        long m3228getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3228getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3222getPrimary0d7_KjU;
        long m3211getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3211getOnSecondaryContainer0d7_KjU() : j9;
        long m3241getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3241getTertiary0d7_KjU() : j10;
        long m3216getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3216getOnTertiary0d7_KjU() : j11;
        long m3242getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3242getTertiaryContainer0d7_KjU() : j12;
        long m3217getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3217getOnTertiaryContainer0d7_KjU() : j13;
        long m3197getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3197getBackground0d7_KjU() : j14;
        long m3203getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3203getOnBackground0d7_KjU() : j15;
        long m3231getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3231getSurface0d7_KjU() : j16;
        long m3214getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3214getOnSurface0d7_KjU() : j17;
        long m3240getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3240getSurfaceVariant0d7_KjU() : j18;
        long m3215getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3215getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3202getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3202getInverseSurface0d7_KjU() : j21;
        long m3200getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3200getInverseOnSurface0d7_KjU() : j22;
        long m3198getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3198getError0d7_KjU() : j23;
        long m3204getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3204getOnError0d7_KjU() : j24;
        long m3199getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3199getErrorContainer0d7_KjU() : j25;
        long m3205getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3205getOnErrorContainer0d7_KjU() : j26;
        long m3220getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3220getOutline0d7_KjU() : j27;
        long m3221getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3221getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m3226getScrim0d7_KjU();
        }
        return m2046lightColorSchemeCXl9yA$default(j30, m3206getOnPrimary0d7_KjU, m3223getPrimaryContainer0d7_KjU, m3207getOnPrimaryContainer0d7_KjU, m3201getInversePrimary0d7_KjU, m3227getSecondary0d7_KjU, m3210getOnSecondary0d7_KjU, m3228getSecondaryContainer0d7_KjU, m3211getOnSecondaryContainer0d7_KjU, m3241getTertiary0d7_KjU, m3216getOnTertiary0d7_KjU, m3242getTertiaryContainer0d7_KjU, m3217getOnTertiaryContainer0d7_KjU, m3197getBackground0d7_KjU, m3203getOnBackground0d7_KjU, m3231getSurface0d7_KjU, m3214getOnSurface0d7_KjU, m3240getSurfaceVariant0d7_KjU, m3215getOnSurfaceVariant0d7_KjU, j31, m3202getInverseSurface0d7_KjU, m3200getInverseOnSurface0d7_KjU, m3198getError0d7_KjU, m3204getOnError0d7_KjU, m3199getErrorContainer0d7_KjU, m3205getOnErrorContainer0d7_KjU, m3220getOutline0d7_KjU, m3221getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m2042darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3174getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3174getPrimary0d7_KjU() : j;
        long m3158getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3158getOnPrimary0d7_KjU() : j2;
        long m3175getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3175getPrimaryContainer0d7_KjU() : j3;
        long m3159getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3159getOnPrimaryContainer0d7_KjU() : j4;
        long m3153getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3153getInversePrimary0d7_KjU() : j5;
        long m3179getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3179getSecondary0d7_KjU() : j6;
        long m3162getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3162getOnSecondary0d7_KjU() : j7;
        long m3180getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3180getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3174getPrimary0d7_KjU;
        long m3163getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3163getOnSecondaryContainer0d7_KjU() : j9;
        long m3193getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3193getTertiary0d7_KjU() : j10;
        long m3168getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3168getOnTertiary0d7_KjU() : j11;
        long m3194getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3194getTertiaryContainer0d7_KjU() : j12;
        long m3169getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3169getOnTertiaryContainer0d7_KjU() : j13;
        long m3149getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3149getBackground0d7_KjU() : j14;
        long m3155getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3155getOnBackground0d7_KjU() : j15;
        long m3183getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3183getSurface0d7_KjU() : j16;
        long m3166getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3166getOnSurface0d7_KjU() : j17;
        long m3192getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3192getSurfaceVariant0d7_KjU() : j18;
        long m3167getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3167getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3154getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3154getInverseSurface0d7_KjU() : j21;
        long m3152getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3152getInverseOnSurface0d7_KjU() : j22;
        long m3150getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3150getError0d7_KjU() : j23;
        long m3156getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3156getOnError0d7_KjU() : j24;
        long m3151getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3151getErrorContainer0d7_KjU() : j25;
        long m3157getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3157getOnErrorContainer0d7_KjU() : j26;
        long m3172getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3172getOutline0d7_KjU() : j27;
        long m3173getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3173getOutlineVariant0d7_KjU() : j28;
        long m3178getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3178getScrim0d7_KjU() : j29;
        long m3184getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3184getSurfaceBright0d7_KjU() : j30;
        long m3185getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3185getSurfaceContainer0d7_KjU() : j31;
        long m3186getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3186getSurfaceContainerHigh0d7_KjU() : j32;
        long m3187getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3187getSurfaceContainerHighest0d7_KjU() : j33;
        long m3188getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3188getSurfaceContainerLow0d7_KjU() : j34;
        long m3189getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3189getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m3190getSurfaceDim0d7_KjU();
        }
        return m2041darkColorSchemeCXl9yA(j37, m3158getOnPrimary0d7_KjU, m3175getPrimaryContainer0d7_KjU, m3159getOnPrimaryContainer0d7_KjU, m3153getInversePrimary0d7_KjU, m3179getSecondary0d7_KjU, m3162getOnSecondary0d7_KjU, m3180getSecondaryContainer0d7_KjU, m3163getOnSecondaryContainer0d7_KjU, m3193getTertiary0d7_KjU, m3168getOnTertiary0d7_KjU, m3194getTertiaryContainer0d7_KjU, m3169getOnTertiaryContainer0d7_KjU, m3149getBackground0d7_KjU, m3155getOnBackground0d7_KjU, m3183getSurface0d7_KjU, m3166getOnSurface0d7_KjU, m3192getSurfaceVariant0d7_KjU, m3167getOnSurfaceVariant0d7_KjU, j38, m3154getInverseSurface0d7_KjU, m3152getInverseOnSurface0d7_KjU, m3150getError0d7_KjU, m3156getOnError0d7_KjU, m3151getErrorContainer0d7_KjU, m3157getOnErrorContainer0d7_KjU, m3172getOutline0d7_KjU, m3173getOutlineVariant0d7_KjU, m3178getScrim0d7_KjU, m3184getSurfaceBright0d7_KjU, m3185getSurfaceContainer0d7_KjU, m3186getSurfaceContainerHigh0d7_KjU, m3187getSurfaceContainerHighest0d7_KjU, m3188getSurfaceContainerLow0d7_KjU, m3189getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* renamed from: darkColorScheme-C-Xl9yA */
    public static final ColorScheme m2041darkColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m2044darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3174getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3174getPrimary0d7_KjU() : j;
        long m3158getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3158getOnPrimary0d7_KjU() : j2;
        long m3175getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3175getPrimaryContainer0d7_KjU() : j3;
        long m3159getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3159getOnPrimaryContainer0d7_KjU() : j4;
        long m3153getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3153getInversePrimary0d7_KjU() : j5;
        long m3179getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3179getSecondary0d7_KjU() : j6;
        long m3162getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3162getOnSecondary0d7_KjU() : j7;
        long m3180getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3180getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3174getPrimary0d7_KjU;
        long m3163getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3163getOnSecondaryContainer0d7_KjU() : j9;
        long m3193getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3193getTertiary0d7_KjU() : j10;
        long m3168getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3168getOnTertiary0d7_KjU() : j11;
        long m3194getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3194getTertiaryContainer0d7_KjU() : j12;
        long m3169getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3169getOnTertiaryContainer0d7_KjU() : j13;
        long m3149getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3149getBackground0d7_KjU() : j14;
        long m3155getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3155getOnBackground0d7_KjU() : j15;
        long m3183getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3183getSurface0d7_KjU() : j16;
        long m3166getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3166getOnSurface0d7_KjU() : j17;
        long m3192getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3192getSurfaceVariant0d7_KjU() : j18;
        long m3167getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3167getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3154getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3154getInverseSurface0d7_KjU() : j21;
        long m3152getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3152getInverseOnSurface0d7_KjU() : j22;
        long m3150getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3150getError0d7_KjU() : j23;
        long m3156getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3156getOnError0d7_KjU() : j24;
        long m3151getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3151getErrorContainer0d7_KjU() : j25;
        long m3157getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3157getOnErrorContainer0d7_KjU() : j26;
        long m3172getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3172getOutline0d7_KjU() : j27;
        long m3173getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3173getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m3178getScrim0d7_KjU();
        }
        return m2042darkColorSchemeCXl9yA$default(j30, m3158getOnPrimary0d7_KjU, m3175getPrimaryContainer0d7_KjU, m3159getOnPrimaryContainer0d7_KjU, m3153getInversePrimary0d7_KjU, m3179getSecondary0d7_KjU, m3162getOnSecondary0d7_KjU, m3180getSecondaryContainer0d7_KjU, m3163getOnSecondaryContainer0d7_KjU, m3193getTertiary0d7_KjU, m3168getOnTertiary0d7_KjU, m3194getTertiaryContainer0d7_KjU, m3169getOnTertiaryContainer0d7_KjU, m3149getBackground0d7_KjU, m3155getOnBackground0d7_KjU, m3183getSurface0d7_KjU, m3166getOnSurface0d7_KjU, m3192getSurfaceVariant0d7_KjU, m3167getOnSurfaceVariant0d7_KjU, j31, m3154getInverseSurface0d7_KjU, m3152getInverseOnSurface0d7_KjU, m3150getError0d7_KjU, m3156getOnError0d7_KjU, m3151getErrorContainer0d7_KjU, m3157getOnErrorContainer0d7_KjU, m3172getOutline0d7_KjU, m3173getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: contentColorFor-4WTKRHQ */
    public static final long m2039contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m4538equalsimpl0(j, colorScheme.m2021getPrimary0d7_KjU())) {
            return colorScheme.m2011getOnPrimary0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2024getSecondary0d7_KjU())) {
            return colorScheme.m2013getOnSecondary0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2036getTertiary0d7_KjU())) {
            return colorScheme.m2017getOnTertiary0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2002getBackground0d7_KjU())) {
            return colorScheme.m2008getOnBackground0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2003getError0d7_KjU())) {
            return colorScheme.m2009getOnError0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2022getPrimaryContainer0d7_KjU())) {
            return colorScheme.m2012getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2025getSecondaryContainer0d7_KjU())) {
            return colorScheme.m2014getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2037getTertiaryContainer0d7_KjU())) {
            return colorScheme.m2018getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2004getErrorContainer0d7_KjU())) {
            return colorScheme.m2010getOnErrorContainer0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2007getInverseSurface0d7_KjU())) {
            return colorScheme.m2005getInverseOnSurface0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2026getSurface0d7_KjU())) {
            return colorScheme.m2015getOnSurface0d7_KjU();
        }
        if (Color.m4538equalsimpl0(j, colorScheme.m2035getSurfaceVariant0d7_KjU())) {
            return colorScheme.m2016getOnSurfaceVariant0d7_KjU();
        }
        if (!Color.m4538equalsimpl0(j, colorScheme.m2027getSurfaceBright0d7_KjU()) && !Color.m4538equalsimpl0(j, colorScheme.m2028getSurfaceContainer0d7_KjU()) && !Color.m4538equalsimpl0(j, colorScheme.m2029getSurfaceContainerHigh0d7_KjU()) && !Color.m4538equalsimpl0(j, colorScheme.m2030getSurfaceContainerHighest0d7_KjU()) && !Color.m4538equalsimpl0(j, colorScheme.m2031getSurfaceContainerLow0d7_KjU()) && !Color.m4538equalsimpl0(j, colorScheme.m2032getSurfaceContainerLowest0d7_KjU())) {
            return Color.Companion.m4573getUnspecified0d7_KjU();
        }
        return colorScheme.m2015getOnSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U */
    public static final long m2040contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color):ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        ComposerKt.sourceInformation(composer, "*878@39525L11,879@39609L7");
        long m2039contentColorFor4WTKRHQ = m2039contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (m2039contentColorFor4WTKRHQ == 16) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            m2039contentColorFor4WTKRHQ = ((Color) consume).m4547unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2039contentColorFor4WTKRHQ;
    }

    /* renamed from: applyTonalElevation-RFCenO8 */
    public static final long m2038applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)896@40465L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalTonalElevationEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (Color.m4538equalsimpl0(j, colorScheme.m2026getSurface0d7_KjU()) && booleanValue) {
            j = m2049surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m2046lightColorSchemeCXl9yA$default(0L, 0L, 0L, PaletteTokens.INSTANCE.m3533getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m3546getSecondary300d7_KjU(), 0L, 0L, 0L, PaletteTokens.INSTANCE.m3546getSecondary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -4361, 15, null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m2002getBackground0d7_KjU();
            case 2:
                return colorScheme.m2003getError0d7_KjU();
            case 3:
                return colorScheme.m2004getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m2005getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m2006getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m2007getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m2008getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m2009getOnError0d7_KjU();
            case 9:
                return colorScheme.m2010getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m2011getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m2012getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m2013getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m2014getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m2015getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m2016getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m2034getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m2017getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m2018getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m2019getOutline0d7_KjU();
            case 20:
                return colorScheme.m2020getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m2021getPrimary0d7_KjU();
            case 22:
                return colorScheme.m2022getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m2023getScrim0d7_KjU();
            case 24:
                return colorScheme.m2024getSecondary0d7_KjU();
            case 25:
                return colorScheme.m2025getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m2026getSurface0d7_KjU();
            case 27:
                return colorScheme.m2035getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m2027getSurfaceBright0d7_KjU();
            case 29:
                return colorScheme.m2028getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m2029getSurfaceContainerHigh0d7_KjU();
            case 31:
                return colorScheme.m2030getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m2031getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m2032getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m2033getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m2036getTertiary0d7_KjU();
            case 36:
                return colorScheme.m2037getTertiaryContainer0d7_KjU();
            default:
                return Color.Companion.m4573getUnspecified0d7_KjU();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -810780884, "C1009@45379L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fromToken;
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs */
    public static final long m2049surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m7256equalsimpl0(f, Dp.m7251constructorimpl(0))) {
            return colorScheme.m2026getSurface0d7_KjU();
        }
        return ColorKt.m4582compositeOverOWjLjI(Color.m4536copywmQWz5c$default(colorScheme.m2034getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m2026getSurface0d7_KjU());
    }
}

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
            return ColorSchemeKt.m1739lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
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

    /* renamed from: lightColorScheme-C-Xl9yA$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1739lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m2915getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2915getPrimary0d7_KjU() : j;
        long m2899getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2899getOnPrimary0d7_KjU() : j2;
        long m2916getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2916getPrimaryContainer0d7_KjU() : j3;
        long m2900getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2900getOnPrimaryContainer0d7_KjU() : j4;
        long m2894getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2894getInversePrimary0d7_KjU() : j5;
        long m2920getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2920getSecondary0d7_KjU() : j6;
        long m2903getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2903getOnSecondary0d7_KjU() : j7;
        long m2921getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2921getSecondaryContainer0d7_KjU() : j8;
        long j37 = m2915getPrimary0d7_KjU;
        long m2904getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2904getOnSecondaryContainer0d7_KjU() : j9;
        long m2934getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2934getTertiary0d7_KjU() : j10;
        long m2909getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2909getOnTertiary0d7_KjU() : j11;
        long m2935getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2935getTertiaryContainer0d7_KjU() : j12;
        long m2910getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2910getOnTertiaryContainer0d7_KjU() : j13;
        long m2890getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2890getBackground0d7_KjU() : j14;
        long m2896getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2896getOnBackground0d7_KjU() : j15;
        long m2924getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2924getSurface0d7_KjU() : j16;
        long m2907getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2907getOnSurface0d7_KjU() : j17;
        long m2933getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2933getSurfaceVariant0d7_KjU() : j18;
        long m2908getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2908getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m2895getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2895getInverseSurface0d7_KjU() : j21;
        long m2893getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2893getInverseOnSurface0d7_KjU() : j22;
        long m2891getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2891getError0d7_KjU() : j23;
        long m2897getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2897getOnError0d7_KjU() : j24;
        long m2892getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2892getErrorContainer0d7_KjU() : j25;
        long m2898getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2898getOnErrorContainer0d7_KjU() : j26;
        long m2913getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m2913getOutline0d7_KjU() : j27;
        long m2914getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m2914getOutlineVariant0d7_KjU() : j28;
        long m2919getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2919getScrim0d7_KjU() : j29;
        long m2925getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m2925getSurfaceBright0d7_KjU() : j30;
        long m2926getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m2926getSurfaceContainer0d7_KjU() : j31;
        long m2927getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m2927getSurfaceContainerHigh0d7_KjU() : j32;
        long m2928getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m2928getSurfaceContainerHighest0d7_KjU() : j33;
        long m2929getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m2929getSurfaceContainerLow0d7_KjU() : j34;
        long m2930getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m2930getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m2931getSurfaceDim0d7_KjU();
        }
        return m1738lightColorSchemeCXl9yA(j37, m2899getOnPrimary0d7_KjU, m2916getPrimaryContainer0d7_KjU, m2900getOnPrimaryContainer0d7_KjU, m2894getInversePrimary0d7_KjU, m2920getSecondary0d7_KjU, m2903getOnSecondary0d7_KjU, m2921getSecondaryContainer0d7_KjU, m2904getOnSecondaryContainer0d7_KjU, m2934getTertiary0d7_KjU, m2909getOnTertiary0d7_KjU, m2935getTertiaryContainer0d7_KjU, m2910getOnTertiaryContainer0d7_KjU, m2890getBackground0d7_KjU, m2896getOnBackground0d7_KjU, m2924getSurface0d7_KjU, m2907getOnSurface0d7_KjU, m2933getSurfaceVariant0d7_KjU, m2908getOnSurfaceVariant0d7_KjU, j38, m2895getInverseSurface0d7_KjU, m2893getInverseOnSurface0d7_KjU, m2891getError0d7_KjU, m2897getOnError0d7_KjU, m2892getErrorContainer0d7_KjU, m2898getOnErrorContainer0d7_KjU, m2913getOutline0d7_KjU, m2914getOutlineVariant0d7_KjU, m2919getScrim0d7_KjU, m2925getSurfaceBright0d7_KjU, m2926getSurfaceContainer0d7_KjU, m2927getSurfaceContainerHigh0d7_KjU, m2928getSurfaceContainerHighest0d7_KjU, m2929getSurfaceContainerLow0d7_KjU, m2930getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* renamed from: lightColorScheme-C-Xl9yA  reason: not valid java name */
    public static final ColorScheme m1738lightColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1741lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m2915getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2915getPrimary0d7_KjU() : j;
        long m2899getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2899getOnPrimary0d7_KjU() : j2;
        long m2916getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2916getPrimaryContainer0d7_KjU() : j3;
        long m2900getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2900getOnPrimaryContainer0d7_KjU() : j4;
        long m2894getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2894getInversePrimary0d7_KjU() : j5;
        long m2920getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2920getSecondary0d7_KjU() : j6;
        long m2903getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2903getOnSecondary0d7_KjU() : j7;
        long m2921getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2921getSecondaryContainer0d7_KjU() : j8;
        long j30 = m2915getPrimary0d7_KjU;
        long m2904getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2904getOnSecondaryContainer0d7_KjU() : j9;
        long m2934getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2934getTertiary0d7_KjU() : j10;
        long m2909getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2909getOnTertiary0d7_KjU() : j11;
        long m2935getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2935getTertiaryContainer0d7_KjU() : j12;
        long m2910getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2910getOnTertiaryContainer0d7_KjU() : j13;
        long m2890getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2890getBackground0d7_KjU() : j14;
        long m2896getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2896getOnBackground0d7_KjU() : j15;
        long m2924getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2924getSurface0d7_KjU() : j16;
        long m2907getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2907getOnSurface0d7_KjU() : j17;
        long m2933getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2933getSurfaceVariant0d7_KjU() : j18;
        long m2908getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2908getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m2895getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2895getInverseSurface0d7_KjU() : j21;
        long m2893getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2893getInverseOnSurface0d7_KjU() : j22;
        long m2891getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2891getError0d7_KjU() : j23;
        long m2897getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2897getOnError0d7_KjU() : j24;
        long m2892getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2892getErrorContainer0d7_KjU() : j25;
        long m2898getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2898getOnErrorContainer0d7_KjU() : j26;
        long m2913getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m2913getOutline0d7_KjU() : j27;
        long m2914getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m2914getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m2919getScrim0d7_KjU();
        }
        return m1739lightColorSchemeCXl9yA$default(j30, m2899getOnPrimary0d7_KjU, m2916getPrimaryContainer0d7_KjU, m2900getOnPrimaryContainer0d7_KjU, m2894getInversePrimary0d7_KjU, m2920getSecondary0d7_KjU, m2903getOnSecondary0d7_KjU, m2921getSecondaryContainer0d7_KjU, m2904getOnSecondaryContainer0d7_KjU, m2934getTertiary0d7_KjU, m2909getOnTertiary0d7_KjU, m2935getTertiaryContainer0d7_KjU, m2910getOnTertiaryContainer0d7_KjU, m2890getBackground0d7_KjU, m2896getOnBackground0d7_KjU, m2924getSurface0d7_KjU, m2907getOnSurface0d7_KjU, m2933getSurfaceVariant0d7_KjU, m2908getOnSurfaceVariant0d7_KjU, j31, m2895getInverseSurface0d7_KjU, m2893getInverseOnSurface0d7_KjU, m2891getError0d7_KjU, m2897getOnError0d7_KjU, m2892getErrorContainer0d7_KjU, m2898getOnErrorContainer0d7_KjU, m2913getOutline0d7_KjU, m2914getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1735darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m2867getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2867getPrimary0d7_KjU() : j;
        long m2851getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2851getOnPrimary0d7_KjU() : j2;
        long m2868getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2868getPrimaryContainer0d7_KjU() : j3;
        long m2852getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2852getOnPrimaryContainer0d7_KjU() : j4;
        long m2846getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2846getInversePrimary0d7_KjU() : j5;
        long m2872getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2872getSecondary0d7_KjU() : j6;
        long m2855getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2855getOnSecondary0d7_KjU() : j7;
        long m2873getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2873getSecondaryContainer0d7_KjU() : j8;
        long j37 = m2867getPrimary0d7_KjU;
        long m2856getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2856getOnSecondaryContainer0d7_KjU() : j9;
        long m2886getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2886getTertiary0d7_KjU() : j10;
        long m2861getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2861getOnTertiary0d7_KjU() : j11;
        long m2887getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2887getTertiaryContainer0d7_KjU() : j12;
        long m2862getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2862getOnTertiaryContainer0d7_KjU() : j13;
        long m2842getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2842getBackground0d7_KjU() : j14;
        long m2848getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2848getOnBackground0d7_KjU() : j15;
        long m2876getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2876getSurface0d7_KjU() : j16;
        long m2859getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2859getOnSurface0d7_KjU() : j17;
        long m2885getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2885getSurfaceVariant0d7_KjU() : j18;
        long m2860getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2860getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m2847getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2847getInverseSurface0d7_KjU() : j21;
        long m2845getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2845getInverseOnSurface0d7_KjU() : j22;
        long m2843getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2843getError0d7_KjU() : j23;
        long m2849getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2849getOnError0d7_KjU() : j24;
        long m2844getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2844getErrorContainer0d7_KjU() : j25;
        long m2850getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2850getOnErrorContainer0d7_KjU() : j26;
        long m2865getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m2865getOutline0d7_KjU() : j27;
        long m2866getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m2866getOutlineVariant0d7_KjU() : j28;
        long m2871getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2871getScrim0d7_KjU() : j29;
        long m2877getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m2877getSurfaceBright0d7_KjU() : j30;
        long m2878getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m2878getSurfaceContainer0d7_KjU() : j31;
        long m2879getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m2879getSurfaceContainerHigh0d7_KjU() : j32;
        long m2880getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m2880getSurfaceContainerHighest0d7_KjU() : j33;
        long m2881getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m2881getSurfaceContainerLow0d7_KjU() : j34;
        long m2882getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m2882getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m2883getSurfaceDim0d7_KjU();
        }
        return m1734darkColorSchemeCXl9yA(j37, m2851getOnPrimary0d7_KjU, m2868getPrimaryContainer0d7_KjU, m2852getOnPrimaryContainer0d7_KjU, m2846getInversePrimary0d7_KjU, m2872getSecondary0d7_KjU, m2855getOnSecondary0d7_KjU, m2873getSecondaryContainer0d7_KjU, m2856getOnSecondaryContainer0d7_KjU, m2886getTertiary0d7_KjU, m2861getOnTertiary0d7_KjU, m2887getTertiaryContainer0d7_KjU, m2862getOnTertiaryContainer0d7_KjU, m2842getBackground0d7_KjU, m2848getOnBackground0d7_KjU, m2876getSurface0d7_KjU, m2859getOnSurface0d7_KjU, m2885getSurfaceVariant0d7_KjU, m2860getOnSurfaceVariant0d7_KjU, j38, m2847getInverseSurface0d7_KjU, m2845getInverseOnSurface0d7_KjU, m2843getError0d7_KjU, m2849getOnError0d7_KjU, m2844getErrorContainer0d7_KjU, m2850getOnErrorContainer0d7_KjU, m2865getOutline0d7_KjU, m2866getOutlineVariant0d7_KjU, m2871getScrim0d7_KjU, m2877getSurfaceBright0d7_KjU, m2878getSurfaceContainer0d7_KjU, m2879getSurfaceContainerHigh0d7_KjU, m2880getSurfaceContainerHighest0d7_KjU, m2881getSurfaceContainerLow0d7_KjU, m2882getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* renamed from: darkColorScheme-C-Xl9yA  reason: not valid java name */
    public static final ColorScheme m1734darkColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1737darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m2867getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2867getPrimary0d7_KjU() : j;
        long m2851getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2851getOnPrimary0d7_KjU() : j2;
        long m2868getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2868getPrimaryContainer0d7_KjU() : j3;
        long m2852getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2852getOnPrimaryContainer0d7_KjU() : j4;
        long m2846getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2846getInversePrimary0d7_KjU() : j5;
        long m2872getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2872getSecondary0d7_KjU() : j6;
        long m2855getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2855getOnSecondary0d7_KjU() : j7;
        long m2873getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2873getSecondaryContainer0d7_KjU() : j8;
        long j30 = m2867getPrimary0d7_KjU;
        long m2856getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2856getOnSecondaryContainer0d7_KjU() : j9;
        long m2886getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2886getTertiary0d7_KjU() : j10;
        long m2861getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2861getOnTertiary0d7_KjU() : j11;
        long m2887getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2887getTertiaryContainer0d7_KjU() : j12;
        long m2862getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2862getOnTertiaryContainer0d7_KjU() : j13;
        long m2842getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2842getBackground0d7_KjU() : j14;
        long m2848getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2848getOnBackground0d7_KjU() : j15;
        long m2876getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2876getSurface0d7_KjU() : j16;
        long m2859getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2859getOnSurface0d7_KjU() : j17;
        long m2885getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2885getSurfaceVariant0d7_KjU() : j18;
        long m2860getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2860getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m2847getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2847getInverseSurface0d7_KjU() : j21;
        long m2845getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2845getInverseOnSurface0d7_KjU() : j22;
        long m2843getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2843getError0d7_KjU() : j23;
        long m2849getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2849getOnError0d7_KjU() : j24;
        long m2844getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2844getErrorContainer0d7_KjU() : j25;
        long m2850getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2850getOnErrorContainer0d7_KjU() : j26;
        long m2865getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m2865getOutline0d7_KjU() : j27;
        long m2866getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m2866getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m2871getScrim0d7_KjU();
        }
        return m1735darkColorSchemeCXl9yA$default(j30, m2851getOnPrimary0d7_KjU, m2868getPrimaryContainer0d7_KjU, m2852getOnPrimaryContainer0d7_KjU, m2846getInversePrimary0d7_KjU, m2872getSecondary0d7_KjU, m2855getOnSecondary0d7_KjU, m2873getSecondaryContainer0d7_KjU, m2856getOnSecondaryContainer0d7_KjU, m2886getTertiary0d7_KjU, m2861getOnTertiary0d7_KjU, m2887getTertiaryContainer0d7_KjU, m2862getOnTertiaryContainer0d7_KjU, m2842getBackground0d7_KjU, m2848getOnBackground0d7_KjU, m2876getSurface0d7_KjU, m2859getOnSurface0d7_KjU, m2885getSurfaceVariant0d7_KjU, m2860getOnSurfaceVariant0d7_KjU, j31, m2847getInverseSurface0d7_KjU, m2845getInverseOnSurface0d7_KjU, m2843getError0d7_KjU, m2849getOnError0d7_KjU, m2844getErrorContainer0d7_KjU, m2850getOnErrorContainer0d7_KjU, m2865getOutline0d7_KjU, m2866getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1732contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m4079equalsimpl0(j, colorScheme.m1714getPrimary0d7_KjU())) {
            return colorScheme.m1704getOnPrimary0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1717getSecondary0d7_KjU())) {
            return colorScheme.m1706getOnSecondary0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1729getTertiary0d7_KjU())) {
            return colorScheme.m1710getOnTertiary0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1695getBackground0d7_KjU())) {
            return colorScheme.m1701getOnBackground0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1696getError0d7_KjU())) {
            return colorScheme.m1702getOnError0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1715getPrimaryContainer0d7_KjU())) {
            return colorScheme.m1705getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1718getSecondaryContainer0d7_KjU())) {
            return colorScheme.m1707getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1730getTertiaryContainer0d7_KjU())) {
            return colorScheme.m1711getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1697getErrorContainer0d7_KjU())) {
            return colorScheme.m1703getOnErrorContainer0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1700getInverseSurface0d7_KjU())) {
            return colorScheme.m1698getInverseOnSurface0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1719getSurface0d7_KjU())) {
            return colorScheme.m1708getOnSurface0d7_KjU();
        }
        if (Color.m4079equalsimpl0(j, colorScheme.m1728getSurfaceVariant0d7_KjU())) {
            return colorScheme.m1709getOnSurfaceVariant0d7_KjU();
        }
        if (!Color.m4079equalsimpl0(j, colorScheme.m1720getSurfaceBright0d7_KjU()) && !Color.m4079equalsimpl0(j, colorScheme.m1721getSurfaceContainer0d7_KjU()) && !Color.m4079equalsimpl0(j, colorScheme.m1722getSurfaceContainerHigh0d7_KjU()) && !Color.m4079equalsimpl0(j, colorScheme.m1723getSurfaceContainerHighest0d7_KjU()) && !Color.m4079equalsimpl0(j, colorScheme.m1724getSurfaceContainerLow0d7_KjU()) && !Color.m4079equalsimpl0(j, colorScheme.m1725getSurfaceContainerLowest0d7_KjU())) {
            return Color.Companion.m4114getUnspecified0d7_KjU();
        }
        return colorScheme.m1708getOnSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1733contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color):ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        ComposerKt.sourceInformation(composer, "*878@39525L11,879@39609L7");
        long m1732contentColorFor4WTKRHQ = m1732contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (m1732contentColorFor4WTKRHQ == 16) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            m1732contentColorFor4WTKRHQ = ((Color) consume).m4088unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1732contentColorFor4WTKRHQ;
    }

    /* renamed from: applyTonalElevation-RFCenO8  reason: not valid java name */
    public static final long m1731applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)896@40465L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalTonalElevationEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (Color.m4079equalsimpl0(j, colorScheme.m1719getSurface0d7_KjU()) && booleanValue) {
            j = m1742surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m1739lightColorSchemeCXl9yA$default(0L, 0L, 0L, PaletteTokens.INSTANCE.m3226getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m3239getSecondary300d7_KjU(), 0L, 0L, 0L, PaletteTokens.INSTANCE.m3239getSecondary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -4361, 15, null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m1695getBackground0d7_KjU();
            case 2:
                return colorScheme.m1696getError0d7_KjU();
            case 3:
                return colorScheme.m1697getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1698getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1699getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1700getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1701getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1702getOnError0d7_KjU();
            case 9:
                return colorScheme.m1703getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1704getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1705getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1706getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1707getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1708getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1709getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1727getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1710getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1711getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1712getOutline0d7_KjU();
            case 20:
                return colorScheme.m1713getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1714getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1715getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1716getScrim0d7_KjU();
            case 24:
                return colorScheme.m1717getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1718getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1719getSurface0d7_KjU();
            case 27:
                return colorScheme.m1728getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m1720getSurfaceBright0d7_KjU();
            case 29:
                return colorScheme.m1721getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m1722getSurfaceContainerHigh0d7_KjU();
            case 31:
                return colorScheme.m1723getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m1724getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m1725getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m1726getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m1729getTertiary0d7_KjU();
            case 36:
                return colorScheme.m1730getTertiaryContainer0d7_KjU();
            default:
                return Color.Companion.m4114getUnspecified0d7_KjU();
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

    /* renamed from: surfaceColorAtElevation-3ABfNKs  reason: not valid java name */
    public static final long m1742surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m6689equalsimpl0(f, Dp.m6684constructorimpl(0))) {
            return colorScheme.m1719getSurface0d7_KjU();
        }
        return ColorKt.m4123compositeOverOWjLjI(Color.m4077copywmQWz5c$default(colorScheme.m1727getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m1719getSurface0d7_KjU());
    }
}

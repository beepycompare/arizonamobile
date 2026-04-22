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
import io.appmetrica.analytics.impl.C0739z2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aí\u0003\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104\u001aí\u0003\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b6\u00104\u001a\u001b\u00107\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0017\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u00020\u0003*\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001a\b\u0010B\u001a\u00020\u0001H\u0000\u001a÷\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001a±\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001a÷\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001a±\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001a\u0019\u0010I\u001a\u00020\u0003*\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001a#\u0010U\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P\"\u000e\u0010Q\u001a\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001a\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010P¨\u0006["}, d2 = {"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", C0739z2.g, "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ColorScheme m1914lightColorScheme_VG5OTI$default;
            m1914lightColorScheme_VG5OTI$default = ColorSchemeKt.m1914lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 65535, null);
            return m1914lightColorScheme_VG5OTI$default;
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(ColorSchemeKt.LocalTonalElevationEnabled$lambda$2());
        }
    });

    /* compiled from: ColorScheme.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
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
            try {
                iArr[ColorSchemeKeyTokens.PrimaryFixed.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryFixedDim.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryFixed.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryFixedVariant.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryFixed.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryFixedDim.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryFixed.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryFixedVariant.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryFixed.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryFixedDim.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryFixed.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryFixedVariant.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean LocalTonalElevationEnabled$lambda$2() {
        return true;
    }

    /* renamed from: lightColorScheme-_VG5OTI$default */
    public static /* synthetic */ ColorScheme m1914lightColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long m3282getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3282getPrimary0d7_KjU() : j;
        long m3266getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3266getOnPrimary0d7_KjU() : j2;
        long m3283getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3283getPrimaryContainer0d7_KjU() : j3;
        long m3267getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3267getOnPrimaryContainer0d7_KjU() : j4;
        long m3261getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3261getInversePrimary0d7_KjU() : j5;
        long m3287getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3287getSecondary0d7_KjU() : j6;
        long m3270getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3270getOnSecondary0d7_KjU() : j7;
        long j49 = m3282getPrimary0d7_KjU;
        long m3288getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3288getSecondaryContainer0d7_KjU() : j8;
        long m3271getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3271getOnSecondaryContainer0d7_KjU() : j9;
        long m3301getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3301getTertiary0d7_KjU() : j10;
        long m3276getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3276getOnTertiary0d7_KjU() : j11;
        long m3302getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3302getTertiaryContainer0d7_KjU() : j12;
        long m3277getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3277getOnTertiaryContainer0d7_KjU() : j13;
        long m3257getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3257getBackground0d7_KjU() : j14;
        long m3263getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3263getOnBackground0d7_KjU() : j15;
        long m3291getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3291getSurface0d7_KjU() : j16;
        long m3274getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3274getOnSurface0d7_KjU() : j17;
        long m3300getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3300getSurfaceVariant0d7_KjU() : j18;
        long m3275getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3275getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long m3262getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3262getInverseSurface0d7_KjU() : j21;
        long m3260getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3260getInverseOnSurface0d7_KjU() : j22;
        long m3258getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3258getError0d7_KjU() : j23;
        long m3264getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3264getOnError0d7_KjU() : j24;
        long m3259getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3259getErrorContainer0d7_KjU() : j25;
        long m3265getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3265getOnErrorContainer0d7_KjU() : j26;
        long m3280getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3280getOutline0d7_KjU() : j27;
        long m3281getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3281getOutlineVariant0d7_KjU() : j28;
        long m3286getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3286getScrim0d7_KjU() : j29;
        long m3292getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3292getSurfaceBright0d7_KjU() : j30;
        long m3293getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3293getSurfaceContainer0d7_KjU() : j31;
        long m3294getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3294getSurfaceContainerHigh0d7_KjU() : j32;
        long m3295getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3295getSurfaceContainerHighest0d7_KjU() : j33;
        long m3296getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3296getSurfaceContainerLow0d7_KjU() : j34;
        long m3297getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3297getSurfaceContainerLowest0d7_KjU() : j35;
        long m3298getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorLightTokens.INSTANCE.m3298getSurfaceDim0d7_KjU() : j36;
        long m3284getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorLightTokens.INSTANCE.m3284getPrimaryFixed0d7_KjU() : j37;
        long m3285getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorLightTokens.INSTANCE.m3285getPrimaryFixedDim0d7_KjU() : j38;
        long m3268getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorLightTokens.INSTANCE.m3268getOnPrimaryFixed0d7_KjU() : j39;
        long m3269getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorLightTokens.INSTANCE.m3269getOnPrimaryFixedVariant0d7_KjU() : j40;
        long m3289getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorLightTokens.INSTANCE.m3289getSecondaryFixed0d7_KjU() : j41;
        long m3290getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorLightTokens.INSTANCE.m3290getSecondaryFixedDim0d7_KjU() : j42;
        long m3272getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorLightTokens.INSTANCE.m3272getOnSecondaryFixed0d7_KjU() : j43;
        long m3273getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorLightTokens.INSTANCE.m3273getOnSecondaryFixedVariant0d7_KjU() : j44;
        long m3303getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorLightTokens.INSTANCE.m3303getTertiaryFixed0d7_KjU() : j45;
        long m3304getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorLightTokens.INSTANCE.m3304getTertiaryFixedDim0d7_KjU() : j46;
        long m3278getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorLightTokens.INSTANCE.m3278getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorLightTokens.INSTANCE.m3279getOnTertiaryFixedVariant0d7_KjU();
        }
        return m1913lightColorScheme_VG5OTI(j49, m3266getOnPrimary0d7_KjU, m3283getPrimaryContainer0d7_KjU, m3267getOnPrimaryContainer0d7_KjU, m3261getInversePrimary0d7_KjU, m3287getSecondary0d7_KjU, m3270getOnSecondary0d7_KjU, m3288getSecondaryContainer0d7_KjU, m3271getOnSecondaryContainer0d7_KjU, m3301getTertiary0d7_KjU, m3276getOnTertiary0d7_KjU, m3302getTertiaryContainer0d7_KjU, m3277getOnTertiaryContainer0d7_KjU, m3257getBackground0d7_KjU, m3263getOnBackground0d7_KjU, m3291getSurface0d7_KjU, m3274getOnSurface0d7_KjU, m3300getSurfaceVariant0d7_KjU, m3275getOnSurfaceVariant0d7_KjU, j50, m3262getInverseSurface0d7_KjU, m3260getInverseOnSurface0d7_KjU, m3258getError0d7_KjU, m3264getOnError0d7_KjU, m3259getErrorContainer0d7_KjU, m3265getOnErrorContainer0d7_KjU, m3280getOutline0d7_KjU, m3281getOutlineVariant0d7_KjU, m3286getScrim0d7_KjU, m3292getSurfaceBright0d7_KjU, m3293getSurfaceContainer0d7_KjU, m3294getSurfaceContainerHigh0d7_KjU, m3295getSurfaceContainerHighest0d7_KjU, m3296getSurfaceContainerLow0d7_KjU, m3297getSurfaceContainerLowest0d7_KjU, m3298getSurfaceDim0d7_KjU, m3284getPrimaryFixed0d7_KjU, m3285getPrimaryFixedDim0d7_KjU, m3268getOnPrimaryFixed0d7_KjU, m3269getOnPrimaryFixedVariant0d7_KjU, m3289getSecondaryFixed0d7_KjU, m3290getSecondaryFixedDim0d7_KjU, m3272getOnSecondaryFixed0d7_KjU, m3273getOnSecondaryFixedVariant0d7_KjU, m3303getTertiaryFixed0d7_KjU, m3304getTertiaryFixedDim0d7_KjU, m3278getOnTertiaryFixed0d7_KjU, j48);
    }

    /* renamed from: lightColorScheme-_VG5OTI */
    public static final ColorScheme m1913lightColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* renamed from: darkColorScheme-_VG5OTI$default */
    public static /* synthetic */ ColorScheme m1908darkColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long m3234getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3234getPrimary0d7_KjU() : j;
        long m3218getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3218getOnPrimary0d7_KjU() : j2;
        long m3235getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3235getPrimaryContainer0d7_KjU() : j3;
        long m3219getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3219getOnPrimaryContainer0d7_KjU() : j4;
        long m3213getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3213getInversePrimary0d7_KjU() : j5;
        long m3239getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3239getSecondary0d7_KjU() : j6;
        long m3222getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3222getOnSecondary0d7_KjU() : j7;
        long j49 = m3234getPrimary0d7_KjU;
        long m3240getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3240getSecondaryContainer0d7_KjU() : j8;
        long m3223getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3223getOnSecondaryContainer0d7_KjU() : j9;
        long m3253getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3253getTertiary0d7_KjU() : j10;
        long m3228getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3228getOnTertiary0d7_KjU() : j11;
        long m3254getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3254getTertiaryContainer0d7_KjU() : j12;
        long m3229getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3229getOnTertiaryContainer0d7_KjU() : j13;
        long m3209getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3209getBackground0d7_KjU() : j14;
        long m3215getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3215getOnBackground0d7_KjU() : j15;
        long m3243getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3243getSurface0d7_KjU() : j16;
        long m3226getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3226getOnSurface0d7_KjU() : j17;
        long m3252getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3252getSurfaceVariant0d7_KjU() : j18;
        long m3227getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3227getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long m3214getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3214getInverseSurface0d7_KjU() : j21;
        long m3212getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3212getInverseOnSurface0d7_KjU() : j22;
        long m3210getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3210getError0d7_KjU() : j23;
        long m3216getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3216getOnError0d7_KjU() : j24;
        long m3211getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3211getErrorContainer0d7_KjU() : j25;
        long m3217getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3217getOnErrorContainer0d7_KjU() : j26;
        long m3232getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3232getOutline0d7_KjU() : j27;
        long m3233getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3233getOutlineVariant0d7_KjU() : j28;
        long m3238getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3238getScrim0d7_KjU() : j29;
        long m3244getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3244getSurfaceBright0d7_KjU() : j30;
        long m3245getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3245getSurfaceContainer0d7_KjU() : j31;
        long m3246getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3246getSurfaceContainerHigh0d7_KjU() : j32;
        long m3247getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3247getSurfaceContainerHighest0d7_KjU() : j33;
        long m3248getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3248getSurfaceContainerLow0d7_KjU() : j34;
        long m3249getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3249getSurfaceContainerLowest0d7_KjU() : j35;
        long m3250getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorDarkTokens.INSTANCE.m3250getSurfaceDim0d7_KjU() : j36;
        long m3236getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorDarkTokens.INSTANCE.m3236getPrimaryFixed0d7_KjU() : j37;
        long m3237getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorDarkTokens.INSTANCE.m3237getPrimaryFixedDim0d7_KjU() : j38;
        long m3220getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorDarkTokens.INSTANCE.m3220getOnPrimaryFixed0d7_KjU() : j39;
        long m3221getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorDarkTokens.INSTANCE.m3221getOnPrimaryFixedVariant0d7_KjU() : j40;
        long m3241getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorDarkTokens.INSTANCE.m3241getSecondaryFixed0d7_KjU() : j41;
        long m3242getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorDarkTokens.INSTANCE.m3242getSecondaryFixedDim0d7_KjU() : j42;
        long m3224getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3224getOnSecondaryFixed0d7_KjU() : j43;
        long m3225getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3225getOnSecondaryFixedVariant0d7_KjU() : j44;
        long m3255getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3255getTertiaryFixed0d7_KjU() : j45;
        long m3256getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3256getTertiaryFixedDim0d7_KjU() : j46;
        long m3230getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3230getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorDarkTokens.INSTANCE.m3231getOnTertiaryFixedVariant0d7_KjU();
        }
        return m1907darkColorScheme_VG5OTI(j49, m3218getOnPrimary0d7_KjU, m3235getPrimaryContainer0d7_KjU, m3219getOnPrimaryContainer0d7_KjU, m3213getInversePrimary0d7_KjU, m3239getSecondary0d7_KjU, m3222getOnSecondary0d7_KjU, m3240getSecondaryContainer0d7_KjU, m3223getOnSecondaryContainer0d7_KjU, m3253getTertiary0d7_KjU, m3228getOnTertiary0d7_KjU, m3254getTertiaryContainer0d7_KjU, m3229getOnTertiaryContainer0d7_KjU, m3209getBackground0d7_KjU, m3215getOnBackground0d7_KjU, m3243getSurface0d7_KjU, m3226getOnSurface0d7_KjU, m3252getSurfaceVariant0d7_KjU, m3227getOnSurfaceVariant0d7_KjU, j50, m3214getInverseSurface0d7_KjU, m3212getInverseOnSurface0d7_KjU, m3210getError0d7_KjU, m3216getOnError0d7_KjU, m3211getErrorContainer0d7_KjU, m3217getOnErrorContainer0d7_KjU, m3232getOutline0d7_KjU, m3233getOutlineVariant0d7_KjU, m3238getScrim0d7_KjU, m3244getSurfaceBright0d7_KjU, m3245getSurfaceContainer0d7_KjU, m3246getSurfaceContainerHigh0d7_KjU, m3247getSurfaceContainerHighest0d7_KjU, m3248getSurfaceContainerLow0d7_KjU, m3249getSurfaceContainerLowest0d7_KjU, m3250getSurfaceDim0d7_KjU, m3236getPrimaryFixed0d7_KjU, m3237getPrimaryFixedDim0d7_KjU, m3220getOnPrimaryFixed0d7_KjU, m3221getOnPrimaryFixedVariant0d7_KjU, m3241getSecondaryFixed0d7_KjU, m3242getSecondaryFixedDim0d7_KjU, m3224getOnSecondaryFixed0d7_KjU, m3225getOnSecondaryFixedVariant0d7_KjU, m3255getTertiaryFixed0d7_KjU, m3256getTertiaryFixedDim0d7_KjU, m3230getOnTertiaryFixed0d7_KjU, j48);
    }

    /* renamed from: darkColorScheme-_VG5OTI */
    public static final ColorScheme m1907darkColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* renamed from: contentColorFor-4WTKRHQ */
    public static final long m1901contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m4773equalsimpl0(j, colorScheme.m1877getPrimary0d7_KjU())) {
            return colorScheme.m1861getOnPrimary0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1882getSecondary0d7_KjU())) {
            return colorScheme.m1865getOnSecondary0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1896getTertiary0d7_KjU())) {
            return colorScheme.m1871getOnTertiary0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1852getBackground0d7_KjU())) {
            return colorScheme.m1858getOnBackground0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1853getError0d7_KjU())) {
            return colorScheme.m1859getOnError0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1878getPrimaryContainer0d7_KjU())) {
            return colorScheme.m1862getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1883getSecondaryContainer0d7_KjU())) {
            return colorScheme.m1866getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1897getTertiaryContainer0d7_KjU())) {
            return colorScheme.m1872getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1854getErrorContainer0d7_KjU())) {
            return colorScheme.m1860getOnErrorContainer0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1857getInverseSurface0d7_KjU())) {
            return colorScheme.m1855getInverseOnSurface0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1886getSurface0d7_KjU())) {
            return colorScheme.m1869getOnSurface0d7_KjU();
        }
        if (Color.m4773equalsimpl0(j, colorScheme.m1895getSurfaceVariant0d7_KjU())) {
            return colorScheme.m1870getOnSurfaceVariant0d7_KjU();
        }
        if (!Color.m4773equalsimpl0(j, colorScheme.m1887getSurfaceBright0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1888getSurfaceContainer0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1889getSurfaceContainerHigh0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1890getSurfaceContainerHighest0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1891getSurfaceContainerLow0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1892getSurfaceContainerLowest0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1893getSurfaceDim0d7_KjU())) {
            if (!Color.m4773equalsimpl0(j, colorScheme.m1879getPrimaryFixed0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1880getPrimaryFixedDim0d7_KjU())) {
                if (!Color.m4773equalsimpl0(j, colorScheme.m1884getSecondaryFixed0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1885getSecondaryFixedDim0d7_KjU())) {
                    if (!Color.m4773equalsimpl0(j, colorScheme.m1898getTertiaryFixed0d7_KjU()) && !Color.m4773equalsimpl0(j, colorScheme.m1899getTertiaryFixedDim0d7_KjU())) {
                        return Color.Companion.m4808getUnspecified0d7_KjU();
                    }
                    return colorScheme.m1873getOnTertiaryFixed0d7_KjU();
                }
                return colorScheme.m1867getOnSecondaryFixed0d7_KjU();
            }
            return colorScheme.m1863getOnPrimaryFixed0d7_KjU();
        }
        return colorScheme.m1869getOnSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U */
    public static final long m1902contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)N(backgroundColor:c#ui.graphics.Color)1112@50936L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
        }
        composer.startReplaceGroup(89374938);
        ComposerKt.sourceInformation(composer, "*1113@51020L7");
        long m1901contentColorFor4WTKRHQ = m1901contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (m1901contentColorFor4WTKRHQ == 16) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            m1901contentColorFor4WTKRHQ = ((Color) consume).m4782unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1901contentColorFor4WTKRHQ;
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m1914lightColorScheme_VG5OTI$default(0L, 0L, 0L, PaletteTokens.INSTANCE.m3659getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m3672getSecondary300d7_KjU(), 0L, 0L, 0L, PaletteTokens.INSTANCE.m3685getTertiary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m3609getError300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -33558793, 65535, null);
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m1910lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3282getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3282getPrimary0d7_KjU() : j;
        long m3266getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3266getOnPrimary0d7_KjU() : j2;
        long m3283getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3283getPrimaryContainer0d7_KjU() : j3;
        long m3267getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3267getOnPrimaryContainer0d7_KjU() : j4;
        long m3261getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3261getInversePrimary0d7_KjU() : j5;
        long m3287getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3287getSecondary0d7_KjU() : j6;
        long m3270getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3270getOnSecondary0d7_KjU() : j7;
        long m3288getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3288getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3282getPrimary0d7_KjU;
        long m3271getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3271getOnSecondaryContainer0d7_KjU() : j9;
        long m3301getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3301getTertiary0d7_KjU() : j10;
        long m3276getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3276getOnTertiary0d7_KjU() : j11;
        long m3302getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3302getTertiaryContainer0d7_KjU() : j12;
        long m3277getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3277getOnTertiaryContainer0d7_KjU() : j13;
        long m3257getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3257getBackground0d7_KjU() : j14;
        long m3263getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3263getOnBackground0d7_KjU() : j15;
        long m3291getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3291getSurface0d7_KjU() : j16;
        long m3274getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3274getOnSurface0d7_KjU() : j17;
        long m3300getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3300getSurfaceVariant0d7_KjU() : j18;
        long m3275getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3275getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3262getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3262getInverseSurface0d7_KjU() : j21;
        long m3260getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3260getInverseOnSurface0d7_KjU() : j22;
        long m3258getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3258getError0d7_KjU() : j23;
        long m3264getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3264getOnError0d7_KjU() : j24;
        long m3259getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3259getErrorContainer0d7_KjU() : j25;
        long m3265getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3265getOnErrorContainer0d7_KjU() : j26;
        long m3280getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3280getOutline0d7_KjU() : j27;
        long m3281getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3281getOutlineVariant0d7_KjU() : j28;
        long m3286getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3286getScrim0d7_KjU() : j29;
        long m3292getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3292getSurfaceBright0d7_KjU() : j30;
        long m3293getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3293getSurfaceContainer0d7_KjU() : j31;
        long m3294getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3294getSurfaceContainerHigh0d7_KjU() : j32;
        long m3295getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3295getSurfaceContainerHighest0d7_KjU() : j33;
        long m3296getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3296getSurfaceContainerLow0d7_KjU() : j34;
        long m3297getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3297getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m3298getSurfaceDim0d7_KjU();
        }
        return m1914lightColorScheme_VG5OTI$default(j37, m3266getOnPrimary0d7_KjU, m3283getPrimaryContainer0d7_KjU, m3267getOnPrimaryContainer0d7_KjU, m3261getInversePrimary0d7_KjU, m3287getSecondary0d7_KjU, m3270getOnSecondary0d7_KjU, m3288getSecondaryContainer0d7_KjU, m3271getOnSecondaryContainer0d7_KjU, m3301getTertiary0d7_KjU, m3276getOnTertiary0d7_KjU, m3302getTertiaryContainer0d7_KjU, m3277getOnTertiaryContainer0d7_KjU, m3257getBackground0d7_KjU, m3263getOnBackground0d7_KjU, m3291getSurface0d7_KjU, m3274getOnSurface0d7_KjU, m3300getSurfaceVariant0d7_KjU, m3275getOnSurfaceVariant0d7_KjU, j38, m3262getInverseSurface0d7_KjU, m3260getInverseOnSurface0d7_KjU, m3258getError0d7_KjU, m3264getOnError0d7_KjU, m3259getErrorContainer0d7_KjU, m3265getOnErrorContainer0d7_KjU, m3280getOutline0d7_KjU, m3281getOutlineVariant0d7_KjU, m3286getScrim0d7_KjU, m3292getSurfaceBright0d7_KjU, m3293getSurfaceContainer0d7_KjU, m3294getSurfaceContainerHigh0d7_KjU, m3295getSurfaceContainerHighest0d7_KjU, m3296getSurfaceContainerLow0d7_KjU, m3297getSurfaceContainerLowest0d7_KjU, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m1912lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3282getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3282getPrimary0d7_KjU() : j;
        long m3266getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3266getOnPrimary0d7_KjU() : j2;
        long m3283getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3283getPrimaryContainer0d7_KjU() : j3;
        long m3267getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3267getOnPrimaryContainer0d7_KjU() : j4;
        long m3261getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3261getInversePrimary0d7_KjU() : j5;
        long m3287getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3287getSecondary0d7_KjU() : j6;
        long m3270getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3270getOnSecondary0d7_KjU() : j7;
        long m3288getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3288getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3282getPrimary0d7_KjU;
        long m3271getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3271getOnSecondaryContainer0d7_KjU() : j9;
        long m3301getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3301getTertiary0d7_KjU() : j10;
        long m3276getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3276getOnTertiary0d7_KjU() : j11;
        long m3302getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3302getTertiaryContainer0d7_KjU() : j12;
        long m3277getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3277getOnTertiaryContainer0d7_KjU() : j13;
        long m3257getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3257getBackground0d7_KjU() : j14;
        long m3263getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3263getOnBackground0d7_KjU() : j15;
        long m3291getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3291getSurface0d7_KjU() : j16;
        long m3274getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3274getOnSurface0d7_KjU() : j17;
        long m3300getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3300getSurfaceVariant0d7_KjU() : j18;
        long m3275getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3275getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3262getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3262getInverseSurface0d7_KjU() : j21;
        long m3260getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3260getInverseOnSurface0d7_KjU() : j22;
        long m3258getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3258getError0d7_KjU() : j23;
        long m3264getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3264getOnError0d7_KjU() : j24;
        long m3259getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3259getErrorContainer0d7_KjU() : j25;
        long m3265getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3265getOnErrorContainer0d7_KjU() : j26;
        long m3280getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3280getOutline0d7_KjU() : j27;
        long m3281getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m3281getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m3286getScrim0d7_KjU();
        }
        return m1914lightColorScheme_VG5OTI$default(j30, m3266getOnPrimary0d7_KjU, m3283getPrimaryContainer0d7_KjU, m3267getOnPrimaryContainer0d7_KjU, m3261getInversePrimary0d7_KjU, m3287getSecondary0d7_KjU, m3270getOnSecondary0d7_KjU, m3288getSecondaryContainer0d7_KjU, m3271getOnSecondaryContainer0d7_KjU, m3301getTertiary0d7_KjU, m3276getOnTertiary0d7_KjU, m3302getTertiaryContainer0d7_KjU, m3277getOnTertiaryContainer0d7_KjU, m3257getBackground0d7_KjU, m3263getOnBackground0d7_KjU, m3291getSurface0d7_KjU, m3274getOnSurface0d7_KjU, m3300getSurfaceVariant0d7_KjU, m3275getOnSurfaceVariant0d7_KjU, j31, m3262getInverseSurface0d7_KjU, m3260getInverseOnSurface0d7_KjU, m3258getError0d7_KjU, m3264getOnError0d7_KjU, m3259getErrorContainer0d7_KjU, m3265getOnErrorContainer0d7_KjU, m3280getOutline0d7_KjU, m3281getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 65535, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m1904darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3234getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3234getPrimary0d7_KjU() : j;
        long m3218getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3218getOnPrimary0d7_KjU() : j2;
        long m3235getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3235getPrimaryContainer0d7_KjU() : j3;
        long m3219getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3219getOnPrimaryContainer0d7_KjU() : j4;
        long m3213getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3213getInversePrimary0d7_KjU() : j5;
        long m3239getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3239getSecondary0d7_KjU() : j6;
        long m3222getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3222getOnSecondary0d7_KjU() : j7;
        long m3240getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3240getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3234getPrimary0d7_KjU;
        long m3223getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3223getOnSecondaryContainer0d7_KjU() : j9;
        long m3253getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3253getTertiary0d7_KjU() : j10;
        long m3228getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3228getOnTertiary0d7_KjU() : j11;
        long m3254getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3254getTertiaryContainer0d7_KjU() : j12;
        long m3229getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3229getOnTertiaryContainer0d7_KjU() : j13;
        long m3209getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3209getBackground0d7_KjU() : j14;
        long m3215getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3215getOnBackground0d7_KjU() : j15;
        long m3243getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3243getSurface0d7_KjU() : j16;
        long m3226getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3226getOnSurface0d7_KjU() : j17;
        long m3252getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3252getSurfaceVariant0d7_KjU() : j18;
        long m3227getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3227getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3214getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3214getInverseSurface0d7_KjU() : j21;
        long m3212getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3212getInverseOnSurface0d7_KjU() : j22;
        long m3210getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3210getError0d7_KjU() : j23;
        long m3216getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3216getOnError0d7_KjU() : j24;
        long m3211getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3211getErrorContainer0d7_KjU() : j25;
        long m3217getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3217getOnErrorContainer0d7_KjU() : j26;
        long m3232getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3232getOutline0d7_KjU() : j27;
        long m3233getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3233getOutlineVariant0d7_KjU() : j28;
        long m3238getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3238getScrim0d7_KjU() : j29;
        long m3244getSurfaceBright0d7_KjU = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3244getSurfaceBright0d7_KjU() : j30;
        long m3245getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3245getSurfaceContainer0d7_KjU() : j31;
        long m3246getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3246getSurfaceContainerHigh0d7_KjU() : j32;
        long m3247getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3247getSurfaceContainerHighest0d7_KjU() : j33;
        long m3248getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3248getSurfaceContainerLow0d7_KjU() : j34;
        long m3249getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3249getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m3250getSurfaceDim0d7_KjU();
        }
        return m1908darkColorScheme_VG5OTI$default(j37, m3218getOnPrimary0d7_KjU, m3235getPrimaryContainer0d7_KjU, m3219getOnPrimaryContainer0d7_KjU, m3213getInversePrimary0d7_KjU, m3239getSecondary0d7_KjU, m3222getOnSecondary0d7_KjU, m3240getSecondaryContainer0d7_KjU, m3223getOnSecondaryContainer0d7_KjU, m3253getTertiary0d7_KjU, m3228getOnTertiary0d7_KjU, m3254getTertiaryContainer0d7_KjU, m3229getOnTertiaryContainer0d7_KjU, m3209getBackground0d7_KjU, m3215getOnBackground0d7_KjU, m3243getSurface0d7_KjU, m3226getOnSurface0d7_KjU, m3252getSurfaceVariant0d7_KjU, m3227getOnSurfaceVariant0d7_KjU, j38, m3214getInverseSurface0d7_KjU, m3212getInverseOnSurface0d7_KjU, m3210getError0d7_KjU, m3216getOnError0d7_KjU, m3211getErrorContainer0d7_KjU, m3217getOnErrorContainer0d7_KjU, m3232getOutline0d7_KjU, m3233getOutlineVariant0d7_KjU, m3238getScrim0d7_KjU, m3244getSurfaceBright0d7_KjU, m3245getSurfaceContainer0d7_KjU, m3246getSurfaceContainerHigh0d7_KjU, m3247getSurfaceContainerHighest0d7_KjU, m3248getSurfaceContainerLow0d7_KjU, m3249getSurfaceContainerLowest0d7_KjU, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m1906darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3234getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3234getPrimary0d7_KjU() : j;
        long m3218getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3218getOnPrimary0d7_KjU() : j2;
        long m3235getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3235getPrimaryContainer0d7_KjU() : j3;
        long m3219getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3219getOnPrimaryContainer0d7_KjU() : j4;
        long m3213getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3213getInversePrimary0d7_KjU() : j5;
        long m3239getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3239getSecondary0d7_KjU() : j6;
        long m3222getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3222getOnSecondary0d7_KjU() : j7;
        long m3240getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3240getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3234getPrimary0d7_KjU;
        long m3223getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3223getOnSecondaryContainer0d7_KjU() : j9;
        long m3253getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3253getTertiary0d7_KjU() : j10;
        long m3228getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3228getOnTertiary0d7_KjU() : j11;
        long m3254getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3254getTertiaryContainer0d7_KjU() : j12;
        long m3229getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3229getOnTertiaryContainer0d7_KjU() : j13;
        long m3209getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3209getBackground0d7_KjU() : j14;
        long m3215getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3215getOnBackground0d7_KjU() : j15;
        long m3243getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3243getSurface0d7_KjU() : j16;
        long m3226getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3226getOnSurface0d7_KjU() : j17;
        long m3252getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3252getSurfaceVariant0d7_KjU() : j18;
        long m3227getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3227getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3214getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3214getInverseSurface0d7_KjU() : j21;
        long m3212getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3212getInverseOnSurface0d7_KjU() : j22;
        long m3210getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3210getError0d7_KjU() : j23;
        long m3216getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3216getOnError0d7_KjU() : j24;
        long m3211getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3211getErrorContainer0d7_KjU() : j25;
        long m3217getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3217getOnErrorContainer0d7_KjU() : j26;
        long m3232getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3232getOutline0d7_KjU() : j27;
        long m3233getOutlineVariant0d7_KjU = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m3233getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m3238getScrim0d7_KjU();
        }
        return m1908darkColorScheme_VG5OTI$default(j30, m3218getOnPrimary0d7_KjU, m3235getPrimaryContainer0d7_KjU, m3219getOnPrimaryContainer0d7_KjU, m3213getInversePrimary0d7_KjU, m3239getSecondary0d7_KjU, m3222getOnSecondary0d7_KjU, m3240getSecondaryContainer0d7_KjU, m3223getOnSecondaryContainer0d7_KjU, m3253getTertiary0d7_KjU, m3228getOnTertiary0d7_KjU, m3254getTertiaryContainer0d7_KjU, m3229getOnTertiaryContainer0d7_KjU, m3209getBackground0d7_KjU, m3215getOnBackground0d7_KjU, m3243getSurface0d7_KjU, m3226getOnSurface0d7_KjU, m3252getSurfaceVariant0d7_KjU, m3227getOnSurfaceVariant0d7_KjU, j31, m3214getInverseSurface0d7_KjU, m3212getInverseOnSurface0d7_KjU, m3210getError0d7_KjU, m3216getOnError0d7_KjU, m3211getErrorContainer0d7_KjU, m3217getOnErrorContainer0d7_KjU, m3232getOutline0d7_KjU, m3233getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 65535, null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m1852getBackground0d7_KjU();
            case 2:
                return colorScheme.m1853getError0d7_KjU();
            case 3:
                return colorScheme.m1854getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1855getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1856getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1857getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1858getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1859getOnError0d7_KjU();
            case 9:
                return colorScheme.m1860getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1861getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1862getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1865getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1866getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1869getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1870getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1894getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1871getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1872getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1875getOutline0d7_KjU();
            case 20:
                return colorScheme.m1876getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1877getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1878getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1881getScrim0d7_KjU();
            case 24:
                return colorScheme.m1882getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1883getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1886getSurface0d7_KjU();
            case 27:
                return colorScheme.m1895getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m1887getSurfaceBright0d7_KjU();
            case 29:
                return colorScheme.m1888getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m1889getSurfaceContainerHigh0d7_KjU();
            case 31:
                return colorScheme.m1890getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m1891getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m1892getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m1893getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m1896getTertiary0d7_KjU();
            case 36:
                return colorScheme.m1897getTertiaryContainer0d7_KjU();
            case 37:
                return colorScheme.m1879getPrimaryFixed0d7_KjU();
            case 38:
                return colorScheme.m1880getPrimaryFixedDim0d7_KjU();
            case 39:
                return colorScheme.m1863getOnPrimaryFixed0d7_KjU();
            case 40:
                return colorScheme.m1864getOnPrimaryFixedVariant0d7_KjU();
            case 41:
                return colorScheme.m1884getSecondaryFixed0d7_KjU();
            case 42:
                return colorScheme.m1885getSecondaryFixedDim0d7_KjU();
            case 43:
                return colorScheme.m1867getOnSecondaryFixed0d7_KjU();
            case 44:
                return colorScheme.m1868getOnSecondaryFixedVariant0d7_KjU();
            case 45:
                return colorScheme.m1898getTertiaryFixed0d7_KjU();
            case 46:
                return colorScheme.m1899getTertiaryFixedDim0d7_KjU();
            case 47:
                return colorScheme.m1873getOnTertiaryFixed0d7_KjU();
            case 48:
                return colorScheme.m1874getOnTertiaryFixedVariant0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -810780884, "C(<get-value>)1524@69711L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1524)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fromToken;
    }

    /* renamed from: applyTonalElevation-RFCenO8 */
    public static final long m1900applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)1540@70581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalTonalElevationEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (Color.m4773equalsimpl0(j, colorScheme.m1886getSurface0d7_KjU()) && booleanValue) {
            j = m1915surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs */
    public static final long m1915surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m7560equalsimpl0(f, Dp.m7555constructorimpl(0.0f))) {
            return colorScheme.m1886getSurface0d7_KjU();
        }
        return ColorKt.m4817compositeOverOWjLjI(Color.m4771copywmQWz5c$default(colorScheme.m1894getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m1886getSurface0d7_KjU());
    }
}

package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aí\u0003\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104\u001aí\u0003\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b6\u00104\u001a\u001b\u00107\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0017\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u00020\u0003*\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001a\b\u0010B\u001a\u00020\u0001H\u0000\u001a÷\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001a±\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001a÷\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001a±\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001a\u0019\u0010I\u001a\u00020\u0003*\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001a#\u0010U\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P\"\u000e\u0010Q\u001a\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001a\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010P¨\u0006["}, d2 = {"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", M2.g, "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ColorScheme m2359lightColorScheme_VG5OTI$default;
            m2359lightColorScheme_VG5OTI$default = ColorSchemeKt.m2359lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 65535, null);
            return m2359lightColorScheme_VG5OTI$default;
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
    public static /* synthetic */ ColorScheme m2359lightColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long m3727getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3727getPrimary0d7_KjU() : j;
        long m3711getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3711getOnPrimary0d7_KjU() : j2;
        long m3728getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3728getPrimaryContainer0d7_KjU() : j3;
        long m3712getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3712getOnPrimaryContainer0d7_KjU() : j4;
        long m3706getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3706getInversePrimary0d7_KjU() : j5;
        long m3732getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3732getSecondary0d7_KjU() : j6;
        long m3715getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3715getOnSecondary0d7_KjU() : j7;
        long j49 = m3727getPrimary0d7_KjU;
        long m3733getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3733getSecondaryContainer0d7_KjU() : j8;
        long m3716getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3716getOnSecondaryContainer0d7_KjU() : j9;
        long m3746getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3746getTertiary0d7_KjU() : j10;
        long m3721getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3721getOnTertiary0d7_KjU() : j11;
        long m3747getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3747getTertiaryContainer0d7_KjU() : j12;
        long m3722getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3722getOnTertiaryContainer0d7_KjU() : j13;
        long m3702getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3702getBackground0d7_KjU() : j14;
        long m3708getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3708getOnBackground0d7_KjU() : j15;
        long m3736getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3736getSurface0d7_KjU() : j16;
        long m3719getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3719getOnSurface0d7_KjU() : j17;
        long m3745getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3745getSurfaceVariant0d7_KjU() : j18;
        long m3720getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3720getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long m3707getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3707getInverseSurface0d7_KjU() : j21;
        long m3705getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3705getInverseOnSurface0d7_KjU() : j22;
        long m3703getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3703getError0d7_KjU() : j23;
        long m3709getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3709getOnError0d7_KjU() : j24;
        long m3704getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3704getErrorContainer0d7_KjU() : j25;
        long m3710getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorLightTokens.INSTANCE.m3710getOnErrorContainer0d7_KjU() : j26;
        long m3725getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3725getOutline0d7_KjU() : j27;
        long m3726getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m3726getOutlineVariant0d7_KjU() : j28;
        long m3731getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3731getScrim0d7_KjU() : j29;
        long m3737getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m3737getSurfaceBright0d7_KjU() : j30;
        long m3738getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3738getSurfaceContainer0d7_KjU() : j31;
        long m3739getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3739getSurfaceContainerHigh0d7_KjU() : j32;
        long m3740getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3740getSurfaceContainerHighest0d7_KjU() : j33;
        long m3741getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3741getSurfaceContainerLow0d7_KjU() : j34;
        long m3742getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3742getSurfaceContainerLowest0d7_KjU() : j35;
        long m3743getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorLightTokens.INSTANCE.m3743getSurfaceDim0d7_KjU() : j36;
        long m3729getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorLightTokens.INSTANCE.m3729getPrimaryFixed0d7_KjU() : j37;
        long m3730getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorLightTokens.INSTANCE.m3730getPrimaryFixedDim0d7_KjU() : j38;
        long m3713getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorLightTokens.INSTANCE.m3713getOnPrimaryFixed0d7_KjU() : j39;
        long m3714getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorLightTokens.INSTANCE.m3714getOnPrimaryFixedVariant0d7_KjU() : j40;
        long m3734getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorLightTokens.INSTANCE.m3734getSecondaryFixed0d7_KjU() : j41;
        long m3735getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorLightTokens.INSTANCE.m3735getSecondaryFixedDim0d7_KjU() : j42;
        long m3717getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorLightTokens.INSTANCE.m3717getOnSecondaryFixed0d7_KjU() : j43;
        long m3718getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorLightTokens.INSTANCE.m3718getOnSecondaryFixedVariant0d7_KjU() : j44;
        long m3748getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorLightTokens.INSTANCE.m3748getTertiaryFixed0d7_KjU() : j45;
        long m3749getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorLightTokens.INSTANCE.m3749getTertiaryFixedDim0d7_KjU() : j46;
        long m3723getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorLightTokens.INSTANCE.m3723getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorLightTokens.INSTANCE.m3724getOnTertiaryFixedVariant0d7_KjU();
        }
        return m2358lightColorScheme_VG5OTI(j49, m3711getOnPrimary0d7_KjU, m3728getPrimaryContainer0d7_KjU, m3712getOnPrimaryContainer0d7_KjU, m3706getInversePrimary0d7_KjU, m3732getSecondary0d7_KjU, m3715getOnSecondary0d7_KjU, m3733getSecondaryContainer0d7_KjU, m3716getOnSecondaryContainer0d7_KjU, m3746getTertiary0d7_KjU, m3721getOnTertiary0d7_KjU, m3747getTertiaryContainer0d7_KjU, m3722getOnTertiaryContainer0d7_KjU, m3702getBackground0d7_KjU, m3708getOnBackground0d7_KjU, m3736getSurface0d7_KjU, m3719getOnSurface0d7_KjU, m3745getSurfaceVariant0d7_KjU, m3720getOnSurfaceVariant0d7_KjU, j50, m3707getInverseSurface0d7_KjU, m3705getInverseOnSurface0d7_KjU, m3703getError0d7_KjU, m3709getOnError0d7_KjU, m3704getErrorContainer0d7_KjU, m3710getOnErrorContainer0d7_KjU, m3725getOutline0d7_KjU, m3726getOutlineVariant0d7_KjU, m3731getScrim0d7_KjU, m3737getSurfaceBright0d7_KjU, m3738getSurfaceContainer0d7_KjU, m3739getSurfaceContainerHigh0d7_KjU, m3740getSurfaceContainerHighest0d7_KjU, m3741getSurfaceContainerLow0d7_KjU, m3742getSurfaceContainerLowest0d7_KjU, m3743getSurfaceDim0d7_KjU, m3729getPrimaryFixed0d7_KjU, m3730getPrimaryFixedDim0d7_KjU, m3713getOnPrimaryFixed0d7_KjU, m3714getOnPrimaryFixedVariant0d7_KjU, m3734getSecondaryFixed0d7_KjU, m3735getSecondaryFixedDim0d7_KjU, m3717getOnSecondaryFixed0d7_KjU, m3718getOnSecondaryFixedVariant0d7_KjU, m3748getTertiaryFixed0d7_KjU, m3749getTertiaryFixedDim0d7_KjU, m3723getOnTertiaryFixed0d7_KjU, j48);
    }

    /* renamed from: lightColorScheme-_VG5OTI */
    public static final ColorScheme m2358lightColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* renamed from: darkColorScheme-_VG5OTI$default */
    public static /* synthetic */ ColorScheme m2353darkColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long m3679getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3679getPrimary0d7_KjU() : j;
        long m3663getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3663getOnPrimary0d7_KjU() : j2;
        long m3680getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3680getPrimaryContainer0d7_KjU() : j3;
        long m3664getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3664getOnPrimaryContainer0d7_KjU() : j4;
        long m3658getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3658getInversePrimary0d7_KjU() : j5;
        long m3684getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3684getSecondary0d7_KjU() : j6;
        long m3667getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3667getOnSecondary0d7_KjU() : j7;
        long j49 = m3679getPrimary0d7_KjU;
        long m3685getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3685getSecondaryContainer0d7_KjU() : j8;
        long m3668getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3668getOnSecondaryContainer0d7_KjU() : j9;
        long m3698getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3698getTertiary0d7_KjU() : j10;
        long m3673getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3673getOnTertiary0d7_KjU() : j11;
        long m3699getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3699getTertiaryContainer0d7_KjU() : j12;
        long m3674getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3674getOnTertiaryContainer0d7_KjU() : j13;
        long m3654getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3654getBackground0d7_KjU() : j14;
        long m3660getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3660getOnBackground0d7_KjU() : j15;
        long m3688getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3688getSurface0d7_KjU() : j16;
        long m3671getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3671getOnSurface0d7_KjU() : j17;
        long m3697getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3697getSurfaceVariant0d7_KjU() : j18;
        long m3672getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3672getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long m3659getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3659getInverseSurface0d7_KjU() : j21;
        long m3657getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3657getInverseOnSurface0d7_KjU() : j22;
        long m3655getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3655getError0d7_KjU() : j23;
        long m3661getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3661getOnError0d7_KjU() : j24;
        long m3656getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3656getErrorContainer0d7_KjU() : j25;
        long m3662getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorDarkTokens.INSTANCE.m3662getOnErrorContainer0d7_KjU() : j26;
        long m3677getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3677getOutline0d7_KjU() : j27;
        long m3678getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m3678getOutlineVariant0d7_KjU() : j28;
        long m3683getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3683getScrim0d7_KjU() : j29;
        long m3689getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m3689getSurfaceBright0d7_KjU() : j30;
        long m3690getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3690getSurfaceContainer0d7_KjU() : j31;
        long m3691getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3691getSurfaceContainerHigh0d7_KjU() : j32;
        long m3692getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3692getSurfaceContainerHighest0d7_KjU() : j33;
        long m3693getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3693getSurfaceContainerLow0d7_KjU() : j34;
        long m3694getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3694getSurfaceContainerLowest0d7_KjU() : j35;
        long m3695getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorDarkTokens.INSTANCE.m3695getSurfaceDim0d7_KjU() : j36;
        long m3681getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorDarkTokens.INSTANCE.m3681getPrimaryFixed0d7_KjU() : j37;
        long m3682getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorDarkTokens.INSTANCE.m3682getPrimaryFixedDim0d7_KjU() : j38;
        long m3665getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorDarkTokens.INSTANCE.m3665getOnPrimaryFixed0d7_KjU() : j39;
        long m3666getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorDarkTokens.INSTANCE.m3666getOnPrimaryFixedVariant0d7_KjU() : j40;
        long m3686getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorDarkTokens.INSTANCE.m3686getSecondaryFixed0d7_KjU() : j41;
        long m3687getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorDarkTokens.INSTANCE.m3687getSecondaryFixedDim0d7_KjU() : j42;
        long m3669getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3669getOnSecondaryFixed0d7_KjU() : j43;
        long m3670getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3670getOnSecondaryFixedVariant0d7_KjU() : j44;
        long m3700getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3700getTertiaryFixed0d7_KjU() : j45;
        long m3701getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3701getTertiaryFixedDim0d7_KjU() : j46;
        long m3675getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3675getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorDarkTokens.INSTANCE.m3676getOnTertiaryFixedVariant0d7_KjU();
        }
        return m2352darkColorScheme_VG5OTI(j49, m3663getOnPrimary0d7_KjU, m3680getPrimaryContainer0d7_KjU, m3664getOnPrimaryContainer0d7_KjU, m3658getInversePrimary0d7_KjU, m3684getSecondary0d7_KjU, m3667getOnSecondary0d7_KjU, m3685getSecondaryContainer0d7_KjU, m3668getOnSecondaryContainer0d7_KjU, m3698getTertiary0d7_KjU, m3673getOnTertiary0d7_KjU, m3699getTertiaryContainer0d7_KjU, m3674getOnTertiaryContainer0d7_KjU, m3654getBackground0d7_KjU, m3660getOnBackground0d7_KjU, m3688getSurface0d7_KjU, m3671getOnSurface0d7_KjU, m3697getSurfaceVariant0d7_KjU, m3672getOnSurfaceVariant0d7_KjU, j50, m3659getInverseSurface0d7_KjU, m3657getInverseOnSurface0d7_KjU, m3655getError0d7_KjU, m3661getOnError0d7_KjU, m3656getErrorContainer0d7_KjU, m3662getOnErrorContainer0d7_KjU, m3677getOutline0d7_KjU, m3678getOutlineVariant0d7_KjU, m3683getScrim0d7_KjU, m3689getSurfaceBright0d7_KjU, m3690getSurfaceContainer0d7_KjU, m3691getSurfaceContainerHigh0d7_KjU, m3692getSurfaceContainerHighest0d7_KjU, m3693getSurfaceContainerLow0d7_KjU, m3694getSurfaceContainerLowest0d7_KjU, m3695getSurfaceDim0d7_KjU, m3681getPrimaryFixed0d7_KjU, m3682getPrimaryFixedDim0d7_KjU, m3665getOnPrimaryFixed0d7_KjU, m3666getOnPrimaryFixedVariant0d7_KjU, m3686getSecondaryFixed0d7_KjU, m3687getSecondaryFixedDim0d7_KjU, m3669getOnSecondaryFixed0d7_KjU, m3670getOnSecondaryFixedVariant0d7_KjU, m3700getTertiaryFixed0d7_KjU, m3701getTertiaryFixedDim0d7_KjU, m3675getOnTertiaryFixed0d7_KjU, j48);
    }

    /* renamed from: darkColorScheme-_VG5OTI */
    public static final ColorScheme m2352darkColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* renamed from: contentColorFor-4WTKRHQ */
    public static final long m2346contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m5349equalsimpl0(j, colorScheme.m2322getPrimary0d7_KjU())) {
            return colorScheme.m2306getOnPrimary0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2327getSecondary0d7_KjU())) {
            return colorScheme.m2310getOnSecondary0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2341getTertiary0d7_KjU())) {
            return colorScheme.m2316getOnTertiary0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2297getBackground0d7_KjU())) {
            return colorScheme.m2303getOnBackground0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2298getError0d7_KjU())) {
            return colorScheme.m2304getOnError0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2323getPrimaryContainer0d7_KjU())) {
            return colorScheme.m2307getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2328getSecondaryContainer0d7_KjU())) {
            return colorScheme.m2311getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2342getTertiaryContainer0d7_KjU())) {
            return colorScheme.m2317getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2299getErrorContainer0d7_KjU())) {
            return colorScheme.m2305getOnErrorContainer0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2302getInverseSurface0d7_KjU())) {
            return colorScheme.m2300getInverseOnSurface0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2331getSurface0d7_KjU())) {
            return colorScheme.m2314getOnSurface0d7_KjU();
        }
        if (Color.m5349equalsimpl0(j, colorScheme.m2340getSurfaceVariant0d7_KjU())) {
            return colorScheme.m2315getOnSurfaceVariant0d7_KjU();
        }
        if (!Color.m5349equalsimpl0(j, colorScheme.m2332getSurfaceBright0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2333getSurfaceContainer0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2334getSurfaceContainerHigh0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2335getSurfaceContainerHighest0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2336getSurfaceContainerLow0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2337getSurfaceContainerLowest0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2338getSurfaceDim0d7_KjU())) {
            if (!Color.m5349equalsimpl0(j, colorScheme.m2324getPrimaryFixed0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2325getPrimaryFixedDim0d7_KjU())) {
                if (!Color.m5349equalsimpl0(j, colorScheme.m2329getSecondaryFixed0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2330getSecondaryFixedDim0d7_KjU())) {
                    if (!Color.m5349equalsimpl0(j, colorScheme.m2343getTertiaryFixed0d7_KjU()) && !Color.m5349equalsimpl0(j, colorScheme.m2344getTertiaryFixedDim0d7_KjU())) {
                        return Color.Companion.m5384getUnspecified0d7_KjU();
                    }
                    return colorScheme.m2318getOnTertiaryFixed0d7_KjU();
                }
                return colorScheme.m2312getOnSecondaryFixed0d7_KjU();
            }
            return colorScheme.m2308getOnPrimaryFixed0d7_KjU();
        }
        return colorScheme.m2314getOnSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U */
    public static final long m2347contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)N(backgroundColor:c#ui.graphics.Color)1112@50936L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
        }
        composer.startReplaceGroup(89374938);
        ComposerKt.sourceInformation(composer, "*1113@51020L7");
        long m2346contentColorFor4WTKRHQ = m2346contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (m2346contentColorFor4WTKRHQ == 16) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            m2346contentColorFor4WTKRHQ = ((Color) consume).m5358unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2346contentColorFor4WTKRHQ;
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m2359lightColorScheme_VG5OTI$default(0L, 0L, 0L, PaletteTokens.INSTANCE.m4104getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m4117getSecondary300d7_KjU(), 0L, 0L, 0L, PaletteTokens.INSTANCE.m4130getTertiary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m4054getError300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -33558793, 65535, null);
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m2355lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3727getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3727getPrimary0d7_KjU() : j;
        long m3711getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3711getOnPrimary0d7_KjU() : j2;
        long m3728getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3728getPrimaryContainer0d7_KjU() : j3;
        long m3712getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3712getOnPrimaryContainer0d7_KjU() : j4;
        long m3706getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3706getInversePrimary0d7_KjU() : j5;
        long m3732getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3732getSecondary0d7_KjU() : j6;
        long m3715getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3715getOnSecondary0d7_KjU() : j7;
        long m3733getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3733getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3727getPrimary0d7_KjU;
        long m3716getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3716getOnSecondaryContainer0d7_KjU() : j9;
        long m3746getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3746getTertiary0d7_KjU() : j10;
        long m3721getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3721getOnTertiary0d7_KjU() : j11;
        long m3747getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3747getTertiaryContainer0d7_KjU() : j12;
        long m3722getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3722getOnTertiaryContainer0d7_KjU() : j13;
        long m3702getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3702getBackground0d7_KjU() : j14;
        long m3708getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3708getOnBackground0d7_KjU() : j15;
        long m3736getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3736getSurface0d7_KjU() : j16;
        long m3719getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3719getOnSurface0d7_KjU() : j17;
        long m3745getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3745getSurfaceVariant0d7_KjU() : j18;
        long m3720getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3720getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3707getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3707getInverseSurface0d7_KjU() : j21;
        long m3705getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3705getInverseOnSurface0d7_KjU() : j22;
        long m3703getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3703getError0d7_KjU() : j23;
        long m3709getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3709getOnError0d7_KjU() : j24;
        long m3704getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3704getErrorContainer0d7_KjU() : j25;
        long m3710getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorLightTokens.INSTANCE.m3710getOnErrorContainer0d7_KjU() : j26;
        long m3725getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3725getOutline0d7_KjU() : j27;
        long m3726getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m3726getOutlineVariant0d7_KjU() : j28;
        long m3731getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3731getScrim0d7_KjU() : j29;
        long m3737getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m3737getSurfaceBright0d7_KjU() : j30;
        long m3738getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3738getSurfaceContainer0d7_KjU() : j31;
        long m3739getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3739getSurfaceContainerHigh0d7_KjU() : j32;
        long m3740getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3740getSurfaceContainerHighest0d7_KjU() : j33;
        long m3741getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3741getSurfaceContainerLow0d7_KjU() : j34;
        long m3742getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3742getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m3743getSurfaceDim0d7_KjU();
        }
        return m2359lightColorScheme_VG5OTI$default(j37, m3711getOnPrimary0d7_KjU, m3728getPrimaryContainer0d7_KjU, m3712getOnPrimaryContainer0d7_KjU, m3706getInversePrimary0d7_KjU, m3732getSecondary0d7_KjU, m3715getOnSecondary0d7_KjU, m3733getSecondaryContainer0d7_KjU, m3716getOnSecondaryContainer0d7_KjU, m3746getTertiary0d7_KjU, m3721getOnTertiary0d7_KjU, m3747getTertiaryContainer0d7_KjU, m3722getOnTertiaryContainer0d7_KjU, m3702getBackground0d7_KjU, m3708getOnBackground0d7_KjU, m3736getSurface0d7_KjU, m3719getOnSurface0d7_KjU, m3745getSurfaceVariant0d7_KjU, m3720getOnSurfaceVariant0d7_KjU, j38, m3707getInverseSurface0d7_KjU, m3705getInverseOnSurface0d7_KjU, m3703getError0d7_KjU, m3709getOnError0d7_KjU, m3704getErrorContainer0d7_KjU, m3710getOnErrorContainer0d7_KjU, m3725getOutline0d7_KjU, m3726getOutlineVariant0d7_KjU, m3731getScrim0d7_KjU, m3737getSurfaceBright0d7_KjU, m3738getSurfaceContainer0d7_KjU, m3739getSurfaceContainerHigh0d7_KjU, m3740getSurfaceContainerHighest0d7_KjU, m3741getSurfaceContainerLow0d7_KjU, m3742getSurfaceContainerLowest0d7_KjU, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m2357lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3727getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m3727getPrimary0d7_KjU() : j;
        long m3711getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m3711getOnPrimary0d7_KjU() : j2;
        long m3728getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m3728getPrimaryContainer0d7_KjU() : j3;
        long m3712getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m3712getOnPrimaryContainer0d7_KjU() : j4;
        long m3706getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m3706getInversePrimary0d7_KjU() : j5;
        long m3732getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m3732getSecondary0d7_KjU() : j6;
        long m3715getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m3715getOnSecondary0d7_KjU() : j7;
        long m3733getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m3733getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3727getPrimary0d7_KjU;
        long m3716getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m3716getOnSecondaryContainer0d7_KjU() : j9;
        long m3746getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m3746getTertiary0d7_KjU() : j10;
        long m3721getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m3721getOnTertiary0d7_KjU() : j11;
        long m3747getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m3747getTertiaryContainer0d7_KjU() : j12;
        long m3722getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m3722getOnTertiaryContainer0d7_KjU() : j13;
        long m3702getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m3702getBackground0d7_KjU() : j14;
        long m3708getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m3708getOnBackground0d7_KjU() : j15;
        long m3736getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m3736getSurface0d7_KjU() : j16;
        long m3719getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m3719getOnSurface0d7_KjU() : j17;
        long m3745getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m3745getSurfaceVariant0d7_KjU() : j18;
        long m3720getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m3720getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3707getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3707getInverseSurface0d7_KjU() : j21;
        long m3705getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3705getInverseOnSurface0d7_KjU() : j22;
        long m3703getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3703getError0d7_KjU() : j23;
        long m3709getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3709getOnError0d7_KjU() : j24;
        long m3704getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3704getErrorContainer0d7_KjU() : j25;
        long m3710getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorLightTokens.INSTANCE.m3710getOnErrorContainer0d7_KjU() : j26;
        long m3725getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m3725getOutline0d7_KjU() : j27;
        long m3726getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m3726getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m3731getScrim0d7_KjU();
        }
        return m2359lightColorScheme_VG5OTI$default(j30, m3711getOnPrimary0d7_KjU, m3728getPrimaryContainer0d7_KjU, m3712getOnPrimaryContainer0d7_KjU, m3706getInversePrimary0d7_KjU, m3732getSecondary0d7_KjU, m3715getOnSecondary0d7_KjU, m3733getSecondaryContainer0d7_KjU, m3716getOnSecondaryContainer0d7_KjU, m3746getTertiary0d7_KjU, m3721getOnTertiary0d7_KjU, m3747getTertiaryContainer0d7_KjU, m3722getOnTertiaryContainer0d7_KjU, m3702getBackground0d7_KjU, m3708getOnBackground0d7_KjU, m3736getSurface0d7_KjU, m3719getOnSurface0d7_KjU, m3745getSurfaceVariant0d7_KjU, m3720getOnSurfaceVariant0d7_KjU, j31, m3707getInverseSurface0d7_KjU, m3705getInverseOnSurface0d7_KjU, m3703getError0d7_KjU, m3709getOnError0d7_KjU, m3704getErrorContainer0d7_KjU, m3710getOnErrorContainer0d7_KjU, m3725getOutline0d7_KjU, m3726getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 65535, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default */
    public static /* synthetic */ ColorScheme m2349darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long m3679getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3679getPrimary0d7_KjU() : j;
        long m3663getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3663getOnPrimary0d7_KjU() : j2;
        long m3680getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3680getPrimaryContainer0d7_KjU() : j3;
        long m3664getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3664getOnPrimaryContainer0d7_KjU() : j4;
        long m3658getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3658getInversePrimary0d7_KjU() : j5;
        long m3684getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3684getSecondary0d7_KjU() : j6;
        long m3667getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3667getOnSecondary0d7_KjU() : j7;
        long m3685getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3685getSecondaryContainer0d7_KjU() : j8;
        long j37 = m3679getPrimary0d7_KjU;
        long m3668getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3668getOnSecondaryContainer0d7_KjU() : j9;
        long m3698getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3698getTertiary0d7_KjU() : j10;
        long m3673getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3673getOnTertiary0d7_KjU() : j11;
        long m3699getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3699getTertiaryContainer0d7_KjU() : j12;
        long m3674getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3674getOnTertiaryContainer0d7_KjU() : j13;
        long m3654getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3654getBackground0d7_KjU() : j14;
        long m3660getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3660getOnBackground0d7_KjU() : j15;
        long m3688getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3688getSurface0d7_KjU() : j16;
        long m3671getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3671getOnSurface0d7_KjU() : j17;
        long m3697getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3697getSurfaceVariant0d7_KjU() : j18;
        long m3672getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3672getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long m3659getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3659getInverseSurface0d7_KjU() : j21;
        long m3657getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3657getInverseOnSurface0d7_KjU() : j22;
        long m3655getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3655getError0d7_KjU() : j23;
        long m3661getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3661getOnError0d7_KjU() : j24;
        long m3656getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3656getErrorContainer0d7_KjU() : j25;
        long m3662getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorDarkTokens.INSTANCE.m3662getOnErrorContainer0d7_KjU() : j26;
        long m3677getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3677getOutline0d7_KjU() : j27;
        long m3678getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m3678getOutlineVariant0d7_KjU() : j28;
        long m3683getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3683getScrim0d7_KjU() : j29;
        long m3689getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m3689getSurfaceBright0d7_KjU() : j30;
        long m3690getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3690getSurfaceContainer0d7_KjU() : j31;
        long m3691getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3691getSurfaceContainerHigh0d7_KjU() : j32;
        long m3692getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3692getSurfaceContainerHighest0d7_KjU() : j33;
        long m3693getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3693getSurfaceContainerLow0d7_KjU() : j34;
        long m3694getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3694getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m3695getSurfaceDim0d7_KjU();
        }
        return m2353darkColorScheme_VG5OTI$default(j37, m3663getOnPrimary0d7_KjU, m3680getPrimaryContainer0d7_KjU, m3664getOnPrimaryContainer0d7_KjU, m3658getInversePrimary0d7_KjU, m3684getSecondary0d7_KjU, m3667getOnSecondary0d7_KjU, m3685getSecondaryContainer0d7_KjU, m3668getOnSecondaryContainer0d7_KjU, m3698getTertiary0d7_KjU, m3673getOnTertiary0d7_KjU, m3699getTertiaryContainer0d7_KjU, m3674getOnTertiaryContainer0d7_KjU, m3654getBackground0d7_KjU, m3660getOnBackground0d7_KjU, m3688getSurface0d7_KjU, m3671getOnSurface0d7_KjU, m3697getSurfaceVariant0d7_KjU, m3672getOnSurfaceVariant0d7_KjU, j38, m3659getInverseSurface0d7_KjU, m3657getInverseOnSurface0d7_KjU, m3655getError0d7_KjU, m3661getOnError0d7_KjU, m3656getErrorContainer0d7_KjU, m3662getOnErrorContainer0d7_KjU, m3677getOutline0d7_KjU, m3678getOutlineVariant0d7_KjU, m3683getScrim0d7_KjU, m3689getSurfaceBright0d7_KjU, m3690getSurfaceContainer0d7_KjU, m3691getSurfaceContainerHigh0d7_KjU, m3692getSurfaceContainerHighest0d7_KjU, m3693getSurfaceContainerLow0d7_KjU, m3694getSurfaceContainerLowest0d7_KjU, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default */
    public static /* synthetic */ ColorScheme m2351darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m3679getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m3679getPrimary0d7_KjU() : j;
        long m3663getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m3663getOnPrimary0d7_KjU() : j2;
        long m3680getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m3680getPrimaryContainer0d7_KjU() : j3;
        long m3664getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m3664getOnPrimaryContainer0d7_KjU() : j4;
        long m3658getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m3658getInversePrimary0d7_KjU() : j5;
        long m3684getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m3684getSecondary0d7_KjU() : j6;
        long m3667getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m3667getOnSecondary0d7_KjU() : j7;
        long m3685getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m3685getSecondaryContainer0d7_KjU() : j8;
        long j30 = m3679getPrimary0d7_KjU;
        long m3668getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m3668getOnSecondaryContainer0d7_KjU() : j9;
        long m3698getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m3698getTertiary0d7_KjU() : j10;
        long m3673getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3673getOnTertiary0d7_KjU() : j11;
        long m3699getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3699getTertiaryContainer0d7_KjU() : j12;
        long m3674getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3674getOnTertiaryContainer0d7_KjU() : j13;
        long m3654getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3654getBackground0d7_KjU() : j14;
        long m3660getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3660getOnBackground0d7_KjU() : j15;
        long m3688getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3688getSurface0d7_KjU() : j16;
        long m3671getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3671getOnSurface0d7_KjU() : j17;
        long m3697getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3697getSurfaceVariant0d7_KjU() : j18;
        long m3672getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3672getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long m3659getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3659getInverseSurface0d7_KjU() : j21;
        long m3657getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3657getInverseOnSurface0d7_KjU() : j22;
        long m3655getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3655getError0d7_KjU() : j23;
        long m3661getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3661getOnError0d7_KjU() : j24;
        long m3656getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3656getErrorContainer0d7_KjU() : j25;
        long m3662getOnErrorContainer0d7_KjU = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorDarkTokens.INSTANCE.m3662getOnErrorContainer0d7_KjU() : j26;
        long m3677getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m3677getOutline0d7_KjU() : j27;
        long m3678getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m3678getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m3683getScrim0d7_KjU();
        }
        return m2353darkColorScheme_VG5OTI$default(j30, m3663getOnPrimary0d7_KjU, m3680getPrimaryContainer0d7_KjU, m3664getOnPrimaryContainer0d7_KjU, m3658getInversePrimary0d7_KjU, m3684getSecondary0d7_KjU, m3667getOnSecondary0d7_KjU, m3685getSecondaryContainer0d7_KjU, m3668getOnSecondaryContainer0d7_KjU, m3698getTertiary0d7_KjU, m3673getOnTertiary0d7_KjU, m3699getTertiaryContainer0d7_KjU, m3674getOnTertiaryContainer0d7_KjU, m3654getBackground0d7_KjU, m3660getOnBackground0d7_KjU, m3688getSurface0d7_KjU, m3671getOnSurface0d7_KjU, m3697getSurfaceVariant0d7_KjU, m3672getOnSurfaceVariant0d7_KjU, j31, m3659getInverseSurface0d7_KjU, m3657getInverseOnSurface0d7_KjU, m3655getError0d7_KjU, m3661getOnError0d7_KjU, m3656getErrorContainer0d7_KjU, m3662getOnErrorContainer0d7_KjU, m3677getOutline0d7_KjU, m3678getOutlineVariant0d7_KjU, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 65535, null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m2297getBackground0d7_KjU();
            case 2:
                return colorScheme.m2298getError0d7_KjU();
            case 3:
                return colorScheme.m2299getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m2300getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m2301getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m2302getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m2303getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m2304getOnError0d7_KjU();
            case 9:
                return colorScheme.m2305getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m2306getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m2307getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m2310getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m2311getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m2314getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m2315getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m2339getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m2316getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m2317getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m2320getOutline0d7_KjU();
            case 20:
                return colorScheme.m2321getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m2322getPrimary0d7_KjU();
            case 22:
                return colorScheme.m2323getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m2326getScrim0d7_KjU();
            case 24:
                return colorScheme.m2327getSecondary0d7_KjU();
            case 25:
                return colorScheme.m2328getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m2331getSurface0d7_KjU();
            case 27:
                return colorScheme.m2340getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m2332getSurfaceBright0d7_KjU();
            case 29:
                return colorScheme.m2333getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m2334getSurfaceContainerHigh0d7_KjU();
            case 31:
                return colorScheme.m2335getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m2336getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m2337getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m2338getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m2341getTertiary0d7_KjU();
            case 36:
                return colorScheme.m2342getTertiaryContainer0d7_KjU();
            case 37:
                return colorScheme.m2324getPrimaryFixed0d7_KjU();
            case 38:
                return colorScheme.m2325getPrimaryFixedDim0d7_KjU();
            case 39:
                return colorScheme.m2308getOnPrimaryFixed0d7_KjU();
            case 40:
                return colorScheme.m2309getOnPrimaryFixedVariant0d7_KjU();
            case 41:
                return colorScheme.m2329getSecondaryFixed0d7_KjU();
            case 42:
                return colorScheme.m2330getSecondaryFixedDim0d7_KjU();
            case 43:
                return colorScheme.m2312getOnSecondaryFixed0d7_KjU();
            case 44:
                return colorScheme.m2313getOnSecondaryFixedVariant0d7_KjU();
            case 45:
                return colorScheme.m2343getTertiaryFixed0d7_KjU();
            case 46:
                return colorScheme.m2344getTertiaryFixedDim0d7_KjU();
            case 47:
                return colorScheme.m2318getOnTertiaryFixed0d7_KjU();
            case 48:
                return colorScheme.m2319getOnTertiaryFixedVariant0d7_KjU();
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
    public static final long m2345applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)1540@70581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalTonalElevationEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (Color.m5349equalsimpl0(j, colorScheme.m2331getSurface0d7_KjU()) && booleanValue) {
            j = m2360surfaceColorAtElevation3ABfNKs(colorScheme, f);
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
    public static final long m2360surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m8165equalsimpl0(f, Dp.m8160constructorimpl(0.0f))) {
            return colorScheme.m2331getSurface0d7_KjU();
        }
        return ColorKt.m5393compositeOverOWjLjI(Color.m5347copywmQWz5c$default(colorScheme.m2339getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m2331getSurface0d7_KjU());
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010+J3\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010,J\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u009d\u0001\u0010<\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00109\u001a\u000205H\u0001¢\u0006\u0004\b=\u0010>J\u009d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0003¢\u0006\u0004\bB\u0010CJ3\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010FJ\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u0010GJ\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010HJ\u008d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0003¢\u0006\u0004\bI\u0010JJï\u0001\u0010K\u001a\u00020\u0019*\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020O2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00109\u001a\u0002052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u0010U\u001a\u00020\u001f2\b\b\u0002\u0010@\u001a\u00020\u001f2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010A\u001a\u00020\u001fH\u0002¢\u0006\u0004\bX\u0010YJC\u0010Z\u001a\u00020\u0019*\u00020/2\u0006\u0010V\u001a\u00020W2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020OH\u0002¢\u0006\u0004\ba\u0010bJ)\u0010-\u001a\u00020\u0019*\u00020/2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u0002052\u0006\u0010^\u001a\u00020\b¢\u0006\u0004\bc\u0010dR\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010e\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010gR\u0013\u0010i\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010gR\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A$material3", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4$material3", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0$material3", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", TypedValues.CycleType.S_WAVE_OFFSET, "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m3730getStopIndicatorSizeD9Ej5fM();
    private static final float TickSize = SliderTokens.INSTANCE.m3730getStopIndicatorSizeD9Ej5fM();
    private static final Path trackPath = AndroidPath_androidKt.Path();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$25(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2516CenteredTrack7LSsfP0$material3(sliderState, modifier, z, sliderColors, function2, function3, f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Thumb_9LiSoMs$lambda$3(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2517Thumb9LiSoMs(mutableInteractionSource, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Thumb_HwbPF3A$lambda$6(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2518ThumbHwbPF3A$material3(mutableInteractionSource, sliderState, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track$lambda$12(SliderDefaults sliderDefaults, SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderPositions, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track$lambda$13(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track$lambda$33(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(rangeSliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_VvwgllI$lambda$32(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2511TrackImplVvwgllI(sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_xlyIBlM$lambda$47(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, Composer composer, int i2) {
        sliderDefaults.m2512TrackImplxlyIBlM(rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_4EFweAY$lambda$17(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2520Track4EFweAY(sliderState, modifier, z, sliderColors, function2, function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_4EFweAY$lambda$37(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2519Track4EFweAY(rangeSliderState, modifier, z, sliderColors, function2, function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_mnvyFg4$lambda$21(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2522TrackmnvyFg4$material3(sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_mnvyFg4$lambda$41(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m2521TrackmnvyFg4$material3(rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1376295968, "C(colors)1107@48675L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1107)");
        }
        SliderColors defaultSliderColors$material3 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors$material3;
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m2523colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        long j11;
        ComposerKt.sourceInformationMarkerStart(composer, 885588574, "C(colors)N(thumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)1149@50999L11:Slider.kt#uh7d8r");
        long m4808getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j;
        long m4808getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j2;
        long m4808getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j3;
        long m4808getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j4;
        long m4808getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j5;
        long m4808getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j6;
        long m4808getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j7;
        long m4808getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j8;
        long m4808getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j9;
        long m4808getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            j11 = m4808getUnspecified0d7_KjU;
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1149)");
        } else {
            j11 = m4808getUnspecified0d7_KjU;
        }
        SliderColors m2497copyK518z4 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2497copyK518z4(j11, m4808getUnspecified0d7_KjU2, m4808getUnspecified0d7_KjU3, m4808getUnspecified0d7_KjU4, m4808getUnspecified0d7_KjU5, m4808getUnspecified0d7_KjU6, m4808getUnspecified0d7_KjU7, m4808getUnspecified0d7_KjU8, m4808getUnspecified0d7_KjU9, m4808getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2497copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached$material3 = colorScheme.getDefaultSliderColorsCached$material3();
        if (defaultSliderColorsCached$material3 == null) {
            SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.m4817compositeOverOWjLjI(Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m1886getSurface0d7_KjU()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
            colorScheme.setDefaultSliderColorsCached$material3(sliderColors);
            return sliderColors;
        }
        return defaultSliderColorsCached$material3;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0135  */
    /* renamed from: Thumb-9LiSoMs  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2517Thumb9LiSoMs(final MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        long j2;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        long j4;
        long j5;
        Object rememberedValue;
        boolean z3;
        SliderDefaults$Thumb$1$1 rememberedValue2;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(startRestartGroup, "C(Thumb)N(interactionSource,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1213@54450L46,1214@54539L658,1214@54505L692,1237@55596L5,1233@55392L220:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= startRestartGroup.changed(this) ? 131072 : 65536;
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1209@54333L8");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                companion = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                sliderColors2 = colors(startRestartGroup, (i3 >> 15) & 14);
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i5 != 0) {
                                j4 = SliderKt.ThumbSize;
                                j5 = j4;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1212)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 216292781, "CC(remember):Slider.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt.mutableStateListOf();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 216296241, "CC(remember):Slider.kt#9igjgp");
                                int i8 = i3 & 14;
                                z3 = i8 == 4;
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2) rememberedValue2, startRestartGroup, i8);
                                SpacerKt.Spacer(BackgroundKt.m263backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m865size6HolHcs(companion, snapshotStateList.isEmpty() ? DpSize.m7646copyDwJknco$default(j5, Dp.m7555constructorimpl(DpSize.m7653getWidthD9Ej5fM(j5) / 2.0f), 0.0f, 2, null) : j5), mutableInteractionSource, false, 2, null), sliderColors2.m2508thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6)), startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j3 = j5;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                        }
                        j5 = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 216292781, "CC(remember):Slider.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                        }
                        SnapshotStateList snapshotStateList2 = (SnapshotStateList) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 216296241, "CC(remember):Slider.kt#9igjgp");
                        int i82 = i3 & 14;
                        if (i82 == 4) {
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z3) {
                        }
                        rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2) rememberedValue2, startRestartGroup, i82);
                        SpacerKt.Spacer(BackgroundKt.m263backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m865size6HolHcs(companion, snapshotStateList2.isEmpty() ? DpSize.m7646copyDwJknco$default(j5, Dp.m7555constructorimpl(DpSize.m7653getWidthD9Ej5fM(j5) / 2.0f), 0.0f, 2, null) : j5), mutableInteractionSource, false, 2, null), sliderColors2.m2508thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6)), startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j3 = j5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        j3 = j2;
                    }
                    final SliderColors sliderColors3 = sliderColors2;
                    final boolean z4 = z2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Thumb_9LiSoMs$lambda$3(SliderDefaults.this, mutableInteractionSource, modifier2, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                j2 = j;
                if ((i2 & 32) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                }
                final SliderColors sliderColors32 = sliderColors2;
                final boolean z42 = z2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            j2 = j;
            if ((i2 & 32) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
            }
            final SliderColors sliderColors322 = sliderColors2;
            final boolean z422 = z2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        j2 = j;
        if ((i2 & 32) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
        }
        final SliderColors sliderColors3222 = sliderColors2;
        final boolean z4222 = z2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6  */
    /* renamed from: Thumb-HwbPF3A$material3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2518ThumbHwbPF3A$material3(final MutableInteractionSource mutableInteractionSource, final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Object obj;
        Object obj2;
        int i5;
        boolean z2;
        int i6;
        long j2;
        final long j3;
        final Modifier modifier2;
        final SliderColors sliderColors2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColors3;
        long j4;
        long j5;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-889714565);
        ComposerKt.sourceInformation(startRestartGroup, "C(Thumb)N(interactionSource,sliderState,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1266@56862L46,1267@56951L658,1267@56917L692,1294@58180L5,1290@57976L220:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(sliderState) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = modifier;
                i3 |= startRestartGroup.changed(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj2 = sliderColors;
                        if (startRestartGroup.changed(obj2)) {
                            i7 = 2048;
                            i3 |= i7;
                        }
                    } else {
                        obj2 = sliderColors;
                    }
                    i7 = 1024;
                    i3 |= i7;
                } else {
                    obj2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        j2 = j;
                    } else {
                        j2 = j;
                        if ((196608 & i) == 0) {
                            i3 |= startRestartGroup.changed(j2) ? 131072 : 65536;
                        }
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(this) ? 1048576 : 524288;
                    }
                    if (!startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1262@56745L8");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            j4 = j2;
                            companion = obj;
                            sliderColors3 = obj2;
                        } else {
                            companion = i4 != 0 ? Modifier.Companion : obj;
                            if ((i2 & 8) != 0) {
                                sliderColors3 = colors(startRestartGroup, (i3 >> 18) & 14);
                                i3 &= -7169;
                            } else {
                                sliderColors3 = obj2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                j2 = SliderKt.ThumbSize;
                            }
                            j4 = j2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1265)");
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -317193687, "CC(remember):Slider.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateListOf();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -317190227, "CC(remember):Slider.kt#9igjgp");
                        int i8 = i3 & 14;
                        boolean z3 = i8 == 4;
                        SliderDefaults$Thumb$3$1 rememberedValue2 = startRestartGroup.rememberedValue();
                        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new SliderDefaults$Thumb$3$1(mutableInteractionSource, snapshotStateList, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2) rememberedValue2, startRestartGroup, i8);
                        if (snapshotStateList.isEmpty()) {
                            j5 = j4;
                        } else if (sliderState.getOrientation$material3() == Orientation.Vertical) {
                            j5 = DpSize.m7646copyDwJknco$default(j4, 0.0f, Dp.m7555constructorimpl(DpSize.m7651getHeightD9Ej5fM(j4) / 2.0f), 1, null);
                        } else {
                            j5 = DpSize.m7646copyDwJknco$default(j4, Dp.m7555constructorimpl(DpSize.m7653getWidthD9Ej5fM(j4) / 2.0f), 0.0f, 2, null);
                        }
                        SpacerKt.Spacer(BackgroundKt.m263backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m865size6HolHcs(companion, j5), mutableInteractionSource, false, 2, null), sliderColors3.m2508thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6)), startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        sliderColors2 = sliderColors3;
                        j3 = j4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        j3 = j2;
                        modifier2 = obj;
                        sliderColors2 = obj2;
                    }
                    final boolean z4 = z2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return SliderDefaults.Thumb_HwbPF3A$lambda$6(SliderDefaults.this, mutableInteractionSource, sliderState, modifier2, sliderColors2, z4, j3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                z2 = z;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (!startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                final boolean z42 = z2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = modifier;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z2 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (!startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            final boolean z422 = z2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = modifier;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z2 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (!startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        final boolean z4222 = z2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b  */
    @Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        final SliderPositions sliderPositions2;
        int i3;
        Object obj;
        Object obj2;
        int i4;
        boolean z2;
        final Modifier modifier2;
        final SliderColors sliderColors2;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        int i5;
        SliderColors sliderColors3;
        boolean z4;
        boolean changed;
        Object rememberedValue;
        boolean z5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(sliderPositions,modifier,colors,enabled)1323@59516L1838,1323@59464L1890:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderPositions2 = sliderPositions;
        } else {
            sliderPositions2 = sliderPositions;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(sliderPositions2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = sliderColors;
                    if (startRestartGroup.changed(obj2)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    obj2 = sliderColors;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                obj2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1316@59111L8");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors4 = obj2;
                        i5 = i3;
                        sliderColors3 = sliderColors4;
                        companion = obj;
                    } else {
                        companion = i8 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            obj2 = colors(startRestartGroup, (i3 >> 12) & 14);
                        }
                        SliderColors sliderColors5 = obj2;
                        i5 = i3;
                        sliderColors3 = sliderColors5;
                        if (i4 != 0) {
                            z4 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1546713545, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1318)");
                            }
                            int i9 = i5;
                            final long m2510trackColorWaAFU9c$material3 = sliderColors3.m2510trackColorWaAFU9c$material3(z4, false);
                            final long m2510trackColorWaAFU9c$material32 = sliderColors3.m2510trackColorWaAFU9c$material3(z4, true);
                            final long m2509tickColorWaAFU9c$material3 = sliderColors3.m2509tickColorWaAFU9c$material3(z4, false);
                            final long m2509tickColorWaAFU9c$material32 = sliderColors3.m2509tickColorWaAFU9c$material3(z4, true);
                            SliderColors sliderColors6 = sliderColors3;
                            modifier2 = companion;
                            Modifier m850height3ABfNKs = SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), SliderKt.getTrackHeight());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -333010299, "CC(remember):Slider.kt#9igjgp");
                            changed = startRestartGroup.changed(m2510trackColorWaAFU9c$material3) | ((i9 & 14) != 4) | startRestartGroup.changed(m2510trackColorWaAFU9c$material32) | startRestartGroup.changed(m2509tickColorWaAFU9c$material3) | startRestartGroup.changed(m2509tickColorWaAFU9c$material32);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                z5 = z4;
                                i6 = 0;
                                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SliderDefaults.Track$lambda$11$lambda$10(m2510trackColorWaAFU9c$material3, sliderPositions2, m2510trackColorWaAFU9c$material32, m2509tickColorWaAFU9c$material3, m2509tickColorWaAFU9c$material32, (DrawScope) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function1);
                                rememberedValue = function1;
                            } else {
                                z5 = z4;
                                i6 = 0;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            CanvasKt.Canvas(m850height3ABfNKs, (Function1) rememberedValue, startRestartGroup, i6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors2 = sliderColors6;
                            z3 = z5;
                        }
                    }
                    z4 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i92 = i5;
                    final long m2510trackColorWaAFU9c$material33 = sliderColors3.m2510trackColorWaAFU9c$material3(z4, false);
                    final long m2510trackColorWaAFU9c$material322 = sliderColors3.m2510trackColorWaAFU9c$material3(z4, true);
                    final long m2509tickColorWaAFU9c$material33 = sliderColors3.m2509tickColorWaAFU9c$material3(z4, false);
                    final long m2509tickColorWaAFU9c$material322 = sliderColors3.m2509tickColorWaAFU9c$material3(z4, true);
                    SliderColors sliderColors62 = sliderColors3;
                    modifier2 = companion;
                    Modifier m850height3ABfNKs2 = SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), SliderKt.getTrackHeight());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -333010299, "CC(remember):Slider.kt#9igjgp");
                    changed = startRestartGroup.changed(m2510trackColorWaAFU9c$material33) | ((i92 & 14) != 4) | startRestartGroup.changed(m2510trackColorWaAFU9c$material322) | startRestartGroup.changed(m2509tickColorWaAFU9c$material33) | startRestartGroup.changed(m2509tickColorWaAFU9c$material322);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    z5 = z4;
                    i6 = 0;
                    Function1 function12 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SliderDefaults.Track$lambda$11$lambda$10(m2510trackColorWaAFU9c$material33, sliderPositions2, m2510trackColorWaAFU9c$material322, m2509tickColorWaAFU9c$material33, m2509tickColorWaAFU9c$material322, (DrawScope) obj3);
                        }
                    };
                    startRestartGroup.updateRememberedValue(function12);
                    rememberedValue = function12;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    CanvasKt.Canvas(m850height3ABfNKs2, (Function1) rememberedValue, startRestartGroup, i6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors2 = sliderColors62;
                    z3 = z5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    sliderColors2 = obj2;
                    z3 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SliderDefaults.Track$lambda$12(SliderDefaults.this, sliderPositions, modifier2, sliderColors2, z3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track$lambda$11$lambda$10(long j, SliderPositions sliderPositions, long j2, long j3, long j4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32));
        long m4519constructorimpl2 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
        long j5 = m4519constructorimpl;
        long j6 = z ? m4519constructorimpl2 : j5;
        if (!z) {
            j5 = m4519constructorimpl2;
        }
        float f = drawScope.mo405toPx0680j_4(TickSize);
        float f2 = drawScope.mo405toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m5332drawLineNGM6Ib0$default(drawScope, j, j6, j5, f2, StrokeCap.Companion.m5147getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        int i = (int) (j6 >> 32);
        int i2 = (int) (j5 >> 32);
        long j7 = j6;
        long j8 = j5;
        DrawScope.m5332drawLineNGM6Ib0$default(drawScope, j2, Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getStart().floatValue())) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L)), Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getEndInclusive().floatValue())) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L)), f2, StrokeCap.Companion.m5147getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float[] tickFractions = sliderPositions.getTickFractions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f3 = tickFractions[i3];
            Boolean valueOf = Boolean.valueOf(f3 > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f3 < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f3));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                float intBitsToFloat2 = Float.intBitsToFloat((int) (OffsetKt.m4550lerpWko1d7g(j7, j8, ((Number) list.get(i4)).floatValue()) >> 32));
                arrayList.add(Offset.m4516boximpl(Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat2) << 32))));
                i4++;
                booleanValue = booleanValue;
                list = list;
            }
            long j9 = j7;
            j8 = j8;
            DrawScope.m5337drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.Companion.m5092getPointsr_lszbg(), booleanValue ? j3 : j4, f, StrokeCap.Companion.m5147getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            j7 = j9;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void Track(final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        int i4;
        boolean z2;
        final Modifier modifier2;
        final SliderColors sliderColors2;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColors3;
        int i5;
        boolean z4;
        float f;
        float f2;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(593554206);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(sliderState,modifier,colors,enabled)1401@62715L214:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = sliderColors;
                    if (startRestartGroup.changed(obj2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    obj2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                obj2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1398@62656L8");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = obj;
                        sliderColors3 = obj2;
                        i5 = i3;
                    } else {
                        companion = i7 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 4) != 0) {
                            sliderColors3 = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                        } else {
                            sliderColors3 = obj2;
                        }
                        i5 = i3;
                        if (i4 != 0) {
                            z4 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(593554206, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1400)");
                            }
                            f = SliderKt.ThumbTrackGapSize;
                            f2 = SliderKt.TrackInsideCornerSize;
                            Modifier modifier3 = companion;
                            sliderColors2 = sliderColors3;
                            m2520Track4EFweAY(sliderState, modifier3, z4, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, f, f2, startRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z4;
                            modifier2 = modifier3;
                        }
                    }
                    z4 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f = SliderKt.ThumbTrackGapSize;
                    f2 = SliderKt.TrackInsideCornerSize;
                    Modifier modifier32 = companion;
                    sliderColors2 = sliderColors3;
                    m2520Track4EFweAY(sliderState, modifier32, z4, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, f, f2, startRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z4;
                    modifier2 = modifier32;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    sliderColors2 = obj2;
                    z3 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SliderDefaults.Track$lambda$13(SliderDefaults.this, sliderState, modifier2, sliderColors2, z3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_4EFweAY$lambda$15$lambda$14(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m2524drawStopIndicatorx3O1jOs(drawScope, offset.m4537unboximpl(), TrackStopIndicatorSize, m2510trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: Track-4EFweAY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2520Track4EFweAY(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Object obj;
        int i5;
        int i6;
        final float f3;
        int i7;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function22;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        float f5;
        int i8;
        float f6;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(49984771);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1447@64678L467:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i10 = 2048;
                            i3 |= i10;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i10 = 1024;
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj = function2;
                        if (startRestartGroup.changedInstance(obj)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        obj = function2;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    obj = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                }
                if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1433@64119L8,1434@64188L199,1441@64443L107");
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            companion = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            sliderColors2 = colors(startRestartGroup, (i3 >> 24) & 14);
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 790733290, "CC(remember):Slider.kt#9igjgp");
                            boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && startRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return SliderDefaults.Track_4EFweAY$lambda$15$lambda$14(SliderColors.this, z2, (DrawScope) obj2, (Offset) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            obj = (Function2) rememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 790741358, "CC(remember):Slider.kt#9igjgp");
                            SliderDefaults$Track$5$1 rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m2530invokewPWG1Vc(drawScope, offset.m4537unboximpl(), color.m4782unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
                                    public final void m2530invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m2524drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2525getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            function33 = (Function3) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        } else {
                            function33 = function3;
                        }
                        if (i6 != 0) {
                            f6 = SliderKt.ThumbTrackGapSize;
                            f3 = f6;
                        }
                        if (i7 != 0) {
                            f5 = SliderKt.TrackInsideCornerSize;
                            function32 = function33;
                            i8 = i3;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f4 = f5;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(49984771, i8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1446)");
                            }
                            int i12 = i8 << 3;
                            modifier2 = companion;
                            function22 = obj;
                            m2511TrackImplVvwgllI(sliderState, Dp.Companion.m7575getUnspecifiedD9Ej5fM(), modifier2, z3, sliderColors3, function22, function32, f3, f4, false, false, startRestartGroup, (i8 & 14) | 805306416 | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), ((i8 >> 21) & 112) | 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            function32 = function33;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        function32 = function3;
                    }
                    i8 = i3;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i8 << 3;
                    modifier2 = companion;
                    function22 = obj;
                    m2511TrackImplVvwgllI(sliderState, Dp.Companion.m7575getUnspecifiedD9Ej5fM(), modifier2, z3, sliderColors3, function22, function32, f3, f4, false, false, startRestartGroup, (i8 & 14) | 805306416 | (i122 & 896) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), ((i8 >> 21) & 112) | 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function32 = function3;
                    modifier2 = companion;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    function22 = obj;
                    f4 = f2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return SliderDefaults.Track_4EFweAY$lambda$17(SliderDefaults.this, sliderState, modifier2, z3, sliderColors3, function22, function32, f3, f4, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_mnvyFg4$lambda$19$lambda$18(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m2524drawStopIndicatorx3O1jOs(drawScope, offset.m4537unboximpl(), TrackStopIndicatorSize, m2510trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* renamed from: Track-mnvyFg4$material3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2522TrackmnvyFg4$material3(final SliderState sliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        int i4;
        Modifier.Companion companion;
        int i5;
        final boolean z2;
        final SliderColors sliderColors2;
        Object obj2;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function22;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        float f7;
        float f8;
        float f9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1691224881);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1503@67150L467:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            obj = sliderState;
        } else if ((i & 6) == 0) {
            obj = sliderState;
            i3 = (startRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            obj = sliderState;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i11 = 16384;
                                i3 |= i11;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i11 = 8192;
                        i3 |= i11;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj2 = function2;
                            if (startRestartGroup.changedInstance(obj2)) {
                                i10 = 131072;
                                i3 |= i10;
                            }
                        } else {
                            obj2 = function2;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        obj2 = function2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        f4 = f2;
                    } else {
                        f4 = f2;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changed(this) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1489@66591L8,1490@66660L199,1497@66915L107");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    sliderColors2 = colors(startRestartGroup, (i3 >> 27) & 14);
                                }
                                if ((i2 & 32) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1769483032, "CC(remember):Slider.kt#9igjgp");
                                    boolean z4 = ((((57344 & i3) ^ 24576) > 16384 && startRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj3, Object obj4) {
                                                return SliderDefaults.Track_mnvyFg4$lambda$19$lambda$18(SliderColors.this, z2, (DrawScope) obj3, (Offset) obj4);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj2 = (Function2) rememberedValue;
                                    i3 = (-458753) & i3;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1769491100, "CC(remember):Slider.kt#9igjgp");
                                    SliderDefaults$Track$8$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$8$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                                m2531invokewPWG1Vc(drawScope, offset.m4537unboximpl(), color.m4782unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
                                            public final void m2531invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                                SliderDefaults.INSTANCE.m2524drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2525getTickSizeD9Ej5fM(), j2);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    function33 = (Function3) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                } else {
                                    function33 = function3;
                                }
                                if (i7 != 0) {
                                    f9 = SliderKt.ThumbTrackGapSize;
                                    f4 = f9;
                                }
                                if (i9 != 0) {
                                    f7 = SliderKt.TrackInsideCornerSize;
                                    f8 = f7;
                                    int i12 = i3;
                                    boolean z5 = z2;
                                    SliderColors sliderColors4 = sliderColors2;
                                    float f10 = f4;
                                    Function2<? super DrawScope, ? super Offset, Unit> function23 = obj2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1502)");
                                    }
                                    int i13 = ((i12 >> 24) & 112) | 6;
                                    Modifier modifier3 = companion;
                                    Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function34 = function33;
                                    m2511TrackImplVvwgllI(obj, f, modifier3, z5, sliderColors4, function23, function34, f10, f8, true, false, startRestartGroup, (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12), i13);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f6 = f8;
                                    f5 = f10;
                                    function32 = function34;
                                    function22 = function23;
                                    sliderColors3 = sliderColors4;
                                    z3 = z5;
                                    modifier2 = modifier3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function33 = function3;
                            }
                            f8 = f3;
                            int i122 = i3;
                            boolean z52 = z2;
                            SliderColors sliderColors42 = sliderColors2;
                            float f102 = f4;
                            Function2<? super DrawScope, ? super Offset, Unit> function232 = obj2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = ((i122 >> 24) & 112) | 6;
                            Modifier modifier32 = companion;
                            Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function342 = function33;
                            m2511TrackImplVvwgllI(obj, f, modifier32, z52, sliderColors42, function232, function342, f102, f8, true, false, startRestartGroup, (i122 & 14) | 805306368 | (i122 & 112) | (i122 & 896) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (234881024 & i122), i132);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f6 = f8;
                            f5 = f102;
                            function32 = function342;
                            function22 = function232;
                            sliderColors3 = sliderColors42;
                            z3 = z52;
                            modifier2 = modifier32;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function32 = function3;
                            modifier2 = companion;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f5 = f4;
                            function22 = obj2;
                            f6 = f3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$21(SliderDefaults.this, sliderState, f, modifier2, z3, sliderColors3, function22, function32, f5, f6, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m2524drawStopIndicatorx3O1jOs(drawScope, offset.m4537unboximpl(), TrackStopIndicatorSize, m2510trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* renamed from: CenteredTrack-7LSsfP0$material3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2516CenteredTrack7LSsfP0$material3(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Object obj;
        int i5;
        int i6;
        final float f4;
        int i7;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function22;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        int i10;
        float f7;
        float f8;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1199441071);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenteredTrack)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,trackCornerSize:c#ui.unit.Dp)1558@69596L466:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj = function2;
                        if (startRestartGroup.changedInstance(obj)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj = function2;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f4 = f;
                } else {
                    f4 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i9 = i8;
                    i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changed(this) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    }
                    if (!startRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1543@68991L8,1544@69060L199,1551@69315L107");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                sliderColors2 = colors(startRestartGroup, (i3 >> 27) & 14);
                            }
                            if ((i2 & 16) != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1611643510, "CC(remember):Slider.kt#9igjgp");
                                boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && startRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            return SliderDefaults.CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors.this, z2, (DrawScope) obj2, (Offset) obj3);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                obj = (Function2) rememberedValue;
                                i3 = (-57345) & i3;
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1611651578, "CC(remember):Slider.kt#9igjgp");
                                SliderDefaults$CenteredTrack$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                            m2527invokewPWG1Vc(drawScope, offset.m4537unboximpl(), color.m4782unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
                                        public final void m2527invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                            SliderDefaults.INSTANCE.m2524drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2525getTickSizeD9Ej5fM(), j2);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                function33 = (Function3) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            } else {
                                function33 = function3;
                            }
                            if (i6 != 0) {
                                f8 = SliderKt.ThumbTrackGapSize;
                                f4 = f8;
                            }
                            float f9 = i7 != 0 ? SliderKt.TrackInsideCornerSize : f2;
                            if (i9 != 0) {
                                function32 = function33;
                                i10 = i3;
                                z3 = z2;
                                f5 = f9;
                                f7 = Dp.Companion.m7575getUnspecifiedD9Ej5fM();
                                sliderColors3 = sliderColors2;
                            } else {
                                function32 = function33;
                                i10 = i3;
                                z3 = z2;
                                sliderColors3 = sliderColors2;
                                f5 = f9;
                                f7 = f3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            function32 = function3;
                            f7 = f3;
                            i10 = i3;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f5 = f2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1199441071, i10, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1557)");
                        }
                        int i14 = i10 << 3;
                        modifier2 = companion;
                        function22 = obj;
                        m2511TrackImplVvwgllI(sliderState, f7, modifier2, z3, sliderColors3, function22, function32, f4, f5, true, true, startRestartGroup, (i10 & 14) | 805306368 | ((i10 >> 21) & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024), ((i10 >> 24) & 112) | 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f6 = f7;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function32 = function3;
                        modifier2 = companion;
                        z3 = z2;
                        sliderColors3 = sliderColors2;
                        function22 = obj;
                        f5 = f2;
                        f6 = f3;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$25(SliderDefaults.this, sliderState, modifier2, z3, sliderColors3, function22, function32, f4, f5, f6, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i9 = i8;
                if ((i2 & 512) == 0) {
                }
                if (!startRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i2 & 512) == 0) {
            }
            if (!startRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i2 & 512) == 0) {
        }
        if (!startRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x018e, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L139;
     */
    /* renamed from: TrackImpl-VvwgllI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m2511TrackImplVvwgllI(final SliderState sliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, final boolean z2, final boolean z3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int i5;
        Modifier m850height3ABfNKs;
        long j;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(133396521);
        ComposerKt.sourceInformation(startRestartGroup, "C(TrackImpl)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,enableCornerShrinking,isCentered)1601@71313L957,1622@72299L1481,1592@70900L2880:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(133396521, i3, i4, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1587)");
            }
            final long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, false);
            final long m2510trackColorWaAFU9c$material32 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
            final long m2509tickColorWaAFU9c$material3 = sliderColors.m2509tickColorWaAFU9c$material3(z, false);
            int i6 = i4;
            long m2509tickColorWaAFU9c$material32 = sliderColors.m2509tickColorWaAFU9c$material3(z, true);
            if (sliderState.getOrientation$material3() == Orientation.Vertical) {
                i5 = i3;
                m850height3ABfNKs = SizeKt.fillMaxHeight$default(SizeKt.m869width3ABfNKs(modifier, SliderKt.getTrackHeight()), 0.0f, 1, null);
                if (sliderState.getReverseVerticalDirection$material3()) {
                    m850height3ABfNKs = ScaleKt.scale(m850height3ABfNKs, 1.0f, -1.0f);
                }
            } else {
                i5 = i3;
                m850height3ABfNKs = SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            }
            Modifier.Companion companion = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -654921594, "CC(remember):Slider.kt#9igjgp");
            int i7 = i5 & 112;
            boolean changedInstance = (i7 == 32) | startRestartGroup.changedInstance(sliderState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance) {
                j = m2509tickColorWaAFU9c$material32;
            } else {
                j = m2509tickColorWaAFU9c$material32;
            }
            rememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$29$lambda$28(f, sliderState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier then = m850height3ABfNKs.then(LayoutModifierKt.layout(companion, (Function3) rememberedValue));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -654889518, "CC(remember):Slider.kt#9igjgp");
            final long j2 = j;
            boolean changedInstance2 = (i7 == 32) | startRestartGroup.changedInstance(sliderState) | startRestartGroup.changed(m2510trackColorWaAFU9c$material3) | startRestartGroup.changed(m2510trackColorWaAFU9c$material32) | startRestartGroup.changed(m2509tickColorWaAFU9c$material3) | startRestartGroup.changed(j2) | ((i5 & 29360128) == 8388608) | ((i5 & 234881024) == 67108864) | ((i5 & 458752) == 131072) | ((i5 & 3670016) == 1048576) | ((i5 & 1879048192) == 536870912) | ((i6 & 14) == 4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                modifier2 = then;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_VvwgllI$lambda$31$lambda$30(f, sliderState, m2510trackColorWaAFU9c$material3, m2510trackColorWaAFU9c$material32, m2509tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                    }
                };
                composer2 = startRestartGroup;
                composer2.updateRememberedValue(function1);
                rememberedValue2 = function1;
            } else {
                modifier2 = then;
                composer2 = startRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) rememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$32(SliderDefaults.this, sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult TrackImpl_VvwgllI$lambda$29$lambda$28(float f, SliderState sliderState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int i;
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(constraints.m7514unboximpl());
        if (Dp.m7560equalsimpl0(f, Dp.Companion.m7575getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation$material3() == Orientation.Vertical) {
                i = mo6216measureBRTryo0.getWidth() / 2;
            } else {
                i = mo6216measureBRTryo0.getHeight() / 2;
            }
        } else {
            i = measureScope.mo399roundToPx0680j_4(f);
        }
        return measureScope.layout(mo6216measureBRTryo0.getWidth(), mo6216measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(i))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable.this, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_VvwgllI$lambda$31$lambda$30(float f, SliderState sliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, boolean z, boolean z2, DrawScope drawScope) {
        float f4;
        float intBitsToFloat;
        if (Dp.m7560equalsimpl0(f, Dp.Companion.m7575getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation$material3() == Orientation.Vertical) {
                intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32));
            } else {
                intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L));
            }
            f4 = intBitsToFloat / 2.0f;
        } else {
            f4 = drawScope.mo405toPx0680j_4(f);
        }
        INSTANCE.m2513drawTrackGVD57ws(drawScope, sliderState.getTickFractions$material3(), 0.0f, sliderState.getCoercedValueAsFraction(), j, j2, j3, j4, drawScope.mo402toDpu2uoSUM(0), drawScope.mo402toDpu2uoSUM(0), drawScope.mo402toDpu2uoSUM(sliderState.getThumbWidth$material3()), drawScope.mo402toDpu2uoSUM(sliderState.getThumbHeight$material3()), f2, f3, drawScope.mo401toDpu2uoSUM(f4), function2, function3, false, z, sliderState.getOrientation$material3(), z2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        int i4;
        boolean z2;
        final Modifier modifier2;
        final SliderColors sliderColors2;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColors3;
        int i5;
        boolean z4;
        float f;
        float f2;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(rangeSliderState,modifier,colors,enabled)1689@75190L219:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = sliderColors;
                    if (startRestartGroup.changed(obj2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    obj2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                obj2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1686@75131L8");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = obj;
                        sliderColors3 = obj2;
                        i5 = i3;
                    } else {
                        companion = i7 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 4) != 0) {
                            sliderColors3 = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                        } else {
                            sliderColors3 = obj2;
                        }
                        i5 = i3;
                        if (i4 != 0) {
                            z4 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1617869097, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1688)");
                            }
                            f = SliderKt.ThumbTrackGapSize;
                            f2 = SliderKt.TrackInsideCornerSize;
                            Modifier modifier3 = companion;
                            sliderColors2 = sliderColors3;
                            m2519Track4EFweAY(rangeSliderState, modifier3, z4, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, f, f2, startRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z4;
                            modifier2 = modifier3;
                        }
                    }
                    z4 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f = SliderKt.ThumbTrackGapSize;
                    f2 = SliderKt.TrackInsideCornerSize;
                    Modifier modifier32 = companion;
                    sliderColors2 = sliderColors3;
                    m2519Track4EFweAY(rangeSliderState, modifier32, z4, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, f, f2, startRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z4;
                    modifier2 = modifier32;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    sliderColors2 = obj2;
                    z3 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SliderDefaults.Track$lambda$33(SliderDefaults.this, rangeSliderState, modifier2, sliderColors2, z3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_4EFweAY$lambda$35$lambda$34(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m2524drawStopIndicatorx3O1jOs(drawScope, offset.m4537unboximpl(), TrackStopIndicatorSize, m2510trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: Track-4EFweAY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2519Track4EFweAY(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Object obj;
        int i5;
        int i6;
        float f3;
        int i7;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function22;
        final float f4;
        final float f5;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        int i8;
        float f6;
        float f7;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-541824132);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(rangeSliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1735@77205L402:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i10 = 2048;
                            i3 |= i10;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i10 = 1024;
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj = function2;
                        if (startRestartGroup.changedInstance(obj)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        obj = function2;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    obj = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                }
                if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1721@76646L8,1722@76715L199,1729@76970L107");
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            companion = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            sliderColors2 = colors(startRestartGroup, (i3 >> 24) & 14);
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1001938653, "CC(remember):Slider.kt#9igjgp");
                            boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && startRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return SliderDefaults.Track_4EFweAY$lambda$35$lambda$34(SliderColors.this, z2, (DrawScope) obj2, (Offset) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            obj = (Function2) rememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1001930585, "CC(remember):Slider.kt#9igjgp");
                            SliderDefaults$Track$12$1 rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$12$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m2528invokewPWG1Vc(drawScope, offset.m4537unboximpl(), color.m4782unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
                                    public final void m2528invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m2524drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2525getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            function33 = (Function3) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        } else {
                            function33 = function3;
                        }
                        if (i6 != 0) {
                            f7 = SliderKt.ThumbTrackGapSize;
                            f3 = f7;
                        }
                        if (i7 != 0) {
                            f6 = SliderKt.TrackInsideCornerSize;
                            z3 = z2;
                            function22 = obj;
                            f5 = f3;
                            function32 = function33;
                            i8 = i3;
                            modifier2 = companion;
                            sliderColors3 = sliderColors2;
                            f4 = f6;
                        } else {
                            z3 = z2;
                            function22 = obj;
                            f5 = f3;
                            function32 = function33;
                            i8 = i3;
                            modifier2 = companion;
                            sliderColors3 = sliderColors2;
                            f4 = f2;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i8 = i3;
                        modifier2 = companion;
                        z3 = z2;
                        sliderColors3 = sliderColors2;
                        function22 = obj;
                        f4 = f2;
                        f5 = f3;
                        function32 = function3;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-541824132, i8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1734)");
                    }
                    int i12 = i8 << 3;
                    m2512TrackImplxlyIBlM(rangeSliderState, Dp.Companion.m7575getUnspecifiedD9Ej5fM(), modifier2, z3, sliderColors3, function22, function32, f5, f4, startRestartGroup, (i8 & 14) | 48 | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12) | (i12 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    function22 = obj;
                    f4 = f2;
                    f5 = f3;
                    function32 = function3;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return SliderDefaults.Track_4EFweAY$lambda$37(SliderDefaults.this, rangeSliderState, modifier2, z3, sliderColors3, function22, function32, f5, f4, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Track_mnvyFg4$lambda$39$lambda$38(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m2524drawStopIndicatorx3O1jOs(drawScope, offset.m4537unboximpl(), TrackStopIndicatorSize, m2510trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* renamed from: Track-mnvyFg4$material3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2521TrackmnvyFg4$material3(final RangeSliderState rangeSliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier.Companion companion;
        int i5;
        final boolean z2;
        final SliderColors sliderColors2;
        Object obj;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier2;
        final boolean z3;
        Composer composer2;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function22;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function34;
        float f7;
        int i10;
        Modifier modifier3;
        boolean z4;
        SliderColors sliderColors4;
        float f8;
        Function2<? super DrawScope, ? super Offset, Unit> function23;
        float f9;
        float f10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1952945688);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1786@79501L403:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i12 = 16384;
                                i3 |= i12;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i12 = 8192;
                        i3 |= i12;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj = function2;
                            if (startRestartGroup.changedInstance(obj)) {
                                i11 = 131072;
                                i3 |= i11;
                            }
                        } else {
                            obj = function2;
                        }
                        i11 = 65536;
                        i3 |= i11;
                    } else {
                        obj = function2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        f4 = f2;
                    } else {
                        f4 = f2;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changed(this) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1772@78942L8,1773@79011L199,1780@79266L107");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    sliderColors2 = colors(startRestartGroup, (i3 >> 27) & 14);
                                }
                                if ((i2 & 32) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -119891585, "CC(remember):Slider.kt#9igjgp");
                                    boolean z5 = ((((57344 & i3) ^ 24576) > 16384 && startRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj2, Object obj3) {
                                                return SliderDefaults.Track_mnvyFg4$lambda$39$lambda$38(SliderColors.this, z2, (DrawScope) obj2, (Offset) obj3);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj = (Function2) rememberedValue;
                                    i3 = (-458753) & i3;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -119883517, "CC(remember):Slider.kt#9igjgp");
                                    SliderDefaults$Track$15$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$15$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                                m2529invokewPWG1Vc(drawScope, offset.m4537unboximpl(), color.m4782unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
                                            public final void m2529invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                                SliderDefaults.INSTANCE.m2524drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2525getTickSizeD9Ej5fM(), j2);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    function33 = (Function3) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                } else {
                                    function33 = function3;
                                }
                                if (i7 != 0) {
                                    f10 = SliderKt.ThumbTrackGapSize;
                                    f4 = f10;
                                }
                                if (i9 != 0) {
                                    f7 = SliderKt.TrackInsideCornerSize;
                                    function34 = function33;
                                    i10 = i3;
                                    modifier3 = companion;
                                    z4 = z2;
                                    sliderColors4 = sliderColors2;
                                    f8 = f4;
                                    function23 = obj;
                                    f9 = f7;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1952945688, i10, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1785)");
                                    }
                                    m2512TrackImplxlyIBlM(rangeSliderState, f, modifier3, z4, sliderColors4, function23, function34, f8, f9, startRestartGroup, i10 & 2147483646);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = startRestartGroup;
                                    f6 = f9;
                                    f5 = f8;
                                    function32 = function34;
                                    function22 = function23;
                                    sliderColors3 = sliderColors4;
                                    z3 = z4;
                                    modifier2 = modifier3;
                                } else {
                                    function34 = function33;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function34 = function3;
                            }
                            i10 = i3;
                            modifier3 = companion;
                            z4 = z2;
                            sliderColors4 = sliderColors2;
                            f8 = f4;
                            function23 = obj;
                            f9 = f3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            m2512TrackImplxlyIBlM(rangeSliderState, f, modifier3, z4, sliderColors4, function23, function34, f8, f9, startRestartGroup, i10 & 2147483646);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            f6 = f9;
                            f5 = f8;
                            function32 = function34;
                            function22 = function23;
                            sliderColors3 = sliderColors4;
                            z3 = z4;
                            modifier2 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function32 = function3;
                            modifier2 = companion;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            sliderColors3 = sliderColors2;
                            f5 = f4;
                            function22 = obj;
                            f6 = f3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$41(SliderDefaults.this, rangeSliderState, f, modifier2, z3, sliderColors3, function22, function32, f5, f6, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: TrackImpl-xlyIBlM  reason: not valid java name */
    private final void m2512TrackImplxlyIBlM(final RangeSliderState rangeSliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(-1719396904);
        ComposerKt.sourceInformation(startRestartGroup, "C(TrackImpl)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1817@80714L449,1828@81174L1310,1816@80643L1841:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if (!startRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1719396904, i2, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1811)");
            }
            final long m2510trackColorWaAFU9c$material3 = sliderColors.m2510trackColorWaAFU9c$material3(z, false);
            int i3 = i2;
            final long m2510trackColorWaAFU9c$material32 = sliderColors.m2510trackColorWaAFU9c$material3(z, true);
            final long m2509tickColorWaAFU9c$material3 = sliderColors.m2509tickColorWaAFU9c$material3(z, false);
            final long m2509tickColorWaAFU9c$material32 = sliderColors.m2509tickColorWaAFU9c$material3(z, true);
            Modifier m850height3ABfNKs = SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1222010201, "CC(remember):Slider.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layout = LayoutModifierKt.layout(m850height3ABfNKs, (Function3) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1222025782, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance = ((i3 & 112) == 32) | startRestartGroup.changedInstance(rangeSliderState) | startRestartGroup.changed(m2510trackColorWaAFU9c$material3) | startRestartGroup.changed(m2510trackColorWaAFU9c$material32) | startRestartGroup.changed(m2509tickColorWaAFU9c$material3) | startRestartGroup.changed(m2509tickColorWaAFU9c$material32) | ((i3 & 29360128) == 8388608) | ((i3 & 234881024) == 67108864) | ((i3 & 458752) == 131072) | ((i3 & 3670016) == 1048576);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                modifier2 = layout;
                composer2 = startRestartGroup;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$46$lambda$45(f, rangeSliderState, m2510trackColorWaAFU9c$material3, m2510trackColorWaAFU9c$material32, m2509tickColorWaAFU9c$material3, m2509tickColorWaAFU9c$material32, f2, f3, function2, function3, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(function1);
                rememberedValue2 = function1;
            } else {
                modifier2 = layout;
                composer2 = startRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) rememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_xlyIBlM$lambda$47(SliderDefaults.this, rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult TrackImpl_xlyIBlM$lambda$44$lambda$43(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(constraints.m7514unboximpl());
        return measureScope.layout(mo6216measureBRTryo0.getWidth(), mo6216measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(mo6216measureBRTryo0.getHeight() / 2))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable.this, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackImpl_xlyIBlM$lambda$46$lambda$45(float f, RangeSliderState rangeSliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, DrawScope drawScope) {
        float f4;
        if (!Dp.m7560equalsimpl0(f, Dp.Companion.m7575getUnspecifiedD9Ej5fM())) {
            f4 = drawScope.mo405toPx0680j_4(f);
        } else {
            f4 = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L)) / 2.0f;
        }
        m2514drawTrackGVD57ws$default(INSTANCE, drawScope, rangeSliderState.getTickFractions$material3(), rangeSliderState.getCoercedActiveRangeStartAsFraction$material3(), rangeSliderState.getCoercedActiveRangeEndAsFraction$material3(), j, j2, j3, j4, drawScope.mo401toDpu2uoSUM(rangeSliderState.getStartThumbWidth$material3()), drawScope.mo401toDpu2uoSUM(rangeSliderState.getStartThumbHeight$material3()), drawScope.mo401toDpu2uoSUM(rangeSliderState.getEndThumbWidth$material3()), drawScope.mo401toDpu2uoSUM(rangeSliderState.getEndThumbHeight$material3()), f2, f3, drawScope.mo401toDpu2uoSUM(f4), function2, function3, true, false, null, false, 917504, null);
        return Unit.INSTANCE;
    }

    /* renamed from: drawTrack-GVD57ws$default  reason: not valid java name */
    static /* synthetic */ void m2514drawTrackGVD57ws$default(SliderDefaults sliderDefaults, DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2 function2, Function3 function3, boolean z, boolean z2, Orientation orientation, boolean z3, int i, Object obj) {
        sliderDefaults.m2513drawTrackGVD57ws(drawScope, fArr, f, f2, j, j2, j3, j4, f3, f4, f5, f6, f7, f8, f9, function2, function3, z, (i & 131072) != 0 ? false : z2, (i & 262144) != 0 ? Orientation.Horizontal : orientation, (i & 524288) != 0 ? false : z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x025a, code lost:
        if ((r35.length == 0 ? r29 : false) == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011a, code lost:
        if ((r35.length == 0) == false) goto L213;
     */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ee  */
    /* renamed from: drawTrack-GVD57ws  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m2513drawTrackGVD57ws(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, boolean z, boolean z2, Orientation orientation, boolean z3) {
        float f10;
        float f11;
        boolean z4;
        long m4519constructorimpl;
        long m4587constructorimpl;
        float f12;
        float f13;
        long m4519constructorimpl2;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        int length;
        int i;
        ClosedFloatingPointRange<Float> closedFloatingPointRange;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        long m4519constructorimpl3;
        long m4519constructorimpl4;
        long m4587constructorimpl2;
        float f20;
        long m4519constructorimpl5;
        long m4587constructorimpl3;
        long m4519constructorimpl6;
        float f21;
        float f22;
        float f23;
        boolean z5 = orientation == Orientation.Vertical;
        boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        boolean z7 = z6 && !z5;
        float f24 = drawScope.mo405toPx0680j_4(f9);
        long mo5346getSizeNHjbRc = drawScope.mo5346getSizeNHjbRc();
        float intBitsToFloat = Float.intBitsToFloat((int) (z5 ? mo5346getSizeNHjbRc & 4294967295L : mo5346getSizeNHjbRc >> 32));
        boolean z8 = Intrinsics.areEqual(f, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f, ArraysKt.lastOrNull(fArr));
        float f25 = ((fArr.length == 0) || (Intrinsics.areEqual(f2, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f2, ArraysKt.lastOrNull(fArr)))) ? 0.0f + ((intBitsToFloat - 0.0f) * f2) : (((intBitsToFloat - 0.0f) - (f24 * 2.0f)) * f2) + 0.0f + f24;
        float f26 = ((fArr.length == 0) || z8) ? 0.0f + ((intBitsToFloat - 0.0f) * f) : (((intBitsToFloat - 0.0f) - (f24 * 2.0f)) * f) + 0.0f + f24;
        float f27 = drawScope.mo405toPx0680j_4(f8);
        if (Dp.m7554compareTo0680j_4(f7, Dp.m7555constructorimpl(0.0f)) > 0) {
            if (z5) {
                f21 = (drawScope.mo405toPx0680j_4(f4) / 2.0f) + drawScope.mo405toPx0680j_4(f7);
                f22 = drawScope.mo405toPx0680j_4(f6) / 2.0f;
                f23 = drawScope.mo405toPx0680j_4(f7);
            } else {
                f21 = (drawScope.mo405toPx0680j_4(f3) / 2.0f) + drawScope.mo405toPx0680j_4(f7);
                f22 = drawScope.mo405toPx0680j_4(f5) / 2.0f;
                f23 = drawScope.mo405toPx0680j_4(f7);
            }
            f10 = f21;
            f11 = f22 + f23;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        long mo5345getCenterF1C5BW0 = drawScope.mo5345getCenterF1C5BW0();
        float intBitsToFloat2 = Float.intBitsToFloat((int) (z5 ? mo5345getCenterF1C5BW0 & 4294967295L : mo5345getCenterF1C5BW0 >> 32));
        float f28 = f10 + 0.0f;
        if (z2) {
        }
        f28 += f24;
        float min = z3 ? Math.min(f25, intBitsToFloat2) : f26;
        if ((z3 || z) && min > f28) {
            float f29 = z7 ? f27 : f24;
            float f30 = z7 ? f24 : f27;
            float f31 = min - f10;
            if (z7) {
                z4 = true;
                m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32)) - f31) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
            } else {
                z4 = true;
                m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
            }
            if (z5) {
                m4587constructorimpl = Size.m4587constructorimpl((Float.floatToRawIntBits(f31 - 0.0f) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32))) << 32));
            } else {
                m4587constructorimpl = Size.m4587constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(f31 - 0.0f) << 32));
            }
            f12 = intBitsToFloat2;
            f13 = f25;
            m2515drawTrackPathzXTsYAs(drawScope, orientation, m4519constructorimpl, m4587constructorimpl, j, f29, f30);
            if (z5) {
                m4519constructorimpl2 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() >> 32))) << 32) | (Float.floatToRawIntBits(f24 + 0.0f) & 4294967295L));
            } else if (z6) {
                m4519constructorimpl2 = Offset.m4519constructorimpl((Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32)) - 0.0f) - f24) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
            } else {
                m4519constructorimpl2 = Offset.m4519constructorimpl((Float.floatToRawIntBits(f24 + 0.0f) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
            }
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m4516boximpl(m4519constructorimpl2));
                Unit unit = Unit.INSTANCE;
            }
        } else {
            f12 = intBitsToFloat2;
            f13 = f25;
            z4 = true;
        }
        float f32 = intBitsToFloat - f11;
        if (z2) {
        }
        f32 -= f24;
        float max = z3 ? Math.max(f13, f12) : f13;
        if (max < f32) {
            float f33 = z7 ? f24 : f27;
            float f34 = z7 ? f27 : f24;
            float f35 = intBitsToFloat - (max + f11);
            if (z5) {
                m4519constructorimpl5 = Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f20) & 4294967295L));
            } else if (z6) {
                m4519constructorimpl5 = Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
            } else {
                m4519constructorimpl5 = Offset.m4519constructorimpl((Float.floatToRawIntBits(f20) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
            }
            if (z5) {
                m4587constructorimpl3 = Size.m4587constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32))) << 32) | (Float.floatToRawIntBits(f35) & 4294967295L));
            } else if (z6 && !z) {
                m4587constructorimpl3 = Size.m4587constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32)) - f20) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L))) & 4294967295L));
            } else {
                m4587constructorimpl3 = Size.m4587constructorimpl((Float.floatToRawIntBits(f35) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L))) & 4294967295L));
            }
            m2515drawTrackPathzXTsYAs(drawScope, orientation, m4519constructorimpl5, m4587constructorimpl3, j, f33, f34);
            if (z5) {
                m4519constructorimpl6 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() >> 32))) << 32) | (Float.floatToRawIntBits(intBitsToFloat - f24) & 4294967295L));
            } else if (z6) {
                m4519constructorimpl6 = Offset.m4519constructorimpl((Float.floatToRawIntBits(f24) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
            } else {
                m4519constructorimpl6 = Offset.m4519constructorimpl((Float.floatToRawIntBits(intBitsToFloat - f24) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
            }
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m4516boximpl(m4519constructorimpl6));
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (z3) {
            f14 = min + (min < f12 ? f10 : 0.0f);
        } else {
            f14 = z ? f26 + f10 : 0.0f;
        }
        if (z3) {
            f15 = max - (max > f12 ? f11 : 0.0f);
        } else {
            f15 = f13 - f11;
        }
        float f36 = (z7 || z3 || z) ? f27 : f24;
        float f37 = (!z7 || z3 || z) ? f27 : f24;
        float f38 = (!z7 || z3 || z) ? f15 - f14 : f15;
        if (z2) {
            if (fArr.length == 0 ? z4 : false) {
                f16 = 0.0f;
                if (f38 <= f16) {
                    if (z5) {
                        m4519constructorimpl4 = Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f14) & 4294967295L));
                    } else if (z6) {
                        m4519constructorimpl4 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32)) - f15) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
                    } else {
                        m4519constructorimpl4 = Offset.m4519constructorimpl((Float.floatToRawIntBits(f14) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
                    }
                    long j5 = m4519constructorimpl4;
                    if (z5) {
                        m4587constructorimpl2 = Size.m4587constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32))) << 32) | (Float.floatToRawIntBits(f38) & 4294967295L));
                    } else if (z6 && !z3 && !z) {
                        m4587constructorimpl2 = Size.m4587constructorimpl((Float.floatToRawIntBits(f15) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L))) & 4294967295L));
                    } else {
                        m4587constructorimpl2 = Size.m4587constructorimpl((Float.floatToRawIntBits(f38) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L))) & 4294967295L));
                    }
                    f17 = f13;
                    f18 = f14;
                    f19 = f15;
                    m2515drawTrackPathzXTsYAs(drawScope, orientation, j5, m4587constructorimpl2, j2, f36, f37);
                } else {
                    f17 = f13;
                    f18 = f14;
                    f19 = f15;
                }
                float f39 = 0.0f + f24;
                float f40 = intBitsToFloat - f24;
                ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(f18, f19);
                ClosedFloatingPointRange<Float> rangeTo2 = RangesKt.rangeTo(f12 - f11, f12 + f11);
                ClosedFloatingPointRange<Float> rangeTo3 = RangesKt.rangeTo(f26 - f10, f26 + f10);
                ClosedFloatingPointRange<Float> rangeTo4 = RangesKt.rangeTo(f17 - f11, f17 + f11);
                length = fArr.length;
                int i2 = 0;
                i = 0;
                while (i < length) {
                    float f41 = fArr[i];
                    int i3 = i2 + 1;
                    if (function2 == null || (((!z3 && !z) || i2 != 0) && i2 != fArr.length - 1)) {
                        float lerp = MathHelpersKt.lerp(f39, f40, f41);
                        if ((!z3 || !rangeTo2.contains(Float.valueOf(lerp))) && ((!z || !rangeTo3.contains(Float.valueOf(lerp))) && !rangeTo4.contains(Float.valueOf(lerp)))) {
                            if (z5) {
                                closedFloatingPointRange = rangeTo2;
                                closedFloatingPointRange2 = rangeTo3;
                                m4519constructorimpl3 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() >> 32))) << 32) | (Float.floatToRawIntBits(lerp) & 4294967295L));
                            } else {
                                closedFloatingPointRange = rangeTo2;
                                closedFloatingPointRange2 = rangeTo3;
                                if (z6) {
                                    m4519constructorimpl3 = Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32)) - lerp) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
                                } else {
                                    m4519constructorimpl3 = Offset.m4519constructorimpl((Float.floatToRawIntBits(lerp) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5345getCenterF1C5BW0() & 4294967295L))) & 4294967295L));
                                }
                            }
                            function3.invoke(drawScope, Offset.m4516boximpl(m4519constructorimpl3), Color.m4762boximpl(rangeTo.contains(Float.valueOf(lerp)) ? j4 : j3));
                            i++;
                            rangeTo2 = closedFloatingPointRange;
                            rangeTo3 = closedFloatingPointRange2;
                            i2 = i3;
                        }
                    }
                    closedFloatingPointRange = rangeTo2;
                    closedFloatingPointRange2 = rangeTo3;
                    i++;
                    rangeTo2 = closedFloatingPointRange;
                    rangeTo3 = closedFloatingPointRange2;
                    i2 = i3;
                }
            }
        }
        f16 = f36;
        if (f38 <= f16) {
        }
        float f392 = 0.0f + f24;
        float f402 = intBitsToFloat - f24;
        ClosedFloatingPointRange<Float> rangeTo5 = RangesKt.rangeTo(f18, f19);
        ClosedFloatingPointRange<Float> rangeTo22 = RangesKt.rangeTo(f12 - f11, f12 + f11);
        ClosedFloatingPointRange<Float> rangeTo32 = RangesKt.rangeTo(f26 - f10, f26 + f10);
        ClosedFloatingPointRange<Float> rangeTo42 = RangesKt.rangeTo(f17 - f11, f17 + f11);
        length = fArr.length;
        int i22 = 0;
        i = 0;
        while (i < length) {
        }
    }

    /* renamed from: drawStopIndicator-x3O1jOs  reason: not valid java name */
    public final void m2524drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, float f, long j2) {
        DrawScope.m5327drawCircleVaOC9Bg$default(drawScope, j2, drawScope.mo405toPx0680j_4(f) / 2.0f, j, 0.0f, null, null, 0, 120, null);
    }

    /* renamed from: getTrackStopIndicatorSize-D9Ej5fM  reason: not valid java name */
    public final float m2526getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }

    /* renamed from: getTickSize-D9Ej5fM  reason: not valid java name */
    public final float m2525getTickSizeD9Ej5fM() {
        return TickSize;
    }

    /* renamed from: drawTrackPath-zXTsYAs  reason: not valid java name */
    private final void m2515drawTrackPathzXTsYAs(DrawScope drawScope, Orientation orientation, long j, long j2, long j3, float f, float f2) {
        RoundRect m4579RoundRectZAM2FJo;
        long m4481constructorimpl = CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
        long m4481constructorimpl2 = CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
        if (orientation == Orientation.Vertical) {
            float intBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
            m4579RoundRectZAM2FJo = RoundRectKt.m4579RoundRectZAM2FJo(RectKt.m4567Recttz77jQw(j, Size.m4587constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32))), m4481constructorimpl, m4481constructorimpl, m4481constructorimpl2, m4481constructorimpl2);
        } else {
            float intBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32));
            float intBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L));
            m4579RoundRectZAM2FJo = RoundRectKt.m4579RoundRectZAM2FJo(RectKt.m4567Recttz77jQw(j, Size.m4587constructorimpl((Float.floatToRawIntBits(intBitsToFloat4) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat3) << 32))), m4481constructorimpl, m4481constructorimpl2, m4481constructorimpl2, m4481constructorimpl);
        }
        Path path = trackPath;
        Path.addRoundRect$default(path, m4579RoundRectZAM2FJo, null, 2, null);
        DrawScope.m5336drawPathLG529CI$default(drawScope, path, j3, 0.0f, null, null, 0, 60, null);
        path.rewind();
    }
}

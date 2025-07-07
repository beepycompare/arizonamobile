package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÈ\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c0 2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020#2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101J&\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J0\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00108\u001a\u00020.H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u008a\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u009e\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010L\u001a\u0002042\b\b\u0002\u0010M\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010OR$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "InputField", "", SearchIntents.EXTRA_QUERY, "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "expanded", "", "onExpandedChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "colors", "Landroidx/compose/material3/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight;
    private static final float ShadowElevation;
    private static final float TonalElevation;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* renamed from: getElevation-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2218getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    static {
        float m2977getLevel0D9Ej5fM = ElevationTokens.INSTANCE.m2977getLevel0D9Ej5fM();
        TonalElevation = m2977getLevel0D9Ej5fM;
        ShadowElevation = ElevationTokens.INSTANCE.m2977getLevel0D9Ej5fM();
        Elevation = m2977getLevel0D9Ej5fM;
        InputFieldHeight = SearchBarTokens.INSTANCE.m3278getContainerHeightD9Ej5fM();
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m2224getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM  reason: not valid java name */
    public final float m2223getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2221getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m2222getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -971556142, "C349@15770L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-971556142, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:349)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1665502056, "C353@15944L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665502056, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:353)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getDockedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1006952150, "C357@16094L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006952150, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:357)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2112270157, "C361@16229L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112270157, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:361)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return statusBars;
    }

    /* renamed from: colors-dgg9oW8  reason: not valid java name */
    public final SearchBarColors m2220colorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1507037523, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)375@16778L5,376@16845L5,381@17019L18:SearchBar.android.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1507037523, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(value, value2, m2226inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, (i << 6) & 57344, 16383), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-ITpI4ow  reason: not valid java name */
    public final TextFieldColors m2226inputFieldColorsITpI4ow(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -602148837, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)410@18829L5,411@18903L5,413@18998L5,416@19154L5,417@19233L7,418@19316L5,419@19399L5,421@19507L5,424@19683L5,425@19768L5,427@19878L5,430@20056L5,431@20142L5,433@20244L5,437@20389L847:SearchBar.android.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j2;
        long m4077copywmQWz5c$default = (i3 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        if ((i3 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long value5 = (i3 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j6;
        long m4077copywmQWz5c$default2 = (i3 & 128) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long value7 = (i3 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j9;
        long m4077copywmQWz5c$default3 = (i3 & 1024) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long value8 = (i3 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j11;
        long value9 = (i3 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j12;
        long m4077copywmQWz5c$default4 = (i3 & 8192) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:437)");
        }
        int i4 = i2 << 18;
        TextFieldColors m2478colors0hiis_0 = TextFieldDefaults.INSTANCE.m2478colors0hiis_0(value, value2, m4077copywmQWz5c$default, 0L, 0L, 0L, 0L, 0L, value3, 0L, textSelectionColors2, 0L, 0L, 0L, 0L, value4, value5, m4077copywmQWz5c$default2, 0L, value6, value7, m4077copywmQWz5c$default3, 0L, 0L, 0L, 0L, 0L, value8, value9, m4077copywmQWz5c$default4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, (i & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i << 15) & 234881024), ((i >> 12) & 14) | (458752 & i) | (3670016 & i) | (i & 29360128) | ((i << 3) & 1879048192), ((i >> 27) & 14) | ((i2 << 3) & 112) | (i4 & 29360128) | (i4 & 234881024) | (i4 & 1879048192), 0, 3072, 1204058872, 4095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2478colors0hiis_0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0524 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* JADX WARN: Type inference failed for: r15v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void InputField(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Object obj;
        int i6;
        boolean z3;
        int i7;
        Object obj2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Object obj3;
        int i15;
        Object obj4;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i16;
        int i17;
        TextFieldColors textFieldColors2;
        int i18;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Object rememberedValue;
        long m6177getColor0d7_KjU;
        float f;
        boolean z4;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        boolean z5;
        Object rememberedValue4;
        boolean z6;
        boolean changed2;
        SearchBarDefaults$InputField$5$1 rememberedValue5;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier2;
        final TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(1451366815);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputField)P(10,7,8,2,6,5,1,9,4,11)492@23517L18,498@23776L25,499@23837L29,500@23912L7,502@23951L34,503@24030L39,*506@24122L7,521@24685L44,522@24761L378,534@25242L7,537@25496L19,540@25625L1172,510@24250L2557,566@26894L320,566@26869L345:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                obj = modifier;
            } else {
                Object obj5 = modifier;
                obj = obj5;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(obj5) ? 131072 : 65536;
                    obj = obj5;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                }
            }
            i7 = i3 & 128;
            if (i7 == 0) {
                i4 |= 12582912;
                obj2 = function2;
            } else {
                Object obj6 = function2;
                obj2 = obj6;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(obj6) ? 8388608 : 4194304;
                    obj2 = obj6;
                }
            }
            i8 = i3 & 256;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
            }
            i9 = i3 & 512;
            if (i9 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i10 = i9;
                i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0 && startRestartGroup.changed(textFieldColors)) {
                        i19 = 4;
                        i11 = i2 | i19;
                    }
                    i19 = 2;
                    i11 = i2 | i19;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                i13 = i3 & 2048;
                if (i13 != 0) {
                    i14 = i13;
                    i15 = i11 | 48;
                    obj4 = mutableInteractionSource;
                } else {
                    if ((i2 & 48) == 0) {
                        i14 = i13;
                        obj3 = mutableInteractionSource;
                        i11 |= startRestartGroup.changed(obj3) ? 32 : 16;
                    } else {
                        i14 = i13;
                        obj3 = mutableInteractionSource;
                    }
                    i15 = i11;
                    obj4 = obj3;
                }
                if ((i3 & 4096) != 0) {
                    i15 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i15 |= startRestartGroup.changed(this) ? 256 : 128;
                    if ((i12 & 306783379) == 306783378 || (i15 & 147) != 146 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        int i20 = i15;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i5 == 0 ? Modifier.Companion : obj;
                            boolean z8 = i6 == 0 ? true : z3;
                            function24 = i7 == 0 ? null : obj2;
                            function25 = i8 == 0 ? null : function22;
                            function26 = i10 == 0 ? null : function23;
                            if ((i3 & 1024) == 0) {
                                i17 = i14;
                                i16 = i12;
                                textFieldColors2 = m2226inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, (i20 << 6) & 57344, 16383);
                                startRestartGroup = startRestartGroup;
                                i18 = i20 & (-15);
                            } else {
                                i16 = i12;
                                i17 = i14;
                                textFieldColors2 = textFieldColors;
                                i18 = i20;
                            }
                            if (i17 == 0) {
                                z3 = z8;
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                z3 = z8;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 1024) != 0) {
                                Object obj7 = obj;
                                i18 = i20 & (-15);
                                companion = obj7;
                                function25 = function22;
                                function26 = function23;
                                mutableInteractionSource2 = obj4;
                                function24 = obj2;
                                i16 = i12;
                            } else {
                                function25 = function22;
                                function26 = function23;
                                mutableInteractionSource2 = obj4;
                                companion = obj;
                                function24 = obj2;
                                i16 = i12;
                                i18 = i20;
                            }
                            textFieldColors2 = textFieldColors;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1451366815, i16, i18, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.android.kt:494)");
                        }
                        startRestartGroup.startReplaceGroup(-320443616);
                        ComposerKt.sourceInformation(startRestartGroup, "496@23695L39");
                        if (mutableInteractionSource2 != null) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320442965, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue6;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        startRestartGroup.endReplaceGroup();
                        boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320438431, "CC(remember):SearchBar.android.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new FocusRequester();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final FocusRequester focusRequester = (FocusRequester) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier modifier3 = companion;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        FocusManager focusManager = (FocusManager) consume;
                        Strings.Companion companion2 = Strings.Companion;
                        final String m2779getString2EP1pXo = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
                        Strings.Companion companion3 = Strings.Companion;
                        final String m2779getString2EP1pXo2 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(TextKt.getLocalTextStyle());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        m6177getColor0d7_KjU = ((TextStyle) consume2).m6177getColor0d7_KjU();
                        if (m6177getColor0d7_KjU == 16) {
                            m6177getColor0d7_KjU = textFieldColors2.m2466textColorXeAY9LY$material3_release(z3, false, booleanValue);
                        }
                        long j = m6177getColor0d7_KjU;
                        float searchBarMinWidth = SearchBar_androidKt.getSearchBarMinWidth();
                        f = SearchBar_androidKt.SearchBarMaxWidth;
                        Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(SizeKt.m789sizeInqDBjuR0$default(modifier3, searchBarMinWidth, InputFieldHeight, f, 0.0f, 8, null), focusRequester);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320411280, "CC(remember):SearchBar.android.kt#9igjgp");
                        final boolean z9 = z3;
                        z4 = (57344 & i16) != 16384;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                    invoke2(focusState);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(FocusState focusState) {
                                    if (focusState.isFocused()) {
                                        function13.invoke(true);
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester2, (Function1) rememberedValue2);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320408514, "CC(remember):SearchBar.android.kt#9igjgp");
                        changed = ((i16 & 7168) != 2048) | startRestartGroup.changed(m2779getString2EP1pXo) | startRestartGroup.changed(m2779getString2EP1pXo2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2779getString2EP1pXo);
                                    if (z) {
                                        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2779getString2EP1pXo2);
                                    }
                                    final FocusRequester focusRequester3 = focusRequester;
                                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1.1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            FocusRequester.this.requestFocus();
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue3, 1, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = startRestartGroup.consume(TextKt.getLocalTextStyle());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        TextStyle merge = ((TextStyle) consume3).merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                        SolidColor solidColor = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(false), null);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m6333getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320385353, "CC(remember):SearchBar.android.kt#9igjgp");
                        int i21 = i16 & 14;
                        z5 = ((i16 & 896) != 256) | (i21 != 4);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!z5 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$3$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                    invoke2(keyboardActionScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyboardActionScope keyboardActionScope) {
                                    function12.invoke(str);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final TextFieldColors textFieldColors4 = textFieldColors2;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                        int i22 = i16 >> 9;
                        Composer composer3 = startRestartGroup;
                        BasicTextFieldKt.BasicTextField(str, function1, semantics$default, z9, false, merge, keyboardOptions, new KeyboardActions(null, null, null, null, rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2029278807, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function213, Composer composer4, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function213, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function213, Composer composer4, int i23) {
                                int i24;
                                ComposerKt.sourceInformation(composer4, "C557@26571L15,541@25683L1096:SearchBar.android.kt#uh7d8r");
                                if ((i23 & 6) == 0) {
                                    i24 = i23 | (composer4.changedInstance(function213) ? 4 : 2);
                                } else {
                                    i24 = i23;
                                }
                                if ((i24 & 19) != 18 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2029278807, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.android.kt:541)");
                                    }
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    int i25 = i24;
                                    String str2 = str;
                                    boolean z10 = z9;
                                    VisualTransformation none = VisualTransformation.Companion.getNone();
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                    Function2<Composer, Integer, Unit> function214 = function210;
                                    final Function2<Composer, Integer, Unit> function215 = function211;
                                    composer4.startReplaceGroup(-1102017390);
                                    ComposerKt.sourceInformation(composer4, "*551@26196L64");
                                    ComposableLambda rememberComposableLambda = function215 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1401341985, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i26) {
                                            float f2;
                                            ComposerKt.sourceInformation(composer5, "C551@26198L60:SearchBar.android.kt#uh7d8r");
                                            if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1401341985, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:551)");
                                            }
                                            f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                            Function2<Composer, Integer, Unit> function216 = function215;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -127763558, "C551@26247L9:SearchBar.android.kt#uh7d8r");
                                            function216.invoke(composer5, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer4, 54);
                                    composer4.endReplaceGroup();
                                    final Function2<Composer, Integer, Unit> function216 = function212;
                                    composer4.startReplaceGroup(-1102010155);
                                    ComposerKt.sourceInformation(composer4, "*555@26423L66");
                                    ComposableLambda rememberComposableLambda2 = function216 != null ? ComposableLambdaKt.rememberComposableLambda(907752083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i26) {
                                            float f2;
                                            ComposerKt.sourceInformation(composer5, "C555@26425L62:SearchBar.android.kt#uh7d8r");
                                            if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(907752083, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:555)");
                                            }
                                            f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-f2), 0.0f, 2, null);
                                            Function2<Composer, Integer, Unit> function217 = function216;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -127537351, "C555@26475L10:SearchBar.android.kt#uh7d8r");
                                            function217.invoke(composer5, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer4, 54) : null;
                                    composer4.endReplaceGroup();
                                    textFieldDefaults.DecorationBox(str2, function213, z10, true, none, mutableInteractionSource6, false, null, function214, rememberComposableLambda, rememberComposableLambda2, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer4, 6), textFieldColors4, TextFieldDefaults.m2469contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1781getLambda1$material3_release(), composer4, ((i25 << 3) & 112) | 27648, 113246208, 14528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), composer3, i21 | 102236160 | (i16 & 112) | (i22 & 7168), (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
                        z6 = z && booleanValue;
                        Boolean valueOf = Boolean.valueOf(z);
                        ComposerKt.sourceInformationMarkerStart(composer3, -320340316, "CC(remember):SearchBar.android.kt#9igjgp");
                        changed2 = composer3.changed(z6) | composer3.changedInstance(focusManager);
                        rememberedValue5 = composer3.rememberedValue();
                        if (!changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new SearchBarDefaults$InputField$5$1(z6, focusManager, null);
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue5, composer3, i22 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composer3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        modifier2 = modifier3;
                        textFieldColors3 = textFieldColors4;
                        function27 = function24;
                        function28 = function25;
                        function29 = function26;
                        z7 = z9;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        textFieldColors3 = textFieldColors;
                        composer2 = startRestartGroup;
                        mutableInteractionSource4 = obj4;
                        modifier2 = obj;
                        z7 = z3;
                        function27 = obj2;
                        function28 = function22;
                        function29 = function23;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i23) {
                                SearchBarDefaults.this.InputField(str, function1, function12, z, function13, modifier2, z7, function27, function28, function29, textFieldColors3, mutableInteractionSource4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i12 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                int i202 = i15;
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if (i17 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-320443616);
                ComposerKt.sourceInformation(startRestartGroup, "496@23695L39");
                if (mutableInteractionSource2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                boolean booleanValue2 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320438431, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                final FocusRequester focusRequester3 = (FocusRequester) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier32 = companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager2 = (FocusManager) consume4;
                Strings.Companion companion22 = Strings.Companion;
                final String m2779getString2EP1pXo3 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
                Strings.Companion companion32 = Strings.Companion;
                final String m2779getString2EP1pXo22 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
                final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(TextKt.getLocalTextStyle());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                m6177getColor0d7_KjU = ((TextStyle) consume22).m6177getColor0d7_KjU();
                if (m6177getColor0d7_KjU == 16) {
                }
                long j2 = m6177getColor0d7_KjU;
                float searchBarMinWidth2 = SearchBar_androidKt.getSearchBarMinWidth();
                f = SearchBar_androidKt.SearchBarMaxWidth;
                Modifier focusRequester22 = FocusRequesterModifierKt.focusRequester(SizeKt.m789sizeInqDBjuR0$default(modifier32, searchBarMinWidth2, InputFieldHeight, f, 0.0f, 8, null), focusRequester3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320411280, "CC(remember):SearchBar.android.kt#9igjgp");
                final boolean z92 = z3;
                if ((57344 & i16) != 16384) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState focusState) {
                        if (focusState.isFocused()) {
                            function13.invoke(true);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier onFocusChanged2 = FocusChangedModifierKt.onFocusChanged(focusRequester22, (Function1) rememberedValue2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320408514, "CC(remember):SearchBar.android.kt#9igjgp");
                changed = ((i16 & 7168) != 2048) | startRestartGroup.changed(m2779getString2EP1pXo3) | startRestartGroup.changed(m2779getString2EP1pXo22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2779getString2EP1pXo3);
                        if (z) {
                            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2779getString2EP1pXo22);
                        }
                        final FocusRequester focusRequester32 = focusRequester3;
                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1.1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                FocusRequester.this.requestFocus();
                                return true;
                            }
                        }, 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier semantics$default2 = SemanticsModifierKt.semantics$default(onFocusChanged2, false, (Function1) rememberedValue3, 1, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(TextKt.getLocalTextStyle());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                TextStyle merge2 = ((TextStyle) consume32).merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                SolidColor solidColor2 = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(false), null);
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m6333getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320385353, "CC(remember):SearchBar.android.kt#9igjgp");
                int i212 = i16 & 14;
                z5 = ((i16 & 896) != 256) | (i212 != 4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope keyboardActionScope) {
                        function12.invoke(str);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final TextFieldColors textFieldColors42 = textFieldColors2;
                final Function2<? super Composer, ? super Integer, Unit> function2102 = function24;
                final Function2<? super Composer, ? super Integer, Unit> function2112 = function25;
                final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
                int i222 = i16 >> 9;
                Composer composer32 = startRestartGroup;
                BasicTextFieldKt.BasicTextField(str, function1, semantics$default2, z92, false, merge2, keyboardOptions2, new KeyboardActions(null, null, null, null, rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource52, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2029278807, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function213, Composer composer4, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function213, composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function213, Composer composer4, int i23) {
                        int i24;
                        ComposerKt.sourceInformation(composer4, "C557@26571L15,541@25683L1096:SearchBar.android.kt#uh7d8r");
                        if ((i23 & 6) == 0) {
                            i24 = i23 | (composer4.changedInstance(function213) ? 4 : 2);
                        } else {
                            i24 = i23;
                        }
                        if ((i24 & 19) != 18 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2029278807, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.android.kt:541)");
                            }
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            int i25 = i24;
                            String str2 = str;
                            boolean z10 = z92;
                            VisualTransformation none = VisualTransformation.Companion.getNone();
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52;
                            Function2<Composer, Integer, Unit> function214 = function2102;
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function2112;
                            composer4.startReplaceGroup(-1102017390);
                            ComposerKt.sourceInformation(composer4, "*551@26196L64");
                            ComposableLambda rememberComposableLambda = function215 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1401341985, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i26) {
                                    float f2;
                                    ComposerKt.sourceInformation(composer5, "C551@26198L60:SearchBar.android.kt#uh7d8r");
                                    if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1401341985, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:551)");
                                    }
                                    f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                    Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function216 = function215;
                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor);
                                    } else {
                                        composer5.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, -127763558, "C551@26247L9:SearchBar.android.kt#uh7d8r");
                                    function216.invoke(composer5, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54);
                            composer4.endReplaceGroup();
                            final Function2<? super Composer, ? super Integer, Unit> function216 = function2122;
                            composer4.startReplaceGroup(-1102010155);
                            ComposerKt.sourceInformation(composer4, "*555@26423L66");
                            ComposableLambda rememberComposableLambda2 = function216 != null ? ComposableLambdaKt.rememberComposableLambda(907752083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i26) {
                                    float f2;
                                    ComposerKt.sourceInformation(composer5, "C555@26425L62:SearchBar.android.kt#uh7d8r");
                                    if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(907752083, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:555)");
                                    }
                                    f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                    Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-f2), 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function217 = function216;
                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor);
                                    } else {
                                        composer5.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, -127537351, "C555@26475L10:SearchBar.android.kt#uh7d8r");
                                    function217.invoke(composer5, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54) : null;
                            composer4.endReplaceGroup();
                            textFieldDefaults.DecorationBox(str2, function213, z10, true, none, mutableInteractionSource6, false, null, function214, rememberComposableLambda, rememberComposableLambda2, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer4, 6), textFieldColors42, TextFieldDefaults.m2469contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1781getLambda1$material3_release(), composer4, ((i25 << 3) & 112) | 27648, 113246208, 14528);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), composer32, i212 | 102236160 | (i16 & 112) | (i222 & 7168), (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
                if (z) {
                }
                Boolean valueOf2 = Boolean.valueOf(z);
                ComposerKt.sourceInformationMarkerStart(composer32, -320340316, "CC(remember):SearchBar.android.kt#9igjgp");
                changed2 = composer32.changed(z6) | composer32.changedInstance(focusManager2);
                rememberedValue5 = composer32.rememberedValue();
                if (!changed2) {
                }
                rememberedValue5 = new SearchBarDefaults$InputField$5$1(z6, focusManager2, null);
                composer32.updateRememberedValue(rememberedValue5);
                ComposerKt.sourceInformationMarkerEnd(composer32);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) rememberedValue5, composer32, i222 & 14);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = composer32;
                mutableInteractionSource4 = mutableInteractionSource2;
                modifier2 = modifier32;
                textFieldColors3 = textFieldColors42;
                function27 = function24;
                function28 = function25;
                function29 = function26;
                z7 = z92;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            i12 = i4;
            i13 = i3 & 2048;
            if (i13 != 0) {
            }
            if ((i3 & 4096) != 0) {
            }
            if ((i12 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            int i2022 = i15;
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if (i17 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-320443616);
            ComposerKt.sourceInformation(startRestartGroup, "496@23695L39");
            if (mutableInteractionSource2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            boolean booleanValue22 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320438431, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            final FocusRequester focusRequester32 = (FocusRequester) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier modifier322 = companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume42 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager22 = (FocusManager) consume42;
            Strings.Companion companion222 = Strings.Companion;
            final String m2779getString2EP1pXo32 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
            Strings.Companion companion322 = Strings.Companion;
            final String m2779getString2EP1pXo222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
            final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m6177getColor0d7_KjU = ((TextStyle) consume222).m6177getColor0d7_KjU();
            if (m6177getColor0d7_KjU == 16) {
            }
            long j22 = m6177getColor0d7_KjU;
            float searchBarMinWidth22 = SearchBar_androidKt.getSearchBarMinWidth();
            f = SearchBar_androidKt.SearchBarMaxWidth;
            Modifier focusRequester222 = FocusRequesterModifierKt.focusRequester(SizeKt.m789sizeInqDBjuR0$default(modifier322, searchBarMinWidth22, InputFieldHeight, f, 0.0f, 8, null), focusRequester32);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320411280, "CC(remember):SearchBar.android.kt#9igjgp");
            final boolean z922 = z3;
            if ((57344 & i16) != 16384) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState focusState) {
                    if (focusState.isFocused()) {
                        function13.invoke(true);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier onFocusChanged22 = FocusChangedModifierKt.onFocusChanged(focusRequester222, (Function1) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320408514, "CC(remember):SearchBar.android.kt#9igjgp");
            changed = ((i16 & 7168) != 2048) | startRestartGroup.changed(m2779getString2EP1pXo32) | startRestartGroup.changed(m2779getString2EP1pXo222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2779getString2EP1pXo32);
                    if (z) {
                        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2779getString2EP1pXo222);
                    }
                    final FocusRequester focusRequester322 = focusRequester32;
                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            FocusRequester.this.requestFocus();
                            return true;
                        }
                    }, 1, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics$default22 = SemanticsModifierKt.semantics$default(onFocusChanged22, false, (Function1) rememberedValue3, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextStyle merge22 = ((TextStyle) consume322).merge(new TextStyle(j22, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            SolidColor solidColor22 = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(false), null);
            KeyboardOptions keyboardOptions22 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m6333getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320385353, "CC(remember):SearchBar.android.kt#9igjgp");
            int i2122 = i16 & 14;
            z5 = ((i16 & 896) != 256) | (i2122 != 4);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                    invoke2(keyboardActionScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(KeyboardActionScope keyboardActionScope) {
                    function12.invoke(str);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextFieldColors textFieldColors422 = textFieldColors2;
            final Function2<? super Composer, ? super Integer, Unit> function21022 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function21122 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function21222 = function26;
            int i2222 = i16 >> 9;
            Composer composer322 = startRestartGroup;
            BasicTextFieldKt.BasicTextField(str, function1, semantics$default22, z922, false, merge22, keyboardOptions22, new KeyboardActions(null, null, null, null, rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource522, (Brush) solidColor22, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2029278807, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function213, Composer composer4, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function213, composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function213, Composer composer4, int i23) {
                    int i24;
                    ComposerKt.sourceInformation(composer4, "C557@26571L15,541@25683L1096:SearchBar.android.kt#uh7d8r");
                    if ((i23 & 6) == 0) {
                        i24 = i23 | (composer4.changedInstance(function213) ? 4 : 2);
                    } else {
                        i24 = i23;
                    }
                    if ((i24 & 19) != 18 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2029278807, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.android.kt:541)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        int i25 = i24;
                        String str2 = str;
                        boolean z10 = z922;
                        VisualTransformation none = VisualTransformation.Companion.getNone();
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522;
                        Function2<Composer, Integer, Unit> function214 = function21022;
                        final Function2<? super Composer, ? super Integer, Unit> function215 = function21122;
                        composer4.startReplaceGroup(-1102017390);
                        ComposerKt.sourceInformation(composer4, "*551@26196L64");
                        ComposableLambda rememberComposableLambda = function215 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1401341985, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i26) {
                                float f2;
                                ComposerKt.sourceInformation(composer5, "C551@26198L60:SearchBar.android.kt#uh7d8r");
                                if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1401341985, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:551)");
                                }
                                f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function216 = function215;
                                ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer5.startReusableNode();
                                if (composer5.getInserting()) {
                                    composer5.createNode(constructor);
                                } else {
                                    composer5.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer5, -127763558, "C551@26247L9:SearchBar.android.kt#uh7d8r");
                                function216.invoke(composer5, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer4, 54);
                        composer4.endReplaceGroup();
                        final Function2<? super Composer, ? super Integer, Unit> function216 = function21222;
                        composer4.startReplaceGroup(-1102010155);
                        ComposerKt.sourceInformation(composer4, "*555@26423L66");
                        ComposableLambda rememberComposableLambda2 = function216 != null ? ComposableLambdaKt.rememberComposableLambda(907752083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i26) {
                                float f2;
                                ComposerKt.sourceInformation(composer5, "C555@26425L62:SearchBar.android.kt#uh7d8r");
                                if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(907752083, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:555)");
                                }
                                f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                                Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-f2), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function217 = function216;
                                ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer5.startReusableNode();
                                if (composer5.getInserting()) {
                                    composer5.createNode(constructor);
                                } else {
                                    composer5.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer5, -127537351, "C555@26475L10:SearchBar.android.kt#uh7d8r");
                                function217.invoke(composer5, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer4, 54) : null;
                        composer4.endReplaceGroup();
                        textFieldDefaults.DecorationBox(str2, function213, z10, true, none, mutableInteractionSource6, false, null, function214, rememberComposableLambda, rememberComposableLambda2, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer4, 6), textFieldColors422, TextFieldDefaults.m2469contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1781getLambda1$material3_release(), composer4, ((i25 << 3) & 112) | 27648, 113246208, 14528);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer322, i2122 | 102236160 | (i16 & 112) | (i2222 & 7168), (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
            if (z) {
            }
            Boolean valueOf22 = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composer322, -320340316, "CC(remember):SearchBar.android.kt#9igjgp");
            changed2 = composer322.changed(z6) | composer322.changedInstance(focusManager22);
            rememberedValue5 = composer322.rememberedValue();
            if (!changed2) {
            }
            rememberedValue5 = new SearchBarDefaults$InputField$5$1(z6, focusManager22, null);
            composer322.updateRememberedValue(rememberedValue5);
            ComposerKt.sourceInformationMarkerEnd(composer322);
            EffectsKt.LaunchedEffect(valueOf22, (Function2) rememberedValue5, composer322, i2222 & 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = composer322;
            mutableInteractionSource4 = mutableInteractionSource2;
            modifier2 = modifier322;
            textFieldColors3 = textFieldColors422;
            function27 = function24;
            function28 = function25;
            function29 = function26;
            z7 = z922;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 6) == 0) {
        }
        i12 = i4;
        i13 = i3 & 2048;
        if (i13 != 0) {
        }
        if ((i3 & 4096) != 0) {
        }
        if ((i12 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        int i20222 = i15;
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if (i17 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-320443616);
        ComposerKt.sourceInformation(startRestartGroup, "496@23695L39");
        if (mutableInteractionSource2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        boolean booleanValue222 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320438431, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        final FocusRequester focusRequester322 = (FocusRequester) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier modifier3222 = companion;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume422 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager222 = (FocusManager) consume422;
        Strings.Companion companion2222 = Strings.Companion;
        final String m2779getString2EP1pXo322 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
        Strings.Companion companion3222 = Strings.Companion;
        final String m2779getString2EP1pXo2222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
        final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(TextKt.getLocalTextStyle());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        m6177getColor0d7_KjU = ((TextStyle) consume2222).m6177getColor0d7_KjU();
        if (m6177getColor0d7_KjU == 16) {
        }
        long j222 = m6177getColor0d7_KjU;
        float searchBarMinWidth222 = SearchBar_androidKt.getSearchBarMinWidth();
        f = SearchBar_androidKt.SearchBarMaxWidth;
        Modifier focusRequester2222 = FocusRequesterModifierKt.focusRequester(SizeKt.m789sizeInqDBjuR0$default(modifier3222, searchBarMinWidth222, InputFieldHeight, f, 0.0f, 8, null), focusRequester322);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320411280, "CC(remember):SearchBar.android.kt#9igjgp");
        final boolean z9222 = z3;
        if ((57344 & i16) != 16384) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                if (focusState.isFocused()) {
                    function13.invoke(true);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier onFocusChanged222 = FocusChangedModifierKt.onFocusChanged(focusRequester2222, (Function1) rememberedValue2);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320408514, "CC(remember):SearchBar.android.kt#9igjgp");
        changed = ((i16 & 7168) != 2048) | startRestartGroup.changed(m2779getString2EP1pXo322) | startRestartGroup.changed(m2779getString2EP1pXo2222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2779getString2EP1pXo322);
                if (z) {
                    SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2779getString2EP1pXo2222);
                }
                final FocusRequester focusRequester3222 = focusRequester322;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$2$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        FocusRequester.this.requestFocus();
                        return true;
                    }
                }, 1, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier semantics$default222 = SemanticsModifierKt.semantics$default(onFocusChanged222, false, (Function1) rememberedValue3, 1, null);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(TextKt.getLocalTextStyle());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        TextStyle merge222 = ((TextStyle) consume3222).merge(new TextStyle(j222, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        SolidColor solidColor222 = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(false), null);
        KeyboardOptions keyboardOptions222 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m6333getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320385353, "CC(remember):SearchBar.android.kt#9igjgp");
        int i21222 = i16 & 14;
        z5 = ((i16 & 896) != 256) | (i21222 != 4);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                function12.invoke(str);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final TextFieldColors textFieldColors4222 = textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function210222 = function24;
        final Function2<? super Composer, ? super Integer, Unit> function211222 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function212222 = function26;
        int i22222 = i16 >> 9;
        Composer composer3222 = startRestartGroup;
        BasicTextFieldKt.BasicTextField(str, function1, semantics$default222, z9222, false, merge222, keyboardOptions222, new KeyboardActions(null, null, null, null, rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5222, (Brush) solidColor222, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2029278807, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function213, Composer composer4, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function213, composer4, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function213, Composer composer4, int i23) {
                int i24;
                ComposerKt.sourceInformation(composer4, "C557@26571L15,541@25683L1096:SearchBar.android.kt#uh7d8r");
                if ((i23 & 6) == 0) {
                    i24 = i23 | (composer4.changedInstance(function213) ? 4 : 2);
                } else {
                    i24 = i23;
                }
                if ((i24 & 19) != 18 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2029278807, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.android.kt:541)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    int i25 = i24;
                    String str2 = str;
                    boolean z10 = z9222;
                    VisualTransformation none = VisualTransformation.Companion.getNone();
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5222;
                    Function2<Composer, Integer, Unit> function214 = function210222;
                    final Function2<? super Composer, ? super Integer, Unit> function215 = function211222;
                    composer4.startReplaceGroup(-1102017390);
                    ComposerKt.sourceInformation(composer4, "*551@26196L64");
                    ComposableLambda rememberComposableLambda = function215 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1401341985, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i26) {
                            float f2;
                            ComposerKt.sourceInformation(composer5, "C551@26198L60:SearchBar.android.kt#uh7d8r");
                            if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1401341985, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:551)");
                            }
                            f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function216 = function215;
                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                composer5.createNode(constructor);
                            } else {
                                composer5.useNode();
                            }
                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer5, -127763558, "C551@26247L9:SearchBar.android.kt#uh7d8r");
                            function216.invoke(composer5, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer4, 54);
                    composer4.endReplaceGroup();
                    final Function2<? super Composer, ? super Integer, Unit> function216 = function212222;
                    composer4.startReplaceGroup(-1102010155);
                    ComposerKt.sourceInformation(composer4, "*555@26423L66");
                    ComposableLambda rememberComposableLambda2 = function216 != null ? ComposableLambdaKt.rememberComposableLambda(907752083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$4$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i26) {
                            float f2;
                            ComposerKt.sourceInformation(composer5, "C555@26425L62:SearchBar.android.kt#uh7d8r");
                            if ((i26 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(907752083, i26, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:555)");
                            }
                            f2 = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-f2), 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function217 = function216;
                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m698offsetVpY3zN4$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                composer5.createNode(constructor);
                            } else {
                                composer5.useNode();
                            }
                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer5, -127537351, "C555@26475L10:SearchBar.android.kt#uh7d8r");
                            function217.invoke(composer5, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer4, 54) : null;
                    composer4.endReplaceGroup();
                    textFieldDefaults.DecorationBox(str2, function213, z10, true, none, mutableInteractionSource6, false, null, function214, rememberComposableLambda, rememberComposableLambda2, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer4, 6), textFieldColors4222, TextFieldDefaults.m2469contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1781getLambda1$material3_release(), composer4, ((i25 << 3) & 112) | 27648, 113246208, 14528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }, startRestartGroup, 54), composer3222, i21222 | 102236160 | (i16 & 112) | (i22222 & 7168), (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
        if (z) {
        }
        Boolean valueOf222 = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(composer3222, -320340316, "CC(remember):SearchBar.android.kt#9igjgp");
        changed2 = composer3222.changed(z6) | composer3222.changedInstance(focusManager222);
        rememberedValue5 = composer3222.rememberedValue();
        if (!changed2) {
        }
        rememberedValue5 = new SearchBarDefaults$InputField$5$1(z6, focusManager222, null);
        composer3222.updateRememberedValue(rememberedValue5);
        ComposerKt.sourceInformationMarkerEnd(composer3222);
        EffectsKt.LaunchedEffect(valueOf222, (Function2) rememberedValue5, composer3222, i22222 & 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = composer3222;
        mutableInteractionSource4 = mutableInteractionSource2;
        modifier2 = modifier3222;
        textFieldColors3 = textFieldColors4222;
        function27 = function24;
        function28 = function25;
        function29 = function26;
        z7 = z9222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. `inputFieldColors` should be passed explicitly to the input field. This parameter will be removed in a future version of the library.", replaceWith = @ReplaceWith(expression = "colors(containerColor, dividerColor)", imports = {}))
    /* renamed from: colors-Klgx-Pg  reason: not valid java name */
    public final SearchBarColors m2219colorsKlgxPg(long j, long j2, TextFieldColors textFieldColors, Composer composer, int i, int i2) {
        int i3;
        TextFieldColors textFieldColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)586@27706L5,587@27773L5,588@27824L18:SearchBar.android.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if ((i2 & 4) != 0) {
            i3 = i;
            textFieldColors2 = m2226inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, (i << 3) & 57344, 16383);
        } else {
            i3 = i;
            textFieldColors2 = textFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:590)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(value, value2, textFieldColors2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2225inputFieldColorsuKgnY(long j, long j2, long j3, TextSelectionColors textSelectionColors, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 355927049, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)599@28228L5,601@28323L5,604@28479L5,605@28558L7,606@28641L5,607@28724L5,609@28832L5,612@29008L5,613@29093L5,615@29203L5,618@29374L5,620@29476L5,624@29586L825:SearchBar.android.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long m4077copywmQWz5c$default = (i3 & 2) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j3;
        if ((i3 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value3 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j4;
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long m4077copywmQWz5c$default2 = (i3 & 64) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long value5 = (i3 & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long m4077copywmQWz5c$default3 = (i3 & 512) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long value7 = (i3 & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j10;
        long m4077copywmQWz5c$default4 = (i3 & 2048) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:624)");
        }
        int i4 = i << 3;
        int i5 = i2 << 6;
        int i6 = ((i >> 27) & 14) | ((i2 << 3) & 112) | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        long j12 = value;
        long j13 = value2;
        long j14 = value3;
        long j15 = value4;
        long j16 = m4077copywmQWz5c$default2;
        long j17 = value6;
        long j18 = value7;
        TextFieldColors m2226inputFieldColorsITpI4ow = m2226inputFieldColorsITpI4ow(j12, j12, m4077copywmQWz5c$default, j13, textSelectionColors2, j14, j15, j16, value5, j17, m4077copywmQWz5c$default3, j18, j18, m4077copywmQWz5c$default4, composer, (i & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344) | (i4 & 458752) | (i4 & 3670016) | (i4 & 29360128) | (i4 & 234881024) | (i4 & 1879048192), i6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2226inputFieldColorsITpI4ow;
    }
}

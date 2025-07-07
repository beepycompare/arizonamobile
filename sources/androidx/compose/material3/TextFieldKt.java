package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020-2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001aì\u0001\u0010/\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u00109\u001ar\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001aR\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u001a\u0010R\u001a\u00020\f*\u00020\f2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0000\u001a\u009a\u0001\u0010V\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010[2\b\u0010]\u001a\u0004\u0018\u00010[2\b\u0010^\u001a\u0004\u0018\u00010[2\b\u0010_\u001a\u0004\u0018\u00010[2\b\u0010`\u001a\u0004\u0018\u00010[2\b\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020$2\u0006\u0010e\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u000204H\u0002\u001a\u0080\u0001\u0010f\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010g\u001a\u00020[2\b\u0010]\u001a\u0004\u0018\u00010[2\b\u0010^\u001a\u0004\u0018\u00010[2\b\u0010_\u001a\u0004\u0018\u00010[2\b\u0010`\u001a\u0004\u0018\u00010[2\b\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002\u001a\u0014\u0010h\u001a\u00020$*\u00020$2\u0006\u0010i\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", TextFieldImplKt.TextFieldId, "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", TtmlNode.RUBY_CONTAINER, "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m6684constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final String str2;
        int i7;
        final Function1<? super String, Unit> function12;
        Modifier.Companion companion;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        Object obj;
        int i10;
        Object obj2;
        int i11;
        Object obj3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        final Shape shape2;
        TextStyle textStyle2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        int i36;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final KeyboardActions keyboardActions2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z7;
        final int i37;
        MutableInteractionSource mutableInteractionSource2;
        final VisualTransformation visualTransformation2;
        final boolean z8;
        int i38;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final boolean z9;
        final KeyboardOptions keyboardOptions2;
        final int i39;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final boolean z10;
        final MutableInteractionSource mutableInteractionSource3;
        long m6177getColor0d7_KjU;
        final TextStyle textStyle3;
        Composer composer2;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final boolean z12;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z13;
        final int i40;
        final int i41;
        final VisualTransformation visualTransformation3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z14;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        int i42;
        Composer startRestartGroup = composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)201@10573L7,217@11369L5,218@11424L8,230@12004L1956,230@11917L2043:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i43 = i6 & 4;
        if (i43 != 0) {
            i7 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i7 |= startRestartGroup.changed(companion) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        obj = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(obj)) ? 131072 : 65536;
                    } else {
                        obj = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        obj2 = function2;
                    } else {
                        obj2 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        obj3 = function22;
                    } else {
                        obj3 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else if ((i3 & 805306368) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i44 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i44 | RendererCapabilities.DECODER_SUPPORT_MASK;
                            } else {
                                int i45 = i44;
                                if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    i45 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i45;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i46 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i46 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i46;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= 805306368;
                                    } else if ((i4 & 805306368) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i42 = 256;
                                            i33 |= i42;
                                        }
                                        i42 = 128;
                                        i33 |= i42;
                                    }
                                    int i47 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i47 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i43 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                i34 = i21 & (-458753);
                                                obj = (TextStyle) consume;
                                            } else {
                                                i34 = i21;
                                            }
                                            if (i10 != 0) {
                                                obj2 = null;
                                            }
                                            if (i11 != 0) {
                                                obj3 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function221 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function222 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i22 != 0 ? null : function27;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.Companion.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.Companion.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i35 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i35 = i;
                                            }
                                            int i48 = i31 != 0 ? 1 : i2;
                                            MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                            Shape shape4 = (i6 & 2097152) != 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            if ((i6 & 4194304) != 0) {
                                                shape2 = shape4;
                                                function28 = function222;
                                                i36 = i27;
                                                function29 = function223;
                                                function210 = function224;
                                                keyboardActions2 = keyboardActions4;
                                                function211 = function225;
                                                z7 = z16;
                                                i37 = i48;
                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                visualTransformation2 = none;
                                                i38 = i34;
                                                function212 = obj2;
                                                function213 = function221;
                                                z9 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i39 = i35;
                                                textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, 6);
                                                textStyle2 = obj;
                                                function214 = obj3;
                                                modifier2 = companion;
                                            } else {
                                                shape2 = shape4;
                                                textStyle2 = obj;
                                                modifier2 = companion;
                                                function28 = function222;
                                                i36 = i27;
                                                function29 = function223;
                                                function210 = function224;
                                                keyboardActions2 = keyboardActions4;
                                                function211 = function225;
                                                z7 = z16;
                                                i37 = i48;
                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                visualTransformation2 = none;
                                                z8 = z6;
                                                i38 = i34;
                                                function212 = obj2;
                                                function213 = function221;
                                                z9 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i39 = i35;
                                                textFieldColors2 = textFieldColors;
                                                function214 = obj3;
                                                z10 = z5;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-676242365, i38, i36, "androidx.compose.material3.TextField (TextField.kt:219)");
                                                }
                                                startRestartGroup.startReplaceGroup(-508515290);
                                                ComposerKt.sourceInformation(startRestartGroup, "221@11518L39");
                                                if (mutableInteractionSource2 != null) {
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -508514639, "CC(remember):TextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup.startReplaceGroup(-508509180);
                                                ComposerKt.sourceInformation(startRestartGroup, "*225@11742L25");
                                                m6177getColor0d7_KjU = textStyle2.m6177getColor0d7_KjU();
                                                if (m6177getColor0d7_KjU == 16) {
                                                    m6177getColor0d7_KjU = textFieldColors2.m2466textColorXeAY9LY$material3_release(z10, z9, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue());
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                final TextStyle merge = textStyle2.merge(new TextStyle(m6177getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i49) {
                                                        ComposerKt.sourceInformation(composer3, "C235@12157L38,253@12960L984,231@12014L1940:TextField.kt#uh7d8r");
                                                        if ((i49 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1859145987, i49, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                                            }
                                                            Modifier modifier3 = Modifier.this;
                                                            boolean z17 = z9;
                                                            Strings.Companion companion2 = Strings.Companion;
                                                            Modifier m769defaultMinSizeVpY3zN4 = SizeKt.m769defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3, z17, Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2484getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2483getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(z9), null);
                                                            String str3 = str2;
                                                            Function1<String, Unit> function13 = function12;
                                                            boolean z18 = z10;
                                                            boolean z19 = z8;
                                                            TextStyle textStyle4 = merge;
                                                            KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                            KeyboardActions keyboardActions5 = keyboardActions2;
                                                            boolean z20 = z7;
                                                            int i50 = i39;
                                                            int i51 = i37;
                                                            VisualTransformation visualTransformation4 = visualTransformation2;
                                                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                                            SolidColor solidColor2 = solidColor;
                                                            final String str4 = str2;
                                                            final boolean z21 = z10;
                                                            final boolean z22 = z7;
                                                            final VisualTransformation visualTransformation5 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                                                            final boolean z23 = z9;
                                                            final Function2<Composer, Integer, Unit> function226 = function212;
                                                            final Function2<Composer, Integer, Unit> function227 = function214;
                                                            final Function2<Composer, Integer, Unit> function228 = function213;
                                                            final Function2<Composer, Integer, Unit> function229 = function28;
                                                            final Function2<Composer, Integer, Unit> function230 = function29;
                                                            final Function2<Composer, Integer, Unit> function231 = function210;
                                                            final Function2<Composer, Integer, Unit> function232 = function211;
                                                            final Shape shape5 = shape2;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            BasicTextFieldKt.BasicTextField(str3, function13, m769defaultMinSizeVpY3zN4, z18, z19, textStyle4, keyboardOptions5, keyboardActions5, z20, i50, i51, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource7, solidColor2, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function233, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function233, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function233, Composer composer4, int i52) {
                                                                    int i53;
                                                                    ComposerKt.sourceInformation(composer4, "C255@13115L811:TextField.kt#uh7d8r");
                                                                    if ((i52 & 6) == 0) {
                                                                        i53 = i52 | (composer4.changedInstance(function233) ? 4 : 2);
                                                                    } else {
                                                                        i53 = i52;
                                                                    }
                                                                    if ((i53 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-288211827, i53, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                                                        }
                                                                        TextFieldDefaults.INSTANCE.DecorationBox(str4, function233, z21, z22, visualTransformation5, mutableInteractionSource8, z23, function226, function227, function228, function229, function230, function231, function232, shape5, textFieldColors4, null, null, composer4, (i53 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }, composer3, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle3 = textStyle2;
                                                composer2 = startRestartGroup;
                                                textFieldColors3 = textFieldColors2;
                                                z11 = z10;
                                                z12 = z8;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z13 = z7;
                                                i40 = i39;
                                                i41 = i37;
                                                visualTransformation3 = visualTransformation2;
                                                function215 = function212;
                                                function216 = function214;
                                                function217 = function29;
                                                function218 = function210;
                                                function219 = function211;
                                                shape3 = shape2;
                                                mutableInteractionSource4 = mutableInteractionSource2;
                                                z14 = z9;
                                                function220 = function28;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i38 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            function213 = function23;
                                            function28 = function24;
                                            function29 = function25;
                                            function210 = function26;
                                            function211 = function27;
                                            visualTransformation2 = visualTransformation;
                                            keyboardOptions2 = keyboardOptions;
                                            z7 = z4;
                                            i39 = i;
                                            i37 = i2;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            shape2 = shape;
                                            textFieldColors2 = textFieldColors;
                                            textStyle2 = obj;
                                            function212 = obj2;
                                            function214 = obj3;
                                            modifier2 = companion;
                                            i36 = i27;
                                            z9 = z3;
                                            keyboardActions2 = keyboardActions;
                                        }
                                        z10 = z5;
                                        z8 = z6;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceGroup(-508515290);
                                        ComposerKt.sourceInformation(startRestartGroup, "221@11518L39");
                                        if (mutableInteractionSource2 != null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        startRestartGroup.startReplaceGroup(-508509180);
                                        ComposerKt.sourceInformation(startRestartGroup, "*225@11742L25");
                                        m6177getColor0d7_KjU = textStyle2.m6177getColor0d7_KjU();
                                        if (m6177getColor0d7_KjU == 16) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final TextStyle merge2 = textStyle2.merge(new TextStyle(m6177getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i49) {
                                                ComposerKt.sourceInformation(composer3, "C235@12157L38,253@12960L984,231@12014L1940:TextField.kt#uh7d8r");
                                                if ((i49 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1859145987, i49, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                                    }
                                                    Modifier modifier3 = Modifier.this;
                                                    boolean z17 = z9;
                                                    Strings.Companion companion2 = Strings.Companion;
                                                    Modifier m769defaultMinSizeVpY3zN4 = SizeKt.m769defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3, z17, Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2484getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2483getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(z9), null);
                                                    String str3 = str2;
                                                    Function1<String, Unit> function13 = function12;
                                                    boolean z18 = z10;
                                                    boolean z19 = z8;
                                                    TextStyle textStyle4 = merge2;
                                                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                    KeyboardActions keyboardActions5 = keyboardActions2;
                                                    boolean z20 = z7;
                                                    int i50 = i39;
                                                    int i51 = i37;
                                                    VisualTransformation visualTransformation4 = visualTransformation2;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                                    SolidColor solidColor2 = solidColor;
                                                    final String str4 = str2;
                                                    final boolean z21 = z10;
                                                    final boolean z22 = z7;
                                                    final VisualTransformation visualTransformation5 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                                                    final boolean z23 = z9;
                                                    final Function2<? super Composer, ? super Integer, Unit> function226 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function227 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function228 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function28;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function29;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function210;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function211;
                                                    final Shape shape5 = shape2;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    BasicTextFieldKt.BasicTextField(str3, function13, m769defaultMinSizeVpY3zN4, z18, z19, textStyle4, keyboardOptions5, keyboardActions5, z20, i50, i51, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource7, solidColor2, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function233, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function233, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function233, Composer composer4, int i52) {
                                                            int i53;
                                                            ComposerKt.sourceInformation(composer4, "C255@13115L811:TextField.kt#uh7d8r");
                                                            if ((i52 & 6) == 0) {
                                                                i53 = i52 | (composer4.changedInstance(function233) ? 4 : 2);
                                                            } else {
                                                                i53 = i52;
                                                            }
                                                            if ((i53 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-288211827, i53, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                                                }
                                                                TextFieldDefaults.INSTANCE.DecorationBox(str4, function233, z21, z22, visualTransformation5, mutableInteractionSource8, z23, function226, function227, function228, function229, function230, function231, function232, shape5, textFieldColors4, null, null, composer4, (i53 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle3 = textStyle2;
                                        composer2 = startRestartGroup;
                                        textFieldColors3 = textFieldColors2;
                                        z11 = z10;
                                        z12 = z8;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z13 = z7;
                                        i40 = i39;
                                        i41 = i37;
                                        visualTransformation3 = visualTransformation2;
                                        function215 = function212;
                                        function216 = function214;
                                        function217 = function29;
                                        function218 = function210;
                                        function219 = function211;
                                        shape3 = shape2;
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        z14 = z9;
                                        function220 = function28;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function213 = function23;
                                        function217 = function25;
                                        function218 = function26;
                                        function219 = function27;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z13 = z4;
                                        i40 = i;
                                        i41 = i2;
                                        mutableInteractionSource4 = mutableInteractionSource;
                                        shape3 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z11 = z5;
                                        z12 = z6;
                                        textStyle3 = obj;
                                        function215 = obj2;
                                        function216 = obj3;
                                        modifier2 = companion;
                                        function220 = function24;
                                        z14 = z3;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier3 = modifier2;
                                        final Function2<? super Composer, ? super Integer, Unit> function226 = function213;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i49) {
                                                TextFieldKt.TextField(str, function1, modifier3, z11, z12, textStyle3, function215, function216, function226, function220, function217, function218, function219, z14, visualTransformation3, keyboardOptions3, keyboardActions3, z13, i40, i41, mutableInteractionSource4, shape3, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            }
                            int i472 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i43 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 == 0) {
                            }
                            if ((i6 & 2097152) != 0) {
                            }
                            MutableInteractionSource mutableInteractionSource62 = mutableInteractionSource5;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i442 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        }
                        int i4722 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i43 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 == 0) {
                        }
                        if ((i6 & 2097152) != 0) {
                        }
                        MutableInteractionSource mutableInteractionSource622 = mutableInteractionSource5;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4422 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    }
                    int i47222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i43 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 == 0) {
                    }
                    if ((i6 & 2097152) != 0) {
                    }
                    MutableInteractionSource mutableInteractionSource6222 = mutableInteractionSource5;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i44222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                }
                int i472222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i43 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 == 0) {
                }
                if ((i6 & 2097152) != 0) {
                }
                MutableInteractionSource mutableInteractionSource62222 = mutableInteractionSource5;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i442222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            }
            int i4722222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i43 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 == 0) {
            }
            if ((i6 & 2097152) != 0) {
            }
            MutableInteractionSource mutableInteractionSource622222 = mutableInteractionSource5;
            if ((i6 & 4194304) != 0) {
            }
        }
        companion = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4422222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        int i47222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i43 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 == 0) {
        }
        if ((i6 & 2097152) != 0) {
        }
        MutableInteractionSource mutableInteractionSource6222222 = mutableInteractionSource5;
        if ((i6 & 4194304) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final TextFieldValue textFieldValue2;
        int i7;
        final Function1<? super TextFieldValue, Unit> function12;
        Modifier.Companion companion;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        Object obj;
        int i10;
        Object obj2;
        int i11;
        Object obj3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        final Shape shape2;
        TextStyle textStyle2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        int i36;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final KeyboardActions keyboardActions2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z7;
        final int i37;
        MutableInteractionSource mutableInteractionSource2;
        final VisualTransformation visualTransformation2;
        final boolean z8;
        int i38;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final boolean z9;
        final KeyboardOptions keyboardOptions2;
        final int i39;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final boolean z10;
        final MutableInteractionSource mutableInteractionSource3;
        long m6177getColor0d7_KjU;
        final TextStyle textStyle3;
        Composer composer2;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final boolean z12;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z13;
        final int i40;
        final int i41;
        final VisualTransformation visualTransformation3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z14;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        int i42;
        Composer startRestartGroup = composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)357@19138L7,373@19934L5,374@19989L8,386@20569L1961,386@20482L2048:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(textFieldValue2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i43 = i6 & 4;
        if (i43 != 0) {
            i7 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i7 |= startRestartGroup.changed(companion) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        obj = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(obj)) ? 131072 : 65536;
                    } else {
                        obj = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        obj2 = function2;
                    } else {
                        obj2 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        obj3 = function22;
                    } else {
                        obj3 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else if ((i3 & 805306368) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i44 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i44 | RendererCapabilities.DECODER_SUPPORT_MASK;
                            } else {
                                int i45 = i44;
                                if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    i45 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i45;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i46 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i46 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i46;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= 805306368;
                                    } else if ((i4 & 805306368) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i42 = 256;
                                            i33 |= i42;
                                        }
                                        i42 = 128;
                                        i33 |= i42;
                                    }
                                    int i47 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i47 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i43 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                i34 = i21 & (-458753);
                                                obj = (TextStyle) consume;
                                            } else {
                                                i34 = i21;
                                            }
                                            if (i10 != 0) {
                                                obj2 = null;
                                            }
                                            if (i11 != 0) {
                                                obj3 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function221 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function222 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i22 != 0 ? null : function27;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.Companion.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.Companion.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i35 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i35 = i;
                                            }
                                            int i48 = i31 != 0 ? 1 : i2;
                                            MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                            Shape shape4 = (i6 & 2097152) != 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            if ((i6 & 4194304) != 0) {
                                                shape2 = shape4;
                                                function28 = function222;
                                                i36 = i27;
                                                function29 = function223;
                                                function210 = function224;
                                                keyboardActions2 = keyboardActions4;
                                                function211 = function225;
                                                z7 = z16;
                                                i37 = i48;
                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                visualTransformation2 = none;
                                                i38 = i34;
                                                function212 = obj2;
                                                function213 = function221;
                                                z9 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i39 = i35;
                                                textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, 6);
                                                textStyle2 = obj;
                                                function214 = obj3;
                                                modifier2 = companion;
                                            } else {
                                                shape2 = shape4;
                                                textStyle2 = obj;
                                                modifier2 = companion;
                                                function28 = function222;
                                                i36 = i27;
                                                function29 = function223;
                                                function210 = function224;
                                                keyboardActions2 = keyboardActions4;
                                                function211 = function225;
                                                z7 = z16;
                                                i37 = i48;
                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                visualTransformation2 = none;
                                                z8 = z6;
                                                i38 = i34;
                                                function212 = obj2;
                                                function213 = function221;
                                                z9 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i39 = i35;
                                                textFieldColors2 = textFieldColors;
                                                function214 = obj3;
                                                z10 = z5;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1268528240, i38, i36, "androidx.compose.material3.TextField (TextField.kt:375)");
                                                }
                                                startRestartGroup.startReplaceGroup(-508241210);
                                                ComposerKt.sourceInformation(startRestartGroup, "377@20083L39");
                                                if (mutableInteractionSource2 != null) {
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -508240559, "CC(remember):TextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup.startReplaceGroup(-508235100);
                                                ComposerKt.sourceInformation(startRestartGroup, "*381@20307L25");
                                                m6177getColor0d7_KjU = textStyle2.m6177getColor0d7_KjU();
                                                if (m6177getColor0d7_KjU == 16) {
                                                    m6177getColor0d7_KjU = textFieldColors2.m2466textColorXeAY9LY$material3_release(z10, z9, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue());
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                final TextStyle merge = textStyle2.merge(new TextStyle(m6177getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i49) {
                                                        ComposerKt.sourceInformation(composer3, "C391@20722L38,409@21525L989,387@20579L1945:TextField.kt#uh7d8r");
                                                        if ((i49 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1163788208, i49, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:387)");
                                                            }
                                                            Modifier modifier3 = Modifier.this;
                                                            boolean z17 = z9;
                                                            Strings.Companion companion2 = Strings.Companion;
                                                            Modifier m769defaultMinSizeVpY3zN4 = SizeKt.m769defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3, z17, Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2484getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2483getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(z9), null);
                                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                                            Function1<TextFieldValue, Unit> function13 = function12;
                                                            boolean z18 = z10;
                                                            boolean z19 = z8;
                                                            TextStyle textStyle4 = merge;
                                                            KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                            KeyboardActions keyboardActions5 = keyboardActions2;
                                                            boolean z20 = z7;
                                                            int i50 = i39;
                                                            int i51 = i37;
                                                            VisualTransformation visualTransformation4 = visualTransformation2;
                                                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                                            SolidColor solidColor2 = solidColor;
                                                            final TextFieldValue textFieldValue4 = textFieldValue2;
                                                            final boolean z21 = z10;
                                                            final boolean z22 = z7;
                                                            final VisualTransformation visualTransformation5 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                                                            final boolean z23 = z9;
                                                            final Function2<Composer, Integer, Unit> function226 = function212;
                                                            final Function2<Composer, Integer, Unit> function227 = function214;
                                                            final Function2<Composer, Integer, Unit> function228 = function213;
                                                            final Function2<Composer, Integer, Unit> function229 = function28;
                                                            final Function2<Composer, Integer, Unit> function230 = function29;
                                                            final Function2<Composer, Integer, Unit> function231 = function210;
                                                            final Function2<Composer, Integer, Unit> function232 = function211;
                                                            final Shape shape5 = shape2;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            BasicTextFieldKt.BasicTextField(textFieldValue3, function13, m769defaultMinSizeVpY3zN4, z18, z19, textStyle4, keyboardOptions5, keyboardActions5, z20, i50, i51, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource7, solidColor2, ComposableLambdaKt.rememberComposableLambda(1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function233, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function233, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function233, Composer composer4, int i52) {
                                                                    int i53;
                                                                    ComposerKt.sourceInformation(composer4, "C411@21680L816:TextField.kt#uh7d8r");
                                                                    if ((i52 & 6) == 0) {
                                                                        i53 = i52 | (composer4.changedInstance(function233) ? 4 : 2);
                                                                    } else {
                                                                        i53 = i52;
                                                                    }
                                                                    if ((i53 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1751957978, i53, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:411)");
                                                                        }
                                                                        TextFieldDefaults.INSTANCE.DecorationBox(TextFieldValue.this.getText(), function233, z21, z22, visualTransformation5, mutableInteractionSource8, z23, function226, function227, function228, function229, function230, function231, function232, shape5, textFieldColors4, null, null, composer4, (i53 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }, composer3, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle3 = textStyle2;
                                                composer2 = startRestartGroup;
                                                textFieldColors3 = textFieldColors2;
                                                z11 = z10;
                                                z12 = z8;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z13 = z7;
                                                i40 = i39;
                                                i41 = i37;
                                                visualTransformation3 = visualTransformation2;
                                                function215 = function212;
                                                function216 = function214;
                                                function217 = function29;
                                                function218 = function210;
                                                function219 = function211;
                                                shape3 = shape2;
                                                mutableInteractionSource4 = mutableInteractionSource2;
                                                z14 = z9;
                                                function220 = function28;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i38 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            function213 = function23;
                                            function28 = function24;
                                            function29 = function25;
                                            function210 = function26;
                                            function211 = function27;
                                            visualTransformation2 = visualTransformation;
                                            keyboardOptions2 = keyboardOptions;
                                            z7 = z4;
                                            i39 = i;
                                            i37 = i2;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            shape2 = shape;
                                            textFieldColors2 = textFieldColors;
                                            textStyle2 = obj;
                                            function212 = obj2;
                                            function214 = obj3;
                                            modifier2 = companion;
                                            i36 = i27;
                                            z9 = z3;
                                            keyboardActions2 = keyboardActions;
                                        }
                                        z10 = z5;
                                        z8 = z6;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceGroup(-508241210);
                                        ComposerKt.sourceInformation(startRestartGroup, "377@20083L39");
                                        if (mutableInteractionSource2 != null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        startRestartGroup.startReplaceGroup(-508235100);
                                        ComposerKt.sourceInformation(startRestartGroup, "*381@20307L25");
                                        m6177getColor0d7_KjU = textStyle2.m6177getColor0d7_KjU();
                                        if (m6177getColor0d7_KjU == 16) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final TextStyle merge2 = textStyle2.merge(new TextStyle(m6177getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i49) {
                                                ComposerKt.sourceInformation(composer3, "C391@20722L38,409@21525L989,387@20579L1945:TextField.kt#uh7d8r");
                                                if ((i49 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1163788208, i49, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:387)");
                                                    }
                                                    Modifier modifier3 = Modifier.this;
                                                    boolean z17 = z9;
                                                    Strings.Companion companion2 = Strings.Companion;
                                                    Modifier m769defaultMinSizeVpY3zN4 = SizeKt.m769defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3, z17, Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2484getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2483getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.m2416cursorColorvNxB06k$material3_release(z9), null);
                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                    Function1<TextFieldValue, Unit> function13 = function12;
                                                    boolean z18 = z10;
                                                    boolean z19 = z8;
                                                    TextStyle textStyle4 = merge2;
                                                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                    KeyboardActions keyboardActions5 = keyboardActions2;
                                                    boolean z20 = z7;
                                                    int i50 = i39;
                                                    int i51 = i37;
                                                    VisualTransformation visualTransformation4 = visualTransformation2;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                                    SolidColor solidColor2 = solidColor;
                                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                                    final boolean z21 = z10;
                                                    final boolean z22 = z7;
                                                    final VisualTransformation visualTransformation5 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                                                    final boolean z23 = z9;
                                                    final Function2<? super Composer, ? super Integer, Unit> function226 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function227 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function228 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function28;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function29;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function210;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function211;
                                                    final Shape shape5 = shape2;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    BasicTextFieldKt.BasicTextField(textFieldValue3, function13, m769defaultMinSizeVpY3zN4, z18, z19, textStyle4, keyboardOptions5, keyboardActions5, z20, i50, i51, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource7, solidColor2, ComposableLambdaKt.rememberComposableLambda(1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function233, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function233, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function233, Composer composer4, int i52) {
                                                            int i53;
                                                            ComposerKt.sourceInformation(composer4, "C411@21680L816:TextField.kt#uh7d8r");
                                                            if ((i52 & 6) == 0) {
                                                                i53 = i52 | (composer4.changedInstance(function233) ? 4 : 2);
                                                            } else {
                                                                i53 = i52;
                                                            }
                                                            if ((i53 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1751957978, i53, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:411)");
                                                                }
                                                                TextFieldDefaults.INSTANCE.DecorationBox(TextFieldValue.this.getText(), function233, z21, z22, visualTransformation5, mutableInteractionSource8, z23, function226, function227, function228, function229, function230, function231, function232, shape5, textFieldColors4, null, null, composer4, (i53 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle3 = textStyle2;
                                        composer2 = startRestartGroup;
                                        textFieldColors3 = textFieldColors2;
                                        z11 = z10;
                                        z12 = z8;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z13 = z7;
                                        i40 = i39;
                                        i41 = i37;
                                        visualTransformation3 = visualTransformation2;
                                        function215 = function212;
                                        function216 = function214;
                                        function217 = function29;
                                        function218 = function210;
                                        function219 = function211;
                                        shape3 = shape2;
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        z14 = z9;
                                        function220 = function28;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function213 = function23;
                                        function217 = function25;
                                        function218 = function26;
                                        function219 = function27;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z13 = z4;
                                        i40 = i;
                                        i41 = i2;
                                        mutableInteractionSource4 = mutableInteractionSource;
                                        shape3 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z11 = z5;
                                        z12 = z6;
                                        textStyle3 = obj;
                                        function215 = obj2;
                                        function216 = obj3;
                                        modifier2 = companion;
                                        function220 = function24;
                                        z14 = z3;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier3 = modifier2;
                                        final Function2<? super Composer, ? super Integer, Unit> function226 = function213;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$4
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i49) {
                                                TextFieldKt.TextField(TextFieldValue.this, function1, modifier3, z11, z12, textStyle3, function215, function216, function226, function220, function217, function218, function219, z14, visualTransformation3, keyboardOptions3, keyboardActions3, z13, i40, i41, mutableInteractionSource4, shape3, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            }
                            int i472 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i43 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 == 0) {
                            }
                            if ((i6 & 2097152) != 0) {
                            }
                            MutableInteractionSource mutableInteractionSource62 = mutableInteractionSource5;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i442 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        }
                        int i4722 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i43 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 == 0) {
                        }
                        if ((i6 & 2097152) != 0) {
                        }
                        MutableInteractionSource mutableInteractionSource622 = mutableInteractionSource5;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4422 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    }
                    int i47222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i43 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 == 0) {
                    }
                    if ((i6 & 2097152) != 0) {
                    }
                    MutableInteractionSource mutableInteractionSource6222 = mutableInteractionSource5;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i44222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                }
                int i472222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i43 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 == 0) {
                }
                if ((i6 & 2097152) != 0) {
                }
                MutableInteractionSource mutableInteractionSource62222 = mutableInteractionSource5;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i442222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            }
            int i4722222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i43 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 == 0) {
            }
            if ((i6 & 2097152) != 0) {
            }
            MutableInteractionSource mutableInteractionSource622222 = mutableInteractionSource5;
            if ((i6 & 4194304) != 0) {
            }
        }
        companion = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4422222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        int i47222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i43 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 == 0) {
        }
        if ((i6 & 2097152) != 0) {
        }
        MutableInteractionSource mutableInteractionSource6222222 = mutableInteractionSource5;
        if ((i6 & 4194304) != 0) {
        }
    }

    public static final void TextFieldLayout(final Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z, float f, final Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        float f2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final float f3 = f;
        Composer startRestartGroup = composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)455@23228L147,458@23423L7,459@23435L4118:TextField.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changed(f3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i6 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function27) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function28) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        int i7 = i4;
        if ((i6 & 306783379) != 306783378 || (i7 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i6, i7, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1052646361, "CC(remember):TextField.kt#9igjgp");
            boolean z2 = ((i6 & 1879048192) == 536870912) | ((234881024 & i6) == 67108864) | ((i7 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z, f3, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1362557328, "C465@23754L11,550@26868L187:TextField.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf(i7 & 14));
            startRestartGroup.startReplaceGroup(1341517187);
            ComposerKt.sourceInformation(startRestartGroup, "468@23818L219");
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -948431736, "C472@24010L9:TextField.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf((i6 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341526310);
            ComposerKt.sourceInformation(startRestartGroup, "476@24104L221");
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -948147001, "C480@24297L10:TextField.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i6 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                i5 = 0;
                calculateStartPadding = Dp.m6684constructorimpl(RangesKt.coerceAtLeast(Dp.m6684constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6684constructorimpl(0)));
            } else {
                i5 = 0;
            }
            float f4 = calculateStartPadding;
            if (function24 != null) {
                calculateEndPadding = Dp.m6684constructorimpl(RangesKt.coerceAtLeast(Dp.m6684constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6684constructorimpl(i5)));
            }
            startRestartGroup.startReplaceGroup(1341556924);
            ComposerKt.sourceInformation(startRestartGroup, "501@25056L309");
            if (function25 != null) {
                Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m773heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), f4, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -947113399, "C507@25339L8:TextField.kt#uh7d8r");
                function25.invoke(startRestartGroup, Integer.valueOf((i6 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341568890);
            ComposerKt.sourceInformation(startRestartGroup, "511@25430L307");
            if (function26 != null) {
                float f5 = calculateEndPadding;
                Modifier m742paddingqDBjuR0$default2 = PaddingKt.m742paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m773heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f5, 0.0f, 10, null);
                f2 = f5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl5 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl5, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl5.getInserting() || !Intrinsics.areEqual(m3520constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m3520constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m3520constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m3527setimpl(m3520constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -946744375, "C517@25711L8:TextField.kt#uh7d8r");
                function26.invoke(startRestartGroup, Integer.valueOf((i6 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                f2 = calculateEndPadding;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341581092);
            ComposerKt.sourceInformation(startRestartGroup, "522@25802L574");
            if (function22 != null) {
                f3 = f;
                Modifier m742paddingqDBjuR0$default3 = PaddingKt.m742paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m773heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId), DpKt.m6727lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f3), 0.0f, 2, null), null, false, 3, null), f4, 0.0f, f2, 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default3);
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl6 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl6, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl6.getInserting() || !Intrinsics.areEqual(m3520constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    m3520constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    m3520constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m3527setimpl(m3520constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -946109526, "C535@26351L7:TextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                f3 = f;
            }
            startRestartGroup.endReplaceGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m773heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                f4 = Dp.m6684constructorimpl(0);
            }
            Modifier m742paddingqDBjuR0$default4 = PaddingKt.m742paddingqDBjuR0$default(wrapContentHeight$default, f4, 0.0f, function26 == null ? f2 : Dp.m6684constructorimpl(0), 0.0f, 10, null);
            startRestartGroup.startReplaceGroup(1341611627);
            ComposerKt.sourceInformation(startRestartGroup, "548@26778L63");
            if (function3 != null) {
                function32 = function3;
                function32.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(m742paddingqDBjuR0$default4), startRestartGroup, Integer.valueOf((i6 >> 6) & 112));
            } else {
                function32 = function3;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(m742paddingqDBjuR0$default4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, then3);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl7 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl7, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl7.getInserting() || !Intrinsics.areEqual(m3520constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m3520constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m3520constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3527setimpl(m3520constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -945435834, "C554@27030L11:TextField.kt#uh7d8r");
            function29 = function2;
            function29.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(1341622624);
            ComposerKt.sourceInformation(startRestartGroup, "559@27167L317");
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m773heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2474supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl8 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl8, maybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl8.getInserting() || !Intrinsics.areEqual(m3520constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m3520constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m3520constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m3527setimpl(m3520constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -945015195, "C565@27454L12:TextField.kt#uh7d8r");
                function210 = function28;
                function210.invoke(startRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function210 = function28;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function29 = function2;
            function210 = function28;
            function32 = function3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function32;
            final PaddingValues paddingValues3 = paddingValues2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextFieldLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    TextFieldKt.TextFieldLayout(Modifier.this, function29, function22, function33, function23, function24, function25, function26, z, f3, function27, function210, paddingValues3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y  reason: not valid java name */
    public static final int m2495calculateWidthyeHjK3Y(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, i6)) + i2, Constraints.m6639getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc  reason: not valid java name */
    public static final int m2494calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        boolean z = i2 > 0;
        float m6684constructorimpl = Dp.m6684constructorimpl(paddingValues.mo690calculateTopPaddingD9Ej5fM() + paddingValues.mo687calculateBottomPaddingD9Ej5fM()) * f2;
        if (z) {
            m6684constructorimpl = MathHelpersKt.lerp(Dp.m6684constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2) * f2, m6684constructorimpl, f);
        }
        return Math.max(Constraints.m6638getMinHeightimpl(j), Math.max(i3, Math.max(i4, MathKt.roundToInt(m6684constructorimpl + MathHelpersKt.lerp(0, i2, f) + ComparisonsKt.maxOf(i, i7, i5, i6, MathHelpersKt.lerp(i2, 0, f))))) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z, int i3, int i4, float f, float f2) {
        int roundToInt;
        Placeable.PlacementScope.m5502place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m6823getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), heightOrZero);
            } else {
                roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt - MathKt.roundToInt((roundToInt - i3) * f), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, i4, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i4, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z, float f, PaddingValues paddingValues) {
        Placeable.PlacementScope.m5502place70tqf50$default(placementScope, placeable7, IntOffset.Companion.m6823getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable8);
        int roundToInt = MathKt.roundToInt(paddingValues.mo690calculateTopPaddingD9Ej5fM() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable5), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable5) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable) {
        return z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final State<BorderStroke> state) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                float f = contentDrawScope.mo389toPx0680j_4(state.getValue().m273getWidthD9Ej5fM());
                float m3903getHeightimpl = Size.m3903getHeightimpl(contentDrawScope.mo4640getSizeNHjbRc()) - (f / 2);
                DrawScope.m4625drawLine1RTmtNc$default(contentDrawScope, state.getValue().getBrush(), OffsetKt.Offset(0.0f, m3903getHeightimpl), OffsetKt.Offset(Size.m3906getWidthimpl(contentDrawScope.mo4640getSizeNHjbRc()), m3903getHeightimpl), f, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}

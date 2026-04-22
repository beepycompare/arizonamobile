package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;J\u009c\u0002\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>2\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010CJ5\u00101\u001a\u0002022\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t¢\u0006\u0004\bH\u0010IJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010JJ¿\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u0010O\u001a\u00020L2\b\b\u0002\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020L2\b\b\u0002\u0010R\u001a\u00020L2\b\b\u0002\u0010S\u001a\u00020L2\b\b\u0002\u0010T\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020L2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020L2\b\b\u0002\u0010Y\u001a\u00020L2\b\b\u0002\u0010Z\u001a\u00020L2\b\b\u0002\u0010[\u001a\u00020L2\b\b\u0002\u0010\\\u001a\u00020L2\b\b\u0002\u0010]\u001a\u00020L2\b\b\u0002\u0010^\u001a\u00020L2\b\b\u0002\u0010_\u001a\u00020L2\b\b\u0002\u0010`\u001a\u00020L2\b\b\u0002\u0010a\u001a\u00020L2\b\b\u0002\u0010b\u001a\u00020L2\b\b\u0002\u0010c\u001a\u00020L2\b\b\u0002\u0010d\u001a\u00020L2\b\b\u0002\u0010e\u001a\u00020L2\b\b\u0002\u0010f\u001a\u00020L2\b\b\u0002\u0010g\u001a\u00020L2\b\b\u0002\u0010h\u001a\u00020L2\b\b\u0002\u0010i\u001a\u00020L2\b\b\u0002\u0010j\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020L2\b\b\u0002\u0010n\u001a\u00020L2\b\b\u0002\u0010o\u001a\u00020L2\b\b\u0002\u0010p\u001a\u00020L2\b\b\u0002\u0010q\u001a\u00020L2\b\b\u0002\u0010r\u001a\u00020L2\b\b\u0002\u0010s\u001a\u00020L2\b\b\u0002\u0010t\u001a\u00020L2\b\b\u0002\u0010u\u001a\u00020L2\b\b\u0002\u0010v\u001a\u00020L2\b\b\u0002\u0010w\u001a\u00020LH\u0007¢\u0006\u0004\bx\u0010yJP\u0010~\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0018\u0010z\u001a\u000200*\u00020{8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", TtmlNode.RUBY_CONTAINER, "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", TextFieldImplKt.ContainerId, "modifier", "Landroidx/compose/ui/Modifier;", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", TtmlNode.START, "top", TtmlNode.END, "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m7555constructorimpl(56.0f);
    private static final float MinWidth = Dp.m7555constructorimpl(280.0f);
    private static final float UnfocusedBorderThickness = Dp.m7555constructorimpl(1.0f);
    private static final float FocusedBorderThickness = Dp.m7555constructorimpl(2.0f);

    public static final Unit ContainerBox_nbWgWpA$lambda$7(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m2347ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m2346Container4EFweAY(z, z2, interactionSource, modifier, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit DecorationBox$lambda$3(OutlinedTextFieldDefaults outlinedTextFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, Function2 function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function29, int i, int i2, int i3, Composer composer, int i4) {
        outlinedTextFieldDefaults.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, function26, function27, function28, textFieldColors, paddingValues, function29, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1066756961, "C(<get-shape>)887@46101L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:887)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM */
    public final float m2351getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM */
    public final float m2352getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM */
    public final float m2353getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM */
    public final float m2350getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    public final TextFieldDecorator decorator(TextFieldState textFieldState, boolean z, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, InteractionSource interactionSource, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z2, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, Composer composer, int i, int i2, int i3) {
        OutlinedTextFieldDefaults outlinedTextFieldDefaults;
        final TextFieldColors textFieldColors2;
        final boolean z3;
        final InteractionSource interactionSource2;
        boolean z4;
        ComposableLambda composableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -449059361, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)980@51820L8,982@51932L371:TextFieldDefaults.kt#uh7d8r");
        TextFieldLabelPosition.Attached attached = (i3 & 32) != 0 ? new TextFieldLabelPosition.Attached(false, null, null, 7, null) : textFieldLabelPosition;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32 = (i3 & 64) != 0 ? null : function3;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i3 & 128) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function29 = (i3 & 256) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function210 = (i3 & 512) != 0 ? null : function23;
        Function2<? super Composer, ? super Integer, Unit> function211 = (i3 & 1024) != 0 ? null : function24;
        Function2<? super Composer, ? super Integer, Unit> function212 = (i3 & 2048) != 0 ? null : function25;
        Function2<? super Composer, ? super Integer, Unit> function213 = (i3 & 4096) != 0 ? null : function26;
        final boolean z5 = (i3 & 8192) != 0 ? false : z2;
        if ((i3 & 16384) != 0) {
            outlinedTextFieldDefaults = this;
            textFieldColors2 = outlinedTextFieldDefaults.colors(composer, (i2 >> 21) & 14);
        } else {
            outlinedTextFieldDefaults = this;
            textFieldColors2 = textFieldColors;
        }
        PaddingValues m2345contentPaddinga9UjIt4$default = (32768 & i3) != 0 ? m2345contentPaddinga9UjIt4$default(outlinedTextFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
        if ((i3 & 65536) != 0) {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            composableLambda = ComposableLambdaKt.rememberComposableLambda(-163468598, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C988@52139L5,983@51946L347:TextFieldDefaults.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-163468598, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<anonymous> (TextFieldDefaults.kt:983)");
                    }
                    OutlinedTextFieldDefaults.INSTANCE.m2346Container4EFweAY(z3, z5, interactionSource2, null, textFieldColors2, OutlinedTextFieldDefaults.INSTANCE.getShape(composer2, 6), OutlinedTextFieldDefaults.INSTANCE.m2350getFocusedBorderThicknessD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2353getUnfocusedBorderThicknessD9Ej5fM(), composer2, 114819072, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
        } else {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            composableLambda = function27;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449059361, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator (TextFieldDefaults.kt:993)");
        }
        OutlinedTextFieldDefaults$decorator$2 outlinedTextFieldDefaults$decorator$2 = new OutlinedTextFieldDefaults$decorator$2(outputTransformation, textFieldState, textFieldLineLimits, attached, function32, function28, function29, function210, function211, function212, function213, z3, z4, interactionSource2, m2345contentPaddinga9UjIt4$default, textFieldColors2, composableLambda);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return outlinedTextFieldDefaults$decorator$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /* renamed from: Container-4EFweAY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2346Container4EFweAY(final boolean z, final boolean z2, final InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        Object obj3;
        float f3;
        float f4;
        Composer composer2;
        final Modifier modifier2;
        final TextFieldColors textFieldColors2;
        final Shape shape2;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        TextFieldColors textFieldColors3;
        Shape shape3;
        float f7;
        Modifier modifier3;
        int i4;
        TextFieldColors textFieldColors4;
        Shape shape4;
        float f8;
        float f9;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1035477640);
        ComposerKt.sourceInformation(startRestartGroup, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1055@55084L25,1057@55155L222,1069@55662L7,1067@55495L189,1071@55693L153:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj2 = textFieldColors;
                    if (startRestartGroup.changed(obj2)) {
                        i8 = 16384;
                        i3 |= i8;
                    }
                } else {
                    obj2 = textFieldColors;
                }
                i8 = 8192;
                i3 |= i8;
            } else {
                obj2 = textFieldColors;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = shape;
                    if (startRestartGroup.changed(obj3)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    obj3 = shape;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                obj3 = shape;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    f3 = f;
                    if (startRestartGroup.changed(f3)) {
                        i6 = 1048576;
                        i3 |= i6;
                    }
                } else {
                    f3 = f;
                }
                i6 = 524288;
                i3 |= i6;
            } else {
                f3 = f;
            }
            if ((12582912 & i) != 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    if (startRestartGroup.changed(f4)) {
                        i5 = 8388608;
                        i3 |= i5;
                    }
                } else {
                    f4 = f2;
                }
                i5 = 4194304;
                i3 |= i5;
            } else {
                f4 = f2;
            }
            if ((i2 & 256) == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i3 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
            }
            if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "1050@54844L8,1051@54903L5");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    i4 = i3;
                    textFieldColors4 = obj2;
                    f8 = f3;
                    shape4 = obj3;
                    modifier3 = obj;
                } else {
                    Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                    if ((i2 & 16) != 0) {
                        textFieldColors3 = colors(startRestartGroup, (i3 >> 24) & 14);
                        i3 &= -57345;
                    } else {
                        textFieldColors3 = obj2;
                    }
                    if ((i2 & 32) != 0) {
                        shape3 = INSTANCE.getShape(startRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        shape3 = obj3;
                    }
                    if ((i2 & 64) != 0) {
                        f7 = FocusedBorderThickness;
                        i3 &= -3670017;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        shape4 = shape3;
                        f9 = UnfocusedBorderThickness;
                        modifier3 = companion;
                        i4 = i3 & (-29360129);
                        textFieldColors4 = textFieldColors3;
                        f8 = f7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035477640, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1054)");
                        }
                        int i10 = i4 >> 6;
                        boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, i10 & 14).getValue().booleanValue();
                        State<BorderStroke> m3095animateBorderStrokeAsStateNuRrP5Q = TextFieldImplKt.m3095animateBorderStrokeAsStateNuRrP5Q(z, z2, booleanValue, textFieldColors4, f8, f9, startRestartGroup, (i10 & 458752) | ((i4 >> 3) & 7168) | (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (57344 & i10));
                        Modifier modifier4 = modifier3;
                        Shape shape5 = shape4;
                        composer2 = startRestartGroup;
                        BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier4, m3095animateBorderStrokeAsStateNuRrP5Q.getValue(), shape5), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(textFieldColors4.m2627containerColorXeAY9LY$material3(z, z2, booleanValue), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6), null, null, startRestartGroup, 0, 12)) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                            public Object get() {
                                return ((State) this.receiver).getValue();
                            }
                        }), shape5), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = f8;
                        f6 = f9;
                        shape2 = shape5;
                        textFieldColors2 = textFieldColors4;
                        modifier2 = modifier4;
                    } else {
                        modifier3 = companion;
                        i4 = i3;
                        textFieldColors4 = textFieldColors3;
                        shape4 = shape3;
                        f8 = f7;
                    }
                }
                f9 = f4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i102 = i4 >> 6;
                boolean booleanValue2 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, i102 & 14).getValue().booleanValue();
                State<BorderStroke> m3095animateBorderStrokeAsStateNuRrP5Q2 = TextFieldImplKt.m3095animateBorderStrokeAsStateNuRrP5Q(z, z2, booleanValue2, textFieldColors4, f8, f9, startRestartGroup, (i102 & 458752) | ((i4 >> 3) & 7168) | (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (57344 & i102));
                Modifier modifier42 = modifier3;
                Shape shape52 = shape4;
                composer2 = startRestartGroup;
                BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier42, m3095animateBorderStrokeAsStateNuRrP5Q2.getValue(), shape52), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(textFieldColors4.m2627containerColorXeAY9LY$material3(z, z2, booleanValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6), null, null, startRestartGroup, 0, 12)) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), shape52), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f5 = f8;
                f6 = f9;
                shape2 = shape52;
                textFieldColors2 = textFieldColors4;
                modifier2 = modifier42;
            } else {
                composer2 = startRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = obj;
                textFieldColors2 = obj2;
                shape2 = obj3;
                f5 = f3;
                f6 = f4;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return OutlinedTextFieldDefaults.Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults.this, z, z2, interactionSource, modifier2, textFieldColors2, shape2, f5, f6, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((12582912 & i) != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:303:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:553:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        int i5;
        final boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function217;
        final TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        PaddingValues paddingValues4;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        int i21;
        boolean z7;
        Function2<? super Composer, ? super Integer, Unit> function221;
        Function2<? super Composer, ? super Integer, Unit> function222;
        TextFieldColors textFieldColors4;
        ComposableLambda composableLambda;
        boolean z8;
        Function2<? super Composer, ? super Integer, Unit> function223;
        boolean z9;
        int i22;
        ComposableLambda rememberComposableLambda;
        Composer startRestartGroup = composer.startRestartGroup(-1732281618);
        ComposerKt.sourceInformation(startRestartGroup, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,colors,contentPadding,container)1170@61544L129,1176@61727L751:TextFieldDefaults.kt#uh7d8r");
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
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z4 = z2;
                i4 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                int i23 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
                }
                i5 = i3 & 64;
                if (i5 != 0) {
                    i4 |= 1572864;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                    }
                }
                i6 = i3 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i7 = i3 & 256;
                if (i7 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i10 = i9;
                        i4 |= startRestartGroup.changedInstance(function24) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 6) == 0) {
                            i12 = i11;
                            i13 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        i14 = i3 & 2048;
                        if (i14 != 0) {
                            i13 |= 48;
                            i15 = i14;
                        } else if ((i2 & 48) == 0) {
                            i15 = i14;
                            i13 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        } else {
                            i15 = i14;
                        }
                        int i24 = i13;
                        i16 = i3 & 4096;
                        if (i16 != 0) {
                            i17 = i24 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i17 = i24 | (startRestartGroup.changedInstance(function27) ? 256 : 128);
                        } else {
                            i17 = i24;
                        }
                        i18 = i3 & 8192;
                        if (i18 != 0) {
                            i19 = i17 | 3072;
                        } else {
                            i19 = i17;
                            if ((i2 & 3072) == 0) {
                                i19 |= startRestartGroup.changedInstance(function28) ? 2048 : 1024;
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) == 0 && startRestartGroup.changed(textFieldColors)) {
                                        i23 = 16384;
                                    }
                                    i19 |= i23;
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i19 |= ((i3 & 32768) == 0 && startRestartGroup.changed(paddingValues)) ? 131072 : 65536;
                                }
                                i20 = i3 & 65536;
                                if (i20 == 0) {
                                    i19 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i19 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
                                }
                                if ((i3 & 131072) == 0) {
                                    i19 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i19 |= startRestartGroup.changed(this) ? 8388608 : 4194304;
                                }
                                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "1154@60977L8,1156@61089L408");
                                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i5 != 0) {
                                            z5 = false;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i6 != 0 ? null : function22;
                                        function217 = i8 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i10 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i12 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i15 != 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function228 = i16 != 0 ? null : function27;
                                        Function2<? super Composer, ? super Integer, Unit> function229 = i18 != 0 ? null : function28;
                                        if ((i3 & 16384) != 0) {
                                            textFieldColors3 = colors(startRestartGroup, (i19 >> 21) & 14);
                                            i19 &= -57345;
                                        } else {
                                            textFieldColors3 = textFieldColors;
                                        }
                                        if ((i3 & 32768) != 0) {
                                            paddingValues3 = m2345contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            i19 &= -458753;
                                        } else {
                                            paddingValues3 = paddingValues;
                                        }
                                        if (i20 != 0) {
                                            Function2<? super Composer, ? super Integer, Unit> function230 = function224;
                                            TextFieldColors textFieldColors5 = textFieldColors3;
                                            paddingValues4 = paddingValues3;
                                            function219 = function225;
                                            function220 = function228;
                                            i21 = i19;
                                            z7 = false;
                                            function221 = function229;
                                            function222 = function227;
                                            textFieldColors4 = textFieldColors5;
                                            composableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i25) {
                                                    ComposerKt.sourceInformation(composer3, "C1163@61333L5,1157@61103L384:TextFieldDefaults.kt#uh7d8r");
                                                    if (!composer3.shouldExecute((i25 & 3) != 2, i25 & 1)) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-896270173, i25, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1157)");
                                                    }
                                                    OutlinedTextFieldDefaults.INSTANCE.m2346Container4EFweAY(z, z5, interactionSource, Modifier.Companion, textFieldColors3, OutlinedTextFieldDefaults.INSTANCE.getShape(composer3, 6), OutlinedTextFieldDefaults.INSTANCE.m2350getFocusedBorderThicknessD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2353getUnfocusedBorderThicknessD9Ej5fM(), composer3, 114822144, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, startRestartGroup, 54);
                                            z8 = z5;
                                            function223 = function226;
                                            z9 = true;
                                            function218 = function230;
                                        } else {
                                            TextFieldColors textFieldColors6 = textFieldColors3;
                                            paddingValues4 = paddingValues3;
                                            function218 = function224;
                                            function219 = function225;
                                            function220 = function228;
                                            i21 = i19;
                                            z7 = false;
                                            function221 = function229;
                                            function222 = function227;
                                            textFieldColors4 = textFieldColors6;
                                            composableLambda = function29;
                                            z8 = z5;
                                            function223 = function226;
                                            z9 = true;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 16384) != 0) {
                                            i19 &= -57345;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i19 &= -458753;
                                        }
                                        function218 = function22;
                                        function217 = function23;
                                        function219 = function24;
                                        function222 = function26;
                                        function220 = function27;
                                        function221 = function28;
                                        paddingValues4 = paddingValues;
                                        composableLambda = function29;
                                        z8 = z5;
                                        i21 = i19;
                                        z7 = false;
                                        z9 = true;
                                        function223 = function25;
                                        textFieldColors4 = textFieldColors;
                                    }
                                    startRestartGroup.endDefaults();
                                    Function2<? super Composer, ? super Integer, Unit> function231 = function220;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1732281618, i4, i21, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1168)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1724716623, "CC(remember):TextFieldDefaults.kt#9igjgp");
                                    boolean z10 = (i4 & 14) == 4 ? z9 : z7;
                                    if ((57344 & i4) == 16384) {
                                        z7 = z9;
                                    }
                                    boolean z11 = z10 | z7;
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
                                        i22 = i21;
                                        rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    } else {
                                        i22 = i21;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    String text = ((TransformedText) rememberedValue).getText().getText();
                                    TextFieldType textFieldType = TextFieldType.Outlined;
                                    TextFieldLabelPosition.Attached attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                    if (function218 == null) {
                                        startRestartGroup.startReplaceGroup(1927058812);
                                        startRestartGroup.endReplaceGroup();
                                        function22 = function218;
                                        rememberComposableLambda = null;
                                    } else {
                                        startRestartGroup.startReplaceGroup(1927058813);
                                        ComposerKt.sourceInformation(startRestartGroup, "*1182@62008L15");
                                        function22 = function218;
                                        rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, z9, new Function3<TextFieldLabelScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldLabelScope textFieldLabelScope, Composer composer3, Integer num) {
                                                invoke(textFieldLabelScope, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(TextFieldLabelScope textFieldLabelScope, Composer composer3, int i25) {
                                                ComposerKt.sourceInformation(composer3, "C1182@62013L8:TextFieldDefaults.kt#uh7d8r");
                                                if (!composer3.shouldExecute((i25 & 17) != 16, i25 & 1)) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1459717586, i25, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous>.<anonymous> (TextFieldDefaults.kt:1182)");
                                                }
                                                function218.invoke(composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    int i25 = i4 >> 9;
                                    int i26 = ((i4 << 3) & 896) | 6 | (458752 & i25) | (3670016 & i25);
                                    int i27 = i22 << 21;
                                    int i28 = i4 & 896;
                                    composer2 = startRestartGroup;
                                    Function2<? super Composer, ? super Integer, Unit> function232 = function217;
                                    TextFieldImplKt.CommonDecorationBox(textFieldType, text, function2, attached, rememberComposableLambda, function232, function219, function223, function222, function231, function221, z4, z, z8, interactionSource, paddingValues4, textFieldColors4, composableLambda, composer2, i26 | (i27 & 29360128) | (i27 & 234881024) | (i27 & 1879048192), i28 | ((i22 >> 9) & 14) | ((i4 >> 6) & 112) | (i25 & 7168) | ((i4 >> 3) & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function213 = function231;
                                    function214 = function221;
                                    paddingValues2 = paddingValues4;
                                    function215 = composableLambda;
                                    function211 = function223;
                                    function212 = function222;
                                    function216 = function232;
                                    function210 = function219;
                                    z6 = z8;
                                    textFieldColors2 = textFieldColors4;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    function210 = function24;
                                    function211 = function25;
                                    function212 = function26;
                                    function213 = function27;
                                    function214 = function28;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    function215 = function29;
                                    z6 = z5;
                                    function216 = function23;
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function233 = function22;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldDefaults.DecorationBox$lambda$3(OutlinedTextFieldDefaults.this, str, function2, z, z2, visualTransformation, interactionSource, z6, function233, function216, function210, function211, function212, function213, function214, textFieldColors2, paddingValues2, function215, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i20 = i3 & 65536;
                        if (i20 == 0) {
                        }
                        if ((i3 & 131072) == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                        }
                        final Function2 function2332 = function22;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    i14 = i3 & 2048;
                    if (i14 != 0) {
                    }
                    int i242 = i13;
                    i16 = i3 & 4096;
                    if (i16 != 0) {
                    }
                    i18 = i3 & 8192;
                    if (i18 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i20 = i3 & 65536;
                    if (i20 == 0) {
                    }
                    if ((i3 & 131072) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                    }
                    final Function2 function23322 = function22;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i7;
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                i14 = i3 & 2048;
                if (i14 != 0) {
                }
                int i2422 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                }
                i18 = i3 & 8192;
                if (i18 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i20 = i3 & 65536;
                if (i20 == 0) {
                }
                if ((i3 & 131072) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                }
                final Function2 function233222 = function22;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z4 = z2;
            int i232 = 8192;
            if ((i3 & 16) != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            i5 = i3 & 64;
            if (i5 != 0) {
            }
            i6 = i3 & 128;
            if (i6 != 0) {
            }
            i7 = i3 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            i14 = i3 & 2048;
            if (i14 != 0) {
            }
            int i24222 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
            }
            i18 = i3 & 8192;
            if (i18 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i20 = i3 & 65536;
            if (i20 == 0) {
            }
            if ((i3 & 131072) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
            }
            final Function2 function2332222 = function22;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        z4 = z2;
        int i2322 = 8192;
        if ((i3 & 16) != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i5 = i3 & 64;
        if (i5 != 0) {
        }
        i6 = i3 & 128;
        if (i6 != 0) {
        }
        i7 = i3 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        i14 = i3 & 2048;
        if (i14 != 0) {
        }
        int i242222 = i13;
        i16 = i3 & 4096;
        if (i16 != 0) {
        }
        i18 = i3 & 8192;
        if (i18 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i20 = i3 & 65536;
        if (i20 == 0) {
        }
        if ((i3 & 131072) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
        }
        final Function2 function23322222 = function22;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: contentPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m2345contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m2349contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4 */
    public final PaddingValues m2349contentPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m814PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -471651810, "C(colors)1215@63265L11,1215@63277L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1215)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedTextFieldColors;
    }

    /* renamed from: colors-0hiis_0 */
    public final TextFieldColors m2348colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long j43;
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 1767617725, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)1317@70088L11,1317@70100L30:TextFieldDefaults.kt#uh7d8r");
        long m4808getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j;
        long m4808getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j2;
        long m4808getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j3;
        long m4808getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j4;
        long m4808getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j5;
        long m4808getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j6;
        long m4808getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j7;
        long m4808getUnspecified0d7_KjU8 = (i6 & 128) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j8;
        long m4808getUnspecified0d7_KjU9 = (i6 & 256) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j9;
        long m4808getUnspecified0d7_KjU10 = (i6 & 512) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors3 = (i6 & 1024) != 0 ? null : textSelectionColors;
        long m4808getUnspecified0d7_KjU11 = (i6 & 2048) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j11;
        long m4808getUnspecified0d7_KjU12 = (i6 & 4096) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j12;
        long m4808getUnspecified0d7_KjU13 = (i6 & 8192) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j13;
        long m4808getUnspecified0d7_KjU14 = (i6 & 16384) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j14;
        long m4808getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j15;
        long m4808getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j16;
        long m4808getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j17;
        long m4808getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j18;
        long m4808getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j19;
        long m4808getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j20;
        long m4808getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j21;
        long m4808getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j22;
        long m4808getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j23;
        long m4808getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j24;
        long m4808getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j25;
        long m4808getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j26;
        long m4808getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j27;
        long m4808getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j28;
        long m4808getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j29;
        long m4808getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j30;
        long m4808getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j31;
        long m4808getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j32;
        long m4808getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j33;
        long m4808getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j34;
        long m4808getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j35;
        long m4808getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j36;
        long m4808getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j37;
        long m4808getUnspecified0d7_KjU38 = (i7 & 128) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j38;
        long m4808getUnspecified0d7_KjU39 = (i7 & 256) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j39;
        long m4808getUnspecified0d7_KjU40 = (i7 & 512) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j40;
        long m4808getUnspecified0d7_KjU41 = (i7 & 1024) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j41;
        long m4808getUnspecified0d7_KjU42 = (i7 & 2048) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            j43 = m4808getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1317)");
        } else {
            j43 = m4808getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors m2628copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m2628copyejIjP34(m4808getUnspecified0d7_KjU, m4808getUnspecified0d7_KjU2, m4808getUnspecified0d7_KjU3, m4808getUnspecified0d7_KjU4, m4808getUnspecified0d7_KjU5, m4808getUnspecified0d7_KjU6, m4808getUnspecified0d7_KjU7, m4808getUnspecified0d7_KjU8, m4808getUnspecified0d7_KjU9, m4808getUnspecified0d7_KjU10, textSelectionColors2, m4808getUnspecified0d7_KjU11, m4808getUnspecified0d7_KjU12, m4808getUnspecified0d7_KjU13, m4808getUnspecified0d7_KjU14, m4808getUnspecified0d7_KjU15, m4808getUnspecified0d7_KjU16, m4808getUnspecified0d7_KjU17, m4808getUnspecified0d7_KjU18, m4808getUnspecified0d7_KjU19, m4808getUnspecified0d7_KjU20, m4808getUnspecified0d7_KjU21, m4808getUnspecified0d7_KjU22, m4808getUnspecified0d7_KjU23, m4808getUnspecified0d7_KjU24, m4808getUnspecified0d7_KjU25, m4808getUnspecified0d7_KjU26, m4808getUnspecified0d7_KjU27, m4808getUnspecified0d7_KjU28, m4808getUnspecified0d7_KjU29, m4808getUnspecified0d7_KjU30, m4808getUnspecified0d7_KjU31, m4808getUnspecified0d7_KjU32, m4808getUnspecified0d7_KjU33, m4808getUnspecified0d7_KjU34, m4808getUnspecified0d7_KjU35, m4808getUnspecified0d7_KjU36, m4808getUnspecified0d7_KjU37, m4808getUnspecified0d7_KjU38, m4808getUnspecified0d7_KjU39, m4808getUnspecified0d7_KjU40, m4808getUnspecified0d7_KjU41, j43);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2628copyejIjP34;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        TextFieldColors textFieldColors;
        ComposerKt.sourceInformationMarkerStart(composer, -292363577, "C(<get-defaultOutlinedTextFieldColors>):TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1365)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached$material3 = colorScheme.getDefaultOutlinedTextFieldColorsCached$material3();
        if (defaultOutlinedTextFieldColorsCached$material3 == null) {
            composer.startReplaceGroup(390452338);
            composer.endReplaceGroup();
            textFieldColors = null;
        } else {
            composer.startReplaceGroup(390452339);
            ComposerKt.sourceInformation(composer, "*1367@72895L7");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextSelectionColors textSelectionColors = (TextSelectionColors) consume;
            if (!Intrinsics.areEqual(defaultOutlinedTextFieldColorsCached$material3.getTextSelectionColors(), textSelectionColors)) {
                defaultOutlinedTextFieldColorsCached$material3 = TextFieldColors.m2626copyejIjP34$default(defaultOutlinedTextFieldColorsCached$material3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, textSelectionColors, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1025, 2047, null);
                colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(defaultOutlinedTextFieldColorsCached$material3);
            }
            composer.endReplaceGroup();
            textFieldColors = defaultOutlinedTextFieldColorsCached$material3;
        }
        if (textFieldColors != null) {
            composer.startReplaceGroup(-1788515437);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1788321191);
            ComposerKt.sourceInformation(composer, "1389@74318L7");
            long fromToken = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long m4771copywmQWz5c$default = Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long m4807getTransparent0d7_KjU = Color.Companion.m4807getTransparent0d7_KjU();
            long m4807getTransparent0d7_KjU2 = Color.Companion.m4807getTransparent0d7_KjU();
            long m4807getTransparent0d7_KjU3 = Color.Companion.m4807getTransparent0d7_KjU();
            long m4807getTransparent0d7_KjU4 = Color.Companion.m4807getTransparent0d7_KjU();
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors2 = new TextFieldColors(fromToken, fromToken2, m4771copywmQWz5c$default, fromToken3, m4807getTransparent0d7_KjU, m4807getTransparent0d7_KjU2, m4807getTransparent0d7_KjU3, m4807getTransparent0d7_KjU4, fromToken4, fromToken5, (TextSelectionColors) consume2, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(textFieldColors2);
            composer.endReplaceGroup();
            textFieldColors = textFieldColors2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:247:0x0136, code lost:
        if ((r28 & 64) != 0) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:273:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n    focusedBorderThickness = focusedBorderThickness,\n    unfocusedBorderThickness = unfocusedBorderThickness,\n)", imports = {}))
    /* renamed from: ContainerBox-nbWgWpA */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2347ContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        boolean z4;
        Object obj;
        TextFieldColors textFieldColors2;
        Shape shape2;
        float f3;
        float f4;
        final TextFieldColors textFieldColors3;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1482@80172L348:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z4 = z2;
            i3 |= startRestartGroup.changed(z4) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = interactionSource;
                i3 |= startRestartGroup.changed(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        textFieldColors2 = textFieldColors;
                        if (startRestartGroup.changed(textFieldColors2)) {
                            i7 = 2048;
                            i3 |= i7;
                        }
                    } else {
                        textFieldColors2 = textFieldColors;
                    }
                    i7 = 1024;
                    i3 |= i7;
                } else {
                    textFieldColors2 = textFieldColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i6 = 16384;
                            i3 |= i6;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i6 = 8192;
                    i3 |= i6;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        f3 = f;
                        if (startRestartGroup.changed(f3)) {
                            i5 = 131072;
                            i3 |= i5;
                        }
                    } else {
                        f3 = f;
                    }
                    i5 = 65536;
                    i3 |= i5;
                } else {
                    f3 = f;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        f4 = f2;
                        if (startRestartGroup.changed(f4)) {
                            i4 = 1048576;
                            i3 |= i4;
                        }
                    } else {
                        f4 = f2;
                    }
                    i4 = 524288;
                    i3 |= i4;
                } else {
                    f4 = f2;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 8388608 : 4194304;
                }
                if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "1477@79964L8,1478@80023L5");
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 8) != 0) {
                            textFieldColors2 = colors(startRestartGroup, (i3 >> 21) & 14);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = INSTANCE.getShape(startRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            f3 = FocusedBorderThickness;
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            f4 = UnfocusedBorderThickness;
                            i3 &= -3670017;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1482)");
                        }
                        int i8 = i3 << 3;
                        int i9 = (i8 & 234881024) | (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8);
                        InteractionSource interactionSource2 = obj;
                        textFieldColors3 = textFieldColors2;
                        shape3 = shape2;
                        f5 = f3;
                        f6 = f4;
                        m2346Container4EFweAY(z3, z4, interactionSource2, Modifier.Companion, textFieldColors3, shape3, f5, f6, startRestartGroup, i9, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    textFieldColors3 = textFieldColors2;
                    shape3 = shape2;
                    f5 = f3;
                    f6 = f4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return OutlinedTextFieldDefaults.ContainerBox_nbWgWpA$lambda$7(OutlinedTextFieldDefaults.this, z, z2, interactionSource, textFieldColors3, shape3, f5, f6, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            obj = interactionSource;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z4 = z2;
        if ((i2 & 4) == 0) {
        }
        obj = interactionSource;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}

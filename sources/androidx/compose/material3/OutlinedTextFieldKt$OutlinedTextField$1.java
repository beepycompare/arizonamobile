package androidx.compose.material3;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutlinedTextField.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt$OutlinedTextField$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
    final /* synthetic */ TextFieldLabelPosition $labelPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ TextFieldLineLimits $lineLimits;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ KeyboardActionHandler $onKeyboardAction;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ OutputTransformation $outputTransformation;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldKt$OutlinedTextField$1(Modifier modifier, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, TextFieldLabelPosition textFieldLabelPosition, boolean z, TextFieldColors textFieldColors, TextFieldState textFieldState, boolean z2, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, PaddingValues paddingValues, boolean z3, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, ScrollState scrollState, Shape shape) {
        this.$modifier = modifier;
        this.$label = function3;
        this.$labelPosition = textFieldLabelPosition;
        this.$isError = z;
        this.$colors = textFieldColors;
        this.$state = textFieldState;
        this.$enabled = z2;
        this.$lineLimits = textFieldLineLimits;
        this.$outputTransformation = outputTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$prefix = function24;
        this.$suffix = function25;
        this.$supportingText = function26;
        this.$contentPadding = paddingValues;
        this.$readOnly = z3;
        this.$inputTransformation = inputTransformation;
        this.$mergedTextStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$onKeyboardAction = keyboardActionHandler;
        this.$onTextLayout = function27;
        this.$scrollState = scrollState;
        this.$shape = shape;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Modifier.Companion companion;
        ComposerKt.sourceInformation(composer, "C255@14761L38,290@16390L359,273@15619L1149,240@14014L2765:OutlinedTextField.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-416142558, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:240)");
        }
        Modifier modifier = this.$modifier;
        if (this.$label != null && !(this.$labelPosition instanceof TextFieldLabelPosition.Above)) {
            composer.startReplaceGroup(-2027097767);
            ComposerKt.sourceInformation(composer, "249@14513L2,250@14563L26");
            Modifier.Companion companion2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -481023420, "CC(remember):OutlinedTextField.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit unit;
                        SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            companion = PaddingKt.m822paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue), 0.0f, TextFieldImplKt.minimizedLabelHalfHeight(composer, 0), 0.0f, 0.0f, 13, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-2026714080);
            composer.endReplaceGroup();
            companion = Modifier.Companion;
        }
        Modifier then = modifier.then(companion);
        boolean z = this.$isError;
        Strings.Companion companion3 = Strings.Companion;
        Modifier m848defaultMinSizeVpY3zN4 = SizeKt.m848defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(then, z, Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.default_error_message), composer, 0)), OutlinedTextFieldDefaults.INSTANCE.m2352getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2351getMinHeightD9Ej5fM());
        SolidColor solidColor = new SolidColor(this.$colors.m2629cursorColorvNxB06k$material3(this.$isError), null);
        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
        TextFieldState textFieldState = this.$state;
        boolean z2 = this.$enabled;
        TextFieldLineLimits textFieldLineLimits = this.$lineLimits;
        OutputTransformation outputTransformation = this.$outputTransformation;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        TextFieldLabelPosition textFieldLabelPosition = this.$labelPosition;
        Function3<TextFieldLabelScope, Composer, Integer, Unit> function3 = this.$label;
        Function2<Composer, Integer, Unit> function2 = this.$placeholder;
        Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
        Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
        Function2<Composer, Integer, Unit> function24 = this.$prefix;
        Function2<Composer, Integer, Unit> function25 = this.$suffix;
        Function2<Composer, Integer, Unit> function26 = this.$supportingText;
        boolean z3 = this.$isError;
        TextFieldColors textFieldColors = this.$colors;
        PaddingValues paddingValues = this.$contentPadding;
        final boolean z4 = this.$enabled;
        final boolean z5 = this.$isError;
        final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        final TextFieldColors textFieldColors2 = this.$colors;
        final Shape shape = this.$shape;
        BasicTextFieldKt.BasicTextField(this.$state, m848defaultMinSizeVpY3zN4, this.$enabled, this.$readOnly, this.$inputTransformation, this.$mergedTextStyle, this.$keyboardOptions, this.$onKeyboardAction, this.$lineLimits, this.$onTextLayout, this.$interactionSource, solidColor, this.$outputTransformation, outlinedTextFieldDefaults.decorator(textFieldState, z2, textFieldLineLimits, outputTransformation, mutableInteractionSource, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z3, textFieldColors, paddingValues, ComposableLambdaKt.rememberComposableLambda(-98391231, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C291@16442L285:OutlinedTextField.kt#uh7d8r");
                if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-98391231, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:291)");
                }
                OutlinedTextFieldDefaults.INSTANCE.m2346Container4EFweAY(z4, z5, mutableInteractionSource2, null, textFieldColors2, shape, 0.0f, 0.0f, composer2, 100663296, 200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 0, 14155776, 0), this.$scrollState, composer, 0, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

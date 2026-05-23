package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
/* compiled from: TextFieldSize.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "legacyTextFieldMinSize", "foundation", "typeface", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier modifier, TextStyle textStyle) {
        if (ComposeFoundationFlags.isBasicTextFieldMinSizeOptimizationEnabled) {
            return modifier.then(new TextFieldSizeElement(textStyle));
        }
        return legacyTextFieldMinSize(modifier, textStyle);
    }

    public static final Modifier legacyTextFieldMinSize(Modifier modifier, final TextStyle textStyle) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldSizeKt.legacyTextFieldMinSize$lambda$0(TextStyle.this, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.runtime.Composer] */
    public static final Modifier legacyTextFieldMinSize$lambda$0(TextStyle textStyle, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-390200690);
        ComposerKt.sourceInformation(composer, "C163@6412L7,164@6473L7,165@6528L7,167@6561L76,169@6666L341,178@7032L107,184@7257L488:TextFieldSize.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-390200690, i, -1, "androidx.compose.foundation.text.legacyTextFieldMinSize.<anonymous> (TextFieldSize.kt:163)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd(composer);
        FontFamily.Resolver resolver = (FontFamily.Resolver) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(composer, -1320702438, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changed = composer.changed(textStyle) | composer.changed(layoutDirection.ordinal());
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer.updateRememberedValue(rememberedValue);
        }
        TextStyle textStyle2 = (TextStyle) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1320698813, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changed2 = composer.changed(resolver) | composer.changed(textStyle2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = textStyle2.getFontFamily();
            FontWeight fontWeight = textStyle2.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m7640getFontStyle4Lr2A7w = textStyle2.m7640getFontStyle4Lr2A7w();
            int m7723unboximpl = m7640getFontStyle4Lr2A7w != null ? m7640getFontStyle4Lr2A7w.m7723unboximpl() : FontStyle.Companion.m7727getNormal_LCdwA();
            FontSynthesis m7641getFontSynthesisZQGJjVo = textStyle2.m7641getFontSynthesisZQGJjVo();
            rememberedValue2 = resolver.mo7693resolveDPcqOEQ(fontFamily, fontWeight, m7723unboximpl, m7641getFontSynthesisZQGJjVo != null ? m7641getFontSynthesisZQGJjVo.m7736unboximpl() : FontSynthesis.Companion.m7737getAllGVVA2EU());
            composer.updateRememberedValue(rememberedValue2);
        }
        State state = rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1320687335, "CC(remember):TextFieldSize.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new LegacyTextFieldSize(layoutDirection, density, resolver, textStyle, state.getValue());
            composer.updateRememberedValue(rememberedValue3);
        }
        final LegacyTextFieldSize legacyTextFieldSize = (LegacyTextFieldSize) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        legacyTextFieldSize.update(layoutDirection, density, resolver, textStyle2, state.getValue());
        Modifier.Companion companion = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, -1320679754, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(legacyTextFieldSize);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult legacyTextFieldMinSize$lambda$0$4$0;
                    legacyTextFieldMinSize$lambda$0$4$0 = TextFieldSizeKt.legacyTextFieldMinSize$lambda$0$4$0(LegacyTextFieldSize.this, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    return legacyTextFieldMinSize$lambda$0$4$0;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier layout = LayoutModifierKt.layout(companion, (Function3) rememberedValue4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult legacyTextFieldMinSize$lambda$0$4$0(LegacyTextFieldSize legacyTextFieldSize, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long m1605getMinSizeYbymL2g = legacyTextFieldSize.m1605getMinSizeYbymL2g();
        final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(Constraints.m8103copyZbe2FdA$default(constraints.m8119unboximpl(), RangesKt.coerceIn((int) (m1605getMinSizeYbymL2g >> 32), Constraints.m8115getMinWidthimpl(constraints.m8119unboximpl()), Constraints.m8113getMaxWidthimpl(constraints.m8119unboximpl())), 0, RangesKt.coerceIn((int) (m1605getMinSizeYbymL2g & 4294967295L), Constraints.m8114getMinHeightimpl(constraints.m8119unboximpl()), Constraints.m8112getMaxHeightimpl(constraints.m8119unboximpl())), 0, 10, null));
        return MeasureScope.layout$default(measureScope, mo6818measureBRTryo0.getWidth(), mo6818measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit legacyTextFieldMinSize$lambda$0$4$0$0;
                legacyTextFieldMinSize$lambda$0$4$0$0 = TextFieldSizeKt.legacyTextFieldMinSize$lambda$0$4$0$0(Placeable.this, (Placeable.PlacementScope) obj);
                return legacyTextFieldMinSize$lambda$0$4$0$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit legacyTextFieldMinSize$lambda$0$4$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}

package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
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
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextFieldSizeKt$textFieldMinSize$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        this.$style = textStyle;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.runtime.Composer] */
    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1582736677);
        ComposerKt.sourceInformation(composer, "C37@1534L7,38@1595L7,39@1650L7,41@1683L76,43@1788L341,52@2154L101,58@2373L488:TextFieldSize.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1582736677, i, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
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
        ComposerKt.sourceInformationMarkerStart(composer, 591529713, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changed = composer.changed(this.$style) | composer.changed(layoutDirection.ordinal());
        TextStyle textStyle = this.$style;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer.updateRememberedValue(rememberedValue);
        }
        TextStyle textStyle2 = rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 591533338, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changed2 = composer.changed(resolver) | composer.changed(textStyle2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = textStyle2.getFontFamily();
            FontWeight fontWeight = textStyle2.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m7490getFontStyle4Lr2A7w = textStyle2.m7490getFontStyle4Lr2A7w();
            int m7574unboximpl = m7490getFontStyle4Lr2A7w != null ? m7490getFontStyle4Lr2A7w.m7574unboximpl() : FontStyle.Companion.m7578getNormal_LCdwA();
            FontSynthesis m7491getFontSynthesisZQGJjVo = textStyle2.m7491getFontSynthesisZQGJjVo();
            rememberedValue2 = resolver.mo7543resolveDPcqOEQ(fontFamily, fontWeight, m7574unboximpl, m7491getFontSynthesisZQGJjVo != null ? m7491getFontSynthesisZQGJjVo.m7587unboximpl() : FontSynthesis.Companion.m7588getAllGVVA2EU());
            composer.updateRememberedValue(rememberedValue2);
        }
        State state = rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 591544810, "CC(remember):TextFieldSize.kt#9igjgp");
        TextStyle textStyle3 = this.$style;
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new TextFieldSize(layoutDirection, density, resolver, textStyle3, state.getValue());
            composer.updateRememberedValue(rememberedValue3);
        }
        final TextFieldSize textFieldSize = (TextFieldSize) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        textFieldSize.update(layoutDirection, density, resolver, textStyle2, state.getValue());
        Modifier.Companion companion = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 591552205, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(textFieldSize);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult invoke$lambda$6$lambda$5;
                    invoke$lambda$6$lambda$5 = TextFieldSizeKt$textFieldMinSize$1.invoke$lambda$6$lambda$5(TextFieldSize.this, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    return invoke$lambda$6$lambda$5;
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
    public static final MeasureResult invoke$lambda$6$lambda$5(TextFieldSize textFieldSize, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long m1383getMinSizeYbymL2g = textFieldSize.m1383getMinSizeYbymL2g();
        final Placeable mo6698measureBRTryo0 = measurable.mo6698measureBRTryo0(Constraints.m7939copyZbe2FdA$default(constraints.m7955unboximpl(), RangesKt.coerceIn((int) (m1383getMinSizeYbymL2g >> 32), Constraints.m7951getMinWidthimpl(constraints.m7955unboximpl()), Constraints.m7949getMaxWidthimpl(constraints.m7955unboximpl())), 0, RangesKt.coerceIn((int) (m1383getMinSizeYbymL2g & 4294967295L), Constraints.m7950getMinHeightimpl(constraints.m7955unboximpl()), Constraints.m7948getMaxHeightimpl(constraints.m7955unboximpl())), 0, 10, null));
        return MeasureScope.layout$default(measureScope, mo6698measureBRTryo0.getWidth(), mo6698measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$6$lambda$5$lambda$4;
                invoke$lambda$6$lambda$5$lambda$4 = TextFieldSizeKt$textFieldMinSize$1.invoke$lambda$6$lambda$5$lambda$4(Placeable.this, (Placeable.PlacementScope) obj);
                return invoke$lambda$6$lambda$5$lambda$4;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}

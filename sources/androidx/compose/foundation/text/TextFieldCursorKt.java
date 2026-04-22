package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
/* compiled from: TextFieldCursor.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"cursor", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCursorKt {
    public static final Modifier cursor(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, final Brush brush, boolean z) {
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldCursorKt.cursor$lambda$0(Brush.this, legacyTextFieldState, textFieldValue, offsetMapping, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Modifier cursor$lambda$0(final Brush brush, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, Modifier modifier, Composer composer, int i) {
        Modifier.Companion companion;
        composer.startReplaceGroup(-84507373);
        ComposerKt.sourceInformation(composer, "C46@1735L7,47@1777L63,54@2290L7:TextFieldCursor.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalCursorBlinkEnabled());
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        ComposerKt.sourceInformationMarkerStart(composer, 392796434, "CC(remember):TextFieldCursor.kt#9igjgp");
        boolean changed = composer.changed(booleanValue);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CursorAnimationState(booleanValue);
            composer.updateRememberedValue(rememberedValue);
        }
        final CursorAnimationState cursorAnimationState = (CursorAnimationState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = ((brush instanceof SolidColor) && ((SolidColor) brush).m5128getValue0d7_KjU() == 16) ? false : true;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalWindowInfo());
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((WindowInfo) consume2).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m6997getCollapsedimpl(textFieldValue.m7253getSelectiond9O1mEE()) && z) {
            composer.startReplaceGroup(-707487962);
            ComposerKt.sourceInformation(composer, "58@2517L81,58@2462L136,61@2631L1888");
            AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
            TextRange m6991boximpl = TextRange.m6991boximpl(textFieldValue.m7253getSelectiond9O1mEE());
            ComposerKt.sourceInformationMarkerStart(composer, 392820132, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(cursorAnimationState);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function2) new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(annotatedString, m6991boximpl, (Function2) rememberedValue2, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 392825587, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(offsetMapping) | composer.changed(textFieldValue) | composer.changedInstance(legacyTextFieldState) | composer.changed(brush);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                Object obj = new Function1() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit cursor$lambda$0$2$0;
                        cursor$lambda$0$2$0 = TextFieldCursorKt.cursor$lambda$0$2$0(CursorAnimationState.this, offsetMapping, textFieldValue, legacyTextFieldState, brush, (ContentDrawScope) obj2);
                        return cursor$lambda$0$2$0;
                    }
                };
                composer.updateRememberedValue(obj);
                rememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            companion = DrawModifierKt.drawWithContent(modifier, (Function1) rememberedValue3);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-705473241);
            composer.endReplaceGroup();
            companion = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cursor$lambda$0$2$0(CursorAnimationState cursorAnimationState, OffsetMapping offsetMapping, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        Rect rect;
        float rint;
        TextLayoutResult value;
        contentDrawScope.drawContent();
        float cursorAlpha = cursorAnimationState.getCursorAlpha();
        if (cursorAlpha != 0.0f) {
            int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m7003getStartimpl(textFieldValue.m7253getSelectiond9O1mEE()));
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(originalToTransformed)) == null) {
                rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
            }
            float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(contentDrawScope.mo405toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
            float f = coerceAtLeast / 2.0f;
            float coerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f, Float.intBitsToFloat((int) (contentDrawScope.mo5346getSizeNHjbRc() >> 32)) - f), f);
            if (((int) coerceAtLeast) % 2 == 1) {
                rint = ((float) Math.floor(coerceAtLeast2)) + 0.5f;
            } else {
                rint = (float) Math.rint(coerceAtLeast2);
            }
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            DrawScope.m5331drawLine1RTmtNc$default(contentDrawScope2, brush, Offset.m4519constructorimpl((Float.floatToRawIntBits(rint) << 32) | (Float.floatToRawIntBits(rect.getTop()) & 4294967295L)), Offset.m4519constructorimpl((Float.floatToRawIntBits(rect.getBottom()) & 4294967295L) | (Float.floatToRawIntBits(rint) << 32)), coerceAtLeast, 0, null, cursorAlpha, null, 0, 432, null);
        }
        return Unit.INSTANCE;
    }
}

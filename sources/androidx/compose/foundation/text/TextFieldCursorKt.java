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
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"cursor", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCursorKt {
    public static final Modifier cursor(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, final Brush brush, boolean z) {
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r13v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r4v2 */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier.Companion companion;
                composer.startReplaceGroup(-84507373);
                ComposerKt.sourceInformation(composer, "C46@1734L7,47@1776L63,54@2289L7:TextFieldCursor.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
                }
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocalsKt.getLocalCursorBlinkEnabled());
                ComposerKt.sourceInformationMarkerEnd(composer);
                boolean booleanValue = ((Boolean) consume).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composer, 1411529339, "CC(remember):TextFieldCursor.kt#9igjgp");
                boolean changed = composer.changed(booleanValue);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new CursorAnimationState(booleanValue);
                    composer.updateRememberedValue(rememberedValue);
                }
                final CursorAnimationState cursorAnimationState = rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Brush brush2 = Brush.this;
                boolean z2 = ((brush2 instanceof SolidColor) && ((SolidColor) brush2).m4414getValue0d7_KjU() == 16) ? false : true;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = composer.consume(CompositionLocalsKt.getLocalWindowInfo());
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (((WindowInfo) consume2).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m6141getCollapsedimpl(textFieldValue.m6396getSelectiond9O1mEE()) && z2) {
                    composer.startReplaceGroup(808460990);
                    ComposerKt.sourceInformation(composer, "58@2516L81,58@2461L136,61@2630L1887");
                    AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
                    TextRange m6135boximpl = TextRange.m6135boximpl(textFieldValue.m6396getSelectiond9O1mEE());
                    ComposerKt.sourceInformationMarkerStart(composer, 1411553037, "CC(remember):TextFieldCursor.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(cursorAnimationState);
                    TextFieldCursorKt$cursor$1$1$1 rememberedValue2 = composer.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(annotatedString, m6135boximpl, (Function2) rememberedValue2, composer, 0);
                    ComposerKt.sourceInformationMarkerStart(composer, 1411558491, "CC(remember):TextFieldCursor.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(offsetMapping) | composer.changed(textFieldValue) | composer.changedInstance(legacyTextFieldState) | composer.changed(Brush.this);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    final Brush brush3 = Brush.this;
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2$1
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
                                Rect rect;
                                float rint;
                                TextLayoutResult value;
                                contentDrawScope.drawContent();
                                float cursorAlpha = CursorAnimationState.this.getCursorAlpha();
                                if (cursorAlpha == 0.0f) {
                                    return;
                                }
                                int originalToTransformed = offsetMapping2.originalToTransformed(TextRange.m6147getStartimpl(textFieldValue2.m6396getSelectiond9O1mEE()));
                                TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                                if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(originalToTransformed)) == null) {
                                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(contentDrawScope.mo389toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
                                float f = coerceAtLeast / 2;
                                float coerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f, Float.intBitsToFloat((int) (contentDrawScope.mo4640getSizeNHjbRc() >> 32)) - f), f);
                                if (((int) coerceAtLeast) % 2 == 1) {
                                    rint = ((float) Math.floor(coerceAtLeast2)) + 0.5f;
                                } else {
                                    rint = (float) Math.rint(coerceAtLeast2);
                                }
                                DrawScope.m4625drawLine1RTmtNc$default(contentDrawScope, brush3, Offset.m3829constructorimpl((Float.floatToRawIntBits(rint) << 32) | (Float.floatToRawIntBits(rect.getTop()) & 4294967295L)), Offset.m3829constructorimpl((Float.floatToRawIntBits(rect.getBottom()) & 4294967295L) | (Float.floatToRawIntBits(rint) << 32)), coerceAtLeast, 0, null, cursorAlpha, null, 0, 432, null);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    companion = DrawModifierKt.drawWithContent(modifier2, (Function1) rememberedValue3);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(810474750);
                    composer.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companion;
            }
        }, 1, null) : modifier;
    }
}

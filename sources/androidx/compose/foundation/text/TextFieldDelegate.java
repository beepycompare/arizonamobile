package androidx.compose.foundation.text;

import androidx.compose.foundation.text.TextFieldDelegate;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
/* compiled from: TextFieldDelegate.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "<init>", "()V", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: TextFieldDelegate.kt */
    @Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010JO\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0004\b!\u0010\"J7\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010'JE\u0010(\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b/J-\u00100\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u000202H\u0001¢\u0006\u0002\b3JA\u00104\u001a\u00020\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\b\u0010<\u001a\u0004\u0018\u00010,H\u0001¢\u0006\u0002\b=JC\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010\u001c\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0004\bA\u0010BJU\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010F\u001a\u00020G2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bJJU\u0010K\u001a\u00020,2\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010F\u001a\u00020G2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bLJ1\u0010M\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bNJ\u001d\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020P¢\u0006\u0004\bS\u0010T¨\u0006U"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "<init>", "()V", "layout", "Lkotlin/Triple;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "selectionPreviewHighlightRange", "Landroidx/compose/ui/text/TextRange;", "deletionPreviewHighlightRange", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "draw-Q1vqE60$foundation", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/text/input/TextFieldValue;JJLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;J)V", "drawHighlight", "range", "paint", "drawHighlight-Le-punE", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;)V", "notifyFocusedRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "hasFocus", "", "notifyFocusedRect$foundation", "updateTextLayoutResult", "textFieldValue", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "updateTextLayoutResult$foundation", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "session", "onEditCommand$foundation", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "setCursorOffset-ULxng0E$foundation", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "restartInput", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "restartInput$foundation", "onFocus", "onFocus$foundation", "onBlur", "onBlur$foundation", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: layout-_EkL_-Y$foundation$default  reason: not valid java name */
        public static /* synthetic */ Triple m1434layout_EkL_Y$foundation$default(Companion companion, TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i, Object obj) {
            if ((i & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m1437layout_EkL_Y$foundation(textDelegate, j, layoutDirection, textLayoutResult);
        }

        @JvmStatic
        /* renamed from: layout-_EkL_-Y$foundation  reason: not valid java name */
        public final Triple<Integer, Integer, TextLayoutResult> m1437layout_EkL_Y$foundation(TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
            TextLayoutResult m1424layoutNN6EwU = textDelegate.m1424layoutNN6EwU(j, layoutDirection, textLayoutResult);
            return new Triple<>(Integer.valueOf((int) (m1424layoutNN6EwU.m7672getSizeYbymL2g() >> 32)), Integer.valueOf((int) (m1424layoutNN6EwU.m7672getSizeYbymL2g() & 4294967295L)), m1424layoutNN6EwU);
        }

        @JvmStatic
        /* renamed from: draw-Q1vqE60$foundation  reason: not valid java name */
        public final void m1436drawQ1vqE60$foundation(Canvas canvas, TextFieldValue textFieldValue, long j, long j2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint, long j3) {
            if (!TextRange.m7695getCollapsedimpl(j)) {
                paint.mo5300setColor8_81llA(j3);
                m1433drawHighlightLepunE(canvas, j, offsetMapping, textLayoutResult, paint);
            } else if (!TextRange.m7695getCollapsedimpl(j2)) {
                Color m5414boximpl = Color.m5414boximpl(textLayoutResult.getLayoutInput().getStyle().m7731getColor0d7_KjU());
                if (m5414boximpl.m5434unboximpl() == 16) {
                    m5414boximpl = null;
                }
                long m5434unboximpl = m5414boximpl != null ? m5414boximpl.m5434unboximpl() : Color.Companion.m5450getBlack0d7_KjU();
                paint.mo5300setColor8_81llA(Color.m5423copywmQWz5c$default(m5434unboximpl, Color.m5426getAlphaimpl(m5434unboximpl) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null));
                m1433drawHighlightLepunE(canvas, j2, offsetMapping, textLayoutResult, paint);
            } else if (!TextRange.m7695getCollapsedimpl(textFieldValue.m7955getSelectiond9O1mEE())) {
                paint.mo5300setColor8_81llA(j3);
                m1433drawHighlightLepunE(canvas, textFieldValue.m7955getSelectiond9O1mEE(), offsetMapping, textLayoutResult, paint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        /* renamed from: drawHighlight-Le-punE  reason: not valid java name */
        private final void m1433drawHighlightLepunE(Canvas canvas, long j, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint) {
            int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m7699getMinimpl(j));
            int originalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m7698getMaximpl(j));
            if (originalToTransformed != originalToTransformed2) {
                canvas.drawPath(textLayoutResult.getPathForRange(originalToTransformed, originalToTransformed2), paint);
            }
        }

        @JvmStatic
        public final void notifyFocusedRect$foundation(TextFieldValue textFieldValue, final TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
            if (z) {
                textInputSession.notifyFocusedRect(TextFieldDelegateKt.focusedRectInRoot(textLayoutResult, layoutCoordinates, offsetMapping.originalToTransformed(TextRange.m7698getMaximpl(textFieldValue.m7955getSelectiond9O1mEE())), new Function0() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        IntSize notifyFocusedRect$lambda$0;
                        notifyFocusedRect$lambda$0 = TextFieldDelegate.Companion.notifyFocusedRect$lambda$0(TextDelegate.this);
                        return notifyFocusedRect$lambda$0;
                    }
                }));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IntSize notifyFocusedRect$lambda$0(TextDelegate textDelegate) {
            return IntSize.m8421boximpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null));
        }

        @JvmStatic
        public final void updateTextLayoutResult$foundation(TextInputSession textInputSession, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy) {
            LayoutCoordinates decorationBoxCoordinates;
            final LayoutCoordinates innerTextFieldCoordinates = textLayoutResultProxy.getInnerTextFieldCoordinates();
            if (innerTextFieldCoordinates == null || !innerTextFieldCoordinates.isAttached() || (decorationBoxCoordinates = textLayoutResultProxy.getDecorationBoxCoordinates()) == null) {
                return;
            }
            textInputSession.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResultProxy.getValue(), new Function1<Matrix, Unit>() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Matrix matrix) {
                    m1439invoke58bKbWc(matrix.m5693unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-58bKbWc  reason: not valid java name */
                public final void m1439invoke58bKbWc(float[] fArr) {
                    if (LayoutCoordinates.this.isAttached()) {
                        LayoutCoordinatesKt.findRootCoordinates(LayoutCoordinates.this).mo6890transformFromEL8BTi8(LayoutCoordinates.this, fArr);
                    }
                }
            }, SelectionManagerKt.visibleBounds(innerTextFieldCoordinates), innerTextFieldCoordinates.localBoundingBoxOf(decorationBoxCoordinates, false));
        }

        @JvmStatic
        public final void onEditCommand$foundation(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
            TextFieldValue apply = editProcessor.apply(list);
            if (textInputSession != null) {
                textInputSession.updateState(null, apply);
            }
            function1.invoke(apply);
        }

        @JvmStatic
        /* renamed from: setCursorOffset-ULxng0E$foundation  reason: not valid java name */
        public final void m1438setCursorOffsetULxng0E$foundation(long j, TextLayoutResultProxy textLayoutResultProxy, EditProcessor editProcessor, OffsetMapping offsetMapping, Function1<? super TextFieldValue, Unit> function1) {
            function1.invoke(TextFieldValue.m7950copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1469getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j, false, 2, null))), (TextRange) null, 5, (Object) null));
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, androidx.compose.ui.text.input.TextInputSession] */
        @JvmStatic
        public final TextInputSession restartInput$foundation(TextInputService textInputService, TextFieldValue textFieldValue, final EditProcessor editProcessor, ImeOptions imeOptions, final Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = textInputService.startInput(textFieldValue, imeOptions, new Function1() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit restartInput$lambda$0;
                    restartInput$lambda$0 = TextFieldDelegate.Companion.restartInput$lambda$0(EditProcessor.this, function1, objectRef, (List) obj);
                    return restartInput$lambda$0;
                }
            }, function12);
            return (TextInputSession) objectRef.element;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit restartInput$lambda$0(EditProcessor editProcessor, Function1 function1, Ref.ObjectRef objectRef, List list) {
            TextFieldDelegate.Companion.onEditCommand$foundation(list, editProcessor, function1, (TextInputSession) objectRef.element);
            return Unit.INSTANCE;
        }

        @JvmStatic
        public final TextInputSession onFocus$foundation(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
            return restartInput$foundation(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
        }

        @JvmStatic
        public final void onBlur$foundation(TextInputSession textInputSession, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1) {
            function1.invoke(TextFieldValue.m7950copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        /* renamed from: applyCompositionDecoration-72CqOWE  reason: not valid java name */
        public final TransformedText m1435applyCompositionDecoration72CqOWE(long j, TransformedText transformedText) {
            int originalToTransformed = transformedText.getOffsetMapping().originalToTransformed(TextRange.m7701getStartimpl(j));
            int originalToTransformed2 = transformedText.getOffsetMapping().originalToTransformed(TextRange.m7696getEndimpl(j));
            int min = Math.min(originalToTransformed, originalToTransformed2);
            int max = Math.max(originalToTransformed, originalToTransformed2);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.getText());
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), min, max);
            return new TransformedText(builder.toAnnotatedString(), transformedText.getOffsetMapping());
        }
    }
}

package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: LegacyCursorAnchorInfoBuilder.android.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001ad\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000\u001a,\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001d"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "containsInclusive", "x", "", "y", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyCursorAnchorInfoBuilder_androidKt {
    public static /* synthetic */ CursorAnchorInfo build$default(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        if ((i & 128) != 0) {
            z2 = true;
        }
        if ((i & 256) != 0) {
            z3 = true;
        }
        if ((i & 512) != 0) {
            z4 = true;
        }
        return build(builder, textFieldValue, offsetMapping, textLayoutResult, matrix, rect, rect2, z, z2, z3, z4);
    }

    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int m6145getMinimpl = TextRange.m6145getMinimpl(textFieldValue.m6396getSelectiond9O1mEE());
        builder.setSelectionRange(m6145getMinimpl, TextRange.m6144getMaximpl(textFieldValue.m6396getSelectiond9O1mEE()));
        if (z) {
            setInsertionMarker(builder, m6145getMinimpl, offsetMapping, textLayoutResult, rect);
        }
        if (z2) {
            TextRange m6395getCompositionMzsxiRA = textFieldValue.m6395getCompositionMzsxiRA();
            int m6145getMinimpl2 = m6395getCompositionMzsxiRA != null ? TextRange.m6145getMinimpl(m6395getCompositionMzsxiRA.m6151unboximpl()) : -1;
            TextRange m6395getCompositionMzsxiRA2 = textFieldValue.m6395getCompositionMzsxiRA();
            int m6144getMaximpl = m6395getCompositionMzsxiRA2 != null ? TextRange.m6144getMaximpl(m6395getCompositionMzsxiRA2.m6151unboximpl()) : -1;
            if (m6145getMinimpl2 >= 0 && m6145getMinimpl2 < m6144getMaximpl) {
                builder.setComposingText(m6145getMinimpl2, textFieldValue.getText().subSequence(m6145getMinimpl2, m6144getMaximpl));
                addCharacterBounds(builder, m6145getMinimpl2, m6144getMaximpl, offsetMapping, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        int originalToTransformed = offsetMapping.originalToTransformed(i);
        Rect cursorRect = textLayoutResult.getCursorRect(originalToTransformed);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (int) (textLayoutResult.m6118getSizeYbymL2g() >> 32));
        boolean containsInclusive = containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = containsInclusive(rect, coerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl;
        if (!containsInclusive && !containsInclusive2) {
            i2 = 0;
        }
        if (!containsInclusive || !containsInclusive2) {
            i2 |= 2;
        }
        if (z) {
            i2 |= 4;
        }
        builder.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), i2);
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i, int i2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        int originalToTransformed = offsetMapping.originalToTransformed(i);
        int originalToTransformed2 = offsetMapping.originalToTransformed(i2);
        float[] fArr = new float[(originalToTransformed2 - originalToTransformed) * 4];
        textLayoutResult.getMultiParagraph().m5997fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(originalToTransformed, originalToTransformed2), fArr, 0);
        for (int i3 = i; i3 < i2; i3++) {
            int originalToTransformed3 = offsetMapping.originalToTransformed(i3);
            int i4 = (originalToTransformed3 - originalToTransformed) * 4;
            Rect rect2 = new Rect(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3]);
            boolean overlaps = rect.overlaps(rect2);
            if (!containsInclusive(rect, rect2.getLeft(), rect2.getTop()) || !containsInclusive(rect, rect2.getRight(), rect2.getBottom())) {
                overlaps |= true;
            }
            if (textLayoutResult.getBidiRunDirection(originalToTransformed3) == ResolvedTextDirection.Rtl) {
                overlaps = (overlaps ? 1 : 0) | 4;
            }
            builder.addCharacterBounds(i3, rect2.getLeft(), rect2.getTop(), rect2.getRight(), rect2.getBottom(), overlaps);
        }
        return builder;
    }

    public static final boolean containsInclusive(Rect rect, float f, float f2) {
        float left = rect.getLeft();
        if (f > rect.getRight() || left > f) {
            return false;
        }
        return f2 <= rect.getBottom() && rect.getTop() <= f2;
    }
}

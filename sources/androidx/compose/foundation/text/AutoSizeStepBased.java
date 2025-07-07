package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextAutoSize.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\t*\u00020\u000fH\u0002J\f\u0010\u0010\u001a\u00020\t*\u00020\u000fH\u0002J\f\u0010\u0011\u001a\u00020\t*\u00020\u000fH\u0002J&\u0010\u0012\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "didOverflow", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private AutoSizeStepBased(long j, long j2, long j3) {
        this.minFontSize = j;
        this.maxFontSize = j2;
        this.stepSize = j3;
        if (TextUnit.m6875equalsimpl0(j, TextUnit.Companion.m6889getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
        }
        if (TextUnit.m6875equalsimpl0(j2, TextUnit.Companion.m6889getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }
        if (TextUnit.m6875equalsimpl0(j3, TextUnit.Companion.m6889getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
        }
        if (TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(this.minFontSize), TextUnit.m6877getTypeUIouoOA(j2))) {
            long j4 = this.minFontSize;
            TextUnitKt.m6892checkArithmeticNB67dxo(j4, j2);
            if (Float.compare(TextUnit.m6878getValueimpl(j4), TextUnit.m6878getValueimpl(j2)) > 0) {
                this.minFontSize = j2;
            }
        }
        if (TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(j3), TextUnitType.Companion.m6911getSpUIouoOA())) {
            long sp = TextUnitKt.getSp(1.0E-4f);
            TextUnitKt.m6892checkArithmeticNB67dxo(j3, sp);
            if (Float.compare(TextUnit.m6878getValueimpl(j3), TextUnit.m6878getValueimpl(sp)) < 0) {
                throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
            }
        }
        if (TextUnit.m6878getValueimpl(this.minFontSize) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
        }
        if (TextUnit.m6878getValueimpl(j2) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
        }
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* renamed from: getFontSize-Ci0_558  reason: not valid java name */
    public long mo1036getFontSizeCi0_558(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j, AnnotatedString annotatedString) {
        float f = textAutoSizeLayoutScope.mo388toPxR2X_6o(this.stepSize);
        float f2 = textAutoSizeLayoutScope.mo388toPxR2X_6o(this.minFontSize);
        float f3 = textAutoSizeLayoutScope.mo388toPxR2X_6o(this.maxFontSize);
        float f4 = 2;
        float f5 = (f2 + f3) / f4;
        float f6 = f2;
        float f7 = f3;
        while (f7 - f6 >= f) {
            if (didOverflow(textAutoSizeLayoutScope.mo1430performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo392toSpkPz2Gy4(f5)))) {
                f7 = f5;
            } else {
                f6 = f5;
            }
            f5 = (f6 + f7) / f4;
        }
        float floor = f2 + (((float) Math.floor((f6 - f2) / f)) * f);
        float f8 = f + floor;
        if (f8 <= f3 && !didOverflow(textAutoSizeLayoutScope.mo1430performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo392toSpkPz2Gy4(f8)))) {
            floor = f8;
        }
        return textAutoSizeLayoutScope.mo392toSpkPz2Gy4(floor);
    }

    private final boolean didOverflow(TextLayoutResult textLayoutResult) {
        int m6114getOverflowgIe3tQ8 = textLayoutResult.getLayoutInput().m6114getOverflowgIe3tQ8();
        if (TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6619getClipgIe3tQ8()) ? true : TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6623getVisiblegIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6622getStartEllipsisgIe3tQ8()) ? true : TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6621getMiddleEllipsisgIe3tQ8()) ? true : TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6620getEllipsisgIe3tQ8())) {
            return didOverflowByEllipsize(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.m6612toStringimpl(textLayoutResult.getLayoutInput().m6114getOverflowgIe3tQ8())) + " is not supported.");
    }

    private final boolean didOverflowBounds(TextLayoutResult textLayoutResult) {
        return textLayoutResult.getDidOverflowWidth() || textLayoutResult.getDidOverflowHeight();
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult textLayoutResult) {
        int lineCount = textLayoutResult.getLineCount();
        if (lineCount != 0) {
            if (lineCount == 1) {
                return textLayoutResult.isLineEllipsized(0);
            }
            int m6114getOverflowgIe3tQ8 = textLayoutResult.getLayoutInput().m6114getOverflowgIe3tQ8();
            if (TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6622getStartEllipsisgIe3tQ8()) ? true : TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6621getMiddleEllipsisgIe3tQ8())) {
                return didOverflowBounds(textLayoutResult);
            }
            if (TextOverflow.m6610equalsimpl0(m6114getOverflowgIe3tQ8, TextOverflow.Companion.m6620getEllipsisgIe3tQ8())) {
                return textLayoutResult.isLineEllipsized(textLayoutResult.getLineCount() - 1);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof AutoSizeStepBased)) {
            AutoSizeStepBased autoSizeStepBased = (AutoSizeStepBased) obj;
            return TextUnit.m6875equalsimpl0(autoSizeStepBased.minFontSize, this.minFontSize) && TextUnit.m6875equalsimpl0(autoSizeStepBased.maxFontSize, this.maxFontSize) && TextUnit.m6875equalsimpl0(autoSizeStepBased.stepSize, this.stepSize);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m6879hashCodeimpl(this.minFontSize) * 31) + TextUnit.m6879hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m6879hashCodeimpl(this.stepSize);
    }
}

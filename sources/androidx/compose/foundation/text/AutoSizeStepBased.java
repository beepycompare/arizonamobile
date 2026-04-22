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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        if (TextUnit.m7746equalsimpl0(j, TextUnit.Companion.m7760getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
        }
        if (TextUnit.m7746equalsimpl0(j2, TextUnit.Companion.m7760getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }
        if (TextUnit.m7746equalsimpl0(j3, TextUnit.Companion.m7760getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
        }
        if (TextUnitType.m7777equalsimpl0(TextUnit.m7748getTypeUIouoOA(this.minFontSize), TextUnit.m7748getTypeUIouoOA(j2))) {
            long j4 = this.minFontSize;
            TextUnitKt.m7763checkArithmeticNB67dxo(j4, j2);
            if (Float.compare(TextUnit.m7749getValueimpl(j4), TextUnit.m7749getValueimpl(j2)) > 0) {
                this.minFontSize = j2;
            }
        }
        if (TextUnitType.m7777equalsimpl0(TextUnit.m7748getTypeUIouoOA(j3), TextUnitType.Companion.m7782getSpUIouoOA())) {
            long sp = TextUnitKt.getSp(1.0E-4f);
            TextUnitKt.m7763checkArithmeticNB67dxo(j3, sp);
            if (Float.compare(TextUnit.m7749getValueimpl(j3), TextUnit.m7749getValueimpl(sp)) < 0) {
                throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
            }
        }
        if (TextUnit.m7749getValueimpl(this.minFontSize) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
        }
        if (TextUnit.m7749getValueimpl(j2) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
        }
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* renamed from: getFontSize-Ci0_558  reason: not valid java name */
    public long mo1131getFontSizeCi0_558(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j, AnnotatedString annotatedString) {
        float f = textAutoSizeLayoutScope.mo404toPxR2X_6o(this.stepSize);
        float f2 = textAutoSizeLayoutScope.mo404toPxR2X_6o(this.minFontSize);
        float f3 = textAutoSizeLayoutScope.mo404toPxR2X_6o(this.maxFontSize);
        float f4 = (f2 + f3) / 2.0f;
        float f5 = f2;
        float f6 = f3;
        while (f6 - f5 >= f) {
            if (didOverflow(textAutoSizeLayoutScope.mo1562performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo408toSpkPz2Gy4(f4)))) {
                f6 = f4;
            } else {
                f5 = f4;
            }
            f4 = (f5 + f6) / 2.0f;
        }
        float floor = (((float) Math.floor((f5 - f2) / f)) * f) + f2;
        float f7 = f + floor;
        if (f7 <= f3 && !didOverflow(textAutoSizeLayoutScope.mo1562performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo408toSpkPz2Gy4(f7)))) {
            floor = f7;
        }
        return textAutoSizeLayoutScope.mo408toSpkPz2Gy4(floor);
    }

    private final boolean didOverflow(TextLayoutResult textLayoutResult) {
        int m6970getOverflowgIe3tQ8 = textLayoutResult.getLayoutInput().m6970getOverflowgIe3tQ8();
        if (TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7490getClipgIe3tQ8()) || TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7494getVisiblegIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7493getStartEllipsisgIe3tQ8()) || TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7492getMiddleEllipsisgIe3tQ8()) || TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7491getEllipsisgIe3tQ8())) {
            return didOverflowByEllipsize(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.m7483toStringimpl(textLayoutResult.getLayoutInput().m6970getOverflowgIe3tQ8())) + " is not supported.");
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
            int m6970getOverflowgIe3tQ8 = textLayoutResult.getLayoutInput().m6970getOverflowgIe3tQ8();
            if (TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7493getStartEllipsisgIe3tQ8()) || TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7492getMiddleEllipsisgIe3tQ8())) {
                return didOverflowBounds(textLayoutResult);
            }
            if (TextOverflow.m7481equalsimpl0(m6970getOverflowgIe3tQ8, TextOverflow.Companion.m7491getEllipsisgIe3tQ8())) {
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
            return TextUnit.m7746equalsimpl0(autoSizeStepBased.minFontSize, this.minFontSize) && TextUnit.m7746equalsimpl0(autoSizeStepBased.maxFontSize, this.maxFontSize) && TextUnit.m7746equalsimpl0(autoSizeStepBased.stepSize, this.stepSize);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m7750hashCodeimpl(this.minFontSize) * 31) + TextUnit.m7750hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m7750hashCodeimpl(this.stepSize);
    }
}

package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
/* compiled from: PlaceholderExtensions.android.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", TtmlNode.START, TtmlNode.END, "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o$annotations  reason: not valid java name */
    private static /* synthetic */ void m6421getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations  reason: not valid java name */
    private static /* synthetic */ void m6423getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        for (Object obj : spannable.getSpans(i, i2, EmojiSpan.class)) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m6878getValueimpl(placeholder.m6050getWidthXSAIIZE()), m6420getSpanUnitR2X_6o(placeholder.m6050getWidthXSAIIZE()), TextUnit.m6878getValueimpl(placeholder.m6048getHeightXSAIIZE()), m6420getSpanUnitR2X_6o(placeholder.m6048getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m6422getSpanVerticalAligndo9XGg(placeholder.m6049getPlaceholderVerticalAlignJ6kI3mc())), i, i2);
    }

    /* renamed from: getSpanUnit--R2X_6o  reason: not valid java name */
    private static final int m6420getSpanUnitR2X_6o(long j) {
        long m6877getTypeUIouoOA = TextUnit.m6877getTypeUIouoOA(j);
        if (TextUnitType.m6906equalsimpl0(m6877getTypeUIouoOA, TextUnitType.Companion.m6911getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m6906equalsimpl0(m6877getTypeUIouoOA, TextUnitType.Companion.m6910getEmUIouoOA()) ? 1 : 2;
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg  reason: not valid java name */
    private static final int m6422getSpanVerticalAligndo9XGg(int i) {
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6058getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6064getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6059getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6060getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6063getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6061getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m6054equalsimpl0(i, PlaceholderVerticalAlign.Companion.m6062getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    public static final void setPlaceholders(Spannable spannable, List<AnnotatedString.Range<Placeholder>> list, Density density) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }
}

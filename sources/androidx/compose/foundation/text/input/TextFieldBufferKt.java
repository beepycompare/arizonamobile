package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;
/* compiled from: TextFieldBuffer.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a{\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2`\u0010\u000e\u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u000fH\u0080\b\u001a\u001a\u0010\u0016\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004\u001aE\u0010\u001a\u001a\u00020\n*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u001dH\u0087\b\u001aE\u0010\u001f\u001a\u00020\n*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u001dH\u0087\b\u001a\u001a\u0010 \u001a\u00020\n*\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#\u001a\n\u0010$\u001a\u00020\n*\u00020\u0017\u001a\n\u0010%\u001a\u00020\n*\u00020\u0017\u001a\u001e\u0010&\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"adjustTextRange", "Landroidx/compose/ui/text/TextRange;", "originalRange", "replaceStart", "", "replaceEnd", "insertedTextLength", "adjustTextRange-vJH6DeI", "(JIII)J", "findCommonPrefixAndSuffix", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "onFound", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "delete", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", TtmlNode.START, TtmlNode.END, "forEachChange", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "block", "Lkotlin/Function2;", "range", "forEachChangeReversed", "insert", FirebaseAnalytics.Param.INDEX, "text", "", "placeCursorAtEnd", "selectAll", "setSelectionCoerced", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldBufferKt {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 == r1) goto L12;
     */
    /* renamed from: adjustTextRange-vJH6DeI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long m1201adjustTextRangevJH6DeI(long j, int i, int i2, int i3) {
        int i4;
        int m6145getMinimpl = TextRange.m6145getMinimpl(j);
        int m6144getMaximpl = TextRange.m6144getMaximpl(j);
        if (m6144getMaximpl < i) {
            return j;
        }
        if (m6145getMinimpl > i || i2 > m6144getMaximpl) {
            if (m6145getMinimpl > i && m6144getMaximpl < i2) {
                i += i3;
                m6145getMinimpl = i;
            } else if (m6145getMinimpl >= i2) {
                i4 = i3 - (i2 - i);
                m6145getMinimpl += i4;
                i = m6144getMaximpl + i4;
            } else if (i < m6145getMinimpl) {
                m6145getMinimpl = i + i3;
                i4 = i3 - (i2 - i);
                i = m6144getMaximpl + i4;
            }
            return TextRangeKt.TextRange(m6145getMinimpl, i);
        }
        i4 = i3 - (i2 - i);
    }

    public static final void insert(TextFieldBuffer textFieldBuffer, int i, String str) {
        textFieldBuffer.replace(i, i, str);
    }

    public static final void delete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        textFieldBuffer.replace(i, i2, "");
    }

    public static final void placeCursorAtEnd(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.placeCursorBeforeCharAt(textFieldBuffer.getLength());
    }

    public static final void selectAll(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
    }

    public static final void forEachChange(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int i = 0; i < changeList.getChangeCount(); i++) {
            function2.invoke(TextRange.m6135boximpl(changeList.mo1200getRangejx7JFs(i)), TextRange.m6135boximpl(changeList.mo1199getOriginalRangejx7JFs(i)));
        }
    }

    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int changeCount = changeList.getChangeCount() - 1; changeCount >= 0; changeCount--) {
            function2.invoke(TextRange.m6135boximpl(changeList.mo1200getRangejx7JFs(changeCount)), TextRange.m6135boximpl(changeList.mo1199getOriginalRangejx7JFs(changeCount)));
        }
    }

    public static final void findCommonPrefixAndSuffix(CharSequence charSequence, CharSequence charSequence2, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        int i;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = 0;
        if (charSequence.length() <= 0 || charSequence2.length() <= 0) {
            i = 0;
        } else {
            int i3 = 0;
            i = 0;
            boolean z = false;
            while (true) {
                if (i2 == 0) {
                    if (charSequence.charAt(i3) == charSequence2.charAt(i)) {
                        i3++;
                        i++;
                    } else {
                        i2 = 1;
                    }
                }
                if (!z) {
                    if (charSequence.charAt(length - 1) == charSequence2.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z = true;
                    }
                }
                if (i3 >= length || i >= length2 || (i2 != 0 && z)) {
                    break;
                }
            }
            i2 = i3;
        }
        if (i2 < length || i < length2) {
            function4.invoke(Integer.valueOf(i2), Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(length2));
        }
    }

    public static /* synthetic */ void setSelectionCoerced$default(TextFieldBuffer textFieldBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        setSelectionCoerced(textFieldBuffer, i, i2);
    }

    public static final void setSelectionCoerced(TextFieldBuffer textFieldBuffer, int i, int i2) {
        textFieldBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i, 0, textFieldBuffer.getLength()), RangesKt.coerceIn(i2, 0, textFieldBuffer.getLength())));
    }
}

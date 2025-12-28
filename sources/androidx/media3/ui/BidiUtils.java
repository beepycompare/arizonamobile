package androidx.media3.ui;

import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextDirectionHeuristics;
import androidx.media3.common.util.Log;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
/* loaded from: classes3.dex */
final class BidiUtils {
    private static final String TAG = "BidiUtils";
    private static final Splitter LF_SPLITTER = Splitter.on("\n");
    private static final Splitter CRLF_SPLITTER = Splitter.on("\r\n");
    private static final Joiner LF_JOINER = Joiner.on("\n");

    BidiUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    public static boolean containsRtl(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int codePointAt = Character.codePointAt(charSequence, i);
            byte directionality = Character.getDirectionality(codePointAt);
            if (directionality == 1 || directionality == 2 || directionality == 16 || directionality == 17) {
                return true;
            }
            i += Character.charCount(codePointAt);
        }
        return false;
    }

    public static CharSequence wrapText(CharSequence charSequence) {
        Spanned spanned;
        Object[] objArr;
        int[] iArr;
        int[] iArr2;
        List<String> splitToList;
        int i;
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        int i2 = 0;
        if (charSequence instanceof Spanned) {
            spanned = (Spanned) charSequence;
            objArr = spanned.getSpans(0, charSequence.length(), Object.class);
            iArr = new int[objArr.length];
            iArr2 = new int[objArr.length];
            Arrays.fill(iArr, -1);
            Arrays.fill(iArr2, -1);
        } else {
            spanned = null;
            objArr = null;
            iArr = null;
            iArr2 = null;
        }
        if (charSequence.toString().contains("\r\n")) {
            splitToList = CRLF_SPLITTER.splitToList(charSequence);
            i = 2;
        } else {
            splitToList = LF_SPLITTER.splitToList(charSequence);
            i = 1;
        }
        ArrayList arrayList = new ArrayList(splitToList.size());
        int i3 = 0;
        int i4 = 0;
        for (String str : splitToList) {
            String unicodeWrap = bidiFormatter.unicodeWrap(str, TextDirectionHeuristics.LTR);
            if (objArr != null) {
                Preconditions.checkNotNull(spanned);
                Preconditions.checkNotNull(iArr);
                Preconditions.checkNotNull(iArr2);
                int length = unicodeWrap.length() - str.length();
                if (length > 0) {
                    i3++;
                }
                for (int i5 = i2; i5 < objArr.length; i5++) {
                    if (iArr[i5] < 0 && spanned.getSpanStart(objArr[i5]) >= i4) {
                        if (spanned.getSpanStart(objArr[i5]) < i4 + str.length()) {
                            iArr[i5] = i3;
                        }
                    }
                    if (iArr2[i5] < 0 && spanned.getSpanEnd(objArr[i5]) - 1 >= i4 && spanned.getSpanEnd(objArr[i5]) - 1 < str.length() + i4) {
                        iArr2[i5] = i3;
                    }
                }
                i4 += str.length() + i;
                if (length > 0) {
                    i3++;
                }
            }
            arrayList.add(unicodeWrap);
            i2 = 0;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LF_JOINER.join(arrayList));
        if (objArr != null) {
            Preconditions.checkNotNull(spanned);
            Preconditions.checkNotNull(iArr);
            Preconditions.checkNotNull(iArr2);
            for (int i6 = 0; i6 < objArr.length; i6++) {
                int spanStart = spanned.getSpanStart(objArr[i6]) + iArr[i6];
                int spanEnd = spanned.getSpanEnd(objArr[i6]) + iArr2[i6];
                int spanFlags = spanned.getSpanFlags(objArr[i6]);
                if (spanStart >= 0 && spanStart < spannableStringBuilder.length() && spanEnd >= 0 && spanEnd <= spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(objArr[i6], spanStart, spanEnd, spanFlags);
                } else {
                    Log.w(TAG, "Span out of bounds: start=" + spanStart + ",end=" + spanEnd + ",len=" + spannableStringBuilder.length());
                }
            }
        }
        return spannableStringBuilder;
    }
}

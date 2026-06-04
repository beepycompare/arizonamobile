package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* compiled from: SpannableString.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0086\b\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\n\u001a\u001d\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0086\n¨\u0006\r"}, d2 = {"toSpannable", "Landroid/text/Spannable;", "", "clearSpans", "", "set", TtmlNode.START, "", TtmlNode.END, TtmlNode.TAG_SPAN, "", "range", "Lkotlin/ranges/IntRange;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    public static final void clearSpans(Spannable spannable) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Spannable spannable2 = spannable;
        Object[] spans = spannable2.getSpans(0, spannable2.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object span) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(span, "span");
        spannable.setSpan(span, i, i2, 17);
    }

    public static final void set(Spannable spannable, IntRange range, Object span) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(span, "span");
        spannable.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}

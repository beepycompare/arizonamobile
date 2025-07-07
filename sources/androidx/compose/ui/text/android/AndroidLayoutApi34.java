package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.GraphemeClusterSegmentFinder;
import android.text.Layout;
import android.text.SegmentFinder;
import androidx.compose.ui.text.android.selection.Api34SegmentFinder;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
/* compiled from: TextLayout.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/android/AndroidLayoutApi34;", "", "()V", "getRangeForRect", "", TtmlNode.TAG_LAYOUT, "Landroidx/compose/ui/text/android/TextLayout;", "rectF", "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidLayoutApi34 {
    public static final int $stable = 0;
    public static final AndroidLayoutApi34 INSTANCE = new AndroidLayoutApi34();

    private AndroidLayoutApi34() {
    }

    public final int[] getRangeForRect$ui_text_release(TextLayout textLayout, RectF rectF, int i, final Function2<? super RectF, ? super RectF, Boolean> function2) {
        SegmentFinder segmentFinder;
        if (i == 1) {
            segmentFinder = Api34SegmentFinder.INSTANCE.toAndroidSegmentFinder$ui_text_release(new WordSegmentFinder(textLayout.getText(), textLayout.getWordIterator()));
        } else {
            segmentFinder = (SegmentFinder) new GraphemeClusterSegmentFinder(textLayout.getText(), textLayout.getTextPaint());
        }
        return textLayout.getLayout().getRangeForRect(rectF, segmentFinder, new Layout.TextInclusionStrategy() { // from class: androidx.compose.ui.text.android.AndroidLayoutApi34$$ExternalSyntheticLambda0
            public final boolean isSegmentInside(RectF rectF2, RectF rectF3) {
                boolean rangeForRect$lambda$0;
                rangeForRect$lambda$0 = AndroidLayoutApi34.getRangeForRect$lambda$0(Function2.this, rectF2, rectF3);
                return rangeForRect$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRangeForRect$lambda$0(Function2 function2, RectF rectF, RectF rectF2) {
        return ((Boolean) function2.invoke(rectF, rectF2)).booleanValue();
    }
}

package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m6310updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m6143getLengthimpl;
        int m6145getMinimpl = TextRange.m6145getMinimpl(j);
        int m6144getMaximpl = TextRange.m6144getMaximpl(j);
        if (TextRange.m6149intersects5zctL8(j2, j)) {
            if (TextRange.m6137contains5zctL8(j2, j)) {
                m6145getMinimpl = TextRange.m6145getMinimpl(j2);
                m6144getMaximpl = m6145getMinimpl;
            } else {
                if (TextRange.m6137contains5zctL8(j, j2)) {
                    m6143getLengthimpl = TextRange.m6143getLengthimpl(j2);
                } else if (TextRange.m6138containsimpl(j2, m6145getMinimpl)) {
                    m6145getMinimpl = TextRange.m6145getMinimpl(j2);
                    m6143getLengthimpl = TextRange.m6143getLengthimpl(j2);
                } else {
                    m6144getMaximpl = TextRange.m6145getMinimpl(j2);
                }
                m6144getMaximpl -= m6143getLengthimpl;
            }
        } else if (m6144getMaximpl > TextRange.m6145getMinimpl(j2)) {
            m6145getMinimpl -= TextRange.m6143getLengthimpl(j2);
            m6143getLengthimpl = TextRange.m6143getLengthimpl(j2);
            m6144getMaximpl -= m6143getLengthimpl;
        }
        return TextRangeKt.TextRange(m6145getMinimpl, m6144getMaximpl);
    }
}

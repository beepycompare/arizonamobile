package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m7772updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m7604getLengthimpl;
        int m7606getMinimpl = TextRange.m7606getMinimpl(j);
        int m7605getMaximpl = TextRange.m7605getMaximpl(j);
        if (TextRange.m7610intersects5zctL8(j2, j)) {
            if (TextRange.m7598contains5zctL8(j2, j)) {
                m7606getMinimpl = TextRange.m7606getMinimpl(j2);
                m7605getMaximpl = m7606getMinimpl;
            } else {
                if (TextRange.m7598contains5zctL8(j, j2)) {
                    m7604getLengthimpl = TextRange.m7604getLengthimpl(j2);
                } else if (TextRange.m7599containsimpl(j2, m7606getMinimpl)) {
                    m7606getMinimpl = TextRange.m7606getMinimpl(j2);
                    m7604getLengthimpl = TextRange.m7604getLengthimpl(j2);
                } else {
                    m7605getMaximpl = TextRange.m7606getMinimpl(j2);
                }
                m7605getMaximpl -= m7604getLengthimpl;
            }
        } else if (m7605getMaximpl > TextRange.m7606getMinimpl(j2)) {
            m7606getMinimpl -= TextRange.m7604getLengthimpl(j2);
            m7604getLengthimpl = TextRange.m7604getLengthimpl(j2);
            m7605getMaximpl -= m7604getLengthimpl;
        }
        return TextRangeKt.TextRange(m7606getMinimpl, m7605getMaximpl);
    }
}

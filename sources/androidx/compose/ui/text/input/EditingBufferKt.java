package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m6878updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m6709getLengthimpl;
        int m6711getMinimpl = TextRange.m6711getMinimpl(j);
        int m6710getMaximpl = TextRange.m6710getMaximpl(j);
        if (TextRange.m6715intersects5zctL8(j2, j)) {
            if (TextRange.m6703contains5zctL8(j2, j)) {
                m6711getMinimpl = TextRange.m6711getMinimpl(j2);
                m6710getMaximpl = m6711getMinimpl;
            } else {
                if (TextRange.m6703contains5zctL8(j, j2)) {
                    m6709getLengthimpl = TextRange.m6709getLengthimpl(j2);
                } else if (TextRange.m6704containsimpl(j2, m6711getMinimpl)) {
                    m6711getMinimpl = TextRange.m6711getMinimpl(j2);
                    m6709getLengthimpl = TextRange.m6709getLengthimpl(j2);
                } else {
                    m6710getMaximpl = TextRange.m6711getMinimpl(j2);
                }
                m6710getMaximpl -= m6709getLengthimpl;
            }
        } else if (m6710getMaximpl > TextRange.m6711getMinimpl(j2)) {
            m6711getMinimpl -= TextRange.m6709getLengthimpl(j2);
            m6709getLengthimpl = TextRange.m6709getLengthimpl(j2);
            m6710getMaximpl -= m6709getLengthimpl;
        }
        return TextRangeKt.TextRange(m6711getMinimpl, m6710getMaximpl);
    }
}

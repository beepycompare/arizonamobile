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
    public static final long m7623updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m7454getLengthimpl;
        int m7456getMinimpl = TextRange.m7456getMinimpl(j);
        int m7455getMaximpl = TextRange.m7455getMaximpl(j);
        if (TextRange.m7460intersects5zctL8(j2, j)) {
            if (TextRange.m7448contains5zctL8(j2, j)) {
                m7456getMinimpl = TextRange.m7456getMinimpl(j2);
                m7455getMaximpl = m7456getMinimpl;
            } else {
                if (TextRange.m7448contains5zctL8(j, j2)) {
                    m7454getLengthimpl = TextRange.m7454getLengthimpl(j2);
                } else if (TextRange.m7449containsimpl(j2, m7456getMinimpl)) {
                    m7456getMinimpl = TextRange.m7456getMinimpl(j2);
                    m7454getLengthimpl = TextRange.m7454getLengthimpl(j2);
                } else {
                    m7455getMaximpl = TextRange.m7456getMinimpl(j2);
                }
                m7455getMaximpl -= m7454getLengthimpl;
            }
        } else if (m7455getMaximpl > TextRange.m7456getMinimpl(j2)) {
            m7456getMinimpl -= TextRange.m7454getLengthimpl(j2);
            m7454getLengthimpl = TextRange.m7454getLengthimpl(j2);
            m7455getMaximpl -= m7454getLengthimpl;
        }
        return TextRangeKt.TextRange(m7456getMinimpl, m7455getMaximpl);
    }
}

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
    public static final long m7622updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m7453getLengthimpl;
        int m7455getMinimpl = TextRange.m7455getMinimpl(j);
        int m7454getMaximpl = TextRange.m7454getMaximpl(j);
        if (TextRange.m7459intersects5zctL8(j2, j)) {
            if (TextRange.m7447contains5zctL8(j2, j)) {
                m7455getMinimpl = TextRange.m7455getMinimpl(j2);
                m7454getMaximpl = m7455getMinimpl;
            } else {
                if (TextRange.m7447contains5zctL8(j, j2)) {
                    m7453getLengthimpl = TextRange.m7453getLengthimpl(j2);
                } else if (TextRange.m7448containsimpl(j2, m7455getMinimpl)) {
                    m7455getMinimpl = TextRange.m7455getMinimpl(j2);
                    m7453getLengthimpl = TextRange.m7453getLengthimpl(j2);
                } else {
                    m7454getMaximpl = TextRange.m7455getMinimpl(j2);
                }
                m7454getMaximpl -= m7453getLengthimpl;
            }
        } else if (m7454getMaximpl > TextRange.m7455getMinimpl(j2)) {
            m7455getMinimpl -= TextRange.m7453getLengthimpl(j2);
            m7453getLengthimpl = TextRange.m7453getLengthimpl(j2);
            m7454getMaximpl -= m7453getLengthimpl;
        }
        return TextRangeKt.TextRange(m7455getMinimpl, m7454getMaximpl);
    }
}

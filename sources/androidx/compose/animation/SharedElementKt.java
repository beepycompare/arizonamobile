package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
/* compiled from: SharedElement.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"hasVisibleContent", "", "", "Landroidx/compose/animation/SharedElementEntry;", "DefaultMomentumSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "toOffset", "Landroidx/compose/ui/unit/Velocity;", "toOffset-TH1AsA0", "(J)J", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElementKt {
    private static final SpringSpec<Offset> DefaultMomentumSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, Offset.m4516boximpl(Offset.m4519constructorimpl((Float.floatToRawIntBits(3.0f) << 32) | (Float.floatToRawIntBits(3.0f) & 4294967295L))), 1, null);

    public static final /* synthetic */ boolean access$hasVisibleContent(List list) {
        return hasVisibleContent(list);
    }

    /* renamed from: toOffset-TH1AsA0 */
    public static final long m122toOffsetTH1AsA0(long j) {
        float m7793getXimpl = Velocity.m7793getXimpl(j);
        return Offset.m4519constructorimpl((Float.floatToRawIntBits(Velocity.m7794getYimpl(j)) & 4294967295L) | (Float.floatToRawIntBits(m7793getXimpl) << 32));
    }

    public static final boolean hasVisibleContent(List<SharedElementEntry> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }
}

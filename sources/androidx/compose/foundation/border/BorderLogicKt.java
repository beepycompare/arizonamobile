package androidx.compose.foundation.border;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
/* compiled from: BorderLogic.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "", "fillArea", "", "createInsetRoundedRect", "widthPx", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderLogicKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        Path.addRoundRect$default(path, roundRect, null, 2, null);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path, createInsetRoundedRect(f, roundRect), null, 2, null);
            path.mo5237opN5in7k0(path, Path, PathOperation.Companion.m5654getDifferenceb3I0S0c());
        }
        return path;
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(roundRect.getLeft() + f, roundRect.getTop() + f, roundRect.getRight() - f, roundRect.getBottom() - f, m382shrinkKibmq7A(roundRect.m5153getTopLeftCornerRadiuskKHJgLs(), f), m382shrinkKibmq7A(roundRect.m5154getTopRightCornerRadiuskKHJgLs(), f), m382shrinkKibmq7A(roundRect.m5152getBottomRightCornerRadiuskKHJgLs(), f), m382shrinkKibmq7A(roundRect.m5151getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A  reason: not valid java name */
    public static final long m382shrinkKibmq7A(long j, float f) {
        return CornerRadius.m5057constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f)) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f)) & 4294967295L));
    }
}

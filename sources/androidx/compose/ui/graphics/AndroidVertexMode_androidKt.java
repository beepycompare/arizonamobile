package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
/* compiled from: AndroidVertexMode.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidVertexMode_androidKt {
    /* renamed from: toAndroidVertexMode-JOOmi9M  reason: not valid java name */
    public static final Canvas.VertexMode m5252toAndroidVertexModeJOOmi9M(int i) {
        return VertexMode.m5766equalsimpl0(i, VertexMode.Companion.m5772getTrianglesc2xauaI()) ? Canvas.VertexMode.TRIANGLES : VertexMode.m5766equalsimpl0(i, VertexMode.Companion.m5771getTriangleStripc2xauaI()) ? Canvas.VertexMode.TRIANGLE_STRIP : VertexMode.m5766equalsimpl0(i, VertexMode.Companion.m5770getTriangleFanc2xauaI()) ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
    }
}

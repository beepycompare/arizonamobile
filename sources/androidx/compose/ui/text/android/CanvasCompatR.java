package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: TextAndroidCanvas.android.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatR;", "", "()V", "quickReject", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CanvasCompatR {
    public static final CanvasCompatR INSTANCE = new CanvasCompatR();

    private CanvasCompatR() {
    }

    public final boolean quickReject(Canvas canvas, RectF rectF) {
        return canvas.quickReject(rectF);
    }

    public final boolean quickReject(Canvas canvas, Path path) {
        return canvas.quickReject(path);
    }

    public final boolean quickReject(Canvas canvas, float f, float f2, float f3, float f4) {
        return canvas.quickReject(f, f2, f3, f4);
    }
}

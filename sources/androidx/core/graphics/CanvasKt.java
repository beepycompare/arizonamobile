package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Canvas.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a=\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001aG\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001aQ\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a=\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a3\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a1\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a1\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00162\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001aI\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001aI\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001a1\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"withSave", "", "Landroid/graphics/Canvas;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withTranslation", "x", "", "y", "withRotation", "degrees", "pivotX", "pivotY", "withScale", "withSkew", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withClip", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "clipPath", "Landroid/graphics/Path;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CanvasKt {
    public static final void withSave(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, Rect clipRect, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, RectF clipRect, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, Path clipPath, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(clipPath, "clipPath");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}

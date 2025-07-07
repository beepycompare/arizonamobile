package coil3.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import kotlin.Metadata;
/* compiled from: transformations.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u0007"}, d2 = {"newScaledShaderPaint", "Landroid/graphics/Paint;", "input", "Landroid/graphics/Bitmap;", "outputWidth", "", "outputHeight", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransformationsKt {
    public static final Paint newScaledShaderPaint(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        float computeSizeMultiplier = (float) DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), i, i2, Scale.FILL);
        float f = 2;
        matrix.setTranslate((i - (bitmap.getWidth() * computeSizeMultiplier)) / f, (i2 - (bitmap.getHeight() * computeSizeMultiplier)) / f);
        matrix.preScale(computeSizeMultiplier, computeSizeMultiplier);
        Paint paint = new Paint(3);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        return paint;
    }
}

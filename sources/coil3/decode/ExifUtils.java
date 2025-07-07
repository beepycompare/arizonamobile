package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import okio.BufferedSource;
/* compiled from: ExifUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil3/decode/ExifUtils;", "", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "getExifData", "Lcoil3/decode/ExifData;", "mimeType", "", "source", "Lokio/BufferedSource;", "strategy", "Lcoil3/decode/ExifOrientationStrategy;", "reverseTransformations", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExifUtils {
    public static final ExifUtils INSTANCE = new ExifUtils();
    private static final Paint paint = new Paint(3);

    private ExifUtils() {
    }

    public final ExifData getExifData(String str, BufferedSource bufferedSource, ExifOrientationStrategy exifOrientationStrategy) {
        if (exifOrientationStrategy.supports(str, bufferedSource)) {
            ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(bufferedSource.peek().inputStream()));
            return new ExifData(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
        }
        return ExifData.NONE;
    }

    public final Bitmap reverseTransformations(Bitmap bitmap, ExifData exifData) {
        Bitmap createBitmap;
        if (exifData.isFlipped() || ExifUtilsKt.isRotated(exifData)) {
            Matrix matrix = new Matrix();
            float width = bitmap.getWidth() / 2.0f;
            float height = bitmap.getHeight() / 2.0f;
            if (exifData.isFlipped()) {
                matrix.postScale(-1.0f, 1.0f, width, height);
            }
            if (ExifUtilsKt.isRotated(exifData)) {
                matrix.postRotate(exifData.getRotationDegrees(), width, height);
            }
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            if (rectF.left != 0.0f || rectF.top != 0.0f) {
                matrix.postTranslate(-rectF.left, -rectF.top);
            }
            if (ExifUtilsKt.isSwapped(exifData)) {
                createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), BitmapsKt.getSafeConfig(bitmap));
            } else {
                createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), BitmapsKt.getSafeConfig(bitmap));
            }
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
            bitmap.recycle();
            return createBitmap;
        }
        return bitmap;
    }
}

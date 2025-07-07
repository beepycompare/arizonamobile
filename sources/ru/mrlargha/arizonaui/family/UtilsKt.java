package ru.mrlargha.arizonaui.family;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"textChanges", "Lkotlinx/coroutines/flow/Flow;", "", "Landroid/widget/EditText;", "applyGradientMask", "Landroid/graphics/Bitmap;", "original", "ArizonaUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final Flow<String> textChanges(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        return FlowKt.callbackFlow(new UtilsKt$textChanges$1(editText, null));
    }

    public static final Bitmap applyGradientMask(Bitmap original) {
        Intrinsics.checkNotNullParameter(original, "original");
        int width = original.getWidth();
        int height = original.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(original, 0.0f, 0.0f, (Paint) null);
        float f = width;
        LinearGradient linearGradient = new LinearGradient(f, 0.0f, 0.0f, 0.0f, 0, (int) ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#99202325"));
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(linearGradient);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, 0.0f, f, f2, paint2);
        return createBitmap;
    }
}

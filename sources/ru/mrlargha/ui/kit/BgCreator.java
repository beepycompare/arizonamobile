package ru.mrlargha.ui.kit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BgCreator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/ui/kit/BgCreator;", "", "<init>", "()V", "createAndSaveGradientCircle", "", "context", "Landroid/content/Context;", "ui-kit"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BgCreator {
    public final void createAndSaveGradientCircle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        float f = i / 2.0f;
        float f2 = i2;
        float f3 = f2 / 2.0f;
        float f4 = f2 / 3.0f;
        RadialGradient radialGradient = new RadialGradient(f, f3, f4, new int[]{-65281, -16776961, -16777216}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint(1);
        paint.setShader(radialGradient);
        canvas.drawCircle(f, f3, f4, paint);
        File file = new File(context.getExternalFilesDir(null), "modloader/hud/cef3d");
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            Log.e("BgCreator", "Error make directory " + parentFile.getAbsolutePath());
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            CloseableKt.closeFinally(fileOutputStream, null);
            System.out.println((Object) ("✅ Сохранено: " + file.getAbsolutePath()));
        } finally {
        }
    }
}

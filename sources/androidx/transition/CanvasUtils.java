package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enableZ(Canvas canvas, boolean z) {
        Method method;
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                Api29Impl.enableZ(canvas);
            } else {
                Api29Impl.disableZ(canvas);
            }
        } else if (Build.VERSION.SDK_INT == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        } else {
            if (!sOrderMethodsFetched) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    sReorderBarrierMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    sInorderBarrierMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sOrderMethodsFetched = true;
            }
            if (z) {
                try {
                    Method method2 = sReorderBarrierMethod;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
            if (z || (method = sInorderBarrierMethod) == null) {
                return;
            }
            method.invoke(canvas, new Object[0]);
        }
    }

    private CanvasUtils() {
    }

    /* loaded from: classes3.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }

        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }
    }
}

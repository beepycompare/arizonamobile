package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsApi19 IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.getTransitionAlpha(view));
            }

            @Override // android.util.Property
            public void set(View view, Float f) {
                ViewUtils.setTransitionAlpha(view, f.floatValue());
            }
        };
        CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            public Rect get(View view) {
                return view.getClipBounds();
            }

            @Override // android.util.Property
            public void set(View view, Rect rect) {
                view.setClipBounds(rect);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    private ViewUtils() {
    }
}

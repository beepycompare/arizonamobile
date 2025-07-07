package androidx.core.view.insets;

import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SystemBarStateMonitor {
    private int mColorHint;
    private final View mDetector;
    private final ArrayList<Callback> mCallbacks = new ArrayList<>();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;

    /* loaded from: classes2.dex */
    interface Callback {
        void onAnimationEnd();

        void onAnimationProgress(int i, Insets insets, RectF rectF);

        void onAnimationStart();

        void onColorHintChanged(int i);

        void onInsetsChanged(Insets insets, Insets insets2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemBarStateMonitor(final ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        this.mColorHint = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        View view = new View(viewGroup.getContext()) { // from class: androidx.core.view.insets.SystemBarStateMonitor.1
            @Override // android.view.View
            protected void onConfigurationChanged(Configuration configuration) {
                Drawable background2 = viewGroup.getBackground();
                int color = background2 instanceof ColorDrawable ? ((ColorDrawable) background2).getColor() : 0;
                if (SystemBarStateMonitor.this.mColorHint != color) {
                    SystemBarStateMonitor.this.mColorHint = color;
                    for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                        ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onColorHintChanged(color);
                    }
                }
            }
        };
        this.mDetector = view;
        view.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: androidx.core.view.insets.SystemBarStateMonitor$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return SystemBarStateMonitor.this.m7205lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(view2, windowInsetsCompat);
            }
        });
        ViewCompat.setWindowInsetsAnimationCallback(view, new WindowInsetsAnimationCompat.Callback(0) { // from class: androidx.core.view.insets.SystemBarStateMonitor.2
            private final HashMap<WindowInsetsAnimationCompat, Integer> mAnimationSidesMap = new HashMap<>();

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                if (animatesSystemBars(windowInsetsAnimationCompat)) {
                    for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                        ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onAnimationStart();
                    }
                }
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
                if (animatesSystemBars(windowInsetsAnimationCompat)) {
                    Insets upperBound = boundsCompat.getUpperBound();
                    Insets lowerBound = boundsCompat.getLowerBound();
                    int i = upperBound.left != lowerBound.left ? 1 : 0;
                    if (upperBound.top != lowerBound.top) {
                        i |= 2;
                    }
                    if (upperBound.right != lowerBound.right) {
                        i |= 4;
                    }
                    if (upperBound.bottom != lowerBound.bottom) {
                        i |= 8;
                    }
                    this.mAnimationSidesMap.put(windowInsetsAnimationCompat, Integer.valueOf(i));
                    return boundsCompat;
                }
                return boundsCompat;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
                RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
                int i = 0;
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = list.get(size);
                    Integer num = this.mAnimationSidesMap.get(windowInsetsAnimationCompat);
                    if (num != null) {
                        int intValue = num.intValue();
                        float alpha = windowInsetsAnimationCompat.getAlpha();
                        if ((intValue & 1) != 0) {
                            rectF.left = alpha;
                        }
                        if ((intValue & 2) != 0) {
                            rectF.top = alpha;
                        }
                        if ((intValue & 4) != 0) {
                            rectF.right = alpha;
                        }
                        if ((intValue & 8) != 0) {
                            rectF.bottom = alpha;
                        }
                        i |= intValue;
                    }
                }
                Insets insets = SystemBarStateMonitor.this.getInsets(windowInsetsCompat);
                for (int size2 = SystemBarStateMonitor.this.mCallbacks.size() - 1; size2 >= 0; size2--) {
                    ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size2)).onAnimationProgress(i, insets, rectF);
                }
                return windowInsetsCompat;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                if (animatesSystemBars(windowInsetsAnimationCompat)) {
                    this.mAnimationSidesMap.remove(windowInsetsAnimationCompat);
                    for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                        ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onAnimationEnd();
                    }
                }
            }

            private boolean animatesSystemBars(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.systemBars()) != 0;
            }
        });
        viewGroup.addView(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-core-view-insets-SystemBarStateMonitor  reason: not valid java name */
    public /* synthetic */ WindowInsetsCompat m7205lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = getInsets(windowInsetsCompat);
        Insets insetsIgnoringVisibility = getInsetsIgnoringVisibility(windowInsetsCompat);
        if (!insets.equals(this.mInsets) || !insetsIgnoringVisibility.equals(this.mInsetsIgnoringVisibility)) {
            this.mInsets = insets;
            this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                this.mCallbacks.get(size).onInsetsChanged(insets, insetsIgnoringVisibility);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Insets getInsets(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.tappableElement()));
    }

    private Insets getInsetsIgnoringVisibility(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCallback(Callback callback) {
        if (this.mCallbacks.contains(callback)) {
            return;
        }
        this.mCallbacks.add(callback);
        callback.onInsetsChanged(this.mInsets, this.mInsetsIgnoringVisibility);
        callback.onColorHintChanged(this.mColorHint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCallback() {
        return !this.mCallbacks.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachFromWindow() {
        this.mDetector.post(new Runnable() { // from class: androidx.core.view.insets.SystemBarStateMonitor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SystemBarStateMonitor.this.m7204xf3edbe07();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$detachFromWindow$1$androidx-core-view-insets-SystemBarStateMonitor  reason: not valid java name */
    public /* synthetic */ void m7204xf3edbe07() {
        ViewParent parent = this.mDetector.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mDetector);
        }
    }
}

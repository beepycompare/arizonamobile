package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsApplier() {
    }

    public static boolean install(ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT < 30 || applicationInfo.targetSdkVersion < 30) {
            ViewCompat.setOnApplyWindowInsetsListener(viewPager2, new WindowInsetsApplier());
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(viewPager2, windowInsetsCompat);
        if (onApplyWindowInsets.isConsumed()) {
            return onApplyWindowInsets;
        }
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.dispatchApplyWindowInsets(recyclerView.getChildAt(i), new WindowInsetsCompat(onApplyWindowInsets));
        }
        return consumeAllInsets(onApplyWindowInsets);
    }

    private WindowInsetsCompat consumeAllInsets(WindowInsetsCompat windowInsetsCompat) {
        if (WindowInsetsCompat.CONSUMED.toWindowInsets() != null) {
            return WindowInsetsCompat.CONSUMED;
        }
        return windowInsetsCompat.consumeSystemWindowInsets().consumeStableInsets();
    }
}

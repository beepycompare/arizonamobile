package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;
/* loaded from: classes2.dex */
public class ScrollFeedbackProviderCompat {
    private final ScrollFeedbackProviderImpl mImpl;

    /* loaded from: classes2.dex */
    private interface ScrollFeedbackProviderImpl {
        void onScrollLimit(int i, int i2, int i3, boolean z);

        void onScrollProgress(int i, int i2, int i3, int i4);

        void onSnapToItem(int i, int i2, int i3);
    }

    private ScrollFeedbackProviderCompat(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new ScrollFeedbackProviderApi35Impl(view);
        } else {
            this.mImpl = new ScrollFeedbackProviderBaseImpl();
        }
    }

    public static ScrollFeedbackProviderCompat createProvider(View view) {
        return new ScrollFeedbackProviderCompat(view);
    }

    public void onSnapToItem(int i, int i2, int i3) {
        this.mImpl.onSnapToItem(i, i2, i3);
    }

    public void onScrollLimit(int i, int i2, int i3, boolean z) {
        this.mImpl.onScrollLimit(i, i2, i3, z);
    }

    public void onScrollProgress(int i, int i2, int i3, int i4) {
        this.mImpl.onScrollProgress(i, i2, i3, i4);
    }

    /* loaded from: classes2.dex */
    private static class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {
        private final ScrollFeedbackProvider mProvider;

        ScrollFeedbackProviderApi35Impl(View view) {
            this.mProvider = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i2, int i3) {
            this.mProvider.onSnapToItem(i, i2, i3);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i2, int i3, boolean z) {
            this.mProvider.onScrollLimit(i, i2, i3, z);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i2, int i3, int i4) {
            this.mProvider.onScrollProgress(i, i2, i3, i4);
        }
    }

    /* loaded from: classes2.dex */
    private static class ScrollFeedbackProviderBaseImpl implements ScrollFeedbackProviderImpl {
        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i2, int i3, boolean z) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i2, int i3, int i4) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i2, int i3) {
        }

        private ScrollFeedbackProviderBaseImpl() {
        }
    }
}

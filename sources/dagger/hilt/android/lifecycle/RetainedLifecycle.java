package dagger.hilt.android.lifecycle;
/* loaded from: classes5.dex */
public interface RetainedLifecycle {

    /* loaded from: classes5.dex */
    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener listener);

    void removeOnClearedListener(OnClearedListener listener);
}

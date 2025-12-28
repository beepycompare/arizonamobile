package androidx.media3.common;

import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;
/* loaded from: classes2.dex */
public interface ViewProvider {
    ListenableFuture<View> getView(ViewGroup viewGroup);
}

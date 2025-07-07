package coil3.compose.internal;

import coil3.ImageLoader;
import coil3.compose.AsyncImageModelEqualityDelegate;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcoil3/compose/internal/AsyncImageState;", "", CommonUrlParts.MODEL, "modelEqualityDelegate", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "imageLoader", "Lcoil3/ImageLoader;", "<init>", "(Ljava/lang/Object;Lcoil3/compose/AsyncImageModelEqualityDelegate;Lcoil3/ImageLoader;)V", "getModel", "()Ljava/lang/Object;", "getModelEqualityDelegate", "()Lcoil3/compose/AsyncImageModelEqualityDelegate;", "getImageLoader", "()Lcoil3/ImageLoader;", "equals", "", "other", "hashCode", "", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncImageState {
    public static final int $stable = 0;
    private final ImageLoader imageLoader;
    private final Object model;
    private final AsyncImageModelEqualityDelegate modelEqualityDelegate;

    public AsyncImageState(Object obj, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate, ImageLoader imageLoader) {
        this.model = obj;
        this.modelEqualityDelegate = asyncImageModelEqualityDelegate;
        this.imageLoader = imageLoader;
    }

    public final Object getModel() {
        return this.model;
    }

    public final AsyncImageModelEqualityDelegate getModelEqualityDelegate() {
        return this.modelEqualityDelegate;
    }

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AsyncImageState) {
            AsyncImageState asyncImageState = (AsyncImageState) obj;
            return Intrinsics.areEqual(this.modelEqualityDelegate, asyncImageState.modelEqualityDelegate) && this.modelEqualityDelegate.equals(this.model, asyncImageState.model) && Intrinsics.areEqual(this.imageLoader, asyncImageState.imageLoader);
        }
        return false;
    }

    public int hashCode() {
        return (((this.modelEqualityDelegate.hashCode() * 31) + this.modelEqualityDelegate.hashCode(this.model)) * 31) + this.imageLoader.hashCode();
    }
}

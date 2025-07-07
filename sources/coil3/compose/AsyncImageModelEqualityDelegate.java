package coil3.compose;

import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocalAsyncImageModelEqualityDelegate.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImageModelEqualityDelegate;", "", "equals", "", "self", "other", "hashCode", "", "Companion", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AsyncImageModelEqualityDelegate {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final AsyncImageModelEqualityDelegate Default = new AsyncImageModelEqualityDelegate() { // from class: coil3.compose.AsyncImageModelEqualityDelegate$Companion$Default$1
        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public boolean equals(Object obj, Object obj2) {
            if (this == obj2) {
                return true;
            }
            if (!(obj instanceof ImageRequest) || !(obj2 instanceof ImageRequest)) {
                return Intrinsics.areEqual(obj, obj2);
            }
            ImageRequest imageRequest = (ImageRequest) obj;
            ImageRequest imageRequest2 = (ImageRequest) obj2;
            return Intrinsics.areEqual(imageRequest.getContext(), imageRequest2.getContext()) && Intrinsics.areEqual(imageRequest.getData(), imageRequest2.getData()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKey(), imageRequest2.getMemoryCacheKey()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKeyExtras(), imageRequest2.getMemoryCacheKeyExtras()) && Intrinsics.areEqual(imageRequest.getDiskCacheKey(), imageRequest2.getDiskCacheKey()) && Intrinsics.areEqual(imageRequest.getSizeResolver(), imageRequest2.getSizeResolver()) && imageRequest.getScale() == imageRequest2.getScale() && imageRequest.getPrecision() == imageRequest2.getPrecision();
        }

        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public int hashCode(Object obj) {
            if (!(obj instanceof ImageRequest)) {
                if (obj != null) {
                    return obj.hashCode();
                }
                return 0;
            }
            ImageRequest imageRequest = (ImageRequest) obj;
            int hashCode = ((imageRequest.getContext().hashCode() * 31) + imageRequest.getData().hashCode()) * 31;
            String memoryCacheKey = imageRequest.getMemoryCacheKey();
            int hashCode2 = (((hashCode + (memoryCacheKey != null ? memoryCacheKey.hashCode() : 0)) * 31) + imageRequest.getMemoryCacheKeyExtras().hashCode()) * 31;
            String diskCacheKey = imageRequest.getDiskCacheKey();
            return ((((((hashCode2 + (diskCacheKey != null ? diskCacheKey.hashCode() : 0)) * 31) + imageRequest.getSizeResolver().hashCode()) * 31) + imageRequest.getScale().hashCode()) * 31) + imageRequest.getPrecision().hashCode();
        }

        public String toString() {
            return "AsyncImageModelEqualityDelegate.Default";
        }
    };
    public static final AsyncImageModelEqualityDelegate AllProperties = new AsyncImageModelEqualityDelegate() { // from class: coil3.compose.AsyncImageModelEqualityDelegate$Companion$AllProperties$1
        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public boolean equals(Object obj, Object obj2) {
            return Intrinsics.areEqual(obj, obj2);
        }

        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public int hashCode(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "AsyncImageModelEqualityDelegate.AllProperties";
        }
    };

    boolean equals(Object obj, Object obj2);

    int hashCode(Object obj);

    /* compiled from: LocalAsyncImageModelEqualityDelegate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil3/compose/AsyncImageModelEqualityDelegate$Companion;", "", "<init>", "()V", "Default", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "AllProperties", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}

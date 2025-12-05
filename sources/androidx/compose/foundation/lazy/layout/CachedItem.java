package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: CacheWindowLogic.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/CachedItem;", "", "key", "mainAxisSize", "", "<init>", "(Ljava/lang/Object;I)V", "getKey", "()Ljava/lang/Object;", "setKey", "(Ljava/lang/Object;)V", "getMainAxisSize", "()I", "setMainAxisSize", "(I)V", "NoKey", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CachedItem {
    private Object key;
    private int mainAxisSize;
    public static final NoKey NoKey = new NoKey(null);
    public static final int $stable = 8;

    /* compiled from: CacheWindowLogic.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/lazy/layout/CachedItem$NoKey;", "", "<init>", "()V", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class NoKey {
        public /* synthetic */ NoKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private NoKey() {
        }
    }

    public CachedItem(Object obj, int i) {
        this.key = obj;
        this.mainAxisSize = i;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final void setKey(Object obj) {
        this.key = obj;
    }

    public final void setMainAxisSize(int i) {
        this.mainAxisSize = i;
    }
}

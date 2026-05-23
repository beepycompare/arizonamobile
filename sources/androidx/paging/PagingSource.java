package androidx.paging;

import com.google.common.net.HttpHeaders;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
/* compiled from: PagingSource.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002#$B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\u0019\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bJ(\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH¦@¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H&¢\u0006\u0002\u0010\"R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006%"}, d2 = {"Landroidx/paging/PagingSource;", "Key", "", "Value", "<init>", "()V", "invalidateCallbackTracker", "Landroidx/paging/InvalidateCallbackTracker;", "Lkotlin/Function0;", "", "invalidateCallbackCount", "", "getInvalidateCallbackCount$paging_common", "()I", "jumpingSupported", "", "getJumpingSupported", "()Z", "keyReuseSupported", "getKeyReuseSupported", "invalid", "getInvalid", "invalidate", "registerInvalidatedCallback", "onInvalidatedCallback", "unregisterInvalidatedCallback", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshKey", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "LoadParams", "LoadResult", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingSource<Key, Value> {
    private final InvalidateCallbackTracker<Function0<Unit>> invalidateCallbackTracker = new InvalidateCallbackTracker<>(new Function1() { // from class: androidx.paging.PagingSource$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PagingSource.invalidateCallbackTracker$lambda$0((Function0) obj);
        }
    }, null, 2, null);

    public boolean getJumpingSupported() {
        return false;
    }

    public boolean getKeyReuseSupported() {
        return false;
    }

    public abstract Key getRefreshKey(PagingState<Key, Value> pagingState);

    public abstract Object load(LoadParams<Key> loadParams, Continuation<? super LoadResult<Key, Value>> continuation);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invalidateCallbackTracker$lambda$0(Function0 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.invoke();
        return Unit.INSTANCE;
    }

    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    /* compiled from: PagingSource.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0013*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\u0010\u0011\u0012\u0013B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0003\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "Key", "", "loadSize", "", "placeholdersEnabled", "", "<init>", "(IZ)V", "getLoadSize", "()I", "getPlaceholdersEnabled", "()Z", "key", "getKey", "()Ljava/lang/Object;", HttpHeaders.REFRESH, "Append", "Prepend", "Companion", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;", "Landroidx/paging/PagingSource$LoadParams$Refresh;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadParams<Key> {
        public static final Companion Companion = new Companion(null);
        private final int loadSize;
        private final boolean placeholdersEnabled;

        public /* synthetic */ LoadParams(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        public abstract Key getKey();

        private LoadParams(int i, boolean z) {
            this.loadSize = i;
            this.placeholdersEnabled = z;
        }

        public final int getLoadSize() {
            return this.loadSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Refresh;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "<init>", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Refresh<Key> extends LoadParams<Key> {
            private final Key key;

            public Refresh(Key key, int i, boolean z) {
                super(i, z, null);
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Append;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "<init>", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Append<Key> extends LoadParams<Key> {
            private final Key key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Append(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Prepend;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "<init>", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Prepend<Key> extends LoadParams<Key> {
            private final Key key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prepend(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0003\u0010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u0001H\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Companion;", "", "<init>", "()V", "create", "Landroidx/paging/PagingSource$LoadParams;", "Key", "loadType", "Landroidx/paging/LoadType;", "key", "loadSize", "", "placeholdersEnabled", "", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$LoadParams;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {

            /* compiled from: PagingSource.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes3.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LoadType.PREPEND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LoadType.APPEND.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <Key> LoadParams<Key> create(LoadType loadType, Key key, int i, boolean z) {
                Intrinsics.checkNotNullParameter(loadType, "loadType");
                int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (key != null) {
                            return new Prepend(key, i, z);
                        }
                        throw new IllegalArgumentException("key cannot be null for prepend".toString());
                    } else if (i2 == 3) {
                        if (key != null) {
                            return new Append(key, i, z);
                        }
                        throw new IllegalArgumentException("key cannot be null for append".toString());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return new Refresh(key, i, z);
            }
        }
    }

    /* compiled from: PagingSource.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PagingSource$LoadResult;", "Key", "", "Value", "<init>", "()V", "Error", "Invalid", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "Landroidx/paging/PagingSource$LoadResult$Page;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadResult<Key, Value> {
        public /* synthetic */ LoadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private LoadResult() {
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Error;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Error<Key, Value> extends LoadResult<Key, Value> {
            private final Throwable throwable;

            public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = error.throwable;
                }
                return error.copy(th);
            }

            public final Throwable component1() {
                return this.throwable;
            }

            public final Error<Key, Value> copy(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                return new Error<>(throwable);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual(this.throwable, ((Error) obj).throwable);
            }

            public int hashCode() {
                return this.throwable.hashCode();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable throwable) {
                super(null);
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.throwable = throwable;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Error(\n                    |   throwable: " + this.throwable + "\n                    |) ", null, 1, null);
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Invalid;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "<init>", "()V", "toString", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super(null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001(B=\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\b\b\u0003\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004¢\u0006\u0004\b\r\u0010\u000fJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00050\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00018\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JV\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u00042\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u000bHÖ\u0081\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00018\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00018\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006)"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "data", "", "prevKey", "nextKey", "itemsBefore", "", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "getData", "()Ljava/util/List;", "getPrevKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getNextKey", "getItemsBefore", "()I", "getItemsAfter", "iterator", "", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)Landroidx/paging/PagingSource$LoadResult$Page;", "equals", "", "other", "hashCode", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, KMappedMarker {
            public static final int COUNT_UNDEFINED = Integer.MIN_VALUE;
            public static final Companion Companion = new Companion(null);
            private static final Page EMPTY = new Page(CollectionsKt.emptyList(), null, null, 0, 0);
            private final List<Value> data;
            private final int itemsAfter;
            private final int itemsBefore;
            private final Key nextKey;
            private final Key prevKey;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Page copy$default(Page page, List list, Object obj, Object obj2, int i, int i2, int i3, Object obj3) {
                List<Value> list2 = list;
                if ((i3 & 1) != 0) {
                    list2 = page.data;
                }
                Key key = obj;
                if ((i3 & 2) != 0) {
                    key = page.prevKey;
                }
                Key key2 = obj2;
                if ((i3 & 4) != 0) {
                    key2 = page.nextKey;
                }
                if ((i3 & 8) != 0) {
                    i = page.itemsBefore;
                }
                if ((i3 & 16) != 0) {
                    i2 = page.itemsAfter;
                }
                int i4 = i2;
                Key key3 = key2;
                return page.copy(list2, key, key3, i, i4);
            }

            public final List<Value> component1() {
                return this.data;
            }

            public final Key component2() {
                return this.prevKey;
            }

            public final Key component3() {
                return this.nextKey;
            }

            public final int component4() {
                return this.itemsBefore;
            }

            public final int component5() {
                return this.itemsAfter;
            }

            public final Page<Key, Value> copy(List<? extends Value> data, Key key, Key key2, int i, int i2) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new Page<>(data, key, key2, i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Page) {
                    Page page = (Page) obj;
                    return Intrinsics.areEqual(this.data, page.data) && Intrinsics.areEqual(this.prevKey, page.prevKey) && Intrinsics.areEqual(this.nextKey, page.nextKey) && this.itemsBefore == page.itemsBefore && this.itemsAfter == page.itemsAfter;
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.data.hashCode() * 31;
                Key key = this.prevKey;
                int hashCode2 = (hashCode + (key == null ? 0 : key.hashCode())) * 31;
                Key key2 = this.nextKey;
                return ((((hashCode2 + (key2 != null ? key2.hashCode() : 0)) * 31) + Integer.hashCode(this.itemsBefore)) * 31) + Integer.hashCode(this.itemsAfter);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Page(List<? extends Value> data, Key key, Key key2, int i, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
                this.prevKey = key;
                this.nextKey = key2;
                this.itemsBefore = i;
                this.itemsAfter = i2;
                if (i != Integer.MIN_VALUE && i < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
                }
                if (i2 != Integer.MIN_VALUE && i2 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
                }
            }

            public /* synthetic */ Page(List list, Object obj, Object obj2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
            }

            public final List<Value> getData() {
                return this.data;
            }

            public final Key getPrevKey() {
                return this.prevKey;
            }

            public final Key getNextKey() {
                return this.nextKey;
            }

            public final int getItemsBefore() {
                return this.itemsBefore;
            }

            public final int getItemsAfter() {
                return this.itemsAfter;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Page(List<? extends Value> data, Key key, Key key2) {
                this(data, key, key2, Integer.MIN_VALUE, Integer.MIN_VALUE);
                Intrinsics.checkNotNullParameter(data, "data");
            }

            @Override // java.lang.Iterable
            public Iterator<Value> iterator() {
                return this.data.listIterator();
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Page(\n                    |   data size: " + this.data.size() + "\n                    |   first Item: " + CollectionsKt.firstOrNull((List<? extends Object>) this.data) + "\n                    |   last Item: " + CollectionsKt.lastOrNull((List<? extends Object>) this.data) + "\n                    |   nextKey: " + this.nextKey + "\n                    |   prevKey: " + this.prevKey + "\n                    |   itemsBefore: " + this.itemsBefore + "\n                    |   itemsAfter: " + this.itemsAfter + "\n                    |) ", null, 1, null);
            }

            /* compiled from: PagingSource.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u0007\"\b\b\u0006\u0010\r*\u00020\u0001\"\b\b\u0007\u0010\u000e*\u00020\u0001H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page$Companion;", "", "<init>", "()V", "COUNT_UNDEFINED", "", "EMPTY", "Landroidx/paging/PagingSource$LoadResult$Page;", "", "getEMPTY$paging_common$annotations", "getEMPTY$paging_common", "()Landroidx/paging/PagingSource$LoadResult$Page;", "empty", "Key", "Value", "empty$paging_common", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes3.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public static /* synthetic */ void getEMPTY$paging_common$annotations() {
                }

                private Companion() {
                }

                public final Page getEMPTY$paging_common() {
                    return Page.EMPTY;
                }

                public final <Key, Value> Page<Key, Value> empty$paging_common() {
                    Page<Key, Value> eMPTY$paging_common = getEMPTY$paging_common();
                    Intrinsics.checkNotNull(eMPTY$paging_common, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Page<Key of androidx.paging.PagingSource.LoadResult.Page.Companion.empty, Value of androidx.paging.PagingSource.LoadResult.Page.Companion.empty>");
                    return eMPTY$paging_common;
                }
            }
        }
    }

    public final boolean getInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    public final void invalidate() {
        if (this.invalidateCallbackTracker.invalidate$paging_common()) {
            PagingLogger pagingLogger = PagingLogger.INSTANCE;
            if (pagingLogger.isLoggable(3)) {
                pagingLogger.log(3, "Invalidated PagingSource " + this, null);
            }
        }
    }

    public final void registerInvalidatedCallback(Function0<Unit> onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(onInvalidatedCallback);
    }

    public final void unregisterInvalidatedCallback(Function0<Unit> onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(onInvalidatedCallback);
    }
}

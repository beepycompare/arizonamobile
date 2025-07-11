package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.disk.DiskCache;
import coil3.fetch.SourceFetchResult;
import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.Buffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$fetchResult$1", f = "NetworkFetcher.kt", i = {0, 1}, l = {76, 87}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class NetworkFetcher$fetch$fetchResult$1 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<NetworkResponse> $cacheResponse;
    final /* synthetic */ NetworkRequest $networkRequest;
    final /* synthetic */ Ref.ObjectRef<DiskCache.Snapshot> $snapshot;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$fetchResult$1(Ref.ObjectRef<DiskCache.Snapshot> objectRef, NetworkFetcher networkFetcher, Ref.ObjectRef<NetworkResponse> objectRef2, NetworkRequest networkRequest, Continuation<? super NetworkFetcher$fetch$fetchResult$1> continuation) {
        super(2, continuation);
        this.$snapshot = objectRef;
        this.this$0 = networkFetcher;
        this.$cacheResponse = objectRef2;
        this.$networkRequest = networkRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(this.$snapshot, this.this$0, this.$cacheResponse, this.$networkRequest, continuation);
        networkFetcher$fetch$fetchResult$1.L$0 = obj;
        return networkFetcher$fetch$fetchResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return ((NetworkFetcher$fetch$fetchResult$1) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, coil3.network.NetworkResponse] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<DiskCache.Snapshot> objectRef;
        Object writeToDiskCache;
        NetworkResponse networkResponse;
        T t;
        NetworkResponse networkResponse2;
        ?? networkResponseOrNull;
        ImageSource imageSource;
        String str;
        NetworkHeaders headers;
        Object obj2;
        Buffer buffer;
        ImageSource imageSource2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str3 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse3 = (NetworkResponse) this.L$0;
            objectRef = this.$snapshot;
            this.L$0 = networkResponse3;
            this.L$1 = objectRef;
            this.label = 1;
            writeToDiskCache = this.this$0.writeToDiskCache(objectRef.element, this.$cacheResponse.element, this.$networkRequest, networkResponse3, this);
            if (writeToDiskCache != coroutine_suspended) {
                networkResponse = networkResponse3;
                t = writeToDiskCache;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                networkResponse2 = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                buffer = (Buffer) obj2;
                if (buffer.size() <= 0) {
                    imageSource2 = this.this$0.toImageSource(buffer);
                    NetworkFetcher networkFetcher = this.this$0;
                    str2 = networkFetcher.url;
                    return new SourceFetchResult(imageSource2, networkFetcher.getMimeType(str2, networkResponse2.getHeaders().get("Content-Type")), DataSource.NETWORK);
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef = (Ref.ObjectRef) this.L$1;
            networkResponse = (NetworkResponse) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
        }
        objectRef.element = t;
        if (this.$snapshot.element != null) {
            Ref.ObjectRef<NetworkResponse> objectRef2 = this.$cacheResponse;
            NetworkFetcher networkFetcher2 = this.this$0;
            DiskCache.Snapshot snapshot = this.$snapshot.element;
            Intrinsics.checkNotNull(snapshot);
            networkResponseOrNull = networkFetcher2.toNetworkResponseOrNull(snapshot);
            objectRef2.element = networkResponseOrNull;
            NetworkFetcher networkFetcher3 = this.this$0;
            DiskCache.Snapshot snapshot2 = this.$snapshot.element;
            Intrinsics.checkNotNull(snapshot2);
            imageSource = networkFetcher3.toImageSource(snapshot2);
            NetworkFetcher networkFetcher4 = this.this$0;
            str = networkFetcher4.url;
            NetworkResponse networkResponse4 = this.$cacheResponse.element;
            if (networkResponse4 != null && (headers = networkResponse4.getHeaders()) != null) {
                str3 = headers.get("Content-Type");
            }
            return new SourceFetchResult(imageSource, networkFetcher4.getMimeType(str, str3), DataSource.NETWORK);
        }
        this.L$0 = networkResponse;
        this.L$1 = null;
        this.label = 2;
        Object readBuffer = UtilsKt.readBuffer(UtilsKt.requireBody(networkResponse), this);
        if (readBuffer != coroutine_suspended) {
            networkResponse2 = networkResponse;
            obj2 = readBuffer;
            buffer = (Buffer) obj2;
            if (buffer.size() <= 0) {
            }
        }
        return coroutine_suspended;
    }
}

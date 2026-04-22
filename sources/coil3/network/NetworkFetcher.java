package coil3.network;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.network.CacheStrategy;
import coil3.network.NetworkHeaders;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.UtilsKt;
import coil3.network.internal.Utils_androidKt;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J4\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J@\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\u001b2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010)\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002J\f\u0010*\u001a\u00020+*\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020+*\u00020,H\u0082@¢\u0006\u0002\u0010-J\f\u0010*\u001a\u00020+*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", "url", "", "options", "Lcoil3/request/Options;", "networkClient", "Lkotlin/Lazy;", "Lcoil3/network/NetworkClient;", "diskCache", "Lcoil3/disk/DiskCache;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Ljava/lang/String;Lcoil3/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/network/ConnectivityChecker;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil3/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "networkResponse", "(Lcoil3/disk/DiskCache$Snapshot;Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRequest", "executeNetworkRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "toNetworkResponseOrNull", "toImageSource", "Lcoil3/decode/ImageSource;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokio/Buffer;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "coil-network-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkFetcher implements Fetcher {
    private final Lazy<CacheStrategy> cacheStrategy;
    private final ConnectivityChecker connectivityChecker;
    private final Lazy<DiskCache> diskCache;
    private final Lazy<NetworkClient> networkClient;
    private final Options options;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkFetcher(String str, Options options, Lazy<? extends NetworkClient> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends CacheStrategy> lazy3, ConnectivityChecker connectivityChecker) {
        this.url = str;
        this.options = options;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|(4:(1:(1:(4:12|13|14|15)(2:18|19))(6:20|21|22|23|24|(1:26)(1:29)))(4:37|38|39|40)|33|(1:35)|36)(11:60|61|62|(4:64|(2:74|75)|67|(2:69|(2:71|28)))|76|45|(2:54|55)|47|48|(3:50|24|(0)(0))|28)|41|(2:43|44)|45|(0)|47|48|(0)|28))|81|6|7|(0)(0)|41|(0)|45|(0)|47|48|(0)|28) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        r15 = r0;
        r14 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:
        if (r15 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0193, code lost:
        if (r15 == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107 A[Catch: Exception -> 0x019d, TRY_LEAVE, TryCatch #1 {Exception -> 0x019d, blocks: (B:45:0x00ff, B:47:0x0107, B:31:0x0091, B:33:0x009a, B:40:0x00d1, B:42:0x00df, B:36:0x00b1, B:38:0x00bb), top: B:76:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0168 A[Catch: Exception -> 0x0046, TryCatch #4 {Exception -> 0x0046, blocks: (B:14:0x0041, B:64:0x0196, B:59:0x0164, B:61:0x0168), top: B:81:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r14v30, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, coil3.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, coil3.network.NetworkResponse] */
    @Override // coil3.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(Continuation<? super FetchResult> continuation) {
        NetworkFetcher$fetch$1 networkFetcher$fetch$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        Exception exc;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        CacheStrategy.ReadResult readResult;
        Object read;
        NetworkRequest request;
        NetworkFetcher networkFetcher;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        NetworkRequest networkRequest;
        SourceFetchResult sourceFetchResult;
        if (continuation instanceof NetworkFetcher$fetch$1) {
            networkFetcher$fetch$1 = (NetworkFetcher$fetch$1) continuation;
            if ((networkFetcher$fetch$1.label & Integer.MIN_VALUE) != 0) {
                networkFetcher$fetch$1.label -= Integer.MIN_VALUE;
                obj = networkFetcher$fetch$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkFetcher$fetch$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef3 = (Ref.ObjectRef) networkFetcher$fetch$1.L$1;
                        Ref.ObjectRef objectRef6 = (Ref.ObjectRef) networkFetcher$fetch$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            read = obj;
                            objectRef2 = objectRef6;
                        } catch (Exception e) {
                            exc = e;
                            objectRef = objectRef6;
                        }
                    } else if (i != 2) {
                        if (i == 3) {
                            SourceFetchResult sourceFetchResult2 = (SourceFetchResult) networkFetcher$fetch$1.L$4;
                            NetworkRequest networkRequest2 = (NetworkRequest) networkFetcher$fetch$1.L$3;
                            Ref.ObjectRef objectRef7 = (Ref.ObjectRef) networkFetcher$fetch$1.L$2;
                            CacheStrategy.ReadResult readResult2 = (CacheStrategy.ReadResult) networkFetcher$fetch$1.L$1;
                            ?? r14 = (Ref.ObjectRef) networkFetcher$fetch$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            this = r14;
                            return (SourceFetchResult) obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        networkRequest = (NetworkRequest) networkFetcher$fetch$1.L$3;
                        objectRef5 = (Ref.ObjectRef) networkFetcher$fetch$1.L$2;
                        readResult = (CacheStrategy.ReadResult) networkFetcher$fetch$1.L$1;
                        Ref.ObjectRef objectRef8 = (Ref.ObjectRef) networkFetcher$fetch$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            networkFetcher = this;
                            objectRef4 = objectRef8;
                            sourceFetchResult = (SourceFetchResult) obj;
                            if (sourceFetchResult == null) {
                                return sourceFetchResult;
                            }
                            networkFetcher$fetch$1.L$0 = objectRef4;
                            networkFetcher$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(readResult);
                            networkFetcher$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(objectRef5);
                            networkFetcher$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(networkRequest);
                            networkFetcher$fetch$1.L$4 = SpillingKt.nullOutSpilledVariable(sourceFetchResult);
                            networkFetcher$fetch$1.label = 3;
                            obj = networkFetcher.executeNetworkRequest(networkFetcher.newRequest(), new NetworkFetcher$fetch$2(networkFetcher, null), networkFetcher$fetch$1);
                            this = objectRef4;
                        } catch (Exception e2) {
                            exc = e2;
                            objectRef = objectRef8;
                        }
                    }
                    DiskCache.Snapshot snapshot = (DiskCache.Snapshot) objectRef.element;
                    if (snapshot != null) {
                        UtilsKt.closeQuietly(snapshot);
                    }
                    throw exc;
                }
                ResultKt.throwOnFailure(obj);
                objectRef2 = new Ref.ObjectRef();
                objectRef2.element = readFromDiskCache();
                try {
                    objectRef3 = new Ref.ObjectRef();
                    if (objectRef2.element != null) {
                        Long size = getFileSystem().metadata(((DiskCache.Snapshot) objectRef2.element).getMetadata()).getSize();
                        if (size != null && size.longValue() == 0) {
                            return new SourceFetchResult(toImageSource((DiskCache.Snapshot) objectRef2.element), getMimeType(this.url, null), DataSource.DISK);
                        }
                        objectRef3.element = toNetworkResponseOrNull((DiskCache.Snapshot) objectRef2.element);
                        if (objectRef3.element != null) {
                            NetworkRequest newRequest = newRequest();
                            Options options = this.options;
                            networkFetcher$fetch$1.L$0 = objectRef2;
                            networkFetcher$fetch$1.L$1 = objectRef3;
                            networkFetcher$fetch$1.label = 1;
                            read = this.cacheStrategy.getValue().read((NetworkResponse) objectRef3.element, newRequest, options, networkFetcher$fetch$1);
                            if (read == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    readResult = null;
                    Ref.ObjectRef objectRef9 = objectRef2;
                    Ref.ObjectRef objectRef10 = objectRef3;
                    if (readResult != null) {
                        try {
                            request = readResult.getRequest();
                        } catch (Exception e3) {
                            exc = e3;
                            objectRef = objectRef9;
                        }
                    }
                    request = newRequest();
                    NetworkRequest networkRequest3 = request;
                    networkFetcher = this;
                    networkFetcher$fetch$1.L$0 = objectRef9;
                    networkFetcher$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(readResult);
                    networkFetcher$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(objectRef10);
                    networkFetcher$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(networkRequest3);
                    networkFetcher$fetch$1.label = 2;
                    obj = networkFetcher.executeNetworkRequest(networkRequest3, new NetworkFetcher$fetch$fetchResult$1(objectRef9, networkFetcher, objectRef10, networkRequest3, null), networkFetcher$fetch$1);
                    if (obj != coroutine_suspended) {
                        objectRef4 = objectRef9;
                        objectRef5 = objectRef10;
                        networkRequest = networkRequest3;
                        sourceFetchResult = (SourceFetchResult) obj;
                        if (sourceFetchResult == null) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e4) {
                    exc = e4;
                    objectRef = objectRef2;
                }
                readResult = (CacheStrategy.ReadResult) read;
                if (readResult.getResponse() != null) {
                    return new SourceFetchResult(toImageSource((DiskCache.Snapshot) objectRef2.element), getMimeType(this.url, readResult.getResponse().getHeaders().get("Content-Type")), DataSource.DISK);
                }
                Ref.ObjectRef objectRef92 = objectRef2;
                Ref.ObjectRef objectRef102 = objectRef3;
                if (readResult != null) {
                }
                request = newRequest();
                NetworkRequest networkRequest32 = request;
                networkFetcher = this;
                networkFetcher$fetch$1.L$0 = objectRef92;
                networkFetcher$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(readResult);
                networkFetcher$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(objectRef102);
                networkFetcher$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(networkRequest32);
                networkFetcher$fetch$1.label = 2;
                obj = networkFetcher.executeNetworkRequest(networkRequest32, new NetworkFetcher$fetch$fetchResult$1(objectRef92, networkFetcher, objectRef102, networkRequest32, null), networkFetcher$fetch$1);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        networkFetcher$fetch$1 = new NetworkFetcher$fetch$1(this, continuation);
        obj = networkFetcher$fetch$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$fetch$1.label;
        if (i == 0) {
        }
        readResult = (CacheStrategy.ReadResult) read;
        if (readResult.getResponse() != null) {
        }
        Ref.ObjectRef objectRef922 = objectRef2;
        Ref.ObjectRef objectRef1022 = objectRef3;
        if (readResult != null) {
        }
        request = newRequest();
        NetworkRequest networkRequest322 = request;
        networkFetcher = this;
        networkFetcher$fetch$1.L$0 = objectRef922;
        networkFetcher$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(readResult);
        networkFetcher$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(objectRef1022);
        networkFetcher$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(networkRequest322);
        networkFetcher$fetch$1.label = 2;
        obj = networkFetcher.executeNetworkRequest(networkRequest322, new NetworkFetcher$fetch$fetchResult$1(objectRef922, networkFetcher, objectRef1022, networkRequest322, null), networkFetcher$fetch$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
        if (r0.writeTo(r10, r3, r6) == r7) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeToDiskCache(DiskCache.Snapshot snapshot, NetworkResponse networkResponse, NetworkRequest networkRequest, NetworkResponse networkResponse2, Continuation<? super DiskCache.Snapshot> continuation) {
        NetworkFetcher$writeToDiskCache$1 networkFetcher$writeToDiskCache$1;
        int i;
        NetworkResponse networkResponse3;
        NetworkRequest networkRequest2;
        NetworkResponse networkResponse4;
        NetworkResponse response;
        DiskCache.Editor editor;
        DiskCache.Editor openEditor;
        Exception exc;
        NetworkResponse networkResponse5;
        NetworkResponse networkResponse6;
        DiskCache.Editor editor2;
        NetworkResponseBody body;
        NetworkResponseBody body2;
        if (continuation instanceof NetworkFetcher$writeToDiskCache$1) {
            networkFetcher$writeToDiskCache$1 = (NetworkFetcher$writeToDiskCache$1) continuation;
            if ((networkFetcher$writeToDiskCache$1.label & Integer.MIN_VALUE) != 0) {
                networkFetcher$writeToDiskCache$1.label -= Integer.MIN_VALUE;
                NetworkFetcher$writeToDiskCache$1 networkFetcher$writeToDiskCache$12 = networkFetcher$writeToDiskCache$1;
                Object obj = networkFetcher$writeToDiskCache$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkFetcher$writeToDiskCache$12.label;
                Throwable th = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.options.getDiskCachePolicy().getWriteEnabled()) {
                        if (snapshot != null) {
                            UtilsKt.closeQuietly(snapshot);
                        }
                        return null;
                    }
                    Options options = this.options;
                    networkFetcher$writeToDiskCache$12.L$0 = snapshot;
                    networkFetcher$writeToDiskCache$12.L$1 = SpillingKt.nullOutSpilledVariable(networkResponse);
                    networkFetcher$writeToDiskCache$12.L$2 = SpillingKt.nullOutSpilledVariable(networkRequest);
                    networkFetcher$writeToDiskCache$12.L$3 = networkResponse2;
                    networkFetcher$writeToDiskCache$12.label = 1;
                    obj = this.cacheStrategy.getValue().write(networkResponse, networkRequest, networkResponse2, options, networkFetcher$writeToDiskCache$12);
                    if (obj != coroutine_suspended) {
                        networkResponse3 = networkResponse;
                        networkRequest2 = networkRequest;
                        networkResponse4 = networkResponse2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        editor2 = (DiskCache.Editor) networkFetcher$writeToDiskCache$12.L$6;
                        networkResponse6 = (NetworkResponse) networkFetcher$writeToDiskCache$12.L$5;
                        CacheStrategy.WriteResult writeResult = (CacheStrategy.WriteResult) networkFetcher$writeToDiskCache$12.L$4;
                        networkResponse5 = (NetworkResponse) networkFetcher$writeToDiskCache$12.L$3;
                        NetworkRequest networkRequest3 = (NetworkRequest) networkFetcher$writeToDiskCache$12.L$2;
                        NetworkResponse networkResponse7 = (NetworkResponse) networkFetcher$writeToDiskCache$12.L$1;
                        DiskCache.Snapshot snapshot2 = (DiskCache.Snapshot) networkFetcher$writeToDiskCache$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return editor2.commitAndOpenSnapshot();
                        } catch (Exception e) {
                            exc = e;
                            UtilsKt.abortQuietly(editor2);
                            body = networkResponse5.getBody();
                            if (body != null) {
                                UtilsKt.closeQuietly(body);
                            }
                            body2 = networkResponse6.getBody();
                            if (body2 != null) {
                                UtilsKt.closeQuietly(body2);
                            }
                            throw exc;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    networkResponse4 = (NetworkResponse) networkFetcher$writeToDiskCache$12.L$3;
                    networkRequest2 = (NetworkRequest) networkFetcher$writeToDiskCache$12.L$2;
                    networkResponse3 = (NetworkResponse) networkFetcher$writeToDiskCache$12.L$1;
                    snapshot = (DiskCache.Snapshot) networkFetcher$writeToDiskCache$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                CacheStrategy.WriteResult writeResult2 = (CacheStrategy.WriteResult) obj;
                response = writeResult2.getResponse();
                if (response != null) {
                    return null;
                }
                if (snapshot != null) {
                    openEditor = snapshot.closeAndOpenEditor();
                } else {
                    DiskCache value = this.diskCache.getValue();
                    if (value == null) {
                        editor = null;
                        if (editor != null) {
                            return null;
                        }
                        try {
                            BufferedSink buffer = Okio.buffer(getFileSystem().sink(editor.getMetadata(), false));
                            CacheNetworkResponse.INSTANCE.writeTo(response, buffer);
                            Unit unit = Unit.INSTANCE;
                            if (buffer != null) {
                                try {
                                    buffer.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            if (th == null) {
                                NetworkResponseBody body3 = response.getBody();
                                if (body3 != null) {
                                    FileSystem fileSystem = getFileSystem();
                                    Path data = editor.getData();
                                    networkFetcher$writeToDiskCache$12.L$0 = SpillingKt.nullOutSpilledVariable(snapshot);
                                    networkFetcher$writeToDiskCache$12.L$1 = SpillingKt.nullOutSpilledVariable(networkResponse3);
                                    networkFetcher$writeToDiskCache$12.L$2 = SpillingKt.nullOutSpilledVariable(networkRequest2);
                                    networkFetcher$writeToDiskCache$12.L$3 = networkResponse4;
                                    networkFetcher$writeToDiskCache$12.L$4 = SpillingKt.nullOutSpilledVariable(writeResult2);
                                    networkFetcher$writeToDiskCache$12.L$5 = response;
                                    networkFetcher$writeToDiskCache$12.L$6 = editor;
                                    networkFetcher$writeToDiskCache$12.label = 2;
                                }
                                networkResponse5 = networkResponse4;
                                networkResponse6 = response;
                                editor2 = editor;
                                return editor2.commitAndOpenSnapshot();
                            }
                            throw th;
                        } catch (Exception e2) {
                            exc = e2;
                            networkResponse5 = networkResponse4;
                            networkResponse6 = response;
                            editor2 = editor;
                            UtilsKt.abortQuietly(editor2);
                            body = networkResponse5.getBody();
                            if (body != null) {
                            }
                            body2 = networkResponse6.getBody();
                            if (body2 != null) {
                            }
                            throw exc;
                        }
                    }
                    openEditor = value.openEditor(getDiskCacheKey());
                }
                editor = openEditor;
                if (editor != null) {
                }
            }
        }
        networkFetcher$writeToDiskCache$1 = new NetworkFetcher$writeToDiskCache$1(this, continuation);
        NetworkFetcher$writeToDiskCache$1 networkFetcher$writeToDiskCache$122 = networkFetcher$writeToDiskCache$1;
        Object obj2 = networkFetcher$writeToDiskCache$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$writeToDiskCache$122.label;
        Throwable th3 = null;
        if (i != 0) {
        }
        CacheStrategy.WriteResult writeResult22 = (CacheStrategy.WriteResult) obj2;
        response = writeResult22.getResponse();
        if (response != null) {
        }
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder newBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            newBuilder.set("Cache-Control", "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                newBuilder.set("Cache-Control", "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            newBuilder.set("Cache-Control", "no-cache");
        } else {
            newBuilder.set("Cache-Control", "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), newBuilder.build(), ImageRequestsKt.getHttpBody(this.options), this.options.getExtras());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object executeNetworkRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            Utils_androidKt.assertNotOnMainThread();
        }
        return this.networkClient.getValue().executeRequest(networkRequest, new NetworkFetcher$executeNetworkRequest$2(function2, null), continuation);
    }

    public final String getMimeType(String str, String str2) {
        String mimeTypeFromUrl;
        if ((str2 == null || StringsKt.startsWith$default(str2, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(str)) != null) {
            return mimeTypeFromUrl;
        }
        if (str2 != null) {
            return StringsKt.substringBefore$default(str2, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkResponse toNetworkResponseOrNull(DiskCache.Snapshot snapshot) {
        try {
            BufferedSource buffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            NetworkResponse readFrom = CacheNetworkResponse.INSTANCE.readFrom(buffer);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
            if (th == null) {
                return readFrom;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toImageSource(NetworkResponseBody networkResponseBody, Continuation<? super ImageSource> continuation) {
        NetworkFetcher$toImageSource$1 networkFetcher$toImageSource$1;
        int i;
        Buffer buffer;
        if (continuation instanceof NetworkFetcher$toImageSource$1) {
            networkFetcher$toImageSource$1 = (NetworkFetcher$toImageSource$1) continuation;
            if ((networkFetcher$toImageSource$1.label & Integer.MIN_VALUE) != 0) {
                networkFetcher$toImageSource$1.label -= Integer.MIN_VALUE;
                Object obj = networkFetcher$toImageSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkFetcher$toImageSource$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    BufferedSink buffer2 = new Buffer();
                    networkFetcher$toImageSource$1.L$0 = SpillingKt.nullOutSpilledVariable(networkResponseBody);
                    networkFetcher$toImageSource$1.L$1 = buffer2;
                    networkFetcher$toImageSource$1.label = 1;
                    if (networkResponseBody.writeTo(buffer2, networkFetcher$toImageSource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    buffer = buffer2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    buffer = (Buffer) networkFetcher$toImageSource$1.L$1;
                    NetworkResponseBody networkResponseBody2 = (NetworkResponseBody) networkFetcher$toImageSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return toImageSource(buffer);
            }
        }
        networkFetcher$toImageSource$1 = new NetworkFetcher$toImageSource$1(this, continuation);
        Object obj2 = networkFetcher$toImageSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$toImageSource$1.label;
        if (i != 0) {
        }
        return toImageSource(buffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default(buffer, getFileSystem(), null, 4, null);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        FileSystem fileSystem;
        DiskCache value = this.diskCache.getValue();
        return (value == null || (fileSystem = value.getFileSystem()) == null) ? this.options.getFileSystem() : fileSystem;
    }

    /* compiled from: NetworkFetcher.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "networkClient", "Lkotlin/Function0;", "Lcoil3/network/NetworkClient;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "networkClientLazy", "Lkotlin/Lazy;", "cacheStrategyLazy", "connectivityCheckerLazy", "Lcoil3/network/internal/SingleParameterLazy;", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-network-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<CacheStrategy> cacheStrategyLazy;
        private final SingleParameterLazy<Context, ConnectivityChecker> connectivityCheckerLazy;
        private final Lazy<NetworkClient> networkClientLazy;

        public Factory(Function0<? extends NetworkClient> function0, Function0<? extends CacheStrategy> function02, Function1<? super Context, ? extends ConnectivityChecker> function1) {
            this.networkClientLazy = LazyKt.lazy(function0);
            this.cacheStrategyLazy = LazyKt.lazy(function02);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: NetworkFetcher.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: coil3.network.NetworkFetcher$Factory$2  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Context, ConnectivityChecker> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            AnonymousClass2() {
                super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ConnectivityChecker invoke(Context context) {
                return ConnectivityCheckerKt.ConnectivityChecker(context);
            }
        }

        public /* synthetic */ Factory(Function0 function0, Function0 function02, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CacheStrategy cacheStrategy;
                    cacheStrategy = CacheStrategy.DEFAULT;
                    return cacheStrategy;
                }
            } : function02, (i & 4) != 0 ? AnonymousClass2.INSTANCE : anonymousClass2);
        }

        @Override // coil3.fetch.Fetcher.Factory
        public Fetcher create(Uri uri, Options options, final ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new NetworkFetcher(uri.toString(), options, this.networkClientLazy, LazyKt.lazy(new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        DiskCache diskCache;
                        diskCache = ImageLoader.this.getDiskCache();
                        return diskCache;
                    }
                }), this.cacheStrategyLazy, this.connectivityCheckerLazy.get(options.getContext()));
            }
            return null;
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), Constants.SCHEME);
        }
    }
}

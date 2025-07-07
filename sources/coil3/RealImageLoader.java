package coil3;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.disk.DiskCache;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.request.Disposable;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.NullRequestData;
import coil3.request.NullRequestDataException;
import coil3.request.RequestDelegate;
import coil3.request.RequestService;
import coil3.request.RequestService_androidKt;
import coil3.request.SuccessResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.target.Target;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.SystemCallbacksKt;
import coil3.util.UtilsKt;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\b\u0010!\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002092\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017*\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c*\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\t\u0010!\u001a\u00020\"X\u0082\u0004¨\u0006<"}, d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "options", "Lcoil3/RealImageLoader$Options;", "<init>", "(Lcoil3/RealImageLoader$Options;)V", "getOptions", "()Lcoil3/RealImageLoader$Options;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil3/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache$delegate", "getDiskCache", "()Lcoil3/disk/DiskCache;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "shutdown", "Lkotlinx/atomicfu/AtomicBoolean;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialRequest", "type", "", "(Lcoil3/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "onSuccess", "result", "Lcoil3/request/SuccessResult;", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", "eventListener", "Lcoil3/EventListener;", "onError", "Lcoil3/request/ErrorResult;", "onCancel", "Options", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RealImageLoader implements ImageLoader {
    private static final /* synthetic */ AtomicIntegerFieldUpdater shutdown$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");
    private final ComponentRegistry components;
    private final Options options;
    private final RequestService requestService;
    private final CoroutineScope scope;
    private volatile /* synthetic */ int shutdown$volatile;
    private final SystemCallbacks systemCallbacks;

    private final /* synthetic */ int getShutdown$volatile() {
        return this.shutdown$volatile;
    }

    private final /* synthetic */ void setShutdown$volatile(int i) {
        this.shutdown$volatile = i;
    }

    public RealImageLoader(Options options) {
        this.options = options;
        this.scope = RealImageLoaderKt.access$CoroutineScope(options.getLogger());
        SystemCallbacks SystemCallbacks = SystemCallbacksKt.SystemCallbacks(this);
        this.systemCallbacks = SystemCallbacks;
        RealImageLoader realImageLoader = this;
        RequestService RequestService = RequestService_androidKt.RequestService(realImageLoader, SystemCallbacks, options.getLogger());
        this.requestService = RequestService;
        options.getMemoryCacheLazy();
        options.getDiskCacheLazy();
        this.components = RealImageLoaderKt.addCommonComponents(RealImageLoader_nonNativeKt.addAppleComponents(RealImageLoader_jvmCommonKt.addJvmComponents(RealImageLoader_androidKt.addAndroidComponents(RealImageLoaderKt.addServiceLoaderComponents(options.getComponentRegistry().newBuilder(), options), options), options), options)).add(new EngineInterceptor(realImageLoader, SystemCallbacks, RequestService, options.getLogger())).build();
    }

    public final Options getOptions() {
        return this.options;
    }

    @Override // coil3.ImageLoader
    public ImageRequest.Defaults getDefaults() {
        return this.options.getDefaults();
    }

    @Override // coil3.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.options.getMemoryCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    public DiskCache getDiskCache() {
        return this.options.getDiskCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil3.ImageLoader
    public Disposable enqueue(ImageRequest imageRequest) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this.scope, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$enqueue$job$1(this, imageRequest, null), 2, null);
        return RealImageLoader_androidKt.getDisposable(imageRequest, async$default);
    }

    @Override // coil3.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (!RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest)) {
            return execute(imageRequest, 1, continuation);
        }
        return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:44:0x00d2, B:46:0x00d8, B:48:0x00de, B:50:0x00e4, B:52:0x00ea, B:55:0x00f2, B:57:0x00f8, B:58:0x00fb, B:60:0x0104, B:61:0x0107), top: B:102:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0104 A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:44:0x00d2, B:46:0x00d8, B:48:0x00de, B:50:0x00e4, B:52:0x00ea, B:55:0x00f2, B:57:0x00f8, B:58:0x00fb, B:60:0x0104, B:61:0x0107), top: B:102:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0155 A[Catch: all -> 0x0066, TryCatch #2 {all -> 0x0066, blocks: (B:14:0x003f, B:71:0x014f, B:73:0x0155, B:74:0x0160, B:76:0x0164, B:79:0x0172, B:80:0x0177, B:19:0x005c), top: B:105:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0160 A[Catch: all -> 0x0066, TryCatch #2 {all -> 0x0066, blocks: (B:14:0x003f, B:71:0x014f, B:73:0x0155, B:74:0x0160, B:76:0x0164, B:79:0x0172, B:80:0x0177, B:19:0x005c), top: B:105:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0192 A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #1 {all -> 0x01a5, blocks: (B:92:0x018e, B:94:0x0192, B:97:0x01a1, B:98:0x01a4), top: B:104:0x018e }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a1 A[Catch: all -> 0x01a5, TRY_ENTER, TryCatch #1 {all -> 0x01a5, blocks: (B:92:0x018e, B:94:0x0192, B:97:0x01a1, B:98:0x01a4), top: B:104:0x018e }] */
    /* JADX WARN: Type inference failed for: r13v0, types: [coil3.RealImageLoader] */
    /* JADX WARN: Type inference failed for: r3v12, types: [coil3.EventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21, types: [coil3.EventListener] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v4, types: [coil3.EventListener] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [coil3.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [coil3.request.RequestDelegate] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, int i, Continuation<? super ImageResult> continuation) {
        RealImageLoader$execute$3 realImageLoader$execute$3;
        Object coroutine_suspended;
        EventListener eventListener;
        ?? r4;
        ?? r5;
        RequestDelegate requestDelegate;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        RequestDelegate requestDelegate2;
        Image image;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        RequestDelegate requestDelegate3;
        EventListener eventListener3;
        ImageRequest imageRequest3;
        MemoryCache memoryCache;
        MemoryCache.Value value;
        ImageRequest imageRequest4;
        Object withContext;
        EventListener eventListener4;
        RequestDelegate requestDelegate4;
        ImageRequest imageRequest5;
        ImageResult imageResult;
        try {
            try {
                if (continuation instanceof RealImageLoader$execute$3) {
                    realImageLoader$execute$3 = (RealImageLoader$execute$3) continuation;
                    if ((realImageLoader$execute$3.label & Integer.MIN_VALUE) != 0) {
                        realImageLoader$execute$3.label -= Integer.MIN_VALUE;
                        RealImageLoader$execute$3 realImageLoader$execute$32 = realImageLoader$execute$3;
                        Object obj = realImageLoader$execute$32.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        eventListener = realImageLoader$execute$32.label;
                        r4 = 2;
                        r5 = 1;
                        if (eventListener != 0) {
                            ResultKt.throwOnFailure(obj);
                            requestDelegate = this.requestService.requestDelegate(imageRequest, JobKt.getJob(realImageLoader$execute$32.getContext()), i == 0);
                            requestDelegate.assertActive();
                            ImageRequest updateRequest = this.requestService.updateRequest(imageRequest);
                            EventListener create = this.options.getEventListenerFactory().create(updateRequest);
                            try {
                                if (Intrinsics.areEqual(updateRequest.getData(), NullRequestData.INSTANCE)) {
                                    throw new NullRequestDataException();
                                }
                                requestDelegate.start();
                                if (i == 0) {
                                    realImageLoader$execute$32.L$0 = requestDelegate;
                                    realImageLoader$execute$32.L$1 = updateRequest;
                                    realImageLoader$execute$32.L$2 = create;
                                    realImageLoader$execute$32.label = 1;
                                    if (requestDelegate.awaitStarted(realImageLoader$execute$32) != coroutine_suspended) {
                                        imageRequest2 = updateRequest;
                                        eventListener2 = create;
                                        requestDelegate2 = requestDelegate;
                                    }
                                    return coroutine_suspended;
                                }
                                imageRequest2 = updateRequest;
                                eventListener = create;
                                MemoryCache.Key placeholderMemoryCacheKey = imageRequest2.getPlaceholderMemoryCacheKey();
                                image = (placeholderMemoryCacheKey != null || (memoryCache = getMemoryCache()) == null || (value = memoryCache.get(placeholderMemoryCacheKey)) == null) ? null : value.getImage();
                                target = imageRequest2.getTarget();
                                if (target != null) {
                                    target.onStart(image == null ? imageRequest2.placeholder() : image);
                                }
                                eventListener.onStart(imageRequest2);
                                listener = imageRequest2.getListener();
                                if (listener != null) {
                                    listener.onStart(imageRequest2);
                                }
                                SizeResolver sizeResolver = imageRequest2.getSizeResolver();
                                eventListener.resolveSizeStart(imageRequest2, sizeResolver);
                                realImageLoader$execute$32.L$0 = requestDelegate;
                                realImageLoader$execute$32.L$1 = imageRequest2;
                                realImageLoader$execute$32.L$2 = eventListener;
                                realImageLoader$execute$32.L$3 = image;
                                realImageLoader$execute$32.label = 2;
                                size = sizeResolver.size(realImageLoader$execute$32);
                                if (size != coroutine_suspended) {
                                    requestDelegate3 = requestDelegate;
                                    obj = size;
                                    eventListener3 = eventListener;
                                    imageRequest3 = imageRequest2;
                                    Image image2 = image;
                                    Size size2 = (Size) obj;
                                    eventListener3.resolveSizeEnd(imageRequest3, size2);
                                    CoroutineContext interceptorCoroutineContext = imageRequest3.getInterceptorCoroutineContext();
                                    imageRequest4 = imageRequest3;
                                    realImageLoader$execute$32.L$0 = requestDelegate3;
                                    realImageLoader$execute$32.L$1 = imageRequest4;
                                    realImageLoader$execute$32.L$2 = eventListener3;
                                    realImageLoader$execute$32.L$3 = null;
                                    realImageLoader$execute$32.label = 3;
                                    withContext = BuildersKt.withContext(interceptorCoroutineContext, new RealImageLoader$execute$result$1(imageRequest4, this, size2, eventListener3, image2, null), realImageLoader$execute$32);
                                    if (withContext != coroutine_suspended) {
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th) {
                                th = th;
                                r5 = requestDelegate;
                                r4 = updateRequest;
                                eventListener = create;
                                if (!(th instanceof CancellationException)) {
                                }
                            }
                        } else if (eventListener == 1) {
                            eventListener = (EventListener) realImageLoader$execute$32.L$2;
                            imageRequest2 = (ImageRequest) realImageLoader$execute$32.L$1;
                            requestDelegate2 = (RequestDelegate) realImageLoader$execute$32.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                eventListener2 = eventListener;
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = imageRequest2;
                                r5 = requestDelegate2;
                                if (!(th instanceof CancellationException)) {
                                }
                            }
                        } else if (eventListener != 2) {
                            if (eventListener == 3) {
                                eventListener4 = (EventListener) realImageLoader$execute$32.L$2;
                                imageRequest5 = (ImageRequest) realImageLoader$execute$32.L$1;
                                requestDelegate4 = (RequestDelegate) realImageLoader$execute$32.L$0;
                                ResultKt.throwOnFailure(obj);
                                imageResult = (ImageResult) obj;
                                if (!(imageResult instanceof SuccessResult)) {
                                    onSuccess((SuccessResult) imageResult, imageRequest5.getTarget(), eventListener4);
                                } else if (!(imageResult instanceof ErrorResult)) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    onError((ErrorResult) imageResult, imageRequest5.getTarget(), eventListener4);
                                }
                                requestDelegate4.complete();
                                return imageResult;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            image = (Image) realImageLoader$execute$32.L$3;
                            EventListener eventListener5 = (EventListener) realImageLoader$execute$32.L$2;
                            ImageRequest imageRequest6 = (ImageRequest) realImageLoader$execute$32.L$1;
                            RequestDelegate requestDelegate5 = (RequestDelegate) realImageLoader$execute$32.L$0;
                            ResultKt.throwOnFailure(obj);
                            eventListener3 = eventListener5;
                            imageRequest3 = imageRequest6;
                            requestDelegate3 = requestDelegate5;
                            Image image22 = image;
                            try {
                                Size size22 = (Size) obj;
                                eventListener3.resolveSizeEnd(imageRequest3, size22);
                                CoroutineContext interceptorCoroutineContext2 = imageRequest3.getInterceptorCoroutineContext();
                                imageRequest4 = imageRequest3;
                                try {
                                    realImageLoader$execute$32.L$0 = requestDelegate3;
                                    realImageLoader$execute$32.L$1 = imageRequest4;
                                    realImageLoader$execute$32.L$2 = eventListener3;
                                    realImageLoader$execute$32.L$3 = null;
                                    realImageLoader$execute$32.label = 3;
                                    withContext = BuildersKt.withContext(interceptorCoroutineContext2, new RealImageLoader$execute$result$1(imageRequest4, this, size22, eventListener3, image22, null), realImageLoader$execute$32);
                                    if (withContext != coroutine_suspended) {
                                        eventListener4 = eventListener3;
                                        requestDelegate4 = requestDelegate3;
                                        imageRequest5 = imageRequest4;
                                        obj = withContext;
                                        imageResult = (ImageResult) obj;
                                        if (!(imageResult instanceof SuccessResult)) {
                                        }
                                        requestDelegate4.complete();
                                        return imageResult;
                                    }
                                    return coroutine_suspended;
                                } catch (Throwable th3) {
                                    th = th3;
                                    eventListener = eventListener3;
                                    r5 = requestDelegate3;
                                    r4 = imageRequest4;
                                    try {
                                        if (!(th instanceof CancellationException)) {
                                        }
                                    } finally {
                                        r5.complete();
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                imageRequest4 = imageRequest3;
                            }
                        }
                        requestDelegate = requestDelegate2;
                        eventListener = eventListener2;
                        MemoryCache.Key placeholderMemoryCacheKey2 = imageRequest2.getPlaceholderMemoryCacheKey();
                        if (placeholderMemoryCacheKey2 != null) {
                        }
                        target = imageRequest2.getTarget();
                        if (target != null) {
                        }
                        eventListener.onStart(imageRequest2);
                        listener = imageRequest2.getListener();
                        if (listener != null) {
                        }
                        SizeResolver sizeResolver2 = imageRequest2.getSizeResolver();
                        eventListener.resolveSizeStart(imageRequest2, sizeResolver2);
                        realImageLoader$execute$32.L$0 = requestDelegate;
                        realImageLoader$execute$32.L$1 = imageRequest2;
                        realImageLoader$execute$32.L$2 = eventListener;
                        realImageLoader$execute$32.L$3 = image;
                        realImageLoader$execute$32.label = 2;
                        size = sizeResolver2.size(realImageLoader$execute$32);
                        if (size != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                }
                MemoryCache.Key placeholderMemoryCacheKey22 = imageRequest2.getPlaceholderMemoryCacheKey();
                if (placeholderMemoryCacheKey22 != null) {
                }
                target = imageRequest2.getTarget();
                if (target != null) {
                }
                eventListener.onStart(imageRequest2);
                listener = imageRequest2.getListener();
                if (listener != null) {
                }
                SizeResolver sizeResolver22 = imageRequest2.getSizeResolver();
                eventListener.resolveSizeStart(imageRequest2, sizeResolver22);
                realImageLoader$execute$32.L$0 = requestDelegate;
                realImageLoader$execute$32.L$1 = imageRequest2;
                realImageLoader$execute$32.L$2 = eventListener;
                realImageLoader$execute$32.L$3 = image;
                realImageLoader$execute$32.label = 2;
                size = sizeResolver22.size(realImageLoader$execute$32);
                if (size != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                r4 = imageRequest2;
                r5 = requestDelegate;
                if (!(th instanceof CancellationException)) {
                    onCancel(r4, eventListener);
                    throw th;
                }
                ErrorResult ErrorResult = UtilsKt.ErrorResult(r4, th);
                onError(ErrorResult, r4.getTarget(), eventListener);
                return ErrorResult;
            }
            if (eventListener != 0) {
            }
            requestDelegate = requestDelegate2;
            eventListener = eventListener2;
        } catch (Throwable th6) {
            th = th6;
        }
        realImageLoader$execute$3 = new RealImageLoader$execute$3(this, continuation);
        RealImageLoader$execute$3 realImageLoader$execute$322 = realImageLoader$execute$3;
        Object obj2 = realImageLoader$execute$322.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        eventListener = realImageLoader$execute$322.label;
        r4 = 2;
        r5 = 1;
    }

    @Override // coil3.ImageLoader
    public void shutdown() {
        if (shutdown$volatile$FU.getAndSet(this, 1) == 1) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil3.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this.options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0056, code lost:
        if (r8 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onSuccess(SuccessResult successResult, Target target, EventListener eventListener) {
        ImageRequest request = successResult.getRequest();
        DataSource dataSource = successResult.getDataSource();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, UtilsKt.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
            }
        }
        if (target instanceof TransitionTarget) {
            SuccessResult successResult2 = successResult;
            Transition create = ImageRequests_androidKt.getTransitionFactory(successResult2.getRequest()).create((TransitionTarget) target, successResult2);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(successResult2.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(successResult2.getRequest(), create);
            }
            target.onSuccess(successResult.getImage());
        }
        eventListener.onSuccess(request, successResult);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, successResult);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r8 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onError(ErrorResult errorResult, Target target, EventListener eventListener) {
        ImageRequest request = errorResult.getRequest();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Throwable throwable = errorResult.getThrowable();
            if (logger.getMinLevel().compareTo(Logger.Level.Error) <= 0) {
                logger.log("RealImageLoader", Logger.Level.Error, "🚨 Failed - " + request.getData(), throwable);
            }
        }
        if (target instanceof TransitionTarget) {
            ErrorResult errorResult2 = errorResult;
            Transition create = ImageRequests_androidKt.getTransitionFactory(errorResult2.getRequest()).create((TransitionTarget) target, errorResult2);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(errorResult2.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(errorResult2.getRequest(), create);
            }
            target.onError(errorResult.getImage());
        }
        eventListener.onError(request, errorResult);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, errorResult);
        }
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🏗 Cancelled - " + imageRequest.getData(), null);
            }
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    /* compiled from: RealImageLoader.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\"\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jj\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcoil3/RealImageLoader$Options;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "Lcoil3/PlatformContext;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)V", "getApplication", "()Landroid/content/Context;", "Landroid/content/Context;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil3/EventListener$Factory;", "getComponentRegistry", "()Lcoil3/ComponentRegistry;", "getLogger", "()Lcoil3/util/Logger;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)Lcoil3/RealImageLoader$Options;", "equals", "", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Options {
        private final Context application;
        private final ComponentRegistry componentRegistry;
        private final ImageRequest.Defaults defaults;
        private final Lazy<DiskCache> diskCacheLazy;
        private final EventListener.Factory eventListenerFactory;
        private final Logger logger;
        private final Lazy<MemoryCache> memoryCacheLazy;

        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger, int i, Object obj) {
            if ((i & 1) != 0) {
                context = options.application;
            }
            if ((i & 2) != 0) {
                defaults = options.defaults;
            }
            Lazy<MemoryCache> lazy3 = lazy;
            if ((i & 4) != 0) {
                lazy3 = options.memoryCacheLazy;
            }
            Lazy<DiskCache> lazy4 = lazy2;
            if ((i & 8) != 0) {
                lazy4 = options.diskCacheLazy;
            }
            if ((i & 16) != 0) {
                factory = options.eventListenerFactory;
            }
            if ((i & 32) != 0) {
                componentRegistry = options.componentRegistry;
            }
            if ((i & 64) != 0) {
                logger = options.logger;
            }
            ComponentRegistry componentRegistry2 = componentRegistry;
            Logger logger2 = logger;
            EventListener.Factory factory2 = factory;
            Lazy lazy5 = lazy3;
            return options.copy(context, defaults, lazy5, lazy4, factory2, componentRegistry2, logger2);
        }

        public final Context component1() {
            return this.application;
        }

        public final ImageRequest.Defaults component2() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> component3() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> component4() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory component5() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry component6() {
            return this.componentRegistry;
        }

        public final Logger component7() {
            return this.logger;
        }

        public final Options copy(Context context, ImageRequest.Defaults defaults, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger) {
            return new Options(context, defaults, lazy, lazy2, factory, componentRegistry, logger);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Options) {
                Options options = (Options) obj;
                return Intrinsics.areEqual(this.application, options.application) && Intrinsics.areEqual(this.defaults, options.defaults) && Intrinsics.areEqual(this.memoryCacheLazy, options.memoryCacheLazy) && Intrinsics.areEqual(this.diskCacheLazy, options.diskCacheLazy) && Intrinsics.areEqual(this.eventListenerFactory, options.eventListenerFactory) && Intrinsics.areEqual(this.componentRegistry, options.componentRegistry) && Intrinsics.areEqual(this.logger, options.logger);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.application.hashCode() * 31) + this.defaults.hashCode()) * 31) + this.memoryCacheLazy.hashCode()) * 31) + this.diskCacheLazy.hashCode()) * 31) + this.eventListenerFactory.hashCode()) * 31) + this.componentRegistry.hashCode()) * 31;
            Logger logger = this.logger;
            return hashCode + (logger == null ? 0 : logger.hashCode());
        }

        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Options(Context context, ImageRequest.Defaults defaults, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger) {
            this.application = context;
            this.defaults = defaults;
            this.memoryCacheLazy = lazy;
            this.diskCacheLazy = lazy2;
            this.eventListenerFactory = factory;
            this.componentRegistry = componentRegistry;
            this.logger = logger;
        }

        public final Context getApplication() {
            return this.application;
        }

        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> getMemoryCacheLazy() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> getDiskCacheLazy() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        public final Logger getLogger() {
            return this.logger;
        }
    }
}

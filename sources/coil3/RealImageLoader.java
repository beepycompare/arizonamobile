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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobKt;
/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\b\u0010!\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002092\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017*\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c*\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\t\u0010!\u001a\u00020\"X\u0082\u0004¨\u0006<"}, d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "options", "Lcoil3/RealImageLoader$Options;", "<init>", "(Lcoil3/RealImageLoader$Options;)V", "getOptions", "()Lcoil3/RealImageLoader$Options;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil3/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache$delegate", "getDiskCache", "()Lcoil3/disk/DiskCache;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "shutdown", "Lkotlinx/atomicfu/AtomicBoolean;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialRequest", "type", "", "(Lcoil3/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "onSuccess", "result", "Lcoil3/request/SuccessResult;", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", "eventListener", "Lcoil3/EventListener;", "onError", "Lcoil3/request/ErrorResult;", "onCancel", "Options", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
        async$default = BuildersKt__Builders_commonKt.async$default(this.scope, this.options.getMainCoroutineContextLazy().getValue(), null, new RealImageLoader$enqueue$job$1(this, imageRequest, null), 2, null);
        return RealImageLoader_androidKt.getDisposable(imageRequest, async$default);
    }

    @Override // coil3.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (!RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest)) {
            return execute(imageRequest, 1, continuation);
        }
        return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(this, imageRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c A[Catch: all -> 0x01db, TryCatch #1 {all -> 0x01db, blocks: (B:44:0x0105, B:46:0x010c, B:48:0x0112, B:50:0x0118, B:51:0x011c, B:54:0x0124, B:56:0x012a, B:57:0x012d, B:59:0x0136, B:60:0x0139, B:35:0x00da, B:37:0x00e6, B:39:0x00eb, B:80:0x01d5, B:81:0x01da), top: B:95:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0136 A[Catch: all -> 0x01db, TryCatch #1 {all -> 0x01db, blocks: (B:44:0x0105, B:46:0x010c, B:48:0x0112, B:50:0x0118, B:51:0x011c, B:54:0x0124, B:56:0x012a, B:57:0x012d, B:59:0x0136, B:60:0x0139, B:35:0x00da, B:37:0x00e6, B:39:0x00eb, B:80:0x01d5, B:81:0x01da), top: B:95:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ac A[Catch: all -> 0x005b, TryCatch #2 {all -> 0x005b, blocks: (B:14:0x0056, B:68:0x01a6, B:70:0x01ac, B:71:0x01b7, B:73:0x01bb, B:76:0x01c9, B:77:0x01ce), top: B:96:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b7 A[Catch: all -> 0x005b, TryCatch #2 {all -> 0x005b, blocks: (B:14:0x0056, B:68:0x01a6, B:70:0x01ac, B:71:0x01b7, B:73:0x01bb, B:76:0x01c9, B:77:0x01ce), top: B:96:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, int i, Continuation<? super ImageResult> continuation) {
        RealImageLoader$execute$3 realImageLoader$execute$3;
        Object coroutine_suspended;
        int i2;
        RequestDelegate requestDelegate;
        ImageRequest updateRequest;
        EventListener create;
        RequestDelegate requestDelegate2;
        EventListener eventListener;
        RequestDelegate requestDelegate3;
        MemoryCache.Key placeholderMemoryCacheKey;
        Image image;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        int i3;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        ImageRequest imageRequest3;
        RequestDelegate requestDelegate4;
        Image image2;
        SizeResolver sizeResolver;
        MemoryCache memoryCache;
        MemoryCache.Value value;
        ImageResult imageResult;
        ImageRequest imageRequest4 = imageRequest;
        int i4 = i;
        if (continuation instanceof RealImageLoader$execute$3) {
            realImageLoader$execute$3 = (RealImageLoader$execute$3) continuation;
            if ((realImageLoader$execute$3.label & Integer.MIN_VALUE) != 0) {
                realImageLoader$execute$3.label -= Integer.MIN_VALUE;
                RealImageLoader$execute$3 realImageLoader$execute$32 = realImageLoader$execute$3;
                Object obj = realImageLoader$execute$32.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = realImageLoader$execute$32.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    requestDelegate = this.requestService.requestDelegate(imageRequest4, JobKt.getJob(realImageLoader$execute$32.getContext()), i4 == 0);
                    requestDelegate.assertActive();
                    updateRequest = this.requestService.updateRequest(imageRequest4);
                    create = this.options.getEventListenerFactory().create(updateRequest);
                    try {
                        if (Intrinsics.areEqual(updateRequest.getData(), NullRequestData.INSTANCE)) {
                            throw new NullRequestDataException();
                        }
                        requestDelegate.start();
                        if (i4 == 0) {
                            realImageLoader$execute$32.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest4);
                            realImageLoader$execute$32.L$1 = requestDelegate;
                            realImageLoader$execute$32.L$2 = updateRequest;
                            realImageLoader$execute$32.L$3 = create;
                            realImageLoader$execute$32.I$0 = i4;
                            realImageLoader$execute$32.label = 1;
                            if (requestDelegate.awaitStarted(realImageLoader$execute$32) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            requestDelegate3 = requestDelegate;
                        }
                        placeholderMemoryCacheKey = updateRequest.getPlaceholderMemoryCacheKey();
                        image = null;
                        if (placeholderMemoryCacheKey != null && (memoryCache = getMemoryCache()) != null && (value = memoryCache.get(placeholderMemoryCacheKey)) != null) {
                            image = value.getImage();
                        }
                        target = updateRequest.getTarget();
                        if (target != null) {
                            target.onStart(image == null ? updateRequest.placeholder() : image);
                        }
                        create.onStart(updateRequest);
                        listener = updateRequest.getListener();
                        if (listener != null) {
                            listener.onStart(updateRequest);
                        }
                        SizeResolver sizeResolver2 = updateRequest.getSizeResolver();
                        create.resolveSizeStart(updateRequest, sizeResolver2);
                        realImageLoader$execute$32.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest4);
                        realImageLoader$execute$32.L$1 = requestDelegate;
                        realImageLoader$execute$32.L$2 = updateRequest;
                        realImageLoader$execute$32.L$3 = create;
                        realImageLoader$execute$32.L$4 = image;
                        realImageLoader$execute$32.L$5 = SpillingKt.nullOutSpilledVariable(sizeResolver2);
                        realImageLoader$execute$32.I$0 = i4;
                        realImageLoader$execute$32.label = 2;
                        size = sizeResolver2.size(realImageLoader$execute$32);
                        if (size != coroutine_suspended) {
                            EventListener eventListener3 = create;
                            i3 = i4;
                            imageRequest2 = updateRequest;
                            eventListener2 = eventListener3;
                            imageRequest3 = imageRequest4;
                            requestDelegate4 = requestDelegate;
                            obj = size;
                            image2 = image;
                            sizeResolver = sizeResolver2;
                            Size size2 = (Size) obj;
                            eventListener2.resolveSizeEnd(imageRequest2, size2);
                            realImageLoader$execute$32.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest3);
                            realImageLoader$execute$32.L$1 = requestDelegate4;
                            realImageLoader$execute$32.L$2 = imageRequest2;
                            realImageLoader$execute$32.L$3 = eventListener2;
                            realImageLoader$execute$32.L$4 = SpillingKt.nullOutSpilledVariable(image2);
                            realImageLoader$execute$32.L$5 = SpillingKt.nullOutSpilledVariable(sizeResolver);
                            realImageLoader$execute$32.L$6 = SpillingKt.nullOutSpilledVariable(size2);
                            realImageLoader$execute$32.I$0 = i3;
                            realImageLoader$execute$32.label = 3;
                            obj = BuildersKt.withContext(imageRequest2.getInterceptorCoroutineContext(), new RealImageLoader$execute$result$1(imageRequest2, this, size2, eventListener2, image2, null), realImageLoader$execute$32);
                            if (obj != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        requestDelegate2 = requestDelegate;
                        eventListener = create;
                    }
                } else {
                    if (i2 == 1) {
                        int i5 = realImageLoader$execute$32.I$0;
                        eventListener = (EventListener) realImageLoader$execute$32.L$3;
                        updateRequest = (ImageRequest) realImageLoader$execute$32.L$2;
                        requestDelegate3 = (RequestDelegate) realImageLoader$execute$32.L$1;
                        ImageRequest imageRequest5 = (ImageRequest) realImageLoader$execute$32.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i4 = i5;
                            imageRequest4 = imageRequest5;
                            create = eventListener;
                        } catch (Throwable th2) {
                            th = th2;
                            requestDelegate2 = requestDelegate3;
                        }
                    } else if (i2 == 2) {
                        int i6 = realImageLoader$execute$32.I$0;
                        SizeResolver sizeResolver3 = (SizeResolver) realImageLoader$execute$32.L$5;
                        Image image3 = (Image) realImageLoader$execute$32.L$4;
                        EventListener eventListener4 = (EventListener) realImageLoader$execute$32.L$3;
                        ImageRequest imageRequest6 = (ImageRequest) realImageLoader$execute$32.L$2;
                        RequestDelegate requestDelegate5 = (RequestDelegate) realImageLoader$execute$32.L$1;
                        ImageRequest imageRequest7 = (ImageRequest) realImageLoader$execute$32.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            image2 = image3;
                            eventListener2 = eventListener4;
                            requestDelegate4 = requestDelegate5;
                            imageRequest3 = imageRequest7;
                            i3 = i6;
                            sizeResolver = sizeResolver3;
                            imageRequest2 = imageRequest6;
                            try {
                                Size size22 = (Size) obj;
                                eventListener2.resolveSizeEnd(imageRequest2, size22);
                                realImageLoader$execute$32.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest3);
                                realImageLoader$execute$32.L$1 = requestDelegate4;
                                realImageLoader$execute$32.L$2 = imageRequest2;
                                realImageLoader$execute$32.L$3 = eventListener2;
                                realImageLoader$execute$32.L$4 = SpillingKt.nullOutSpilledVariable(image2);
                                realImageLoader$execute$32.L$5 = SpillingKt.nullOutSpilledVariable(sizeResolver);
                                realImageLoader$execute$32.L$6 = SpillingKt.nullOutSpilledVariable(size22);
                                realImageLoader$execute$32.I$0 = i3;
                                realImageLoader$execute$32.label = 3;
                                obj = BuildersKt.withContext(imageRequest2.getInterceptorCoroutineContext(), new RealImageLoader$execute$result$1(imageRequest2, this, size22, eventListener2, image2, null), realImageLoader$execute$32);
                                if (obj != coroutine_suspended) {
                                    EventListener eventListener5 = eventListener2;
                                    updateRequest = imageRequest2;
                                    eventListener = eventListener5;
                                    requestDelegate2 = requestDelegate4;
                                    imageResult = (ImageResult) obj;
                                    if (!(imageResult instanceof SuccessResult)) {
                                    }
                                    return imageResult;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th3) {
                                th = th3;
                                EventListener eventListener6 = eventListener2;
                                updateRequest = imageRequest2;
                                eventListener = eventListener6;
                                requestDelegate2 = requestDelegate4;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            eventListener = eventListener4;
                            updateRequest = imageRequest6;
                            requestDelegate2 = requestDelegate5;
                        }
                    } else if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i7 = realImageLoader$execute$32.I$0;
                        Size size3 = (Size) realImageLoader$execute$32.L$6;
                        SizeResolver sizeResolver4 = (SizeResolver) realImageLoader$execute$32.L$5;
                        Image image4 = (Image) realImageLoader$execute$32.L$4;
                        eventListener = (EventListener) realImageLoader$execute$32.L$3;
                        updateRequest = (ImageRequest) realImageLoader$execute$32.L$2;
                        requestDelegate2 = (RequestDelegate) realImageLoader$execute$32.L$1;
                        ImageRequest imageRequest8 = (ImageRequest) realImageLoader$execute$32.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            imageResult = (ImageResult) obj;
                            if (!(imageResult instanceof SuccessResult)) {
                                onSuccess((SuccessResult) imageResult, updateRequest.getTarget(), eventListener);
                            } else if (!(imageResult instanceof ErrorResult)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                onError((ErrorResult) imageResult, updateRequest.getTarget(), eventListener);
                            }
                            return imageResult;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    try {
                        if (th instanceof CancellationException) {
                            onCancel(updateRequest, eventListener);
                            throw th;
                        }
                        ErrorResult ErrorResult = UtilsKt.ErrorResult(updateRequest, th);
                        onError(ErrorResult, updateRequest.getTarget(), eventListener);
                        return ErrorResult;
                    } finally {
                        requestDelegate2.complete();
                    }
                }
                requestDelegate = requestDelegate3;
                placeholderMemoryCacheKey = updateRequest.getPlaceholderMemoryCacheKey();
                image = null;
                if (placeholderMemoryCacheKey != null) {
                    image = value.getImage();
                }
                target = updateRequest.getTarget();
                if (target != null) {
                }
                create.onStart(updateRequest);
                listener = updateRequest.getListener();
                if (listener != null) {
                }
                SizeResolver sizeResolver22 = updateRequest.getSizeResolver();
                create.resolveSizeStart(updateRequest, sizeResolver22);
                realImageLoader$execute$32.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest4);
                realImageLoader$execute$32.L$1 = requestDelegate;
                realImageLoader$execute$32.L$2 = updateRequest;
                realImageLoader$execute$32.L$3 = create;
                realImageLoader$execute$32.L$4 = image;
                realImageLoader$execute$32.L$5 = SpillingKt.nullOutSpilledVariable(sizeResolver22);
                realImageLoader$execute$32.I$0 = i4;
                realImageLoader$execute$32.label = 2;
                size = sizeResolver22.size(realImageLoader$execute$32);
                if (size != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        realImageLoader$execute$3 = new RealImageLoader$execute$3(this, continuation);
        RealImageLoader$execute$3 realImageLoader$execute$322 = realImageLoader$execute$3;
        Object obj2 = realImageLoader$execute$322.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = realImageLoader$execute$322.label;
        if (i2 != 0) {
        }
        requestDelegate = requestDelegate3;
        placeholderMemoryCacheKey = updateRequest.getPlaceholderMemoryCacheKey();
        image = null;
        if (placeholderMemoryCacheKey != null) {
        }
        target = updateRequest.getTarget();
        if (target != null) {
        }
        create.onStart(updateRequest);
        listener = updateRequest.getListener();
        if (listener != null) {
        }
        SizeResolver sizeResolver222 = updateRequest.getSizeResolver();
        create.resolveSizeStart(updateRequest, sizeResolver222);
        realImageLoader$execute$322.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest4);
        realImageLoader$execute$322.L$1 = requestDelegate;
        realImageLoader$execute$322.L$2 = updateRequest;
        realImageLoader$execute$322.L$3 = create;
        realImageLoader$execute$322.L$4 = image;
        realImageLoader$execute$322.L$5 = SpillingKt.nullOutSpilledVariable(sizeResolver222);
        realImageLoader$execute$322.I$0 = i4;
        realImageLoader$execute$322.label = 2;
        size = sizeResolver222.size(realImageLoader$execute$322);
        if (size != coroutine_suspended) {
        }
        return coroutine_suspended;
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005b, code lost:
        r8.onSuccess(r7.getImage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0076, code lost:
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (r8 != null) goto L9;
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
        SuccessResult successResult2 = successResult;
        if (target instanceof TransitionTarget) {
            Transition create = ImageRequests_androidKt.getTransitionFactory(successResult2.getRequest()).create((TransitionTarget) target, successResult2);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(successResult2.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(successResult2.getRequest(), create);
            }
        }
        eventListener.onSuccess(request, successResult);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, successResult);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
        r8.onError(r7.getImage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r8 != null) goto L9;
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
        ErrorResult errorResult2 = errorResult;
        if (target instanceof TransitionTarget) {
            Transition create = ImageRequests_androidKt.getTransitionFactory(errorResult2.getRequest()).create((TransitionTarget) target, errorResult2);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(errorResult2.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(errorResult2.getRequest(), create);
            }
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
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010%\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jz\u0010-\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcoil3/RealImageLoader$Options;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "Lcoil3/PlatformContext;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "mainCoroutineContextLazy", "Lkotlin/Lazy;", "Lkotlin/coroutines/CoroutineContext;", "memoryCacheLazy", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)V", "getApplication", "()Landroid/content/Context;", "Landroid/content/Context;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "getMainCoroutineContextLazy", "()Lkotlin/Lazy;", "getMemoryCacheLazy", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil3/EventListener$Factory;", "getComponentRegistry", "()Lcoil3/ComponentRegistry;", "getLogger", "()Lcoil3/util/Logger;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)Lcoil3/RealImageLoader$Options;", "equals", "", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Options {
        private final Context application;
        private final ComponentRegistry componentRegistry;
        private final ImageRequest.Defaults defaults;
        private final Lazy<DiskCache> diskCacheLazy;
        private final EventListener.Factory eventListenerFactory;
        private final Logger logger;
        private final Lazy<CoroutineContext> mainCoroutineContextLazy;
        private final Lazy<MemoryCache> memoryCacheLazy;

        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, Lazy lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger, int i, Object obj) {
            if ((i & 1) != 0) {
                context = options.application;
            }
            if ((i & 2) != 0) {
                defaults = options.defaults;
            }
            Lazy<CoroutineContext> lazy4 = lazy;
            if ((i & 4) != 0) {
                lazy4 = options.mainCoroutineContextLazy;
            }
            Lazy<MemoryCache> lazy5 = lazy2;
            if ((i & 8) != 0) {
                lazy5 = options.memoryCacheLazy;
            }
            Lazy<DiskCache> lazy6 = lazy3;
            if ((i & 16) != 0) {
                lazy6 = options.diskCacheLazy;
            }
            if ((i & 32) != 0) {
                factory = options.eventListenerFactory;
            }
            if ((i & 64) != 0) {
                componentRegistry = options.componentRegistry;
            }
            if ((i & 128) != 0) {
                logger = options.logger;
            }
            ComponentRegistry componentRegistry2 = componentRegistry;
            Logger logger2 = logger;
            Lazy lazy7 = lazy6;
            EventListener.Factory factory2 = factory;
            return options.copy(context, defaults, lazy4, lazy5, lazy7, factory2, componentRegistry2, logger2);
        }

        public final Context component1() {
            return this.application;
        }

        public final ImageRequest.Defaults component2() {
            return this.defaults;
        }

        public final Lazy<CoroutineContext> component3() {
            return this.mainCoroutineContextLazy;
        }

        public final Lazy<MemoryCache> component4() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> component5() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory component6() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry component7() {
            return this.componentRegistry;
        }

        public final Logger component8() {
            return this.logger;
        }

        public final Options copy(Context context, ImageRequest.Defaults defaults, Lazy<? extends CoroutineContext> lazy, Lazy<? extends MemoryCache> lazy2, Lazy<? extends DiskCache> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger) {
            return new Options(context, defaults, lazy, lazy2, lazy3, factory, componentRegistry, logger);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Options) {
                Options options = (Options) obj;
                return Intrinsics.areEqual(this.application, options.application) && Intrinsics.areEqual(this.defaults, options.defaults) && Intrinsics.areEqual(this.mainCoroutineContextLazy, options.mainCoroutineContextLazy) && Intrinsics.areEqual(this.memoryCacheLazy, options.memoryCacheLazy) && Intrinsics.areEqual(this.diskCacheLazy, options.diskCacheLazy) && Intrinsics.areEqual(this.eventListenerFactory, options.eventListenerFactory) && Intrinsics.areEqual(this.componentRegistry, options.componentRegistry) && Intrinsics.areEqual(this.logger, options.logger);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((((((this.application.hashCode() * 31) + this.defaults.hashCode()) * 31) + this.mainCoroutineContextLazy.hashCode()) * 31) + this.memoryCacheLazy.hashCode()) * 31) + this.diskCacheLazy.hashCode()) * 31) + this.eventListenerFactory.hashCode()) * 31) + this.componentRegistry.hashCode()) * 31;
            Logger logger = this.logger;
            return hashCode + (logger == null ? 0 : logger.hashCode());
        }

        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", mainCoroutineContextLazy=" + this.mainCoroutineContextLazy + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Options(Context context, ImageRequest.Defaults defaults, Lazy<? extends CoroutineContext> lazy, Lazy<? extends MemoryCache> lazy2, Lazy<? extends DiskCache> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger) {
            this.application = context;
            this.defaults = defaults;
            this.mainCoroutineContextLazy = lazy;
            this.memoryCacheLazy = lazy2;
            this.diskCacheLazy = lazy3;
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

        public final Lazy<CoroutineContext> getMainCoroutineContextLazy() {
            return this.mainCoroutineContextLazy;
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

package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Image;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.decode.DecodeResult;
import coil3.decode.Decoder;
import coil3.decode.FileImageSource;
import coil3.decode.ImageSource;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.ImageFetchResult;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.memory.MemoryCacheService;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\"J>\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil3/intercept/EngineInterceptor;", "Lcoil3/intercept/Interceptor;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "memoryCacheService", "Lcoil3/memory/MemoryCacheService;", "intercept", "Lcoil3/request/ImageResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "(Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil3/fetch/FetchResult;", "components", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil3/fetch/SourceFetchResult;", "(Lcoil3/fetch/SourceFetchResult;Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ExecuteResult", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    private final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ImageLoader imageLoader, SystemCallbacks systemCallbacks, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    @Override // coil3.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        EngineInterceptor$intercept$1 engineInterceptor$intercept$1;
        int i;
        Throwable th;
        try {
            if (continuation instanceof EngineInterceptor$intercept$1) {
                engineInterceptor$intercept$1 = (EngineInterceptor$intercept$1) continuation;
                if ((engineInterceptor$intercept$1.label & Integer.MIN_VALUE) != 0) {
                    engineInterceptor$intercept$1.label -= Integer.MIN_VALUE;
                    Object obj = engineInterceptor$intercept$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = engineInterceptor$intercept$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            Interceptor.Chain chain2 = (Interceptor.Chain) engineInterceptor$intercept$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    try {
                        ImageRequest request = chain.getRequest();
                        Object data = request.getData();
                        Size size = chain.getSize();
                        EventListener eventListener = UtilsKt.getEventListener(chain);
                        Options options = this.requestService.options(request, size);
                        Scale scale = options.getScale();
                        eventListener.mapStart(request, data);
                        Object map = this.imageLoader.getComponents().map(data, options);
                        eventListener.mapEnd(request, map);
                        MemoryCache.Key newCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                        MemoryCache.Value cacheValue = newCacheKey != null ? this.memoryCacheService.getCacheValue(request, newCacheKey, size, scale) : null;
                        if (cacheValue != null) {
                            return this.memoryCacheService.newResult(chain, request, newCacheKey, cacheValue);
                        }
                        CoroutineContext fetcherCoroutineContext = request.getFetcherCoroutineContext();
                        try {
                            engineInterceptor$intercept$1.L$0 = chain;
                            engineInterceptor$intercept$1.label = 1;
                            Object withContext = BuildersKt.withContext(fetcherCoroutineContext, new EngineInterceptor$intercept$2(this, request, map, options, eventListener, newCacheKey, chain, null), engineInterceptor$intercept$1);
                            return withContext == coroutine_suspended ? coroutine_suspended : withContext;
                        } catch (Throwable th2) {
                            th = th2;
                            chain = chain;
                            if (!(th instanceof CancellationException)) {
                                throw th;
                            }
                            return UtilsKt.ErrorResult(chain.getRequest(), th);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        if (!(th instanceof CancellationException)) {
                        }
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        engineInterceptor$intercept$1 = new EngineInterceptor$intercept$1(this, continuation);
        Object obj2 = engineInterceptor$intercept$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$intercept$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x019b, code lost:
        if (r0 == r9) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #1 {all -> 0x007b, blocks: (B:22:0x0070, B:37:0x0109, B:39:0x0113), top: B:77:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0144 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:17:0x004d, B:45:0x013d, B:41:0x011d, B:47:0x0144, B:49:0x0149, B:64:0x01a8, B:65:0x01ad), top: B:76:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b6  */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, coil3.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, coil3.request.Options] */
    /* JADX WARN: Type inference failed for: r2v20, types: [T, coil3.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$execute$1 engineInterceptor$execute$1;
        Ref.ObjectRef objectRef;
        SourceFetchResult sourceFetchResult;
        ImageSource source;
        Ref.ObjectRef objectRef2;
        EngineInterceptor$execute$1 engineInterceptor$execute$12;
        ImageRequest imageRequest2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef3;
        T t;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        FetchResult fetchResult;
        Ref.ObjectRef objectRef6;
        ExecuteResult executeResult;
        ImageRequest imageRequest3;
        Ref.ObjectRef objectRef7;
        EventListener eventListener3;
        SourceFetchResult sourceFetchResult2;
        ImageSource source2;
        Object obj3;
        Object obj4;
        try {
            if (continuation instanceof EngineInterceptor$execute$1) {
                engineInterceptor$execute$1 = (EngineInterceptor$execute$1) continuation;
                if ((engineInterceptor$execute$1.label & Integer.MIN_VALUE) != 0) {
                    engineInterceptor$execute$1.label -= Integer.MIN_VALUE;
                    EngineInterceptor$execute$1 engineInterceptor$execute$13 = engineInterceptor$execute$1;
                    Object obj5 = engineInterceptor$execute$13.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    objectRef = engineInterceptor$execute$13.label;
                    if (objectRef != 0) {
                        ResultKt.throwOnFailure(obj5);
                        Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                        objectRef8.element = options;
                        objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = this.imageLoader.getComponents();
                        Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                        try {
                            objectRef8.element = this.requestService.updateOptions((Options) objectRef8.element);
                            if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                                objectRef2.element = UtilsKt.addFirst(UtilsKt.addFirst(((ComponentRegistry) objectRef2.element).newBuilder(), imageRequest.getFetcherFactory()), imageRequest.getDecoderFactory()).build();
                            }
                            engineInterceptor$execute$13.L$0 = imageRequest;
                            engineInterceptor$execute$13.L$1 = obj;
                            engineInterceptor$execute$13.L$2 = eventListener;
                            engineInterceptor$execute$13.L$3 = objectRef8;
                            engineInterceptor$execute$13.L$4 = objectRef2;
                            engineInterceptor$execute$13.L$5 = objectRef9;
                            engineInterceptor$execute$13.L$6 = objectRef9;
                            engineInterceptor$execute$13.label = 1;
                            Object fetch = fetch((ComponentRegistry) objectRef2.element, imageRequest, obj, (Options) objectRef8.element, eventListener, engineInterceptor$execute$13);
                            engineInterceptor$execute$12 = engineInterceptor$execute$13;
                            if (fetch != coroutine_suspended) {
                                imageRequest2 = imageRequest;
                                obj2 = obj;
                                eventListener2 = eventListener;
                                objectRef3 = objectRef8;
                                t = fetch;
                                objectRef4 = objectRef9;
                                objectRef5 = objectRef4;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            objectRef = objectRef9;
                            T t2 = objectRef.element;
                            if (t2 instanceof SourceFetchResult) {
                            }
                            if (sourceFetchResult != null) {
                                UtilsKt.closeQuietly(source);
                            }
                            throw th;
                        }
                    } else if (objectRef == 1) {
                        objectRef4 = (Ref.ObjectRef) engineInterceptor$execute$13.L$6;
                        objectRef5 = (Ref.ObjectRef) engineInterceptor$execute$13.L$5;
                        Ref.ObjectRef objectRef10 = (Ref.ObjectRef) engineInterceptor$execute$13.L$4;
                        Ref.ObjectRef objectRef11 = (Ref.ObjectRef) engineInterceptor$execute$13.L$3;
                        EventListener eventListener4 = (EventListener) engineInterceptor$execute$13.L$2;
                        Object obj6 = engineInterceptor$execute$13.L$1;
                        ImageRequest imageRequest4 = (ImageRequest) engineInterceptor$execute$13.L$0;
                        try {
                            ResultKt.throwOnFailure(obj5);
                            engineInterceptor$execute$12 = engineInterceptor$execute$13;
                            eventListener2 = eventListener4;
                            objectRef3 = objectRef11;
                            obj2 = obj6;
                            objectRef2 = objectRef10;
                            imageRequest2 = imageRequest4;
                            t = obj5;
                        } catch (Throwable th2) {
                            th = th2;
                            objectRef = objectRef5;
                            T t22 = objectRef.element;
                            sourceFetchResult = t22 instanceof SourceFetchResult ? (SourceFetchResult) t22 : null;
                            if (sourceFetchResult != null && (source = sourceFetchResult.getSource()) != null) {
                                UtilsKt.closeQuietly(source);
                            }
                            throw th;
                        }
                    } else if (objectRef != 2) {
                        if (objectRef == 3) {
                            ResultKt.throwOnFailure(obj5);
                            obj4 = obj5;
                            ExecuteResult executeResult2 = (ExecuteResult) obj4;
                            Utils_androidKt.prepareToDraw(executeResult2.getImage());
                            return executeResult2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        objectRef6 = (Ref.ObjectRef) engineInterceptor$execute$13.L$3;
                        objectRef7 = (Ref.ObjectRef) engineInterceptor$execute$13.L$2;
                        eventListener3 = (EventListener) engineInterceptor$execute$13.L$1;
                        imageRequest3 = (ImageRequest) engineInterceptor$execute$13.L$0;
                        ResultKt.throwOnFailure(obj5);
                        engineInterceptor$execute$12 = engineInterceptor$execute$13;
                        obj3 = obj5;
                        executeResult = (ExecuteResult) obj3;
                        objectRef3 = objectRef7;
                        eventListener2 = eventListener3;
                        imageRequest2 = imageRequest3;
                        ExecuteResult executeResult3 = executeResult;
                        T t3 = objectRef6.element;
                        sourceFetchResult2 = t3 instanceof SourceFetchResult ? (SourceFetchResult) t3 : null;
                        if (sourceFetchResult2 != null && (source2 = sourceFetchResult2.getSource()) != null) {
                            UtilsKt.closeQuietly(source2);
                        }
                        EventListener eventListener5 = eventListener2;
                        Logger logger = this.logger;
                        engineInterceptor$execute$12.L$0 = null;
                        engineInterceptor$execute$12.L$1 = null;
                        engineInterceptor$execute$12.L$2 = null;
                        engineInterceptor$execute$12.L$3 = null;
                        engineInterceptor$execute$12.L$4 = null;
                        engineInterceptor$execute$12.L$5 = null;
                        engineInterceptor$execute$12.L$6 = null;
                        engineInterceptor$execute$12.label = 3;
                        Object transform = EngineInterceptorKt.transform(executeResult3, imageRequest2, (Options) objectRef3.element, eventListener5, logger, engineInterceptor$execute$12);
                        obj4 = transform;
                    }
                    objectRef4.element = t;
                    fetchResult = (FetchResult) objectRef5.element;
                    if (fetchResult instanceof SourceFetchResult) {
                        objectRef6 = objectRef5;
                        if (!(fetchResult instanceof ImageFetchResult)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        executeResult = new ExecuteResult(((ImageFetchResult) objectRef6.element).getImage(), ((ImageFetchResult) objectRef6.element).isSampled(), ((ImageFetchResult) objectRef6.element).getDataSource(), null);
                        ExecuteResult executeResult32 = executeResult;
                        T t32 = objectRef6.element;
                        if (t32 instanceof SourceFetchResult) {
                        }
                        if (sourceFetchResult2 != null) {
                        }
                        EventListener eventListener52 = eventListener2;
                        Logger logger2 = this.logger;
                        engineInterceptor$execute$12.L$0 = null;
                        engineInterceptor$execute$12.L$1 = null;
                        engineInterceptor$execute$12.L$2 = null;
                        engineInterceptor$execute$12.L$3 = null;
                        engineInterceptor$execute$12.L$4 = null;
                        engineInterceptor$execute$12.L$5 = null;
                        engineInterceptor$execute$12.L$6 = null;
                        engineInterceptor$execute$12.label = 3;
                        Object transform2 = EngineInterceptorKt.transform(executeResult32, imageRequest2, (Options) objectRef3.element, eventListener52, logger2, engineInterceptor$execute$12);
                        obj4 = transform2;
                    } else {
                        CoroutineContext decoderCoroutineContext = imageRequest2.getDecoderCoroutineContext();
                        objectRef6 = objectRef5;
                        engineInterceptor$execute$12.L$0 = imageRequest2;
                        engineInterceptor$execute$12.L$1 = eventListener2;
                        engineInterceptor$execute$12.L$2 = objectRef3;
                        engineInterceptor$execute$12.L$3 = objectRef6;
                        engineInterceptor$execute$12.L$4 = null;
                        engineInterceptor$execute$12.L$5 = null;
                        engineInterceptor$execute$12.L$6 = null;
                        engineInterceptor$execute$12.label = 2;
                        Object withContext = BuildersKt.withContext(decoderCoroutineContext, new EngineInterceptor$execute$executeResult$1(this, objectRef6, objectRef2, imageRequest2, obj2, objectRef3, eventListener2, null), engineInterceptor$execute$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        imageRequest3 = imageRequest2;
                        objectRef7 = objectRef3;
                        eventListener3 = eventListener2;
                        obj3 = withContext;
                        executeResult = (ExecuteResult) obj3;
                        objectRef3 = objectRef7;
                        eventListener2 = eventListener3;
                        imageRequest2 = imageRequest3;
                        ExecuteResult executeResult322 = executeResult;
                        T t322 = objectRef6.element;
                        if (t322 instanceof SourceFetchResult) {
                        }
                        if (sourceFetchResult2 != null) {
                            UtilsKt.closeQuietly(source2);
                        }
                        EventListener eventListener522 = eventListener2;
                        Logger logger22 = this.logger;
                        engineInterceptor$execute$12.L$0 = null;
                        engineInterceptor$execute$12.L$1 = null;
                        engineInterceptor$execute$12.L$2 = null;
                        engineInterceptor$execute$12.L$3 = null;
                        engineInterceptor$execute$12.L$4 = null;
                        engineInterceptor$execute$12.L$5 = null;
                        engineInterceptor$execute$12.L$6 = null;
                        engineInterceptor$execute$12.label = 3;
                        Object transform22 = EngineInterceptorKt.transform(executeResult322, imageRequest2, (Options) objectRef3.element, eventListener522, logger22, engineInterceptor$execute$12);
                        obj4 = transform22;
                    }
                }
            }
            if (objectRef != 0) {
            }
            objectRef4.element = t;
            fetchResult = (FetchResult) objectRef5.element;
            if (fetchResult instanceof SourceFetchResult) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        engineInterceptor$execute$1 = new EngineInterceptor$execute$1(this, continuation);
        EngineInterceptor$execute$1 engineInterceptor$execute$132 = engineInterceptor$execute$1;
        Object obj52 = engineInterceptor$execute$132.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        objectRef = engineInterceptor$execute$132.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008b -> B:21:0x008f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        EngineInterceptor$fetch$1 engineInterceptor$fetch$1;
        int i;
        int i2;
        Pair<Fetcher, Integer> newFetcher;
        ImageSource source;
        if (continuation instanceof EngineInterceptor$fetch$1) {
            engineInterceptor$fetch$1 = (EngineInterceptor$fetch$1) continuation;
            if ((engineInterceptor$fetch$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$fetch$1.label -= Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$fetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    newFetcher = componentRegistry.newFetcher(obj, options, this.imageLoader, i2);
                    if (newFetcher != null) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = engineInterceptor$fetch$1.I$0;
                    options = (Options) engineInterceptor$fetch$1.L$3;
                    Object obj3 = engineInterceptor$fetch$1.L$2;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$fetch$1.L$1;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$12 = engineInterceptor$fetch$1;
                    int i4 = i3;
                    componentRegistry = (ComponentRegistry) engineInterceptor$fetch$1.L$0;
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$13 = engineInterceptor$fetch$12;
                    Fetcher first = (Fetcher) engineInterceptor$fetch$1.L$5;
                    imageRequest = imageRequest2;
                    eventListener = (EventListener) engineInterceptor$fetch$1.L$4;
                    obj = obj3;
                    FetchResult fetchResult = (FetchResult) obj2;
                    try {
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult);
                        if (fetchResult == null) {
                            return fetchResult;
                        }
                        i2 = i4;
                        engineInterceptor$fetch$1 = engineInterceptor$fetch$13;
                        newFetcher = componentRegistry.newFetcher(obj, options, this.imageLoader, i2);
                        if (newFetcher != null) {
                            throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                        }
                        first = newFetcher.getFirst();
                        int intValue = newFetcher.getSecond().intValue() + 1;
                        eventListener.fetchStart(imageRequest, first, options);
                        engineInterceptor$fetch$1.L$0 = componentRegistry;
                        engineInterceptor$fetch$1.L$1 = imageRequest;
                        engineInterceptor$fetch$1.L$2 = obj;
                        engineInterceptor$fetch$1.L$3 = options;
                        engineInterceptor$fetch$1.L$4 = eventListener;
                        engineInterceptor$fetch$1.L$5 = first;
                        engineInterceptor$fetch$1.I$0 = intValue;
                        engineInterceptor$fetch$1.label = 1;
                        Object fetch = first.fetch(engineInterceptor$fetch$1);
                        if (fetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        EngineInterceptor$fetch$1 engineInterceptor$fetch$14 = engineInterceptor$fetch$1;
                        i4 = intValue;
                        obj2 = fetch;
                        engineInterceptor$fetch$13 = engineInterceptor$fetch$14;
                        FetchResult fetchResult2 = (FetchResult) obj2;
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult2);
                        if (fetchResult2 == null) {
                        }
                    } catch (Throwable th) {
                        SourceFetchResult sourceFetchResult = fetchResult2 instanceof SourceFetchResult ? (SourceFetchResult) fetchResult2 : null;
                        if (sourceFetchResult != null && (source = sourceFetchResult.getSource()) != null) {
                            UtilsKt.closeQuietly(source);
                        }
                        throw th;
                    }
                }
            }
        }
        engineInterceptor$fetch$1 = new EngineInterceptor$fetch$1(this, continuation);
        Object obj22 = engineInterceptor$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$fetch$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:21:0x0098). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceFetchResult sourceFetchResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$decode$1 engineInterceptor$decode$1;
        int i;
        int i2;
        Pair<Decoder, Integer> newDecoder;
        if (continuation instanceof EngineInterceptor$decode$1) {
            engineInterceptor$decode$1 = (EngineInterceptor$decode$1) continuation;
            if ((engineInterceptor$decode$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$decode$1.label -= Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$decode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$decode$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    newDecoder = componentRegistry.newDecoder(sourceFetchResult, options, this.imageLoader, i2);
                    if (newDecoder != null) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = engineInterceptor$decode$1.I$0;
                    Decoder decoder = (Decoder) engineInterceptor$decode$1.L$6;
                    Object obj3 = engineInterceptor$decode$1.L$3;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$decode$1.L$2;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$decode$1.L$1;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$decode$1 engineInterceptor$decode$12 = engineInterceptor$decode$1;
                    int i4 = i3;
                    sourceFetchResult = (SourceFetchResult) engineInterceptor$decode$1.L$0;
                    EngineInterceptor$decode$1 engineInterceptor$decode$13 = engineInterceptor$decode$12;
                    eventListener = (EventListener) engineInterceptor$decode$1.L$5;
                    imageRequest = imageRequest2;
                    options = (Options) engineInterceptor$decode$1.L$4;
                    obj = obj3;
                    DecodeResult decodeResult = (DecodeResult) obj2;
                    eventListener.decodeEnd(imageRequest, decoder, options, decodeResult);
                    if (decodeResult != null) {
                        i2 = i4;
                        componentRegistry = componentRegistry2;
                        engineInterceptor$decode$1 = engineInterceptor$decode$13;
                        newDecoder = componentRegistry.newDecoder(sourceFetchResult, options, this.imageLoader, i2);
                        if (newDecoder != null) {
                            throw new IllegalStateException(("Unable to create a decoder that supports: " + obj).toString());
                        }
                        Decoder first = newDecoder.getFirst();
                        int intValue = newDecoder.getSecond().intValue() + 1;
                        eventListener.decodeStart(imageRequest, first, options);
                        engineInterceptor$decode$1.L$0 = sourceFetchResult;
                        engineInterceptor$decode$1.L$1 = componentRegistry;
                        engineInterceptor$decode$1.L$2 = imageRequest;
                        engineInterceptor$decode$1.L$3 = obj;
                        engineInterceptor$decode$1.L$4 = options;
                        engineInterceptor$decode$1.L$5 = eventListener;
                        engineInterceptor$decode$1.L$6 = first;
                        engineInterceptor$decode$1.I$0 = intValue;
                        engineInterceptor$decode$1.label = 1;
                        Object decode = first.decode(engineInterceptor$decode$1);
                        if (decode == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        componentRegistry2 = componentRegistry;
                        decoder = first;
                        EngineInterceptor$decode$1 engineInterceptor$decode$14 = engineInterceptor$decode$1;
                        i4 = intValue;
                        obj2 = decode;
                        engineInterceptor$decode$13 = engineInterceptor$decode$14;
                        DecodeResult decodeResult2 = (DecodeResult) obj2;
                        eventListener.decodeEnd(imageRequest, decoder, options, decodeResult2);
                        if (decodeResult2 != null) {
                        }
                    } else {
                        Image image = decodeResult2.getImage();
                        boolean isSampled = decodeResult2.isSampled();
                        DataSource dataSource = sourceFetchResult.getDataSource();
                        ImageSource source = sourceFetchResult.getSource();
                        FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                        return new ExecuteResult(image, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey$coil_core_release() : null);
                    }
                }
            }
        }
        engineInterceptor$decode$1 = new EngineInterceptor$decode$1(this, continuation);
        Object obj22 = engineInterceptor$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$decode$1.label;
        if (i != 0) {
        }
    }

    /* compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "", "image", "Lcoil3/Image;", "isSampled", "", "dataSource", "Lcoil3/decode/DataSource;", "diskCacheKey", "", "<init>", "(Lcoil3/Image;ZLcoil3/decode/DataSource;Ljava/lang/String;)V", "getImage", "()Lcoil3/Image;", "()Z", "getDataSource", "()Lcoil3/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Image image;
        private final boolean isSampled;

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Image image, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                image = executeResult.image;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(image, z, dataSource, str);
        }

        public final Image component1() {
            return this.image;
        }

        public final boolean component2() {
            return this.isSampled;
        }

        public final DataSource component3() {
            return this.dataSource;
        }

        public final String component4() {
            return this.diskCacheKey;
        }

        public final ExecuteResult copy(Image image, boolean z, DataSource dataSource, String str) {
            return new ExecuteResult(image, z, dataSource, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExecuteResult) {
                ExecuteResult executeResult = (ExecuteResult) obj;
                return Intrinsics.areEqual(this.image, executeResult.image) && this.isSampled == executeResult.isSampled && this.dataSource == executeResult.dataSource && Intrinsics.areEqual(this.diskCacheKey, executeResult.diskCacheKey);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode()) * 31;
            String str = this.diskCacheKey;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ExecuteResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ", diskCacheKey=" + this.diskCacheKey + ')';
        }

        public ExecuteResult(Image image, boolean z, DataSource dataSource, String str) {
            this.image = image;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Image getImage() {
            return this.image;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }
    }

    /* compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/intercept/EngineInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

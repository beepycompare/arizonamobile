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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\"J>\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil3/intercept/EngineInterceptor;", "Lcoil3/intercept/Interceptor;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "memoryCacheService", "Lcoil3/memory/MemoryCacheService;", "intercept", "Lcoil3/request/ImageResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "(Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil3/fetch/FetchResult;", "components", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil3/fetch/SourceFetchResult;", "(Lcoil3/fetch/SourceFetchResult;Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ExecuteResult", "Companion", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010b  */
    @Override // coil3.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        EngineInterceptor$intercept$1 engineInterceptor$intercept$1;
        int i;
        Interceptor.Chain chain2 = chain;
        if (continuation instanceof EngineInterceptor$intercept$1) {
            engineInterceptor$intercept$1 = (EngineInterceptor$intercept$1) continuation;
            if ((engineInterceptor$intercept$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$intercept$1.label -= Integer.MIN_VALUE;
                EngineInterceptor$intercept$1 engineInterceptor$intercept$12 = engineInterceptor$intercept$1;
                Object obj = engineInterceptor$intercept$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$intercept$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ImageRequest request = chain2.getRequest();
                        Object data = request.getData();
                        Size size = chain2.getSize();
                        EventListener eventListener = UtilsKt.getEventListener(chain2);
                        Options options = this.requestService.options(request, size);
                        Scale scale = options.getScale();
                        eventListener.mapStart(request, data);
                        Object map = this.imageLoader.getComponents().map(data, options);
                        eventListener.mapEnd(request, map);
                        MemoryCache.Key newCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                        MemoryCache.Value cacheValue = newCacheKey != null ? this.memoryCacheService.getCacheValue(request, newCacheKey, size, scale) : null;
                        if (cacheValue != null) {
                            return this.memoryCacheService.newResult(chain2, request, newCacheKey, cacheValue);
                        }
                        engineInterceptor$intercept$12.L$0 = chain2;
                        engineInterceptor$intercept$12.L$1 = SpillingKt.nullOutSpilledVariable(request);
                        engineInterceptor$intercept$12.L$2 = SpillingKt.nullOutSpilledVariable(data);
                        engineInterceptor$intercept$12.L$3 = SpillingKt.nullOutSpilledVariable(size);
                        engineInterceptor$intercept$12.L$4 = SpillingKt.nullOutSpilledVariable(eventListener);
                        engineInterceptor$intercept$12.L$5 = SpillingKt.nullOutSpilledVariable(options);
                        engineInterceptor$intercept$12.L$6 = SpillingKt.nullOutSpilledVariable(scale);
                        engineInterceptor$intercept$12.L$7 = SpillingKt.nullOutSpilledVariable(map);
                        engineInterceptor$intercept$12.L$8 = SpillingKt.nullOutSpilledVariable(newCacheKey);
                        engineInterceptor$intercept$12.L$9 = SpillingKt.nullOutSpilledVariable(cacheValue);
                        engineInterceptor$intercept$12.label = 1;
                        Object withContext = BuildersKt.withContext(request.getFetcherCoroutineContext(), new EngineInterceptor$intercept$2(this, request, map, options, eventListener, newCacheKey, chain2, null), engineInterceptor$intercept$12);
                        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    MemoryCache.Value value = (MemoryCache.Value) engineInterceptor$intercept$12.L$9;
                    MemoryCache.Key key = (MemoryCache.Key) engineInterceptor$intercept$12.L$8;
                    Object obj2 = engineInterceptor$intercept$12.L$7;
                    Scale scale2 = (Scale) engineInterceptor$intercept$12.L$6;
                    Options options2 = (Options) engineInterceptor$intercept$12.L$5;
                    EventListener eventListener2 = (EventListener) engineInterceptor$intercept$12.L$4;
                    Size size2 = (Size) engineInterceptor$intercept$12.L$3;
                    Object obj3 = engineInterceptor$intercept$12.L$2;
                    ImageRequest imageRequest = (ImageRequest) engineInterceptor$intercept$12.L$1;
                    Interceptor.Chain chain3 = (Interceptor.Chain) engineInterceptor$intercept$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        chain2 = chain3;
                    }
                }
                if (!(th instanceof CancellationException)) {
                    throw th;
                }
                return UtilsKt.ErrorResult(chain2.getRequest(), th);
            }
        }
        engineInterceptor$intercept$1 = new EngineInterceptor$intercept$1(this, continuation);
        EngineInterceptor$intercept$1 engineInterceptor$intercept$122 = engineInterceptor$intercept$1;
        Object obj4 = engineInterceptor$intercept$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$intercept$122.label;
        if (i != 0) {
        }
        if (!(th instanceof CancellationException)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0212, code lost:
        if (r0 == r9) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014c A[Catch: all -> 0x0225, TRY_LEAVE, TryCatch #0 {all -> 0x0225, blocks: (B:38:0x0142, B:40:0x014c), top: B:77:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0192 A[Catch: all -> 0x007d, TryCatch #3 {all -> 0x007d, blocks: (B:17:0x0077, B:46:0x0187, B:42:0x0157, B:47:0x0192, B:49:0x019a, B:63:0x021f, B:64:0x0224), top: B:83:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0237  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, coil3.request.Options] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, coil3.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, coil3.ComponentRegistry] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$execute$1 engineInterceptor$execute$1;
        Ref.ObjectRef objectRef;
        SourceFetchResult sourceFetchResult;
        ImageSource source;
        EngineInterceptor$execute$1 engineInterceptor$execute$12;
        ImageRequest imageRequest2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef2;
        T t;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Options options2;
        Options options3;
        FetchResult fetchResult;
        Ref.ObjectRef objectRef6;
        ExecuteResult executeResult;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        ImageRequest imageRequest3;
        Object obj3;
        Ref.ObjectRef objectRef9;
        EventListener eventListener3;
        Options options4;
        ImageSource source2;
        Object obj4;
        Object obj5;
        EngineInterceptor engineInterceptor = this;
        try {
            try {
                if (continuation instanceof EngineInterceptor$execute$1) {
                    engineInterceptor$execute$1 = (EngineInterceptor$execute$1) continuation;
                    if ((engineInterceptor$execute$1.label & Integer.MIN_VALUE) != 0) {
                        engineInterceptor$execute$1.label -= Integer.MIN_VALUE;
                        EngineInterceptor$execute$1 engineInterceptor$execute$13 = engineInterceptor$execute$1;
                        Object obj6 = engineInterceptor$execute$13.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        objectRef = engineInterceptor$execute$13.label;
                        if (objectRef != 0) {
                            ResultKt.throwOnFailure(obj6);
                            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                            T t2 = options;
                            objectRef10.element = t2;
                            Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
                            objectRef11.element = engineInterceptor.imageLoader.getComponents();
                            Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
                            try {
                                objectRef10.element = engineInterceptor.requestService.updateOptions((Options) objectRef10.element);
                                if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                                    objectRef11.element = UtilsKt.addFirst(UtilsKt.addFirst(((ComponentRegistry) objectRef11.element).newBuilder(), imageRequest.getFetcherFactory()), imageRequest.getDecoderFactory()).build();
                                }
                                engineInterceptor$execute$13.L$0 = imageRequest;
                                engineInterceptor$execute$13.L$1 = obj;
                                engineInterceptor$execute$13.L$2 = SpillingKt.nullOutSpilledVariable(t2);
                                engineInterceptor$execute$13.L$3 = eventListener;
                                engineInterceptor$execute$13.L$4 = objectRef10;
                                engineInterceptor$execute$13.L$5 = objectRef11;
                                engineInterceptor$execute$13.L$6 = objectRef12;
                                engineInterceptor$execute$13.L$7 = objectRef12;
                                engineInterceptor$execute$13.label = 1;
                                Object fetch = engineInterceptor.fetch((ComponentRegistry) objectRef11.element, imageRequest, obj, (Options) objectRef10.element, eventListener, engineInterceptor$execute$13);
                                engineInterceptor$execute$12 = engineInterceptor$execute$13;
                                if (fetch == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                imageRequest2 = imageRequest;
                                obj2 = obj;
                                eventListener2 = eventListener;
                                objectRef2 = objectRef10;
                                t = fetch;
                                objectRef3 = objectRef11;
                                objectRef4 = objectRef12;
                                objectRef5 = objectRef4;
                                options2 = t2;
                            } catch (Throwable th) {
                                th = th;
                                objectRef = objectRef12;
                                T t3 = objectRef.element;
                                if (t3 instanceof SourceFetchResult) {
                                }
                                if (sourceFetchResult != null) {
                                    UtilsKt.closeQuietly(source);
                                }
                                throw th;
                            }
                        } else if (objectRef == 1) {
                            objectRef4 = (Ref.ObjectRef) engineInterceptor$execute$13.L$7;
                            objectRef5 = (Ref.ObjectRef) engineInterceptor$execute$13.L$6;
                            Ref.ObjectRef objectRef13 = (Ref.ObjectRef) engineInterceptor$execute$13.L$5;
                            Ref.ObjectRef objectRef14 = (Ref.ObjectRef) engineInterceptor$execute$13.L$4;
                            EventListener eventListener4 = (EventListener) engineInterceptor$execute$13.L$3;
                            Options options5 = (Options) engineInterceptor$execute$13.L$2;
                            Object obj7 = engineInterceptor$execute$13.L$1;
                            ImageRequest imageRequest4 = (ImageRequest) engineInterceptor$execute$13.L$0;
                            try {
                                ResultKt.throwOnFailure(obj6);
                                objectRef3 = objectRef13;
                                engineInterceptor$execute$12 = engineInterceptor$execute$13;
                                imageRequest2 = imageRequest4;
                                eventListener2 = eventListener4;
                                objectRef2 = objectRef14;
                                obj2 = obj7;
                                t = obj6;
                                options2 = options5;
                            } catch (Throwable th2) {
                                th = th2;
                                objectRef = objectRef5;
                                T t32 = objectRef.element;
                                if (t32 instanceof SourceFetchResult) {
                                }
                                if (sourceFetchResult != null) {
                                }
                                throw th;
                            }
                        } else if (objectRef != 2) {
                            if (objectRef == 3) {
                                ExecuteResult executeResult2 = (ExecuteResult) engineInterceptor$execute$13.L$7;
                                Ref.ObjectRef objectRef15 = (Ref.ObjectRef) engineInterceptor$execute$13.L$6;
                                Ref.ObjectRef objectRef16 = (Ref.ObjectRef) engineInterceptor$execute$13.L$5;
                                Ref.ObjectRef objectRef17 = (Ref.ObjectRef) engineInterceptor$execute$13.L$4;
                                EventListener eventListener5 = (EventListener) engineInterceptor$execute$13.L$3;
                                Options options6 = (Options) engineInterceptor$execute$13.L$2;
                                Object obj8 = engineInterceptor$execute$13.L$1;
                                ImageRequest imageRequest5 = (ImageRequest) engineInterceptor$execute$13.L$0;
                                ResultKt.throwOnFailure(obj6);
                                obj5 = obj6;
                                ExecuteResult executeResult3 = (ExecuteResult) obj5;
                                Utils_androidKt.prepareToDraw(executeResult3.getImage());
                                return executeResult3;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            objectRef6 = (Ref.ObjectRef) engineInterceptor$execute$13.L$6;
                            objectRef8 = (Ref.ObjectRef) engineInterceptor$execute$13.L$5;
                            objectRef9 = (Ref.ObjectRef) engineInterceptor$execute$13.L$4;
                            eventListener3 = (EventListener) engineInterceptor$execute$13.L$3;
                            options4 = (Options) engineInterceptor$execute$13.L$2;
                            obj3 = engineInterceptor$execute$13.L$1;
                            imageRequest3 = (ImageRequest) engineInterceptor$execute$13.L$0;
                            ResultKt.throwOnFailure(obj6);
                            engineInterceptor$execute$12 = engineInterceptor$execute$13;
                            obj4 = obj6;
                            Ref.ObjectRef objectRef18 = objectRef8;
                            executeResult = (ExecuteResult) obj4;
                            objectRef7 = objectRef18;
                            eventListener2 = eventListener3;
                            options3 = options4;
                            obj2 = obj3;
                            objectRef2 = objectRef9;
                            imageRequest2 = imageRequest3;
                            T t4 = objectRef6.element;
                            sourceFetchResult = t4 instanceof SourceFetchResult ? (SourceFetchResult) t4 : null;
                            if (sourceFetchResult != null && (source2 = sourceFetchResult.getSource()) != null) {
                                UtilsKt.closeQuietly(source2);
                            }
                            Ref.ObjectRef objectRef19 = objectRef2;
                            EventListener eventListener6 = eventListener2;
                            Logger logger = engineInterceptor.logger;
                            engineInterceptor$execute$12.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest2);
                            engineInterceptor$execute$12.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            engineInterceptor$execute$12.L$2 = SpillingKt.nullOutSpilledVariable(options3);
                            engineInterceptor$execute$12.L$3 = SpillingKt.nullOutSpilledVariable(eventListener6);
                            engineInterceptor$execute$12.L$4 = SpillingKt.nullOutSpilledVariable(objectRef19);
                            engineInterceptor$execute$12.L$5 = SpillingKt.nullOutSpilledVariable(objectRef7);
                            engineInterceptor$execute$12.L$6 = SpillingKt.nullOutSpilledVariable(objectRef6);
                            engineInterceptor$execute$12.L$7 = SpillingKt.nullOutSpilledVariable(executeResult);
                            engineInterceptor$execute$12.label = 3;
                            Object transform = EngineInterceptorKt.transform(executeResult, imageRequest2, (Options) objectRef2.element, eventListener6, logger, engineInterceptor$execute$12);
                            obj5 = transform;
                        }
                        options3 = options2;
                        objectRef4.element = t;
                        fetchResult = (FetchResult) objectRef5.element;
                        if (fetchResult instanceof SourceFetchResult) {
                            objectRef6 = objectRef5;
                            Ref.ObjectRef objectRef20 = objectRef3;
                            engineInterceptor = this;
                            if (!(fetchResult instanceof ImageFetchResult)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            executeResult = new ExecuteResult(((ImageFetchResult) objectRef6.element).getImage(), ((ImageFetchResult) objectRef6.element).isSampled(), ((ImageFetchResult) objectRef6.element).getDataSource(), null);
                            objectRef7 = objectRef20;
                            T t42 = objectRef6.element;
                            if (t42 instanceof SourceFetchResult) {
                            }
                            if (sourceFetchResult != null) {
                            }
                            Ref.ObjectRef objectRef192 = objectRef2;
                            EventListener eventListener62 = eventListener2;
                            Logger logger2 = engineInterceptor.logger;
                            engineInterceptor$execute$12.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest2);
                            engineInterceptor$execute$12.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            engineInterceptor$execute$12.L$2 = SpillingKt.nullOutSpilledVariable(options3);
                            engineInterceptor$execute$12.L$3 = SpillingKt.nullOutSpilledVariable(eventListener62);
                            engineInterceptor$execute$12.L$4 = SpillingKt.nullOutSpilledVariable(objectRef192);
                            engineInterceptor$execute$12.L$5 = SpillingKt.nullOutSpilledVariable(objectRef7);
                            engineInterceptor$execute$12.L$6 = SpillingKt.nullOutSpilledVariable(objectRef6);
                            engineInterceptor$execute$12.L$7 = SpillingKt.nullOutSpilledVariable(executeResult);
                            engineInterceptor$execute$12.label = 3;
                            Object transform2 = EngineInterceptorKt.transform(executeResult, imageRequest2, (Options) objectRef2.element, eventListener62, logger2, engineInterceptor$execute$12);
                            obj5 = transform2;
                        } else {
                            CoroutineContext decoderCoroutineContext = imageRequest2.getDecoderCoroutineContext();
                            objectRef6 = objectRef5;
                            objectRef8 = objectRef3;
                            engineInterceptor = this;
                            engineInterceptor$execute$12.L$0 = imageRequest2;
                            engineInterceptor$execute$12.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            engineInterceptor$execute$12.L$2 = SpillingKt.nullOutSpilledVariable(options3);
                            engineInterceptor$execute$12.L$3 = eventListener2;
                            engineInterceptor$execute$12.L$4 = objectRef2;
                            engineInterceptor$execute$12.L$5 = SpillingKt.nullOutSpilledVariable(objectRef8);
                            engineInterceptor$execute$12.L$6 = objectRef6;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 2;
                            Object withContext = BuildersKt.withContext(decoderCoroutineContext, new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef6, objectRef8, imageRequest2, obj2, objectRef2, eventListener2, null), engineInterceptor$execute$12);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            imageRequest3 = imageRequest2;
                            obj3 = obj2;
                            objectRef9 = objectRef2;
                            eventListener3 = eventListener2;
                            options4 = options3;
                            obj4 = withContext;
                            Ref.ObjectRef objectRef182 = objectRef8;
                            executeResult = (ExecuteResult) obj4;
                            objectRef7 = objectRef182;
                            eventListener2 = eventListener3;
                            options3 = options4;
                            obj2 = obj3;
                            objectRef2 = objectRef9;
                            imageRequest2 = imageRequest3;
                            T t422 = objectRef6.element;
                            if (t422 instanceof SourceFetchResult) {
                            }
                            if (sourceFetchResult != null) {
                                UtilsKt.closeQuietly(source2);
                            }
                            Ref.ObjectRef objectRef1922 = objectRef2;
                            EventListener eventListener622 = eventListener2;
                            Logger logger22 = engineInterceptor.logger;
                            engineInterceptor$execute$12.L$0 = SpillingKt.nullOutSpilledVariable(imageRequest2);
                            engineInterceptor$execute$12.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            engineInterceptor$execute$12.L$2 = SpillingKt.nullOutSpilledVariable(options3);
                            engineInterceptor$execute$12.L$3 = SpillingKt.nullOutSpilledVariable(eventListener622);
                            engineInterceptor$execute$12.L$4 = SpillingKt.nullOutSpilledVariable(objectRef1922);
                            engineInterceptor$execute$12.L$5 = SpillingKt.nullOutSpilledVariable(objectRef7);
                            engineInterceptor$execute$12.L$6 = SpillingKt.nullOutSpilledVariable(objectRef6);
                            engineInterceptor$execute$12.L$7 = SpillingKt.nullOutSpilledVariable(executeResult);
                            engineInterceptor$execute$12.label = 3;
                            Object transform22 = EngineInterceptorKt.transform(executeResult, imageRequest2, (Options) objectRef2.element, eventListener622, logger22, engineInterceptor$execute$12);
                            obj5 = transform22;
                        }
                    }
                }
                objectRef4.element = t;
                fetchResult = (FetchResult) objectRef5.element;
                if (fetchResult instanceof SourceFetchResult) {
                }
            } catch (Throwable th3) {
                th = th3;
                objectRef = objectRef5;
                T t322 = objectRef.element;
                sourceFetchResult = t322 instanceof SourceFetchResult ? (SourceFetchResult) t322 : null;
                if (sourceFetchResult != null && (source = sourceFetchResult.getSource()) != null) {
                    UtilsKt.closeQuietly(source);
                }
                throw th;
            }
            if (objectRef != 0) {
            }
            options3 = options2;
        } catch (Throwable th4) {
            th = th4;
        }
        engineInterceptor$execute$1 = new EngineInterceptor$execute$1(engineInterceptor, continuation);
        EngineInterceptor$execute$1 engineInterceptor$execute$132 = engineInterceptor$execute$1;
        Object obj62 = engineInterceptor$execute$132.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        objectRef = engineInterceptor$execute$132.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0091 -> B:20:0x0094). Please submit an issue!!! */
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
                    Pair pair = (Pair) engineInterceptor$fetch$1.L$5;
                    options = (Options) engineInterceptor$fetch$1.L$3;
                    Object obj3 = engineInterceptor$fetch$1.L$2;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$fetch$1.L$1;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    int intValue = i3;
                    componentRegistry = componentRegistry2;
                    Fetcher first = (Fetcher) engineInterceptor$fetch$1.L$6;
                    imageRequest = imageRequest2;
                    eventListener = (EventListener) engineInterceptor$fetch$1.L$4;
                    obj = obj3;
                    FetchResult fetchResult = (FetchResult) obj2;
                    try {
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult);
                        if (fetchResult == null) {
                            return fetchResult;
                        }
                        i2 = intValue;
                        newFetcher = componentRegistry.newFetcher(obj, options, this.imageLoader, i2);
                        if (newFetcher != null) {
                            throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                        }
                        first = newFetcher.getFirst();
                        intValue = newFetcher.getSecond().intValue() + 1;
                        eventListener.fetchStart(imageRequest, first, options);
                        engineInterceptor$fetch$1.L$0 = componentRegistry;
                        engineInterceptor$fetch$1.L$1 = imageRequest;
                        engineInterceptor$fetch$1.L$2 = obj;
                        engineInterceptor$fetch$1.L$3 = options;
                        engineInterceptor$fetch$1.L$4 = eventListener;
                        engineInterceptor$fetch$1.L$5 = SpillingKt.nullOutSpilledVariable(newFetcher);
                        engineInterceptor$fetch$1.L$6 = first;
                        engineInterceptor$fetch$1.I$0 = intValue;
                        engineInterceptor$fetch$1.label = 1;
                        obj2 = first.fetch(engineInterceptor$fetch$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009a -> B:21:0x009d). Please submit an issue!!! */
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
                    Decoder decoder = (Decoder) engineInterceptor$decode$1.L$7;
                    Pair pair = (Pair) engineInterceptor$decode$1.L$6;
                    Object obj3 = engineInterceptor$decode$1.L$3;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$decode$1.L$2;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$decode$1.L$1;
                    SourceFetchResult sourceFetchResult2 = (SourceFetchResult) engineInterceptor$decode$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    int intValue = i3;
                    sourceFetchResult = sourceFetchResult2;
                    eventListener = (EventListener) engineInterceptor$decode$1.L$5;
                    imageRequest = imageRequest2;
                    options = (Options) engineInterceptor$decode$1.L$4;
                    obj = obj3;
                    DecodeResult decodeResult = (DecodeResult) obj2;
                    eventListener.decodeEnd(imageRequest, decoder, options, decodeResult);
                    if (decodeResult != null) {
                        componentRegistry = componentRegistry2;
                        i2 = intValue;
                        newDecoder = componentRegistry.newDecoder(sourceFetchResult, options, this.imageLoader, i2);
                        if (newDecoder != null) {
                            throw new IllegalStateException(("Unable to create a decoder that supports: " + obj).toString());
                        }
                        Decoder first = newDecoder.getFirst();
                        intValue = newDecoder.getSecond().intValue() + 1;
                        eventListener.decodeStart(imageRequest, first, options);
                        engineInterceptor$decode$1.L$0 = sourceFetchResult;
                        engineInterceptor$decode$1.L$1 = componentRegistry;
                        engineInterceptor$decode$1.L$2 = imageRequest;
                        engineInterceptor$decode$1.L$3 = obj;
                        engineInterceptor$decode$1.L$4 = options;
                        engineInterceptor$decode$1.L$5 = eventListener;
                        engineInterceptor$decode$1.L$6 = SpillingKt.nullOutSpilledVariable(newDecoder);
                        engineInterceptor$decode$1.L$7 = first;
                        engineInterceptor$decode$1.I$0 = intValue;
                        engineInterceptor$decode$1.label = 1;
                        obj2 = first.decode(engineInterceptor$decode$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        componentRegistry2 = componentRegistry;
                        decoder = first;
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "", "image", "Lcoil3/Image;", "isSampled", "", "dataSource", "Lcoil3/decode/DataSource;", "diskCacheKey", "", "<init>", "(Lcoil3/Image;ZLcoil3/decode/DataSource;Ljava/lang/String;)V", "getImage", "()Lcoil3/Image;", "()Z", "getDataSource", "()Lcoil3/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/intercept/EngineInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;
    private static final String TAG = "GlideRequest";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = LogTime.getLogTime();
            if (this.model == null) {
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
            } else if (this.status == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else {
                if (this.status == Status.COMPLETE) {
                    onResourceReady(this.resource, DataSource.MEMORY_CACHE, false);
                    return;
                }
                experimentalNotifyRequestStarted(this.model);
                this.cookie = GlideTrace.beginSectionAsync(TAG);
                this.status = Status.WAITING_FOR_SIZE;
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    onSizeReady(this.overrideWidth, this.overrideHeight);
                } else {
                    this.target.getSize(this);
                }
                if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                    this.target.onLoadStarted(getPlaceholderDrawable());
                }
                if (IS_VERBOSE_LOGGABLE) {
                    logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                }
            }
        }
    }

    private void experimentalNotifyRequestStarted(Object obj) {
        List<RequestListener<R>> list = this.requestListeners;
        if (list == null) {
            return;
        }
        for (RequestListener<R> requestListener : list) {
            if (requestListener instanceof ExperimentalRequestListener) {
                ((ExperimentalRequestListener) requestListener).onRequestStarted(obj);
            }
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            if (this.status == Status.CLEARED) {
                return;
            }
            cancel();
            Resource<R> resource = this.resource;
            if (resource != null) {
                this.resource = null;
            } else {
                resource = null;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            GlideTrace.endSectionAsync(TAG, this.cookie);
            this.status = Status.CLEARED;
            if (resource != null) {
                this.engine.release(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable(this.context, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        int i3;
        Class<?> resourceClass;
        Class<R> cls;
        Priority priority;
        DiskCacheStrategy diskCacheStrategy;
        Map<Class<?>, Transformation<?>> transformations;
        boolean isTransformationRequired;
        boolean isScaleOnlyOrNoTransform;
        Options options;
        boolean isMemoryCacheable;
        boolean useUnlimitedSourceGeneratorsPool;
        boolean useAnimationPool;
        boolean onlyRetrieveFromCache;
        Executor executor;
        SingleRequest<R> singleRequest = this;
        singleRequest.stateVerifier.throwIfRecycled();
        Object obj = singleRequest.requestLock;
        synchronized (obj) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        singleRequest.logV("Got onSizeReady in " + LogTime.getElapsedMillis(singleRequest.startTime));
                    }
                    if (singleRequest.status == Status.WAITING_FOR_SIZE) {
                        singleRequest.status = Status.RUNNING;
                        float sizeMultiplier = singleRequest.requestOptions.getSizeMultiplier();
                        singleRequest.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        singleRequest.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            singleRequest.logV("finished setup for calling load in " + LogTime.getElapsedMillis(singleRequest.startTime));
                        }
                        Engine engine = singleRequest.engine;
                        GlideContext glideContext = singleRequest.glideContext;
                        try {
                            Object obj2 = singleRequest.model;
                            Key signature = singleRequest.requestOptions.getSignature();
                            try {
                                int i4 = singleRequest.width;
                                try {
                                    i3 = singleRequest.height;
                                    resourceClass = singleRequest.requestOptions.getResourceClass();
                                    try {
                                        cls = singleRequest.transcodeClass;
                                        try {
                                            priority = singleRequest.priority;
                                            diskCacheStrategy = singleRequest.requestOptions.getDiskCacheStrategy();
                                            transformations = singleRequest.requestOptions.getTransformations();
                                            isTransformationRequired = singleRequest.requestOptions.isTransformationRequired();
                                            isScaleOnlyOrNoTransform = singleRequest.requestOptions.isScaleOnlyOrNoTransform();
                                            options = singleRequest.requestOptions.getOptions();
                                            isMemoryCacheable = singleRequest.requestOptions.isMemoryCacheable();
                                            useUnlimitedSourceGeneratorsPool = singleRequest.requestOptions.getUseUnlimitedSourceGeneratorsPool();
                                            useAnimationPool = singleRequest.requestOptions.getUseAnimationPool();
                                            onlyRetrieveFromCache = singleRequest.requestOptions.getOnlyRetrieveFromCache();
                                            executor = singleRequest.callbackExecutor;
                                            singleRequest = obj;
                                        } catch (Throwable th) {
                                            th = th;
                                            singleRequest = obj;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        singleRequest = obj;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    singleRequest = obj;
                                }
                                try {
                                    singleRequest.loadStatus = engine.load(glideContext, obj2, signature, i4, i3, resourceClass, cls, priority, diskCacheStrategy, transformations, isTransformationRequired, isScaleOnlyOrNoTransform, options, isMemoryCacheable, useUnlimitedSourceGeneratorsPool, useAnimationPool, onlyRetrieveFromCache, singleRequest, executor);
                                    if (singleRequest.status != Status.RUNNING) {
                                        singleRequest.loadStatus = null;
                                    }
                                    if (z) {
                                        singleRequest.logV("finished onSizeReady in " + LogTime.getElapsedMillis(singleRequest.startTime));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                singleRequest = obj;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            singleRequest = obj;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    singleRequest = obj;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r7 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        r6.engine.release(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResourceReady(Resource<?> resource, DataSource dataSource, boolean z) {
        String str;
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource2 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    try {
                        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (!canSetResource()) {
                                this.resource = null;
                                this.status = Status.COMPLETE;
                                GlideTrace.endSectionAsync(TAG, this.cookie);
                            } else {
                                onResourceReady(resource, obj, dataSource, z);
                                return;
                            }
                        }
                        this.resource = null;
                        StringBuilder append = new StringBuilder("Expected to receive an object of ").append(this.transcodeClass).append(" but instead got ").append(obj != null ? obj.getClass() : "").append("{").append(obj).append("} inside Resource{").append(resource).append("}.");
                        if (obj != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        onLoadFailed(new GlideException(append.append(str).toString()));
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.engine.release(resource2);
            }
            throw th3;
        }
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource, boolean z) {
        boolean z2;
        boolean z3;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        notifyRequestCoordinatorLoadSucceeded();
        boolean z4 = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                z2 = false;
                for (RequestListener<R> requestListener : list) {
                    R r2 = r;
                    DataSource dataSource2 = dataSource;
                    boolean onResourceReady = requestListener.onResourceReady(r2, this.model, this.target, dataSource2, isFirstReadyResource) | z2;
                    if (requestListener instanceof ExperimentalRequestListener) {
                        z3 = z;
                        onResourceReady |= ((ExperimentalRequestListener) requestListener).onResourceReady(r2, this.model, this.target, dataSource2, isFirstReadyResource, z3);
                    } else {
                        z3 = z;
                    }
                    dataSource = dataSource2;
                    z = z3;
                    z2 = onResourceReady;
                    r = r2;
                }
            } else {
                z2 = false;
            }
            R r3 = r;
            DataSource dataSource3 = dataSource;
            RequestListener<R> requestListener2 = this.targetListener;
            if (requestListener2 == null || !requestListener2.onResourceReady(r3, this.model, this.target, dataSource3, isFirstReadyResource)) {
                z4 = false;
            }
            if (!(z4 | z2)) {
                this.target.onResourceReady(r3, this.animationFactory.build(dataSource3, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            GlideTrace.endSectionAsync(TAG, this.cookie);
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            notifyRequestCoordinatorLoadFailed();
            boolean z2 = true;
            this.isCallingCallbacks = true;
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                z = false;
                for (RequestListener<R> requestListener : list) {
                    z |= requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                }
            } else {
                z = false;
            }
            RequestListener<R> requestListener2 = this.targetListener;
            if (requestListener2 == null || !requestListener2.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                z2 = false;
            }
            if (!(z | z2)) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            GlideTrace.endSectionAsync(TAG, this.cookie);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (request instanceof SingleRequest) {
            synchronized (this.requestLock) {
                i = this.overrideWidth;
                i2 = this.overrideHeight;
                obj = this.model;
                cls = this.transcodeClass;
                baseRequestOptions = this.requestOptions;
                priority = this.priority;
                List<RequestListener<R>> list = this.requestListeners;
                size = list != null ? list.size() : 0;
            }
            SingleRequest singleRequest = (SingleRequest) request;
            synchronized (singleRequest.requestLock) {
                i3 = singleRequest.overrideWidth;
                i4 = singleRequest.overrideHeight;
                obj2 = singleRequest.model;
                cls2 = singleRequest.transcodeClass;
                baseRequestOptions2 = singleRequest.requestOptions;
                priority2 = singleRequest.priority;
                List<RequestListener<R>> list2 = singleRequest.requestListeners;
                size2 = list2 != null ? list2.size() : 0;
            }
            return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && Util.bothBaseRequestOptionsNullEquivalentOrEquals(baseRequestOptions, baseRequestOptions2) && priority == priority2 && size == size2;
        }
        return false;
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}

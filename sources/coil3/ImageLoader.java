package coil3;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.RealImageLoader;
import coil3.disk.DiskCache;
import coil3.disk.UtilsKt;
import coil3.memory.MemoryCache;
import coil3.request.CachePolicy;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Precision;
import coil3.util.ContextsKt;
import coil3.util.Logger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.FileSystem;
/* compiled from: ImageLoader.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcoil3/ImageLoader;", "", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache", "()Lcoil3/disk/DiskCache;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "Builder", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ImageLoader {
    Disposable enqueue(ImageRequest imageRequest);

    Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation);

    ComponentRegistry getComponents();

    ImageRequest.Defaults getDefaults();

    DiskCache getDiskCache();

    MemoryCache getMemoryCache();

    Builder newBuilder();

    void shutdown();

    /* compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\"\u0010\u001f\u001a\u00020\u00002\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!¢\u0006\u0002\b$H\u0086\bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0012J\u0016\u0010%\u001a\u00020\u00002\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120'J\u0010\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0014J\u0016\u0010(\u001a\u00020\u00002\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140'J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0007J\u0016\u00102\u001a\u00020\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100'H\u0007J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010J\u0010\u00106\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000108J\u001c\u00106\u001a\u00020\u00002\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u0001080!J\u0010\u0010:\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000108J\u001c\u0010:\u001a\u00020\u00002\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u0001080!J\u0010\u0010;\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000108J\u001c\u0010;\u001a\u00020\u00002\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u0001080!J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010A\u001a\u00020BR\u0014\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006C"}, d2 = {"Lcoil3/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "<init>", "(Landroid/content/Context;)V", "options", "Lcoil3/RealImageLoader$Options;", "(Lcoil3/RealImageLoader$Options;)V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "mainCoroutineContextLazy", "Lkotlin/Lazy;", "Lkotlin/coroutines/CoroutineContext;", "memoryCacheLazy", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "extras", "Lcoil3/Extras$Builder;", "getExtras", "()Lcoil3/Extras$Builder;", "components", "builder", "Lkotlin/Function1;", "Lcoil3/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "memoryCache", "initializer", "Lkotlin/Function0;", "diskCache", "fileSystem", "Lokio/FileSystem;", "eventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/EventListener;", "factory", "precision", "Lcoil3/size/Precision;", "coroutineContext", "mainCoroutineContext", "interceptorCoroutineContext", "fetcherCoroutineContext", "decoderCoroutineContext", "placeholder", "image", "Lcoil3/Image;", "Lcoil3/request/ImageRequest;", "error", "fallback", "memoryCachePolicy", "policy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "build", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final Context application;
        private ComponentRegistry componentRegistry;
        private ImageRequest.Defaults defaults;
        private Lazy<? extends DiskCache> diskCacheLazy;
        private EventListener.Factory eventListenerFactory;
        private final Extras.Builder extras;
        private Logger logger;
        private Lazy<? extends CoroutineContext> mainCoroutineContextLazy;
        private Lazy<? extends MemoryCache> memoryCacheLazy;

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image error$lambda$17(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EventListener eventListener$lambda$6(EventListener eventListener, ImageRequest imageRequest) {
            return eventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image fallback$lambda$19(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineContext mainCoroutineContext$lambda$10(CoroutineContext coroutineContext) {
            return coroutineContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image placeholder$lambda$15(Image image, ImageRequest imageRequest) {
            return image;
        }

        public final Extras.Builder getExtras() {
            return this.extras;
        }

        public Builder(Context context) {
            this.application = ContextsKt.getApplication(context);
            this.defaults = ImageRequest.Defaults.DEFAULT;
            this.mainCoroutineContextLazy = null;
            this.memoryCacheLazy = null;
            this.diskCacheLazy = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.logger = null;
            this.extras = new Extras.Builder();
        }

        public Builder(RealImageLoader.Options options) {
            this.application = options.getApplication();
            this.defaults = options.getDefaults();
            this.mainCoroutineContextLazy = options.getMainCoroutineContextLazy();
            this.memoryCacheLazy = options.getMemoryCacheLazy();
            this.diskCacheLazy = options.getDiskCacheLazy();
            this.eventListenerFactory = options.getEventListenerFactory();
            this.componentRegistry = options.getComponentRegistry();
            this.logger = options.getLogger();
            this.extras = options.getDefaults().getExtras().newBuilder();
        }

        public final /* synthetic */ Builder components(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return components(builder.build());
        }

        public final Builder components(ComponentRegistry componentRegistry) {
            this.componentRegistry = componentRegistry;
            return this;
        }

        public final Builder memoryCache(MemoryCache memoryCache) {
            this.memoryCacheLazy = LazyKt.lazyOf(memoryCache);
            return this;
        }

        public final Builder memoryCache(Function0<? extends MemoryCache> function0) {
            this.memoryCacheLazy = LazyKt.lazy(function0);
            return this;
        }

        public final Builder diskCache(DiskCache diskCache) {
            this.diskCacheLazy = LazyKt.lazyOf(diskCache);
            return this;
        }

        public final Builder diskCache(Function0<? extends DiskCache> function0) {
            this.diskCacheLazy = LazyKt.lazy(function0);
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, fileSystem, null, null, null, null, null, null, null, null, null, null, null, null, null, 16382, null);
            return this;
        }

        public final Builder eventListener(final EventListener eventListener) {
            return eventListenerFactory(new EventListener.Factory() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda6
                @Override // coil3.EventListener.Factory
                public final EventListener create(ImageRequest imageRequest) {
                    EventListener eventListener$lambda$6;
                    eventListener$lambda$6 = ImageLoader.Builder.eventListener$lambda$6(EventListener.this, imageRequest);
                    return eventListener$lambda$6;
                }
            });
        }

        public final Builder eventListenerFactory(EventListener.Factory factory) {
            this.eventListenerFactory = factory;
            return this;
        }

        public final Builder precision(Precision precision) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, null, null, null, precision, null, 12287, null);
            return this;
        }

        public final Builder coroutineContext(CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, coroutineContext, coroutineContext, coroutineContext, null, null, null, null, null, null, null, null, null, null, 16369, null);
            return this;
        }

        public final Builder mainCoroutineContext(final CoroutineContext coroutineContext) {
            return mainCoroutineContext(new Function0() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CoroutineContext mainCoroutineContext$lambda$10;
                    mainCoroutineContext$lambda$10 = ImageLoader.Builder.mainCoroutineContext$lambda$10(CoroutineContext.this);
                    return mainCoroutineContext$lambda$10;
                }
            });
        }

        public final Builder mainCoroutineContext(Function0<? extends CoroutineContext> function0) {
            this.mainCoroutineContextLazy = LazyKt.lazy(function0);
            return this;
        }

        public final Builder interceptorCoroutineContext(CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, coroutineContext, null, null, null, null, null, null, null, null, null, null, null, null, 16381, null);
            return this;
        }

        public final Builder fetcherCoroutineContext(CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, coroutineContext, null, null, null, null, null, null, null, null, null, null, null, 16379, null);
            return this;
        }

        public final Builder decoderCoroutineContext(CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, coroutineContext, null, null, null, null, null, null, null, null, null, null, 16375, null);
            return this;
        }

        public final Builder placeholder(final Image image) {
            return placeholder(new Function1() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image placeholder$lambda$15;
                    placeholder$lambda$15 = ImageLoader.Builder.placeholder$lambda$15(Image.this, (ImageRequest) obj);
                    return placeholder$lambda$15;
                }
            });
        }

        public final Builder placeholder(Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, function1, null, null, null, null, null, null, 16255, null);
            return this;
        }

        public final Builder error(final Image image) {
            return error(new Function1() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image error$lambda$17;
                    error$lambda$17 = ImageLoader.Builder.error$lambda$17(Image.this, (ImageRequest) obj);
                    return error$lambda$17;
                }
            });
        }

        public final Builder error(Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, function1, null, null, null, null, null, 16127, null);
            return this;
        }

        public final Builder fallback(final Image image) {
            return fallback(new Function1() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image fallback$lambda$19;
                    fallback$lambda$19 = ImageLoader.Builder.fallback$lambda$19(Image.this, (ImageRequest) obj);
                    return fallback$lambda$19;
                }
            });
        }

        public final Builder fallback(Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, function1, null, null, null, null, 15871, null);
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, cachePolicy, null, null, null, null, null, null, null, null, null, 16367, null);
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, cachePolicy, null, null, null, null, null, null, null, null, 16351, null);
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, cachePolicy, null, null, null, null, null, null, null, 16319, null);
            return this;
        }

        public final Builder logger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public final ImageLoader build() {
            Context context = this.application;
            ImageRequest.Defaults copy$default = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, null, null, null, null, this.extras.build(), 8191, null);
            Lazy<? extends CoroutineContext> lazy = this.mainCoroutineContextLazy;
            if (lazy == null) {
                lazy = LazyKt.lazy(new Function0() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MainCoroutineDispatcher build$lambda$25;
                        build$lambda$25 = ImageLoader.Builder.build$lambda$25();
                        return build$lambda$25;
                    }
                });
            }
            Lazy<? extends MemoryCache> lazy2 = this.memoryCacheLazy;
            if (lazy2 == null) {
                lazy2 = LazyKt.lazy(new Function0() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MemoryCache build$lambda$26;
                        build$lambda$26 = ImageLoader.Builder.build$lambda$26(ImageLoader.Builder.this);
                        return build$lambda$26;
                    }
                });
            }
            Lazy<? extends DiskCache> lazy3 = this.diskCacheLazy;
            if (lazy3 == null) {
                lazy3 = LazyKt.lazy(new Function0() { // from class: coil3.ImageLoader$Builder$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        DiskCache build$lambda$27;
                        build$lambda$27 = ImageLoader.Builder.build$lambda$27();
                        return build$lambda$27;
                    }
                });
            }
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            ComponentRegistry componentRegistry = this.componentRegistry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(new RealImageLoader.Options(context, copy$default, lazy, lazy2, lazy3, factory, componentRegistry, this.logger));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MainCoroutineDispatcher build$lambda$25() {
            return Dispatchers.getMain().getImmediate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MemoryCache build$lambda$26(Builder builder) {
            return MemoryCache.Builder.maxSizePercent$default(new MemoryCache.Builder(), builder.application, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 2, null).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DiskCache build$lambda$27() {
            return UtilsKt.singletonDiskCache();
        }
    }
}

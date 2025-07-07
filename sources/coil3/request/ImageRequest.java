package coil3.request;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import coil3.Extras;
import coil3.Image;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.size.SizeResolver;
import coil3.size.SizeResolverKt;
import coil3.target.Target;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.Coroutines_nonJsCommonKt;
import coil3.util.FileSystems_nonJsCommonKt;
import coil3.util.UtilsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okio.FileSystem;
/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004nopqBµ\u0002\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u001c\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201¢\u0006\u0004\b2\u00103J\b\u0010b\u001a\u0004\u0018\u00010#J\b\u0010c\u001a\u0004\u0018\u00010#J\b\u0010d\u001a\u0004\u0018\u00010#J\u001b\u0010e\u001a\u00020f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020\u000bH\u0016R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR'\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u0010\u001a\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u001d\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001f\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001f\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u001f\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b`\u0010a¨\u0006r"}, d2 = {"Lcoil3/request/ImageRequest;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "data", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtras", "", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "defined", "Lcoil3/request/ImageRequest$Defined;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Lcoil3/target/Target;Lcoil3/request/ImageRequest$Listener;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lokio/FileSystem;Lkotlin/Pair;Lcoil3/decode/Decoder$Factory;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/memory/MemoryCache$Key;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;Lcoil3/request/ImageRequest$Defined;Lcoil3/request/ImageRequest$Defaults;)V", "getContext", "()Landroid/content/Context;", "Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getTarget", "()Lcoil3/target/Target;", "getListener", "()Lcoil3/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Ljava/lang/String;", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "getDiskCacheKey", "getFileSystem", "()Lokio/FileSystem;", "getFetcherFactory", "()Lkotlin/Pair;", "getDecoderFactory", "()Lcoil3/decode/Decoder$Factory;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderMemoryCacheKey", "()Lcoil3/memory/MemoryCache$Key;", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "getDefined", "()Lcoil3/request/ImageRequest$Defined;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "placeholder", "error", "fallback", "newBuilder", "Lcoil3/request/ImageRequest$Builder;", "(Landroid/content/Context;)Lcoil3/request/ImageRequest$Builder;", "equals", "", "other", "hashCode", "", "toString", "Listener", "Defined", "Defaults", "Builder", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageRequest {
    private final Context context;
    private final Object data;
    private final CoroutineContext decoderCoroutineContext;
    private final Decoder.Factory decoderFactory;
    private final Defaults defaults;
    private final Defined defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Function1<ImageRequest, Image> errorFactory;
    private final Extras extras;
    private final Function1<ImageRequest, Image> fallbackFactory;
    private final CoroutineContext fetcherCoroutineContext;
    private final Pair<Fetcher.Factory<?>, KClass<?>> fetcherFactory;
    private final FileSystem fileSystem;
    private final CoroutineContext interceptorCoroutineContext;
    private final Listener listener;
    private final String memoryCacheKey;
    private final Map<String, String> memoryCacheKeyExtras;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Function1<ImageRequest, Image> placeholderFactory;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Precision precision;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Target target;

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcoil3/request/ImageRequest$Listener;", "", "onStart", "", "request", "Lcoil3/request/ImageRequest;", "onCancel", "onError", "result", "Lcoil3/request/ErrorResult;", "onSuccess", "Lcoil3/request/SuccessResult;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Listener {
        default void onCancel(ImageRequest imageRequest) {
        }

        default void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        }

        default void onStart(ImageRequest imageRequest) {
        }

        default void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        }
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map map, String str2, FileSystem fileSystem, Pair pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, str, map, str2, fileSystem, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function12, function13, sizeResolver, scale, precision, extras, defined, defaults);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return Intrinsics.areEqual(this.context, imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && Intrinsics.areEqual(this.listener, imageRequest.listener) && Intrinsics.areEqual(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.areEqual(this.memoryCacheKeyExtras, imageRequest.memoryCacheKeyExtras) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && Intrinsics.areEqual(this.fileSystem, imageRequest.fileSystem) && Intrinsics.areEqual(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.areEqual(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.areEqual(this.interceptorCoroutineContext, imageRequest.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, imageRequest.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, imageRequest.decoderCoroutineContext) && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual(this.placeholderFactory, imageRequest.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, imageRequest.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, imageRequest.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.precision == imageRequest.precision && Intrinsics.areEqual(this.extras, imageRequest.extras) && Intrinsics.areEqual(this.defined, imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target = this.target;
        int hashCode2 = (hashCode + (target == null ? 0 : target.hashCode())) * 31;
        Listener listener = this.listener;
        int hashCode3 = (hashCode2 + (listener == null ? 0 : listener.hashCode())) * 31;
        String str = this.memoryCacheKey;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.memoryCacheKeyExtras.hashCode()) * 31;
        String str2 = this.diskCacheKey;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.fileSystem.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, KClass<?>> pair = this.fetcherFactory;
        int hashCode6 = (hashCode5 + (pair == null ? 0 : pair.hashCode())) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int hashCode7 = (((((((((((((hashCode6 + (factory == null ? 0 : factory.hashCode())) * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31;
        MemoryCache.Key key = this.placeholderMemoryCacheKey;
        return ((((((((((((((((((hashCode7 + (key != null ? key.hashCode() : 0)) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode()) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, null, 1, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageRequest(context=");
        sb.append(this.context).append(", data=").append(this.data).append(", target=").append(this.target).append(", listener=").append(this.listener).append(", memoryCacheKey=").append(this.memoryCacheKey).append(", memoryCacheKeyExtras=").append(this.memoryCacheKeyExtras).append(", diskCacheKey=").append(this.diskCacheKey).append(", fileSystem=").append(this.fileSystem).append(", fetcherFactory=").append(this.fetcherFactory).append(", decoderFactory=").append(this.decoderFactory).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=");
        sb.append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderMemoryCacheKey=").append(this.placeholderMemoryCacheKey).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=").append(this.scale).append(", precision=").append(this.precision);
        sb.append(", extras=").append(this.extras).append(", defined=").append(this.defined).append(", defaults=").append(this.defaults).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map<String, String> map, String str2, FileSystem fileSystem, Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = str;
        this.memoryCacheKeyExtras = map;
        this.diskCacheKey = str2;
        this.fileSystem = fileSystem;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.interceptorCoroutineContext = coroutineContext;
        this.fetcherCoroutineContext = coroutineContext2;
        this.decoderCoroutineContext = coroutineContext3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderMemoryCacheKey = key;
        this.placeholderFactory = function1;
        this.errorFactory = function12;
        this.fallbackFactory = function13;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.precision = precision;
        this.extras = extras;
        this.defined = defined;
        this.defaults = defaults;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final String getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final Map<String, String> getMemoryCacheKeyExtras() {
        return this.memoryCacheKeyExtras;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public final Pair<Fetcher.Factory<?>, KClass<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final CoroutineContext getInterceptorCoroutineContext() {
        return this.interceptorCoroutineContext;
    }

    public final CoroutineContext getFetcherCoroutineContext() {
        return this.fetcherCoroutineContext;
    }

    public final CoroutineContext getDecoderCoroutineContext() {
        return this.decoderCoroutineContext;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final Function1<ImageRequest, Image> getPlaceholderFactory() {
        return this.placeholderFactory;
    }

    public final Function1<ImageRequest, Image> getErrorFactory() {
        return this.errorFactory;
    }

    public final Function1<ImageRequest, Image> getFallbackFactory() {
        return this.fallbackFactory;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final Defined getDefined() {
        return this.defined;
    }

    public final Defaults getDefaults() {
        return this.defaults;
    }

    public final Image placeholder() {
        Image invoke = this.placeholderFactory.invoke(this);
        return invoke == null ? this.defaults.getPlaceholderFactory().invoke(this) : invoke;
    }

    public final Image error() {
        Image invoke = this.errorFactory.invoke(this);
        return invoke == null ? this.defaults.getErrorFactory().invoke(this) : invoke;
    }

    public final Image fallback() {
        Image invoke = this.fallbackFactory.invoke(this);
        return invoke == null ? this.defaults.getFallbackFactory().invoke(this) : invoke;
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    public final Builder newBuilder(Context context) {
        return new Builder(this, context);
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B³\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019JÌ\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcoil3/request/ImageRequest$Defined;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "copy", "equals", "", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Defined {
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1<ImageRequest, Image> errorFactory;
        private final Function1<ImageRequest, Image> fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1<ImageRequest, Image> placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Defined) {
                Defined defined = (Defined) obj;
                return Intrinsics.areEqual(this.fileSystem, defined.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, defined.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defined.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defined.decoderCoroutineContext) && this.memoryCachePolicy == defined.memoryCachePolicy && this.diskCachePolicy == defined.diskCachePolicy && this.networkCachePolicy == defined.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, defined.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, defined.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, defined.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, defined.sizeResolver) && this.scale == defined.scale && this.precision == defined.precision;
            }
            return false;
        }

        public int hashCode() {
            FileSystem fileSystem = this.fileSystem;
            int hashCode = (fileSystem == null ? 0 : fileSystem.hashCode()) * 31;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            int hashCode2 = (hashCode + (coroutineContext == null ? 0 : coroutineContext.hashCode())) * 31;
            CoroutineContext coroutineContext2 = this.fetcherCoroutineContext;
            int hashCode3 = (hashCode2 + (coroutineContext2 == null ? 0 : coroutineContext2.hashCode())) * 31;
            CoroutineContext coroutineContext3 = this.decoderCoroutineContext;
            int hashCode4 = (hashCode3 + (coroutineContext3 == null ? 0 : coroutineContext3.hashCode())) * 31;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            int hashCode5 = (hashCode4 + (cachePolicy == null ? 0 : cachePolicy.hashCode())) * 31;
            CachePolicy cachePolicy2 = this.diskCachePolicy;
            int hashCode6 = (hashCode5 + (cachePolicy2 == null ? 0 : cachePolicy2.hashCode())) * 31;
            CachePolicy cachePolicy3 = this.networkCachePolicy;
            int hashCode7 = (hashCode6 + (cachePolicy3 == null ? 0 : cachePolicy3.hashCode())) * 31;
            Function1<ImageRequest, Image> function1 = this.placeholderFactory;
            int hashCode8 = (hashCode7 + (function1 == null ? 0 : function1.hashCode())) * 31;
            Function1<ImageRequest, Image> function12 = this.errorFactory;
            int hashCode9 = (hashCode8 + (function12 == null ? 0 : function12.hashCode())) * 31;
            Function1<ImageRequest, Image> function13 = this.fallbackFactory;
            int hashCode10 = (hashCode9 + (function13 == null ? 0 : function13.hashCode())) * 31;
            SizeResolver sizeResolver = this.sizeResolver;
            int hashCode11 = (hashCode10 + (sizeResolver == null ? 0 : sizeResolver.hashCode())) * 31;
            Scale scale = this.scale;
            int hashCode12 = (hashCode11 + (scale == null ? 0 : scale.hashCode())) * 31;
            Precision precision = this.precision;
            return hashCode12 + (precision != null ? precision.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Defined(fileSystem=");
            sb.append(this.fileSystem).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=").append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=");
            sb.append(this.scale).append(", precision=").append(this.precision).append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Defined(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
        }

        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public final Scale getScale() {
            return this.scale;
        }

        public final Precision getPrecision() {
            return this.precision;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Defined copy$default(Defined defined, FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, int i, Object obj) {
            if ((i & 1) != 0) {
                fileSystem = defined.fileSystem;
            }
            return defined.copy(fileSystem, (i & 2) != 0 ? defined.interceptorCoroutineContext : coroutineContext, (i & 4) != 0 ? defined.fetcherCoroutineContext : coroutineContext2, (i & 8) != 0 ? defined.decoderCoroutineContext : coroutineContext3, (i & 16) != 0 ? defined.memoryCachePolicy : cachePolicy, (i & 32) != 0 ? defined.diskCachePolicy : cachePolicy2, (i & 64) != 0 ? defined.networkCachePolicy : cachePolicy3, (i & 128) != 0 ? defined.placeholderFactory : function1, (i & 256) != 0 ? defined.errorFactory : function12, (i & 512) != 0 ? defined.fallbackFactory : function13, (i & 1024) != 0 ? defined.sizeResolver : sizeResolver, (i & 2048) != 0 ? defined.scale : scale, (i & 4096) != 0 ? defined.precision : precision);
        }

        public final Defined copy(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision) {
            return new Defined(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, sizeResolver, scale, precision);
        }
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ¼\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019Jª\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006;"}, d2 = {"Lcoil3/request/ImageRequest$Defaults;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Defaults {
        public static final Companion Companion = new Companion(null);
        public static final Defaults DEFAULT = new Defaults(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1<ImageRequest, Image> errorFactory;
        private final Extras extras;
        private final Function1<ImageRequest, Image> fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1<ImageRequest, Image> placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public Defaults() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Defaults) {
                Defaults defaults = (Defaults) obj;
                return Intrinsics.areEqual(this.fileSystem, defaults.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, defaults.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defaults.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defaults.decoderCoroutineContext) && this.memoryCachePolicy == defaults.memoryCachePolicy && this.diskCachePolicy == defaults.diskCachePolicy && this.networkCachePolicy == defaults.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, defaults.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, defaults.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, defaults.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, defaults.sizeResolver) && this.scale == defaults.scale && this.precision == defaults.precision && Intrinsics.areEqual(this.extras, defaults.extras);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.fileSystem.hashCode() * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Defaults(fileSystem=");
            sb.append(this.fileSystem).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=").append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=");
            sb.append(this.scale).append(", precision=").append(this.precision).append(", extras=").append(this.extras).append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
            this.extras = extras;
        }

        public /* synthetic */ Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? FileSystems_nonJsCommonKt.defaultFileSystem() : fileSystem, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i & 4) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext2, (i & 8) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext3, (i & 16) != 0 ? CachePolicy.ENABLED : cachePolicy, (i & 32) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i & 64) != 0 ? CachePolicy.ENABLED : cachePolicy3, (i & 128) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function1, (i & 256) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function12, (i & 512) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function13, (i & 1024) != 0 ? SizeResolver.ORIGINAL : sizeResolver, (i & 2048) != 0 ? Scale.FIT : scale, (i & 4096) != 0 ? Precision.EXACT : precision, (i & 8192) != 0 ? Extras.EMPTY : extras);
        }

        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public final Scale getScale() {
            return this.scale;
        }

        public final Precision getPrecision() {
            return this.precision;
        }

        public final Extras getExtras() {
            return this.extras;
        }

        public final Defaults copy(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras) {
            return new Defaults(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, sizeResolver, scale, precision, extras);
        }

        public static /* synthetic */ Defaults copy$default(Defaults defaults, FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, Precision precision, Extras extras, int i, Object obj) {
            if ((i & 1) != 0) {
                fileSystem = defaults.fileSystem;
            }
            if ((i & 2) != 0) {
                coroutineContext = defaults.interceptorCoroutineContext;
            }
            if ((i & 4) != 0) {
                coroutineContext2 = defaults.fetcherCoroutineContext;
            }
            if ((i & 8) != 0) {
                coroutineContext3 = defaults.decoderCoroutineContext;
            }
            if ((i & 16) != 0) {
                cachePolicy = defaults.memoryCachePolicy;
            }
            if ((i & 32) != 0) {
                cachePolicy2 = defaults.diskCachePolicy;
            }
            if ((i & 64) != 0) {
                cachePolicy3 = defaults.networkCachePolicy;
            }
            if ((i & 128) != 0) {
                function1 = defaults.placeholderFactory;
            }
            if ((i & 256) != 0) {
                function12 = defaults.errorFactory;
            }
            if ((i & 512) != 0) {
                function13 = defaults.fallbackFactory;
            }
            if ((i & 1024) != 0) {
                precision = defaults.precision;
            }
            if ((i & 2048) != 0) {
                extras = defaults.extras;
            }
            Precision precision2 = precision;
            Extras extras2 = extras;
            Function1 function14 = function12;
            Function1 function15 = function13;
            CachePolicy cachePolicy4 = cachePolicy3;
            Function1 function16 = function1;
            CachePolicy cachePolicy5 = cachePolicy;
            CachePolicy cachePolicy6 = cachePolicy2;
            return defaults.copy(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy5, cachePolicy6, cachePolicy4, function16, function14, function15, precision2, extras2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public final /* synthetic */ Defaults copy(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, Precision precision, Extras extras) {
            return new Defaults(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, null, null, precision, extras, 3072, null);
        }

        /* compiled from: ImageRequest.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/request/ImageRequest$Defaults$Companion;", "", "<init>", "()V", "DEFAULT", "Lcoil3/request/ImageRequest$Defaults;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001f\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0001J|\u0010\u000e\u001a\u00020\u00002%\b\u0006\u0010>\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020B0/2%\b\u0006\u0010C\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010E\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0/H\u0086\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130HJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJÇ\u0001\u0010\u0010\u001a\u00020\u00002#\b\u0006\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/28\b\u0006\u0010C\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110M¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0L28\b\u0006\u0010E\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110N¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0LH\u0086\bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020T2\u0006\u0010S\u001a\u00020TJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020UJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010V\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u000208J#\u0010\u001e\u001a\u00020\u0000\"\n\b\u0000\u0010W\u0018\u0001*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 H\u0086\bJ,\u0010\u001e\u001a\u00020\u0000\"\b\b\u0000\u0010W*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010X\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010A\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010A\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010D\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010D\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010\\\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010\\\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010]\u001a\u00020\bR\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006^"}, d2 = {"Lcoil3/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "<init>", "(Landroid/content/Context;)V", "request", "Lcoil3/request/ImageRequest;", "(Lcoil3/request/ImageRequest;Landroid/content/Context;)V", "Landroid/content/Context;", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Lcoil3/request/ImageRequest$Defaults;", "data", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtrasAreMutable", "", "lazyMemoryCacheKeyExtras", "memoryCacheKeyExtras", "", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "lazyExtras", "extras", "Lcoil3/Extras$Builder;", "getExtras", "()Lcoil3/Extras$Builder;", "onStart", "Lkotlin/ParameterName;", "name", "placeholder", "", "onError", "error", "onSuccess", "result", "key", "", "memoryCacheKeyExtra", "value", "onCancel", "Lkotlin/Function2;", "Lcoil3/request/ErrorResult;", "Lcoil3/request/SuccessResult;", "coroutineContext", "size", "", "width", "height", "Lcoil3/size/Dimension;", "Lcoil3/size/Size;", "resolver", ExifInterface.GPS_DIRECTION_TRUE, "factory", "type", "policy", "image", "fallback", "build", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final Context context;
        private Object data;
        private CoroutineContext decoderCoroutineContext;
        private Decoder.Factory decoderFactory;
        private Defaults defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Function1<? super ImageRequest, ? extends Image> errorFactory;
        private Function1<? super ImageRequest, ? extends Image> fallbackFactory;
        private CoroutineContext fetcherCoroutineContext;
        private Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> fetcherFactory;
        private FileSystem fileSystem;
        private CoroutineContext interceptorCoroutineContext;
        private Object lazyExtras;
        private Object lazyMemoryCacheKeyExtras;
        private Listener listener;
        private String memoryCacheKey;
        private boolean memoryCacheKeyExtrasAreMutable;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Function1<? super ImageRequest, ? extends Image> placeholderFactory;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Precision precision;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Target target;

        public Builder(ImageRequest imageRequest) {
            this(imageRequest, null, 2, null);
        }

        public static final Image error$lambda$27(Image image, ImageRequest imageRequest) {
            return image;
        }

        public static final Image fallback$lambda$29(Image image, ImageRequest imageRequest) {
            return image;
        }

        public static final Image placeholder$lambda$25(Image image, ImageRequest imageRequest) {
            return image;
        }

        private final Map<String, String> getMemoryCacheKeyExtras() {
            Object obj = this.lazyMemoryCacheKeyExtras;
            if (!Intrinsics.areEqual(obj, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                if (obj instanceof Map) {
                    obj = MapsKt.toMutableMap((Map) obj);
                    this.lazyMemoryCacheKeyExtras = obj;
                    this.memoryCacheKeyExtrasAreMutable = true;
                } else {
                    throw new AssertionError();
                }
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            return TypeIntrinsics.asMutableMap(obj);
        }

        public final Extras.Builder getExtras() {
            Object obj = this.lazyExtras;
            if (obj instanceof Extras.Builder) {
                return (Extras.Builder) obj;
            }
            if (obj instanceof Extras) {
                Extras.Builder newBuilder = ((Extras) obj).newBuilder();
                this.lazyExtras = newBuilder;
                return newBuilder;
            }
            throw new AssertionError();
        }

        public Builder(Context context) {
            this.context = context;
            this.defaults = Defaults.DEFAULT;
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.lazyMemoryCacheKeyExtras = MapsKt.emptyMap();
            this.diskCacheKey = null;
            this.fileSystem = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.interceptorCoroutineContext = null;
            this.fetcherCoroutineContext = null;
            this.decoderCoroutineContext = null;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.errorFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.fallbackFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.sizeResolver = null;
            this.scale = null;
            this.precision = null;
            this.lazyExtras = Extras.EMPTY;
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.lazyMemoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.fileSystem = imageRequest.getDefined().getFileSystem();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.interceptorCoroutineContext = imageRequest.getDefined().getInterceptorCoroutineContext();
            this.fetcherCoroutineContext = imageRequest.getDefined().getFetcherCoroutineContext();
            this.decoderCoroutineContext = imageRequest.getDefined().getDecoderCoroutineContext();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderFactory = imageRequest.getDefined().getPlaceholderFactory();
            this.errorFactory = imageRequest.getDefined().getErrorFactory();
            this.fallbackFactory = imageRequest.getDefined().getFallbackFactory();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.precision = imageRequest.getDefined().getPrecision();
            this.lazyExtras = imageRequest.getExtras();
        }

        public /* synthetic */ Builder(ImageRequest imageRequest, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i & 2) != 0 ? imageRequest.getContext() : context);
        }

        public final Builder data(Object obj) {
            this.data = obj;
            return this;
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 2) != 0) {
                function12 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 4) != 0) {
                function13 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$3
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            return builder.target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Function1<? super Image, Unit> function1, Function1<? super Image, Unit> function12, Function1<? super Image, Unit> function13) {
            return target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Target target) {
            this.target = target;
            return this;
        }

        public final Builder memoryCacheKey(MemoryCache.Key key) {
            memoryCacheKey(key != null ? key.getKey() : null);
            Map<String, String> extras = key != null ? key.getExtras() : null;
            if (extras == null) {
                extras = MapsKt.emptyMap();
            }
            memoryCacheKeyExtras(extras);
            return this;
        }

        public final Builder memoryCacheKey(String str) {
            this.memoryCacheKey = str;
            return this;
        }

        public final Builder memoryCacheKeyExtras(Map<String, String> map) {
            this.lazyMemoryCacheKeyExtras = MapsKt.toMutableMap(map);
            this.memoryCacheKeyExtrasAreMutable = true;
            return this;
        }

        public final Builder memoryCacheKeyExtra(String str, String str2) {
            if (str2 != null) {
                getMemoryCacheKeyExtras().put(str, str2);
                return this;
            }
            getMemoryCacheKeyExtras().remove(str);
            return this;
        }

        public final Builder diskCacheKey(String str) {
            this.diskCacheKey = str;
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest) {
                        invoke2(imageRequest);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 2) != 0) {
                function12 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest) {
                        invoke2(imageRequest);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 4) != 0) {
                function2 = new Function2<ImageRequest, ErrorResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$3
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest, ErrorResult errorResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest, ErrorResult errorResult) {
                        invoke2(imageRequest, errorResult);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 8) != 0) {
                function22 = new Function2<ImageRequest, SuccessResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$4
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest, SuccessResult successResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest, SuccessResult successResult) {
                        invoke2(imageRequest, successResult);
                        return Unit.INSTANCE;
                    }
                };
            }
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder coroutineContext(CoroutineContext coroutineContext) {
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext;
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder interceptorCoroutineContext(CoroutineContext coroutineContext) {
            this.interceptorCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder fetcherCoroutineContext(CoroutineContext coroutineContext) {
            this.fetcherCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder decoderCoroutineContext(CoroutineContext coroutineContext) {
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder size(int i) {
            return size(SizeKt.Size(i, i));
        }

        public final Builder size(int i, int i2) {
            return size(SizeKt.Size(i, i2));
        }

        public final Builder size(Dimension dimension, Dimension dimension2) {
            return size(new Size(dimension, dimension2));
        }

        public final Builder size(Size size) {
            return size(SizeResolverKt.SizeResolver(size));
        }

        public final Builder size(SizeResolver sizeResolver) {
            this.sizeResolver = sizeResolver;
            return this;
        }

        public final Builder scale(Scale scale) {
            this.scale = scale;
            return this;
        }

        public final Builder precision(Precision precision) {
            this.precision = precision;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcherFactory(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return fetcherFactory(factory, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> Builder fetcherFactory(Fetcher.Factory<T> factory, KClass<T> kClass) {
            this.fetcherFactory = TuplesKt.to(factory, kClass);
            return this;
        }

        public final Builder decoderFactory(Decoder.Factory factory) {
            this.decoderFactory = factory;
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            this.networkCachePolicy = cachePolicy;
            return this;
        }

        public final Builder placeholderMemoryCacheKey(String str) {
            return placeholderMemoryCacheKey(str != null ? new MemoryCache.Key(str, null, 2, null) : null);
        }

        public final Builder placeholderMemoryCacheKey(MemoryCache.Key key) {
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        public final Builder placeholder(final Image image) {
            return placeholder(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image placeholder$lambda$25;
                    placeholder$lambda$25 = ImageRequest.Builder.placeholder$lambda$25(Image.this, (ImageRequest) obj);
                    return placeholder$lambda$25;
                }
            });
        }

        public final Builder placeholder(Function1<? super ImageRequest, ? extends Image> function1) {
            this.placeholderFactory = function1;
            return this;
        }

        public final Builder error(final Image image) {
            return error(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image error$lambda$27;
                    error$lambda$27 = ImageRequest.Builder.error$lambda$27(Image.this, (ImageRequest) obj);
                    return error$lambda$27;
                }
            });
        }

        public final Builder error(Function1<? super ImageRequest, ? extends Image> function1) {
            this.errorFactory = function1;
            return this;
        }

        public final Builder fallback(final Image image) {
            return fallback(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Image fallback$lambda$29;
                    fallback$lambda$29 = ImageRequest.Builder.fallback$lambda$29(Image.this, (ImageRequest) obj);
                    return fallback$lambda$29;
                }
            });
        }

        public final Builder fallback(Function1<? super ImageRequest, ? extends Image> function1) {
            this.fallbackFactory = function1;
            return this;
        }

        public final Builder defaults(Defaults defaults) {
            this.defaults = defaults;
            return this;
        }

        public final ImageRequest build() {
            Map map;
            Extras extras;
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            String str = this.memoryCacheKey;
            Object obj3 = this.lazyMemoryCacheKeyExtras;
            if (Intrinsics.areEqual(obj3, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
                map = Collections_jvmCommonKt.toImmutableMap(TypeIntrinsics.asMutableMap(obj3));
            } else if (!(obj3 instanceof Map)) {
                throw new AssertionError();
            } else {
                map = (Map) obj3;
            }
            Map map2 = map;
            Intrinsics.checkNotNull(map2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            String str2 = this.diskCacheKey;
            FileSystem fileSystem = this.fileSystem;
            if (fileSystem == null) {
                fileSystem = this.defaults.getFileSystem();
            }
            FileSystem fileSystem2 = fileSystem;
            Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            if (coroutineContext == null) {
                coroutineContext = this.defaults.getInterceptorCoroutineContext();
            }
            CoroutineContext coroutineContext2 = coroutineContext;
            CoroutineContext coroutineContext3 = this.fetcherCoroutineContext;
            if (coroutineContext3 == null) {
                coroutineContext3 = this.defaults.getFetcherCoroutineContext();
            }
            CoroutineContext coroutineContext4 = coroutineContext3;
            CoroutineContext coroutineContext5 = this.decoderCoroutineContext;
            if (coroutineContext5 == null) {
                coroutineContext5 = this.defaults.getDecoderCoroutineContext();
            }
            CoroutineContext coroutineContext6 = coroutineContext5;
            MemoryCache.Key key = this.placeholderMemoryCacheKey;
            Function1 function1 = this.placeholderFactory;
            if (function1 == null) {
                function1 = this.defaults.getPlaceholderFactory();
            }
            Function1 function12 = function1;
            Function1 function13 = this.errorFactory;
            if (function13 == null) {
                function13 = this.defaults.getErrorFactory();
            }
            Function1 function14 = function13;
            Function1 function15 = this.fallbackFactory;
            if (function15 == null) {
                function15 = this.defaults.getFallbackFactory();
            }
            Function1 function16 = function15;
            SizeResolver sizeResolver = this.sizeResolver;
            if (sizeResolver == null) {
                sizeResolver = this.defaults.getSizeResolver();
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.scale;
            if (scale == null) {
                scale = this.defaults.getScale();
            }
            Scale scale2 = scale;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Object obj4 = this.lazyExtras;
            if (obj4 instanceof Extras.Builder) {
                extras = ((Extras.Builder) obj4).build();
            } else if (!(obj4 instanceof Extras)) {
                throw new AssertionError();
            } else {
                extras = (Extras) obj4;
            }
            return new ImageRequest(context, obj2, target, listener, str, map2, str2, fileSystem2, pair, factory, coroutineContext2, coroutineContext4, coroutineContext6, cachePolicy2, cachePolicy4, cachePolicy6, key, function12, function14, function16, sizeResolver2, scale2, precision2, extras, new Defined(this.fileSystem, this.interceptorCoroutineContext, this.fetcherCoroutineContext, this.decoderCoroutineContext, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy, this.placeholderFactory, this.errorFactory, this.fallbackFactory, this.sizeResolver, this.scale, this.precision), this.defaults, null);
        }
    }
}

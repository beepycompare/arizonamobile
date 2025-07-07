package coil3.memory;

import coil3.BitmapImage;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.request.SuccessResult;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.Logger;
import coil3.util.UtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MemoryCacheService.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001dJ0\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001f\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\u00020\u001b*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcoil3/memory/MemoryCacheService;", "", "imageLoader", "Lcoil3/ImageLoader;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "newCacheKey", "Lcoil3/memory/MemoryCache$Key;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "getCacheValue", "Lcoil3/memory/MemoryCache$Value;", "cacheKey", "size", "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "isCacheValueValid", "", "cacheValue", "isCacheValueValid$coil_core_release", "isCacheValueValidForSize", "setCacheValue", "result", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "newResult", "Lcoil3/request/SuccessResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "isSampled", "(Lcoil3/memory/MemoryCache$Value;)Z", "diskCacheKey", "", "getDiskCacheKey", "(Lcoil3/memory/MemoryCache$Value;)Ljava/lang/String;", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemoryCacheService {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_SIZE = "coil#size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    /* compiled from: MemoryCacheService.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Precision.values().length];
            try {
                iArr2[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener) {
        if (imageRequest.getMemoryCacheKey() != null) {
            return new MemoryCache.Key(imageRequest.getMemoryCacheKey(), imageRequest.getMemoryCacheKeyExtras());
        }
        eventListener.keyStart(imageRequest, obj);
        String key = UtilsKt.key(this.imageLoader.getComponents(), obj, options, this.logger, TAG);
        eventListener.keyEnd(imageRequest, key);
        if (key == null) {
            return null;
        }
        if (!ImageRequestsKt.getTransformations(imageRequest).isEmpty()) {
            Map mutableMap = MapsKt.toMutableMap(imageRequest.getMemoryCacheKeyExtras());
            mutableMap.put(EXTRA_SIZE, options.getSize().toString());
            return new MemoryCache.Key(key, mutableMap);
        }
        return new MemoryCache.Key(key, imageRequest.getMemoryCacheKeyExtras());
    }

    public final MemoryCache.Value getCacheValue(ImageRequest imageRequest, MemoryCache.Key key, Size size, Scale scale) {
        if (imageRequest.getMemoryCachePolicy().getReadEnabled()) {
            MemoryCache memoryCache = this.imageLoader.getMemoryCache();
            MemoryCache.Value value = memoryCache != null ? memoryCache.get(key) : null;
            if (value == null || !isCacheValueValid$coil_core_release(imageRequest, key, value, size, scale)) {
                return null;
            }
            return value;
        }
        return null;
    }

    public final boolean isCacheValueValid$coil_core_release(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        if (!this.requestService.isCacheValueValidForHardware(imageRequest, value)) {
            Logger logger = this.logger;
            if (logger != null) {
                Logger.Level level = Logger.Level.Debug;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(TAG, level, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
                    return false;
                }
                return false;
            }
            return false;
        }
        return isCacheValueValidForSize(imageRequest, key, value, size, scale);
    }

    private final boolean isCacheValueValidForSize(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        Size size2;
        int abs;
        int abs2;
        String str = key.getExtras().get(EXTRA_SIZE);
        if (str != null) {
            if (Intrinsics.areEqual(str, size.toString())) {
                return true;
            }
            Logger logger = this.logger;
            if (logger != null) {
                Logger.Level level = Logger.Level.Debug;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(TAG, level, imageRequest.getData() + ": Memory cached image's size (" + str + ") does not exactly match the target size (" + size + ").", null);
                }
            }
            return false;
        } else if (isSampled(value) || !(SizeKt.isOriginal(size) || imageRequest.getPrecision() == Precision.INEXACT)) {
            int width = value.getImage().getWidth();
            int height = value.getImage().getHeight();
            if (value.getImage() instanceof BitmapImage) {
                size2 = ImageRequestsKt.getMaxBitmapSize(imageRequest);
            } else {
                size2 = Size.ORIGINAL;
            }
            Dimension width2 = size.getWidth();
            int m7820unboximpl = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).m7820unboximpl() : Integer.MAX_VALUE;
            Dimension width3 = size2.getWidth();
            int min = Math.min(m7820unboximpl, width3 instanceof Dimension.Pixels ? ((Dimension.Pixels) width3).m7820unboximpl() : Integer.MAX_VALUE);
            Dimension height2 = size.getHeight();
            int m7820unboximpl2 = height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).m7820unboximpl() : Integer.MAX_VALUE;
            Dimension height3 = size2.getHeight();
            int min2 = Math.min(m7820unboximpl2, height3 instanceof Dimension.Pixels ? ((Dimension.Pixels) height3).m7820unboximpl() : Integer.MAX_VALUE);
            double d = min / width;
            double d2 = min2 / height;
            int i = WhenMappings.$EnumSwitchMapping$0[((min == Integer.MAX_VALUE || min2 == Integer.MAX_VALUE) ? Scale.FIT : scale).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (d < d2) {
                    abs2 = Math.abs(min - width);
                } else {
                    abs = Math.abs(min2 - height);
                    abs2 = abs;
                    d = d2;
                }
            } else if (d > d2) {
                abs2 = Math.abs(min - width);
            } else {
                abs = Math.abs(min2 - height);
                abs2 = abs;
                d = d2;
            }
            if (abs2 <= 1) {
                return true;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$1[imageRequest.getPrecision().ordinal()];
            if (i2 == 1) {
                if (d == 1.0d) {
                    return true;
                }
                Logger logger2 = this.logger;
                if (logger2 != null) {
                    Logger.Level level2 = Logger.Level.Debug;
                    if (logger2.getMinLevel().compareTo(level2) <= 0) {
                        logger2.log(TAG, level2, imageRequest.getData() + ": Memory cached image's size (" + width + ", " + height + ") does not exactly match the target size (" + min + ", " + min2 + ").", null);
                    }
                }
                return false;
            } else if (i2 == 2) {
                if (d <= 1.0d) {
                    return true;
                }
                Logger logger3 = this.logger;
                if (logger3 != null) {
                    Logger.Level level3 = Logger.Level.Debug;
                    if (logger3.getMinLevel().compareTo(level3) <= 0) {
                        logger3.log(TAG, level3, imageRequest.getData() + ": Memory cached image's size (" + width + ", " + height + ") is smaller than the target size (" + min + ", " + min2 + ").", null);
                    }
                }
                return false;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            return true;
        }
    }

    public final boolean setCacheValue(MemoryCache.Key key, ImageRequest imageRequest, EngineInterceptor.ExecuteResult executeResult) {
        MemoryCache memoryCache;
        if (key == null || !imageRequest.getMemoryCachePolicy().getWriteEnabled() || !executeResult.getImage().getShareable() || (memoryCache = this.imageLoader.getMemoryCache()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EXTRA_IS_SAMPLED, Boolean.valueOf(executeResult.isSampled()));
        String diskCacheKey = executeResult.getDiskCacheKey();
        if (diskCacheKey != null) {
            linkedHashMap.put(EXTRA_DISK_CACHE_KEY, diskCacheKey);
        }
        memoryCache.set(key, new MemoryCache.Value(executeResult.getImage(), linkedHashMap));
        return true;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value) {
        return new SuccessResult(value.getImage(), imageRequest, DataSource.MEMORY_CACHE, key, getDiskCacheKey(value), isSampled(value), UtilsKt.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* compiled from: MemoryCacheService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil3/memory/MemoryCacheService$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_SIZE", "EXTRA_IS_SAMPLED", "EXTRA_DISK_CACHE_KEY", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

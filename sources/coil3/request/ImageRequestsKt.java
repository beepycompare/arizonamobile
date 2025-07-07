package coil3.request;

import coil3.Extras;
import coil3.ExtrasKt;
import coil3.ImageLoader;
import coil3.request.ImageRequest;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.transform.Transformation;
import coil3.util.Collections_jvmCommonKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: imageRequests.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u001a\u0012\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0012\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0012\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u001e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010#\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u000b*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u000b*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010\"!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000b0\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0013\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u0017\u001a\u00020\u0019*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u0017\u001a\u00020\u0019*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c\"\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013\"\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u001e\u001a\u00020\u0003*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010\u001e\u001a\u00020\u0003*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013\"\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010#\u001a\u00020\u0003*\u00020\f8F¢\u0006\u0006\u001a\u0004\b$\u0010 \"\u0015\u0010#\u001a\u00020\u0003*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b$\u0010!\"\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b$\u0010\u0013\"\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"crossfade", "Lcoil3/request/ImageRequest$Builder;", "enable", "", "Lcoil3/ImageLoader$Builder;", "DEFAULT_CROSSFADE_MILLIS", "", "transformations", "", "Lcoil3/transform/Transformation;", "(Lcoil3/request/ImageRequest$Builder;[Lcoil3/transform/Transformation;)Lcoil3/request/ImageRequest$Builder;", "", "Lcoil3/request/ImageRequest;", "getTransformations", "(Lcoil3/request/ImageRequest;)Ljava/util/List;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;)Ljava/util/List;", "Lcoil3/Extras$Key;", "Lcoil3/Extras$Key$Companion;", "(Lcoil3/Extras$Key$Companion;)Lcoil3/Extras$Key;", "EXTRA_TRANSFORMATIONS", "", "transformationsKey", "maxBitmapSize", "size", "Lcoil3/size/Size;", "getMaxBitmapSize", "(Lcoil3/request/ImageRequest;)Lcoil3/size/Size;", "(Lcoil3/request/Options;)Lcoil3/size/Size;", "maxBitmapSizeKey", "addLastModifiedToFileCacheKey", "getAddLastModifiedToFileCacheKey", "(Lcoil3/request/ImageRequest;)Z", "(Lcoil3/request/Options;)Z", "addLastModifiedToFileCacheKeyKey", "allowConversionToBitmap", "getAllowConversionToBitmap", "allowConversionToBitmapKey", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageRequestsKt {
    public static final int DEFAULT_CROSSFADE_MILLIS = 200;
    private static final String EXTRA_TRANSFORMATIONS = "coil#transformations";
    private static final Extras.Key<List<Transformation>> transformationsKey = new Extras.Key<>(CollectionsKt.emptyList());
    private static final Extras.Key<Size> maxBitmapSizeKey = new Extras.Key<>(SizeKt.Size(4096, 4096));
    private static final Extras.Key<Boolean> addLastModifiedToFileCacheKeyKey = new Extras.Key<>(false);
    private static final Extras.Key<Boolean> allowConversionToBitmapKey = new Extras.Key<>(true);

    public static final ImageRequest.Builder crossfade(ImageRequest.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    public static final ImageLoader.Builder crossfade(ImageLoader.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    public static final ImageRequest.Builder transformations(ImageRequest.Builder builder, Transformation... transformationArr) {
        return transformations(builder, ArraysKt.toList(transformationArr));
    }

    public static final ImageRequest.Builder transformations(ImageRequest.Builder builder, List<? extends Transformation> list) {
        builder.getExtras().set(transformationsKey, Collections_jvmCommonKt.toImmutableList(list));
        final Ref.IntRef intRef = new Ref.IntRef();
        builder.memoryCacheKeyExtra(EXTRA_TRANSFORMATIONS, CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1() { // from class: coil3.request.ImageRequestsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence transformations$lambda$1$lambda$0;
                transformations$lambda$1$lambda$0 = ImageRequestsKt.transformations$lambda$1$lambda$0(Ref.IntRef.this, (Transformation) obj);
                return transformations$lambda$1$lambda$0;
            }
        }, 31, null));
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence transformations$lambda$1$lambda$0(Ref.IntRef intRef, Transformation transformation) {
        StringBuilder sb = new StringBuilder();
        int i = intRef.element;
        intRef.element = i + 1;
        return sb.append(i).append(AbstractJsonLexerKt.COLON).append(transformation.getCacheKey()).toString();
    }

    public static final List<Transformation> getTransformations(ImageRequest imageRequest) {
        return (List) ExtrasKt.getExtra(imageRequest, transformationsKey);
    }

    public static final List<Transformation> getTransformations(Options options) {
        return (List) ExtrasKt.getExtra(options, transformationsKey);
    }

    public static final Extras.Key<List<Transformation>> getTransformations(Extras.Key.Companion companion) {
        return transformationsKey;
    }

    public static final ImageRequest.Builder maxBitmapSize(ImageRequest.Builder builder, Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    public static final ImageLoader.Builder maxBitmapSize(ImageLoader.Builder builder, Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    public static final Size getMaxBitmapSize(ImageRequest imageRequest) {
        return (Size) ExtrasKt.getExtra(imageRequest, maxBitmapSizeKey);
    }

    public static final Size getMaxBitmapSize(Options options) {
        return (Size) ExtrasKt.getExtra(options, maxBitmapSizeKey);
    }

    public static final Extras.Key<Size> getMaxBitmapSize(Extras.Key.Companion companion) {
        return maxBitmapSizeKey;
    }

    public static final ImageRequest.Builder addLastModifiedToFileCacheKey(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder addLastModifiedToFileCacheKey(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAddLastModifiedToFileCacheKey(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    public static final boolean getAddLastModifiedToFileCacheKey(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    public static final Extras.Key<Boolean> getAddLastModifiedToFileCacheKey(Extras.Key.Companion companion) {
        return addLastModifiedToFileCacheKeyKey;
    }

    public static final ImageRequest.Builder allowConversionToBitmap(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder allowConversionToBitmap(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowConversionToBitmap(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowConversionToBitmapKey)).booleanValue();
    }

    public static final boolean getAllowConversionToBitmap(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowConversionToBitmapKey)).booleanValue();
    }

    public static final Extras.Key<Boolean> getAllowConversionToBitmap(Extras.Key.Companion companion) {
        return allowConversionToBitmapKey;
    }
}

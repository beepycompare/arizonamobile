package coil3;

import coil3.ComponentRegistry;
import coil3.RealImageLoader;
import coil3.decode.Decoder;
import coil3.fetch.ByteArrayFetcher;
import coil3.fetch.DataUriFetcher;
import coil3.fetch.Fetcher;
import coil3.fetch.FileUriFetcher;
import coil3.key.FileUriKeyer;
import coil3.key.UriKeyer;
import coil3.map.PathMapper;
import coil3.map.StringMapper;
import coil3.util.DecoderServiceLoaderTarget;
import coil3.util.FetcherServiceLoaderTarget;
import coil3.util.Logger;
import coil3.util.ServiceLoaderComponentRegistry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.Path;
/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0005*\u00020\u0005H\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"CoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logger", "Lcoil3/util/Logger;", "addServiceLoaderComponents", "Lcoil3/ComponentRegistry$Builder;", "options", "Lcoil3/RealImageLoader$Options;", "addCommonComponents", "TAG", "", "REQUEST_TYPE_ENQUEUE", "", "REQUEST_TYPE_EXECUTE", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RealImageLoaderKt {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";

    public static final CoroutineScope CoroutineScope(Logger logger) {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, logger)));
    }

    public static final ComponentRegistry.Builder addServiceLoaderComponents(ComponentRegistry.Builder builder, RealImageLoader.Options options) {
        if (ImageLoadersKt.getServiceLoaderEnabled(options)) {
            builder.addFetcherFactories(new Function0() { // from class: coil3.RealImageLoaderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List addServiceLoaderComponents$lambda$3;
                    addServiceLoaderComponents$lambda$3 = RealImageLoaderKt.addServiceLoaderComponents$lambda$3();
                    return addServiceLoaderComponents$lambda$3;
                }
            });
            builder.addDecoderFactories(new Function0() { // from class: coil3.RealImageLoaderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List addServiceLoaderComponents$lambda$6;
                    addServiceLoaderComponents$lambda$6 = RealImageLoaderKt.addServiceLoaderComponents$lambda$6();
                    return addServiceLoaderComponents$lambda$6;
                }
            });
        }
        return builder;
    }

    public static final List addServiceLoaderComponents$lambda$3() {
        KClass type;
        List sortedWith = CollectionsKt.sortedWith(ServiceLoaderComponentRegistry.INSTANCE.getFetchers(), new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$3$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((FetcherServiceLoaderTarget) t2).priority()), Integer.valueOf(((FetcherServiceLoaderTarget) t).priority()));
            }
        });
        ArrayList arrayList = new ArrayList();
        int size = sortedWith.size();
        for (int i = 0; i < size; i++) {
            FetcherServiceLoaderTarget fetcherServiceLoaderTarget = (FetcherServiceLoaderTarget) sortedWith.get(i);
            Intrinsics.checkNotNull(fetcherServiceLoaderTarget, "null cannot be cast to non-null type coil3.util.FetcherServiceLoaderTarget<kotlin.Any>");
            Fetcher.Factory factory = fetcherServiceLoaderTarget.factory();
            Pair pair = null;
            if (factory != null && (type = fetcherServiceLoaderTarget.type()) != null) {
                pair = TuplesKt.to(factory, type);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    public static final List addServiceLoaderComponents$lambda$6() {
        List sortedWith = CollectionsKt.sortedWith(ServiceLoaderComponentRegistry.INSTANCE.getDecoders(), new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$6$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DecoderServiceLoaderTarget) t2).priority()), Integer.valueOf(((DecoderServiceLoaderTarget) t).priority()));
            }
        });
        ArrayList arrayList = new ArrayList();
        int size = sortedWith.size();
        for (int i = 0; i < size; i++) {
            Decoder.Factory factory = ((DecoderServiceLoaderTarget) sortedWith.get(i)).factory();
            if (factory != null) {
                arrayList.add(factory);
            }
        }
        return arrayList;
    }

    public static final ComponentRegistry.Builder addCommonComponents(ComponentRegistry.Builder builder) {
        return builder.add(new StringMapper(), Reflection.getOrCreateKotlinClass(String.class)).add(new PathMapper(), Reflection.getOrCreateKotlinClass(Path.class)).add(new FileUriKeyer(), Reflection.getOrCreateKotlinClass(Uri.class)).add(new UriKeyer(), Reflection.getOrCreateKotlinClass(Uri.class)).add(new FileUriFetcher.Factory(), Reflection.getOrCreateKotlinClass(Uri.class)).add(new ByteArrayFetcher.Factory(), Reflection.getOrCreateKotlinClass(byte[].class)).add(new DataUriFetcher.Factory(), Reflection.getOrCreateKotlinClass(Uri.class));
    }
}

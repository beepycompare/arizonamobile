package coil3.request;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.Image;
import coil3.ImageLoader;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.size.ViewSizeResolver;
import coil3.size.ViewSizeResolverKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import coil3.util.BitmapsKt;
import coil3.util.ContextsKt;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
/* compiled from: RequestService.android.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0014*\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u000fH\u0002J\f\u0010\u001c\u001a\u00020\u001d*\u00020\u000fH\u0002J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010 \u001a\u00020\u001bH\u0002J\u0014\u0010!\u001a\u00020\"*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcoil3/request/AndroidRequestService;", "Lcoil3/request/RequestService;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/util/Logger;)V", "hardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "updateRequest", "options", "Lcoil3/request/Options;", "size", "Lcoil3/size/Size;", "resolveSizeResolver", "Lcoil3/size/SizeResolver;", "resolveScale", "Lcoil3/size/Scale;", "resolvePrecision", "Lcoil3/size/Precision;", "sizeResolver", "resolveExtras", "Lcoil3/Extras;", "updateOptions", "isCacheValueValidForHardware", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isBitmapConfigValidMainThread", "isBitmapConfigValidWorkerThread", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidRequestService implements RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final SystemCallbacks systemCallbacks;

    public AndroidRequestService(ImageLoader imageLoader, SystemCallbacks systemCallbacks, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.logger = logger;
        this.hardwareBitmapService = HardwareBitmapsKt.HardwareBitmapService(logger);
    }

    @Override // coil3.request.RequestService
    public RequestDelegate requestDelegate(ImageRequest imageRequest, Job job, boolean z) {
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            Lifecycle lifecycle = ImageRequests_androidKt.getLifecycle(imageRequest);
            if (lifecycle == null) {
                lifecycle = findLifecycle(imageRequest);
            }
            return new ViewTargetRequestDelegate(this.imageLoader, imageRequest, (ViewTarget) target, lifecycle, job);
        }
        Lifecycle lifecycle2 = ImageRequests_androidKt.getLifecycle(imageRequest);
        if (lifecycle2 == null) {
            lifecycle2 = z ? findLifecycle(imageRequest) : null;
        }
        if (lifecycle2 != null) {
            return new LifecycleRequestDelegate(lifecycle2, job);
        }
        return BaseRequestDelegate.m7804boximpl(BaseRequestDelegate.m7805constructorimpl(job));
    }

    private final Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        return ContextsKt.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : imageRequest.getContext());
    }

    @Override // coil3.request.RequestService
    public ImageRequest updateRequest(ImageRequest imageRequest) {
        ImageRequest.Builder defaults = ImageRequest.newBuilder$default(imageRequest, null, 1, null).defaults(this.imageLoader.getDefaults());
        SizeResolver sizeResolver = imageRequest.getDefined().getSizeResolver();
        if (sizeResolver == null) {
            sizeResolver = resolveSizeResolver(imageRequest);
            defaults.size(sizeResolver);
        }
        if (imageRequest.getDefined().getScale() == null) {
            defaults.scale(resolveScale(imageRequest));
        }
        if (imageRequest.getDefined().getPrecision() == null) {
            defaults.precision(resolvePrecision(imageRequest, sizeResolver));
        }
        return defaults.build();
    }

    @Override // coil3.request.RequestService
    public Options options(ImageRequest imageRequest, Size size) {
        return new Options(imageRequest.getContext(), size, imageRequest.getScale(), imageRequest.getPrecision(), imageRequest.getDiskCacheKey(), imageRequest.getFileSystem(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), imageRequest.getNetworkCachePolicy(), resolveExtras(imageRequest, size));
    }

    private final SizeResolver resolveSizeResolver(ImageRequest imageRequest) {
        ImageView.ScaleType scaleType;
        if (imageRequest.getTarget() instanceof ViewTarget) {
            View view = ((ViewTarget) imageRequest.getTarget()).getView();
            if ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                return SizeResolver.ORIGINAL;
            }
            return ViewSizeResolverKt.ViewSizeResolver$default(view, false, 2, null);
        }
        return SizeResolver.ORIGINAL;
    }

    private final Scale resolveScale(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        ViewTarget viewTarget = target instanceof ViewTarget ? (ViewTarget) target : null;
        KeyEvent.Callback view = viewTarget != null ? viewTarget.getView() : null;
        ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView != null) {
            return Utils_androidKt.getScale(imageView);
        }
        return imageRequest.getScale();
    }

    private final Precision resolvePrecision(ImageRequest imageRequest, SizeResolver sizeResolver) {
        if (imageRequest.getDefined().getSizeResolver() == null && Intrinsics.areEqual(sizeResolver, SizeResolver.ORIGINAL)) {
            return Precision.INEXACT;
        }
        if ((imageRequest.getTarget() instanceof ViewTarget) && (sizeResolver instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && ((ViewTarget) imageRequest.getTarget()).getView() == ((ViewSizeResolver) sizeResolver).getView()) {
            return Precision.INEXACT;
        }
        return Precision.EXACT;
    }

    private final Extras resolveExtras(ImageRequest imageRequest, Size size) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(imageRequest);
        boolean allowRgb565 = ImageRequests_androidKt.getAllowRgb565(imageRequest);
        if (!isBitmapConfigValidMainThread(imageRequest, size)) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        boolean z = allowRgb565 && ImageRequestsKt.getTransformations(imageRequest).isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        Extras.Builder builder = new Extras.Builder(MapsKt.plus(imageRequest.getDefaults().getExtras().asMap(), imageRequest.getExtras().asMap()));
        if (bitmapConfig != ImageRequests_androidKt.getBitmapConfig(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), bitmapConfig);
        }
        if (z != ImageRequests_androidKt.getAllowRgb565(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getAllowRgb565(Extras.Key.Companion), Boolean.valueOf(z));
        }
        return builder.build();
    }

    @Override // coil3.request.RequestService
    public Options updateOptions(Options options) {
        boolean z;
        Extras extras = options.getExtras();
        if (isBitmapConfigValidWorkerThread(options)) {
            z = false;
        } else {
            extras = extras.newBuilder().set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), Bitmap.Config.ARGB_8888).build();
            z = true;
        }
        return z ? Options.copy$default(options, null, null, null, null, null, null, null, null, null, extras, 511, null) : options;
    }

    @Override // coil3.request.RequestService
    public boolean isCacheValueValidForHardware(ImageRequest imageRequest, MemoryCache.Value value) {
        Image image = value.getImage();
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null) {
            return true;
        }
        return isConfigValidForHardware(imageRequest, BitmapsKt.getSafeConfig(bitmapImage.getBitmap()));
    }

    private final boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        if (BitmapsKt.isHardware(config)) {
            if (ImageRequests_androidKt.getAllowHardware(imageRequest)) {
                Target target = imageRequest.getTarget();
                if (target instanceof ViewTarget) {
                    View view = ((ViewTarget) target).getView();
                    if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private final boolean isBitmapConfigValidMainThread(ImageRequest imageRequest, Size size) {
        return (ImageRequestsKt.getTransformations(imageRequest).isEmpty() || ArraysKt.contains(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), ImageRequests_androidKt.getBitmapConfig(imageRequest))) && (!BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(imageRequest)) || (isConfigValidForHardware(imageRequest, ImageRequests_androidKt.getBitmapConfig(imageRequest)) && this.hardwareBitmapService.allowHardwareMainThread(size)));
    }

    private final boolean isBitmapConfigValidWorkerThread(Options options) {
        return !BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(options)) || this.hardwareBitmapService.allowHardwareWorkerThread();
    }
}

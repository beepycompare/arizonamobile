package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Size;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Scale;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
/* compiled from: StaticImageDecoder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil3/decode/StaticImageDecoder;", "Lcoil3/decode/Decoder;", "source", "Landroid/graphics/ImageDecoder$Source;", "closeable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "options", "Lcoil3/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Landroid/graphics/ImageDecoder$Source;Ljava/lang/AutoCloseable;Lcoil3/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureImageDecoderProperties", "", "Landroid/graphics/ImageDecoder;", "Factory", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StaticImageDecoder implements Decoder {
    private final AutoCloseable closeable;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageDecoder.Source source;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureImageDecoderProperties$lambda$3(ImageDecoder.DecodeException decodeException) {
        return true;
    }

    public StaticImageDecoder(ImageDecoder.Source source, AutoCloseable autoCloseable, Options options, Semaphore semaphore) {
        this.source = source;
        this.closeable = autoCloseable;
        this.options = options;
        this.parallelismLock = semaphore;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // coil3.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) {
        StaticImageDecoder$decode$1 staticImageDecoder$decode$1;
        int i;
        Semaphore semaphore;
        try {
            if (continuation instanceof StaticImageDecoder$decode$1) {
                staticImageDecoder$decode$1 = (StaticImageDecoder$decode$1) continuation;
                if ((staticImageDecoder$decode$1.label & Integer.MIN_VALUE) != 0) {
                    staticImageDecoder$decode$1.label -= Integer.MIN_VALUE;
                    Object obj = staticImageDecoder$decode$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = staticImageDecoder$decode$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Semaphore semaphore2 = this.parallelismLock;
                        staticImageDecoder$decode$1.L$0 = semaphore2;
                        staticImageDecoder$decode$1.label = 1;
                        if (semaphore2.acquire(staticImageDecoder$decode$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        semaphore = semaphore2;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        semaphore = (Semaphore) staticImageDecoder$decode$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    AutoCloseable autoCloseable = this.closeable;
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    DecodeResult decodeResult = new DecodeResult(Image_androidKt.asImage$default(ImageDecoder.decodeBitmap(this.source, new ImageDecoder.OnHeaderDecodedListener() { // from class: coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1
                        /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
                            if (r2.getPrecision() == coil3.size.Precision.EXACT) goto L13;
                         */
                        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                            Options options;
                            Options options2;
                            Options options3;
                            Options options4;
                            Options options5;
                            Size size = imageInfo.getSize();
                            int width = size.getWidth();
                            int height = size.getHeight();
                            options = StaticImageDecoder.this.options;
                            coil3.size.Size size2 = options.getSize();
                            options2 = StaticImageDecoder.this.options;
                            Scale scale = options2.getScale();
                            options3 = StaticImageDecoder.this.options;
                            long m7772computeDstSizesEdh43o = DecodeUtils.m7772computeDstSizesEdh43o(width, height, size2, scale, ImageRequestsKt.getMaxBitmapSize(options3));
                            int m7830getFirstimpl = IntPair.m7830getFirstimpl(m7772computeDstSizesEdh43o);
                            int m7831getSecondimpl = IntPair.m7831getSecondimpl(m7772computeDstSizesEdh43o);
                            if (width > 0 && height > 0 && (width != m7830getFirstimpl || height != m7831getSecondimpl)) {
                                options4 = StaticImageDecoder.this.options;
                                double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, m7830getFirstimpl, m7831getSecondimpl, options4.getScale());
                                booleanRef.element = computeSizeMultiplier < 1.0d;
                                if (!booleanRef.element) {
                                    options5 = StaticImageDecoder.this.options;
                                }
                                imageDecoder.setTargetSize(MathKt.roundToInt(width * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * height));
                            }
                            StaticImageDecoder.this.configureImageDecoderProperties(imageDecoder);
                        }
                    }), false, 1, null), booleanRef.element);
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return decodeResult;
                }
            }
            AutoCloseable autoCloseable2 = this.closeable;
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            DecodeResult decodeResult2 = new DecodeResult(Image_androidKt.asImage$default(ImageDecoder.decodeBitmap(this.source, new ImageDecoder.OnHeaderDecodedListener() { // from class: coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1
                /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
                    if (r2.getPrecision() == coil3.size.Precision.EXACT) goto L13;
                 */
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    Options options;
                    Options options2;
                    Options options3;
                    Options options4;
                    Options options5;
                    Size size = imageInfo.getSize();
                    int width = size.getWidth();
                    int height = size.getHeight();
                    options = StaticImageDecoder.this.options;
                    coil3.size.Size size2 = options.getSize();
                    options2 = StaticImageDecoder.this.options;
                    Scale scale = options2.getScale();
                    options3 = StaticImageDecoder.this.options;
                    long m7772computeDstSizesEdh43o = DecodeUtils.m7772computeDstSizesEdh43o(width, height, size2, scale, ImageRequestsKt.getMaxBitmapSize(options3));
                    int m7830getFirstimpl = IntPair.m7830getFirstimpl(m7772computeDstSizesEdh43o);
                    int m7831getSecondimpl = IntPair.m7831getSecondimpl(m7772computeDstSizesEdh43o);
                    if (width > 0 && height > 0 && (width != m7830getFirstimpl || height != m7831getSecondimpl)) {
                        options4 = StaticImageDecoder.this.options;
                        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, m7830getFirstimpl, m7831getSecondimpl, options4.getScale());
                        booleanRef2.element = computeSizeMultiplier < 1.0d;
                        if (!booleanRef2.element) {
                            options5 = StaticImageDecoder.this.options;
                        }
                        imageDecoder.setTargetSize(MathKt.roundToInt(width * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * height));
                    }
                    StaticImageDecoder.this.configureImageDecoderProperties(imageDecoder);
                }
            }), false, 1, null), booleanRef2.element);
            AutoCloseableKt.closeFinally(autoCloseable2, null);
            return decodeResult2;
        } finally {
            semaphore.release();
        }
        staticImageDecoder$decode$1 = new StaticImageDecoder$decode$1(this, continuation);
        Object obj2 = staticImageDecoder$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = staticImageDecoder$decode$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: coil3.decode.StaticImageDecoder$$ExternalSyntheticLambda0
            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                boolean configureImageDecoderProperties$lambda$3;
                configureImageDecoderProperties$lambda$3 = StaticImageDecoder.configureImageDecoderProperties$lambda$3(decodeException);
                return configureImageDecoderProperties$lambda$3;
            }
        });
        imageDecoder.setAllocator(BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(this.options)) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(!ImageRequests_androidKt.getAllowRgb565(this.options) ? 1 : 0);
        if (ImageRequests_androidKt.getColorSpace(this.options) != null) {
            imageDecoder.setTargetColorSpace(ImageRequests_androidKt.getColorSpace(this.options));
        }
        imageDecoder.setUnpremultipliedRequired(!ImageRequests_androidKt.getPremultipliedAlpha(this.options));
    }

    /* compiled from: StaticImageDecoder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil3/decode/StaticImageDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Lkotlinx/coroutines/sync/Semaphore;)V", "create", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Decoder.Factory {
        private final Semaphore parallelismLock;

        public Factory() {
            this(null, 1, null);
        }

        public Factory(Semaphore semaphore) {
            this.parallelismLock = semaphore;
        }

        public /* synthetic */ Factory(Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SemaphoreKt.Semaphore$default(4, 0, 2, null) : semaphore);
        }

        @Override // coil3.decode.Decoder.Factory
        public Decoder create(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
            ImageDecoder.Source imageDecoderSourceOrNull;
            if (isApplicable(options) && (imageDecoderSourceOrNull = StaticImageDecoderKt.toImageDecoderSourceOrNull(sourceFetchResult.getSource(), options, false)) != null) {
                return new StaticImageDecoder(imageDecoderSourceOrNull, sourceFetchResult.getSource(), options, this.parallelismLock);
            }
            return null;
        }

        private final boolean isApplicable(Options options) {
            Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(options);
            return bitmapConfig == Bitmap.Config.ARGB_8888 || bitmapConfig == Bitmap.Config.HARDWARE;
        }
    }
}

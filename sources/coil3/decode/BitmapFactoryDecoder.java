package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* compiled from: BitmapFactoryDecoder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\f\u0010\f\u001a\u00020\r*\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder;", "Lcoil3/decode/Decoder;", "source", "Lcoil3/decode/ImageSource;", "options", "Lcoil3/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "exifOrientationStrategy", "Lcoil3/decode/ExifOrientationStrategy;", "<init>", "(Lcoil3/decode/ImageSource;Lcoil3/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil3/decode/ExifOrientationStrategy;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/BitmapFactory$Options;", "configureConfig", "", "exifData", "Lcoil3/decode/ExifData;", "configureScale", "Factory", "ExceptionCatchingSource", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BitmapFactoryDecoder implements Decoder {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationStrategy exifOrientationStrategy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationStrategy = exifOrientationStrategy;
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore, (i & 8) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r7.acquire(r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    @Override // coil3.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) {
        BitmapFactoryDecoder$decode$1 bitmapFactoryDecoder$decode$1;
        Object coroutine_suspended;
        int i;
        Semaphore semaphore;
        Semaphore semaphore2;
        Throwable th;
        Object runInterruptible$default;
        try {
            if (continuation instanceof BitmapFactoryDecoder$decode$1) {
                bitmapFactoryDecoder$decode$1 = (BitmapFactoryDecoder$decode$1) continuation;
                if ((bitmapFactoryDecoder$decode$1.label & Integer.MIN_VALUE) != 0) {
                    bitmapFactoryDecoder$decode$1.label -= Integer.MIN_VALUE;
                    Object obj = bitmapFactoryDecoder$decode$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bitmapFactoryDecoder$decode$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        semaphore = this.parallelismLock;
                        bitmapFactoryDecoder$decode$1.L$0 = semaphore;
                        bitmapFactoryDecoder$decode$1.label = 1;
                    } else if (i != 1) {
                        if (i == 2) {
                            semaphore2 = (Semaphore) bitmapFactoryDecoder$decode$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                DecodeResult decodeResult = (DecodeResult) obj;
                                semaphore2.release();
                                return decodeResult;
                            } catch (Throwable th2) {
                                th = th2;
                                semaphore2.release();
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        semaphore = (Semaphore) bitmapFactoryDecoder$decode$1.L$0;
                    }
                    Function0 function0 = new Function0() { // from class: coil3.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            DecodeResult decode$lambda$1$lambda$0;
                            decode$lambda$1$lambda$0 = BitmapFactoryDecoder.decode$lambda$1$lambda$0(BitmapFactoryDecoder.this);
                            return decode$lambda$1$lambda$0;
                        }
                    };
                    bitmapFactoryDecoder$decode$1.L$0 = semaphore;
                    bitmapFactoryDecoder$decode$1.label = 2;
                    runInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, bitmapFactoryDecoder$decode$1, 1, null);
                    if (runInterruptible$default != coroutine_suspended) {
                        semaphore2 = semaphore;
                        obj = runInterruptible$default;
                        DecodeResult decodeResult2 = (DecodeResult) obj;
                        semaphore2.release();
                        return decodeResult2;
                    }
                    return coroutine_suspended;
                }
            }
            Function0 function02 = new Function0() { // from class: coil3.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    DecodeResult decode$lambda$1$lambda$0;
                    decode$lambda$1$lambda$0 = BitmapFactoryDecoder.decode$lambda$1$lambda$0(BitmapFactoryDecoder.this);
                    return decode$lambda$1$lambda$0;
                }
            };
            bitmapFactoryDecoder$decode$1.L$0 = semaphore;
            bitmapFactoryDecoder$decode$1.label = 2;
            runInterruptible$default = InterruptibleKt.runInterruptible$default(null, function02, bitmapFactoryDecoder$decode$1, 1, null);
            if (runInterruptible$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            semaphore2 = semaphore;
            th = th3;
            semaphore2.release();
            throw th;
        }
        bitmapFactoryDecoder$decode$1 = new BitmapFactoryDecoder$decode$1(this, continuation);
        Object obj2 = bitmapFactoryDecoder$decode$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bitmapFactoryDecoder$decode$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecodeResult decode$lambda$1$lambda$0(BitmapFactoryDecoder bitmapFactoryDecoder) {
        return bitmapFactoryDecoder.decode(new BitmapFactory.Options());
    }

    private final DecodeResult decode(BitmapFactory.Options options) {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource buffer = Okio.buffer(exceptionCatchingSource);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(buffer.peek().inputStream(), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception != null) {
            throw exception;
        }
        options.inJustDecodeBounds = false;
        ExifData exifData = ExifUtils.INSTANCE.getExifData(options.outMimeType, buffer, this.exifOrientationStrategy);
        Exception exception2 = exceptionCatchingSource.getException();
        if (exception2 != null) {
            throw exception2;
        }
        options.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && ImageRequests_androidKt.getColorSpace(this.options) != null) {
            options.inPreferredColorSpace = ImageRequests_androidKt.getColorSpace(this.options);
        }
        options.inPremultiplied = ImageRequests_androidKt.getPremultipliedAlpha(this.options);
        configureConfig(options, exifData);
        configureScale(options, exifData);
        BufferedSource bufferedSource = buffer;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedSource.inputStream(), null, options);
            CloseableKt.closeFinally(bufferedSource, null);
            Exception exception3 = exceptionCatchingSource.getException();
            if (exception3 == null) {
                if (decodeStream == null) {
                    throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the image source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
                }
                decodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
                Image asImage = Image_androidKt.asImage(new BitmapDrawable(this.options.getContext().getResources(), ExifUtils.INSTANCE.reverseTransformations(decodeStream, exifData)));
                if (options.inSampleSize <= 1 && !options.inScaled) {
                    z = false;
                }
                return new DecodeResult(asImage, z);
            }
            throw exception3;
        } finally {
        }
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(this.options);
        if (exifData.isFlipped() || ExifUtilsKt.isRotated(exifData)) {
            bitmapConfig = BitmapsKt.toSoftware(bitmapConfig);
        }
        if (ImageRequests_androidKt.getAllowRgb565(this.options) && bitmapConfig == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
            bitmapConfig = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && bitmapConfig != Bitmap.Config.HARDWARE) {
            bitmapConfig = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = bitmapConfig;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        long m7772computeDstSizesEdh43o = DecodeUtils.m7772computeDstSizesEdh43o(i, i2, this.options.getSize(), this.options.getScale(), ImageRequestsKt.getMaxBitmapSize(this.options));
        int m7830getFirstimpl = IntPair.m7830getFirstimpl(m7772computeDstSizesEdh43o);
        int m7831getSecondimpl = IntPair.m7831getSecondimpl(m7772computeDstSizesEdh43o);
        options.inSampleSize = DecodeUtils.calculateInSampleSize(i, i2, m7830getFirstimpl, m7831getSecondimpl, this.options.getScale());
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i / options.inSampleSize, i2 / options.inSampleSize, m7830getFirstimpl, m7831getSecondimpl, this.options.getScale());
        if (this.options.getPrecision() == Precision.INEXACT) {
            computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
        }
        options.inScaled = !(computeSizeMultiplier == 1.0d);
        if (options.inScaled) {
            if (computeSizeMultiplier > 1.0d) {
                options.inDensity = MathKt.roundToInt(Integer.MAX_VALUE / computeSizeMultiplier);
                options.inTargetDensity = Integer.MAX_VALUE;
                return;
            }
            options.inDensity = Integer.MAX_VALUE;
            options.inTargetDensity = MathKt.roundToInt(Integer.MAX_VALUE * computeSizeMultiplier);
        }
    }

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "exifOrientationStrategy", "Lcoil3/decode/ExifOrientationStrategy;", "<init>", "(Lkotlinx/coroutines/sync/Semaphore;Lcoil3/decode/ExifOrientationStrategy;)V", "create", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationStrategy exifOrientationStrategy;
        private final Semaphore parallelismLock;

        public Factory() {
            this(null, null, 3, null);
        }

        public Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy) {
            this.parallelismLock = semaphore;
            this.exifOrientationStrategy = exifOrientationStrategy;
        }

        public /* synthetic */ Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SemaphoreKt.Semaphore$default(4, 0, 2, null) : semaphore, (i & 2) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy);
        }

        @Override // coil3.decode.Decoder.Factory
        public Decoder create(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(sourceFetchResult.getSource(), options, this.parallelismLock, this.exifOrientationStrategy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016R.\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "value", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) {
            try {
                return super.read(buffer, j);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Companion;", "", "<init>", "()V", "DEFAULT_MAX_PARALLELISM", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

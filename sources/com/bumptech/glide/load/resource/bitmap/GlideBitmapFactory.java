package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
final class GlideBitmapFactory {
    private static final String TAG = "GlideBitmapFactory";

    private GlideBitmapFactory() {
    }

    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options);
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap decodeByteArray(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(bArr, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            boolean hasJpegMpf = imageReader.hasJpegMpf();
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "isLikelyToContainGainmap=" + hasJpegMpf);
            }
            return hasJpegMpf;
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "isLikelyToContainGainmap failed", e);
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        r3.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        r4.inPreferredConfig = android.graphics.Bitmap.Config.HARDWARE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r3 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r3 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(InputStream inputStream, BitmapFactory.Options options) {
        Throwable th;
        Bitmap bitmap;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = null;
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmap != null) {
                try {
                    bitmap2 = safeDecodeBitmapWithGainmap(bitmap);
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r4.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        r5.inPreferredConfig = android.graphics.Bitmap.Config.HARDWARE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r4 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r4 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[] bArr, BitmapFactory.Options options) {
        Throwable th;
        Bitmap bitmap;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = null;
        try {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null) {
                try {
                    bitmap2 = safeDecodeBitmapWithGainmap(bitmap);
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        r3.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        r4.inPreferredConfig = android.graphics.Bitmap.Config.HARDWARE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r3 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r3 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(FileDescriptor fileDescriptor, BitmapFactory.Options options) {
        Throwable th;
        Bitmap bitmap;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = null;
        try {
            bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmap != null) {
                try {
                    bitmap2 = safeDecodeBitmapWithGainmap(bitmap);
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
    }

    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        private GainmapCopier() {
        }

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmap2 = new Gainmap(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmap2.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmap2.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmap2.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmap2.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmap2.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmap2.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmap2.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmap2;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return createBitmap;
        }
    }

    /* loaded from: classes4.dex */
    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier<Boolean> REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier() { // from class: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory$GainmapDecoderWorkaroundStateCalculator$$ExternalSyntheticLambda0
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public final Object get() {
                Boolean valueOf;
                valueOf = Boolean.valueOf(GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.calculateNeedsGainmapDecodeWorkaround());
                return valueOf;
            }
        });
        private static final String TAG = "GainmapWorkaroundCalc";

        private GainmapDecoderWorkaroundStateCalculator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return REQUIRES_GAIN_MAP_FIX.get().booleanValue();
            }
            return false;
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap copy = createBitmap.copy(Bitmap.Config.HARDWARE, false);
            createBitmap.recycle();
            boolean z = copy == null;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (copy != null) {
                copy.recycle();
            }
            return z;
        }
    }
}

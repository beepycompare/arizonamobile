package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* loaded from: classes2.dex */
public final class ExternallyLoadedImageDecoder implements ImageDecoder {
    private final BitmapResolver bitmapResolver;
    private final DecoderInputBuffer inputBuffer;
    private final ImageOutputBuffer outputBuffer;
    private ListenableFuture<Bitmap> pendingDecode;
    private long pendingDecodeTimeUs;
    private boolean pendingEndOfStream;

    /* loaded from: classes2.dex */
    public interface BitmapResolver {
        ListenableFuture<Bitmap> resolve(ExternalImageRequest externalImageRequest);
    }

    @Override // androidx.media3.decoder.Decoder
    public void setOutputStartTimeUs(long j) {
    }

    /* loaded from: classes2.dex */
    public static final class ExternalImageRequest {
        public final Uri uri;

        public ExternalImageRequest(Uri uri) {
            this.uri = uri;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Factory implements ImageDecoder.Factory {
        private final BitmapResolver bitmapResolver;

        public Factory(BitmapResolver bitmapResolver) {
            this.bitmapResolver = bitmapResolver;
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public int supportsFormat(Format format) {
            int i;
            if (Objects.equals(format.sampleMimeType, MimeTypes.APPLICATION_EXTERNALLY_LOADED_IMAGE)) {
                i = 4;
            } else {
                i = MimeTypes.isImage(format.sampleMimeType) ? 1 : 0;
            }
            return RendererCapabilities.create(i);
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public ExternallyLoadedImageDecoder createImageDecoder() {
            return new ExternallyLoadedImageDecoder(this.bitmapResolver);
        }
    }

    private ExternallyLoadedImageDecoder(BitmapResolver bitmapResolver) {
        this.bitmapResolver = bitmapResolver;
        this.inputBuffer = new DecoderInputBuffer(1);
        this.outputBuffer = new ImageOutputBuffer() { // from class: androidx.media3.exoplayer.image.ExternallyLoadedImageDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public void release() {
                clear();
            }
        };
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "externallyLoadedImageDecoder";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.decoder.Decoder
    public DecoderInputBuffer dequeueInputBuffer() {
        if (this.pendingDecode == null) {
            return this.inputBuffer;
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.exoplayer.image.ImageDecoder, androidx.media3.decoder.Decoder
    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.isEndOfStream()) {
            this.pendingEndOfStream = true;
            decoderInputBuffer.clear();
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        Assertions.checkState(byteBuffer.hasArray());
        this.pendingDecode = this.bitmapResolver.resolve(new ExternalImageRequest(Uri.parse(new String(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining(), StandardCharsets.UTF_8))));
        this.pendingDecodeTimeUs = decoderInputBuffer.timeUs;
        decoderInputBuffer.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.exoplayer.image.ImageDecoder, androidx.media3.decoder.Decoder
    public ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException {
        if (this.pendingEndOfStream) {
            this.outputBuffer.addFlag(4);
            this.pendingEndOfStream = false;
            return this.outputBuffer;
        }
        ListenableFuture<Bitmap> listenableFuture = this.pendingDecode;
        if (listenableFuture != null) {
            try {
                if (listenableFuture.isDone()) {
                    try {
                        try {
                            this.outputBuffer.bitmap = (Bitmap) Futures.getDone(this.pendingDecode);
                            this.outputBuffer.timeUs = this.pendingDecodeTimeUs;
                            return this.outputBuffer;
                        } catch (ExecutionException e) {
                            throw new ImageDecoderException(e.getCause());
                        }
                    } catch (CancellationException e2) {
                        throw new ImageDecoderException(e2);
                    }
                }
            } finally {
                this.pendingDecode = null;
            }
        }
        return null;
    }

    @Override // androidx.media3.decoder.Decoder
    public void flush() {
        resetState();
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
        resetState();
    }

    private void resetState() {
        ListenableFuture<Bitmap> listenableFuture = this.pendingDecode;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.pendingDecode = null;
        }
        this.pendingEndOfStream = false;
        this.outputBuffer.release();
    }
}

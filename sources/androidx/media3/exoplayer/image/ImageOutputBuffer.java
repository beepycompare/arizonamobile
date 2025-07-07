package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.decoder.DecoderOutputBuffer;
/* loaded from: classes2.dex */
public abstract class ImageOutputBuffer extends DecoderOutputBuffer {
    public Bitmap bitmap;

    @Override // androidx.media3.decoder.DecoderOutputBuffer, androidx.media3.decoder.Buffer
    public void clear() {
        this.bitmap = null;
        super.clear();
    }
}

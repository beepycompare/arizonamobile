package androidx.media3.extractor.metadata.flac;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class PictureFrame implements Metadata.Entry {
    public final int colors;
    public final int depth;
    public final String description;
    public final int height;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;
    public final int width;

    public PictureFrame(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.pictureType = i;
        this.mimeType = str;
        this.description = str2;
        this.width = i2;
        this.height = i3;
        this.depth = i4;
        this.colors = i5;
        this.pictureData = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        builder.maybeSetArtworkData(this.pictureData, this.pictureType);
    }

    public String toString() {
        return "Picture: mimeType=" + this.mimeType + ", description=" + this.description;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PictureFrame pictureFrame = (PictureFrame) obj;
            if (this.pictureType == pictureFrame.pictureType && this.mimeType.equals(pictureFrame.mimeType) && this.description.equals(pictureFrame.description) && this.width == pictureFrame.width && this.height == pictureFrame.height && this.depth == pictureFrame.depth && this.colors == pictureFrame.colors && Arrays.equals(this.pictureData, pictureFrame.pictureData)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.pictureType) * 31) + this.mimeType.hashCode()) * 31) + this.description.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.depth) * 31) + this.colors) * 31) + Arrays.hashCode(this.pictureData);
    }

    public static PictureFrame fromPictureBlock(ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        String normalizeMimeType = MimeTypes.normalizeMimeType(parsableByteArray.readString(parsableByteArray.readInt(), StandardCharsets.US_ASCII));
        String readString = parsableByteArray.readString(parsableByteArray.readInt());
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        int readInt6 = parsableByteArray.readInt();
        byte[] bArr = new byte[readInt6];
        parsableByteArray.readBytes(bArr, 0, readInt6);
        return new PictureFrame(readInt, normalizeMimeType, readString, readInt2, readInt3, readInt4, readInt5, bArr);
    }
}

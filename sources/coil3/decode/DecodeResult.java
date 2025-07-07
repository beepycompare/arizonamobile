package coil3.decode;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecodeResult.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0011"}, d2 = {"Lcoil3/decode/DecodeResult;", "", "image", "Lcoil3/Image;", "isSampled", "", "<init>", "(Lcoil3/Image;Z)V", "getImage", "()Lcoil3/Image;", "()Z", "equals", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DecodeResult {
    private final Image image;
    private final boolean isSampled;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecodeResult) {
            DecodeResult decodeResult = (DecodeResult) obj;
            return Intrinsics.areEqual(this.image, decodeResult.image) && this.isSampled == decodeResult.isSampled;
        }
        return false;
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled);
    }

    public String toString() {
        return "DecodeResult(image=" + this.image + ", isSampled=" + this.isSampled + ')';
    }

    public DecodeResult(Image image, boolean z) {
        this.image = image;
        this.isSampled = z;
    }

    public final Image getImage() {
        return this.image;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }
}

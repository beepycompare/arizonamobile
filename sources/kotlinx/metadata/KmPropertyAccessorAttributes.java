package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/metadata/KmPropertyAccessorAttributes;", "", "()V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(I)V", "getFlags$kotlinx_metadata", "()I", "setFlags$kotlinx_metadata", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmPropertyAccessorAttributes {
    private int flags;

    public KmPropertyAccessorAttributes(int i) {
        this.flags = i;
    }

    public final int getFlags$kotlinx_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlinx_metadata(int i) {
        this.flags = i;
    }

    public KmPropertyAccessorAttributes() {
        this(0);
    }
}

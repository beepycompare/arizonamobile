package coil3.fetch;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FetchResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcoil3/fetch/SourceFetchResult;", "Lcoil3/fetch/FetchResult;", "source", "Lcoil3/decode/ImageSource;", "mimeType", "", "dataSource", "Lcoil3/decode/DataSource;", "<init>", "(Lcoil3/decode/ImageSource;Ljava/lang/String;Lcoil3/decode/DataSource;)V", "getSource", "()Lcoil3/decode/ImageSource;", "getMimeType", "()Ljava/lang/String;", "getDataSource", "()Lcoil3/decode/DataSource;", "equals", "", "other", "", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SourceFetchResult implements FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SourceFetchResult) {
            SourceFetchResult sourceFetchResult = (SourceFetchResult) obj;
            return Intrinsics.areEqual(this.source, sourceFetchResult.source) && Intrinsics.areEqual(this.mimeType, sourceFetchResult.mimeType) && this.dataSource == sourceFetchResult.dataSource;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dataSource.hashCode();
    }

    public String toString() {
        return "SourceFetchResult(source=" + this.source + ", mimeType=" + this.mimeType + ", dataSource=" + this.dataSource + ')';
    }

    public SourceFetchResult(ImageSource imageSource, String str, DataSource dataSource) {
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    public final ImageSource getSource() {
        return this.source;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }
}

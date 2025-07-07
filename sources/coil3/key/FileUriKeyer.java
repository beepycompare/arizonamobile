package coil3.key;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import okio.Path;
/* compiled from: FileUriKeyer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcoil3/key/FileUriKeyer;", "Lcoil3/key/Keyer;", "Lcoil3/Uri;", "<init>", "()V", "key", "", "data", "options", "Lcoil3/request/Options;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileUriKeyer implements Keyer<Uri> {
    @Override // coil3.key.Keyer
    public String key(Uri uri, Options options) {
        String filePath;
        if (UtilsKt.isFileUri(uri) && ImageRequestsKt.getAddLastModifiedToFileCacheKey(options) && (filePath = UriKt.getFilePath(uri)) != null) {
            return new StringBuilder().append(uri).append('-').append(options.getFileSystem().metadata(Path.Companion.get$default(Path.Companion, filePath, false, 1, (Object) null)).getLastModifiedAtMillis()).toString();
        }
        return null;
    }
}

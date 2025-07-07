package coil3.fetch;

import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
/* compiled from: DataUriFetcher.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcoil3/fetch/DataUriFetcher;", "Lcoil3/fetch/Fetcher;", "uri", "Lcoil3/Uri;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/Uri;Lcoil3/request/Options;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataUriFetcher implements Fetcher {
    private static final String BASE64_TAG = ";base64,";
    private static final Companion Companion = new Companion(null);
    private final Options options;
    private final Uri uri;

    public DataUriFetcher(Uri uri, Options options) {
        this.uri = uri;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.uri.toString(), BASE64_TAG, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalStateException(("invalid data uri: " + this.uri).toString());
        }
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) this.uri.toString(), (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (indexOf$default2 == -1) {
            throw new IllegalStateException(("invalid data uri: " + this.uri).toString());
        }
        String substring = this.uri.toString().substring(indexOf$default2 + 1, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        byte[] decode$default = Base64.decode$default(Base64.Default, this.uri.toString(), indexOf$default + 8, 0, 4, (Object) null);
        Buffer buffer = new Buffer();
        buffer.write(decode$default);
        return new SourceFetchResult(ImageSourceKt.ImageSource$default(buffer, this.options.getFileSystem(), null, 4, null), substring, DataSource.MEMORY);
    }

    /* compiled from: DataUriFetcher.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcoil3/fetch/DataUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "<init>", "()V", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil3.fetch.Fetcher.Factory
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (Intrinsics.areEqual(uri.getScheme(), "data")) {
                return new DataUriFetcher(uri, options);
            }
            return null;
        }
    }

    /* compiled from: DataUriFetcher.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/fetch/DataUriFetcher$Companion;", "", "<init>", "()V", "BASE64_TAG", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

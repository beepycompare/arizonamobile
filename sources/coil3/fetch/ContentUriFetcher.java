package coil3.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.common.MimeTypes;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.Uri_androidKt;
import coil3.decode.ContentMetadata;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.size.Dimension;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
/* compiled from: ContentUriFetcher.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil3/fetch/ContentUriFetcher;", "Lcoil3/fetch/Fetcher;", "data", "Lcoil3/Uri;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/Uri;Lcoil3/request/Options;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContactPhotoUri", "", "isContactPhotoUri$coil_core_release", "isMusicThumbnailUri", "isMusicThumbnailUri$coil_core_release", "newMusicThumbnailSizeOptions", "Landroid/os/Bundle;", "Factory", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ContentUriFetcher(Uri uri, Options options) {
        this.data = uri;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) {
        AssetFileDescriptor openAssetFileDescriptor;
        android.net.Uri androidUri = Uri_androidKt.toAndroidUri(this.data);
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (isContactPhotoUri$coil_core_release(this.data)) {
            openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (openAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + androidUri + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT >= 29 && isMusicThumbnailUri$coil_core_release(this.data)) {
            openAssetFileDescriptor = contentResolver.openTypedAssetFile(androidUri, "image/*", newMusicThumbnailSizeOptions(), null);
            if (openAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + androidUri + "'.").toString());
            }
        } else {
            openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (openAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to open '" + androidUri + "'.").toString());
            }
        }
        return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.buffer(Okio.source(openAssetFileDescriptor.createInputStream())), this.options.getFileSystem(), new ContentMetadata(this.data, openAssetFileDescriptor)), contentResolver.getType(androidUri), DataSource.DISK);
    }

    public final boolean isContactPhotoUri$coil_core_release(Uri uri) {
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.contacts") && Intrinsics.areEqual(CollectionsKt.lastOrNull((List<? extends Object>) UriKt.getPathSegments(uri)), "display_photo");
    }

    public final boolean isMusicThumbnailUri$coil_core_release(Uri uri) {
        List<String> pathSegments;
        int size;
        return Intrinsics.areEqual(uri.getAuthority(), "media") && (size = (pathSegments = UriKt.getPathSegments(uri)).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size + (-3)), MimeTypes.BASE_TYPE_AUDIO) && Intrinsics.areEqual(pathSegments.get(size + (-2)), "albums");
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels != null) {
            int m7821unboximpl = pixels.m7821unboximpl();
            Dimension height = this.options.getSize().getHeight();
            Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
            if (pixels2 != null) {
                int m7821unboximpl2 = pixels2.m7821unboximpl();
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("android.content.extra.SIZE", new Point(m7821unboximpl, m7821unboximpl2));
                return bundle;
            }
            return null;
        }
        return null;
    }

    /* compiled from: ContentUriFetcher.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcoil3/fetch/ContentUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "<init>", "()V", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil3.fetch.Fetcher.Factory
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new ContentUriFetcher(uri, options);
            }
            return null;
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), FirebaseAnalytics.Param.CONTENT);
        }
    }
}

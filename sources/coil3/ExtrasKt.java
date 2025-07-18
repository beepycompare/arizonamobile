package coil3;

import androidx.exifinterface.media.ExifInterface;
import coil3.Extras;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
/* compiled from: Extras.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a#\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a#\u0010\t\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u000b\u001a#\u0010\t\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"plus", "Lcoil3/Extras;", "other", "getOrDefault", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lcoil3/Extras$Key;", "(Lcoil3/Extras;Lcoil3/Extras$Key;)Ljava/lang/Object;", "orEmpty", "getExtra", "Lcoil3/request/ImageRequest;", "(Lcoil3/request/ImageRequest;Lcoil3/Extras$Key;)Ljava/lang/Object;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;Lcoil3/Extras$Key;)Ljava/lang/Object;", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExtrasKt {
    public static final Extras plus(Extras extras, Extras extras2) {
        return new Extras.Builder(MapsKt.plus(extras.asMap(), extras2.asMap())).build();
    }

    public static final <T> T getOrDefault(Extras extras, Extras.Key<T> key) {
        T t = (T) extras.get(key);
        return t == null ? key.getDefault() : t;
    }

    public static final Extras orEmpty(Extras extras) {
        return extras == null ? Extras.EMPTY : extras;
    }

    public static final <T> T getExtra(ImageRequest imageRequest, Extras.Key<T> key) {
        T t = (T) imageRequest.getExtras().get(key);
        if (t == null) {
            T t2 = (T) imageRequest.getDefaults().getExtras().get(key);
            return t2 == null ? key.getDefault() : t2;
        }
        return t;
    }

    public static final <T> T getExtra(Options options, Extras.Key<T> key) {
        T t = (T) options.getExtras().get(key);
        return t == null ? key.getDefault() : t;
    }
}

package kotlinx.metadata;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u0002H\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0000¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"flagAccessPrefix", "", "flagsCtorDeprecated", "addTo", ExifInterface.GPS_DIRECTION_TRUE, "collection", "", "(Ljava/lang/Object;Ljava/util/Collection;)Ljava/lang/Object;", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NodesKt {
    private static final String flagAccessPrefix = "Flag API is deprecated. Please use corresponding member extensions on";
    private static final String flagsCtorDeprecated = "Constructor with flags is deprecated, use constructor without flags and assign them or corresponding extension properties directly.";

    public static final <T> T addTo(T t, Collection<T> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        collection.add(t);
        return t;
    }
}

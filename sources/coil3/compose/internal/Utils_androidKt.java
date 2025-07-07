package coil3.compose.internal;

import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import kotlin.Metadata;
/* compiled from: utils.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"validateRequestProperties", "", "request", "Lcoil3/request/ImageRequest;", "coil-compose-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Utils_androidKt {
    public static final void validateRequestProperties(ImageRequest imageRequest) {
        if (imageRequest.getTarget() != null) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
        if (ImageRequests_androidKt.getLifecycle(imageRequest) != null) {
            throw new IllegalArgumentException("request.lifecycle must be null.".toString());
        }
    }
}

package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class ThumbRating extends Rating {
    private static final int TYPE = 3;
    private final boolean isThumbsUp;
    private final boolean rated;
    private static final String FIELD_RATED = Util.intToStringMaxRadix(1);
    private static final String FIELD_IS_THUMBS_UP = Util.intToStringMaxRadix(2);

    public ThumbRating() {
        this.rated = false;
        this.isThumbsUp = false;
    }

    public ThumbRating(boolean z) {
        this.rated = true;
        this.isThumbsUp = z;
    }

    @Override // androidx.media3.common.Rating
    public boolean isRated() {
        return this.rated;
    }

    public boolean isThumbsUp() {
        return this.isThumbsUp;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.rated), Boolean.valueOf(this.isThumbsUp));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ThumbRating) {
            ThumbRating thumbRating = (ThumbRating) obj;
            return this.isThumbsUp == thumbRating.isThumbsUp && this.rated == thumbRating.rated;
        }
        return false;
    }

    @Override // androidx.media3.common.Rating
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RATING_TYPE, 3);
        bundle.putBoolean(FIELD_RATED, this.rated);
        bundle.putBoolean(FIELD_IS_THUMBS_UP, this.isThumbsUp);
        return bundle;
    }

    public static ThumbRating fromBundle(Bundle bundle) {
        Assertions.checkArgument(bundle.getInt(FIELD_RATING_TYPE, -1) == 3);
        if (bundle.getBoolean(FIELD_RATED, false)) {
            return new ThumbRating(bundle.getBoolean(FIELD_IS_THUMBS_UP, false));
        }
        return new ThumbRating();
    }
}

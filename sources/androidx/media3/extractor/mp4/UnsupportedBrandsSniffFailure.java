package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SniffFailure;
import com.google.common.primitives.ImmutableIntArray;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class UnsupportedBrandsSniffFailure implements SniffFailure {
    public final ImmutableIntArray compatibleBrands;
    public final int majorBrand;

    public UnsupportedBrandsSniffFailure(int i, int[] iArr) {
        ImmutableIntArray of;
        this.majorBrand = i;
        if (iArr != null) {
            of = ImmutableIntArray.copyOf(iArr);
        } else {
            of = ImmutableIntArray.of();
        }
        this.compatibleBrands = of;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(this.compatibleBrands.length());
        for (int i = 0; i < this.compatibleBrands.length(); i++) {
            arrayList.add(Util.toFourccString(this.compatibleBrands.get(i)));
        }
        return "UnsupportedBrands{major=" + Util.toFourccString(this.majorBrand) + ", compatible=" + arrayList + "}";
    }
}

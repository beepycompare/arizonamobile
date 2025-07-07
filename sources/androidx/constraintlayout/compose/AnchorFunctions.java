package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: ConstraintScopeCommon.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/AnchorFunctions;", "", "()V", "horizontalAnchorIndexToAnchorName", "", FirebaseAnalytics.Param.INDEX, "", "verticalAnchorIndexToAnchorName", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnchorFunctions {
    public static final int $stable = 0;
    public static final AnchorFunctions INSTANCE = new AnchorFunctions();

    private AnchorFunctions() {
    }

    public final String horizontalAnchorIndexToAnchorName(int i) {
        if (i != 0) {
            if (i == 1) {
                return "bottom";
            }
            Log.e("CCL", "horizontalAnchorIndexToAnchorName: Unknown horizontal index");
            return "top";
        }
        return "top";
    }

    public final String verticalAnchorIndexToAnchorName(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return TtmlNode.RIGHT;
                    }
                    Log.e("CCL", "verticalAnchorIndexToAnchorName: Unknown vertical index");
                    return TtmlNode.START;
                }
                return TtmlNode.LEFT;
            }
            return TtmlNode.END;
        }
        return TtmlNode.START;
    }
}

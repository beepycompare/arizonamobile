package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"Transition", "Landroidx/constraintlayout/compose/Transition;", FirebaseAnalytics.Param.CONTENT, "", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransitionKt {
    public static final Transition Transition(String str) {
        CLObject cLObject;
        try {
            cLObject = CLParser.parse(str);
        } catch (CLParsingException e) {
            Log.e("CML", "Error parsing JSON " + e);
            cLObject = null;
        }
        return cLObject != null ? new TransitionImpl(cLObject) : TransitionImpl.Companion.getEMPTY$constraintlayout_compose_release();
    }
}

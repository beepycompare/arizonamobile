package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
/* compiled from: Focusable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\"\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusableKt {
    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    public static final Modifier focusable(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource) {
        Modifier.Companion companion;
        if (z) {
            companion = new FocusableElement(mutableInteractionSource);
        } else {
            companion = Modifier.Companion;
        }
        return modifier.then(companion);
    }

    public static final Modifier focusGroup(Modifier modifier) {
        return modifier.then(FocusGroupElement.INSTANCE);
    }
}

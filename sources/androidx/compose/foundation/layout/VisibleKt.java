package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
/* compiled from: Visible.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"visible", "Landroidx/compose/ui/Modifier;", "", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VisibleKt {
    public static final Modifier visible(Modifier modifier, boolean z) {
        return modifier.then(new VisibilityElement(z));
    }
}

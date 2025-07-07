package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
/* compiled from: LazyStaggeredGridScrollScope.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"LazyLayoutScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridScrollScopeKt {
    public static final LazyLayoutScrollScope LazyLayoutScrollScope(LazyStaggeredGridState lazyStaggeredGridState, ScrollScope scrollScope) {
        return new LazyStaggeredGridScrollScopeKt$LazyLayoutScrollScope$1(scrollScope, lazyStaggeredGridState);
    }
}

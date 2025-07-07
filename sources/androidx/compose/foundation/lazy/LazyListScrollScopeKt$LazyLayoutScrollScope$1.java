package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: LazyListScrollScope.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\u0017"}, d2 = {"androidx/compose/foundation/lazy/LazyListScrollScopeKt$LazyLayoutScrollScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "Landroidx/compose/foundation/gestures/ScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "calculateDistanceTo", "targetIndex", "targetOffset", "scrollBy", "", "pixels", "snapToItem", "", FirebaseAnalytics.Param.INDEX, TypedValues.CycleType.S_WAVE_OFFSET, "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListScrollScopeKt$LazyLayoutScrollScope$1 implements LazyLayoutScrollScope, ScrollScope {
    private final /* synthetic */ ScrollScope $$delegate_0;
    final /* synthetic */ LazyListState $state;

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float scrollBy(float f) {
        return this.$$delegate_0.scrollBy(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyListScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, LazyListState lazyListState) {
        this.$state = lazyListState;
        this.$$delegate_0 = scrollScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int getFirstVisibleItemIndex() {
        return this.$state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.$state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int getLastVisibleItemIndex() {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull((List<? extends Object>) this.$state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int getItemCount() {
        return this.$state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public void snapToItem(int i, int i2) {
        this.$state.snapToItemIndexInternal$foundation_release(i, i2, true);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int calculateDistanceTo(int i, int i2) {
        LazyListItemInfo lazyListItemInfo;
        LazyListLayoutInfo layoutInfo = this.$state.getLayoutInfo();
        int i3 = 0;
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        int firstVisibleItemIndex = getFirstVisibleItemIndex();
        if (i > getLastVisibleItemIndex() || firstVisibleItemIndex > i) {
            i3 = (LazyListLayoutInfoKt.visibleItemsAverageSize(layoutInfo) * (i - getFirstVisibleItemIndex())) - getFirstVisibleItemScrollOffset();
        } else {
            List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                lazyListItemInfo = visibleItemsInfo.get(i4);
                if (lazyListItemInfo.getIndex() == i) {
                    break;
                }
                i4++;
            }
            LazyListItemInfo lazyListItemInfo2 = lazyListItemInfo;
            if (lazyListItemInfo2 != null) {
                i3 = lazyListItemInfo2.getOffset();
            }
        }
        return i3 + i2;
    }
}

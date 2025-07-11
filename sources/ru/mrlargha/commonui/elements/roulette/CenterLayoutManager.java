package ru.mrlargha.commonui.elements.roulette;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CaseRouletteScreen.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "CenterSmoothScroller", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CenterLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CenterSmoothScroller centerSmoothScroller = new CenterSmoothScroller(context);
        centerSmoothScroller.setTargetPosition(i);
        startSmoothScroll(centerSmoothScroller);
    }

    /* compiled from: CaseRouletteScreen.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CenterLayoutManager$CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class CenterSmoothScroller extends LinearSmoothScroller {
        public static final Companion Companion = new Companion(null);
        private static final float MILLISECONDS_PER_INCH = 150.0f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CenterSmoothScroller(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }

        /* compiled from: CaseRouletteScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CenterLayoutManager$CenterSmoothScroller$Companion;", "", "<init>", "()V", "MILLISECONDS_PER_INCH", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}

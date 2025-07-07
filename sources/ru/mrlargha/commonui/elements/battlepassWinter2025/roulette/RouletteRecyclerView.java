package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RouletteRecyclerView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "isPremium", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "onSellPrise", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;ZLandroid/util/AttributeSet;ILkotlin/jvm/functions/Function0;)V", "rouletteAdapter", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter;", "notifyAdapter", "startRotation", "position", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseModel;", "endScrolling", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteRecyclerView extends RecyclerView {
    public static final Companion Companion = new Companion(null);
    public static final int MAIN_POSITION = 2;
    private final RouletteAdapter rouletteAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RouletteRecyclerView(Context context, boolean z, AttributeSet attributeSet, Function0<Unit> onSellPrise) {
        this(context, z, attributeSet, 0, onSellPrise, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSellPrise, "onSellPrise");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RouletteRecyclerView(Context context, boolean z, Function0<Unit> onSellPrise) {
        this(context, z, null, 0, onSellPrise, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSellPrise, "onSellPrise");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public /* synthetic */ RouletteRecyclerView(Context context, boolean z, AttributeSet attributeSet, int i, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i, function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouletteRecyclerView(Context context, boolean z, AttributeSet attributeSet, int i, Function0<Unit> onSellPrise) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSellPrise, "onSellPrise");
        RouletteAdapter rouletteAdapter = new RouletteAdapter(onSellPrise);
        this.rouletteAdapter = rouletteAdapter;
        setLayoutManager(new LinearLayoutManager(context, 1, false));
        setAdapter(rouletteAdapter);
        rouletteAdapter.setPremium(z);
        new LinearSnapHelper().attachToRecyclerView(this);
        smoothScrollToPosition(2);
        setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteRecyclerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = RouletteRecyclerView._init_$lambda$0(view, motionEvent);
                return _init_$lambda$0;
            }
        });
    }

    public final void notifyAdapter() {
        this.rouletteAdapter.notifyAdapter();
    }

    public final void startRotation(final int i, final PriseModel prise, final Function0<Unit> endScrolling) {
        Intrinsics.checkNotNullParameter(prise, "prise");
        Intrinsics.checkNotNullParameter(endScrolling, "endScrolling");
        clearOnScrollListeners();
        setOnClickListener(null);
        smoothScrollToPosition(i);
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteRecyclerView$startRotation$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= i) {
                        Log.d("onBackendMessage", prise.toString());
                        RecyclerView.Adapter adapter = this.getAdapter();
                        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteAdapter");
                        ((RouletteAdapter) adapter).changePrise(prise);
                        RouletteRecyclerViewKt.scrollToPositionCentered(recyclerView, 2);
                        endScrolling.invoke();
                    }
                }
            }
        });
    }

    /* compiled from: RouletteRecyclerView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteRecyclerView$Companion;", "", "<init>", "()V", "MAIN_POSITION", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

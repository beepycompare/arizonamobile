package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
/* compiled from: RouletteView.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00172\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0 J\"\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&J\u0006\u0010'\u001a\u00020\u001eJ$\u0010(\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0&H\u0002J$\u0010*\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0 H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0016\u0010-\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0&H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rouletteSlotCount", "rouletteSlotList", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteRecyclerView;", "backgroundLine", "Landroid/widget/ImageView;", "getBackgroundLine", "()Landroid/widget/ImageView;", "foregroundLayout", "Landroid/widget/FrameLayout;", "getForegroundLayout", "()Landroid/widget/FrameLayout;", "isFirstStart", "", "()Z", "setFirstStart", "(Z)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isPremium", "", "onSellPrise", "Lkotlin/Function1;", TtmlNode.START, "priseList", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseModel;", "endRotation", "Lkotlin/Function0;", "notifyAdapter", "startRotation", "endScrolling", "initialization", "createBackgroundLind", "createForegroundView", "createRouletteSlot", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteView extends LinearLayout {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_ROULETTE_HEIGHT = 240;
    public static final int DEFAULT_ROULETTE_WIDTH = 280;
    public static final int DEFAULT_SLOT_COUNT = 3;
    public static final int PREMIUM_ROULETTE_HEIGHT = 180;
    public static final int PREMIUM_ROULETTE_WIDTH = 360;
    public static final int PREMIUM_SLOT_COUNT = 7;
    public static final int ROULETTE_POSITION = 200;
    public static final int ROULETTE_POSITION_STEP = 200;
    public static final int START_ROULETTE_SLOT = 1;
    private final ImageView backgroundLine;
    private final FrameLayout foregroundLayout;
    private boolean isFirstStart;
    private int rouletteSlotCount;
    private final List<RouletteRecyclerView> rouletteSlotList;
    private final CoroutineScope scope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RouletteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RouletteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RouletteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rouletteSlotCount = 3;
        this.rouletteSlotList = new ArrayList();
        this.backgroundLine = new ImageView(context);
        this.foregroundLayout = new FrameLayout(context);
        this.isFirstStart = true;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        setOrientation(0);
    }

    public final ImageView getBackgroundLine() {
        return this.backgroundLine;
    }

    public final FrameLayout getForegroundLayout() {
        return this.foregroundLayout;
    }

    public final boolean isFirstStart() {
        return this.isFirstStart;
    }

    public final void setFirstStart(boolean z) {
        this.isFirstStart = z;
    }

    public final void isPremium(boolean z, Function1<? super Integer, Unit> onSellPrise) {
        Intrinsics.checkNotNullParameter(onSellPrise, "onSellPrise");
        if (z) {
            this.rouletteSlotCount = 7;
            initialization(7, onSellPrise);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int dpToPx = RouletteViewKt.dpToPx(context, 360.0f);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, RouletteViewKt.dpToPx(context2, 180.0f));
            layoutParams.gravity = 17;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int dpToPx2 = RouletteViewKt.dpToPx(context3, 30.0f);
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            layoutParams.setMargins(dpToPx2, 0, RouletteViewKt.dpToPx(context4, 30.0f), 0);
            setLayoutParams(layoutParams);
            return;
        }
        this.rouletteSlotCount = 3;
        initialization(3, onSellPrise);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        int dpToPx3 = RouletteViewKt.dpToPx(context5, 280.0f);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx3, RouletteViewKt.dpToPx(context6, 240.0f));
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(38, 0, 38, 0);
        setLayoutParams(layoutParams2);
    }

    public final void start(List<PriseModel> priseList, final Function0<Unit> endRotation) {
        Intrinsics.checkNotNullParameter(priseList, "priseList");
        Intrinsics.checkNotNullParameter(endRotation, "endRotation");
        Log.d("onBackendMessage1", priseList.toString());
        if (priseList.size() == this.rouletteSlotCount) {
            startRotation(priseList, new Function0() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit start$lambda$2;
                    start$lambda$2 = RouletteView.start$lambda$2(Function0.this);
                    return start$lambda$2;
                }
            });
            return;
        }
        int i = this.rouletteSlotCount;
        throw new RuntimeException("Неправильное количество списка, ожидается: " + i + " полученно: " + priseList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void notifyAdapter() {
        for (RouletteRecyclerView rouletteRecyclerView : this.rouletteSlotList) {
            rouletteRecyclerView.notifyAdapter();
        }
    }

    private final void startRotation(final List<PriseModel> list, final Function0<Unit> function0) {
        Log.d("onBackendMessage2", list.toString());
        final int i = 0;
        int i2 = 200;
        for (Object obj : list) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.rouletteSlotList.get(i).startRotation(i2, (PriseModel) obj, new Function0() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit startRotation$lambda$5$lambda$4;
                    startRotation$lambda$5$lambda$4 = RouletteView.startRotation$lambda$5$lambda$4(i, list, function0);
                    return startRotation$lambda$5$lambda$4;
                }
            });
            i2 += 200;
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRotation$lambda$5$lambda$4(int i, List list, Function0 function0) {
        if (i == list.size() - 1) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final void initialization(int i, final Function1<? super Integer, Unit> function1) {
        removeAllViews();
        this.rouletteSlotList.clear();
        createForegroundView();
        createBackgroundLind();
        final int i2 = 1;
        if (1 <= i) {
            while (true) {
                createRouletteSlot(new Function0() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit initialization$lambda$6;
                        initialization$lambda$6 = RouletteView.initialization$lambda$6(Function1.this, i2);
                        return initialization$lambda$6;
                    }
                });
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        this.isFirstStart = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialization$lambda$6(Function1 function1, int i) {
        function1.invoke(Integer.valueOf(i - 1));
        return Unit.INSTANCE;
    }

    private final void createBackgroundLind() {
        if (this.isFirstStart) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(this.backgroundLine, 0);
        }
        ImageView imageView = this.backgroundLine;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dpToPx = RouletteViewKt.dpToPx(context, this.rouletteSlotCount == 7 ? 360.0f : 280.0f);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, RouletteViewKt.dpToPx(context2, (this.rouletteSlotCount == 7 ? 180 : 240) / 2.8f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        this.backgroundLine.setImageResource(this.rouletteSlotCount == 7 ? R.drawable.winter_battlepass_roulette_bg_premium_roulette : R.drawable.winter_battlepass_roulette_bg_default_roulette);
        this.backgroundLine.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void createForegroundView() {
        if (this.isFirstStart) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(this.foregroundLayout);
        }
        FrameLayout frameLayout = this.foregroundLayout;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dpToPx = RouletteViewKt.dpToPx(context, 360.0f);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, RouletteViewKt.dpToPx(context2, 180.0f));
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
    }

    private final void createRouletteSlot(Function0<Unit> function0) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        RouletteRecyclerView rouletteRecyclerView = new RouletteRecyclerView(context, this.rouletteSlotCount == 7, null, 0, function0, 12, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(6, 0, 6, 0);
        rouletteRecyclerView.setLayoutParams(layoutParams);
        addView(rouletteRecyclerView);
        this.rouletteSlotList.add(rouletteRecyclerView);
    }

    /* compiled from: RouletteView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteView$Companion;", "", "<init>", "()V", "START_ROULETTE_SLOT", "", "DEFAULT_SLOT_COUNT", "PREMIUM_SLOT_COUNT", "DEFAULT_ROULETTE_WIDTH", "PREMIUM_ROULETTE_WIDTH", "DEFAULT_ROULETTE_HEIGHT", "PREMIUM_ROULETTE_HEIGHT", "ROULETTE_POSITION", "ROULETTE_POSITION_STEP", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

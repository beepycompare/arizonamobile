package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter;
import ru.mrlargha.feature.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLevelItemBinding;
import ru.mrlargha.feature.battlepassWinter2025.utils.LevelItemsAdapterDiffUtil;
/* compiled from: LevelItemsAdapter.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001(B{\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0004:\u0002\b\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000b\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u001c\u0010\u001f\u001a\u00020\b2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u0004H\u0016J\u0014\u0010\"\u001a\u00020\b2\n\u0010 \u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J@\u0010$\u001a\u00020\b2\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00150%2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\bR\u0015\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0005¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter$LevelItemViewHolder;", "itemLayout", "", "Landroidx/annotation/LayoutRes;", "onBuyLevel", "Lkotlin/Function0;", "", "onQuality", "onClaimItem", "Lkotlin/Function2;", "", "onRewardDescription", "Lkotlin/Function3;", "Landroid/view/View;", "repeatBP", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lkotlin/Pair;", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", FirebaseAnalytics.Param.LEVEL, "levelProgress", "isArizonaType", "isPrem", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "setData", "", "isArisona", "clearItems", "LevelItemViewHolder", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LevelItemsAdapter extends RecyclerView.Adapter<LevelItemViewHolder> {
    private boolean isArizonaType;
    private boolean isPrem;
    private final int itemLayout;
    private final List<Pair<AwardItemData, AwardItemData>> items;
    private int level;
    private int levelProgress;
    private final Function0<Unit> onBuyLevel;
    private final Function2<Boolean, Integer, Unit> onClaimItem;
    private final Function0<Unit> onQuality;
    private final Function3<View, Integer, Boolean, Unit> onRewardDescription;
    private final Function0<Unit> repeatBP;

    /* JADX WARN: Multi-variable type inference failed */
    public LevelItemsAdapter(int i, Function0<Unit> onBuyLevel, Function0<Unit> onQuality, Function2<? super Boolean, ? super Integer, Unit> onClaimItem, Function3<? super View, ? super Integer, ? super Boolean, Unit> onRewardDescription, Function0<Unit> repeatBP) {
        Intrinsics.checkNotNullParameter(onBuyLevel, "onBuyLevel");
        Intrinsics.checkNotNullParameter(onQuality, "onQuality");
        Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
        Intrinsics.checkNotNullParameter(onRewardDescription, "onRewardDescription");
        Intrinsics.checkNotNullParameter(repeatBP, "repeatBP");
        this.itemLayout = i;
        this.onBuyLevel = onBuyLevel;
        this.onQuality = onQuality;
        this.onClaimItem = onClaimItem;
        this.onRewardDescription = onRewardDescription;
        this.repeatBP = repeatBP;
        this.items = new ArrayList();
        this.isArizonaType = true;
    }

    public /* synthetic */ LevelItemsAdapter(int i, Function0 function0, Function0 function02, Function2 function2, Function3 function3, Function0 function03, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, function02, (i2 & 8) != 0 ? new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                ((Boolean) obj).booleanValue();
                ((Integer) obj2).intValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function2, function3, function03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LevelItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new LevelItemViewHolder(this, inflate, this.onClaimItem, this.onRewardDescription);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LevelItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(i), i, this.level, this.isPrem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(LevelItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.cancelImageLoading();
        super.onViewRecycled((LevelItemsAdapter) holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setData(List<Pair<AwardItemData, AwardItemData>> items, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(items, "items");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new LevelItemsAdapterDiffUtil(this.items, items));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(...)");
        this.items.clear();
        List<Pair<AwardItemData, AwardItemData>> list = this.items;
        List<Pair<AwardItemData, AwardItemData>> list2 = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(new Pair(AwardItemData.copy$default((AwardItemData) pair.getFirst(), 0, null, null, 0, false, false, null, 0, 255, null), AwardItemData.copy$default((AwardItemData) pair.getSecond(), 0, null, null, 0, false, false, null, 0, 255, null)));
        }
        list.addAll(arrayList);
        if (this.level != i || this.isPrem != z2) {
            this.level = i;
            this.isArizonaType = z;
            this.isPrem = z2;
            this.levelProgress = i2;
            notifyDataSetChanged();
            return;
        }
        this.levelProgress = i2;
        this.level = i;
        this.isArizonaType = z;
        this.isPrem = z2;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public final void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }

    /* compiled from: LevelItemsAdapter.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0004\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J8\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J0\u0010#\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0006\u0010&\u001a\u00020\bJ\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J(\u0010(\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J8\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u00100\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J \u00101\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter$LevelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClaimItem", "Lkotlin/Function2;", "", "", "", "onRewardDescription", "Lkotlin/Function3;", "<init>", "(Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLevelItemBinding;", "loadPremiumImageJob", "Lkotlinx/coroutines/Job;", "loadUsualImageJob", "bind", "award", "Lkotlin/Pair;", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", "position", FirebaseAnalytics.Param.LEVEL, "isPrem", "bindPremiumRewardDescription", "itemPremium", "bindQualityButtons", "itemUsual", "bindProgress", "pos", "levelProgressColor", "levelProgressTextColor", "levelNotPassedColor", "levelNotPassedTextColor", "bindBoosts", "levelProgress", "bindRewardImages", "cancelImageLoading", "bindCountBadges", "bindPremiumRewardState", "bindUsualRewardState", "bindLockedRewardDescription", "button", "lock", "item", "isPremium", "isLocked", "bindContainerVisibility", "bindRepeatBoost", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class LevelItemViewHolder extends RecyclerView.ViewHolder {
        private final WinterBattlepassLevelItemBinding binding;
        private Job loadPremiumImageJob;
        private Job loadUsualImageJob;
        private final Function2<Boolean, Integer, Unit> onClaimItem;
        private final Function3<View, Integer, Boolean, Unit> onRewardDescription;
        final /* synthetic */ LevelItemsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public LevelItemViewHolder(LevelItemsAdapter levelItemsAdapter, View itemView, Function2<? super Boolean, ? super Integer, Unit> onClaimItem, Function3<? super View, ? super Integer, ? super Boolean, Unit> onRewardDescription) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
            Intrinsics.checkNotNullParameter(onRewardDescription, "onRewardDescription");
            this.this$0 = levelItemsAdapter;
            this.onClaimItem = onClaimItem;
            this.onRewardDescription = onRewardDescription;
            WinterBattlepassLevelItemBinding bind = WinterBattlepassLevelItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public /* synthetic */ LevelItemViewHolder(LevelItemsAdapter levelItemsAdapter, View view, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(levelItemsAdapter, view, (i & 2) != 0 ? new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit unit;
                    ((Boolean) obj).booleanValue();
                    ((Integer) obj2).intValue();
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function2, function3);
        }

        public final void bind(Pair<AwardItemData, AwardItemData> award, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(award, "award");
            AwardItemData second = award.getSecond();
            AwardItemData first = award.getFirst();
            int i3 = i + 1;
            cancelImageLoading();
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int resolveBattlePassColor = BattlePassVisualSkinKt.resolveBattlePassColor(context, R.attr.winterBpLevelProgressPassed, R.color.winter_bp_level_progress_passed);
            Context context2 = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            int resolveBattlePassColor2 = BattlePassVisualSkinKt.resolveBattlePassColor(context2, R.attr.winterBpLevelProgressPassedText, R.color.winter_bp_level_progress_text);
            Context context3 = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int resolveBattlePassColor3 = BattlePassVisualSkinKt.resolveBattlePassColor(context3, R.attr.winterBpLevelProgressNotPassed, R.color.winter_bp_level_progress_not_passed);
            Context context4 = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            int resolveBattlePassColor4 = BattlePassVisualSkinKt.resolveBattlePassColor(context4, R.attr.winterBpLevelProgressNotPassedText, R.color.winter_bp_white);
            bindQualityButtons(first, second);
            bindProgress(i3, i2, resolveBattlePassColor, resolveBattlePassColor2, resolveBattlePassColor3, resolveBattlePassColor4);
            bindBoosts(i3, i2, this.this$0.levelProgress, resolveBattlePassColor, resolveBattlePassColor3);
            bindRewardImages(second, first);
            bindCountBadges(second, first);
            bindPremiumRewardDescription(second, i3);
            bindPremiumRewardState(second, i3, i2, z);
            bindUsualRewardState(first, i3, i2);
            bindContainerVisibility(second, first);
            bindRepeatBoost(i3, i2, resolveBattlePassColor);
        }

        private final void bindPremiumRewardDescription(AwardItemData awardItemData, final int i) {
            CustomCardView customCardView = this.binding.itemLevelPremiumContainerFull;
            customCardView.setTag(Integer.valueOf(i));
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) awardItemData.getSysName()).toString(), "-1")) {
                customCardView.setOnClickListener(null);
                customCardView.setClickable(false);
                return;
            }
            customCardView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindPremiumRewardDescription$lambda$0$0(LevelItemsAdapter.LevelItemViewHolder.this, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindPremiumRewardDescription$lambda$0$0(LevelItemViewHolder levelItemViewHolder, int i, View view) {
            Function3<View, Integer, Boolean, Unit> function3 = levelItemViewHolder.onRewardDescription;
            Intrinsics.checkNotNull(view);
            function3.invoke(view, Integer.valueOf(i), true);
        }

        private final void bindQualityButtons(AwardItemData awardItemData, AwardItemData awardItemData2) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            final LevelItemsAdapter levelItemsAdapter = this.this$0;
            Integer isVehicle = awardItemData.isVehicle();
            if (isVehicle != null && isVehicle.intValue() == 1) {
                winterBattlepassLevelItemBinding.qualityButton.setVisibility(0);
            } else {
                winterBattlepassLevelItemBinding.qualityButton.setVisibility(8);
            }
            Integer isVehicle2 = awardItemData2.isVehicle();
            if (isVehicle2 != null && isVehicle2.intValue() == 1) {
                winterBattlepassLevelItemBinding.qualityButton1.setVisibility(0);
            } else {
                winterBattlepassLevelItemBinding.qualityButton1.setVisibility(8);
            }
            winterBattlepassLevelItemBinding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindQualityButtons$lambda$0$0(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.qualityButton1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindQualityButtons$lambda$0$1(LevelItemsAdapter.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindQualityButtons$lambda$0$0(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onQuality.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindQualityButtons$lambda$0$1(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onQuality.invoke();
        }

        private final void bindProgress(int i, int i2, int i3, int i4, int i5, int i6) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            winterBattlepassLevelItemBinding.levelText.setText(String.valueOf(i));
            if (i < i2) {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackground(i3);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(i3);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i3);
                winterBattlepassLevelItemBinding.levelText.setTextColor(i4);
            } else if (i == i2) {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackground(i3);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(i3);
                winterBattlepassLevelItemBinding.levelText.setTextColor(i4);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i5);
            } else {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackground(i5);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(i5);
                winterBattlepassLevelItemBinding.levelText.setTextColor(i6);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i5);
            }
        }

        private final void bindBoosts(int i, int i2, int i3, int i4, int i5) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            final LevelItemsAdapter levelItemsAdapter = this.this$0;
            winterBattlepassLevelItemBinding.boost1.setVisibility(8);
            winterBattlepassLevelItemBinding.boost2.setVisibility(8);
            winterBattlepassLevelItemBinding.boost3.setVisibility(8);
            winterBattlepassLevelItemBinding.boost4.setVisibility(8);
            if (i2 == 0 && i == 1) {
                winterBattlepassLevelItemBinding.boost1.setVisibility(0);
            }
            winterBattlepassLevelItemBinding.boost1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindBoosts$lambda$0$0(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindBoosts$lambda$0$1(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindBoosts$lambda$0$2(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindBoosts$lambda$0$3(LevelItemsAdapter.this, view);
                }
            });
            if (i2 < 100) {
                if (i == i2) {
                    if (i3 >= 0 && i3 < 6) {
                        winterBattlepassLevelItemBinding.boost4.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i5);
                    } else if (6 <= i3 && i3 < 11) {
                        winterBattlepassLevelItemBinding.boost2.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i4);
                    } else {
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i4);
                    }
                }
                if (i == i2 + 1) {
                    if (11 <= i3 && i3 < 21) {
                        winterBattlepassLevelItemBinding.boost1.setVisibility(0);
                    } else if (16 > i3 || i3 >= 21) {
                    } else {
                        winterBattlepassLevelItemBinding.boost3.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewBeforeLevel.setBackground(i4);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindBoosts$lambda$0$0(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindBoosts$lambda$0$1(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindBoosts$lambda$0$2(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindBoosts$lambda$0$3(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        private final void bindRewardImages(AwardItemData awardItemData, AwardItemData awardItemData2) {
            Job launch$default;
            Job launch$default2;
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            LevelItemsAdapter levelItemsAdapter = this.this$0;
            winterBattlepassLevelItemBinding.itemLevelNamePremium.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, awardItemData.getTitle(), 0.0f, null, 3, null));
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$1(winterBattlepassLevelItemBinding, levelItemsAdapter, awardItemData, this, null), 3, null);
            this.loadPremiumImageJob = launch$default;
            winterBattlepassLevelItemBinding.itemLevelNameUsually.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, awardItemData2.getTitle(), 0.0f, null, 3, null));
            launch$default2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2(winterBattlepassLevelItemBinding, levelItemsAdapter, awardItemData2, this, null), 3, null);
            this.loadUsualImageJob = launch$default2;
        }

        public final void cancelImageLoading() {
            Job job = this.loadPremiumImageJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.loadPremiumImageJob = null;
            Job job2 = this.loadUsualImageJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.loadUsualImageJob = null;
        }

        private final void bindCountBadges(AwardItemData awardItemData, AwardItemData awardItemData2) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            LevelItemsAdapter levelItemsAdapter = this.this$0;
            if (awardItemData.getCount() > 0 && !levelItemsAdapter.isArizonaType) {
                CustomCardView premiumContainerCount = winterBattlepassLevelItemBinding.premiumContainerCount;
                Intrinsics.checkNotNullExpressionValue(premiumContainerCount, "premiumContainerCount");
                premiumContainerCount.setVisibility(0);
                winterBattlepassLevelItemBinding.tvPremiumCount.setText(awardItemData.getCount() + " шт.");
            } else {
                CustomCardView premiumContainerCount2 = winterBattlepassLevelItemBinding.premiumContainerCount;
                Intrinsics.checkNotNullExpressionValue(premiumContainerCount2, "premiumContainerCount");
                premiumContainerCount2.setVisibility(8);
            }
            if (awardItemData2.getCount() > 0 && !levelItemsAdapter.isArizonaType) {
                CustomCardView usuallyCountContainer = winterBattlepassLevelItemBinding.usuallyCountContainer;
                Intrinsics.checkNotNullExpressionValue(usuallyCountContainer, "usuallyCountContainer");
                usuallyCountContainer.setVisibility(0);
                winterBattlepassLevelItemBinding.tvUsuallyCount.setText(awardItemData2.getCount() + " шт.");
                return;
            }
            CustomCardView usuallyCountContainer2 = winterBattlepassLevelItemBinding.usuallyCountContainer;
            Intrinsics.checkNotNullExpressionValue(usuallyCountContainer2, "usuallyCountContainer");
            usuallyCountContainer2.setVisibility(8);
        }

        private final void bindPremiumRewardState(final AwardItemData awardItemData, final int i, int i2, boolean z) {
            final WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            boolean z2 = i > i2 || !z;
            if (awardItemData.isAvailable() && i <= i2 && z) {
                CustomCardView itemLevelBtnPremium = winterBattlepassLevelItemBinding.itemLevelBtnPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnPremium, "itemLevelBtnPremium");
                itemLevelBtnPremium.setVisibility(0);
                LinearLayout itemLevelReceivedPremium = winterBattlepassLevelItemBinding.itemLevelReceivedPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedPremium, "itemLevelReceivedPremium");
                itemLevelReceivedPremium.setVisibility(8);
                CustomCardView itemLevelBackgroundPremium = winterBattlepassLevelItemBinding.itemLevelBackgroundPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundPremium, "itemLevelBackgroundPremium");
                itemLevelBackgroundPremium.setVisibility(8);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LevelItemsAdapter.LevelItemViewHolder.bindPremiumRewardState$lambda$0$0(WinterBattlepassLevelItemBinding.this, awardItemData, this, i, view);
                    }
                });
            } else if (z2) {
                CustomCardView itemLevelBtnPremium2 = winterBattlepassLevelItemBinding.itemLevelBtnPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnPremium2, "itemLevelBtnPremium");
                itemLevelBtnPremium2.setVisibility(8);
                LinearLayout itemLevelReceivedPremium2 = winterBattlepassLevelItemBinding.itemLevelReceivedPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedPremium2, "itemLevelReceivedPremium");
                itemLevelReceivedPremium2.setVisibility(8);
                CustomCardView itemLevelBackgroundPremium2 = winterBattlepassLevelItemBinding.itemLevelBackgroundPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundPremium2, "itemLevelBackgroundPremium");
                itemLevelBackgroundPremium2.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(null);
            } else {
                CustomCardView itemLevelBtnPremium3 = winterBattlepassLevelItemBinding.itemLevelBtnPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnPremium3, "itemLevelBtnPremium");
                itemLevelBtnPremium3.setVisibility(8);
                LinearLayout itemLevelReceivedPremium3 = winterBattlepassLevelItemBinding.itemLevelReceivedPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedPremium3, "itemLevelReceivedPremium");
                itemLevelReceivedPremium3.setVisibility(0);
                CustomCardView itemLevelBackgroundPremium3 = winterBattlepassLevelItemBinding.itemLevelBackgroundPremium;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundPremium3, "itemLevelBackgroundPremium");
                itemLevelBackgroundPremium3.setVisibility(8);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(null);
            }
            CustomCardView itemLevelDescriptionPremium = winterBattlepassLevelItemBinding.itemLevelDescriptionPremium;
            Intrinsics.checkNotNullExpressionValue(itemLevelDescriptionPremium, "itemLevelDescriptionPremium");
            CustomCardView customCardView = itemLevelDescriptionPremium;
            ImageView itemLevelLockPremium = winterBattlepassLevelItemBinding.itemLevelLockPremium;
            Intrinsics.checkNotNullExpressionValue(itemLevelLockPremium, "itemLevelLockPremium");
            bindLockedRewardDescription(customCardView, itemLevelLockPremium, awardItemData, true, z2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindPremiumRewardState$lambda$0$0(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
            winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(4);
            awardItemData.setWasClicked(true);
            levelItemViewHolder.onClaimItem.invoke(true, Integer.valueOf(i));
        }

        private final void bindUsualRewardState(final AwardItemData awardItemData, final int i, int i2) {
            final WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            boolean z = i > i2;
            if (awardItemData.isAvailable() && i <= i2) {
                CustomCardView itemLevelBtnUsually = winterBattlepassLevelItemBinding.itemLevelBtnUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnUsually, "itemLevelBtnUsually");
                itemLevelBtnUsually.setVisibility(0);
                LinearLayout itemLevelReceivedUsually = winterBattlepassLevelItemBinding.itemLevelReceivedUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedUsually, "itemLevelReceivedUsually");
                itemLevelReceivedUsually.setVisibility(8);
                CustomCardView itemLevelBackgroundUsual = winterBattlepassLevelItemBinding.itemLevelBackgroundUsual;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundUsual, "itemLevelBackgroundUsual");
                itemLevelBackgroundUsual.setVisibility(8);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LevelItemsAdapter.LevelItemViewHolder.bindUsualRewardState$lambda$0$0(WinterBattlepassLevelItemBinding.this, awardItemData, this, i, view);
                    }
                });
            } else if (z) {
                CustomCardView itemLevelBtnUsually2 = winterBattlepassLevelItemBinding.itemLevelBtnUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnUsually2, "itemLevelBtnUsually");
                itemLevelBtnUsually2.setVisibility(8);
                LinearLayout itemLevelReceivedUsually2 = winterBattlepassLevelItemBinding.itemLevelReceivedUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedUsually2, "itemLevelReceivedUsually");
                itemLevelReceivedUsually2.setVisibility(8);
                CustomCardView itemLevelBackgroundUsual2 = winterBattlepassLevelItemBinding.itemLevelBackgroundUsual;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundUsual2, "itemLevelBackgroundUsual");
                itemLevelBackgroundUsual2.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(null);
            } else {
                CustomCardView itemLevelBtnUsually3 = winterBattlepassLevelItemBinding.itemLevelBtnUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelBtnUsually3, "itemLevelBtnUsually");
                itemLevelBtnUsually3.setVisibility(8);
                LinearLayout itemLevelReceivedUsually3 = winterBattlepassLevelItemBinding.itemLevelReceivedUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelReceivedUsually3, "itemLevelReceivedUsually");
                itemLevelReceivedUsually3.setVisibility(0);
                CustomCardView itemLevelBackgroundUsual3 = winterBattlepassLevelItemBinding.itemLevelBackgroundUsual;
                Intrinsics.checkNotNullExpressionValue(itemLevelBackgroundUsual3, "itemLevelBackgroundUsual");
                itemLevelBackgroundUsual3.setVisibility(8);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(null);
            }
            CustomCardView itemLevelDescriptionUsually = winterBattlepassLevelItemBinding.itemLevelDescriptionUsually;
            Intrinsics.checkNotNullExpressionValue(itemLevelDescriptionUsually, "itemLevelDescriptionUsually");
            CustomCardView customCardView = itemLevelDescriptionUsually;
            ImageView itemLevelLockUsually = winterBattlepassLevelItemBinding.itemLevelLockUsually;
            Intrinsics.checkNotNullExpressionValue(itemLevelLockUsually, "itemLevelLockUsually");
            bindLockedRewardDescription(customCardView, itemLevelLockUsually, awardItemData, false, z, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindUsualRewardState$lambda$0$0(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
            winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(4);
            awardItemData.setWasClicked(true);
            levelItemViewHolder.onClaimItem.invoke(false, Integer.valueOf(i));
        }

        private final void bindLockedRewardDescription(View view, View view2, AwardItemData awardItemData, final boolean z, boolean z2, final int i) {
            boolean z3 = true;
            boolean z4 = this.this$0.isArizonaType && z2 && !Intrinsics.areEqual(StringsKt.trim((CharSequence) awardItemData.getSysName()).toString(), "-1");
            view.setVisibility(z4 ? 0 : 8);
            if (!z2 || z4) {
                z3 = false;
            }
            view2.setVisibility(z3 ? 0 : 8);
            view.setTag(Integer.valueOf(i));
            view.setOnClickListener(z4 ? new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LevelItemsAdapter.LevelItemViewHolder.bindLockedRewardDescription$lambda$0(LevelItemsAdapter.LevelItemViewHolder.this, i, z, view3);
                }
            } : null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void bindLockedRewardDescription$lambda$0(LevelItemViewHolder levelItemViewHolder, int i, boolean z, View view) {
            Function3<View, Integer, Boolean, Unit> function3 = levelItemViewHolder.onRewardDescription;
            Intrinsics.checkNotNull(view);
            function3.invoke(view, Integer.valueOf(i), Boolean.valueOf(z));
        }

        private final void bindContainerVisibility(AwardItemData awardItemData, AwardItemData awardItemData2) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            if (Intrinsics.areEqual(awardItemData.getSysName(), "-1")) {
                winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(4);
            } else {
                winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(0);
            }
            if (Intrinsics.areEqual(awardItemData2.getSysName(), " -1")) {
                winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(4);
            } else {
                winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(0);
            }
        }

        private final void bindRepeatBoost(int i, int i2, int i3) {
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            final LevelItemsAdapter levelItemsAdapter = this.this$0;
            if (i2 >= i && i == levelItemsAdapter.items.size()) {
                winterBattlepassLevelItemBinding.boost2.setBackgroundResource(R.drawable.bp_reapet);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackground(i3);
                winterBattlepassLevelItemBinding.boost2.setClickable(true);
                View boost2 = winterBattlepassLevelItemBinding.boost2;
                Intrinsics.checkNotNullExpressionValue(boost2, "boost2");
                boost2.setVisibility(0);
            } else {
                winterBattlepassLevelItemBinding.boost2.setBackgroundResource(R.drawable.battlepass_2025_winter_boost_button);
                winterBattlepassLevelItemBinding.boost2.setClickable(false);
                View boost22 = winterBattlepassLevelItemBinding.boost2;
                Intrinsics.checkNotNullExpressionValue(boost22, "boost2");
                boost22.setVisibility(8);
            }
            winterBattlepassLevelItemBinding.boost2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bindRepeatBoost$lambda$0$0(LevelItemsAdapter.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindRepeatBoost$lambda$0$0(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.repeatBP.invoke();
        }
    }
}

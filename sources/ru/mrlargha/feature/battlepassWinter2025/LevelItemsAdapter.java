package ru.mrlargha.feature.battlepassWinter2025;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\b2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J@\u0010 \u001a\u00020\b2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00120!2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter$LevelItemViewHolder;", "levelPassedColor", "", "levelNotPassedColor", "onBuyLevel", "Lkotlin/Function0;", "", "onQuality", "onClaimItem", "Lkotlin/Function2;", "", "repeatBP", "<init>", "(IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lkotlin/Pair;", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", FirebaseAnalytics.Param.LEVEL, "levelProgress", "isArizonaType", "isPrem", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setData", "", "isArisona", "clearItems", "LevelItemViewHolder", "battle-pass"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LevelItemsAdapter extends RecyclerView.Adapter<LevelItemViewHolder> {
    private boolean isArizonaType;
    private boolean isPrem;
    private final List<Pair<AwardItemData, AwardItemData>> items;
    private int level;
    private final int levelNotPassedColor;
    private final int levelPassedColor;
    private int levelProgress;
    private final Function0<Unit> onBuyLevel;
    private final Function2<Boolean, Integer, Unit> onClaimItem;
    private final Function0<Unit> onQuality;
    private final Function0<Unit> repeatBP;

    /* JADX WARN: Multi-variable type inference failed */
    public LevelItemsAdapter(int i, int i2, Function0<Unit> onBuyLevel, Function0<Unit> onQuality, Function2<? super Boolean, ? super Integer, Unit> onClaimItem, Function0<Unit> repeatBP) {
        Intrinsics.checkNotNullParameter(onBuyLevel, "onBuyLevel");
        Intrinsics.checkNotNullParameter(onQuality, "onQuality");
        Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
        Intrinsics.checkNotNullParameter(repeatBP, "repeatBP");
        this.levelPassedColor = i;
        this.levelNotPassedColor = i2;
        this.onBuyLevel = onBuyLevel;
        this.onQuality = onQuality;
        this.onClaimItem = onClaimItem;
        this.repeatBP = repeatBP;
        this.items = new ArrayList();
        this.isArizonaType = true;
    }

    public /* synthetic */ LevelItemsAdapter(int i, int i2, Function0 function0, Function0 function02, Function2 function2, Function0 function03, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, function0, function02, (i3 & 16) != 0 ? new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                ((Boolean) obj).booleanValue();
                ((Integer) obj2).intValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function2, function03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LevelItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LinearLayout root = WinterBattlepassLevelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return new LevelItemViewHolder(this, root, this.onClaimItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LevelItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(i), i, this.level, this.isPrem);
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
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter$LevelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClaimItem", "Lkotlin/Function2;", "", "", "", "<init>", "(Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLevelItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "award", "Lkotlin/Pair;", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", "position", FirebaseAnalytics.Param.LEVEL, "isPrem", "battle-pass"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class LevelItemViewHolder extends RecyclerView.ViewHolder {
        private final WinterBattlepassLevelItemBinding binding;
        private Job loadImageJob;
        private final Function2<Boolean, Integer, Unit> onClaimItem;
        final /* synthetic */ LevelItemsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public LevelItemViewHolder(LevelItemsAdapter levelItemsAdapter, View itemView, Function2<? super Boolean, ? super Integer, Unit> onClaimItem) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
            this.this$0 = levelItemsAdapter;
            this.onClaimItem = onClaimItem;
            WinterBattlepassLevelItemBinding bind = WinterBattlepassLevelItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public /* synthetic */ LevelItemViewHolder(LevelItemsAdapter levelItemsAdapter, View view, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(levelItemsAdapter, view, (i & 2) != 0 ? new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit unit;
                    ((Boolean) obj).booleanValue();
                    ((Integer) obj2).intValue();
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function2);
        }

        public final void bind(Pair<AwardItemData, AwardItemData> award, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(award, "award");
            final AwardItemData second = award.getSecond();
            final AwardItemData first = award.getFirst();
            final int i3 = i + 1;
            Job job = this.loadImageJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            final WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
            final LevelItemsAdapter levelItemsAdapter = this.this$0;
            Integer isVehicle = first.isVehicle();
            if (isVehicle != null && isVehicle.intValue() == 1) {
                winterBattlepassLevelItemBinding.qualityButton.setVisibility(0);
            } else {
                winterBattlepassLevelItemBinding.qualityButton.setVisibility(8);
            }
            Integer isVehicle2 = second.isVehicle();
            if (isVehicle2 != null && isVehicle2.intValue() == 1) {
                winterBattlepassLevelItemBinding.qualityButton1.setVisibility(0);
            } else {
                winterBattlepassLevelItemBinding.qualityButton1.setVisibility(8);
            }
            winterBattlepassLevelItemBinding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$0(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.qualityButton1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$1(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.levelText.setTextColor(-1);
            winterBattlepassLevelItemBinding.levelText.setText(String.valueOf(i3));
            if (i3 < i2) {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(levelItemsAdapter.levelPassedColor);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                winterBattlepassLevelItemBinding.levelText.setTextColor(levelItemsAdapter.levelNotPassedColor);
            } else if (i3 == i2) {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(levelItemsAdapter.levelPassedColor);
                winterBattlepassLevelItemBinding.levelText.setTextColor(levelItemsAdapter.levelNotPassedColor);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelNotPassedColor);
            } else {
                winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(levelItemsAdapter.levelNotPassedColor);
                winterBattlepassLevelItemBinding.levelContainer.setColorFilter(levelItemsAdapter.levelNotPassedColor);
                winterBattlepassLevelItemBinding.levelText.setTextColor(-1);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelNotPassedColor);
            }
            winterBattlepassLevelItemBinding.boost1.setVisibility(8);
            winterBattlepassLevelItemBinding.boost2.setVisibility(8);
            winterBattlepassLevelItemBinding.boost3.setVisibility(8);
            winterBattlepassLevelItemBinding.boost4.setVisibility(8);
            if (i2 == 0 && i3 == 1) {
                winterBattlepassLevelItemBinding.boost1.setVisibility(0);
            }
            winterBattlepassLevelItemBinding.boost1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$2(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$3(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$4(LevelItemsAdapter.this, view);
                }
            });
            winterBattlepassLevelItemBinding.boost4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$5(LevelItemsAdapter.this, view);
                }
            });
            if (i2 < 100) {
                if (i3 == i2) {
                    int i4 = levelItemsAdapter.levelProgress;
                    if (i4 >= 0 && i4 < 6) {
                        winterBattlepassLevelItemBinding.boost4.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelNotPassedColor);
                    } else if (6 > i4 || i4 >= 11) {
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                    } else {
                        winterBattlepassLevelItemBinding.boost2.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                    }
                }
                if (i3 == i2 + 1) {
                    int i5 = levelItemsAdapter.levelProgress;
                    if (11 <= i5 && i5 < 21) {
                        winterBattlepassLevelItemBinding.boost1.setVisibility(0);
                    } else if (16 <= i5 && i5 < 21) {
                        winterBattlepassLevelItemBinding.boost3.setVisibility(0);
                        winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
                    }
                }
            }
            winterBattlepassLevelItemBinding.itemLevelNamePremium.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, second.getTitle(), 0.0f, 1, null));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemsAdapter$LevelItemViewHolder$bind$1$7(winterBattlepassLevelItemBinding, levelItemsAdapter, second, this, null), 3, null);
            winterBattlepassLevelItemBinding.itemLevelNameUsually.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, first.getTitle(), 0.0f, 1, null));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemsAdapter$LevelItemViewHolder$bind$1$8(winterBattlepassLevelItemBinding, levelItemsAdapter, first, this, null), 3, null);
            if (second.getCount() > 0 && !levelItemsAdapter.isArizonaType) {
                CustomCardView premiumContainerCount = winterBattlepassLevelItemBinding.premiumContainerCount;
                Intrinsics.checkNotNullExpressionValue(premiumContainerCount, "premiumContainerCount");
                premiumContainerCount.setVisibility(0);
                winterBattlepassLevelItemBinding.tvPremiumCount.setText(second.getCount() + " шт.");
            } else {
                CustomCardView premiumContainerCount2 = winterBattlepassLevelItemBinding.premiumContainerCount;
                Intrinsics.checkNotNullExpressionValue(premiumContainerCount2, "premiumContainerCount");
                premiumContainerCount2.setVisibility(8);
            }
            if (first.getCount() > 0 && !levelItemsAdapter.isArizonaType) {
                CustomCardView usuallyCountContainer = winterBattlepassLevelItemBinding.usuallyCountContainer;
                Intrinsics.checkNotNullExpressionValue(usuallyCountContainer, "usuallyCountContainer");
                usuallyCountContainer.setVisibility(0);
                winterBattlepassLevelItemBinding.tvUsuallyCount.setText(first.getCount() + " шт.");
            } else {
                CustomCardView usuallyCountContainer2 = winterBattlepassLevelItemBinding.usuallyCountContainer;
                Intrinsics.checkNotNullExpressionValue(usuallyCountContainer2, "usuallyCountContainer");
                usuallyCountContainer2.setVisibility(8);
            }
            if (second.isAvailable() && i3 <= i2 && z) {
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setImageResource(R.drawable.battlepass_2025_btn_get_item_pass_premium);
                winterBattlepassLevelItemBinding.itemLevelBackgroundPremium.setVisibility(4);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$6(WinterBattlepassLevelItemBinding.this, second, this, i3, view);
                    }
                });
            } else if (i3 > i2 || !z) {
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBackgroundPremium.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setImageResource(R.drawable.battlepass_2025_ic_battlepass_lock_premium);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(null);
            } else {
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBackgroundPremium.setVisibility(4);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setImageResource(R.drawable.ic_battlepass_award_received);
                winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(null);
            }
            if (first.isAvailable() && i3 <= i2) {
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBackgroundUsual.setVisibility(4);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setImageResource(R.drawable.battlepass_2025_btn_get_item_pass_red);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$7(WinterBattlepassLevelItemBinding.this, first, this, i3, view);
                    }
                });
            } else if (i3 > i2) {
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBackgroundUsual.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setImageResource(R.drawable.ic_battlepass_lock);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(null);
            } else {
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(0);
                winterBattlepassLevelItemBinding.itemLevelBackgroundUsual.setVisibility(4);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setImageResource(R.drawable.ic_battlepass_award_received);
                winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(null);
            }
            if (Intrinsics.areEqual(second.getSysName(), "-1")) {
                winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(4);
            } else {
                winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(0);
            }
            if (Intrinsics.areEqual(first.getSysName(), " -1")) {
                winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(4);
            } else {
                winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(0);
            }
            if (i2 >= i3 && i3 == levelItemsAdapter.items.size()) {
                winterBattlepassLevelItemBinding.boost2.setBackgroundResource(R.drawable.bp_reapet);
                winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(levelItemsAdapter.levelPassedColor);
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
                    LevelItemsAdapter.LevelItemViewHolder.bind$lambda$0$8(LevelItemsAdapter.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$0(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onQuality.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$1(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onQuality.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$2(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$3(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$4(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$5(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.onBuyLevel.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$6(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
            winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(4);
            awardItemData.setWasClicked(true);
            levelItemViewHolder.onClaimItem.invoke(true, Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$7(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
            winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(4);
            awardItemData.setWasClicked(true);
            levelItemViewHolder.onClaimItem.invoke(false, Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$8(LevelItemsAdapter levelItemsAdapter, View view) {
            levelItemsAdapter.repeatBP.invoke();
        }
    }
}

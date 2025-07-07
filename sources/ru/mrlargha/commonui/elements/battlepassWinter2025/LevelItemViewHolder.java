package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.graphics.Color;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassLevelItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.AwardItemData;
/* compiled from: LevelItemsAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ2\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/LevelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClaimItem", "Lkotlin/Function2;", "", "", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "levelPassedColor", "levelNotPassedColor", "binding", "Lru/mrlargha/commonui/databinding/WinterBattlepassLevelItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "award", "Lkotlin/Pair;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/AwardItemData;", "position", FirebaseAnalytics.Param.LEVEL, "isPrem", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LevelItemViewHolder extends RecyclerView.ViewHolder {
    private final WinterBattlepassLevelItemBinding binding;
    private final int levelNotPassedColor;
    private final int levelPassedColor;
    private Job loadImageJob;
    private final Function2<Boolean, Integer, Unit> onClaimItem;

    public /* synthetic */ LevelItemViewHolder(View view, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.LevelItemViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = LevelItemViewHolder._init_$lambda$0(((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(boolean z, int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LevelItemViewHolder(View itemView, Function2<? super Boolean, ? super Integer, Unit> onClaimItem) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
        this.onClaimItem = onClaimItem;
        this.levelPassedColor = Color.parseColor("#EB8BD3");
        this.levelNotPassedColor = Color.parseColor("#462E3D");
        WinterBattlepassLevelItemBinding bind = WinterBattlepassLevelItemBinding.bind(itemView);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final void bind(Pair<AwardItemData, AwardItemData> award, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(award, "award");
        final AwardItemData second = award.getSecond();
        final AwardItemData first = award.getFirst();
        final int i3 = i + 1;
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        final WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding = this.binding;
        winterBattlepassLevelItemBinding.levelText.setTextColor(-1);
        winterBattlepassLevelItemBinding.levelText.setText(String.valueOf(i3));
        if (i3 < i2) {
            winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(this.levelPassedColor);
            winterBattlepassLevelItemBinding.levelContainer.setColorFilter(this.levelPassedColor);
            winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(this.levelPassedColor);
        } else if (i3 == i2) {
            winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(this.levelPassedColor);
            winterBattlepassLevelItemBinding.levelContainer.setColorFilter(this.levelPassedColor);
            winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(this.levelNotPassedColor);
        } else {
            winterBattlepassLevelItemBinding.viewBeforeLevel.setBackgroundColor(this.levelNotPassedColor);
            winterBattlepassLevelItemBinding.levelContainer.setColorFilter(this.levelNotPassedColor);
            winterBattlepassLevelItemBinding.viewAfterLevel.setBackgroundColor(this.levelNotPassedColor);
        }
        winterBattlepassLevelItemBinding.itemLevelNamePremium.setText(second.getTitle());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemViewHolder$bind$1$1(winterBattlepassLevelItemBinding, this, second, null), 3, null);
        winterBattlepassLevelItemBinding.itemLevelNameUsually.setText(first.getTitle());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LevelItemViewHolder$bind$1$2(winterBattlepassLevelItemBinding, this, first, null), 3, null);
        if (second.isAvailable() && i3 <= i2 && z) {
            winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(0);
            winterBattlepassLevelItemBinding.itemLevelBtnPremium.setImageResource(R.drawable.battlepass_2025_btn_get_item_pass_premium);
            winterBattlepassLevelItemBinding.itemLevelBackgroundPremium.setVisibility(4);
            winterBattlepassLevelItemBinding.itemLevelBtnPremium.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.LevelItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemViewHolder.bind$lambda$3$lambda$1(WinterBattlepassLevelItemBinding.this, second, this, i3, view);
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
            winterBattlepassLevelItemBinding.itemLevelBtnUsually.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.LevelItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemViewHolder.bind$lambda$3$lambda$2(WinterBattlepassLevelItemBinding.this, first, this, i3, view);
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
        if (second.getSysName() == -1) {
            winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(4);
        } else {
            winterBattlepassLevelItemBinding.itemLevelPremiumContainer.setVisibility(0);
        }
        if (first.getSysName() == -1) {
            winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(4);
        } else {
            winterBattlepassLevelItemBinding.itemLevelUsuallyContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3$lambda$1(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
        winterBattlepassLevelItemBinding.itemLevelBtnPremium.setVisibility(4);
        awardItemData.setWasClicked(true);
        levelItemViewHolder.onClaimItem.invoke(true, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3$lambda$2(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
        winterBattlepassLevelItemBinding.itemLevelBtnUsually.setVisibility(4);
        awardItemData.setWasClicked(true);
        levelItemViewHolder.onClaimItem.invoke(false, Integer.valueOf(i));
    }
}

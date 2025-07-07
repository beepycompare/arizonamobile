package ru.mrlargha.commonui.elements.easter.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.EasterBattlePassAwardItemBinding;
import ru.mrlargha.commonui.elements.easter.data.AwardItemData;
/* compiled from: AwardsAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J$\u0010\u0017\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0007R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/AwardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/easter/adapters/LevelItemViewHolder;", "onClaimItem", "Lkotlin/Function2;", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/easter/data/AwardItemData;", FirebaseAnalytics.Param.LEVEL, "isArizonaType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setData", "", "isArisona", "clearItems", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AwardsAdapter extends RecyclerView.Adapter<LevelItemViewHolder> {
    private boolean isArizonaType;
    private final List<AwardItemData> items;
    private int level;
    private final Function2<Boolean, Integer, Unit> onClaimItem;

    public AwardsAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ AwardsAdapter(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.easter.adapters.AwardsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = AwardsAdapter._init_$lambda$0(((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(boolean z, int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwardsAdapter(Function2<? super Boolean, ? super Integer, Unit> onClaimItem) {
        Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
        this.onClaimItem = onClaimItem;
        this.items = new ArrayList();
        this.isArizonaType = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LevelItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LinearLayout root = EasterBattlePassAwardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return new LevelItemViewHolder(root, this.onClaimItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LevelItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(i), i, this.level, this.isArizonaType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setData(List<AwardItemData> items, int i, boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new LevelItemsAdapterDiffUtil(this.items, items));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(...)");
        this.items.clear();
        List<AwardItemData> list = this.items;
        List<AwardItemData> list2 = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AwardItemData awardItemData : list2) {
            arrayList.add(AwardItemData.copy$default(awardItemData, 0, null, 0, 0, false, false, 63, null));
        }
        list.addAll(arrayList);
        if (this.level != i) {
            this.level = i;
            this.isArizonaType = z;
            notifyDataSetChanged();
            return;
        }
        this.level = i;
        this.isArizonaType = z;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public final void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }
}

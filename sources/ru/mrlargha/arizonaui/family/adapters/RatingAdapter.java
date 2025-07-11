package ru.mrlargha.arizonaui.family.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyRatingItemBinding;
import ru.mrlargha.arizonaui.family.data.FlagsKt;
import ru.mrlargha.arizonaui.family.data.RatingItem;
/* compiled from: RatingAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bJ\u0014\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%J\u000e\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/RatingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/RatingItemViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/family/data/RatingItem;", "", "onScrollFinish", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "selectedItem", "isRequestSend", "", "page", "getPage", "()I", "setPage", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "color", "colorSel", "onBindViewHolder", "holder", "position", "getItemCount", "setSelectedItem", "int", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "getTop", "name", "", "clearList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RatingAdapter extends RecyclerView.Adapter<RatingItemViewHolder> {
    private final int color;
    private final int colorSel;
    private boolean isRequestSend;
    private final List<RatingItem> itemsList;
    private final Function1<RatingItem, Unit> onClick;
    private final Function1<Integer, Unit> onScrollFinish;
    private int page;
    private int selectedItem;

    /* JADX WARN: Multi-variable type inference failed */
    public RatingAdapter(Function1<? super RatingItem, Unit> onClick, Function1<? super Integer, Unit> onScrollFinish) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onScrollFinish, "onScrollFinish");
        this.onClick = onClick;
        this.onScrollFinish = onScrollFinish;
        this.itemsList = new ArrayList();
        this.page = 1;
        this.color = Color.parseColor("#1A2029");
        this.colorSel = Color.parseColor("#455162");
    }

    public final List<RatingItem> getItemsList() {
        return this.itemsList;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RatingItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_rating_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RatingItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RatingItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final RatingItem ratingItem = (RatingItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (ratingItem == null) {
            ratingItem = (RatingItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        FamilyRatingItemBinding binding = holder.getBinding();
        binding.topImage.setVisibility(0);
        int i2 = i + 1;
        if (i2 == 1) {
            binding.topImage.setImageResource(R.drawable.family_rv_ic_top1);
        } else if (i2 == 2) {
            binding.topImage.setImageResource(R.drawable.family_rv_ic_top2);
        } else if (i2 == 3) {
            binding.topImage.setImageResource(R.drawable.family_rv_ic_top3);
        } else {
            binding.topImage.setVisibility(4);
        }
        binding.top.setText(String.valueOf(i2));
        binding.title.setText(ratingItem.getName());
        binding.lvl.setText(String.valueOf(ratingItem.getLevel()));
        binding.members.setText(String.valueOf(ratingItem.getMemberCount()));
        binding.leader.setText(ratingItem.getLeader());
        binding.flag.setImageResource(FlagsKt.familyFlag(ratingItem.getFlagId()));
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.RatingAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RatingAdapter.onBindViewHolder$lambda$1$lambda$0(RatingAdapter.this, ratingItem, view);
            }
        });
        if (i2 != this.itemsList.size() || this.isRequestSend || i <= 20) {
            return;
        }
        this.isRequestSend = true;
        int i3 = this.page + 1;
        this.page = i3;
        this.onScrollFinish.invoke(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(RatingAdapter ratingAdapter, RatingItem ratingItem, View view) {
        ratingAdapter.onClick.invoke(ratingItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void setSelectedItem(int i) {
        this.selectedItem = i;
        notifyDataSetChanged();
    }

    public final void addAllItems(List<RatingItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RatingAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final int getTop(String name) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = this.itemsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((RatingItem) obj).getName(), name)) {
                break;
            }
        }
        RatingItem ratingItem = (RatingItem) obj;
        if (ratingItem != null) {
            return this.itemsList.indexOf(ratingItem);
        }
        return -1;
    }

    public final void clearList() {
        this.page = 1;
        this.isRequestSend = false;
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}

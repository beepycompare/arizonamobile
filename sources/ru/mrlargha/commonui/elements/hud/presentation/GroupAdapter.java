package ru.mrlargha.commonui.elements.hud.presentation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudGroupItemBinding;
import ru.mrlargha.commonui.elements.hud.presentation.models.GroupItem;
/* compiled from: GroupAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0011J\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/GroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/hud/presentation/GroupViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "deleteItem", "id", "updateList", "list", "addItem", "item", "clearList", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {
    private final List<GroupItem> itemsList;
    private final Function1<GroupItem, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupAdapter(Function1<? super GroupItem, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.itemsList = new ArrayList();
    }

    public final List<GroupItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hud_group_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GroupViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GroupViewHolder holder, int i) {
        ImageView imageView;
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GroupItem groupItem = (GroupItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (groupItem == null) {
            groupItem = (GroupItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        HudGroupItemBinding binding = holder.getBinding();
        if (groupItem.getId() == 0) {
            imageView = binding.itemImage;
            i2 = 0;
        } else {
            imageView = binding.itemImage;
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Integer health = groupItem.getHealth();
        if (health != null) {
            health.intValue();
            if (groupItem.getHealth().intValue() <= 0) {
                binding.hpContainer.setAlpha(0.5f);
            } else {
                binding.hpContainer.setAlpha(1.0f);
            }
            if (groupItem.getHealth().intValue() <= 25) {
                binding.hp.setTextColor(Color.parseColor("#FF1D38"));
            } else {
                binding.hp.setTextColor(-1);
            }
        }
        Integer armor = groupItem.getArmor();
        if (armor != null) {
            armor.intValue();
            if (groupItem.getArmor().intValue() <= 0) {
                binding.defContainer.setAlpha(0.5f);
            } else {
                binding.defContainer.setAlpha(1.0f);
            }
        }
        binding.hp.setText(String.valueOf(groupItem.getHealth()));
        binding.name.setText(groupItem.getName());
        binding.def.setText(String.valueOf(groupItem.getArmor()));
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.GroupAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAdapter.onBindViewHolder$lambda$3$lambda$2(GroupAdapter.this, groupItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(GroupAdapter groupAdapter, GroupItem groupItem, View view) {
        groupAdapter.onClick.invoke(groupItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<GroupItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new GroupAdapter$addAllItems$1(this, items, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteItem$lambda$4(int i, GroupItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteItem$lambda$5(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void deleteItem(final int i) {
        List<GroupItem> list = this.itemsList;
        final Function1 function1 = new Function1() { // from class: ru.mrlargha.commonui.elements.hud.presentation.GroupAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean deleteItem$lambda$4;
                deleteItem$lambda$4 = GroupAdapter.deleteItem$lambda$4(i, (GroupItem) obj);
                return Boolean.valueOf(deleteItem$lambda$4);
            }
        };
        list.removeIf(new Predicate() { // from class: ru.mrlargha.commonui.elements.hud.presentation.GroupAdapter$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean deleteItem$lambda$5;
                deleteItem$lambda$5 = GroupAdapter.deleteItem$lambda$5(Function1.this, obj);
                return deleteItem$lambda$5;
            }
        });
        notifyDataSetChanged();
    }

    public final void updateList(List<GroupItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        for (GroupItem groupItem : list) {
            Iterator<GroupItem> it = this.itemsList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getId() == groupItem.getId()) {
                    break;
                } else {
                    i++;
                }
            }
            GroupItem groupItem2 = (GroupItem) CollectionsKt.getOrNull(this.itemsList, i);
            GroupItem updateWith = groupItem2 != null ? GroupAdapterKt.updateWith(groupItem2, groupItem) : null;
            if (updateWith != null) {
                this.itemsList.remove(i);
                this.itemsList.add(i, updateWith);
            }
        }
        notifyDataSetChanged();
    }

    public final void addItem(GroupItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.itemsList.add(item);
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}

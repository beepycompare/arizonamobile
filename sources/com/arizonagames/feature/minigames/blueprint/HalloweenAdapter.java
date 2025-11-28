package com.arizonagames.feature.minigames.blueprint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintHalloweenItemBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
/* compiled from: HalloweenAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0006\u0010\u0013\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizonagames/feature/minigames/blueprint/HalloweenAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function0;", "", "onClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "itemsList", "", "", "getItemsList", "()Ljava/util/List;", "toPress", "onBindViewHolder", "holder", "position", "nestPress", "clearList", "addItems", "infoList", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "blueprint_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HalloweenAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Integer> itemsList;
    private final Function0<Unit> onClick;
    private final Function0<Unit> onItemClick;
    private int toPress;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$1(View view) {
    }

    public HalloweenAdapter(Function0<Unit> onItemClick, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onItemClick = onItemClick;
        this.onClick = onClick;
        this.itemsList = new ArrayList();
        this.toPress = -1;
    }

    public final List<Integer> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.itemsList, i);
        if (num != null) {
            int intValue = num.intValue();
            Iterator<T> it = HalloweeenKt.getHalloweenList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((HalloweenObject) obj).getId() == intValue) {
                    break;
                }
            }
            final HalloweenObject halloweenObject = (HalloweenObject) obj;
            if (halloweenObject == null) {
                return;
            }
            BlueprintHalloweenItemBinding binding = holder.getBinding();
            if (halloweenObject.isPressed()) {
                binding.image.setImageResource(halloweenObject.getPressedImg());
            } else {
                binding.image.setImageResource(halloweenObject.getNotPressedImg());
            }
            if (halloweenObject.getId() == this.toPress) {
                binding.touch.setVisibility(0);
                binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.blueprint.HalloweenAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HalloweenAdapter.onBindViewHolder$lambda$1$0(HalloweenAdapter.this, halloweenObject, view);
                    }
                });
                return;
            }
            binding.touch.setVisibility(8);
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.blueprint.HalloweenAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HalloweenAdapter.onBindViewHolder$lambda$1$1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$0(HalloweenAdapter halloweenAdapter, HalloweenObject halloweenObject, View view) {
        halloweenAdapter.onItemClick.invoke();
        halloweenObject.setPressed(true);
        halloweenAdapter.nestPress();
    }

    private final void nestPress() {
        this.toPress = -1;
        notifyDataSetChanged();
        ArrayList arrayList = new ArrayList();
        for (Object obj : HalloweeenKt.getHalloweenList()) {
            if (!((HalloweenObject) obj).isPressed()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            this.onClick.invoke();
            return;
        }
        this.toPress = ((HalloweenObject) CollectionsKt.random(arrayList2, Random.Default)).getId();
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    public final void addItems(List<Integer> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.itemsList.clear();
        for (HalloweenObject halloweenObject : HalloweeenKt.getHalloweenList()) {
            halloweenObject.setPressed(false);
        }
        this.toPress = ((HalloweenObject) CollectionsKt.random(HalloweeenKt.getHalloweenList(), Random.Default)).getId();
        this.itemsList.addAll(infoList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    /* compiled from: HalloweenAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/minigames/blueprint/HalloweenAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/minigames/blueprint/databinding/BlueprintHalloweenItemBinding;", "Lcom/arizonagames/feature/minigames/blueprint/ItemBinding;", "<init>", "(Lcom/arizonagames/feature/minigames/blueprint/databinding/BlueprintHalloweenItemBinding;)V", "getBinding", "()Lcom/arizonagames/feature/minigames/blueprint/databinding/BlueprintHalloweenItemBinding;", "blueprint_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final BlueprintHalloweenItemBinding binding;

        public final BlueprintHalloweenItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BlueprintHalloweenItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BlueprintHalloweenItemBinding inflate = BlueprintHalloweenItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }
}

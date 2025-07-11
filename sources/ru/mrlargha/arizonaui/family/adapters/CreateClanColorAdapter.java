package ru.mrlargha.arizonaui.family.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyCreateColorItemBinding;
import ru.mrlargha.arizonaui.family.data.ColorsKt;
/* compiled from: CreateClanColorAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/CreateClanColorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/CreateClanColorViewHolder;", "<init>", "()V", "selectedColorPos", "", "getSelectedColorPos", "()I", "setSelectedColorPos", "(I)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "clear", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateClanColorAdapter extends RecyclerView.Adapter<CreateClanColorViewHolder> {
    private final List<Integer> itemsList = CollectionsKt.toList(new IntRange(0, 30));
    private int selectedColorPos;

    public final int getSelectedColorPos() {
        return this.selectedColorPos;
    }

    public final void setSelectedColorPos(int i) {
        this.selectedColorPos = i;
    }

    public final List<Integer> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CreateClanColorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_create_color_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CreateClanColorViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CreateClanColorViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        String familyColors = ColorsKt.familyColors(i);
        FamilyCreateColorItemBinding binding = holder.getBinding();
        binding.colorItem.setCardBackgroundColor(Color.parseColor(familyColors));
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.CreateClanColorAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateClanColorAdapter.onBindViewHolder$lambda$1$lambda$0(CreateClanColorAdapter.this, i, view);
            }
        });
        binding.colorItem.setForeground(i == this.selectedColorPos ? ContextCompat.getDrawable(holder.getCntx(), R.drawable.family_create_color_stroke) : null);
        binding.doneArrow.setVisibility(i == this.selectedColorPos ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(CreateClanColorAdapter createClanColorAdapter, int i, View view) {
        createClanColorAdapter.selectedColorPos = i;
        createClanColorAdapter.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void clear() {
        this.selectedColorPos = 0;
        notifyDataSetChanged();
    }
}

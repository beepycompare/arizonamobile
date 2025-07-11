package ru.mrlargha.arizonaui.documents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DocumentsVipLevelItemBinding;
import ru.mrlargha.arizonaui.documents.data.PremiumLevel;
/* compiled from: VipLevelAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0014\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\u0006\u0010\u001a\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/documents/VipLevelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/documents/VipLevelViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "allList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/documents/data/PremiumLevel;", "Lkotlin/collections/ArrayList;", "getAllList", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addElements", "list", "", "clearAllTasksList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VipLevelAdapter extends RecyclerView.Adapter<VipLevelViewHolder> {
    private final ArrayList<PremiumLevel> allList;
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public VipLevelAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.allList = new ArrayList<>();
    }

    public final ArrayList<PremiumLevel> getAllList() {
        return this.allList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VipLevelViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_vip_level_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new VipLevelViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VipLevelViewHolder holder, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        PremiumLevel premiumLevel = this.allList.get(i);
        Intrinsics.checkNotNullExpressionValue(premiumLevel, "get(...)");
        PremiumLevel premiumLevel2 = premiumLevel;
        DocumentsVipLevelItemBinding binding = holder.getBinding();
        binding.documentsVipLevel.setText("Уровень " + (i + 1));
        binding.documentsVipDesc.setText(premiumLevel2.getDesc());
        if (premiumLevel2.getMark() == 1) {
            i2 = R.drawable.documents_vip_ic_checkmark;
        } else {
            i2 = R.drawable.documents_vip_ic_checkmark_empty;
        }
        binding.documentsTransportItemIc.setImageResource(i2);
        binding.documentsVipLevelButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.VipLevelAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipLevelAdapter.onBindViewHolder$lambda$1$lambda$0(VipLevelAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(VipLevelAdapter vipLevelAdapter, int i, View view) {
        vipLevelAdapter.onClick.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allList.size();
    }

    public final void addElements(List<PremiumLevel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.allList.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearAllTasksList() {
        this.allList.clear();
        notifyDataSetChanged();
    }
}

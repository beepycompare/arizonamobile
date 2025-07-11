package ru.mrlargha.arizonaui.documents;

import android.graphics.Color;
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
import ru.mrlargha.arizonaui.databinding.DocumentsVipTypeItemBinding;
import ru.mrlargha.arizonaui.documents.data.VipStatus;
/* compiled from: VipTypeAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0014\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\u0006\u0010\u001a\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/documents/VipTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/documents/VipTypeViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "allList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/documents/data/VipStatus;", "Lkotlin/collections/ArrayList;", "getAllList", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addElements", "list", "", "clearAllTasksList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VipTypeAdapter extends RecyclerView.Adapter<VipTypeViewHolder> {
    private final ArrayList<VipStatus> allList;
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public VipTypeAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.allList = new ArrayList<>();
    }

    public final ArrayList<VipStatus> getAllList() {
        return this.allList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VipTypeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_vip_type_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new VipTypeViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VipTypeViewHolder holder, final int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        VipStatus vipStatus = this.allList.get(i);
        Intrinsics.checkNotNullExpressionValue(vipStatus, "get(...)");
        VipStatus vipStatus2 = vipStatus;
        DocumentsVipTypeItemBinding binding = holder.getBinding();
        String date_vip = vipStatus2.getDate_vip();
        if (date_vip != null && date_vip.length() != 0) {
            binding.documentsVipDescType.setVisibility(0);
            binding.documentsVipDescType.setText(vipStatus2.getDate_vip());
        } else {
            binding.documentsVipDescType.setVisibility(8);
        }
        if (Intrinsics.areEqual(vipStatus2.getType_vip(), "diamond")) {
            i2 = R.drawable.documents_vip_ic_diamondvip;
        } else if (Intrinsics.areEqual(vipStatus2.getType_vip(), "add")) {
            i2 = R.drawable.documents_vip_ic_addvip;
        } else if (Intrinsics.areEqual(vipStatus2.getType_vip(), "premium")) {
            i2 = R.drawable.documents_vip_ic_premvip;
        } else {
            i2 = Intrinsics.areEqual(vipStatus2.getType_vip(), "titan") ? R.drawable.documents_vip_ic_titanvip : R.drawable.documents_vip_ic_addvip;
        }
        if (Intrinsics.areEqual(vipStatus2.getType_vip(), "diamond")) {
            str = "Diamond VIP";
        } else if (Intrinsics.areEqual(vipStatus2.getType_vip(), "add")) {
            str = "ADD VIP";
        } else if (Intrinsics.areEqual(vipStatus2.getType_vip(), "premium")) {
            str = "Premium VIP";
        } else {
            str = Intrinsics.areEqual(vipStatus2.getType_vip(), "titan") ? "Titan Vip" : "VIP";
        }
        binding.documentsTransportItemIc.setImageResource(i2);
        binding.documentsVipTypeTitle.setText(str);
        binding.documentsVipTypeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.VipTypeAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipTypeAdapter.onBindViewHolder$lambda$1$lambda$0(VipTypeAdapter.this, i, view);
            }
        });
        if (vipStatus2.getAvailable() == 1) {
            binding.documentsTransportItemIc.setAlpha(1.0f);
            binding.documentsVipTypeTitle.setTextColor(Color.parseColor("#FFFFFF"));
            return;
        }
        binding.documentsTransportItemIc.setAlpha(0.2f);
        binding.documentsVipTypeTitle.setTextColor(Color.parseColor("#33FFFFFF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(VipTypeAdapter vipTypeAdapter, int i, View view) {
        vipTypeAdapter.onClick.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allList.size();
    }

    public final void addElements(List<VipStatus> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.allList.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearAllTasksList() {
        this.allList.clear();
        notifyDataSetChanged();
    }
}

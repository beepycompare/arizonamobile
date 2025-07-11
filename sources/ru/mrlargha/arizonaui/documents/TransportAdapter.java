package ru.mrlargha.arizonaui.documents;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DocumentsTransportItemBinding;
import ru.mrlargha.arizonaui.documents.data.TransportItem;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: TransportAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0006\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/documents/TransportAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/documents/TransportViewHolder;", "shapeRadius", "", "circleRadius", "<init>", "(FF)V", "allList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/documents/data/TransportItem;", "Lkotlin/collections/ArrayList;", "getAllList", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addElements", "list", "", "clearAllTasksList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransportAdapter extends RecyclerView.Adapter<TransportViewHolder> {
    private final ArrayList<TransportItem> allList = new ArrayList<>();
    private final float circleRadius;
    private final float shapeRadius;

    public TransportAdapter(float f, float f2) {
        this.shapeRadius = f;
        this.circleRadius = f2;
    }

    public final ArrayList<TransportItem> getAllList() {
        return this.allList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TransportViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_transport_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TransportViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TransportViewHolder holder, int i) {
        int parseColor;
        int parseColor2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TransportItem transportItem = this.allList.get(i);
        Intrinsics.checkNotNullExpressionValue(transportItem, "get(...)");
        TransportItem transportItem2 = transportItem;
        DocumentsTransportItemBinding binding = holder.getBinding();
        Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + transportItem2.getImage_url()).into(binding.documentsTransportItemIc);
        String number = transportItem2.getNumber();
        if (number == null || number.length() == 0) {
            binding.documentsTransportItemNumber.setVisibility(8);
        } else {
            binding.documentsTransportItemNumber.setVisibility(0);
            binding.documentsTransportItemNumber.setText(transportItem2.getNumber());
        }
        String cost = transportItem2.getCost();
        if (cost == null || cost.length() == 0) {
            binding.costContainer.setVisibility(8);
        } else {
            binding.costContainer.setVisibility(0);
            binding.documentsTransportItemCost.setText(transportItem2.getCost());
        }
        String milliage = transportItem2.getMilliage();
        if (milliage == null || milliage.length() == 0) {
            binding.milliageContainer.setVisibility(8);
        } else {
            binding.milliageContainer.setVisibility(0);
            binding.documentsTransportItemMilliage.setText(transportItem2.getMilliage());
        }
        String status_text = transportItem2.getStatus_text();
        if (status_text == null || status_text.length() == 0) {
            binding.statusContainer.setVisibility(8);
        } else {
            try {
                parseColor = Color.parseColor(transportItem2.getStatus_color());
            } catch (Exception unused) {
                parseColor = Color.parseColor("#4EB74B");
            }
            try {
                parseColor2 = Color.parseColor("#55" + StringsKt.drop(transportItem2.getStatus_color(), 1));
            } catch (Exception unused2) {
                parseColor2 = Color.parseColor("#554EB74B");
            }
            binding.statusContainer.setVisibility(0);
            binding.documentsTransportCarStatus.setTextColor(parseColor);
            binding.documentsTransportCarStatus.setText(transportItem2.getStatus_text());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(parseColor2);
            gradientDrawable.setCornerRadius(this.shapeRadius);
            binding.statusContainer.setBackground(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(parseColor2);
            float f = this.shapeRadius;
            gradientDrawable2.setSize((int) f, (int) f);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(1);
            gradientDrawable3.setColor(parseColor);
            float f2 = this.shapeRadius;
            float f3 = 2;
            gradientDrawable3.setSize((int) (f2 / f3), (int) (f2 / f3));
            LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable2, gradientDrawable3});
            int i2 = (int) (this.shapeRadius / 4);
            layerDrawable.setLayerInset(1, i2, i2, i2, i2);
            binding.statusImage.setImageDrawable(layerDrawable);
        }
        binding.documentsTransportItemText.setText(transportItem2.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allList.size();
    }

    public final void addElements(List<TransportItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.allList.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearAllTasksList() {
        this.allList.clear();
        notifyDataSetChanged();
    }
}

package ru.mrlargha.feature.mobile.presentation.page.rent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentRealEstateItemBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel;
/* compiled from: ArizonaRentRealEstateAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentRealEstateAdapter;", "Landroid/widget/ArrayAdapter;", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentRealEstateModel;", "context", "Landroid/content/Context;", "items", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getCount", "", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getDropDownView", "initialize", "isEnabled", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentRealEstateAdapter extends ArrayAdapter<ArizonaRentRealEstateModel> {
    private final List<ArizonaRentRealEstateModel> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentRealEstateAdapter(Context context, List<ArizonaRentRealEstateModel> items) {
        super(context, R.layout.mp_arizona_rent_real_estate_item, items);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.items.size() - 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return initialize(parent, i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return initialize(parent, i);
    }

    private final View initialize(ViewGroup viewGroup, int i) {
        MpArizonaRentRealEstateItemBinding inflate = MpArizonaRentRealEstateItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ArizonaRentRealEstateModel arizonaRentRealEstateModel = this.items.get(i);
        inflate.tvRealEstate.setText(arizonaRentRealEstateModel.getName());
        TextView tvPublished = inflate.tvPublished;
        Intrinsics.checkNotNullExpressionValue(tvPublished, "tvPublished");
        tvPublished.setVisibility(arizonaRentRealEstateModel.isPublish() ? 0 : 8);
        if (arizonaRentRealEstateModel.isPublish()) {
            inflate.tvRealEstate.setAlpha(0.6f);
        } else {
            inflate.tvRealEstate.setAlpha(1.0f);
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return !this.items.get(i).isPublish();
    }
}

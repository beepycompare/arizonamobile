package ru.mrlargha.commonui.elements.catalog;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.CatalogItemLayoutBinding;
import ru.mrlargha.commonui.elements.catalog.models.CatalogItemModel;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: CatalogAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/catalog/CatalogItemViewHolder;", "isArizona", "", "onSelectItem", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "", "", "<init>", "(ZLkotlin/jvm/functions/Function2;)V", "catalogItemList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addCatalogItems", "catalogItems", "", "clearCatalogItems", "removeItemById", "id", "selectCatalogItem", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatalogAdapter extends RecyclerView.Adapter<CatalogItemViewHolder> {
    private final ArrayList<CatalogItemModel> catalogItemList;
    private final boolean isArizona;
    private final Function2<CatalogItemModel, Integer, Unit> onSelectItem;

    public /* synthetic */ CatalogAdapter(boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = CatalogAdapter._init_$lambda$0((CatalogItemModel) obj, ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(CatalogItemModel catalogItemModel, int i) {
        Intrinsics.checkNotNullParameter(catalogItemModel, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogAdapter(boolean z, Function2<? super CatalogItemModel, ? super Integer, Unit> onSelectItem) {
        Intrinsics.checkNotNullParameter(onSelectItem, "onSelectItem");
        this.isArizona = z;
        this.onSelectItem = onSelectItem;
        this.catalogItemList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CatalogItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_item_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CatalogItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CatalogItemViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CatalogItemModel catalogItemModel = this.catalogItemList.get(i);
        Intrinsics.checkNotNullExpressionValue(catalogItemModel, "get(...)");
        final CatalogItemModel catalogItemModel2 = catalogItemModel;
        final CatalogItemLayoutBinding binding = holder.getBinding();
        Drawable drawable = ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.bg_catalog_item);
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
            DrawableCompat.setTint(mutate, UtilsKt.getColorTint(catalogItemModel2.getColor()));
            DrawableCompat.setTintMode(mutate, PorterDuff.Mode.SRC_ATOP);
        }
        if (drawable != null) {
            binding.getRoot().setBackground(drawable);
        } else {
            binding.getRoot().setBackgroundResource(R.drawable.bg_catalog_item);
        }
        if (catalogItemModel2.isSelected()) {
            binding.getRoot().setBackgroundResource(R.drawable.bg_catalog_item_selected);
        }
        binding.catalogNameText.setText(catalogItemModel2.getTitle());
        String currency = catalogItemModel2.getCurrency();
        if (currency == null) {
            currency = this.isArizona ? "$" : "₽";
        }
        if (catalogItemModel2.getPrice() > 0) {
            binding.catalogItemPriceText.setVisibility(0);
            binding.catalogItemPriceText.setText(catalogItemModel2.getPrice() + " " + currency);
        } else {
            binding.catalogItemPriceText.setVisibility(8);
        }
        Picasso.get().load((this.isArizona ? FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/donate/" : FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/battlepass/items/") + catalogItemModel2.getImg() + ".webp").error(R.drawable.baseline_warning_24).into(binding.catalogImage, new Callback() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$onBindViewHolder$1$2
            @Override // com.squareup.picasso.Callback
            public void onError(Exception exc) {
            }

            @Override // com.squareup.picasso.Callback
            public void onSuccess() {
                ProgressBar catalogProgressBar = CatalogItemLayoutBinding.this.catalogProgressBar;
                Intrinsics.checkNotNullExpressionValue(catalogProgressBar, "catalogProgressBar");
                catalogProgressBar.setVisibility(8);
                ImageView catalogImage = CatalogItemLayoutBinding.this.catalogImage;
                Intrinsics.checkNotNullExpressionValue(catalogImage, "catalogImage");
                catalogImage.setVisibility(0);
            }
        });
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CatalogAdapter.onBindViewHolder$lambda$3$lambda$2(CatalogAdapter.this, i, catalogItemModel2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(CatalogAdapter catalogAdapter, int i, CatalogItemModel catalogItemModel, View view) {
        int id = catalogAdapter.isArizona ? i : catalogItemModel.getId();
        catalogAdapter.selectCatalogItem(i);
        catalogAdapter.onSelectItem.invoke(catalogItemModel, Integer.valueOf(id));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.catalogItemList.size();
    }

    public final void addCatalogItems(List<CatalogItemModel> catalogItems) {
        Intrinsics.checkNotNullParameter(catalogItems, "catalogItems");
        this.catalogItemList.addAll(catalogItems);
        notifyDataSetChanged();
    }

    public final void clearCatalogItems() {
        this.catalogItemList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeItemById$lambda$4(int i, CatalogItemModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() == i;
    }

    public final boolean removeItemById(final int i) {
        boolean removeAll = CollectionsKt.removeAll((List) this.catalogItemList, new Function1() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean removeItemById$lambda$4;
                removeItemById$lambda$4 = CatalogAdapter.removeItemById$lambda$4(i, (CatalogItemModel) obj);
                return Boolean.valueOf(removeItemById$lambda$4);
            }
        });
        notifyDataSetChanged();
        return removeAll;
    }

    public final void selectCatalogItem(int i) {
        for (CatalogItemModel catalogItemModel : this.catalogItemList) {
            catalogItemModel.setSelected(false);
        }
        try {
            this.catalogItemList.get(i).setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyDataSetChanged();
    }
}

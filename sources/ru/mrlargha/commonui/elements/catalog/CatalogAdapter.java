package ru.mrlargha.commonui.elements.catalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
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
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.CatalogItemLayoutBinding;
import ru.mrlargha.commonui.elements.catalog.models.CatalogItemModel;
import ru.mrlargha.commonui.elements.hud.presentation.UtilsKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: CatalogAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u001a\b\u0001\u0010\u0013\u001a\u00020\u0006:\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0014\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0014\u0010\u001b\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/catalog/CatalogItemViewHolder;", "onSelectItem", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "catalogItemList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Landroid/annotation/SuppressLint;", "value", "RecyclerView", "getItemCount", "setSearchItems", "catalogItems", "", "addCatalogItems", "clearCatalogItems", "removeItemById", "", "id", "selectCatalogItem", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogAdapter extends RecyclerView.Adapter<CatalogItemViewHolder> {
    private final ArrayList<CatalogItemModel> catalogItemList;
    private final Function2<CatalogItemModel, Integer, Unit> onSelectItem;

    public CatalogAdapter() {
        this(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$2(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogAdapter(Function2<? super CatalogItemModel, ? super Integer, Unit> onSelectItem) {
        Intrinsics.checkNotNullParameter(onSelectItem, "onSelectItem");
        this.onSelectItem = onSelectItem;
        this.catalogItemList = new ArrayList<>();
    }

    public /* synthetic */ CatalogAdapter(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CatalogAdapter._init_$lambda$0((CatalogItemModel) obj, ((Integer) obj2).intValue());
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(CatalogItemModel catalogItemModel, int i) {
        Intrinsics.checkNotNullParameter(catalogItemModel, "<unused var>");
        return Unit.INSTANCE;
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
        Integer color;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CatalogItemModel catalogItemModel = this.catalogItemList.get(i);
        Intrinsics.checkNotNullExpressionValue(catalogItemModel, "get(...)");
        final CatalogItemModel catalogItemModel2 = catalogItemModel;
        final CatalogItemLayoutBinding binding = holder.getBinding();
        if (catalogItemModel2.getColor() != null && ((color = catalogItemModel2.getColor()) == null || color.intValue() != -1)) {
            binding.getRoot().setBackground(UtilsKt.toRgb(catalogItemModel2.getColor().intValue()));
        } else {
            binding.getRoot().setBackground(-1);
        }
        if (catalogItemModel2.isSelected()) {
            binding.getRoot().setBackgroundAlpha(30);
        } else {
            binding.getRoot().setBackgroundAlpha(15);
        }
        binding.catalogNameText.setText(catalogItemModel2.getTitle());
        String currency = catalogItemModel2.getCurrency();
        if (currency == null) {
            currency = ru.mrlargha.commonui.utils.UtilsKt.isArizonaType() ? "" : "₽";
        }
        if (catalogItemModel2.getPrice() > 0) {
            binding.catalogItemPriceText.setVisibility(0);
            binding.catalogItemPriceText.setText((ru.mrlargha.commonui.utils.UtilsKt.isArizonaType() && StringsKt.isBlank(currency)) ? MoneyElementKt.toMoneyFormattedSpannable$default(catalogItemModel2.getPrice(), false, null, null, null, 15, null) : catalogItemModel2.getPrice() + " " + currency);
        } else {
            binding.catalogItemPriceText.setVisibility(8);
        }
        if (ru.mrlargha.commonui.utils.UtilsKt.isArizonaType()) {
            Picasso.get().load((FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "assets/images/donate/") + catalogItemModel2.getImg() + ".webp").error(R.drawable.baseline_warning_24).into(binding.catalogImage, new Callback() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$onBindViewHolder$1$1
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
        } else {
            String str = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + (catalogItemModel2.getUrl() != null ? catalogItemModel2.getUrl() : "systems/battlepass/items/");
            if (StringsKt.contains$default((CharSequence) catalogItemModel2.getImg(), (CharSequence) ".gif", false, 2, (Object) null)) {
                ImageView catalogImage = binding.catalogImage;
                Intrinsics.checkNotNullExpressionValue(catalogImage, "catalogImage");
                ru.mrlargha.commonui.utils.UtilsKt.gifLoadFromCdn$default(catalogImage, str, null, 2, null);
                ProgressBar catalogProgressBar = binding.catalogProgressBar;
                Intrinsics.checkNotNullExpressionValue(catalogProgressBar, "catalogProgressBar");
                catalogProgressBar.setVisibility(8);
                ImageView catalogImage2 = binding.catalogImage;
                Intrinsics.checkNotNullExpressionValue(catalogImage2, "catalogImage");
                catalogImage2.setVisibility(0);
            } else {
                Picasso.get().load(str + catalogItemModel2.getImg()).error(R.drawable.baseline_warning_24).into(binding.catalogImage, new Callback() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$onBindViewHolder$1$2
                    @Override // com.squareup.picasso.Callback
                    public void onError(Exception exc) {
                    }

                    @Override // com.squareup.picasso.Callback
                    public void onSuccess() {
                        ProgressBar catalogProgressBar2 = CatalogItemLayoutBinding.this.catalogProgressBar;
                        Intrinsics.checkNotNullExpressionValue(catalogProgressBar2, "catalogProgressBar");
                        catalogProgressBar2.setVisibility(8);
                        ImageView catalogImage3 = CatalogItemLayoutBinding.this.catalogImage;
                        Intrinsics.checkNotNullExpressionValue(catalogImage3, "catalogImage");
                        catalogImage3.setVisibility(0);
                    }
                });
            }
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CatalogAdapter.onBindViewHolder$lambda$0$0(i, catalogItemModel2, this, view);
            }
        });
        String custom_price_str = catalogItemModel2.getCustom_price_str();
        if (custom_price_str != null) {
            binding.catalogItemPriceText.setVisibility(0);
            binding.catalogItemPriceText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, custom_price_str, 0.0f, null, 3, null));
        }
        if (catalogItemModel2.getEmpty()) {
            binding.getRoot().setVisibility(8);
        } else {
            binding.getRoot().setVisibility(0);
        }
        if (catalogItemModel2.getDummy()) {
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CatalogAdapter.onBindViewHolder$lambda$0$2(view);
                }
            });
        }
        binding.brightness.setVisibility(8);
        if (catalogItemModel2.getBrightness() != null) {
            binding.brightness.setVisibility(0);
            binding.brightness.setAlpha(1.0f - catalogItemModel2.getBrightness().floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(int i, CatalogItemModel catalogItemModel, CatalogAdapter catalogAdapter, View view) {
        int id = ru.mrlargha.commonui.utils.UtilsKt.isArizonaType() ? i : catalogItemModel.getId();
        catalogAdapter.selectCatalogItem(i);
        catalogAdapter.onSelectItem.invoke(catalogItemModel, Integer.valueOf(id));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.catalogItemList.size();
    }

    public final void setSearchItems(List<CatalogItemModel> catalogItems) {
        Intrinsics.checkNotNullParameter(catalogItems, "catalogItems");
        this.catalogItemList.clear();
        this.catalogItemList.addAll(catalogItems);
        notifyDataSetChanged();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean removeItemById$lambda$0(int i, CatalogItemModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() == i;
    }

    public final boolean removeItemById(final int i) {
        boolean removeAll = CollectionsKt.removeAll((List) this.catalogItemList, new Function1() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CatalogAdapter.removeItemById$lambda$0(i, (CatalogItemModel) obj));
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

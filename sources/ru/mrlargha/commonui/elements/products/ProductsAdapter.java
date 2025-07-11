package ru.mrlargha.commonui.elements.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ProductsListElementBinding;
import ru.mrlargha.commonui.elements.products.ProductsScreen;
/* compiled from: ProductsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0017J\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/products/ProductsAdapter$ProductsViewHolder;", "isArizonaType", "", "<init>", "(Z)V", "products", "", "Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$ItemsList;", "productSelectedClickListener", "Lru/mrlargha/commonui/elements/products/ProductsAdapter$OnProductSelectedClickListener;", "setOnProductSelectedClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "addProducts", "", "clearProducts", "getItemCount", "OnProductSelectedClickListener", "ProductsViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
    private final boolean isArizonaType;
    private OnProductSelectedClickListener productSelectedClickListener;
    private List<ProductsScreen.Companion.ItemsList> products;

    /* compiled from: ProductsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsAdapter$OnProductSelectedClickListener;", "", "onProductSelectedClickListener", "", "position", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnProductSelectedClickListener {
        void onProductSelectedClickListener(int i);
    }

    public ProductsAdapter() {
        this(false, 1, null);
    }

    public /* synthetic */ ProductsAdapter(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public ProductsAdapter(boolean z) {
        this.isArizonaType = z;
        this.products = new ArrayList();
    }

    public final void setOnProductSelectedClickListener(OnProductSelectedClickListener productSelectedClickListener) {
        Intrinsics.checkNotNullParameter(productSelectedClickListener, "productSelectedClickListener");
        this.productSelectedClickListener = productSelectedClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list_element, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ProductsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ProductsViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ProductsListElementBinding binding = holder.getBinding();
        int i2 = 0;
        for (Object obj : this.products.get(i).getItems()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProductsScreen.Companion.Item item = (ProductsScreen.Companion.Item) obj;
            if (i2 == 0) {
                binding.title1.setText(item.getTitle());
                binding.value1.setText(item.getValue());
            } else if (i2 == 1) {
                binding.title2.setText(item.getTitle());
                binding.value2.setText(item.getValue());
            } else if (i2 == 2) {
                binding.title3.setText(item.getTitle());
                binding.value3.setText(item.getValue());
            } else if (i2 == 3) {
                binding.title4.setText(item.getTitle());
                binding.value4.setText(item.getValue());
            } else if (i2 == 4) {
                binding.title5.setText(item.getTitle());
                binding.value5.setText(item.getValue());
            } else if (i2 == 5) {
                String value = item.getValue();
                if (value == null || value.length() == 0) {
                    binding.title6.setVisibility(8);
                    binding.value6.setVisibility(8);
                } else {
                    binding.title6.setVisibility(0);
                    binding.value6.setVisibility(0);
                    binding.title6.setText(item.getTitle());
                    binding.value6.setText(item.getValue());
                }
            }
            i2 = i3;
        }
        binding.productItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.products.ProductsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductsAdapter.onBindViewHolder$lambda$2$lambda$1(ProductsAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(ProductsAdapter productsAdapter, int i, View view) {
        OnProductSelectedClickListener onProductSelectedClickListener = productsAdapter.productSelectedClickListener;
        if (onProductSelectedClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productSelectedClickListener");
            onProductSelectedClickListener = null;
        }
        onProductSelectedClickListener.onProductSelectedClickListener(i);
    }

    public final void addProducts(List<ProductsScreen.Companion.ItemsList> products) {
        Intrinsics.checkNotNullParameter(products, "products");
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    public final void clearProducts() {
        this.products.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.products.size();
    }

    /* compiled from: ProductsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsAdapter$ProductsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/ProductsListElementBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/ProductsListElementBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ProductsViewHolder extends RecyclerView.ViewHolder {
        private final ProductsListElementBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProductsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            ProductsListElementBinding bind = ProductsListElementBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final ProductsListElementBinding getBinding() {
            return this.binding;
        }
    }
}

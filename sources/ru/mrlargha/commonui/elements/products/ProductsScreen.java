package ru.mrlargha.commonui.elements.products;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.ProductsScreenBinding;
import ru.mrlargha.commonui.elements.products.ProductsAdapter;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ProductsScreen.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/ProductsScreenBinding;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "productsAdapter", "Lru/mrlargha/commonui/elements/products/ProductsAdapter;", "setTitle", "", "title", "", "addItems", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$ItemsList;", "onBackendMessage", "data", "subId", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductsScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final ProductsScreenBinding binding;
    private final ProductsAdapter productsAdapter;
    private final ConstraintLayout screenLayout;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.products_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        ProductsScreenBinding bind = ProductsScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        ProductsAdapter productsAdapter = new ProductsAdapter(sharedPreferences.getBoolean("isArizonaType", false));
        this.productsAdapter = productsAdapter;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.rodinaAuthBtnClose2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.products.ProductsScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ProductsScreen.this, 0, 0, null, 4, null);
            }
        });
        bind.rodinaProductsListRecycler.setAdapter(productsAdapter);
        bind.rodinaProductsListRecycler.setLayoutManager(new LinearLayoutManager(targetActivity, 1, false));
        productsAdapter.setOnProductSelectedClickListener(new ProductsAdapter.OnProductSelectedClickListener() { // from class: ru.mrlargha.commonui.elements.products.ProductsScreen$1$2
            @Override // ru.mrlargha.commonui.elements.products.ProductsAdapter.OnProductSelectedClickListener
            public void onProductSelectedClickListener(int i2) {
                SAMPUIElement.notifyClick$default(ProductsScreen.this, 1, i2, null, 4, null);
            }
        });
    }

    private final void setTitle(String str) {
        this.binding.mainTitle.setText(str);
    }

    private final void addItems(List<Companion.ItemsList> list) {
        this.productsAdapter.addProducts(list);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            this.productsAdapter.clearProducts();
            setTitle(data);
        } else if (i != 1) {
        } else {
            System.out.println((Object) StringKt.toStringJson(MapperKt.toListModel(data, Companion.ItemsList.class)));
            addItems(MapperKt.toListModel(data, Companion.ItemsList.class));
        }
    }

    /* compiled from: ProductsScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion;", "", "<init>", "()V", "ItemsList", "Item", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: ProductsScreen.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$ItemsList;", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$Item;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ItemsList {
            private final List<Item> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsList copy$default(ItemsList itemsList, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsList.items;
                }
                return itemsList.copy(list);
            }

            public final List<Item> component1() {
                return this.items;
            }

            public final ItemsList copy(List<Item> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new ItemsList(items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ItemsList) && Intrinsics.areEqual(this.items, ((ItemsList) obj).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "ItemsList(items=" + this.items + ")";
            }

            public ItemsList(List<Item> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<Item> getItems() {
                return this.items;
            }
        }

        /* compiled from: ProductsScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$Item;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Item {
            private final String title;
            private final String value;

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.title;
                }
                if ((i & 2) != 0) {
                    str2 = item.value;
                }
                return item.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final Item copy(String title, String str) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Item(title, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Item) {
                    Item item = (Item) obj;
                    return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.value, item.value);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.title.hashCode() * 31;
                String str = this.value;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                String str = this.title;
                return "Item(title=" + str + ", value=" + this.value + ")";
            }

            public Item(String title, String str) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.value = str;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }
        }
    }

    /* compiled from: ProductsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ProductsScreen(targetActivity, i);
        }
    }
}

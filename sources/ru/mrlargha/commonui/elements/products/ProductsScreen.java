package ru.mrlargha.commonui.elements.products;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.ProductsScreenBinding;
import ru.mrlargha.commonui.elements.products.ProductsAdapter;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ProductsScreen.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/ProductsScreenBinding;", "productsAdapter", "Lru/mrlargha/commonui/elements/products/ProductsAdapter;", "setTitle", "", "title", "", "addItems", "items", "", "Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$ItemsList;", "onBackendMessageHandled", "data", "subId", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProductsScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final ProductsScreenBinding binding;
    private final ProductsAdapter productsAdapter;
    private final ConstraintLayout screenLayout;

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
        ProductsAdapter productsAdapter = new ProductsAdapter();
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
    public void onBackendMessageHandled(String data, int i) {
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion;", "", "<init>", "()V", "ItemsList", "Item", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: ProductsScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$ItemsList;", "", "items", "", "Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$Item;", "bg_color", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getBg_color", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class ItemsList {
            private final String bg_color;
            private final List<Item> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsList copy$default(ItemsList itemsList, List list, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsList.items;
                }
                if ((i & 2) != 0) {
                    str = itemsList.bg_color;
                }
                return itemsList.copy(list, str);
            }

            public final List<Item> component1() {
                return this.items;
            }

            public final String component2() {
                return this.bg_color;
            }

            public final ItemsList copy(List<Item> items, String str) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new ItemsList(items, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ItemsList) {
                    ItemsList itemsList = (ItemsList) obj;
                    return Intrinsics.areEqual(this.items, itemsList.items) && Intrinsics.areEqual(this.bg_color, itemsList.bg_color);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.items.hashCode() * 31;
                String str = this.bg_color;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                List<Item> list = this.items;
                return "ItemsList(items=" + list + ", bg_color=" + this.bg_color + ")";
            }

            public ItemsList(List<Item> items, String str) {
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
                this.bg_color = str;
            }

            public final String getBg_color() {
                return this.bg_color;
            }

            public final List<Item> getItems() {
                return this.items;
            }
        }

        private Companion() {
        }

        /* compiled from: ProductsScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Companion$Item;", "", "title", "", "value", "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Item {
            private final String color;
            private final String title;
            private final String value;

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.title;
                }
                if ((i & 2) != 0) {
                    str2 = item.value;
                }
                if ((i & 4) != 0) {
                    str3 = item.color;
                }
                return item.copy(str, str2, str3);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final String component3() {
                return this.color;
            }

            public final Item copy(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Item(title, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Item) {
                    Item item = (Item) obj;
                    return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.value, item.value) && Intrinsics.areEqual(this.color, item.color);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.title.hashCode() * 31;
                String str = this.value;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.color;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                String str = this.title;
                String str2 = this.value;
                return "Item(title=" + str + ", value=" + str2 + ", color=" + this.color + ")";
            }

            public Item(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.value = str;
                this.color = str2;
            }

            public final String getColor() {
                return this.color;
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/products/ProductsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.PRODUCTS_SCREEN);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ProductsScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

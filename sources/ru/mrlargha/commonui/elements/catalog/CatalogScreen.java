package ru.mrlargha.commonui.elements.catalog;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.CatalogLayoutBinding;
import ru.mrlargha.commonui.elements.catalog.models.CatalogInfoModel;
import ru.mrlargha.commonui.elements.catalog.models.CatalogItemModel;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "catalogScreen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/CatalogLayoutBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "catalogAdapter", "Lru/mrlargha/commonui/elements/catalog/CatalogAdapter;", "paginationController", "Lru/mrlargha/commonui/elements/catalog/CatalogPaginationController;", "catalogItemList", "", "Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "setupTitleData", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/catalog/models/CatalogInfoModel;", "onBackendMessageHandled", "data", "", "subId", "appendCatalogItems", "removeCatalogItemById", TtmlNode.ATTR_ID, "closeScreen", "setVisibility", "visible", "", "setupPagination", "requestNextPage", "setupListeners", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogScreen extends SAMPUIElement {
    private final CatalogLayoutBinding binding;
    private final CatalogAdapter catalogAdapter;
    private List<CatalogItemModel> catalogItemList;
    private final View catalogScreen;
    private final IBackendNotifier frontendNotifier;
    private final CatalogPaginationController paginationController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View catalogScreen = targetActivity.getLayoutInflater().inflate(R.layout.catalog_layout, (ViewGroup) null);
        this.catalogScreen = catalogScreen;
        CatalogLayoutBinding bind = CatalogLayoutBinding.bind(catalogScreen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        CatalogAdapter catalogAdapter = new CatalogAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CatalogScreen.catalogAdapter$lambda$0(CatalogScreen.this, (CatalogItemModel) obj, ((Integer) obj2).intValue());
            }
        });
        this.catalogAdapter = catalogAdapter;
        this.paginationController = new CatalogPaginationController();
        this.catalogItemList = CollectionsKt.emptyList();
        catalogScreen.setClickable(true);
        Intrinsics.checkNotNullExpressionValue(catalogScreen, "catalogScreen");
        addViewToConstraintLayout(catalogScreen, -1, -1);
        bind.catalogBtnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CatalogScreen.this.closeScreen();
            }
        });
        bind.catalogListRv.setAdapter(catalogAdapter);
        setupListeners();
        setupPagination();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit catalogAdapter$lambda$0(CatalogScreen catalogScreen, CatalogItemModel catalogItemModel, int i) {
        Intrinsics.checkNotNullParameter(catalogItemModel, "<unused var>");
        catalogScreen.notifyClick(0, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    private final void setupTitleData(CatalogInfoModel catalogInfoModel) {
        this.catalogAdapter.setCatalogImageBasePath(catalogInfoModel.getUrl());
        CatalogLayoutBinding catalogLayoutBinding = this.binding;
        catalogLayoutBinding.catalogTitleText.setText(catalogInfoModel.getTitle());
        catalogLayoutBinding.catalogDescText.setText(StringsKt.replace$default(catalogInfoModel.getDesc(), "</br>", "\n", false, 4, (Object) null));
        CustomCardView searchContainer = catalogLayoutBinding.searchContainer;
        Intrinsics.checkNotNullExpressionValue(searchContainer, "searchContainer");
        searchContainer.setVisibility(catalogInfoModel.getSearch() ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setupTitleData((CatalogInfoModel) MapperKt.toModel(data, CatalogInfoModel.class));
        } else if (i == 1) {
            appendCatalogItems(data);
        } else if (i == 2) {
            removeCatalogItemById(Integer.parseInt(data));
        } else if (i != 3) {
        } else {
            this.paginationController.onPageReceived(appendCatalogItems(data));
        }
    }

    private final int appendCatalogItems(String str) {
        List<CatalogItemModel> listModel = MapperKt.toListModel(str, CatalogItemModel.class);
        this.catalogItemList = CollectionsKt.plus((Collection) this.catalogItemList, (Iterable) listModel);
        this.catalogAdapter.addCatalogItems(listModel);
        return listModel.size();
    }

    private final void removeCatalogItemById(int i) {
        if (this.catalogAdapter.removeItemById(i)) {
            return;
        }
        Toast.makeText(getTargetActivity().getApplicationContext(), "Не удалось удалить!", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        CatalogScreen catalogScreen = this;
        SAMPUIElement.notifyClick$default(catalogScreen, 0, 0, null, 4, null);
        this.frontendNotifier.setUIElementVisible(UIElementID.CATALOG.getId(), false);
        getNotifier().requestRemoveUIElement(catalogScreen);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        this.paginationController.reset();
        this.catalogItemList = CollectionsKt.emptyList();
        this.catalogAdapter.clearCatalogItems();
        this.catalogAdapter.setCatalogImageBasePath(null);
    }

    private final void setupPagination() {
        this.binding.catalogListRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$setupPagination$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                if (i2 <= 0) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
                if (gridLayoutManager == null) {
                    return;
                }
                int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                if (gridLayoutManager.getItemCount() <= 0 || findLastVisibleItemPosition < gridLayoutManager.getItemCount() - 1) {
                    return;
                }
                CatalogScreen.this.requestNextPage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestNextPage() {
        Integer requestNextPage = this.paginationController.requestNextPage();
        if (requestNextPage != null) {
            SAMPUIElement.notifyClick$default(this, requestNextPage.intValue(), 3, null, 4, null);
        }
    }

    private final void setupListeners() {
        final CatalogLayoutBinding catalogLayoutBinding = this.binding;
        catalogLayoutBinding.etSearch.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$setupListeners$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                List list;
                ArrayList arrayList;
                CatalogAdapter catalogAdapter;
                String obj;
                String obj2 = (charSequence == null || (obj = charSequence.toString()) == null) ? null : StringsKt.trim((CharSequence) obj).toString();
                if (obj2 == null) {
                    obj2 = "";
                }
                String str = obj2;
                int length = str.length();
                CatalogScreen catalogScreen = CatalogScreen.this;
                if (length == 0) {
                    arrayList = catalogScreen.catalogItemList;
                } else {
                    list = catalogScreen.catalogItemList;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : list) {
                        if (StringsKt.contains((CharSequence) ((CatalogItemModel) obj3).getTitle(), (CharSequence) str, true)) {
                            arrayList2.add(obj3);
                        }
                    }
                    arrayList = arrayList2;
                }
                catalogAdapter = CatalogScreen.this.catalogAdapter;
                catalogAdapter.setSearchItems(arrayList);
            }
        });
        catalogLayoutBinding.etSearch.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = CatalogScreen.setupListeners$lambda$0$0(CatalogLayoutBinding.this, this, view, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupListeners$lambda$0$0(CatalogLayoutBinding catalogLayoutBinding, CatalogScreen catalogScreen, View view, MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() != 1 || (drawable = catalogLayoutBinding.etSearch.getCompoundDrawables()[2]) == null) {
            return false;
        }
        if (motionEvent.getX() >= (catalogLayoutBinding.etSearch.getWidth() - catalogLayoutBinding.etSearch.getPaddingEnd()) - drawable.getBounds().width()) {
            Editable text = catalogLayoutBinding.etSearch.getText();
            if (text != null) {
                text.clear();
            }
            catalogScreen.catalogAdapter.setSearchItems(catalogScreen.catalogItemList);
            return true;
        }
        return false;
    }

    /* compiled from: CatalogScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CATALOG);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CatalogScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

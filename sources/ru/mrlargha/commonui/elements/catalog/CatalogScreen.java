package ru.mrlargha.commonui.elements.catalog;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.CatalogLayoutBinding;
import ru.mrlargha.commonui.elements.catalog.models.CatalogInfoModel;
import ru.mrlargha.commonui.elements.catalog.models.CatalogItemModel;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "catalogScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/CatalogLayoutBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "catalogAdapter", "Lru/mrlargha/commonui/elements/catalog/CatalogAdapter;", "setupTitleData", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/catalog/models/CatalogInfoModel;", "onBackendMessage", "data", "", "subId", "removeCatalogItemById", "id", "closeScreen", "setVisibility", "visible", "", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatalogScreen extends SAMPUIElement {
    private final CatalogLayoutBinding binding;
    private final CatalogAdapter catalogAdapter;
    private final ConstraintLayout catalogScreen;
    private final IBackendNotifier frontendNotifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.catalog_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.catalogScreen = constraintLayout;
        CatalogLayoutBinding bind = CatalogLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        CatalogAdapter catalogAdapter = new CatalogAdapter(targetActivity.getSharedPreferences("flavorType", 0).getBoolean("isArizonaType", false), new Function2() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit catalogAdapter$lambda$0;
                catalogAdapter$lambda$0 = CatalogScreen.catalogAdapter$lambda$0(CatalogScreen.this, (CatalogItemModel) obj, ((Integer) obj2).intValue());
                return catalogAdapter$lambda$0;
            }
        });
        this.catalogAdapter = catalogAdapter;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.catalogBtnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.catalog.CatalogScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CatalogScreen.this.closeScreen();
            }
        });
        bind.catalogListRv.setAdapter(catalogAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit catalogAdapter$lambda$0(CatalogScreen catalogScreen, CatalogItemModel catalogItemModel, int i) {
        Intrinsics.checkNotNullParameter(catalogItemModel, "<unused var>");
        catalogScreen.notifyClick(0, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    private final void setupTitleData(CatalogInfoModel catalogInfoModel) {
        CatalogLayoutBinding catalogLayoutBinding = this.binding;
        catalogLayoutBinding.catalogTitleText.setText(catalogInfoModel.getTitle());
        catalogLayoutBinding.catalogDescText.setText(catalogInfoModel.getDesc());
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setupTitleData((CatalogInfoModel) MapperKt.toModel(data, CatalogInfoModel.class));
        } else if (i == 1) {
            this.catalogAdapter.addCatalogItems(MapperKt.toListModel(data, CatalogItemModel.class));
        } else if (i != 2) {
        } else {
            removeCatalogItemById(Integer.parseInt(data));
        }
    }

    private final void removeCatalogItemById(int i) {
        if (this.catalogAdapter.removeItemById(i)) {
            return;
        }
        Toast.makeText(getTargetActivity(), "Не удалось удалить!", 0).show();
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
        this.catalogAdapter.clearCatalogItems();
    }

    /* compiled from: CatalogScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CatalogScreen(targetActivity, i);
        }
    }
}

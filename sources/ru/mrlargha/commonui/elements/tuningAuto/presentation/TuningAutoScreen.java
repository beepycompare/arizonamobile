package ru.mrlargha.commonui.elements.tuningAuto.presentation;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.LayoutWheelSettingsBinding;
import ru.mrlargha.commonui.databinding.TuningAutoScreenBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.tuningAuto.domain.CategoryComponents;
import ru.mrlargha.commonui.elements.tuningAuto.domain.CategoryInfo;
import ru.mrlargha.commonui.elements.tuningAuto.domain.ClientData;
import ru.mrlargha.commonui.elements.tuningAuto.domain.DashboardProperties;
import ru.mrlargha.commonui.elements.tuningAuto.domain.SelectedColors;
import ru.mrlargha.commonui.elements.tuningAuto.domain.TintedWindows;
import ru.mrlargha.commonui.elements.tuningAuto.domain.UpdateCategory;
import ru.mrlargha.commonui.elements.tuningAuto.domain.UpdateColor;
import ru.mrlargha.commonui.elements.tuningAuto.domain.UpdateComponent;
import ru.mrlargha.commonui.elements.tuningAuto.domain.UpdateDashboard;
import ru.mrlargha.commonui.elements.tuningAuto.domain.UpdateTintedColor;
import ru.mrlargha.commonui.elements.tuningAuto.domain.WheelSettings;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.AutoCharsAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.CategoriesMenuAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.CategoryComponentsAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.SubCategoriesMenuAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.TintedColorAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.TuningSelectColorAdapter;
import ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.UserCartAdapter;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: TuningAutoScreen.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u00108\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u001bH\u0002J\u0016\u0010;\u001a\u00020\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u0002020)H\u0002J\u0016\u0010=\u001a\u00020\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u0002020)H\u0002J\u0010\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010:\u001a\u000202H\u0002J\u0016\u0010@\u001a\u00020\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b0)H\u0002J\b\u0010A\u001a\u00020\u0010H\u0002J\u0018\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006H\u0016J\b\u0010F\u001a\u00020\u0010H\u0002J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\u0016\u0010I\u001a\u00020\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020,0)2\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0018\u0010L\u001a\u00020\u00102\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006H\u0002J\b\u0010M\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020,0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/TuningAutoScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/TuningAutoScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "setVisible", "", "visible", "", "categoriesMenuAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/CategoriesMenuAdapter;", "subCategoriesMenuAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/SubCategoriesMenuAdapter;", "itemComponentsAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/CategoryComponentsAdapter;", "categoryComponentsList", "", "Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryComponents;", "autoCharsAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/AutoCharsAdapter;", "tintSelectColorAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TintedColorAdapter;", "selectFirstColorAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorAdapter;", "selectSecondColorAdapter", "userCartAdapter", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/UserCartAdapter;", "currentPageId", "firstSelectedColorIndex", "secondSelectedColorIndex", "wheelSettings", "", "Lru/mrlargha/commonui/elements/tuningAuto/domain/WheelSettings;", "listAllColors", "Lru/mrlargha/commonui/elements/tuningAuto/domain/SelectedColors;", "cartItems", "selectedCategoryComponent", "listTintedWindows", "Lru/mrlargha/commonui/elements/tuningAuto/domain/TintedWindows;", "categoriesList", "Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryInfo;", "selectedTintColor", "handler", "Landroid/os/Handler;", "selectedSubCategory", "unselectTintColorList", "initAdapters", "setTintedWindowInfo", "item", "initMenuCategories", "list", "initSubMenuCategories", "additionalInfoUiVisibility", "showProperUi", "refreshComponentsList", "initAutoColorAdapter", "onBackendMessage", "data", "", "subId", "resetAllValues", "cartUiVisibility", "showCartListUi", "updateWheelSettings", "updateSelectColorIndex", "itemIndex", "sendData", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TuningAutoScreen extends SAMPUIElement implements InterfaceController {
    private final AutoCharsAdapter autoCharsAdapter;
    private final TuningAutoScreenBinding binding;
    private List<CategoryComponents> cartItems;
    private List<CategoryInfo> categoriesList;
    private CategoriesMenuAdapter categoriesMenuAdapter;
    private List<CategoryComponents> categoryComponentsList;
    private int currentPageId;
    private int firstSelectedColorIndex;
    private final IBackendNotifier frontendNotifier;
    private Handler handler;
    private CategoryComponentsAdapter itemComponentsAdapter;
    private final List<SelectedColors> listAllColors;
    private List<TintedWindows> listTintedWindows;
    private final ConstraintLayout screen;
    private int secondSelectedColorIndex;
    private TuningSelectColorAdapter selectFirstColorAdapter;
    private TuningSelectColorAdapter selectSecondColorAdapter;
    private CategoryComponents selectedCategoryComponent;
    private CategoryInfo selectedSubCategory;
    private int selectedTintColor;
    private SubCategoriesMenuAdapter subCategoriesMenuAdapter;
    private TintedColorAdapter tintSelectColorAdapter;
    private List<SelectedColors> unselectTintColorList;
    private final UserCartAdapter userCartAdapter;
    private List<WheelSettings> wheelSettings;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$11(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuningAutoScreen(final Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.tuning_auto_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screen = constraintLayout;
        TuningAutoScreenBinding bind = TuningAutoScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        this.categoryComponentsList = new ArrayList();
        this.autoCharsAdapter = new AutoCharsAdapter();
        this.userCartAdapter = new UserCartAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit userCartAdapter$lambda$0;
                userCartAdapter$lambda$0 = TuningAutoScreen.userCartAdapter$lambda$0(TuningAutoScreen.this, (CategoryComponents) obj);
                return userCartAdapter$lambda$0;
            }
        });
        this.currentPageId = -1;
        this.firstSelectedColorIndex = -1;
        this.secondSelectedColorIndex = -1;
        this.wheelSettings = CollectionsKt.emptyList();
        this.listAllColors = new ArrayList();
        this.cartItems = new ArrayList();
        this.listTintedWindows = new ArrayList();
        this.categoriesList = CollectionsKt.emptyList();
        this.handler = new Handler();
        this.unselectTintColorList = new ArrayList();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.tvClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$1(TuningAutoScreen.this, view);
            }
        });
        bind.btnExit.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$2(TuningAutoScreen.this, view);
            }
        });
        initAdapters();
        bind.btnAddCart.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$3(TuningAutoScreen.this, view);
            }
        });
        bind.tvCartTotal.setText("0");
        bind.selectColorLayout.btnFirstColor.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$4(targetActivity, this, view);
            }
        });
        bind.selectColorLayout.btnSecondColor.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$5(targetActivity, this, view);
            }
        });
        bind.tintSettingsLayout.btnMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$6(TuningAutoScreen.this, view);
            }
        });
        bind.tintSettingsLayout.btnPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$7(TuningAutoScreen.this, view);
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        bind.tintSettingsLayout.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object, java.lang.Integer] */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                Integer id;
                ?? valueOf = Integer.valueOf(Integer.valueOf(i2 / 5).intValue() * 5);
                TuningAutoScreen.this.binding.tintSettingsLayout.tvMiddle.setText(String.valueOf((Object) valueOf));
                if (Intrinsics.areEqual(objectRef.element, (Object) valueOf)) {
                    return;
                }
                TuningAutoScreen tuningAutoScreen = TuningAutoScreen.this;
                CategoryComponents categoryComponents = TuningAutoScreen.this.selectedCategoryComponent;
                tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateTintedColor((categoryComponents == null || (id = categoryComponents.getId()) == null) ? -1 : id.intValue(), TuningAutoScreen.this.selectedTintColor, valueOf.intValue())), 4);
                objectRef.element = valueOf;
            }
        });
        bind.linearCart.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.this.showCartListUi();
            }
        });
        bind.userCartLayout.btnEmptyCart.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$9(TuningAutoScreen.this, view);
            }
        });
        bind.userCartLayout.btnBuyItems.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$10(TuningAutoScreen.this, view);
            }
        });
        bind.bgUserCart.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen._init_$lambda$11(view);
            }
        });
        bind.tvBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.this.cartUiVisibility(false);
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userCartAdapter$lambda$0(TuningAutoScreen tuningAutoScreen, CategoryComponents item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Integer id = item.getId();
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateComponent(id != null ? id.intValue() : 0)), 3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.sendData(StringKt.toStringJson(""), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.sendData(StringKt.toStringJson(""), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(TuningAutoScreen tuningAutoScreen, View view) {
        Integer id;
        CategoryComponents categoryComponents = tuningAutoScreen.selectedCategoryComponent;
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateComponent((categoryComponents == null || (id = categoryComponents.getId()) == null) ? 0 : id.intValue())), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(Activity activity, TuningAutoScreen tuningAutoScreen, View view) {
        view.setBackgroundTintList(ColorStateList.valueOf(activity.getColor(R.color.grey_type2)));
        tuningAutoScreen.binding.selectColorLayout.btnSecondColor.setBackgroundTintList(ColorStateList.valueOf(activity.getColor(R.color.grey_type5)));
        RecyclerView rvFirstColors = tuningAutoScreen.binding.selectColorLayout.rvFirstColors;
        Intrinsics.checkNotNullExpressionValue(rvFirstColors, "rvFirstColors");
        rvFirstColors.setVisibility(0);
        RecyclerView rvSecondColors = tuningAutoScreen.binding.selectColorLayout.rvSecondColors;
        Intrinsics.checkNotNullExpressionValue(rvSecondColors, "rvSecondColors");
        rvSecondColors.setVisibility(8);
        List<SelectedColors> updateSelectColorIndex = tuningAutoScreen.updateSelectColorIndex(tuningAutoScreen.firstSelectedColorIndex);
        TuningSelectColorAdapter tuningSelectColorAdapter = tuningAutoScreen.selectFirstColorAdapter;
        TuningSelectColorAdapter tuningSelectColorAdapter2 = null;
        if (tuningSelectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
            tuningSelectColorAdapter = null;
        }
        tuningSelectColorAdapter.submitList(updateSelectColorIndex);
        TuningSelectColorAdapter tuningSelectColorAdapter3 = tuningAutoScreen.selectFirstColorAdapter;
        if (tuningSelectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
        } else {
            tuningSelectColorAdapter2 = tuningSelectColorAdapter3;
        }
        tuningSelectColorAdapter2.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(Activity activity, TuningAutoScreen tuningAutoScreen, View view) {
        view.setBackgroundTintList(ColorStateList.valueOf(activity.getColor(R.color.grey_type2)));
        tuningAutoScreen.binding.selectColorLayout.btnFirstColor.setBackgroundTintList(ColorStateList.valueOf(activity.getColor(R.color.grey_type5)));
        RecyclerView rvFirstColors = tuningAutoScreen.binding.selectColorLayout.rvFirstColors;
        Intrinsics.checkNotNullExpressionValue(rvFirstColors, "rvFirstColors");
        rvFirstColors.setVisibility(8);
        RecyclerView rvSecondColors = tuningAutoScreen.binding.selectColorLayout.rvSecondColors;
        Intrinsics.checkNotNullExpressionValue(rvSecondColors, "rvSecondColors");
        rvSecondColors.setVisibility(0);
        List<SelectedColors> updateSelectColorIndex = tuningAutoScreen.updateSelectColorIndex(tuningAutoScreen.secondSelectedColorIndex);
        TuningSelectColorAdapter tuningSelectColorAdapter = tuningAutoScreen.selectSecondColorAdapter;
        TuningSelectColorAdapter tuningSelectColorAdapter2 = null;
        if (tuningSelectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
            tuningSelectColorAdapter = null;
        }
        tuningSelectColorAdapter.submitList(updateSelectColorIndex);
        TuningSelectColorAdapter tuningSelectColorAdapter3 = tuningAutoScreen.selectSecondColorAdapter;
        if (tuningSelectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
        } else {
            tuningSelectColorAdapter2 = tuningSelectColorAdapter3;
        }
        tuningSelectColorAdapter2.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.binding.tintSettingsLayout.seekBar.incrementProgressBy(-5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.binding.tintSettingsLayout.seekBar.incrementProgressBy(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.sendData(StringKt.toStringJson(""), 12);
        tuningAutoScreen.cartUiVisibility(false);
        tuningAutoScreen.binding.tvCartTotal.setText("0");
        tuningAutoScreen.binding.tvCartCount.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$10(TuningAutoScreen tuningAutoScreen, View view) {
        tuningAutoScreen.sendData(StringKt.toStringJson(""), 9);
    }

    private final void initAdapters() {
        this.binding.carCharacteristicLayout.rvTuningCharacteristic.setAdapter(this.autoCharsAdapter);
        this.binding.userCartLayout.rvUserCart.setAdapter(this.userCartAdapter);
        this.categoriesMenuAdapter = new CategoriesMenuAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAdapters$lambda$14;
                initAdapters$lambda$14 = TuningAutoScreen.initAdapters$lambda$14(TuningAutoScreen.this, (CategoryInfo) obj, ((Integer) obj2).intValue());
                return initAdapters$lambda$14;
            }
        }, getTargetActivity());
        RecyclerView recyclerView = this.binding.rvMenu;
        CategoriesMenuAdapter categoriesMenuAdapter = this.categoriesMenuAdapter;
        TintedColorAdapter tintedColorAdapter = null;
        if (categoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter = null;
        }
        recyclerView.setAdapter(categoriesMenuAdapter);
        this.subCategoriesMenuAdapter = new SubCategoriesMenuAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAdapters$lambda$16;
                initAdapters$lambda$16 = TuningAutoScreen.initAdapters$lambda$16(TuningAutoScreen.this, (CategoryInfo) obj, ((Integer) obj2).intValue());
                return initAdapters$lambda$16;
            }
        }, getTargetActivity());
        RecyclerView recyclerView2 = this.binding.rvSubMenu;
        SubCategoriesMenuAdapter subCategoriesMenuAdapter = this.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter = null;
        }
        recyclerView2.setAdapter(subCategoriesMenuAdapter);
        this.itemComponentsAdapter = new CategoryComponentsAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAdapters$lambda$18;
                initAdapters$lambda$18 = TuningAutoScreen.initAdapters$lambda$18(TuningAutoScreen.this, (CategoryComponents) obj, ((Integer) obj2).intValue());
                return initAdapters$lambda$18;
            }
        }, getTargetActivity(), new Function1() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initAdapters$lambda$19;
                initAdapters$lambda$19 = TuningAutoScreen.initAdapters$lambda$19(TuningAutoScreen.this, (CategoryComponents) obj);
                return initAdapters$lambda$19;
            }
        });
        RecyclerView recyclerView3 = this.binding.rvCategoryComponents;
        CategoryComponentsAdapter categoryComponentsAdapter = this.itemComponentsAdapter;
        if (categoryComponentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
            categoryComponentsAdapter = null;
        }
        recyclerView3.setAdapter(categoryComponentsAdapter);
        this.tintSelectColorAdapter = new TintedColorAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAdapters$lambda$21;
                initAdapters$lambda$21 = TuningAutoScreen.initAdapters$lambda$21(TuningAutoScreen.this, (SelectedColors) obj, ((Integer) obj2).intValue());
                return initAdapters$lambda$21;
            }
        });
        RecyclerView recyclerView4 = this.binding.tintSettingsLayout.rvColors;
        TintedColorAdapter tintedColorAdapter2 = this.tintSelectColorAdapter;
        if (tintedColorAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
        } else {
            tintedColorAdapter = tintedColorAdapter2;
        }
        recyclerView4.setAdapter(tintedColorAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$14(TuningAutoScreen tuningAutoScreen, CategoryInfo item, int i) {
        Integer id;
        Intrinsics.checkNotNullParameter(item, "item");
        CategoriesMenuAdapter categoriesMenuAdapter = tuningAutoScreen.categoriesMenuAdapter;
        CategoryComponentsAdapter categoryComponentsAdapter = null;
        if (categoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter = null;
        }
        int selectedItemPosition = categoriesMenuAdapter.getSelectedItemPosition();
        CategoriesMenuAdapter categoriesMenuAdapter2 = tuningAutoScreen.categoriesMenuAdapter;
        if (categoriesMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter2 = null;
        }
        categoriesMenuAdapter2.setSelectedItemPosition(i);
        CategoriesMenuAdapter categoriesMenuAdapter3 = tuningAutoScreen.categoriesMenuAdapter;
        if (categoriesMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter3 = null;
        }
        categoriesMenuAdapter3.notifyItemChanged(selectedItemPosition);
        CategoriesMenuAdapter categoriesMenuAdapter4 = tuningAutoScreen.categoriesMenuAdapter;
        if (categoriesMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter4 = null;
        }
        categoriesMenuAdapter4.notifyItemChanged(i);
        SubCategoriesMenuAdapter subCategoriesMenuAdapter = tuningAutoScreen.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter = null;
        }
        subCategoriesMenuAdapter.setSelectedItemPosition(0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : tuningAutoScreen.categoriesList) {
            if (Intrinsics.areEqual(((CategoryInfo) obj).getParentId(), item.getId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        tuningAutoScreen.initSubMenuCategories(arrayList2);
        CategoryInfo categoryInfo = (CategoryInfo) CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        tuningAutoScreen.currentPageId = (categoryInfo == null || (id = categoryInfo.getId()) == null) ? 0 : id.intValue();
        tuningAutoScreen.selectedSubCategory = (CategoryInfo) CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        CategoryComponentsAdapter categoryComponentsAdapter2 = tuningAutoScreen.itemComponentsAdapter;
        if (categoryComponentsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
        } else {
            categoryComponentsAdapter = categoryComponentsAdapter2;
        }
        categoryComponentsAdapter.setSelectedItemPosition(-1);
        tuningAutoScreen.additionalInfoUiVisibility(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$16(TuningAutoScreen tuningAutoScreen, CategoryInfo item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        SubCategoriesMenuAdapter subCategoriesMenuAdapter = tuningAutoScreen.subCategoriesMenuAdapter;
        CategoryComponentsAdapter categoryComponentsAdapter = null;
        if (subCategoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter = null;
        }
        int selectedItemPosition = subCategoriesMenuAdapter.getSelectedItemPosition();
        SubCategoriesMenuAdapter subCategoriesMenuAdapter2 = tuningAutoScreen.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter2 = null;
        }
        subCategoriesMenuAdapter2.setSelectedItemPosition(i);
        SubCategoriesMenuAdapter subCategoriesMenuAdapter3 = tuningAutoScreen.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter3 = null;
        }
        subCategoriesMenuAdapter3.notifyItemChanged(selectedItemPosition);
        SubCategoriesMenuAdapter subCategoriesMenuAdapter4 = tuningAutoScreen.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter4 = null;
        }
        subCategoriesMenuAdapter4.notifyItemChanged(i);
        Integer id = item.getId();
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateCategory(id != null ? id.intValue() : 0)), 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : tuningAutoScreen.categoryComponentsList) {
            if (Intrinsics.areEqual(((CategoryComponents) obj).getCategoryId(), item.getId())) {
                arrayList.add(obj);
            }
        }
        tuningAutoScreen.refreshComponentsList(arrayList);
        CategoryComponentsAdapter categoryComponentsAdapter2 = tuningAutoScreen.itemComponentsAdapter;
        if (categoryComponentsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
        } else {
            categoryComponentsAdapter = categoryComponentsAdapter2;
        }
        categoryComponentsAdapter.setSelectedItemPosition(-1);
        Integer id2 = item.getId();
        tuningAutoScreen.currentPageId = id2 != null ? id2.intValue() : 0;
        tuningAutoScreen.selectedSubCategory = item;
        tuningAutoScreen.additionalInfoUiVisibility(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$18(TuningAutoScreen tuningAutoScreen, CategoryComponents item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        CategoryComponentsAdapter categoryComponentsAdapter = tuningAutoScreen.itemComponentsAdapter;
        CategoryComponentsAdapter categoryComponentsAdapter2 = null;
        if (categoryComponentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
            categoryComponentsAdapter = null;
        }
        int selectedItemPosition = categoryComponentsAdapter.getSelectedItemPosition();
        CategoryComponentsAdapter categoryComponentsAdapter3 = tuningAutoScreen.itemComponentsAdapter;
        if (categoryComponentsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
            categoryComponentsAdapter3 = null;
        }
        categoryComponentsAdapter3.setSelectedItemPosition(i);
        CategoryComponentsAdapter categoryComponentsAdapter4 = tuningAutoScreen.itemComponentsAdapter;
        if (categoryComponentsAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
            categoryComponentsAdapter4 = null;
        }
        categoryComponentsAdapter4.notifyItemChanged(selectedItemPosition);
        CategoryComponentsAdapter categoryComponentsAdapter5 = tuningAutoScreen.itemComponentsAdapter;
        if (categoryComponentsAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
        } else {
            categoryComponentsAdapter2 = categoryComponentsAdapter5;
        }
        categoryComponentsAdapter2.notifyItemChanged(i);
        tuningAutoScreen.selectedCategoryComponent = item;
        Integer id = item.getId();
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateComponent(id != null ? id.intValue() : 0)), 1);
        if (tuningAutoScreen.currentPageId == 18) {
            tuningAutoScreen.setTintedWindowInfo(item);
        }
        CategoryInfo categoryInfo = tuningAutoScreen.selectedSubCategory;
        if (categoryInfo != null) {
            tuningAutoScreen.showProperUi(categoryInfo);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$19(TuningAutoScreen tuningAutoScreen, CategoryComponents it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getInCart()) {
            Integer id = it.getId();
            tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateComponent(id != null ? id.intValue() : 0)), 3);
        } else {
            Integer id2 = it.getId();
            tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateComponent(id2 != null ? id2.intValue() : 0)), 2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAdapters$lambda$21(TuningAutoScreen tuningAutoScreen, SelectedColors item, int i) {
        Integer id;
        Intrinsics.checkNotNullParameter(item, "item");
        TintedColorAdapter tintedColorAdapter = tuningAutoScreen.tintSelectColorAdapter;
        TintedColorAdapter tintedColorAdapter2 = null;
        if (tintedColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
            tintedColorAdapter = null;
        }
        List<SelectedColors> currentList = tintedColorAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<SelectedColors> list = currentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SelectedColors selectedColors = (SelectedColors) obj;
            if (selectedColors.isSelected()) {
                selectedColors = SelectedColors.copy$default(selectedColors, 0, false, 1, null);
            } else if (i == i2) {
                selectedColors = SelectedColors.copy$default(selectedColors, 0, true, 1, null);
            }
            arrayList.add(selectedColors);
            i2 = i3;
        }
        ArrayList arrayList2 = arrayList;
        TintedColorAdapter tintedColorAdapter3 = tuningAutoScreen.tintSelectColorAdapter;
        if (tintedColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
            tintedColorAdapter3 = null;
        }
        tintedColorAdapter3.submitList(arrayList2);
        TintedColorAdapter tintedColorAdapter4 = tuningAutoScreen.tintSelectColorAdapter;
        if (tintedColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
        } else {
            tintedColorAdapter2 = tintedColorAdapter4;
        }
        tintedColorAdapter2.notifyItemChanged(i);
        tuningAutoScreen.selectedTintColor = i;
        CategoryComponents categoryComponents = tuningAutoScreen.selectedCategoryComponent;
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateTintedColor((categoryComponents == null || (id = categoryComponents.getId()) == null) ? -1 : id.intValue(), tuningAutoScreen.selectedTintColor, tuningAutoScreen.binding.tintSettingsLayout.seekBar.getProgress())), 4);
        return Unit.INSTANCE;
    }

    private final void setTintedWindowInfo(CategoryComponents categoryComponents) {
        TintedColorAdapter tintedColorAdapter;
        for (TintedWindows tintedWindows : this.listTintedWindows) {
            if (Intrinsics.areEqual(categoryComponents.getId(), tintedWindows.getId())) {
                List<SelectedColors> list = this.unselectTintColorList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (true) {
                    tintedColorAdapter = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    SelectedColors selectedColors = (SelectedColors) it.next();
                    int color = selectedColors.getColor();
                    Integer color2 = tintedWindows.getColor();
                    if (color2 != null && color == color2.intValue()) {
                        selectedColors = SelectedColors.copy$default(selectedColors, 0, true, 1, null);
                    }
                    arrayList.add(selectedColors);
                }
                ArrayList arrayList2 = arrayList;
                this.binding.tintSettingsLayout.tvMiddle.setText(String.valueOf(tintedWindows.getOpacity()));
                SeekBar seekBar = this.binding.tintSettingsLayout.seekBar;
                Integer opacity = tintedWindows.getOpacity();
                seekBar.setProgress(opacity != null ? opacity.intValue() : 0);
                TintedColorAdapter tintedColorAdapter2 = this.tintSelectColorAdapter;
                if (tintedColorAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
                    tintedColorAdapter2 = null;
                }
                tintedColorAdapter2.submitList(arrayList2);
                TintedColorAdapter tintedColorAdapter3 = this.tintSelectColorAdapter;
                if (tintedColorAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
                } else {
                    tintedColorAdapter = tintedColorAdapter3;
                }
                tintedColorAdapter.notifyDataSetChanged();
            }
        }
    }

    private final void initMenuCategories(List<CategoryInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CategoryInfo) obj).getParentId() == null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        CategoriesMenuAdapter categoriesMenuAdapter = this.categoriesMenuAdapter;
        CategoriesMenuAdapter categoriesMenuAdapter2 = null;
        if (categoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
            categoriesMenuAdapter = null;
        }
        categoriesMenuAdapter.submitList(arrayList2);
        CategoriesMenuAdapter categoriesMenuAdapter3 = this.categoriesMenuAdapter;
        if (categoriesMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesMenuAdapter");
        } else {
            categoriesMenuAdapter2 = categoriesMenuAdapter3;
        }
        if (categoriesMenuAdapter2.getItemCount() > 0) {
            this.binding.rvMenu.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    TuningAutoScreen.initMenuCategories$lambda$25(TuningAutoScreen.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenuCategories$lambda$25(TuningAutoScreen tuningAutoScreen) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = tuningAutoScreen.binding.rvMenu.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    private final void initSubMenuCategories(List<CategoryInfo> list) {
        Integer id;
        ArrayList<CategoryInfo> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            CategoryInfo categoryInfo = (CategoryInfo) next;
            List<CategoryComponents> list2 = this.categoryComponentsList;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Intrinsics.areEqual(((CategoryComponents) it2.next()).getCategoryId(), categoryInfo.getId())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!z) {
                arrayList.add(next);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        for (CategoryInfo categoryInfo2 : arrayList) {
            mutableList.remove(categoryInfo2);
        }
        SubCategoriesMenuAdapter subCategoriesMenuAdapter = this.subCategoriesMenuAdapter;
        SubCategoriesMenuAdapter subCategoriesMenuAdapter2 = null;
        if (subCategoriesMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
            subCategoriesMenuAdapter = null;
        }
        subCategoriesMenuAdapter.submitList(mutableList);
        SubCategoriesMenuAdapter subCategoriesMenuAdapter3 = this.subCategoriesMenuAdapter;
        if (subCategoriesMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subCategoriesMenuAdapter");
        } else {
            subCategoriesMenuAdapter2 = subCategoriesMenuAdapter3;
        }
        subCategoriesMenuAdapter2.notifyDataSetChanged();
        try {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : this.categoryComponentsList) {
                Integer categoryId = ((CategoryComponents) obj).getCategoryId();
                CategoryInfo categoryInfo3 = (CategoryInfo) CollectionsKt.firstOrNull((List<? extends Object>) list);
                if (Intrinsics.areEqual(categoryId, (categoryInfo3 == null || (r5 = categoryInfo3.getId()) == null) ? 0 : 0)) {
                    arrayList2.add(obj);
                }
            }
            refreshComponentsList(arrayList2);
            CategoryInfo categoryInfo4 = (CategoryInfo) CollectionsKt.firstOrNull((List<? extends Object>) list);
            sendData(StringKt.toStringJson(new UpdateCategory((categoryInfo4 == null || (id = categoryInfo4.getId()) == null) ? 0 : id.intValue())), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void additionalInfoUiVisibility(boolean z) {
        ConstraintLayout parentLayout = this.binding.carCharacteristicLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout2 = this.binding.wheelSettingsLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout3 = this.binding.tintSettingsLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout4 = this.binding.selectColorLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout4, "parentLayout");
        parentLayout4.setVisibility(z ? 0 : 8);
    }

    private final void showProperUi(CategoryInfo categoryInfo) {
        String type = categoryInfo.getType();
        if (type != null) {
            switch (type.hashCode()) {
                case -183252630:
                    if (type.equals("tintedWindow")) {
                        ConstraintLayout parentLayout = this.binding.carCharacteristicLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
                        parentLayout.setVisibility(8);
                        ConstraintLayout parentLayout2 = this.binding.wheelSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
                        parentLayout2.setVisibility(8);
                        ConstraintLayout parentLayout3 = this.binding.tintSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
                        parentLayout3.setVisibility(0);
                        ConstraintLayout parentLayout4 = this.binding.selectColorLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout4, "parentLayout");
                        parentLayout4.setVisibility(8);
                        return;
                    }
                    return;
                case 1105937695:
                    if (type.equals("sliderList")) {
                        ConstraintLayout parentLayout5 = this.binding.carCharacteristicLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout5, "parentLayout");
                        parentLayout5.setVisibility(8);
                        ConstraintLayout parentLayout6 = this.binding.wheelSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout6, "parentLayout");
                        parentLayout6.setVisibility(0);
                        ConstraintLayout parentLayout7 = this.binding.tintSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout7, "parentLayout");
                        parentLayout7.setVisibility(8);
                        ConstraintLayout parentLayout8 = this.binding.selectColorLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout8, "parentLayout");
                        parentLayout8.setVisibility(8);
                        return;
                    }
                    return;
                case 1706195771:
                    if (type.equals("componentList")) {
                        ConstraintLayout parentLayout9 = this.binding.carCharacteristicLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout9, "parentLayout");
                        parentLayout9.setVisibility(0);
                        ConstraintLayout parentLayout10 = this.binding.wheelSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout10, "parentLayout");
                        parentLayout10.setVisibility(8);
                        ConstraintLayout parentLayout11 = this.binding.tintSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout11, "parentLayout");
                        parentLayout11.setVisibility(8);
                        ConstraintLayout parentLayout12 = this.binding.selectColorLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout12, "parentLayout");
                        parentLayout12.setVisibility(8);
                        return;
                    }
                    return;
                case 1980689057:
                    if (type.equals("colorList")) {
                        ConstraintLayout parentLayout13 = this.binding.carCharacteristicLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout13, "parentLayout");
                        parentLayout13.setVisibility(8);
                        ConstraintLayout parentLayout14 = this.binding.wheelSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout14, "parentLayout");
                        parentLayout14.setVisibility(8);
                        ConstraintLayout parentLayout15 = this.binding.tintSettingsLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout15, "parentLayout");
                        parentLayout15.setVisibility(8);
                        ConstraintLayout parentLayout16 = this.binding.selectColorLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout16, "parentLayout");
                        parentLayout16.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void refreshComponentsList(List<CategoryComponents> list) {
        CategoryComponentsAdapter categoryComponentsAdapter = this.itemComponentsAdapter;
        CategoryComponentsAdapter categoryComponentsAdapter2 = null;
        if (categoryComponentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
            categoryComponentsAdapter = null;
        }
        categoryComponentsAdapter.submitList(list);
        CategoryComponentsAdapter categoryComponentsAdapter3 = this.itemComponentsAdapter;
        if (categoryComponentsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
        } else {
            categoryComponentsAdapter2 = categoryComponentsAdapter3;
        }
        categoryComponentsAdapter2.notifyDataSetChanged();
    }

    private final void initAutoColorAdapter() {
        this.selectFirstColorAdapter = new TuningSelectColorAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAutoColorAdapter$lambda$31;
                initAutoColorAdapter$lambda$31 = TuningAutoScreen.initAutoColorAdapter$lambda$31(TuningAutoScreen.this, (SelectedColors) obj, ((Integer) obj2).intValue());
                return initAutoColorAdapter$lambda$31;
            }
        });
        RecyclerView recyclerView = this.binding.selectColorLayout.rvFirstColors;
        TuningSelectColorAdapter tuningSelectColorAdapter = this.selectFirstColorAdapter;
        TuningSelectColorAdapter tuningSelectColorAdapter2 = null;
        if (tuningSelectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
            tuningSelectColorAdapter = null;
        }
        recyclerView.setAdapter(tuningSelectColorAdapter);
        this.selectSecondColorAdapter = new TuningSelectColorAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initAutoColorAdapter$lambda$33;
                initAutoColorAdapter$lambda$33 = TuningAutoScreen.initAutoColorAdapter$lambda$33(TuningAutoScreen.this, (SelectedColors) obj, ((Integer) obj2).intValue());
                return initAutoColorAdapter$lambda$33;
            }
        });
        RecyclerView recyclerView2 = this.binding.selectColorLayout.rvSecondColors;
        TuningSelectColorAdapter tuningSelectColorAdapter3 = this.selectSecondColorAdapter;
        if (tuningSelectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
        } else {
            tuningSelectColorAdapter2 = tuningSelectColorAdapter3;
        }
        recyclerView2.setAdapter(tuningSelectColorAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAutoColorAdapter$lambda$31(TuningAutoScreen tuningAutoScreen, SelectedColors selectedColors, int i) {
        Intrinsics.checkNotNullParameter(selectedColors, "<unused var>");
        TuningSelectColorAdapter tuningSelectColorAdapter = tuningAutoScreen.selectFirstColorAdapter;
        TuningSelectColorAdapter tuningSelectColorAdapter2 = null;
        if (tuningSelectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
            tuningSelectColorAdapter = null;
        }
        List<SelectedColors> currentList = tuningSelectColorAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<SelectedColors> list = currentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SelectedColors selectedColors2 = (SelectedColors) obj;
            if (selectedColors2.isSelected()) {
                selectedColors2 = SelectedColors.copy$default(selectedColors2, 0, false, 1, null);
            } else if (i == i2) {
                selectedColors2 = SelectedColors.copy$default(selectedColors2, 0, true, 1, null);
            }
            arrayList.add(selectedColors2);
            i2 = i3;
        }
        ArrayList arrayList2 = arrayList;
        TuningSelectColorAdapter tuningSelectColorAdapter3 = tuningAutoScreen.selectFirstColorAdapter;
        if (tuningSelectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
            tuningSelectColorAdapter3 = null;
        }
        tuningSelectColorAdapter3.submitList(arrayList2);
        TuningSelectColorAdapter tuningSelectColorAdapter4 = tuningAutoScreen.selectFirstColorAdapter;
        if (tuningSelectColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
        } else {
            tuningSelectColorAdapter2 = tuningSelectColorAdapter4;
        }
        tuningSelectColorAdapter2.notifyItemChanged(i);
        tuningAutoScreen.firstSelectedColorIndex = i;
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateColor(tuningAutoScreen.firstSelectedColorIndex, tuningAutoScreen.secondSelectedColorIndex)), 5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAutoColorAdapter$lambda$33(TuningAutoScreen tuningAutoScreen, SelectedColors selectedColors, int i) {
        Intrinsics.checkNotNullParameter(selectedColors, "<unused var>");
        TuningSelectColorAdapter tuningSelectColorAdapter = tuningAutoScreen.selectSecondColorAdapter;
        TuningSelectColorAdapter tuningSelectColorAdapter2 = null;
        if (tuningSelectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
            tuningSelectColorAdapter = null;
        }
        List<SelectedColors> currentList = tuningSelectColorAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<SelectedColors> list = currentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SelectedColors selectedColors2 = (SelectedColors) obj;
            if (selectedColors2.isSelected()) {
                selectedColors2 = SelectedColors.copy$default(selectedColors2, 0, false, 1, null);
            } else if (i == i2) {
                selectedColors2 = SelectedColors.copy$default(selectedColors2, 0, true, 1, null);
            }
            arrayList.add(selectedColors2);
            i2 = i3;
        }
        ArrayList arrayList2 = arrayList;
        TuningSelectColorAdapter tuningSelectColorAdapter3 = tuningAutoScreen.selectSecondColorAdapter;
        if (tuningSelectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
            tuningSelectColorAdapter3 = null;
        }
        tuningSelectColorAdapter3.submitList(arrayList2);
        TuningSelectColorAdapter tuningSelectColorAdapter4 = tuningAutoScreen.selectSecondColorAdapter;
        if (tuningSelectColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSecondColorAdapter");
        } else {
            tuningSelectColorAdapter2 = tuningSelectColorAdapter4;
        }
        tuningSelectColorAdapter2.notifyItemChanged(i);
        tuningAutoScreen.secondSelectedColorIndex = i;
        tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateColor(tuningAutoScreen.firstSelectedColorIndex, tuningAutoScreen.secondSelectedColorIndex)), 5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x014a A[SYNTHETIC] */
    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBackendMessage(String data, int i) {
        boolean z;
        Integer id;
        Object obj;
        boolean z2;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_TUNING", "onBACKEND subID: " + i + " === data: " + data);
        CategoryComponentsAdapter categoryComponentsAdapter = null;
        try {
            switch (i) {
                case 1:
                    final List<CategoryInfo> listModel = MapperKt.toListModel(data, CategoryInfo.class);
                    this.categoriesList = listModel;
                    initMenuCategories(listModel);
                    this.handler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            TuningAutoScreen.onBackendMessage$lambda$35(TuningAutoScreen.this, listModel);
                        }
                    }, 500L);
                    return;
                case 2:
                    Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) List.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    initAutoColorAdapter();
                    this.firstSelectedColorIndex = ((Number) list.get(0)).intValue();
                    this.secondSelectedColorIndex = ((Number) list.get(1)).intValue();
                    Button btnSecondColor = this.binding.selectColorLayout.btnSecondColor;
                    Intrinsics.checkNotNullExpressionValue(btnSecondColor, "btnSecondColor");
                    btnSecondColor.setVisibility(((Number) list.get(2)).intValue() != 1 ? 0 : 8);
                    for (Number number : ConstantsKt.getTuningColorsList()) {
                        this.listAllColors.add(new SelectedColors(number.intValue(), false));
                    }
                    List<SelectedColors> updateSelectColorIndex = updateSelectColorIndex(this.firstSelectedColorIndex);
                    TuningSelectColorAdapter tuningSelectColorAdapter = this.selectFirstColorAdapter;
                    if (tuningSelectColorAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectFirstColorAdapter");
                    } else {
                        categoryComponentsAdapter = tuningSelectColorAdapter;
                    }
                    categoryComponentsAdapter.submitList(updateSelectColorIndex);
                    sendData(StringKt.toStringJson(new UpdateColor(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue())), 5);
                    return;
                case 3:
                    Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) List.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Number number2 : (List) fromJson2) {
                        arrayList.add(new SelectedColors(number2.intValue(), false));
                    }
                    this.unselectTintColorList = arrayList;
                    TintedColorAdapter tintedColorAdapter = this.tintSelectColorAdapter;
                    if (tintedColorAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tintSelectColorAdapter");
                    } else {
                        categoryComponentsAdapter = tintedColorAdapter;
                    }
                    categoryComponentsAdapter.submitList(arrayList);
                    return;
                case 4:
                    List<WheelSettings> listModel2 = MapperKt.toListModel(data, WheelSettings.class);
                    this.wheelSettings = listModel2;
                    updateWheelSettings(listModel2);
                    return;
                case 5:
                    this.listTintedWindows = CollectionsKt.toMutableList((Collection) MapperKt.toListModel(data, TintedWindows.class));
                    return;
                case 6:
                case 11:
                case 12:
                case 13:
                default:
                    return;
                case 7:
                    Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) ClientData.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
                    ClientData clientData = (ClientData) fromJson3;
                    this.binding.tvTitle.setText(clientData.getCarName());
                    this.binding.tvUserMoney.setText(String.valueOf(clientData.getPlayerMoney()));
                    this.binding.tvCartTotal.setText(String.valueOf(clientData.getCartCount()));
                    this.binding.userCartLayout.tvTotalPrice.setText(String.valueOf(clientData.getCartCount()));
                    return;
                case 8:
                    this.autoCharsAdapter.submitList(MapperKt.toListModel(data, DashboardProperties.class));
                    return;
                case 9:
                    Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CategoryComponents.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
                    CategoryComponents categoryComponents = (CategoryComponents) fromJson4;
                    Iterator<CategoryComponents> it = this.categoryComponentsList.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                        } else if (!Intrinsics.areEqual(it.next().getId(), categoryComponents.getId())) {
                            i2++;
                        }
                    }
                    this.categoryComponentsList.set(i2, categoryComponents);
                    CategoryComponentsAdapter categoryComponentsAdapter2 = this.itemComponentsAdapter;
                    if (categoryComponentsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
                        categoryComponentsAdapter2 = null;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : this.categoryComponentsList) {
                        Integer categoryId = ((CategoryComponents) obj2).getCategoryId();
                        int i3 = this.currentPageId;
                        if (categoryId != null && categoryId.intValue() == i3) {
                            z = true;
                            if (!z) {
                                arrayList2.add(obj2);
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    categoryComponentsAdapter2.submitList(arrayList2);
                    CategoryComponentsAdapter categoryComponentsAdapter3 = this.itemComponentsAdapter;
                    if (categoryComponentsAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemComponentsAdapter");
                    } else {
                        categoryComponentsAdapter = categoryComponentsAdapter3;
                    }
                    categoryComponentsAdapter.notifyItemChanged(i2);
                    return;
                case 10:
                    List listModel3 = MapperKt.toListModel(data, CategoryComponents.class);
                    if (listModel3.size() > 3) {
                        CategoryComponents categoryComponents2 = (CategoryComponents) CollectionsKt.firstOrNull((List<? extends Object>) listModel3);
                        if (((categoryComponents2 == null || (id = categoryComponents2.getId()) == null) ? 0 : id.intValue()) == 0) {
                            resetAllValues();
                            ConstraintLayout parentLayout = this.binding.userCartLayout.parentLayout;
                            Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
                            if (parentLayout.getVisibility() == 0) {
                                cartUiVisibility(false);
                            }
                        }
                    }
                    CollectionsKt.addAll(this.categoryComponentsList, listModel3);
                    return;
                case 14:
                    Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) List.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
                    List<Number> list2 = (List) fromJson5;
                    this.cartItems.clear();
                    for (Number number3 : list2) {
                        int intValue = number3.intValue();
                        Iterator<T> it2 = this.categoryComponentsList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj = it2.next();
                                Integer id2 = ((CategoryComponents) obj).getId();
                                if (id2 != null && id2.intValue() == intValue) {
                                    z2 = true;
                                    continue;
                                    if (z2) {
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                            } else {
                                obj = null;
                            }
                        }
                        CategoryComponents categoryComponents3 = (CategoryComponents) obj;
                        if (categoryComponents3 != null) {
                            this.cartItems.add(categoryComponents3);
                        }
                    }
                    this.binding.tvCartCount.setText(String.valueOf(list2.size()));
                    this.userCartAdapter.submitList(this.cartItems);
                    this.userCartAdapter.notifyDataSetChanged();
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$35(TuningAutoScreen tuningAutoScreen, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Integer parentId = ((CategoryInfo) obj).getParentId();
            if (parentId != null && parentId.intValue() == 0) {
                arrayList.add(obj);
            }
        }
        tuningAutoScreen.initSubMenuCategories(arrayList);
    }

    private final void resetAllValues() {
        this.categoriesList = CollectionsKt.emptyList();
        this.categoryComponentsList.clear();
        this.currentPageId = 0;
        this.firstSelectedColorIndex = 0;
        this.secondSelectedColorIndex = 0;
        this.wheelSettings = CollectionsKt.emptyList();
        this.listAllColors.clear();
        this.cartItems.clear();
        this.selectedCategoryComponent = null;
        this.listTintedWindows.clear();
        this.categoriesList = CollectionsKt.emptyList();
        this.selectedTintColor = 0;
        this.binding.tvCartCount.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cartUiVisibility(boolean z) {
        View bgUserCart = this.binding.bgUserCart;
        Intrinsics.checkNotNullExpressionValue(bgUserCart, "bgUserCart");
        bgUserCart.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout = this.binding.userCartLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(z ? 0 : 8);
        TextView tvBack = this.binding.tvBack;
        Intrinsics.checkNotNullExpressionValue(tvBack, "tvBack");
        tvBack.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCartListUi() {
        cartUiVisibility(true);
        this.userCartAdapter.submitList(this.cartItems);
    }

    private final void updateWheelSettings(final List<WheelSettings> list) {
        final int i;
        Iterator<T> it = list.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            WheelSettings wheelSettings = (WheelSettings) it.next();
            LayoutWheelSettingsBinding layoutWheelSettingsBinding = this.binding.wheelSettingsLayout;
            Integer id = wheelSettings.getId();
            if (id != null && id.intValue() == 0) {
                layoutWheelSettingsBinding.tvRearWheels.setText(wheelSettings.getTitle());
                layoutWheelSettingsBinding.tvRearMinus.setText(String.valueOf(wheelSettings.getMin()));
                layoutWheelSettingsBinding.tvRearPlus.setText(String.valueOf(wheelSettings.getMax()));
                double d = 100;
                layoutWheelSettingsBinding.seekBarRear.setMin((int) (wheelSettings.getMin() * d));
                layoutWheelSettingsBinding.seekBarRear.setMax((int) (wheelSettings.getMax() * d));
                layoutWheelSettingsBinding.seekBarRear.setProgress((int) (wheelSettings.getValue() * d));
                layoutWheelSettingsBinding.tvRearMiddle.setText(String.valueOf(wheelSettings.getValue()));
            } else if (id != null && id.intValue() == 1) {
                layoutWheelSettingsBinding.tvFrontWheels.setText(wheelSettings.getTitle());
                layoutWheelSettingsBinding.tvFrontMinus.setText(String.valueOf(wheelSettings.getMin()));
                layoutWheelSettingsBinding.tvFrontPlus.setText(String.valueOf(wheelSettings.getMax()));
                double d2 = 100;
                layoutWheelSettingsBinding.seekBarFront.setMin((int) (wheelSettings.getMin() * d2));
                layoutWheelSettingsBinding.seekBarFront.setMax((int) (wheelSettings.getMax() * d2));
                layoutWheelSettingsBinding.seekBarFront.setProgress((int) (wheelSettings.getValue() * d2));
                layoutWheelSettingsBinding.tvFrontMiddle.setText(String.valueOf(wheelSettings.getValue()));
            }
        }
        final LayoutWheelSettingsBinding layoutWheelSettingsBinding2 = this.binding.wheelSettingsLayout;
        ConstraintLayout layoutFrontWheels = layoutWheelSettingsBinding2.layoutFrontWheels;
        Intrinsics.checkNotNullExpressionValue(layoutFrontWheels, "layoutFrontWheels");
        layoutFrontWheels.setVisibility(0);
        AppCompatTextView tvFrontWheels = layoutWheelSettingsBinding2.tvFrontWheels;
        Intrinsics.checkNotNullExpressionValue(tvFrontWheels, "tvFrontWheels");
        tvFrontWheels.setVisibility(0);
        double d3 = 100;
        final int step = (int) (list.get(0).getStep() * d3);
        if (list.size() > 1) {
            i = (int) (list.get(1).getStep() * d3);
        } else {
            ConstraintLayout layoutFrontWheels2 = layoutWheelSettingsBinding2.layoutFrontWheels;
            Intrinsics.checkNotNullExpressionValue(layoutFrontWheels2, "layoutFrontWheels");
            layoutFrontWheels2.setVisibility(8);
            AppCompatTextView tvFrontWheels2 = layoutWheelSettingsBinding2.tvFrontWheels;
            Intrinsics.checkNotNullExpressionValue(tvFrontWheels2, "tvFrontWheels");
            tvFrontWheels2.setVisibility(8);
        }
        layoutWheelSettingsBinding2.btnRearMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.updateWheelSettings$lambda$48$lambda$44(LayoutWheelSettingsBinding.this, step, view);
            }
        });
        layoutWheelSettingsBinding2.btnRearPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.updateWheelSettings$lambda$48$lambda$45(LayoutWheelSettingsBinding.this, step, view);
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutWheelSettingsBinding2.seekBarRear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$updateWheelSettings$2$3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Double] */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                Integer id2;
                int i3 = step;
                double d4 = ((i2 / i3) * i3) / 100.0d;
                layoutWheelSettingsBinding2.tvRearMiddle.setText(String.valueOf(d4));
                if (Intrinsics.areEqual(objectRef.element, d4)) {
                    return;
                }
                TuningAutoScreen tuningAutoScreen = this;
                WheelSettings wheelSettings2 = (WheelSettings) CollectionsKt.firstOrNull((List<? extends Object>) list);
                tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateDashboard((wheelSettings2 == null || (id2 = wheelSettings2.getId()) == null) ? 0 : id2.intValue(), d4)), 7);
                objectRef.element = Double.valueOf(d4);
            }
        });
        layoutWheelSettingsBinding2.btnFrontMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.updateWheelSettings$lambda$48$lambda$46(LayoutWheelSettingsBinding.this, i, view);
            }
        });
        layoutWheelSettingsBinding2.btnFrontPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TuningAutoScreen.updateWheelSettings$lambda$48$lambda$47(LayoutWheelSettingsBinding.this, i, view);
            }
        });
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final int i2 = i;
        layoutWheelSettingsBinding2.seekBarFront.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.TuningAutoScreen$updateWheelSettings$2$6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Double] */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                int i4 = i2;
                double d4 = ((i3 / i4) * i4) / 100.0d;
                layoutWheelSettingsBinding2.tvFrontMiddle.setText(String.valueOf(d4));
                if (list.size() <= 1 || Intrinsics.areEqual(objectRef2.element, d4)) {
                    return;
                }
                TuningAutoScreen tuningAutoScreen = this;
                Integer id2 = list.get(1).getId();
                tuningAutoScreen.sendData(StringKt.toStringJson(new UpdateDashboard(id2 != null ? id2.intValue() : 0, d4)), 7);
                objectRef2.element = Double.valueOf(d4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWheelSettings$lambda$48$lambda$44(LayoutWheelSettingsBinding layoutWheelSettingsBinding, int i, View view) {
        layoutWheelSettingsBinding.seekBarRear.incrementProgressBy(-i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWheelSettings$lambda$48$lambda$45(LayoutWheelSettingsBinding layoutWheelSettingsBinding, int i, View view) {
        layoutWheelSettingsBinding.seekBarRear.incrementProgressBy(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWheelSettings$lambda$48$lambda$46(LayoutWheelSettingsBinding layoutWheelSettingsBinding, int i, View view) {
        layoutWheelSettingsBinding.seekBarFront.incrementProgressBy(-i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWheelSettings$lambda$48$lambda$47(LayoutWheelSettingsBinding layoutWheelSettingsBinding, int i, View view) {
        layoutWheelSettingsBinding.seekBarFront.incrementProgressBy(i);
    }

    private final List<SelectedColors> updateSelectColorIndex(int i) {
        List<SelectedColors> list = this.listAllColors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SelectedColors selectedColors = (SelectedColors) obj;
            if (i2 == i) {
                selectedColors = SelectedColors.copy$default(selectedColors, 0, true, 1, null);
            }
            arrayList.add(selectedColors);
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendData(String str, int i) {
        Log.d("TAG_TUNINGSEND", "subId: " + i + " === sendITEM: " + str);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.TUNING_SCREEN.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.TUNING_SCREEN.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: TuningAutoScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/TuningAutoScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new TuningAutoScreen(targetActivity, i);
        }
    }
}

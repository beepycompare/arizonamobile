package ru.mrlargha.commonui.elements.radial_menu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.RadialMenuItemBinding;
import ru.mrlargha.commonui.databinding.RadialMenuScreenBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: RadialMenuScreen.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\u00020\u0001:\u0006FGHIJKB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0016J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0002J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u0002H-0\u0014\"\u0006\b\u0000\u0010-\u0018\u00012\u0006\u0010.\u001a\u00020)H\u0082\bJ\u0016\u0010/\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H\u0002J\b\u00101\u001a\u00020%H\u0002J,\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u00020%052\f\u00106\u001a\b\u0012\u0004\u0012\u00020%05H\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020\u000eH\u0002J$\u00109\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020:0\u00142\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010<\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H\u0002J,\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020%052\f\u0010A\u001a\b\u0012\u0004\u0012\u00020%05H\u0003J\b\u0010B\u001a\u00020%H\u0002J%\u0010C\u001a\b\u0012\u0004\u0012\u0002H-0\u0014\"\u0006\b\u0000\u0010-\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H-0\u0014H\u0082\bJ\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020)H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "radialMenu", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/RadialMenuScreenBinding;", "leftItems", "", "Lru/mrlargha/commonui/databinding/RadialMenuItemBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "rightItems", "scope", "Lkotlinx/coroutines/CoroutineScope;", "visibleView", "", "invisibleView", "itemList", "Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuItemModel;", "actionList", "showListSize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isFirst", "page", "setVisibility", "", "visible", "onBackendMessage", "data", "", "subId", "checkModelType", "toListModel", ExifInterface.GPS_DIRECTION_TRUE, "json", "setItems", "list", "setOnClickListener", "setOnBottomBtnListener", "listSize", "onNext", "Lkotlin/Function0;", "onBack", "isShowNext", "isShowBack", "setExtremeItem", "", "extremeItems", "setDataItems", "itemClickListener", "view", "Landroid/view/ViewGroup;", "onTouch", "onClick", "clearItems", "setVisibleList", "setImage", "icon", "Spawner", "Companion", "RadialMenuId", "RadialMenuModel", "RadialMenuActionModel", "RadialMenuItemModel", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RadialMenuScreen extends SAMPUIElement {
    private static final String ACTIONS = "actions";
    private static final int MAX_ITEM = 7;
    private static final int ONE_ITEM = 1;
    private static final int THREE_ITEM = 3;
    private static final int TWO_ITEM = 2;
    private List<RadialMenuItemModel> actionList;
    private final IBackendNotifier backendNotifier;
    private final RadialMenuScreenBinding binding;
    private List<RadialMenuItemBinding> invisibleView;
    private final boolean isArizonaType;
    private boolean isFirst;
    private final List<RadialMenuItemModel> itemList;
    private final List<RadialMenuItemBinding> leftItems;
    private int page;
    private final ConstraintLayout radialMenu;
    private final List<RadialMenuItemBinding> rightItems;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPref;
    private MutableStateFlow<Integer> showListSize;
    private List<RadialMenuItemBinding> visibleView;
    public static final Companion Companion = new Companion(null);
    private static final int darkColor = Color.parseColor("#202731");
    private static final int whiteColor = Color.parseColor("#FFFFFF");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialMenuScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.backendNotifier = (IBackendNotifier) targetActivity;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.radial_menu_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.radialMenu = constraintLayout;
        RadialMenuScreenBinding bind = RadialMenuScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.leftItems = CollectionsKt.listOf((Object[]) new RadialMenuItemBinding[]{bind.leftFirstItem, bind.leftSecondItem, bind.leftThirdItem});
        this.rightItems = CollectionsKt.listOf((Object[]) new RadialMenuItemBinding[]{bind.rightFirstItem, bind.rightSecondItem, bind.rightThirdItem});
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.visibleView = new ArrayList();
        this.invisibleView = new ArrayList();
        this.itemList = new ArrayList();
        this.showListSize = StateFlowKt.MutableStateFlow(0);
        this.isFirst = true;
        this.page = 1;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setOnClickListener();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        this.itemList.clear();
        this.isFirst = true;
        this.page = 1;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == RadialMenuId.INITIALIZE.getSubId()) {
            checkModelType(data);
        }
    }

    private final void checkModelType(String str) {
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ACTIONS, false, 2, (Object) null)) {
            Object fromJson = new Gson().fromJson(str, new TypeToken<List<? extends RadialMenuModel>>() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$$inlined$toListModel$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            this.itemList.add(((RadialMenuModel) ((List) fromJson).get(0)).toItemModel());
        } else {
            Object fromJson2 = new Gson().fromJson(str, new TypeToken<List<? extends RadialMenuActionModel>>() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$$inlined$toListModel$2
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
            for (RadialMenuActionModel radialMenuActionModel : (List) fromJson2) {
                this.itemList.add(radialMenuActionModel.toItemModel());
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RadialMenuScreen$checkModelType$2(this, null), 3, null);
        setItems(this.itemList);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RadialMenuScreen$checkModelType$3(this, null), 3, null);
    }

    private final /* synthetic */ <T> List<T> toListModel(String str) {
        Intrinsics.needClassReification();
        Object fromJson = new Gson().fromJson(str, new TypeToken<List<? extends T>>() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$toListModel$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (List) fromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItems(List<RadialMenuItemModel> list) {
        clearItems();
        LinearLayout root = this.binding.bottomItem.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(isShowNext(list.size()) || isShowBack() ? 8 : 0);
        if (list.size() > 7) {
            LinearLayout root2 = this.binding.bottomItem.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            root2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            int i = (this.page - 1) * 7;
            int min = Math.min(i + 7, list.size());
            while (i < min) {
                arrayList.add(list.get(i));
                i++;
            }
            list = arrayList;
        } else {
            LinearLayout root3 = this.binding.bottomItem.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            root3.setVisibility(8);
        }
        if (list.size() % 2 != 0) {
            List<RadialMenuItemBinding> list2 = this.visibleView;
            RadialMenuItemBinding topItem = this.binding.topItem;
            Intrinsics.checkNotNullExpressionValue(topItem, "topItem");
            list2.add(topItem);
        } else {
            List<RadialMenuItemBinding> list3 = this.invisibleView;
            RadialMenuItemBinding topItem2 = this.binding.topItem;
            Intrinsics.checkNotNullExpressionValue(topItem2, "topItem");
            list3.add(topItem2);
        }
        setExtremeItem(list, this.leftItems);
        setExtremeItem(list, this.rightItems);
        int i2 = 0;
        for (Object obj : this.visibleView) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LinearLayout root4 = ((RadialMenuItemBinding) obj).getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
            root4.setVisibility(0);
            i2 = i3;
        }
        for (RadialMenuItemBinding radialMenuItemBinding : this.invisibleView) {
            LinearLayout root5 = radialMenuItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
            root5.setVisibility(8);
        }
        setDataItems(list);
    }

    private final void setOnClickListener() {
        LinearLayout root = this.binding.centerElement.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        itemClickListener(root, new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onClickListener$lambda$3;
                onClickListener$lambda$3 = RadialMenuScreen.setOnClickListener$lambda$3(RadialMenuScreen.this);
                return onClickListener$lambda$3;
            }
        }, new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onClickListener$lambda$4;
                onClickListener$lambda$4 = RadialMenuScreen.setOnClickListener$lambda$4(RadialMenuScreen.this);
                return onClickListener$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setOnClickListener$lambda$3(RadialMenuScreen radialMenuScreen) {
        radialMenuScreen.binding.centerElement.getRoot().setBackgroundResource(R.drawable.radial_menu_center_element_select_bg);
        radialMenuScreen.binding.centerElement.centerIvIcon.setColorFilter(darkColor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setOnClickListener$lambda$4(RadialMenuScreen radialMenuScreen) {
        radialMenuScreen.binding.centerElement.getRoot().setBackgroundResource(R.drawable.radial_menu_center_element_bg);
        radialMenuScreen.binding.centerElement.centerIvIcon.setColorFilter(whiteColor);
        radialMenuScreen.backendNotifier.clickedWrapper(radialMenuScreen.getBackendID(), 0, RadialMenuId.CLOSE.getSubId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOnBottomBtnListener(final int i, final Function0<Unit> function0, final Function0<Unit> function02) {
        isShowNext(i);
        isShowBack();
        this.binding.bottomItem.btnNextPage.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadialMenuScreen.setOnBottomBtnListener$lambda$5(RadialMenuScreen.this, function0, i, view);
            }
        });
        this.binding.bottomItem.btnBackPage.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadialMenuScreen.setOnBottomBtnListener$lambda$6(RadialMenuScreen.this, function02, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnBottomBtnListener$lambda$5(RadialMenuScreen radialMenuScreen, Function0 function0, int i, View view) {
        radialMenuScreen.page++;
        function0.invoke();
        radialMenuScreen.isShowNext(i);
        radialMenuScreen.isShowBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnBottomBtnListener$lambda$6(RadialMenuScreen radialMenuScreen, Function0 function0, int i, View view) {
        int i2 = radialMenuScreen.page;
        if (i2 > 1) {
            radialMenuScreen.page = i2 - 1;
            function0.invoke();
        } else if (!radialMenuScreen.isFirst) {
            radialMenuScreen.isFirst = true;
            radialMenuScreen.actionList = null;
            radialMenuScreen.setItems(radialMenuScreen.itemList);
        }
        radialMenuScreen.isShowNext(i);
        radialMenuScreen.isShowBack();
    }

    private final boolean isShowNext(int i) {
        if (i <= this.page * 7) {
            LinearLayout btnNextPage = this.binding.bottomItem.btnNextPage;
            Intrinsics.checkNotNullExpressionValue(btnNextPage, "btnNextPage");
            btnNextPage.setVisibility(4);
            return false;
        }
        LinearLayout btnNextPage2 = this.binding.bottomItem.btnNextPage;
        Intrinsics.checkNotNullExpressionValue(btnNextPage2, "btnNextPage");
        btnNextPage2.setVisibility(0);
        return true;
    }

    private final boolean isShowBack() {
        if (this.page > 1 || !this.isFirst) {
            LinearLayout root = this.binding.bottomItem.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
            LinearLayout btnBackPage = this.binding.bottomItem.btnBackPage;
            Intrinsics.checkNotNullExpressionValue(btnBackPage, "btnBackPage");
            btnBackPage.setVisibility(0);
            return true;
        }
        LinearLayout btnBackPage2 = this.binding.bottomItem.btnBackPage;
        Intrinsics.checkNotNullExpressionValue(btnBackPage2, "btnBackPage");
        btnBackPage2.setVisibility(4);
        return false;
    }

    private final void setExtremeItem(List<? extends Object> list, List<RadialMenuItemBinding> list2) {
        int size = list.size() / 2;
        int i = 0;
        if (size == 1) {
            for (Object obj : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RadialMenuItemBinding radialMenuItemBinding = (RadialMenuItemBinding) obj;
                if (i == 1) {
                    this.visibleView.add(radialMenuItemBinding);
                } else {
                    this.invisibleView.add(radialMenuItemBinding);
                }
                i = i2;
            }
        } else if (size == 2) {
            for (Object obj2 : list2) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RadialMenuItemBinding radialMenuItemBinding2 = (RadialMenuItemBinding) obj2;
                if (i != 1) {
                    this.visibleView.add(radialMenuItemBinding2);
                } else {
                    this.invisibleView.add(radialMenuItemBinding2);
                }
                i = i3;
            }
        } else {
            if (size == 3) {
                for (RadialMenuItemBinding radialMenuItemBinding3 : list2) {
                    this.visibleView.add(radialMenuItemBinding3);
                }
                return;
            }
            for (RadialMenuItemBinding radialMenuItemBinding4 : list2) {
                this.invisibleView.add(radialMenuItemBinding4);
            }
        }
    }

    private final void setDataItems(List<RadialMenuItemModel> list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final RadialMenuItemModel radialMenuItemModel = (RadialMenuItemModel) obj;
            final RadialMenuItemBinding radialMenuItemBinding = this.visibleView.get(i);
            TextView textView = radialMenuItemBinding.tvTitle;
            String title = radialMenuItemModel.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            Picasso.get().load(setImage(radialMenuItemModel.getIcon())).into(radialMenuItemBinding.ivIcon);
            LinearLayout root = radialMenuItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            itemClickListener(root, new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit dataItems$lambda$15$lambda$11;
                    dataItems$lambda$15$lambda$11 = RadialMenuScreen.setDataItems$lambda$15$lambda$11(RadialMenuItemBinding.this);
                    return dataItems$lambda$15$lambda$11;
                }
            }, new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit dataItems$lambda$15$lambda$14;
                    dataItems$lambda$15$lambda$14 = RadialMenuScreen.setDataItems$lambda$15$lambda$14(RadialMenuItemBinding.this, this, radialMenuItemModel);
                    return dataItems$lambda$15$lambda$14;
                }
            });
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDataItems$lambda$15$lambda$11(RadialMenuItemBinding radialMenuItemBinding) {
        radialMenuItemBinding.getRoot().setBackgroundResource(R.drawable.radial_menu_item_select_bg);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDataItems$lambda$15$lambda$14(RadialMenuItemBinding radialMenuItemBinding, RadialMenuScreen radialMenuScreen, RadialMenuItemModel radialMenuItemModel) {
        radialMenuItemBinding.getRoot().setBackgroundResource(R.drawable.radial_menu_item_bg);
        radialMenuScreen.isFirst = false;
        if (radialMenuItemModel.getActionModels() != null) {
            List<RadialMenuActionModel> actionModels = radialMenuItemModel.getActionModels();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(actionModels, 10));
            for (RadialMenuActionModel radialMenuActionModel : actionModels) {
                arrayList.add(radialMenuActionModel.toItemModel());
            }
            radialMenuScreen.actionList = arrayList;
            List<RadialMenuActionModel> actionModels2 = radialMenuItemModel.getActionModels();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(actionModels2, 10));
            for (RadialMenuActionModel radialMenuActionModel2 : actionModels2) {
                arrayList2.add(radialMenuActionModel2.toItemModel());
            }
            radialMenuScreen.setItems(arrayList2);
            radialMenuScreen.isShowBack();
        } else {
            radialMenuScreen.backendNotifier.clickedWrapper(radialMenuScreen.getBackendID(), radialMenuItemModel.getId(), RadialMenuId.SEND_ACTION_ID.getSubId());
        }
        return Unit.INSTANCE;
    }

    private final void itemClickListener(final ViewGroup viewGroup, final Function0<Unit> function0, final Function0<Unit> function02) {
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean itemClickListener$lambda$18;
                itemClickListener$lambda$18 = RadialMenuScreen.itemClickListener$lambda$18(viewGroup, function0, function02, view, motionEvent);
                return itemClickListener$lambda$18;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean itemClickListener$lambda$18(ViewGroup viewGroup, Function0 function0, Function0 function02, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            for (View view2 : ViewGroupKt.getChildren(viewGroup)) {
                if (view2 instanceof TextView) {
                    ((TextView) view2).setTextColor(darkColor);
                }
            }
            function0.invoke();
            return true;
        } else if (action != 1) {
            return false;
        } else {
            for (View view3 : ViewGroupKt.getChildren(viewGroup)) {
                if (view3 instanceof TextView) {
                    ((TextView) view3).setTextColor(whiteColor);
                }
            }
            function02.invoke();
            return true;
        }
    }

    private final void clearItems() {
        this.visibleView.clear();
        this.invisibleView.clear();
    }

    private final /* synthetic */ <T> List<T> setVisibleList(List<? extends T> list) {
        ArrayList arrayList = new ArrayList();
        int i = (this.page - 1) * 7;
        int min = Math.min(i + 7, list.size());
        while (i < min) {
            arrayList.add(list.get(i));
            i++;
        }
        return arrayList;
    }

    private final String setImage(String str) {
        if (this.isArizonaType) {
            return FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/radial_menu_update/" + str + ".webp";
        }
        return FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/radial_menu/" + str + ".webp";
    }

    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new RadialMenuScreen(targetActivity, i);
        }
    }

    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$Companion;", "", "<init>", "()V", "ONE_ITEM", "", "TWO_ITEM", "THREE_ITEM", "MAX_ITEM", "ACTIONS", "", "darkColor", "whiteColor", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuId;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "INITIALIZE", "SEND_ACTION_ID", "CLOSE", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RadialMenuId {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RadialMenuId[] $VALUES;
        private final int subId;
        public static final RadialMenuId INITIALIZE = new RadialMenuId("INITIALIZE", 0, 0);
        public static final RadialMenuId SEND_ACTION_ID = new RadialMenuId("SEND_ACTION_ID", 1, 0);
        public static final RadialMenuId CLOSE = new RadialMenuId("CLOSE", 2, 1);

        private static final /* synthetic */ RadialMenuId[] $values() {
            return new RadialMenuId[]{INITIALIZE, SEND_ACTION_ID, CLOSE};
        }

        public static EnumEntries<RadialMenuId> getEntries() {
            return $ENTRIES;
        }

        public static RadialMenuId valueOf(String str) {
            return (RadialMenuId) Enum.valueOf(RadialMenuId.class, str);
        }

        public static RadialMenuId[] values() {
            return (RadialMenuId[]) $VALUES.clone();
        }

        private RadialMenuId(String str, int i, int i2) {
            this.subId = i2;
        }

        public final int getSubId() {
            return this.subId;
        }

        static {
            RadialMenuId[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuModel;", "", "id", "", "title", "", "icon", "actionModels", "", "Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuActionModel;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getIcon", "getActionModels", "()Ljava/util/List;", "toItemModel", "Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuItemModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RadialMenuModel {
        @SerializedName(RadialMenuScreen.ACTIONS)
        private final List<RadialMenuActionModel> actionModels;
        @SerializedName("icon")
        private final String icon;
        @SerializedName("id")
        private final int id;
        @SerializedName("title")
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RadialMenuModel copy$default(RadialMenuModel radialMenuModel, int i, String str, String str2, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = radialMenuModel.id;
            }
            if ((i2 & 2) != 0) {
                str = radialMenuModel.title;
            }
            if ((i2 & 4) != 0) {
                str2 = radialMenuModel.icon;
            }
            if ((i2 & 8) != 0) {
                list = radialMenuModel.actionModels;
            }
            return radialMenuModel.copy(i, str, str2, list);
        }

        public final int component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.icon;
        }

        public final List<RadialMenuActionModel> component4() {
            return this.actionModels;
        }

        public final RadialMenuModel copy(int i, String title, String icon, List<RadialMenuActionModel> actionModels) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(actionModels, "actionModels");
            return new RadialMenuModel(i, title, icon, actionModels);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RadialMenuModel) {
                RadialMenuModel radialMenuModel = (RadialMenuModel) obj;
                return this.id == radialMenuModel.id && Intrinsics.areEqual(this.title, radialMenuModel.title) && Intrinsics.areEqual(this.icon, radialMenuModel.icon) && Intrinsics.areEqual(this.actionModels, radialMenuModel.actionModels);
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.actionModels.hashCode();
        }

        public String toString() {
            int i = this.id;
            String str = this.title;
            String str2 = this.icon;
            return "RadialMenuModel(id=" + i + ", title=" + str + ", icon=" + str2 + ", actionModels=" + this.actionModels + ")";
        }

        public RadialMenuModel(int i, String title, String icon, List<RadialMenuActionModel> actionModels) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(actionModels, "actionModels");
            this.id = i;
            this.title = title;
            this.icon = icon;
            this.actionModels = actionModels;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final List<RadialMenuActionModel> getActionModels() {
            return this.actionModels;
        }

        public final RadialMenuItemModel toItemModel() {
            return new RadialMenuItemModel(this.id, this.title, this.icon, this.actionModels);
        }
    }

    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuActionModel;", "", "id", "", "title", "", "icon", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getIcon", "toItemModel", "Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuItemModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RadialMenuActionModel {
        @SerializedName("icon")
        private final String icon;
        @SerializedName("id")
        private final int id;
        @SerializedName("title")
        private final String title;

        public static /* synthetic */ RadialMenuActionModel copy$default(RadialMenuActionModel radialMenuActionModel, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = radialMenuActionModel.id;
            }
            if ((i2 & 2) != 0) {
                str = radialMenuActionModel.title;
            }
            if ((i2 & 4) != 0) {
                str2 = radialMenuActionModel.icon;
            }
            return radialMenuActionModel.copy(i, str, str2);
        }

        public final int component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.icon;
        }

        public final RadialMenuActionModel copy(int i, String str, String icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            return new RadialMenuActionModel(i, str, icon);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RadialMenuActionModel) {
                RadialMenuActionModel radialMenuActionModel = (RadialMenuActionModel) obj;
                return this.id == radialMenuActionModel.id && Intrinsics.areEqual(this.title, radialMenuActionModel.title) && Intrinsics.areEqual(this.icon, radialMenuActionModel.icon);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.id) * 31;
            String str = this.title;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode();
        }

        public String toString() {
            int i = this.id;
            String str = this.title;
            return "RadialMenuActionModel(id=" + i + ", title=" + str + ", icon=" + this.icon + ")";
        }

        public RadialMenuActionModel(int i, String str, String icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.id = i;
            this.title = str;
            this.icon = icon;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final RadialMenuItemModel toItemModel() {
            return new RadialMenuItemModel(this.id, this.title, this.icon, null, 8, null);
        }
    }

    /* compiled from: RadialMenuScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuItemModel;", "", "id", "", "title", "", "icon", "actionModels", "", "Lru/mrlargha/commonui/elements/radial_menu/RadialMenuScreen$RadialMenuActionModel;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getIcon", "getActionModels", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RadialMenuItemModel {
        private final List<RadialMenuActionModel> actionModels;
        private final String icon;
        private final int id;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RadialMenuItemModel copy$default(RadialMenuItemModel radialMenuItemModel, int i, String str, String str2, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = radialMenuItemModel.id;
            }
            if ((i2 & 2) != 0) {
                str = radialMenuItemModel.title;
            }
            if ((i2 & 4) != 0) {
                str2 = radialMenuItemModel.icon;
            }
            if ((i2 & 8) != 0) {
                list = radialMenuItemModel.actionModels;
            }
            return radialMenuItemModel.copy(i, str, str2, list);
        }

        public final int component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.icon;
        }

        public final List<RadialMenuActionModel> component4() {
            return this.actionModels;
        }

        public final RadialMenuItemModel copy(int i, String str, String icon, List<RadialMenuActionModel> list) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            return new RadialMenuItemModel(i, str, icon, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RadialMenuItemModel) {
                RadialMenuItemModel radialMenuItemModel = (RadialMenuItemModel) obj;
                return this.id == radialMenuItemModel.id && Intrinsics.areEqual(this.title, radialMenuItemModel.title) && Intrinsics.areEqual(this.icon, radialMenuItemModel.icon) && Intrinsics.areEqual(this.actionModels, radialMenuItemModel.actionModels);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.id) * 31;
            String str = this.title;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode()) * 31;
            List<RadialMenuActionModel> list = this.actionModels;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            int i = this.id;
            String str = this.title;
            String str2 = this.icon;
            return "RadialMenuItemModel(id=" + i + ", title=" + str + ", icon=" + str2 + ", actionModels=" + this.actionModels + ")";
        }

        public RadialMenuItemModel(int i, String str, String icon, List<RadialMenuActionModel> list) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.id = i;
            this.title = str;
            this.icon = icon;
            this.actionModels = list;
        }

        public /* synthetic */ RadialMenuItemModel(int i, String str, String str2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, (i2 & 8) != 0 ? null : list);
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final List<RadialMenuActionModel> getActionModels() {
            return this.actionModels;
        }
    }
}

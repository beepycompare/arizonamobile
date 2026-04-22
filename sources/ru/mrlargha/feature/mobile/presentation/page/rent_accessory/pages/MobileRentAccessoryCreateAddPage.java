package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.inventory.presentation.UtilKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryAddBinding;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryElementItemBinding;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryCategoryIcon;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCreateAddModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryGetModelItem;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryLimitsModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryNavigateModel;
/* compiled from: MobileRentAccessoryCreateAddPage.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\"H\u0002J\u0012\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0018\u0010/\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002J\u001c\u00102\u001a\u00020\"*\u0002032\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\r\u0012\t\u0012\u00070\u0013¢\u0006\u0002\b\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage;", "", "parentContainer", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;)V", "bindingPage", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryAddBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentBar", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage$Companion$TopBar;", "currentLimits", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryLimitsModel;", "topBars", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage$Companion$TopBarModel;", "items", "", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryElementItemBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getItems", "()Ljava/util/List;", "chosenItems", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryGetModelItem;", "sumCost", "", "currentCategory", "isCostSuc", "", "isItemSuc", "isCategorySuc", NotificationCompat.CATEGORY_EVENT, "", "data", "", "eventType", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/MobileRentAccessoryEvent;", "show", "selectTopBar", "topBar", "initItems", "setCategoryItem", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "setDescListeners", "update", "setupListeners", "setLimits", "setLimit", "Landroid/widget/EditText;", "max", "min", "checkSuc", "hide", "Companion", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryCreateAddPage {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_DESC_LETTERS = 70;
    private final MobileRentAccessoryAddBinding bindingPage;
    private final List<MobileRentAccessoryGetModelItem> chosenItems;
    private Companion.TopBar currentBar;
    private int currentCategory;
    private MobileRentAccessoryLimitsModel currentLimits;
    private boolean isCategorySuc;
    private boolean isCostSuc;
    private boolean isItemSuc;
    private final List<MobileRentAccessoryElementItemBinding> items;
    private final RentAccessoryPage parentContainer;
    private final CoroutineScope scope;
    private int sumCost;
    private final Map<Companion.TopBar, Companion.TopBarModel> topBars;

    /* compiled from: MobileRentAccessoryCreateAddPage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Companion.TopBar.values().length];
            try {
                iArr[Companion.TopBar.SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.TopBar.ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MobileRentAccessoryEvent.values().length];
            try {
                iArr2[MobileRentAccessoryEvent.GET_CHOSEN_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.SET_LIMITS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.GET_CATEGORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.SET_TAB.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MobileRentAccessoryCreateAddPage(RentAccessoryPage parentContainer) {
        Intrinsics.checkNotNullParameter(parentContainer, "parentContainer");
        this.parentContainer = parentContainer;
        MobileRentAccessoryAddBinding createAdd = parentContainer.getBinding().createAdd;
        Intrinsics.checkNotNullExpressionValue(createAdd, "createAdd");
        this.bindingPage = createAdd;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.currentBar = Companion.TopBar.NONE;
        this.currentLimits = new MobileRentAccessoryLimitsModel(0, 0, 0, 0, 15, null);
        Companion.TopBar topBar = Companion.TopBar.SET;
        CustomCardView btnSet = createAdd.btnSet;
        Intrinsics.checkNotNullExpressionValue(btnSet, "btnSet");
        TextView tvSet = createAdd.tvSet;
        Intrinsics.checkNotNullExpressionValue(tvSet, "tvSet");
        Companion.TopBar topBar2 = Companion.TopBar.ITEM;
        CustomCardView btnItem = createAdd.btnItem;
        Intrinsics.checkNotNullExpressionValue(btnItem, "btnItem");
        TextView tvItem = createAdd.tvItem;
        Intrinsics.checkNotNullExpressionValue(tvItem, "tvItem");
        this.topBars = MapsKt.mutableMapOf(TuplesKt.to(topBar, new Companion.TopBarModel(btnSet, tvSet)), TuplesKt.to(topBar2, new Companion.TopBarModel(btnItem, tvItem)));
        this.items = CollectionsKt.listOf((Object[]) new MobileRentAccessoryElementItemBinding[]{createAdd.firstContainer, createAdd.secondContainer, createAdd.thirdContainer, createAdd.fourthContainer, createAdd.fifthContainer, createAdd.sixthContainer});
        this.chosenItems = new ArrayList();
        this.currentCategory = -1;
    }

    public final List<MobileRentAccessoryElementItemBinding> getItems() {
        return this.items;
    }

    public static /* synthetic */ void event$default(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, String str, MobileRentAccessoryEvent mobileRentAccessoryEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            mobileRentAccessoryEvent = MobileRentAccessoryEvent.NONE;
        }
        mobileRentAccessoryCreateAddPage.event(str, mobileRentAccessoryEvent);
    }

    public final void event(String str, MobileRentAccessoryEvent eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (str != null) {
            if (eventType == MobileRentAccessoryEvent.NONE || str.length() == 0) {
                show();
                return;
            } else {
                update(str, eventType);
                return;
            }
        }
        hide();
    }

    private final void show() {
        ScrollView root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        this.chosenItems.clear();
        MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        mobileRentAccessoryAddBinding.etDesc.setText("");
        mobileRentAccessoryAddBinding.etKCost.setText("");
        mobileRentAccessoryAddBinding.etKkCost.setText("");
        setupListeners();
        selectTopBar(this.currentBar);
        initItems();
        setCategoryItem(null);
        setDescListeners();
        setLimits();
        checkSuc();
    }

    private final void selectTopBar(Companion.TopBar topBar) {
        CustomCardView customCardView;
        TextView textView;
        CustomCardView customCardView2;
        TextView textView2;
        Companion.TopBar topBar2 = this.currentBar;
        if (topBar == topBar2) {
            return;
        }
        Companion.TopBarModel topBarModel = this.topBars.get(topBar2);
        if (topBarModel != null && (textView2 = topBarModel.getTextView()) != null) {
            textView2.setTextColor(Color.parseColor("#B2FFFFFF"));
        }
        Companion.TopBarModel topBarModel2 = this.topBars.get(this.currentBar);
        if (topBarModel2 != null && (customCardView2 = topBarModel2.getCustomCardView()) != null) {
            CustomCardView.setBackground$default(customCardView2, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
        }
        Companion.TopBarModel topBarModel3 = this.topBars.get(topBar);
        if (topBarModel3 != null && (textView = topBarModel3.getTextView()) != null) {
            textView.setTextColor(Color.parseColor("#E5000000"));
        }
        Companion.TopBarModel topBarModel4 = this.topBars.get(topBar);
        if (topBarModel4 != null && (customCardView = topBarModel4.getCustomCardView()) != null) {
            customCardView.setBackground(-1);
        }
        this.currentBar = topBar;
        MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        int i = WhenMappings.$EnumSwitchMapping$0[topBar.ordinal()];
        if (i == 1) {
            FrameLayout root = mobileRentAccessoryAddBinding.secondContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
            FrameLayout root2 = mobileRentAccessoryAddBinding.thirdContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            root2.setVisibility(0);
            LinearLayout secondPartContainer = mobileRentAccessoryAddBinding.secondPartContainer;
            Intrinsics.checkNotNullExpressionValue(secondPartContainer, "secondPartContainer");
            secondPartContainer.setVisibility(0);
            TextView tvItemOutOf = mobileRentAccessoryAddBinding.tvItemOutOf;
            Intrinsics.checkNotNullExpressionValue(tvItemOutOf, "tvItemOutOf");
            tvItemOutOf.setVisibility(0);
            this.parentContainer.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_SET_ITEM.getSubIds(), 0, "0");
            mobileRentAccessoryAddBinding.tvChooseItem.setText(this.parentContainer.getTargetActivity().getString(R.string.chose_items));
        } else if (i != 2) {
        } else {
            FrameLayout root3 = mobileRentAccessoryAddBinding.secondContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            root3.setVisibility(8);
            FrameLayout root4 = mobileRentAccessoryAddBinding.thirdContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
            root4.setVisibility(8);
            LinearLayout secondPartContainer2 = mobileRentAccessoryAddBinding.secondPartContainer;
            Intrinsics.checkNotNullExpressionValue(secondPartContainer2, "secondPartContainer");
            secondPartContainer2.setVisibility(8);
            TextView tvItemOutOf2 = mobileRentAccessoryAddBinding.tvItemOutOf;
            Intrinsics.checkNotNullExpressionValue(tvItemOutOf2, "tvItemOutOf");
            tvItemOutOf2.setVisibility(8);
            this.parentContainer.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_SET_ITEM.getSubIds(), 1, "1");
            mobileRentAccessoryAddBinding.tvChooseItem.setText(this.parentContainer.getTargetActivity().getString(R.string.chose_item));
        }
    }

    private final void initItems() {
        this.bindingPage.tvItemOutOf.setText(this.parentContainer.getTargetActivity().getString(R.string.out_of, new Object[]{Integer.valueOf(this.chosenItems.size()), Integer.valueOf(this.items.size())}));
        TextView tvItemOutOf = this.bindingPage.tvItemOutOf;
        Intrinsics.checkNotNullExpressionValue(tvItemOutOf, "tvItemOutOf");
        tvItemOutOf.setVisibility(this.currentBar == Companion.TopBar.SET ? 0 : 8);
        int i = 0;
        for (Object obj : this.items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding = (MobileRentAccessoryElementItemBinding) obj;
            MobileRentAccessoryGetModelItem mobileRentAccessoryGetModelItem = (MobileRentAccessoryGetModelItem) CollectionsKt.getOrNull(this.chosenItems, i);
            if (mobileRentAccessoryGetModelItem != null) {
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MobileRentAccessoryCreateAddPage$initItems$1$1$1(mobileRentAccessoryElementItemBinding, mobileRentAccessoryGetModelItem, null), 3, null);
                ImageView ivItem = mobileRentAccessoryElementItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
                ivItem.setVisibility(0);
                ImageView ivIcon = mobileRentAccessoryElementItemBinding.ivIcon;
                Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
                ivIcon.setVisibility(8);
                TextView tvCount = mobileRentAccessoryElementItemBinding.tvCount;
                Intrinsics.checkNotNullExpressionValue(tvCount, "tvCount");
                tvCount.setVisibility(mobileRentAccessoryGetModelItem.getEnchanted() > 0 ? 0 : 8);
                mobileRentAccessoryElementItemBinding.tvCount.setText("+" + mobileRentAccessoryGetModelItem.getEnchanted());
                CustomCardView btnDelete = mobileRentAccessoryElementItemBinding.btnDelete;
                Intrinsics.checkNotNullExpressionValue(btnDelete, "btnDelete");
                btnDelete.setVisibility(0);
                mobileRentAccessoryElementItemBinding.container.setBackground(mobileRentAccessoryGetModelItem.getColorId());
                ImageView ivEffectBackgroundTop = mobileRentAccessoryElementItemBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
                ImageView ivEffectBackground = mobileRentAccessoryElementItemBinding.ivEffectBackground;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
                ImageView ivEffectForeground = mobileRentAccessoryElementItemBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
                UtilKt.setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, Integer.valueOf(mobileRentAccessoryGetModelItem.getItemId()));
            } else {
                ImageView ivIcon2 = mobileRentAccessoryElementItemBinding.ivIcon;
                Intrinsics.checkNotNullExpressionValue(ivIcon2, "ivIcon");
                ivIcon2.setVisibility(0);
                ImageView ivItem2 = mobileRentAccessoryElementItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem2, "ivItem");
                ivItem2.setVisibility(8);
                mobileRentAccessoryElementItemBinding.ivIcon.setImageResource(R.drawable.mp_ic_plus);
                TextView tvCount2 = mobileRentAccessoryElementItemBinding.tvCount;
                Intrinsics.checkNotNullExpressionValue(tvCount2, "tvCount");
                tvCount2.setVisibility(8);
                CustomCardView btnDelete2 = mobileRentAccessoryElementItemBinding.btnDelete;
                Intrinsics.checkNotNullExpressionValue(btnDelete2, "btnDelete");
                btnDelete2.setVisibility(8);
                CustomCardView container = mobileRentAccessoryElementItemBinding.container;
                Intrinsics.checkNotNullExpressionValue(container, "container");
                CustomCardView.setBackground$default(container, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
                ImageView ivEffectBackgroundTop2 = mobileRentAccessoryElementItemBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop2, "ivEffectBackgroundTop");
                ImageView ivEffectBackground2 = mobileRentAccessoryElementItemBinding.ivEffectBackground;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackground2, "ivEffectBackground");
                ImageView ivEffectForeground2 = mobileRentAccessoryElementItemBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground2, "ivEffectForeground");
                UtilKt.setEffect(ivEffectBackgroundTop2, ivEffectBackground2, ivEffectForeground2, -1);
            }
            i = i2;
        }
        if (!this.chosenItems.isEmpty()) {
            this.isItemSuc = true;
        } else {
            this.isItemSuc = false;
        }
        checkSuc();
    }

    private final void setCategoryItem(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel) {
        Object obj;
        MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        if (mobileRentAccessoryCategoryModel != null) {
            this.isCategorySuc = true;
            this.currentCategory = mobileRentAccessoryCategoryModel.getId();
            ImageView ivCategoryIcon = mobileRentAccessoryAddBinding.ivCategoryIcon;
            Intrinsics.checkNotNullExpressionValue(ivCategoryIcon, "ivCategoryIcon");
            ivCategoryIcon.setVisibility(0);
            mobileRentAccessoryAddBinding.tvCategoryName.setText(mobileRentAccessoryCategoryModel.getName());
            Iterator<E> it = MobileRentAccessoryCategoryIcon.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MobileRentAccessoryCategoryIcon) obj).getId() == mobileRentAccessoryCategoryModel.getId()) {
                    break;
                }
            }
            MobileRentAccessoryCategoryIcon mobileRentAccessoryCategoryIcon = (MobileRentAccessoryCategoryIcon) obj;
            if (mobileRentAccessoryCategoryIcon != null) {
                mobileRentAccessoryAddBinding.ivCategoryIcon.setImageResource(mobileRentAccessoryCategoryIcon.getResId());
            }
            mobileRentAccessoryAddBinding.tvCategoryName.setTextColor(Color.parseColor(mobileRentAccessoryCategoryModel.getColor()));
            mobileRentAccessoryAddBinding.ivCategoryArrow.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
            mobileRentAccessoryAddBinding.ivCategoryIcon.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
            CustomCardView categoryContainer = mobileRentAccessoryAddBinding.categoryContainer;
            Intrinsics.checkNotNullExpressionValue(categoryContainer, "categoryContainer");
            CustomCardView.setBackground$default(categoryContainer, ColorUtils.setAlphaComponent(Color.parseColor(mobileRentAccessoryCategoryModel.getColorBG()), 50), 0, null, null, 12, null);
        } else {
            this.isCategorySuc = false;
            ImageView ivCategoryIcon2 = mobileRentAccessoryAddBinding.ivCategoryIcon;
            Intrinsics.checkNotNullExpressionValue(ivCategoryIcon2, "ivCategoryIcon");
            ivCategoryIcon2.setVisibility(8);
            mobileRentAccessoryAddBinding.tvCategoryName.setText("Категория сета");
            mobileRentAccessoryAddBinding.ivCategoryArrow.setImageTintList(ColorStateList.valueOf(Color.parseColor("#B2FFFFFF")));
            mobileRentAccessoryAddBinding.tvCategoryName.setTextColor(Color.parseColor("#B2FFFFFF"));
            CustomCardView categoryContainer2 = mobileRentAccessoryAddBinding.categoryContainer;
            Intrinsics.checkNotNullExpressionValue(categoryContainer2, "categoryContainer");
            CustomCardView.setBackground$default(categoryContainer2, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
        }
        checkSuc();
    }

    private final void setDescListeners() {
        final MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        mobileRentAccessoryAddBinding.etDesc.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$setDescListeners$1$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                RentAccessoryPage rentAccessoryPage;
                TextView textView = MobileRentAccessoryAddBinding.this.tvDescOutOf;
                rentAccessoryPage = this.parentContainer;
                textView.setText(rentAccessoryPage.getTargetActivity().getString(R.string.out_of, new Object[]{charSequence != null ? Integer.valueOf(charSequence.length()) : null, 70}));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                this.checkSuc();
            }
        });
        CustomEditText customEditText = mobileRentAccessoryAddBinding.etDesc;
        InputFilter[] filters = customEditText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        customEditText.setFilters((InputFilter[]) ArraysKt.plus((InputFilter.LengthFilter[]) filters, new InputFilter.LengthFilter(MAX_DESC_LETTERS)));
    }

    private final void update(String str, MobileRentAccessoryEvent mobileRentAccessoryEvent) {
        ArrayList arrayList;
        Companion.TopBar topBar;
        try {
            int i = WhenMappings.$EnumSwitchMapping$1[mobileRentAccessoryEvent.ordinal()];
            if (i == 1) {
                this.chosenItems.clear();
                List<MobileRentAccessoryGetModelItem> list = this.chosenItems;
                if (MapperKt.isJsonValid(str)) {
                    JsonArray asJsonArray = ((JsonElement) MapperKt.getGson().fromJson(str, (Class<Object>) JsonElement.class)).getAsJsonArray();
                    Intrinsics.checkNotNull(asJsonArray);
                    JsonArray<JsonElement> jsonArray = asJsonArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                    for (JsonElement jsonElement : jsonArray) {
                        arrayList2.add(MapperKt.getGson().fromJson(jsonElement, (Class<Object>) MobileRentAccessoryGetModelItem.class));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = CollectionsKt.emptyList();
                }
                list.addAll(arrayList);
                initItems();
            } else if (i == 2) {
                if (MapperKt.isJsonValid(str)) {
                    this.currentLimits = (MobileRentAccessoryLimitsModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryLimitsModel.class);
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (i == 3) {
                if (MapperKt.isJsonValid(str)) {
                    ScrollView root = this.bindingPage.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                    root.setVisibility(0);
                    setCategoryItem((MobileRentAccessoryCategoryModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryCategoryModel.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (i == 4) {
                if (MapperKt.isJsonValid(str)) {
                    if (((MobileRentAccessoryNavigateModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryNavigateModel.class)).getTab() == 0) {
                        topBar = Companion.TopBar.SET;
                    } else {
                        topBar = Companion.TopBar.ITEM;
                    }
                    selectTopBar(topBar);
                    return;
                }
                throw new JsonParseException("Json is not valid");
            }
        } catch (Exception unused) {
        }
    }

    private final void setupListeners() {
        final MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        mobileRentAccessoryAddBinding.btnItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$0(MobileRentAccessoryCreateAddPage.this, view);
            }
        });
        mobileRentAccessoryAddBinding.btnSet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$1(MobileRentAccessoryCreateAddPage.this, view);
            }
        });
        mobileRentAccessoryAddBinding.btnCreateAdd.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$2(MobileRentAccessoryCreateAddPage.this, mobileRentAccessoryAddBinding, view);
            }
        });
        final int i = 0;
        for (Object obj : this.items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding = (MobileRentAccessoryElementItemBinding) obj;
            mobileRentAccessoryElementItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$3$0(MobileRentAccessoryCreateAddPage.this, i, view);
                }
            });
            mobileRentAccessoryElementItemBinding.btnDelete.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$3$1(MobileRentAccessoryCreateAddPage.this, i, view);
                }
            });
            i = i2;
        }
        mobileRentAccessoryAddBinding.categoryContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryCreateAddPage.setupListeners$lambda$0$4(MobileRentAccessoryCreateAddPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, View view) {
        mobileRentAccessoryCreateAddPage.selectTopBar(Companion.TopBar.ITEM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, View view) {
        mobileRentAccessoryCreateAddPage.selectTopBar(Companion.TopBar.SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding, View view) {
        MobileRentAccessoryCreateAddModel mobileRentAccessoryCreateAddModel = new MobileRentAccessoryCreateAddModel(String.valueOf(mobileRentAccessoryCreateAddPage.sumCost), mobileRentAccessoryCreateAddPage.currentCategory, String.valueOf(mobileRentAccessoryAddBinding.etDesc.getText()));
        Log.e("TAG", "setupListeners: " + mobileRentAccessoryCreateAddModel);
        mobileRentAccessoryCreateAddPage.parentContainer.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_CREATE_ADD.getSubIds(), 0, StringKt.toStringJson(mobileRentAccessoryCreateAddModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3$0(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, int i, View view) {
        if (CollectionsKt.getOrNull(mobileRentAccessoryCreateAddPage.chosenItems, i) == null) {
            mobileRentAccessoryCreateAddPage.parentContainer.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_ADD_ITEM.getSubIds(), 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3$1(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, int i, View view) {
        mobileRentAccessoryCreateAddPage.parentContainer.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_DELETE_ITEM.getSubIds(), mobileRentAccessoryCreateAddPage.chosenItems.get(i).getItemId(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, View view) {
        mobileRentAccessoryCreateAddPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.CATEGORIES);
        mobileRentAccessoryCreateAddPage.parentContainer.setAfterCategoryPage(RentAccessoryPage.Companion.RentAccessoryPages.CREATE_ADD);
    }

    private final void setLimits() {
        MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding = this.bindingPage;
        CustomEditText customEditText = mobileRentAccessoryAddBinding.etDesc;
        InputFilter[] filters = customEditText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        customEditText.setFilters((InputFilter[]) ArraysKt.plus((InputFilter.LengthFilter[]) filters, new InputFilter.LengthFilter(this.currentLimits.getMaxDesc())));
        EditText etKCost = mobileRentAccessoryAddBinding.etKCost;
        Intrinsics.checkNotNullExpressionValue(etKCost, "etKCost");
        setLimit(etKCost, this.currentLimits.getMaxCost(), this.currentLimits.getMinCost());
        EditText etKkCost = mobileRentAccessoryAddBinding.etKkCost;
        Intrinsics.checkNotNullExpressionValue(etKkCost, "etKkCost");
        setLimit(etKkCost, this.currentLimits.getMaxCost(), this.currentLimits.getMinCost());
    }

    private final void setLimit(final EditText editText, final int i, final int i2) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return MobileRentAccessoryCreateAddPage.setLimit$lambda$0(MobileRentAccessoryCreateAddPage.this, i2, editText, i, textView, i3, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setLimit$lambda$0(MobileRentAccessoryCreateAddPage mobileRentAccessoryCreateAddPage, int i, EditText editText, int i2, TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 == 6) {
            Integer intOrNull = StringsKt.toIntOrNull(mobileRentAccessoryCreateAddPage.bindingPage.etKkCost.getText().toString());
            Integer intOrNull2 = StringsKt.toIntOrNull(mobileRentAccessoryCreateAddPage.bindingPage.etKCost.getText().toString());
            mobileRentAccessoryCreateAddPage.sumCost = 0;
            if (intOrNull != null) {
                mobileRentAccessoryCreateAddPage.sumCost += intOrNull.intValue() * 1000000;
            }
            if (intOrNull2 != null) {
                mobileRentAccessoryCreateAddPage.sumCost += intOrNull2.intValue();
            }
            int i4 = mobileRentAccessoryCreateAddPage.sumCost;
            if (i4 < i) {
                Toast.makeText(editText.getContext(), "Стоимость должна быть больше " + i, 0).show();
                mobileRentAccessoryCreateAddPage.isCostSuc = false;
            } else if (i4 > i2) {
                Toast.makeText(editText.getContext(), "Стоимость должна быть меньше " + i2, 0).show();
                mobileRentAccessoryCreateAddPage.isCostSuc = false;
            } else {
                mobileRentAccessoryCreateAddPage.isCostSuc = true;
            }
            textView.clearFocus();
            Object systemService = textView.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            mobileRentAccessoryCreateAddPage.checkSuc();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSuc() {
        Editable text;
        if (this.isCostSuc && (text = this.bindingPage.etDesc.getText()) != null && text.length() > 0 && this.isItemSuc && this.isCategorySuc) {
            this.bindingPage.btnCreateAdd.setEnabled(true);
            this.bindingPage.btnCreateAdd.setAlpha(1.0f);
            return;
        }
        this.bindingPage.btnCreateAdd.setEnabled(false);
        this.bindingPage.btnCreateAdd.setAlpha(0.7f);
    }

    private final void hide() {
        ScrollView root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    /* compiled from: MobileRentAccessoryCreateAddPage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage$Companion;", "", "<init>", "()V", "MAX_DESC_LETTERS", "", "TopBar", "TopBarModel", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: MobileRentAccessoryCreateAddPage.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage$Companion$TopBar;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM", "SET", "NONE", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class TopBar {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ TopBar[] $VALUES;
            public static final TopBar ITEM = new TopBar("ITEM", 0);
            public static final TopBar SET = new TopBar("SET", 1);
            public static final TopBar NONE = new TopBar("NONE", 2);

            private static final /* synthetic */ TopBar[] $values() {
                return new TopBar[]{ITEM, SET, NONE};
            }

            public static EnumEntries<TopBar> getEntries() {
                return $ENTRIES;
            }

            public static TopBar valueOf(String str) {
                return (TopBar) Enum.valueOf(TopBar.class, str);
            }

            public static TopBar[] values() {
                return (TopBar[]) $VALUES.clone();
            }

            private TopBar(String str, int i) {
            }

            static {
                TopBar[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MobileRentAccessoryCreateAddPage.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage$Companion$TopBarModel;", "", "customCardView", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "textView", "Landroid/widget/TextView;", "<init>", "(Lru/mrlargha/commonui/utils/ui/CustomCardView;Landroid/widget/TextView;)V", "getCustomCardView", "()Lru/mrlargha/commonui/utils/ui/CustomCardView;", "getTextView", "()Landroid/widget/TextView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class TopBarModel {
            private final CustomCardView customCardView;
            private final TextView textView;

            public static /* synthetic */ TopBarModel copy$default(TopBarModel topBarModel, CustomCardView customCardView, TextView textView, int i, Object obj) {
                if ((i & 1) != 0) {
                    customCardView = topBarModel.customCardView;
                }
                if ((i & 2) != 0) {
                    textView = topBarModel.textView;
                }
                return topBarModel.copy(customCardView, textView);
            }

            public final CustomCardView component1() {
                return this.customCardView;
            }

            public final TextView component2() {
                return this.textView;
            }

            public final TopBarModel copy(CustomCardView customCardView, TextView textView) {
                Intrinsics.checkNotNullParameter(customCardView, "customCardView");
                Intrinsics.checkNotNullParameter(textView, "textView");
                return new TopBarModel(customCardView, textView);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TopBarModel) {
                    TopBarModel topBarModel = (TopBarModel) obj;
                    return Intrinsics.areEqual(this.customCardView, topBarModel.customCardView) && Intrinsics.areEqual(this.textView, topBarModel.textView);
                }
                return false;
            }

            public int hashCode() {
                return (this.customCardView.hashCode() * 31) + this.textView.hashCode();
            }

            public String toString() {
                CustomCardView customCardView = this.customCardView;
                return "TopBarModel(customCardView=" + customCardView + ", textView=" + this.textView + ")";
            }

            public TopBarModel(CustomCardView customCardView, TextView textView) {
                Intrinsics.checkNotNullParameter(customCardView, "customCardView");
                Intrinsics.checkNotNullParameter(textView, "textView");
                this.customCardView = customCardView;
                this.textView = textView;
            }

            public final CustomCardView getCustomCardView() {
                return this.customCardView;
            }

            public final TextView getTextView() {
                return this.textView;
            }
        }
    }
}

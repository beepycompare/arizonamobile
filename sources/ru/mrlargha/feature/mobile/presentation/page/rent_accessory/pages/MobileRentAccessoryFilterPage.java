package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryFilterBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryCategoryIcon;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryFilterModel;
/* compiled from: MobileRentAccessoryFilterPage.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u001c\u0010\u0016\u001a\u00020\u000b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryFilterPage;", "", "parentContainer", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;)V", "bindingPage", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryFilterBinding;", "currentFilter", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterModel;", NotificationCompat.CATEGORY_EVENT, "", "data", "", "eventType", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/MobileRentAccessoryEvent;", "show", "update", "setupListeners", "setSearchListeners", "setSortListeners", "setFilterListeners", "setCheckBox", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "imageView", "Landroid/widget/ImageView;", "isSelect", "", "setCategoryItem", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "setBizId", "hide", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryFilterPage {
    private final MobileRentAccessoryFilterBinding bindingPage;
    private MobileRentAccessoryFilterModel currentFilter;
    private final RentAccessoryPage parentContainer;

    /* compiled from: MobileRentAccessoryFilterPage.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MobileRentAccessoryEvent.values().length];
            try {
                iArr[MobileRentAccessoryEvent.GET_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MobileRentAccessoryEvent.GET_CATEGORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(View view) {
    }

    public MobileRentAccessoryFilterPage(RentAccessoryPage parentContainer) {
        Intrinsics.checkNotNullParameter(parentContainer, "parentContainer");
        this.parentContainer = parentContainer;
        MobileRentAccessoryFilterBinding filter = parentContainer.getBinding().filter;
        Intrinsics.checkNotNullExpressionValue(filter, "filter");
        this.bindingPage = filter;
        this.currentFilter = new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null);
    }

    public static /* synthetic */ void event$default(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, String str, MobileRentAccessoryEvent mobileRentAccessoryEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            mobileRentAccessoryEvent = MobileRentAccessoryEvent.NONE;
        }
        mobileRentAccessoryFilterPage.event(str, mobileRentAccessoryEvent);
    }

    public final void event(String str, MobileRentAccessoryEvent eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (str != null) {
            if (eventType == MobileRentAccessoryEvent.NONE) {
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
        FrameLayout root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
    }

    private final void update(String str, MobileRentAccessoryEvent mobileRentAccessoryEvent) {
        int i = WhenMappings.$EnumSwitchMapping$0[mobileRentAccessoryEvent.ordinal()];
        if (i == 1) {
            if (MapperKt.isJsonValid(str)) {
                this.currentFilter = (MobileRentAccessoryFilterModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryFilterModel.class);
                setupListeners();
                return;
            }
            throw new JsonParseException("Json is not valid");
        } else if (i != 2) {
        } else {
            if (MapperKt.isJsonValid(str)) {
                this.currentFilter.setCategoryId(((MobileRentAccessoryCategoryModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryCategoryModel.class)).getId());
                if (MapperKt.isJsonValid(str)) {
                    setCategoryItem((MobileRentAccessoryCategoryModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryCategoryModel.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            }
            throw new JsonParseException("Json is not valid");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupListeners() {
        MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        CustomCardView btnClearFilter = mobileRentAccessoryFilterBinding.btnClearFilter;
        Intrinsics.checkNotNullExpressionValue(btnClearFilter, "btnClearFilter");
        btnClearFilter.setVisibility(!Intrinsics.areEqual(this.currentFilter, new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null)) ? 0 : 8);
        setSearchListeners();
        setSortListeners();
        setFilterListeners();
        List<MobileRentAccessoryCategoryModel> rentCategories = this.parentContainer.getRentCategories();
        MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel = null;
        if (rentCategories != null) {
            Iterator<T> it = rentCategories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MobileRentAccessoryCategoryModel) next).getId() == this.currentFilter.getCategoryId()) {
                    mobileRentAccessoryCategoryModel = next;
                    break;
                }
            }
            mobileRentAccessoryCategoryModel = mobileRentAccessoryCategoryModel;
        }
        setCategoryItem(mobileRentAccessoryCategoryModel);
        setBizId();
        mobileRentAccessoryFilterBinding.filterContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$1(view);
            }
        });
        mobileRentAccessoryFilterBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$2(MobileRentAccessoryFilterPage.this, view);
            }
        });
        mobileRentAccessoryFilterBinding.categoryContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$3(MobileRentAccessoryFilterPage.this, view);
            }
        });
        mobileRentAccessoryFilterBinding.btnFind.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$4(MobileRentAccessoryFilterPage.this, view);
            }
        });
        mobileRentAccessoryFilterBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$5(MobileRentAccessoryFilterPage.this, view);
            }
        });
        mobileRentAccessoryFilterBinding.btnClearFilter.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setupListeners$lambda$0$6(MobileRentAccessoryFilterPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, View view) {
        mobileRentAccessoryFilterPage.currentFilter = new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null);
        mobileRentAccessoryFilterPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, View view) {
        mobileRentAccessoryFilterPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.CATEGORIES);
        mobileRentAccessoryFilterPage.parentContainer.setAfterCategoryPage(RentAccessoryPage.Companion.RentAccessoryPages.FILTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, View view) {
        mobileRentAccessoryFilterPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.MAIN);
        mobileRentAccessoryFilterPage.parentContainer.getMainPage().event(StringKt.toStringJson(mobileRentAccessoryFilterPage.currentFilter), MobileRentAccessoryEvent.GET_FILTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$5(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, View view) {
        mobileRentAccessoryFilterPage.currentFilter = new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null);
        mobileRentAccessoryFilterPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$6(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, View view) {
        mobileRentAccessoryFilterPage.currentFilter = new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null);
        mobileRentAccessoryFilterPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.MAIN);
        mobileRentAccessoryFilterPage.parentContainer.getMainPage().event(StringKt.toStringJson(mobileRentAccessoryFilterPage.currentFilter), MobileRentAccessoryEvent.GET_FILTER);
    }

    private final void setSearchListeners() {
        String str;
        Object name;
        MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        EditText editText = mobileRentAccessoryFilterBinding.etSearchByNumber;
        Integer number = this.currentFilter.getNumber();
        MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = this.currentFilter;
        if (number != null) {
            name = mobileRentAccessoryFilterModel.getNumber();
        } else if (mobileRentAccessoryFilterModel.getName() == null) {
            str = "";
            editText.setText(str);
            mobileRentAccessoryFilterBinding.etSearchByNumber.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$setSearchListeners$1$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel2;
                    MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel3;
                    MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel4;
                    MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel5;
                    String valueOf = String.valueOf(charSequence);
                    Integer intOrNull = StringsKt.toIntOrNull(valueOf);
                    MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage = MobileRentAccessoryFilterPage.this;
                    if (intOrNull == null) {
                        mobileRentAccessoryFilterModel2 = mobileRentAccessoryFilterPage.currentFilter;
                        String str2 = valueOf;
                        if (str2.length() == 0) {
                            str2 = null;
                        }
                        mobileRentAccessoryFilterModel2.setName(str2);
                        mobileRentAccessoryFilterModel3 = mobileRentAccessoryFilterPage.currentFilter;
                        mobileRentAccessoryFilterModel3.setNumber(null);
                        return;
                    }
                    int intValue = intOrNull.intValue();
                    mobileRentAccessoryFilterModel4 = mobileRentAccessoryFilterPage.currentFilter;
                    mobileRentAccessoryFilterModel4.setNumber(Integer.valueOf(intValue));
                    mobileRentAccessoryFilterModel5 = mobileRentAccessoryFilterPage.currentFilter;
                    mobileRentAccessoryFilterModel5.setName(null);
                }
            });
        } else {
            name = this.currentFilter.getName();
        }
        str = String.valueOf(name);
        editText.setText(str);
        mobileRentAccessoryFilterBinding.etSearchByNumber.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$setSearchListeners$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel2;
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel3;
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel4;
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel5;
                String valueOf = String.valueOf(charSequence);
                Integer intOrNull = StringsKt.toIntOrNull(valueOf);
                MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage = MobileRentAccessoryFilterPage.this;
                if (intOrNull == null) {
                    mobileRentAccessoryFilterModel2 = mobileRentAccessoryFilterPage.currentFilter;
                    String str2 = valueOf;
                    if (str2.length() == 0) {
                        str2 = null;
                    }
                    mobileRentAccessoryFilterModel2.setName(str2);
                    mobileRentAccessoryFilterModel3 = mobileRentAccessoryFilterPage.currentFilter;
                    mobileRentAccessoryFilterModel3.setNumber(null);
                    return;
                }
                int intValue = intOrNull.intValue();
                mobileRentAccessoryFilterModel4 = mobileRentAccessoryFilterPage.currentFilter;
                mobileRentAccessoryFilterModel4.setNumber(Integer.valueOf(intValue));
                mobileRentAccessoryFilterModel5 = mobileRentAccessoryFilterPage.currentFilter;
                mobileRentAccessoryFilterModel5.setName(null);
            }
        });
    }

    private final void setSortListeners() {
        final MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        mobileRentAccessoryFilterBinding.ivCost.setScaleY(this.currentFilter.isSortByPrice() ? -1.0f : 1.0f);
        mobileRentAccessoryFilterBinding.ivRating.setScaleY(this.currentFilter.isSortByRating() ? -1.0f : 1.0f);
        mobileRentAccessoryFilterBinding.btnCost.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setSortListeners$lambda$0$0(MobileRentAccessoryFilterPage.this, mobileRentAccessoryFilterBinding, view);
            }
        });
        mobileRentAccessoryFilterBinding.btnRating.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setSortListeners$lambda$0$1(MobileRentAccessoryFilterPage.this, mobileRentAccessoryFilterBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSortListeners$lambda$0$0(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding, View view) {
        MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = mobileRentAccessoryFilterPage.currentFilter;
        mobileRentAccessoryFilterModel.setSortByPrice(!mobileRentAccessoryFilterModel.isSortByPrice());
        if (mobileRentAccessoryFilterPage.currentFilter.isSortByPrice()) {
            mobileRentAccessoryFilterPage.currentFilter.setSortByRating(false);
        }
        mobileRentAccessoryFilterBinding.ivCost.setScaleY(mobileRentAccessoryFilterPage.currentFilter.isSortByPrice() ? -1.0f : 1.0f);
        mobileRentAccessoryFilterBinding.ivRating.setScaleY(mobileRentAccessoryFilterPage.currentFilter.isSortByRating() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSortListeners$lambda$0$1(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding, View view) {
        MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = mobileRentAccessoryFilterPage.currentFilter;
        mobileRentAccessoryFilterModel.setSortByRating(!mobileRentAccessoryFilterModel.isSortByRating());
        if (mobileRentAccessoryFilterPage.currentFilter.isSortByRating()) {
            mobileRentAccessoryFilterPage.currentFilter.setSortByPrice(false);
        }
        mobileRentAccessoryFilterBinding.ivCost.setScaleY(mobileRentAccessoryFilterPage.currentFilter.isSortByPrice() ? -1.0f : 1.0f);
        mobileRentAccessoryFilterBinding.ivRating.setScaleY(mobileRentAccessoryFilterPage.currentFilter.isSortByRating() ? -1.0f : 1.0f);
    }

    private final void setFilterListeners() {
        final MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        mobileRentAccessoryFilterBinding.onlySetFilter.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setFilterListeners$lambda$0$0(MobileRentAccessoryFilterPage.this, mobileRentAccessoryFilterBinding, view);
            }
        });
        mobileRentAccessoryFilterBinding.onlySharpingTenPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryFilterPage.setFilterListeners$lambda$0$1(MobileRentAccessoryFilterPage.this, mobileRentAccessoryFilterBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFilterListeners$lambda$0$0(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding, View view) {
        MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = mobileRentAccessoryFilterPage.currentFilter;
        mobileRentAccessoryFilterModel.setOnlySet(!mobileRentAccessoryFilterModel.getOnlySet());
        CustomCardView onlySetFilter = mobileRentAccessoryFilterBinding.onlySetFilter;
        Intrinsics.checkNotNullExpressionValue(onlySetFilter, "onlySetFilter");
        ImageView ivOnlySetFilter = mobileRentAccessoryFilterBinding.ivOnlySetFilter;
        Intrinsics.checkNotNullExpressionValue(ivOnlySetFilter, "ivOnlySetFilter");
        mobileRentAccessoryFilterPage.setCheckBox(onlySetFilter, ivOnlySetFilter, mobileRentAccessoryFilterPage.currentFilter.getOnlySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFilterListeners$lambda$0$1(MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage, MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding, View view) {
        MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = mobileRentAccessoryFilterPage.currentFilter;
        mobileRentAccessoryFilterModel.setOnlySharpingTenPlus(!mobileRentAccessoryFilterModel.getOnlySharpingTenPlus());
        CustomCardView onlySharpingTenPlus = mobileRentAccessoryFilterBinding.onlySharpingTenPlus;
        Intrinsics.checkNotNullExpressionValue(onlySharpingTenPlus, "onlySharpingTenPlus");
        ImageView ivOnlySharpingTenPlus = mobileRentAccessoryFilterBinding.ivOnlySharpingTenPlus;
        Intrinsics.checkNotNullExpressionValue(ivOnlySharpingTenPlus, "ivOnlySharpingTenPlus");
        mobileRentAccessoryFilterPage.setCheckBox(onlySharpingTenPlus, ivOnlySharpingTenPlus, mobileRentAccessoryFilterPage.currentFilter.getOnlySharpingTenPlus());
    }

    private final void setCheckBox(CustomCardView customCardView, ImageView imageView, boolean z) {
        if (z) {
            imageView.setVisibility(0);
            customCardView.setBackground(-1);
            return;
        }
        imageView.setVisibility(8);
        customCardView.setBackground(Color.parseColor("#1AFFFFFF"));
    }

    private final void setCategoryItem(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel) {
        Object obj;
        MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        if (mobileRentAccessoryCategoryModel != null) {
            ImageView ivCategoryIcon = mobileRentAccessoryFilterBinding.ivCategoryIcon;
            Intrinsics.checkNotNullExpressionValue(ivCategoryIcon, "ivCategoryIcon");
            ivCategoryIcon.setVisibility(0);
            mobileRentAccessoryFilterBinding.tvCategoryName.setText(mobileRentAccessoryCategoryModel.getName());
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
                mobileRentAccessoryFilterBinding.ivCategoryIcon.setImageResource(mobileRentAccessoryCategoryIcon.getResId());
            }
            mobileRentAccessoryFilterBinding.tvCategoryName.setTextColor(Color.parseColor(mobileRentAccessoryCategoryModel.getColor()));
            mobileRentAccessoryFilterBinding.ivCategoryArrow.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
            mobileRentAccessoryFilterBinding.ivCategoryIcon.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
            CustomCardView categoryContainer = mobileRentAccessoryFilterBinding.categoryContainer;
            Intrinsics.checkNotNullExpressionValue(categoryContainer, "categoryContainer");
            CustomCardView.setBackground$default(categoryContainer, ColorUtils.setAlphaComponent(Color.parseColor(mobileRentAccessoryCategoryModel.getColorBG()), 50), 0, null, null, 12, null);
            return;
        }
        ImageView ivCategoryIcon2 = mobileRentAccessoryFilterBinding.ivCategoryIcon;
        Intrinsics.checkNotNullExpressionValue(ivCategoryIcon2, "ivCategoryIcon");
        ivCategoryIcon2.setVisibility(8);
        mobileRentAccessoryFilterBinding.tvCategoryName.setText("Категория сета");
        mobileRentAccessoryFilterBinding.ivCategoryArrow.setImageTintList(ColorStateList.valueOf(Color.parseColor("#B2FFFFFF")));
        mobileRentAccessoryFilterBinding.tvCategoryName.setTextColor(Color.parseColor("#B2FFFFFF"));
        CustomCardView categoryContainer2 = mobileRentAccessoryFilterBinding.categoryContainer;
        Intrinsics.checkNotNullExpressionValue(categoryContainer2, "categoryContainer");
        CustomCardView.setBackground$default(categoryContainer2, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
    }

    private final void setBizId() {
        MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding = this.bindingPage;
        mobileRentAccessoryFilterBinding.etBizId.setText(this.currentFilter.getBizId() > 0 ? String.valueOf(this.currentFilter.getBizId()) : "");
        mobileRentAccessoryFilterBinding.etBizId.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage$setBizId$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel;
                MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel2;
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(charSequence));
                MobileRentAccessoryFilterPage mobileRentAccessoryFilterPage = MobileRentAccessoryFilterPage.this;
                if (intOrNull == null) {
                    mobileRentAccessoryFilterModel = mobileRentAccessoryFilterPage.currentFilter;
                    mobileRentAccessoryFilterModel.setBizId(-1);
                    return;
                }
                int intValue = intOrNull.intValue();
                mobileRentAccessoryFilterModel2 = mobileRentAccessoryFilterPage.currentFilter;
                mobileRentAccessoryFilterModel2.setBizId(intValue);
            }
        });
    }

    private final void hide() {
        FrameLayout root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }
}
